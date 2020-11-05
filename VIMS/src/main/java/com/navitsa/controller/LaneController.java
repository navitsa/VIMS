package com.navitsa.controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.entity.AddLaneHeadCategory;
import com.navitsa.entity.AddLaneHeadVehicleClass;
import com.navitsa.entity.BusinessPartner;
import com.navitsa.entity.CenterMaster;
import com.navitsa.entity.EquipmentMake;
import com.navitsa.entity.EquipmentMaster;
import com.navitsa.entity.EquipmentModel;
import com.navitsa.entity.EquipmentType;
import com.navitsa.entity.TestCategory;
import com.navitsa.entity.TestLane;
import com.navitsa.entity.TestLaneDetails;
import com.navitsa.entity.TestLaneHead;
import com.navitsa.entity.Test_type;
import com.navitsa.entity.UserLevel;
import com.navitsa.entity.Users;
import com.navitsa.entity.VehicleClass;
import com.navitsa.services.BusinessPartnerService;
import com.navitsa.services.CenterService;
import com.navitsa.services.EquipmentService;
import com.navitsa.services.LaneServices;
import com.navitsa.services.TestTypeService;
import com.navitsa.services.UsersService;
import com.navitsa.services.VehicleService;

@Controller
public class LaneController {

	@Autowired
	private LaneServices laneServices;
	@Autowired
	private CenterService centerService;
	@Autowired
	private EquipmentService eqervice;
	@Autowired
	private UsersService usservice;
	@Autowired
	BusinessPartnerService businessPartnerService;
	@Autowired
	VehicleService vehicleService;
	@Autowired
	private TestTypeService testTypeService;
	
	@RequestMapping("/TestLaneDetails")
	public String getCenterDetailsPage(Map <String , Object> model,@RequestParam String id) {
		TestLaneDetails testlanedetails = new TestLaneDetails();
		testlanedetails.setTestLaneDetailsid("0000".substring(laneServices.maxlaneDetailsid().length()) + laneServices.maxlaneDetailsid());
		TestLaneHead testLaneHead=laneServices.getTestLaneHeadById(id);
		CenterMaster centerMaster=centerService.getcenterById(testLaneHead.getCenterID().getCenter_ID());
		testlanedetails.setCenterID(centerMaster);
	//	TestLane testLane=laneServices.getAllLaneDetailsByID(testLaneHead.getLaneID());
		//testlanedetails.setLaneID(testLane);
		testlanedetails.setTestLaneHeadId(testLaneHead);
		List <TestLaneDetails> testlanedetaisList = centerService.listTestDetails(id);
		
		model.put("testlanedetaisList", testlanedetaisList);
		model.put("testLaneDetails", testlanedetails);
		
		AddLaneHeadCategory alc=new AddLaneHeadCategory();
		alc.setTestLaneHeadId(testLaneHead);
		model.put("addLaneHeadCategory", alc);
		
		AddLaneHeadVehicleClass vec=new AddLaneHeadVehicleClass();
		vec.setTestLaneHeadId(testLaneHead);
		model.put("addLaneHeadVehicleClass", vec);
		
		List <AddLaneHeadCategory> catList = laneServices.listAddLaneHeadCategory(id);
		
		model.put("laneCategoryList", catList);
		
		
		List <AddLaneHeadVehicleClass> classList = laneServices.listAddLaneHeadVehicleClass(id);
		
		model.put("laneVehicleClassList", classList);
		
	
		return "TestLaneDetails";
	}
	//list Centers
	@ModelAttribute("allcenters")
	public List <CenterMaster> getcenterist(){
		List<CenterMaster> listOfcenters = centerService.listAll();
		return listOfcenters;
	}
	//list testlane
	@ModelAttribute("alllanes")
	public List<TestLane> getAllLanes() {
		List<TestLane> lane = laneServices.getAllLaneDetails();
		return lane;
	}	
	 //add combo for testdetais jsp
	 @ModelAttribute("testtypeList")
		public List <Test_type> getListOfTestType(){
			List <Test_type> getTesttype = laneServices.getTesttypeCombo();
			return getTesttype;
		}
	
		@ModelAttribute("eqTypeCmbforLane")
		public List<EquipmentType> getAllTypeDetails() {
		List<EquipmentType> typedrop = eqervice.findAllEquipmentType();
		return typedrop;
		}
		
