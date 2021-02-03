package com.navitsa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.Reports.EmissionPetrolResultBean;
import com.navitsa.Reports.TestResultBean;
import com.navitsa.Reports.TestResultSpeedoBean;
import com.navitsa.entity.EmissionDieselCertificateData;
import com.navitsa.entity.EmissionDieselCertificateReadings;
import com.navitsa.entity.EmissionPetrolCertificateData;
import com.navitsa.entity.ParameterCodes;
import com.navitsa.entity.TestParameter;
import com.navitsa.entity.TestParameterAngle;
import com.navitsa.entity.TestParameterCategory;
import com.navitsa.entity.TestPoint;
import com.navitsa.entity.TestProfile;
import com.navitsa.entity.TestProfileStatus;
import com.navitsa.entity.Test_type;
import com.navitsa.entity.VehicleOwner;
import com.navitsa.entity.VehicleRegistration;
import com.navitsa.entity.VisualChecklistDetail;
import com.navitsa.entity.VisualChecklistMaster;
import com.navitsa.services.CenterService;
import com.navitsa.services.TestProfileService;
import com.navitsa.services.TestReportConfigService;
import com.navitsa.services.TestTypeService;
import com.navitsa.services.TestValueFileService;
import com.navitsa.services.VehicleService;
import com.navitsa.services.VisualInspectionServices;
import com.navitsa.utils.ReportViewe;

@Controller
public class TestingReportConfigController {

	@Autowired
	private CenterService centerService;

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private TestTypeService testTypeService;
	
	@Autowired
	private TestReportConfigService service;
	
	@Autowired
	private VisualInspectionServices inspectionServices;
	
	@Autowired
	private TestValueFileService testValueFileServices;
	
	@Autowired
	private TestProfileService testProfileService;
		
	 @ModelAttribute("testTypes")
	 public List<Test_type> getAllTestTypes(){
		 
		 List<Test_type> ls = testTypeService.listAll();
		 return ls;
	 }

	@RequestMapping(value="/getParameterData", method=RequestMethod.GET)
	public @ResponseBody List<TestParameter> getAllParameter() {
		List<TestParameter> rs = service.listAll();
		return rs;
	}
	
	@RequestMapping(value="/get_para_by_test_type_id", method=RequestMethod.GET)
	public @ResponseBody List<TestParameter> get_para_by_test_type_id(@RequestParam String typeID) {
		List<TestParameter> rs = service.get_para_by_test_type_id(typeID);
		return rs;
	}
	
	@RequestMapping("/testProfile")
	public String loadTestProfileForm(Model m) {
		
		m.addAttribute("testProfileForm", new TestProfile());
		return "testProfile";
	}
	
	//@RequestParam("roleID") String[] roleID
	
	 @RequestMapping(value="/saveTestProfile" ,method=RequestMethod.POST)
	 public String saveTestProfile(@Valid @ModelAttribute("testProfileForm") TestProfile tp,
			 BindingResult br,RedirectAttributes redirectAttributes) {
		 
		 if(br.hasErrors())  
	        {  
			 return "testProfile";  
	        }  
	        else  
	        {
	        	try {
	        			if(tp.getTestProfileID()!=0) {
	        				service.saveTestProfile(tp);
	        			}
	        			else {
	    		        	String pid = service.maxTestProfileID();
	    		        	tp.setTestProfileID(Integer.valueOf(pid));
	    		        	service.saveTestProfile(tp);
	        			}
		        	
		        	redirectAttributes.addFlashAttribute("success", 1);
			        return "redirect:/testProfile";
				} catch (Exception e) {
					redirectAttributes.addFlashAttribute("success", 0);
				}
	        }
		 
		 return "testProfile";
	 }
	 
