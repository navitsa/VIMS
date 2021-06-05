package com.navitsa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.entity.Ck_testProfileDetailId;
import com.navitsa.entity.Ck_testWisePrintOrderId;
import com.navitsa.entity.FuelType;
import com.navitsa.entity.ParameterCodes;
import com.navitsa.entity.TestLimitRule;
import com.navitsa.entity.TestParameter;
import com.navitsa.entity.TestParameterAngle;
import com.navitsa.entity.TestPoint;
import com.navitsa.entity.TestProfile;
import com.navitsa.entity.TestProfileDetail;
import com.navitsa.entity.TestProfileStatus;
import com.navitsa.entity.TestWisePrintOrder;
import com.navitsa.entity.Test_type;
import com.navitsa.entity.VehicleCategory;
import com.navitsa.entity.VehicleCategoryType;
import com.navitsa.entity.VehiclesSubCategory;
import com.navitsa.services.TestProfileService;
import com.navitsa.services.TestTypeService;
import com.navitsa.services.VehicleService;
import com.navitsa.services.VehicleSubCategoryService;

@Controller
public class TestProfileController {
	
	@Autowired
	private TestProfileService testProfileService;

	@Autowired
	private TestTypeService testTypeService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleSubCategoryService vSubCatService;
	
	@RequestMapping("/testPoints")
	public String loadTestPointsForm(Model m) {
		
		m.addAttribute("testPointForm", new TestPoint());
		m.addAttribute("testParameterForm", new TestParameter());
		m.addAttribute("testAngleForm", new TestParameterAngle());
		return "testPoints";
	}
	
	 @ModelAttribute("testTypes")
	 public List<Test_type> getAllTestTypes(){
		 
		 List<Test_type> ls = testTypeService.listAll();
		 return ls;
	 }
	 
	 @ModelAttribute("testPoints")
	 public List<TestPoint> getAlltestPoints(){
		 
		 List<TestPoint> ls = testProfileService.listAllTestPoints();
		 return ls;
	 }
	 
	@RequestMapping(value = "/saveTestPoints", method = RequestMethod.GET)
	public String saveTestPoints(@ModelAttribute("testPointForm") TestPoint tpoint,
			@RequestParam(value="testPointName") String[] tpname, RedirectAttributes redirectAttributes) {
		
		//List<TestPoint> list = new ArrayList<TestPoint>();
		
		String typeID = tpoint.getTestType().getTypeId();
		
		try {

			String maxPointID = testProfileService.maxTestPointID(typeID);
			char y;
			int n=0;
			
			if(maxPointID!=null) {
				int x = maxPointID.length()-1;
				y = maxPointID.charAt(x);
				int z = Integer.valueOf(String.valueOf(y));
				n = z + 1;
				
				//System.out.println("last no is "+ z);
				//System.out.println("final no is "+n);
				//System.out.println(n+0);
			}
			
			for (int i = 0; i < tpname.length; i++) {
				
				if(tpname[i].length()>0) {
					  TestPoint obj = new TestPoint(); 
					  Test_type tt = new Test_type();
					  tt.setTypeId(typeID);
					  
					  if(maxPointID==null) {
						  obj.setTestPointID(typeID+"-"+i);
						  obj.setTestPointName(tpname[i]); 
						  obj.setTestType(tt);
						  testProfileService.save(obj);
					  }else {
						  
						  int nextPointID = n+i;
						  obj.setTestPointID(typeID+"-"+nextPointID);
						  obj.setTestPointName(tpname[i]); 
						  obj.setTestType(tt);
						  testProfileService.save(obj);
					  }
				}
				   
			}
			
			redirectAttributes.addFlashAttribute("success", 1);
			return "redirect:/testPoints";
			
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("success", 0);
		}	
		
		//testProfileService.saveAll(list);
		return "redirect:/testPoints";

	}
	