		@RequestMapping(value="/eqModleCmbforLane", method=RequestMethod.GET)
		public  @ResponseBody  List<EquipmentModel> getAllModelDetails(@RequestParam String eqMakeid,@RequestParam String eqTypeID) {
		List<EquipmentModel> modeldrop = eqervice.searchModel(eqMakeid,eqTypeID);
		return modeldrop;
		}
		//combo box for eq.make selection
		@ModelAttribute("eqMakeCmbforLane")
		public List<EquipmentMake> getAllMakeDetails() {
			List<EquipmentMake> makedrop = eqervice.findAllEquipmentMake();
			return makedrop;
		}
		//get Equment data in combo forLane
		@RequestMapping(value="/getEquipmentcombo", method=RequestMethod.GET)
		public  @ResponseBody List<EquipmentMaster> setEqumentComboforLane(@RequestParam String eqModelID,@RequestParam String eqTypeid) {
			List<EquipmentMaster> listeq= eqervice.getEqumentDatabyEqTyoEqModel(eqTypeid,eqModelID);
			return listeq;
		}
		
		@RequestMapping(value="/getEquipmentMa", method=RequestMethod.GET)
		public  @ResponseBody List<EquipmentMaster> searchEq(@RequestParam String eqModelID,@RequestParam String center) {
			List<EquipmentMaster> listeq= eqervice.searchEq(eqModelID,center);
			return listeq;
		}
		
		@ModelAttribute("userlevelforinsper")
		public List<UserLevel> getleveldetails(){
		List <UserLevel> ul = usservice.listAllUserlevel();
		return ul;
	 	}	
	
		@RequestMapping(value="/getLevelByUserLevel", method=RequestMethod.GET)
		public  @ResponseBody List<Users> getLevelByUserLevel(@RequestParam String userLevel) {
			List<Users> listeq= usservice.userbyLevel(userLevel);
			return listeq;
		}		
		
		@RequestMapping(value = "/testDetailsAction", method = RequestMethod.POST)
		public String saveTestLaneDetails(@ModelAttribute("testLaneDetails") TestLaneDetails testLaneDetails,RedirectAttributes redirectAttributes) {
			try {
			laneServices.saveTestLaneDetails(testLaneDetails);
			redirectAttributes.addFlashAttribute("success", 1);
			}catch(Exception e) {
				System.out.println(e);
				redirectAttributes.addFlashAttribute("success", 0);
			}
			return "redirect:/TestLaneDetails?id="+testLaneDetails.getTestLaneHeadId().getTestLaneHeadId()+"";

		}	
		
		@RequestMapping(value = "/testLanes", method = RequestMethod.GET)
		public String list(Map <String , Object> model) {
			TestLane testLane = new TestLane();
			testLane.setLaneId("0000".substring(laneServices.maxlanetyid().length()) + laneServices.maxlanetyid());
			//List <TestLaneDetails> testlanedetaisList = centerService.listTestDetails();
			model.put("AlltestLane", laneServices.getAllLaneDetails());
			model.put("netmaxid", testLane);
			model.put("saveTestLane", new TestLane());
			return "testLanes";	
			
		}	
		@RequestMapping(value = "/savetestLanes", method = RequestMethod.POST)
		public String saveUser(@Valid @ModelAttribute("saveTestLane") TestLane testLane, BindingResult br,RedirectAttributes redirectAttributes) {
			if(br.hasErrors()) {
				return "testLanes";
			}
			try {
			laneServices.saveTestLane(testLane);
			redirectAttributes.addFlashAttribute("success", 1);
			}catch(Exception e) {
				System.out.println(e);
				redirectAttributes.addFlashAttribute("success", 0);
			}
			return "redirect:/testLanes.do";
		}
		
		 @ModelAttribute("LanepartnerCombo")
		 public List<BusinessPartner> getAll() {
			 List<BusinessPartner> bp = usservice.getAllPartners();
			 return bp;
		 }
		
	@RequestMapping("/laneDetails1")
	public String LaneDetails(Map<String, Object> model) {

		return "laneDetails";
	}


	//edit test lane
	@RequestMapping("/editTestlanes")
	public ModelAndView updateTestLane(@RequestParam String laneId) {
		ModelAndView mav = new ModelAndView("testLanes");
		TestLane vRType = laneServices.getTestLaneById(laneId);
		mav.addObject("saveTestLane", vRType);
		return mav;
	}
	
	@ModelAttribute("AlltestLane")
	public List<TestLane> getAllTestLanes() {
		List<TestLane> lane = laneServices.getAllLaneDetails();
		return lane;
	}
	 @ModelAttribute("vclassLoadModel")
	 public List<VehicleClass> loadVClass(){
		 List<VehicleClass> vclist = vehicleService.getVClass();
		 return vclist;
	 }
	 @ModelAttribute("listLaneHead")
	 public List<TestLaneHead> listTestLaneHead(){
		 List<TestLaneHead> lhlist = laneServices.listTestLaneHead();
		 return lhlist;
	 } 
	 
