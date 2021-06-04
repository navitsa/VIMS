package com.navitsa.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.navitsa.entity.BusinessPartner;
import com.navitsa.entity.CenterMaster;
import com.navitsa.entity.CenterTypes;
import com.navitsa.entity.CountryMaster;
import com.navitsa.entity.EquipmentMake;
import com.navitsa.entity.EquipmentMaster;
import com.navitsa.entity.EquipmentModel;
import com.navitsa.entity.EquipmentType;
import com.navitsa.entity.InventoryLocation;
import com.navitsa.entity.TestCategory;
import com.navitsa.entity.TestLane;
import com.navitsa.entity.TestLaneDetails;
import com.navitsa.entity.TestProfile;
import com.navitsa.entity.Test_type;
import com.navitsa.entity.Users;
import com.navitsa.entity.VisualProfile;
import com.navitsa.services.BusinessPartnerService;
import com.navitsa.services.CenterService;
import com.navitsa.services.RegionalService;
import com.navitsa.services.TestReportConfigService;
import com.navitsa.services.VisualInspectionServices;
import com.navitsa.utils.StringFormaterWeb;

@Controller
public class CentersController {

	@Autowired
	CenterService centerService;

	@Autowired
	RegionalService rService;

	@Autowired
	BusinessPartnerService partnerRepo;

	@Autowired
	private VisualInspectionServices insService;

	@Autowired
	private TestReportConfigService service;

	@RequestMapping(value = "/centerType", method = RequestMethod.GET)
	public String listTypes(Map<String, Object> map) {

		CenterTypes cType = new CenterTypes();
		cType.setCenterTypeID("0000".substring(centerService.getId().length()) + centerService.getId());
		map.put("ct", cType);
		List<CenterTypes> listCenterTypes = centerService.getAllCTypes();
		map.put("listTypes", listCenterTypes);
		return "centerType";
	}

	@RequestMapping(value = "/saveCenterType", method = RequestMethod.POST)
	public String saveItems(@Valid @ModelAttribute("ct") CenterTypes centerTypes, BindingResult br) {
		if (br.hasErrors()) {
			return "centerType";
		} else {
			centerService.save(centerTypes);
			return "redirect:/centerType.do";
		}
	}

//	data retrieve to page , load by id
	@RequestMapping("/getCenterInfo")
	public ModelAndView getProfile(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("centerType");
		CenterTypes ct = centerService.get(id);
		mav.addObject("centers", ct);

		return mav;
	}

	@ModelAttribute("types")
	public List<CenterTypes> getAll() {
		List<CenterTypes> types = centerService.getAllCTypes();
		return types;
	}

	@RequestMapping(value = "/deleteCenterInfo")
	public ModelAndView deleteContact(HttpServletRequest request) {
		String centerId = request.getParameter("centerTypeID");
		centerService.delete(centerId);
		return new ModelAndView("centerType");
	}

	@RequestMapping("/updateCenterType")
	public ModelAndView getCenterType(@RequestParam String centerTypeID) {
		CenterTypes ct = centerService.get(centerTypeID);
		ModelAndView mv = new ModelAndView("centerType");
		mv.addObject("ct", ct);
		return mv;
	}

	// center master
	@RequestMapping(value = "/CMaster", method = RequestMethod.GET)
	public String getCenterMaster(Map<String, Object> model) {
		List<CenterMaster> centerMasterlist = centerService.listAll();
		CenterMaster centermaster = new CenterMaster();
		centermaster
				.setCenter_ID("0000".substring(centerService.maxCenterMID().length()) + centerService.maxCenterMID());
		model.put("centerMasterlist", centerMasterlist);
		model.put("saveCMaster", new CenterMaster());
		model.put("saveCMaster", centermaster);
		return "CMaster";
	}