	//	Saving test parameters
	 @RequestMapping(value="/saveTestParameter" ,method=RequestMethod.GET)
	 public String saveTestParameter(@ModelAttribute("testParameterForm") TestParameter tp,
			 @RequestParam(value="paraName") String[] paraName, RedirectAttributes redirectAttributes) {
		 
		 String typeID = tp.getTestType().getTypeId();
		 try {
			 
			 String maxParaID = testProfileService.maxTestParaID(typeID);
			 char y;
			 int n=0;

			if (maxParaID != null) {
				int x = maxParaID.length() - 1;
				y = maxParaID.charAt(x);
				int z = Integer.valueOf(String.valueOf(y));
				n = z + 1;

				//System.out.println("last no is "+ z);
				//System.out.println("final no is "+n);
				//System.out.println(n+0);
			}
			 
			for (int i = 0; i < paraName.length; i++) {

				if (paraName[i].length() > 0) {
					
					TestParameter obj = new TestParameter();
					Test_type tt = new Test_type();
					tt.setTypeId(typeID);

					if (maxParaID == null) {
						obj.setTestParameterId(typeID + "-" + i);
						obj.setParaName(paraName[i]);
						obj.setTestType(tt);
						testProfileService.saveParameter(obj);
					} else {

						int nextParaID = n + i;
						obj.setTestParameterId(typeID + "-" + nextParaID);
						obj.setParaName(paraName[i]);
						obj.setTestType(tt);
						testProfileService.saveParameter(obj);
					}
				}

			}
			
			redirectAttributes.addFlashAttribute("success", 1);
			return "redirect:/testPoints";
			 
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("success", 0);
		}
		 
		 return "redirect:/testPoints";
	 }
	 
	 @ModelAttribute("testParameters")
	 public List<TestParameter> getAlltestParameters(){
		 
		 List<TestParameter> ls = testProfileService.listAll();
		 return ls;
	 }
	 
	 @ModelAttribute("parameterAngles")
	 public List<TestParameterAngle> getAllparameterAngles(){
		 
		 List<TestParameterAngle> ls = testProfileService.listAllTestParameterAngles();
		 return ls;
	 }
	 
	 @RequestMapping(value="/saveTestAngles" ,method=RequestMethod.GET)
	 public String saveTestAngles(@ModelAttribute("testAngleForm") TestParameterAngle paraAngle,
			 @RequestParam(value="angleName") String[] angleName, RedirectAttributes redirectAttributes) {
				
		 String paraID = paraAngle.getTestParameter().getTestParameterId();
		 
		 try {
			
			 String maxAngleID = testProfileService.maxAngleID(paraID);
			 char y;
			 int n=0;
			 Boolean flag = null;
			 
			if (maxAngleID != null) {
				int x = maxAngleID.length() - 1;
				y = maxAngleID.charAt(x);
				flag = Character.isDigit(y);
				if (flag) {
					int z = Integer.valueOf(String.valueOf(y));
					n = z + 1;
				}


				// System.out.println("last no is "+ z);
				// System.out.println("final no is "+n);
				// System.out.println(n+0);
			}

			for (int i = 0; i < angleName.length; i++) {

				if (angleName[i].length() > 0) {
					
					TestParameterAngle obj = new TestParameterAngle();
					TestParameter testPara = new TestParameter();
					testPara.setTestParameterId(paraID);

					if (maxAngleID == null) {
						
						obj.setParaAngleID(paraID + "-" + i);
						obj.setAngleName(angleName[i]);
						obj.setTestParameter(testPara);
						testProfileService.saveAngle(obj);
					} else if(flag == false) {

						obj.setParaAngleID(paraID + "-" + i);
						obj.setAngleName(angleName[i]);
						obj.setTestParameter(testPara);
						testProfileService.saveAngle(obj);
					}
					else {
						int nextAngleID = n + i;
						obj.setParaAngleID(paraID + "-" + nextAngleID);
						obj.setAngleName(angleName[i]);
						obj.setTestParameter(testPara);
						testProfileService.saveAngle(obj);
					}
				}

			}
			
			redirectAttributes.addFlashAttribute("success", 1);
			return "redirect:/testPoints";
			 
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("success", 0);
		}
		 
		 return "redirect:/testPoints";
		 
	 }
	 
	 @ModelAttribute("testProfileStatus")
	 public List<TestProfileStatus> getAllTestProfileStatus(){
		 
		 List<TestProfileStatus> ls = testProfileService.getAllTestProfileStatus();
		 return ls;
	 }
	 