		@RequestMapping(value = "/createNewTestLanes", method = RequestMethod.GET)
		public String openNewLane(Map <String , Object> model) {
			TestLaneHead createTestLane = new TestLaneHead();
			createTestLane.setTestLaneHeadId("0000".substring(laneServices.maxlaneHeadid().length()) + laneServices.maxlaneHeadid());
			List <TestLaneHead> allLaneHead = laneServices.getAllTestLaneHead();
			//model.put("AlltestLane", laneServices.getAllLaneDetails());
			model.put("allLaneHead", allLaneHead);
			model.put("saveLaneHead", createTestLane);
			return "NewLane";	
			
		}	
		
		
		
		@RequestMapping(value = "/saveLaneHead", method = RequestMethod.POST)
		public String saveLaneHead(@Valid @ModelAttribute("saveLaneHead") TestLaneHead testLaneHead,RedirectAttributes redirectAttributes) {
//			if(br.hasErrors()) {
//				return "testLanes";
//			}
			try {
				testLaneHead.setRemark("a");
				testLaneHead.setStatus("ACTIVE");
			laneServices.saveTestLaneHead(testLaneHead);
			
			redirectAttributes.addFlashAttribute("success", 1);
			}catch(Exception e) {
				System.out.println(e);
			redirectAttributes.addFlashAttribute("success", 0);
			}
			return "redirect:/createNewTestLanes.do";
		}
		//edit test lane
		@RequestMapping("/editLaneHead")
		public ModelAndView editLaneHead(@RequestParam String id) {
			ModelAndView mav = new ModelAndView("createNewTestLanes");
			TestLaneHead vhead = laneServices.getTestLaneHeadById(id);
			mav.addObject("saveLaneHead", vhead);
			return mav;
		}
		

		 @ModelAttribute("vclassLane")
		 public List<VehicleClass> loadvclassLane(){
			 List<VehicleClass> vclist = vehicleService.getVClass();
			 return vclist;
		 }

		 
			@ModelAttribute("regCatTypeList")
			public List <TestCategory> getTestCategory(){
				List <TestCategory> listTestCategory = centerService.getAll();
				return listTestCategory;
			}
		 

			
	
			 //getMakeImg
			 @RequestMapping(value="/setProgress", method=RequestMethod.GET)
			 public @ResponseBody double setProgress(@RequestParam String centerID) {
				 List<TestLaneHead> listeq= laneServices.getTestLaneHeadDetailByCenter(centerID);
				 CenterMaster centerMaster=centerService.getcenterById(centerID);
				 System.out.println("ff="+listeq.size()+"  gg="+Integer.parseInt(centerMaster.getLanes()));
				 double y=Double.parseDouble(listeq.size()+"")/Double.parseDouble(centerMaster.getLanes());
				// int x=(Integer.parseInt(centerMaster.getLanes()))*100);
				// System.out.println("ff="+listeq.size()+"  gg="+Integer.parseInt(centerMaster.getLanes())+" kk="+x);
				//Double x= new DecimalFormat("#").format(y*100);
				 
				 return Math.round(y*100);
				 
			}
		
	
				@RequestMapping(value="/geteqTypeidByTesTtyp", method=RequestMethod.GET)
				public  @ResponseBody  List<EquipmentType> getEqupmentTypeByTestType(@RequestParam String testType) {
				List<EquipmentType> modeldrop = testTypeService.getEqupmentTypeByTestType(testType);
				return modeldrop;
				}
				
				@RequestMapping(value = "/saveLaneHeadCategory", method = RequestMethod.POST)
		public String saveLaneHeadCategory(@Valid @ModelAttribute("addLaneHeadCategory") AddLaneHeadCategory addLaneHeadCategory,RedirectAttributes redirectAttributes) {
//			if(br.hasErrors()) {
//				return "testLanes";
//			}
			try {

			laneServices.saveLaneHeadCategory(addLaneHeadCategory);
			
			redirectAttributes.addFlashAttribute("success1", 1);
			}catch(Exception e) {
				System.out.println(e);
			redirectAttributes.addFlashAttribute("success1", 0);
			}
			
			return "redirect:/TestLaneDetails?id="+addLaneHeadCategory.getTestLaneHeadId().getTestLaneHeadId();
		}	
				
	
				@RequestMapping(value = "/saveLaneHeadVehicleClass", method = RequestMethod.POST)
		public String saveLaneHeadVehicleClass(@Valid @ModelAttribute("addLaneHeadCategory") AddLaneHeadVehicleClass addLaneHeadVehicleClass,RedirectAttributes redirectAttributes) {
//			if(br.hasErrors()) {
//				return "testLanes";
//			}
			try {

			laneServices.saveLaneHeadVehicleClass(addLaneHeadVehicleClass);
			
			redirectAttributes.addFlashAttribute("success2", 1);
			}catch(Exception e) {
				System.out.println(e);
			redirectAttributes.addFlashAttribute("success2", 0);
			}
			
			return "redirect:/TestLaneDetails?id="+addLaneHeadVehicleClass.getTestLaneHeadId().getTestLaneHeadId();
			
			
		}	
						
				
				
				
				
				
}