	@RequestMapping(value = "/updateInfo", method = RequestMethod.GET)
	public ModelAndView editInfo(@RequestParam String center_ID) {

		ModelAndView mav = new ModelAndView("CMaster");
		CenterMaster cm = null;
		try {
			cm = centerService.getcenterById(center_ID);
			mav.addObject("saveCMaster", cm);

		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			String centerLogo = cm.getCenter_imageView();
			mav.addObject("img", centerLogo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return mav;
	}

	@RequestMapping(value = "/saveCMaster", method = RequestMethod.POST)
	public String savecenters(@ModelAttribute("saveCMaster") CenterMaster centerMaster, BindingResult br,
			RedirectAttributes redirectAttributes, HttpSession session) {

		if (br.hasErrors()) {
			return "CMaster";
		} else {
			try {

				BusinessPartner bp = partnerRepo.getPartnerId(centerMaster.getPartner_ID().getPartner_ID());

				centerMaster.setCountrycode(bp.getCountry_Code());
//				centerMaster.setGetAutoCaptureImgPath("E:\\ImageCap");
//				centerMaster.setVehicleAutoConfig("1-1-1-1");	
				centerService.saveMaster(centerMaster);

				InventoryLocation invloc = centerService.getInventoryLocationByCenterID(centerMaster.getCenter_ID());

				InventoryLocation inventoryLocation = new InventoryLocation();
				if (invloc == null) {

					inventoryLocation.setInvLocationcol(centerMaster.getCenter());
					inventoryLocation.setCenterID(centerMaster);
					centerService.saveInventoryLocation(inventoryLocation);
				} else {
					inventoryLocation.setInvLoID(invloc.getInvLoID());
					inventoryLocation.setInvLocationcol(centerMaster.getCenter());
					inventoryLocation.setCenterID(centerMaster);
					centerService.saveInventoryLocation(inventoryLocation);

				}

				redirectAttributes.addFlashAttribute("success", 1);
				return "redirect:/CMaster.do";
			} catch (Exception e) {
				System.out.println(e);
				redirectAttributes.addFlashAttribute("success", 0);
			}
		}
		return "redirect:/CMaster.do";
	}

	// setCountry
	@RequestMapping(value = "/getCountry", method = RequestMethod.GET)
	public @ResponseBody List<CountryMaster> loadCountry(@RequestParam String cid) {
		List<CountryMaster> country = centerService.setCountry(cid);
		return country;
	}

	@ModelAttribute("center")
	public List<CenterTypes> getCenterType() {
		List<CenterTypes> b1 = centerService.listcenters();
		return b1;
	}

	@ModelAttribute("centerMasterlist")
	public List<CenterMaster> getAllDetails() {
		List<CenterMaster> cMaster = centerService.listAll();
		return cMaster;
	}

	@ModelAttribute("country")
	public List<CountryMaster> getAllCountryDetails() {
		java.util.List<CountryMaster> countrylist = centerService.getClistAll();

		return countrylist;
	}

	@ModelAttribute("business")
	public List<BusinessPartner> getAllPatners() {
		java.util.List<BusinessPartner> b = centerService.getBusinesslistAll();

		return b;
	}

	@ModelAttribute("cType")
	public List<CenterTypes> getAllCType() {
		List<CenterTypes> ct = centerService.getAllCTypes();
		return ct;
	}

	@ModelAttribute("eqType")
	public List<EquipmentType> getp() {
		List<EquipmentType> eq = centerService.getEqAll();
		return eq;
	}

	@ModelAttribute("lanelist")
	public List<TestLane> getlaneist() {
		List<TestLane> lanelistD = centerService.getLaneListDetails();
		return lanelistD;
	}

	@ModelAttribute("EqMake")
	public List<EquipmentMake> listOfEqMake() {
		List<EquipmentMake> listOfEQ = centerService.getListOfEQMakeList();
		return listOfEQ;
	}

	@ModelAttribute("Eqmodel")
	public List<EquipmentModel> getListOFEQModel() {
		List<EquipmentModel> listEQMake = centerService.getListOFEQModelList();
		return listEQMake;
	}

	@ModelAttribute("userlist")
	public List<Users> getListOFUsers() {
		List<Users> llistOFUsers = centerService.getUserListD();
		return llistOFUsers;
	}

	@ModelAttribute("EQMaster")
	public List<EquipmentMaster> getListOfEQMaster() {
		List<EquipmentMaster> getEQMaster = centerService.getListOFEQMaster();
		return getEQMaster;
	}

	@RequestMapping("/updateTestDInfo")
	public ModelAndView editTestDetailsInfo(@RequestParam String testLaneDetails) {
		ModelAndView mav = new ModelAndView("TestLaneDetails");
		TestLaneDetails tt = centerService.getTestLaneDetailsBYID(testLaneDetails);
		mav.addObject("TestLaneDetails", tt);
		return mav;
	}

	@RequestMapping("/testTYPE")
	public String getTestType(Map<String, Object> model) {
		Test_type ttype = new Test_type();

		List<Test_type> testTypeList = centerService.getTest_typedetails();

		model.put("test_type", ttype);
		model.put("testTypeList", testTypeList);

		return "test_type";
	}

	@RequestMapping(value = "/testTypeAction", method = RequestMethod.POST)
	public String saveItems(@Valid @ModelAttribute("test_type") Test_type testType, BindingResult br,
			RedirectAttributes redirectAttributes) {

		if (br.hasErrors()) {
			return "test_type";
		} else {
			try {
				centerService.saveTestType(testType);
				redirectAttributes.addFlashAttribute("success", 1);
				return "redirect:/testTYPE";
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("success", 0);
			}
		}

		return "test_type";
	}

	@RequestMapping("/updatetestTypeInfo")
	public ModelAndView editTestTypeInfo(@RequestParam String typeId) {

		ModelAndView mav = new ModelAndView("test_type");
		Test_type tt = centerService.getTesttypeDetailsBYID(typeId);
		mav.addObject("test_type", tt);
		return mav;
	}

	// test category
	@RequestMapping(value = "/testCategory", method = RequestMethod.GET)
	public String loadCategoryPage(Model m) {

		TestCategory testCat = new TestCategory();
		testCat.setCategoryId("0000".substring(centerService.getCategoryId().length()) + centerService.getCategoryId());
		m.addAttribute("testCategory", testCat);
		return "testCategory";
	}

	@RequestMapping(value = "/saveTestCategory", method = RequestMethod.POST)
	public String saveCategory(@Valid @ModelAttribute("testCategory") TestCategory tc, BindingResult br,
			RedirectAttributes redirectAttributes) {
		if (br.hasErrors()) {
			return "testCategory";
		} else {
			Long ncategoryFee = StringFormaterWeb.rupeesToLong(String.valueOf(tc.getCategoryFee()));
			tc.setCategoryFee(ncategoryFee);
			// VisualProfile vp=new VisualProfile();
			// vp.setVisualProfileID("0001");

			// tc.setViProfileId(vp);
			try {
				centerService.savecategory(tc);
				redirectAttributes.addFlashAttribute("success", 1);
				return "redirect:/testCategory";
			} catch (Exception e) {
				// TODO: handle exception
				redirectAttributes.addFlashAttribute("success", 0);
				System.out.println(e);
			}
		}
		return "testCategory";

	}

	@ModelAttribute("cCategory")
	public List<TestCategory> getAllCategory() {
		List<TestCategory> tc = centerService.getAll();
		return tc;
	}

	@ModelAttribute("countryM")
	public List<CountryMaster> getAllCountries() {
		List<CountryMaster> country = rService.getAll();
		return country;
	}

	@RequestMapping(value = "/editDetails", method = RequestMethod.GET)
	public ModelAndView editCategory(@RequestParam String id) {

		ModelAndView mav = new ModelAndView("testCategory");
		TestCategory tc = centerService.getCategoryId(id);

		// String testFee = StringFormaterWeb.formatToRupees(tc.getCategoryFee());
		tc.setCategoryFee(tc.getCategoryFee() / 100);

		mav.addObject("testCategory", tc);
		// mav.addObject("testfee", testFee);

		return mav;
	}

	// Return all test profiles
	@ModelAttribute("testProfiles")
	public List<TestProfile> getAllTestProfiles() {

		List<TestProfile> tp = service.listAllProfiles();
		return tp;
	}

	// Return all vi profiles
	@ModelAttribute("profileNames")
	public List<VisualProfile> getProfiles() {

		List<VisualProfile> pro = insService.listProfiles();
		return pro;
	}
}