	@RequestMapping("/limitValues")
	public String loadLimitValuesForm(@RequestParam int proId, Model m) {
		
		TestProfile tp = new TestProfile();
		tp.setTestProfileID(proId);
		TestProfileDetail tpd = new TestProfileDetail();
		tpd.setCk_testProfileDetailId(new Ck_testProfileDetailId(tp, null,null,null,null));
		
		List<TestProfileDetail> ls = testProfileService.listAllProfileDetailsByProfileId(proId);
		
		m.addAttribute("limitValues", tpd);
		m.addAttribute("testProfileDetails", ls);
		
		return "testLimitValues";
	}

	@ModelAttribute("vehicleCat")
	public List<VehicleCategory> getAllVehicleCats(){
		List <VehicleCategory> vCats = vehicleService.getVehicleCategory();
		return vCats;
	}

	@ModelAttribute("vehicleSubCat")
	public List<VehiclesSubCategory> getAllVehicleSubCats(){
		List <VehiclesSubCategory> vSubCats = vSubCatService.findAll();
		return vSubCats;
	} 

	 @ModelAttribute("testProfile")
	 public List<TestProfile> getAlltestProfiles(){
		 
		 List<TestProfile> ls = testProfileService.listAllProfiles();
		 return ls;
	 }

	 @ModelAttribute("paraCodes")
	 public List<ParameterCodes> getAllCodes(){
		 
		 List<ParameterCodes> ls = testProfileService.getAllCodes();
		 return ls;
	 }

	@RequestMapping(value="/getTestCodes4", method=RequestMethod.GET)
	public @ResponseBody List<ParameterCodes> getTestCodes4(@RequestParam String typeID) {
		List<ParameterCodes> rs = testProfileService.getTestCodes4(typeID);
		return rs;
	}

	//	save limit values
	 @RequestMapping(value="/saveLimitValues" ,method=RequestMethod.POST)
	 public String setLimitValues(@ModelAttribute("limitValues") TestProfileDetail tpd,
			 RedirectAttributes redirectAttributes) {
		 	 
		 TestProfile testProfile = tpd.getCk_testProfileDetailId().getTestProfileHeaderID();
		 ParameterCodes paraCode = tpd.getCk_testProfileDetailId().getParameterCode();
		 String vehicle_cat_id = tpd.getCk_testProfileDetailId().getVehicleCat().getCategoryID();
		 VehiclesSubCategory vSub = tpd.getCk_testProfileDetailId().getSubCategoryID();
		 TestLimitRule rule = tpd.getCk_testProfileDetailId().getTestLimitRule();
		 
		 if(vehicle_cat_id.contains("all")) {
			 List <VehicleCategory> vCats = vehicleService.getVehicleCategory();
			 
			 for (VehicleCategory vc : vCats) {
				 tpd.setCk_testProfileDetailId(new Ck_testProfileDetailId(testProfile, paraCode, vc,vSub,rule));
				 testProfileService.saveTestProDetail(tpd);
			 } 
		 }else {
			 testProfileService.saveTestProDetail(tpd);
		 }
		
		 redirectAttributes.addFlashAttribute("success", 1);
		 return "redirect:/limitValues?proId="+testProfile.getTestProfileID();

	 }
	 
//	 @ModelAttribute("testProfileDetails")
//	 public List<TestProfileDetail> getAlltestProfilesDetails(){
//		 
//		 List<TestProfileDetail> ls = testProfileService.listAllProfileDetails();
//		 return ls;
//	 }
	 
 	@RequestMapping("/testCodes")
	public String loadTestCodesForm(Model m) {
		
		m.addAttribute("testCodesM", new ParameterCodes());
		return "testCodes";
	}

	@RequestMapping(value="/getTestPointsByTestTypeID", method=RequestMethod.GET)
	public @ResponseBody List<TestPoint> getTestPointsByTestTypeID(@RequestParam String typeID) {
		List<TestPoint> rs = testProfileService.getTestPointsByTestTypeID(typeID);
		return rs;
	}
	