	 // Edit Test Profile Details
	 @RequestMapping("/updateTestProfile")
	 public ModelAndView updateTestProfile(@RequestParam int proId) {
	     ModelAndView mav = new ModelAndView("testProfile");
	     try {
		     mav.addObject("testProfileForm",service.getTestProfileInfo(proId));
	     }catch (Exception e) {
			System.out.println(e);
		}
	  
	     return mav;
	 }
	 
	 
	@RequestMapping("/getTestCertificate")
	public String loadTestReportPage() {
		
		return "testCertificate";
	}
	
	
	@GetMapping("/getTestReport")
	 public ModelAndView getTestReport(@RequestParam String register_id,@RequestParam String test_value_file_id,
			 @RequestParam int color,HttpServletResponse response)
	 {
		 ModelAndView mav = new ModelAndView("comPdfReportView");
		 
		 String cat_id =  vehicleService.getCategoryID(register_id);
		 int test_pro_id = centerService.getProfileID(cat_id);
		 
		 VehicleRegistration vr = vehicleService.getRegistraionInfo(register_id);
		 String vehicle_cat_id = vr.getVid().getVmodel().getVehicleClass().getCategoryID().getCategoryID();
		 
		 String name,address,mobileNo;
		 if(!vr.getCusid().getId().equals("0000"))
		 {
			//This is a customer
			 name		= vr.getCusid().getName();
			 address	= vr.getCusid().getStateid().getState()+", "+vr.getCusid().getCity()+", "+vr.getCusid().getAddress();
			 mobileNo	= vr.getCusid().getTpno(); 
		 }
		 else
		 {
			 //this is a owner			 
			 VehicleOwner vo =  vehicleService.getVehicleOwnerIDByVehicleID(vr.getVid().getVehicleID());
			 name 		= vo.getOwnerName();
			 address	= vo.getAdd01()+", "+ vo.getStateid().getState()+", "+vo.getCity()+", "+vo.getPostalBox();
			 mobileNo	= vo.getContactNo();
			 
		 }
		 
		 //set parameters to report
		 Map<String,Object> params = new HashMap<>();
		 params.put("cusName", name);
		 params.put("cusAddress",address);
		 params.put("cusTP",mobileNo);
		 params.put("testDate",vr.getDate());
		 params.put("testTime",vr.getTime());
		 params.put("mileage",vr.getCurrentMilage());
		 params.put("fuel",vr.getVid().getFtype().getFuel());
		 params.put("model",vr.getVid().getVmodel().getVehicleModel());
		 params.put("make",vr.getVid().getVmodel().getVehicleMakeID().getVehicleMake());
		 params.put("class",vr.getVid().getVmodel().getVehicleClass().getVehicleClass());
		 params.put("chessisNo",vr.getVid().getChassisNo());
		 params.put("engineNo",vr.getVid().getEngineNo());
		 params.put("bpartner",vr.getCentermaster().getPartner_ID().getPartner_Name());
		 params.put("bpartnerLogo",vr.getCentermaster().getPartner_ID().getPartner_Logo());
		 params.put("centerAddress",vr.getCentermaster().getAdd03());
		 params.put("centerName", vr.getCentermaster().getCenter());
		 params.put("centerContactNo", vr.getCentermaster().getTele());
		 params.put("centerOpenTime", vr.getCentermaster().getOpenTime());	
		 params.put("centerCloseTime", vr.getCentermaster().getCloseTime());
		 if(vr.getOcrid().getNoimage() != null)
			 if(vr.getOcrid().getNoimage().length>0)
				 params.put("vehicleImage",vr.getOcrid().getNoimage());
		 
		 params.put("noOfAxles",vr.getVid().getNoWheel());
		 params.put("LicensePlateNo",vr.getVid().getVehicleID());
		 params.put("RegistrationNo", register_id);
		 params.put("ReportID",test_value_file_id );
		 params.put("Inspector",vr.getUser().getUserName());
		 params.put("emissionType",vr.getVid().getEmissionNorms());
		 params.put("tokenNo",vr.getTrid().getTrID());
		 params.put("reportColor",color);
		 
		 String bookingNo = vr.getOcrid().getAppNo();		 
		 if(bookingNo == null || bookingNo.equals("0") ) {
			 bookingNo = "N / A";
		 }
		 params.put("appointmentNo", bookingNo);
		 
		 //getting test results from query
		 String[][] result = service.getTestResult(test_pro_id,test_value_file_id,vehicle_cat_id);
		 List<TestResultBean> list = new ArrayList<>();
		 
		 for(int i=0; i<result.length;i++ )
		 {
			 TestResultBean obj = new TestResultBean();
			 
			 obj.setTest_value_result_header_Vehicle_ID(result[i][0]);
			 obj.setTest_value_result_detail_Code(result[i][1]);
			 obj.setTest_value_result_detail_Result(Double.valueOf(result[i][2]));
			 obj.setTest_type_type_id(result[i][3]);
			 obj.setTest_type_test_type(result[i][4]);
			 obj.setT_test_point_name(result[i][5]);
			 obj.setTa_para_name(result[i][6]);
			 obj.setTaa_angle_name(result[i][7]);
			 //obj.setT_limit_value_desc(result[i][8]);
			 obj.setOperator(result[i][9]);
			 if(result[i][10] !=null) {
				 obj.setT_limit_value(Double.valueOf(result[i][10]));}
			 
			 if(result[i][11] !=null) {
				 obj.setT_min_value(Double.valueOf(result[i][11]));
			 }
			 
			 if(result[i][12] !=null) {
				 obj.setT_max_value(Double.valueOf(result[i][12]));
			 }
			 
			 obj.setTest_profile_status_status(result[i][13]);
			 
			 if(result[i][14] !=null)
				 obj.setUnit(result[i][14]);
			 if(result[i][15] !=null)
				 obj.setUnit(result[i][15]);
			 if(result[i][16] !=null)
				 obj.setUnit(result[i][16]);
			 
			 int pass_fail_status = 2;
			 String limit_value_desc = null;
			 
			 // limit value checking	 
			 if(obj.getTest_profile_status_status().equals("0"))
			 {
				 
				 if(obj.getT_limit_value() != null)
				 {
					    switch(obj.getOperator()){
					    case "<=":
					    	
							 if(obj.getTest_value_result_detail_Result() <= obj.getT_limit_value())
								 pass_fail_status = 1;
							 else
								 pass_fail_status = 0;
					        break;
					        
					    case "<":
					    	
							 if(obj.getTest_value_result_detail_Result() < obj.getT_limit_value())
								 pass_fail_status = 1;
							 else
								 pass_fail_status = 0;
					        break;
					       
					    case "=>":
							 if(obj.getTest_value_result_detail_Result() >= obj.getT_limit_value())
								 pass_fail_status = 1;
							 else
								 pass_fail_status = 0;
					        break;
					    
					    case ">":
							 if(obj.getTest_value_result_detail_Result() > obj.getT_limit_value())
								 pass_fail_status = 1;
							 else
								 pass_fail_status = 0;
					        break;
					    }
					    
					    limit_value_desc = obj.getT_test_point_name()+" "+obj.getTa_para_name()+" "+obj.getTaa_angle_name()+" "+obj.getOperator()+" "+obj.getT_limit_value()+" "+"Normal";

				 }
				 
				 if(obj.getT_min_value()!=null || obj.getT_max_value()!=null)
				 {
					 if(obj.getTest_value_result_detail_Result()<=obj.getT_max_value() && 
							 obj.getTest_value_result_detail_Result()>=obj.getT_min_value())
						pass_fail_status = 1;
					else
						pass_fail_status = 0;
						 
					 
					 limit_value_desc = obj.getT_test_point_name()+" "+obj.getTa_para_name()+" "+obj.getTaa_angle_name()+" "+"min "+obj.getT_min_value()+" "+"max "+obj.getT_max_value();
				 }
				 
			 }

			 obj.setPass_fail_status(pass_fail_status);
			 obj.setT_limit_value_desc(limit_value_desc);
			 list.add(obj);
			 
			 //System.out.println(obj.getTest_type_test_type()+" "+pass_fail_status);
		 }

/* ---------------------------------------------------------------------------------------------------------- */
		 String[][] speedoResult = service.getSpeedoTestResult(test_pro_id,test_value_file_id,vehicle_cat_id);
					
			String subCat = vr.getVid().getSubCategoryID().getDescription();
			boolean haveSpeedGovernor = false;
			double lmaxSpeed = 0 ;
			// last max speed with tolerance
			
			if (!subCat.equalsIgnoreCase("N/A")) {
				int imaxSpeed = vr.getVid().getSubCategoryID().getMaxSpeed();
				double tol = vr.getVid().getSubCategoryID().getTolerance();
				lmaxSpeed = imaxSpeed + (imaxSpeed * tol/100);
				
				haveSpeedGovernor =  true;
			}
			
			String status="PASS";
			String status2="PASS";
			String mandatory_status = null;
			List<TestResultSpeedoBean> speedoList = new ArrayList<>();
			
			for (int i = 0; i < speedoResult.length; i++) {
				double targetTolerance1 = 0;
				double targetTolerance2 = 0;
				TestResultSpeedoBean speedoObj = new TestResultSpeedoBean();
				
				try {
					speedoObj.setValue1(speedoResult[i][0]);
					speedoObj.setValue2(speedoResult[i][2]);
					
					i = i +1;
					speedoObj.setValue3(speedoResult[i][2]);
					if(speedoResult[i][5]!=null)
						targetTolerance1 = Double.parseDouble(speedoResult[i][5]);
					
					i = i +1;
					speedoObj.setValue4(speedoResult[i][0]);
					speedoObj.setValue5(speedoResult[i][2]);
					
					i = i +1;
					speedoObj.setValue6(speedoResult[i][2]);
					if(speedoResult[i][5]!=null)
						targetTolerance2 = Double.parseDouble(speedoResult[i][5]);
					
					mandatory_status = speedoResult[i][6];

					if(mandatory_status.equals("0")) {
						String desc = speedoObj.getValue1()+" ActualSpeed  < "+speedoObj.getValue3()+" Normal\n"+speedoObj.getValue4()+" ActualSpeed  < "+speedoObj.getValue6()+" Normal";
						speedoObj.setLimitDes(desc);
						
						if (haveSpeedGovernor) {
							if(status2=="PASS") {
								if(speedoObj.getValue2() > lmaxSpeed)
									status2="FAIL";
								if(speedoObj.getValue5() > lmaxSpeed)
									status2="FAIL";
							}						
						}else {
							if(status=="PASS") {
								
								double lmaxSpeed1 = speedoObj.getValue3() + (speedoObj.getValue3() * targetTolerance1/100);
								double lmaxSpeed2 = speedoObj.getValue6() + (speedoObj.getValue6() * targetTolerance2/100);
								System.out.println(lmaxSpeed1+" "+lmaxSpeed2);
								
								if(speedoObj.getValue2() >  lmaxSpeed1)
									status="FAIL";
								if(speedoObj.getValue5() > lmaxSpeed2)
									status="FAIL";
							}					
						}					
					}
					
					speedoList.add(speedoObj);		
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println(e);
				}

			}
			
			params.put("speedoResults",speedoList);
			
			if(!speedoList.isEmpty()) {
				if(mandatory_status.equals("0")) {
					if (haveSpeedGovernor) {
						params.put("speedoPassStatus2", status2);
						params.put("speedoGovernorLimit", "<= "+lmaxSpeed+" km/h");
					}	
					else {
						params.put("speedoPassStatus",status);}
				}				
			}
			
			
/* ---------------------------------------------------------------------------------------------------------- */
			
			params.put("noiseResults",list);
			params.put("brakeResults", list);
/* ---------------------------------------------------------------------------------------------------------- */
			
		try {
			// getting visual inspection records
			VisualChecklistMaster vi = inspectionServices.getChecklistMasterData(register_id);
			List<VisualChecklistDetail> b = inspectionServices.getCheckedData(vi.getCheklistID());
			params.put("checklistData", b);
		} catch (Exception e) {
			System.out.println("Error on getting visual inspection records " + e);
		}
		 
		try {
			// Emission diesel results
			EmissionDieselCertificateData emd = service.getEmiDieselCerData(register_id);
			List<EmissionDieselCertificateReadings> emr = service.getEmiDieselCerReadings(emd.getId_no());
			params.put("emissionDieselReadings", emr);
		} catch (Exception e) {
			System.out.println("Error on getting Emission diesel results " + e);
		}
		
		try {
			// Emission petrol results
			EmissionPetrolCertificateData empcdata = service.getEmiPetrolCerData(register_id);
			
			List<EmissionPetrolResultBean> petrolResultlist = new ArrayList<EmissionPetrolResultBean>();
			EmissionPetrolResultBean empresult = new EmissionPetrolResultBean();
			empresult.setEmpcdata(empcdata);
			empresult.setEmpcgas(service.getEmiPetrolCerGas(empcdata.getId_no()));
			empresult.setEmpclambda(service.getEmiPetrolCerLambda(empcdata.getId_no()));
			empresult.setEmpcpetrol(service.getEmiPetrolCerPetrol(empcdata.getId_no()));
			
			petrolResultlist.add(empresult);
			
			params.put("emissionPetrolReadings",petrolResultlist);
			
		} catch (Exception e) {
			System.out.println("Error on getting Emission petrol results "+e);
		}
		 
		 
//Getting finalized PASS / FAIL status for the Test Type
		
		 Map<String, List<TestResultBean>> hashMap = new HashMap<String, List<TestResultBean>>();
		 
		 for(TestResultBean ab : list)
		 {
			 String key  = ab.getTest_type_test_type();
			 
			 if (!hashMap.containsKey(key)) {
				    List<TestResultBean> list2 = new ArrayList<TestResultBean>();
				    list2.add(ab);

				    hashMap.put(key, list2);
				} else {
				    hashMap.get(key).add(ab);
				}
		 }
		 
		for (Map.Entry<String, List<TestResultBean>> entry : hashMap.entrySet()) {
		    //System.out.println(entry.getKey() + " = " + entry.getValue());
			
			 List<TestResultBean> list3 = hashMap.get(entry.getKey());
			 int basenumber = 2, exponent = list3.size();
			 
			 int rs = 1;
			 
			 for(TestResultBean xy : list3)
			 {
				  rs = rs * xy.getPass_fail_status();
				
			 }

			 double pow = Math.pow(basenumber, exponent);
			 double y = rs/pow;
			 
			 System.out.println("Final result is" + y);
			 String final_result = null;
			 if(y==0.0) {
				 //fail
				 final_result="FAIL";
				 
			 }else if(y>0.0 && y<1.0 ) {
				 //pass
				 final_result="PASS";
				 
			 }else if(y==1){
				 //Not checked
				 final_result="";
			 }
			 
			 a:for(TestResultBean xy : list)
			 {
				  if(xy.getTest_type_test_type().equals(entry.getKey())){
					  xy.setFinalize_pass_fail_status(final_result);
					  //System.out.println(entry.getKey() + " "+final_result);
					  break a;
				  }
			 }
				 
			 //list.get(8).setFinalize_pass_fail_status("Not Checked");
			 
		}
		 
		 ReportViewe view =new ReportViewe();
		 String pdf_result = null;
		 params.put("limitValueDescription",list);
		 
		try {
			pdf_result = view.pdfReportViewInlineSystemOpen("test_report.jasper","test_report",list,params,response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// update vehicle registration table as testing was completed
		vehicleService.update_test_status(register_id);
		
		// update test_value_result_header table
		testValueFileServices.update_status(register_id);
		
		
		 mav.addObject("pdfViewEq", pdf_result);
		 return mav;
		 
	 }
	
	 /*@GetMapping("/getTestingReport")
	 public ModelAndView getTestingReport(@RequestParam String vehicle_id,@RequestParam String test_value_file_id,HttpServletResponse response)
	 {
		 String cat_id =  vehicleService.getCategoryID(vehicle_id);
		 System.out.println("Category ID id " + cat_id);
		 
		 int profile_id = centerService.getProfileID(cat_id);
		 System.out.println("Profile id is"+ profile_id);
		 
		 System.out.println(test_value_file_id);
		 
		return null;
		 
	 }*/
	 
	 @ModelAttribute("testParaCat")
	 public List<TestParameterCategory> getAllTestParaCat(){
		 
		 List<TestParameterCategory> ls = service.getAllTestParaCat();
		 return ls;
	 }
	
	 @ModelAttribute("testProfile")
	 public List<TestProfile> getAlltestProfiles(){
		 
		 List<TestProfile> ls = service.listAllProfiles();
		 return ls;
	 }
	 
//	@ModelAttribute("vehicleCat")
//	public List<VehicleCategory> getAllVehicleCats(){
//		List <VehicleCategory> vCats = vehicleService.getVehicleCategory();
//		return vCats;
//	} 
	 
	 @ModelAttribute("testPoints")
	 public List<TestPoint> getAlltestPoints(){
		 
		 List<TestPoint> ls = service.listAllTestPoints();
		 return ls;
	 }
	 
	 @ModelAttribute("testParameters")
	 public List<TestParameter> getAlltestParameters(){
		 
		 List<TestParameter> ls = service.listAll();
		 return ls;
	 }
	 
	 @ModelAttribute("parameterAngles")
	 public List<TestParameterAngle> getAllparameterAngles(){
		 
		 List<TestParameterAngle> ls = service.listAllTestParameterAngles();
		 return ls;
	 }
	 
//	@RequestMapping(value="/getTestPointsByTestTypeID", method=RequestMethod.GET)
//	public @ResponseBody List<TestPoint> getTestPointsByTestTypeID(@RequestParam String typeID) {
//		List<TestPoint> rs = service.getTestPointsByTestTypeID(typeID);
//		return rs;
//	}
	
	@RequestMapping(value="/getTestAnglesByTestPara", method=RequestMethod.GET)
	public @ResponseBody List<TestParameterAngle> getTestAnglesByTestPara(@RequestParam String paraID) {
		List<TestParameterAngle> rs = service.getTestAnglesByTestPara(paraID);
		return rs;
	}
	
	
/*	@RequestMapping(value="/getTestCodes", method=RequestMethod.GET)
	public @ResponseBody List<ParameterCodes> getTestCodes(@RequestParam String typeID, String pointID, String paraID) {
		List<ParameterCodes> rs = service.getTestCodes(typeID,pointID,paraID);
		return rs;
	}*/
	
/*	@RequestMapping(value="/getTestCodes2", method=RequestMethod.GET)
	public @ResponseBody List<ParameterCodes> getTestCodes2(@RequestParam String typeID, String pointID, String paraID, String angleID) {
		List<ParameterCodes> rs = service.getTestCodes2(typeID,pointID,paraID,angleID);
		return rs;
	}*/
	
	//	save limit values
/*	 @RequestMapping(value="/setLimitValues" ,method=RequestMethod.POST)
	 public String setLimitValues(@ModelAttribute("limitValues") ParameterCodes pc,RedirectAttributes redirectAttributes) {
		 
		 Optional<ParameterCodes> obj = service.getDataByCode(pc.getCode());

		 if(obj.isPresent())
		 {
			 
			 try {
				 service.setLimitValues(pc.getOperator(),pc.getLimitValue(),pc.getMinValue(),pc.getMaxValue(),pc.getCode());
				 redirectAttributes.addFlashAttribute("success", 1);
			} catch (Exception e) {
				 redirectAttributes.addFlashAttribute("success", 0);
			}
			 
		 }else {
			 try {
				 service.saveParaCode(pc);
				 redirectAttributes.addFlashAttribute("success", 1);
			} catch (Exception e) {
				 redirectAttributes.addFlashAttribute("success", 0);
			}
			
			
			//tpd.setParameterCodes(pc);
			//service.saveTestProfileDetial(tpd);
		 }		
		 
		 return "redirect:/limitValues";

	 }*/
	 
	 @ModelAttribute("paraCodes")
	 public List<ParameterCodes> getAllCodes(){
		 
		 List<ParameterCodes> ls = service.getAllCodes();
		 return ls;
	 }
	 
/*	@RequestMapping(value="/getTestCodes3", method=RequestMethod.GET)
	public @ResponseBody List<ParameterCodes> getTestCodes3(@RequestParam String typeID, String pointID) {
		List<ParameterCodes> rs = service.getTestCodes3(typeID,pointID);
		return rs;
	}*/
	
	 // Edit limit values
/*	 @RequestMapping("/editLimits")
	 public ModelAndView getProfile(@RequestParam String code) {
		 
	     ModelAndView mav = new ModelAndView("testLimitValues");
		 //System.out.println("code is "+code);
	     try {
	    	 
	    	 ParameterCodes pc = new ParameterCodes();
	    	 pc = service.getData(code);
		     mav.addObject("limitValues",pc);
	    	 
	    	 //System.out.println("parameter is "+ pc.getMinValue());
		     
	     }catch (Exception e) {
			System.out.println(e);
		}
		//return null;
	  
	     return mav;
	     
	 }*/

	 @ModelAttribute("testProfileStatus")
	 public List<TestProfileStatus> getAllTestProfileStatus(){
		 
		 List<TestProfileStatus> ls = testProfileService.getAllTestProfileStatus();
		 return ls;
	 }

/*	@RequestMapping(value = "/saveProfileStatus", method = RequestMethod.GET)
	public @ResponseBody TestProfileStatusJsonRespone saveTestProfileStatus(@RequestParam("profile_id") int pro_id,
			@RequestParam("type_id") String type_id,
			@RequestParam("status") int status,@RequestParam("serial_no") int serial_no) {

		int success=2;
		//new record = 0
		//update = 1
		//error = 2

		TestProfileStatus tps = new TestProfileStatus();
		TestProfile tp = new TestProfile(); tp.setTestProfileID(pro_id);
		Test_type tt = new Test_type(); tt.setTypeId(type_id);
		tps.setProfile_id(tp); 
		tps.setType_id(tt);
		tps.setStatus(status);
		tps.setSerial_no(serial_no);

		TestProfileStatusJsonRespone respone = new TestProfileStatusJsonRespone();
		
		try {
			
			TestProfileStatus obj = testProfileService.findBy(pro_id,type_id);
			
			if (obj != null) {
				testProfileService.updateRecord(obj.getS_id(), status,serial_no);
				success = 1;
			} else {
				testProfileService.saveTestProStatus(tps);
				success = 0;
			}
				
		} catch (Exception e) {
			success = 2;
			System.out.println(e);
		}
		
		respone.setSuccess(success);
		respone.setProfile_status_list(testProfileService.getAllTestProfileStatus());
		
		return respone;
	}
	*/
	
}
