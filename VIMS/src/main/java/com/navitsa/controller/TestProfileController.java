package com.navitsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.entity.Ck_testProfileDetailId;
import com.navitsa.entity.ParameterCodes;
import com.navitsa.entity.TestParameter;
import com.navitsa.entity.TestParameterAngle;
import com.navitsa.entity.TestPoint;
import com.navitsa.entity.TestProfile;
import com.navitsa.entity.TestProfileDetail;
import com.navitsa.entity.TestProfileStatus;
import com.navitsa.entity.Test_type;
import com.navitsa.entity.VehicleCategory;
import com.navitsa.services.TestProfileService;
import com.navitsa.services.TestTypeService;
import com.navitsa.services.VehicleService;

@Controller
public class TestProfileController {
	
	@Autowired
	private TestProfileService testProfileService;

	@Autowired
	private TestTypeService testTypeService;
	
	@Autowired
	private VehicleService vehicleService;
	
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
		tpd.setCk_testProfileDetailId(new Ck_testProfileDetailId(tp, null,null));
		
		m.addAttribute("limitValues", tpd);
		return "testLimitValues";
	}

	@ModelAttribute("vehicleCat")
	public List<VehicleCategory> getAllVehicleCats(){
		List <VehicleCategory> vCats = vehicleService.getVehicleCategory();
		return vCats;
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

		 
		 if(vehicle_cat_id.contains("all")) {
			 List <VehicleCategory> vCats = vehicleService.getVehicleCategory();
			 
			 for (VehicleCategory vc : vCats) {
				 tpd.setCk_testProfileDetailId(new Ck_testProfileDetailId(testProfile, paraCode, vc));
				 testProfileService.saveTestProDetail(tpd);
			 } 
		 }else {
			 testProfileService.saveTestProDetail(tpd);
		 }
			  
		 return "redirect:/limitValues?proId="+testProfile.getTestProfileID();

	 }
	 
	 @ModelAttribute("testProfileDetails")
	 public List<TestProfileDetail> getAlltestProfilesDetails(){
		 
		 List<TestProfileDetail> ls = testProfileService.listAllProfileDetails();
		 return ls;
	 }
}