	@RequestMapping(value = "/saveProfileStatus", method = RequestMethod.GET)
	public String saveTestProfileStatus(@RequestParam("profile_id") int pro_id,
			@RequestParam("type_id") String type_id,
			@RequestParam("status") int status) {

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

		//TestProfileStatusJsonRespone respone = new TestProfileStatusJsonRespone();
		
		try {
			
			TestProfileStatus obj = testProfileService.findBy(pro_id,type_id);
			
			if (obj != null) {
				testProfileService.updateRecord(obj.getS_id(), status);
				success = 1;
			} else {
				testProfileService.saveTestProStatus(tps);
				success = 0;
			}
				
		} catch (Exception e) {
			success = 2;
			System.out.println(e);
		}
		
		//respone.setSuccess(success);
		//respone.setProfile_status_list(testProfileService.getAllTestProfileStatus());
		
		return "redirect:/limitValues?proId=1";
	}
	
	 @ModelAttribute("rules")
	 public List<TestLimitRule> findAll(){
		 
		 List<TestLimitRule> ls = testProfileService.findAllRules();
		 return ls;
	 }
	 @ModelAttribute("testWisePrintOrder")
	 public List<TestWisePrintOrder> getAll(){
		 
		 List<TestWisePrintOrder> ls = testProfileService.getAllTestWisePrintOrder();
		 return ls;
	 }
	 
	@RequestMapping(value = "/saveTestWisePrintOrder", method = RequestMethod.POST)
	public @ResponseBody String saveTestWisePrintOrder(
			@RequestParam("profile_id") int[] pro_id,
			@RequestParam("type_id") String[] type_id,
			@RequestParam("reportPath") String[] reportPath,
			@RequestParam("print_order") int[] printOrder) {
		
		System.out.println("calling....");
		try {
			List<TestWisePrintOrder> ls = new ArrayList<TestWisePrintOrder>();
			for (int i = 0; i < printOrder.length; i++) {

				TestProfile tp = new TestProfile();
				tp.setTestProfileID(pro_id[i]);
				
				Test_type tt = new Test_type();
				tt.setTypeId(type_id[i]);			
				
				TestWisePrintOrder obj = new TestWisePrintOrder(new Ck_testWisePrintOrderId(tp, tt),reportPath[i],printOrder[i]);
				ls.add(obj);
			}
			
			testProfileService.saveTestWisePrintOrder(ls);
			return "1";
		} catch (Exception e) {
			return "0";
		}

	}

	@RequestMapping("/testLimitRule")
	public String loadLimitRuleForm(Model m) {
		
		m.addAttribute("testLimitRuleForm", new TestLimitRule());
		return "testLimitRule";
	}

	@ModelAttribute("fuelTypes")
	public List<FuelType> getAllFualTypes() {
		List<FuelType> list = vehicleService.getFuelType();
		return list;
	}
	
	@ModelAttribute("vehicleCatTypes")
	public List<VehicleCategoryType> getAllVehicleCatTypes() {
		List<VehicleCategoryType> list = vehicleService.getAllVehicleCatTypes();
		return list;
	}
	
	 @RequestMapping(value="/saveTestLimitRule" ,method=RequestMethod.POST)
	 public String saveTestLimitRule(@Valid @ModelAttribute("testLimitRuleForm") TestLimitRule rule,
			 BindingResult br,RedirectAttributes redirectAttributes) {		 
		 if(br.hasErrors())  
	        {  
			 return "testLimitRule";  
			}  
	        else{
	        	try {
	        			if(rule.getRuleCode()!=0) {
	        				testProfileService.saveTestLimitRule(rule);
	        			}
	        			else {
	    		        	String ruleId = testProfileService.nextTestLimitRuleId();
	    		        	rule.setRuleCode(Integer.valueOf(ruleId));
	    		        	testProfileService.saveTestLimitRule(rule);
	        			}
		        	
		        	redirectAttributes.addFlashAttribute("success", 1);
			        return "redirect:/testLimitRule";
				} catch (Exception e) {
					System.out.println(e);
					redirectAttributes.addFlashAttribute("success", 0);
				}
	        }
		 
		 return "testLimitRule";
	 }
	 
	 @RequestMapping("/updateTestLimitRule")
	 public ModelAndView updateTestProfile(@RequestParam int ruleCode) {
	     ModelAndView mav = new ModelAndView("testLimitRule");
	     try {
		     mav.addObject("testLimitRuleForm",testProfileService.findRuleById(ruleCode));
	     }catch (Exception e) {
			System.out.println(e);
		}
	  
	     return mav;
	 }
}
