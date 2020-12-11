package com.navitsa.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.navitsa.Reports.AnalysisReportBeen;
import com.navitsa.Reports.IncomingReceiptBeen;
import com.navitsa.Reports.IncomingReceiptSummaryBeen;
import com.navitsa.Reports.InvoiceSummaryReportBeen;
import com.navitsa.Reports.NumberDataBeen;
import com.navitsa.Reports.RevenueStatementBeen;
import com.navitsa.Reports.VehicleInvoiceBeen;
import com.navitsa.Reports.VehicleReceiptBeen;
import com.navitsa.Reports.VehicleReportByDateBeen;
import com.navitsa.entity.Appointment;
import com.navitsa.entity.BusinessPartner;
import com.navitsa.entity.CenterMaster;
import com.navitsa.entity.ConfigSystem;
import com.navitsa.entity.CountryMaster;
import com.navitsa.entity.CountryState;
import com.navitsa.entity.Customer;
import com.navitsa.entity.Document;
import com.navitsa.entity.DocumentCheckDetails;
import com.navitsa.entity.DocumentCheckHead;
import com.navitsa.entity.EquipmentType;
import com.navitsa.entity.FuelType;
import com.navitsa.entity.IncomingReceiptDetails;
import com.navitsa.entity.IncomingReceiptHead;
import com.navitsa.entity.InvoiceDetails;
import com.navitsa.entity.InvoiceHead;
import com.navitsa.entity.OcrDetails;
import com.navitsa.entity.ReceiptDetails;
import com.navitsa.entity.ReceiptHead;
import com.navitsa.entity.TaxConfiguration;
import com.navitsa.entity.TestCategory;
import com.navitsa.entity.TestLane;
import com.navitsa.entity.TestLaneDetails;
import com.navitsa.entity.TestLaneHead;
import com.navitsa.entity.Transaction;
import com.navitsa.entity.Users;
import com.navitsa.entity.VehicalWmi;
import com.navitsa.entity.VehicleCategory;
import com.navitsa.entity.VehicleClass;
import com.navitsa.entity.VehicleMake;
import com.navitsa.entity.VehicleMaster;
import com.navitsa.entity.VehicleModel;
import com.navitsa.entity.VehicleOwner;
import com.navitsa.entity.VehicleRegisterType;
import com.navitsa.entity.VehicleRegistration;
import com.navitsa.entity.VehiclesSubCategory;
import com.navitsa.services.AppointmentService;
import com.navitsa.services.BusinessPartnerService;
import com.navitsa.services.CenterService;
import com.navitsa.services.DocumentScrvice;
import com.navitsa.services.LaneServices;
import com.navitsa.services.RegionalService;
import com.navitsa.services.TestValueFileService;
import com.navitsa.services.TransactionServive;
import com.navitsa.services.UsersService;
import com.navitsa.services.VehicleService;
import com.navitsa.utils.DateHelperWeb;
import com.navitsa.utils.EnglishNumberToWords;
import com.navitsa.utils.FTPUploader;
import com.navitsa.utils.ReportViewe;
import com.navitsa.utils.StringFormaterWeb;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;

import org.apache.log4j.Logger;


@Transactional(rollbackFor=Exception.class)
@Controller
public class VehicleController {

	private Logger logger = Logger.getLogger(VehicleController.class);
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	RegionalService regionalService;
	
	@Autowired
	TransactionServive transactionservice;
	
	@Autowired
	CenterService centerService;
	
	@Autowired
	LaneServices laneServices;
	
	@Autowired
	BusinessPartnerService businessPartnerService;
	
	@Autowired
	UsersService usersService;	
	
	@Autowired
	AppointmentService appointmentService;
	
	@Autowired
	DocumentScrvice documentScrvice;
	
	@Autowired
	private TestValueFileService testValueFileServices;

	
	@ModelAttribute("statusMap")
	public Map<String, String> getCountryList() {
		Map<String, String> countryList = new HashMap<String, String>();
		countryList.put("ACTIVE", "ACTIVE");
		countryList.put("INACTIVE", "INACTIVE");

		return countryList;
	}

	@RequestMapping(value = "/savevmodel", method = RequestMethod.POST)
	public String saveModel(@Valid @ModelAttribute("vehicleModelForm") VehicleModel vehicleModel, 
							BindingResult br,RedirectAttributes redirectAttributes)throws IOException{

			if(br.hasErrors()) {
				return "vehicleModelForm";
			} else {
				try {
					vehicleService.saveVModel(vehicleModel);
					redirectAttributes.addFlashAttribute("success", 1);
					return "redirect:/vehiclemodel1";
	        	}catch (Exception e) {
					// TODO: handle exception
	        		redirectAttributes.addFlashAttribute("success", 0);
				}
				
				return "vehicleModelForm";
			}
	}
	
	@RequestMapping(value = "/savevmodelFormModel", method = RequestMethod.POST)
	public @ResponseBody String saveVModelFormModel(@RequestParam String vehicleMakeID,@RequestParam String vehicleClassID,@RequestParam String vehicleModel,@RequestParam MultipartFile modelLogo){

		VehicleModel vModel=new VehicleModel();
		try {
		vModel.setVehicleModelID("0000".substring(vehicleService.maxModelID().length()) + vehicleService.maxModelID());
		VehicleMake vm=new VehicleMake();
		vm.setVehicleMakeID(vehicleMakeID);		
		
		vModel.setVehicleMakeID(vm);
		
		VehicleClass vc=new VehicleClass();
		vc.setVehicleClassID(vehicleClassID);
		
		vModel.setVehicleClass(vc);
		vModel.setVehicleModel(vehicleModel);
		vModel.setModelLogo(modelLogo);
		vModel.setStatus("ACTIVE");
		
			vehicleService.saveVModel(vModel);
		//	redirectAttributes.addFlashAttribute("success", 1);
			return "1";
    	}catch (Exception e) {
			// TODO: handle exception
    		return "0";
    		//redirectAttributes.addFlashAttribute("success", 0);
		}
		 
		 
		 
		// return "";

	}
	
	
	
	
	
	@ModelAttribute("statusMap")
	public Map<String, String> getMakeList() {
		Map<String, String> makeList = new HashMap<String, String>();
		makeList.put("ACTIVE", "ACTIVE");
		makeList.put("INACTIVE", "INACTIVE");
		return makeList;
	}
	
	@RequestMapping(value = "/vehiclemodel1", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		
		VehicleModel vmodel = new VehicleModel();
		vmodel.setVehicleModelID("0000".substring(vehicleService.maxModelID().length()) + vehicleService.maxModelID());
		map.put("vehicleModelForm", vmodel);
		
		//List <VehicleModel> vModelList = vehicleService.getVModel();
		//map.put("vModelList", vModelList);
			
		return "vehicleModelForm";
	}
	
	@ModelAttribute("vmake")
	public List<VehicleMake> getVmak(){
		List <VehicleMake> vlist = vehicleService.getActiveMakes();
		return vlist;
	}
	
	@ModelAttribute("vModelList")
	public List<VehicleModel> getAllModel() {
		List<VehicleModel> models = vehicleService.getVModel();
		return models;
	}
	
	@RequestMapping(value="/updateVinfo") 
	public ModelAndView editTestVInfo(@RequestParam String vehicleModelID) {	
		
			
			ModelAndView mav = new ModelAndView("vehicleModelForm");
			VehicleModel vehicleModelForm = null;;
			
			try {
				vehicleModelForm = vehicleService.getVmodelDetailsByID(vehicleModelID);
				
				 mav.addObject("vehicleModelForm", vehicleModelForm);
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
			try {
				String vMakeLogo = vehicleModelForm.getVehicleMakeID().getMakeLogoView();
				String vModelLogo = vehicleModelForm.getModelLogoView();
				
				mav.addObject("vMakeLogo", vMakeLogo);
				mav.addObject("vMLogo", vModelLogo);
			}catch(Exception e) {
				System.out.println(e);
			}
			return mav;
		}

	

	
	
	// save lane reg type data
	@RequestMapping(value = "/saveVRegTypes", method = RequestMethod.POST)
	public String saveVregType(@Valid @ModelAttribute("vehicleRegisterType") VehicleRegisterType vehicleRegisterType,
			BindingResult br,RedirectAttributes redirectAttributes) {
		
		if (br.hasErrors()) {
			return "vehicleRegTypes";
		} else {

			try {
				
				vehicleService.saveVRegType(vehicleRegisterType);
				redirectAttributes.addFlashAttribute("success", 1);
				return "redirect:/vehicleRegTypes.do";
				
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("success", 1);
			}

		}
		
		return "vehicleRegTypes";
	}

	// load form of lane reg type
	@RequestMapping( value = "/vehicleRegTypes", method = RequestMethod.GET)
	public String listVRegType(Map<String, Object> map) {
		
		VehicleRegisterType vehicleRegisterType=new VehicleRegisterType();
		Long defaultValue=Long.parseLong("100");	
		vehicleRegisterType.setvTestFeePre(defaultValue);
		vehicleRegisterType.setvRegTypeID("0000".substring(vehicleService.maxTypeID().length()) + vehicleService.maxTypeID());
		map.put("vehicleRegisterType", vehicleRegisterType);

		return "vehicleRegTypes";
	}

	// delete v reg type
	@RequestMapping("/deleteVRegType")
	public String deleteVRegType(@PathVariable("id") String id) {
		this.vehicleService.deleteVRegType(id);
		return "redirect:/vehicleRegTypes.do";
	}
	
	@ModelAttribute("types")
	public List<VehicleRegisterType> getAllTypes() {
		List<VehicleRegisterType> types = vehicleService.getAllVType();
		return types;
	}

//	update v reg type
	@RequestMapping("/editVRegType")
	public ModelAndView updateVehicleRegType(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("vehicleRegTypes");
		VehicleRegisterType vRType = vehicleService.getRegType(id);
		mav.addObject("vehicleRegisterType", vRType);
		return mav;
	}

	@RequestMapping(value = "/saveVClass", method = RequestMethod.POST)
	public String saveVehicleClass(@Valid @ModelAttribute("saveVClass") VehicleClass vc, BindingResult br,
			RedirectAttributes redirectAttributes) {

		if (br.hasErrors()) {
			return "vehicleClass";
		} else {

			try {
				vehicleService.saveVClass(vc);
				redirectAttributes.addFlashAttribute("success", 1);
				return "redirect:/vehicleClasss.do";
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("success", 0);
			}
		}

		return "vehicleClass";

	}

	@RequestMapping(value = "/vehicleClasss", method = RequestMethod.GET)
	public String VehicleClasslist(Map<String, Object> map) {

		VehicleClass vClass = new VehicleClass();
		vClass.setVehicleClassID("0000".substring(vehicleService.maxVClassID().length()) + vehicleService.maxVClassID());
		map.put("saveVClass", vClass);
		List<VehicleClass> listVehicleClass = vehicleService.getVClass();
		map.put("listVehicleClass", listVehicleClass);
		return "vehicleClass";
	}
	
	@RequestMapping("/editClass")
	public ModelAndView editVehicleClass(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("vehicleClass");
		VehicleClass ps = vehicleService.getVClassById(id);
		mav.addObject("saveVClass", ps);
		return mav;
	}
	
	@ModelAttribute("listVehicleClass") 
	public List<VehicleClass> getAllvclass() {
		List<VehicleClass> vClass = vehicleService.getVClass();
		return vClass;
	}

	//getting vehicle make details for table 
	 @ModelAttribute("makeList")
	 	public List<VehicleMake> getMakes(){
		 
		 List<VehicleMake> a = vehicleService.getMakelistAll();
		 return a;
	 }
	 
	 // load vehicle make UI with auto increment ID
	@RequestMapping(value = "/vehicleMake", method = RequestMethod.GET)
	public String VehicleMakeist(Map<String, Object> map) {
		try {
			
			VehicleMake vm = new VehicleMake();
			String vmid = vehicleService.maxVMakeID();
			vm.setVehicleMakeID("0000".substring(vmid.length())+vmid);
			map.put("VMakeForm",vm);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "vehicleMake";
	}
	
	// Save vehicle make data
	@RequestMapping(value = "/saveVMake", method = RequestMethod.POST)
	public String saveVehicleMake(@Valid @ModelAttribute("VMakeForm") VehicleMake vm,BindingResult br,
			RedirectAttributes redirectAttributes){

		 if(br.hasErrors()) 
		 {
			 return "vehicleMake";
		 }else {
			 
			 try {

				vehicleService.saveVMake(vm);
				redirectAttributes.addFlashAttribute("success", 1);
				return "redirect:/vehicleMake.do";
				
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("success", 0);
			}
			 
		 }
		 
		 return "vehicleMake";

	}
	// Save vehicle make data
	@RequestMapping(value = "/saveVMakeModelForm", method = RequestMethod.POST)
	public  @ResponseBody  String saveVMakeModelForm(@RequestParam String vehicleMake,@RequestParam MultipartFile makeLogo,@RequestParam String remark){

		String vmid = vehicleService.maxVMakeID();
	
		 try {
		VehicleMake vMake=new VehicleMake();
		vMake.setVehicleMake(vehicleMake);
		vMake.setVehicleMakeID("0000".substring(vmid.length())+vmid);
		vMake.setMakeLogo(makeLogo);
		
		vMake.setRemark(remark);
		vMake.setStatus("Active");
			

				vehicleService.saveVMake(vMake);
			
				return "1";
				
			} catch (Exception e) {
				return "0";
			}
			 
		 
		 
		// return "";

	}
	// getting vehicle make data for edit purpose
	@RequestMapping("/editMake")
	public ModelAndView editVehicleMake(@RequestParam String id) {

		ModelAndView mav = new ModelAndView("vehicleMake");
		VehicleMake vm = null;

		try {

			vm = vehicleService.getVMakeById(id);
			mav.addObject("VMakeForm", vm);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("******Null value passing error of editMake in V Con*****");
		}

		try {

			String vmLogo = vm.getMakeLogoView();
			mav.addObject("makeImg", vmLogo);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("****Null value passing error of editMake in V Con*****");
		}

		return mav;
	}
	
	//getting all records for vehicle master table ** this method not use 
	@ModelAttribute("masterList")
	public List<VehicleMaster> getVMList(){
		List <VehicleMaster> VMlist = vehicleService.getVehicleMasterAllDetail();
		return VMlist;
	}
	
	@RequestMapping("/vehicleMaster")
	public ModelAndView logVehicleMaster(HttpSession session) {
		ModelAndView mav = new ModelAndView("vehicleMaster");
		
 
		mav.addObject("saveVMaster", new VehicleMaster());
		mav.addObject("veOwner", new VehicleOwner());	
		//OcrDetails ocrDetails=vehicleService.getOcrDetailsById(Integer.parseInt(id));
		//ocrDetails.setOcrVid(vehicleID);		
		//vehicleService.saveOcrDetailsRepo(ocrDetails);
//		if(!appNo.equals("0")) {
//			Appointment appointment=new Appointment();
//			appointment=appointmentService.getAppointmentDetailsById(appNo);
//			appointment.setStatus("completed");
//			appointmentService.save(appointment);
//		}
		return mav;
		}
	
	
	@RequestMapping("/vehicleMasterAuto")
	public ModelAndView logVehicleMaster(@RequestParam String vehicleID,@RequestParam String id,HttpSession session) {
		ModelAndView mav = new ModelAndView("vehicleMaster");
		
		OcrDetails ocrDetails=vehicleService.getOcrDetailsById(Integer.parseInt(id));
		//ocrDetails.setOcrVid(vehicleID);		
		//vehicleService.saveOcrDetailsRepo(ocrDetails);
		String appNo=ocrDetails.getAppNo();
		
		if(!appNo.equals("0")) {
			Appointment appointment=new Appointment();
			appointment=appointmentService.getAppointmentDetailsById(appNo);
			appointment.setStatus("completed");
			appointmentService.save(appointment);
		}
		

		
		
		mav.addObject("imgVe",ocrDetails.getNoimageView());
		mav.addObject("ocid",id);
		mav.addObject("milage",ocrDetails.getCurrentMilage());
		VehicleMaster vm=new VehicleMaster();
		
		
		if(vehicleService.getVMasterById(vehicleID)!=null) {
			vm = vehicleService.getVMasterById(vehicleID);
			System.out.println("not null value v master= "+vm);
		}
		
		List<VehicleOwner> pre_owners = vehicleService.getOwnersByVehicleNo(vehicleID);

		mav.addObject("pre_owners", pre_owners);
		
		mav.addObject("saveVMaster", vm);
		VehicleOwner vo=vehicleService.getVehicleOwnerIDByVehicleID(vehicleID);
		List<CountryState> counState = centerService.getallStateFromCountry(session.getAttribute("countryCode")+"");
		mav.addObject("counState", counState);
		if(vo==null) {
			mav.addObject("veOwner", new VehicleOwner());	
		}else {
		mav.addObject("veOwner", vo);
		}
		//session.setAttribute("vMvid", vehicleID);
		

		mav.addObject("vidn",vehicleID);
		mav.addObject("vid",vehicleID);
		return mav;
	}

	// Saving V Master Info	
	 @RequestMapping(value="/saveVMasterk", method = RequestMethod.POST)
	 public String saveVehicleMaster(@Valid @ModelAttribute("saveVMaster") VehicleMaster vmaster,@ModelAttribute("veOwner")VehicleOwner vehicleOwner,BindingResult br,Model m,@RequestParam String currentMilage,@RequestParam String ocid,HttpSession session) {		

		 if(br.hasErrors())
		 {
			 return "vehicleMaster";
		 }
		 else {
			 try {
				  String centerid=session.getAttribute("centerid")+"";
				  CenterMaster centerMaster=centerService.getcenterById(centerid);
				 
				vehicleService.saveVMaster(vmaster);				
				vehicleOwner.setVehicleID(vmaster);
				vehicleOwner.setCountryCode(centerMaster.getCountrycode());
				vehicleOwner.setStatus("currentOwner");
				
				if(vehicleOwner.getOwnerID().length()<1){
					vehicleOwner.setOwnerID("0000".substring(vehicleService.maxVOwnerID().length()) + vehicleService.maxVOwnerID());
					vehicleService.saveVOwner(vehicleOwner);
					vehicleService.updateOwnerStatus(vehicleOwner.getOwnerID(), vehicleOwner.getVehicleID().getVehicleID());
				
				}else {
					vehicleService.saveVOwner(vehicleOwner);	
					
				}
				
				OcrDetails ocrDetails=vehicleService.getOcrDetailsById(Integer.parseInt(ocid));
				ocrDetails.setVmStatus("completed");
				ocrDetails.setCurrentMilage(Long.parseLong(currentMilage));
				vehicleService.saveOcrDetailsRepo(ocrDetails);
				
				return "redirect:/vehicleRegistrationAuto?vid="+vmaster.getVehicleID()+"&id="+ocid; 
		
	 
				//return "redirect:/checkDocumentAuto?vecNo="+vmaster.getVehicleID()+"&curMi="+currentMilage+"&id="+ocid; 
				
				
			 
			 
				
			 
			 } catch (Exception e) {
				// TODO: handle exception
				System.out.println("vehicle master saving error");
				m.addAttribute("error","A vehicle already saved by using this Engine No or Chassis No");
				
			}
		 }
		 return "vehicleMaster";
	 }

	//Edit V Master detail
	@RequestMapping(value="/newVehicleMaster",method = RequestMethod.GET)
	public ModelAndView newVehicleMaster(@RequestParam String vehicleID,@RequestParam String id,HttpSession session) {
		    
		OcrDetails ocrDetails=vehicleService.getOcrDetailsById(Integer.parseInt(id));
		
		//ocrDetails.setOcrid(Long.parseLong(id));
		
		ocrDetails.setOcrVid(vehicleID);
				
		vehicleService.saveOcrDetailsRepo(ocrDetails);
	    
		session.setAttribute("vMvid", vehicleID);
		
		ModelAndView mav = new ModelAndView("vehicleMaster");
		VehicleMaster vm=new VehicleMaster();
		VehicleOwner vo=new VehicleOwner();
		vm.setVehicleID(vehicleID);
		vo.setVehicleID(vm);
		List<CountryState> counState = centerService.getallStateFromCountry(session.getAttribute("countryCode")+"");
		mav.addObject("counState", counState);
		mav.addObject("saveVMaster", vm);
		mav.addObject("veOwner", vo);
		mav.addObject("imgVe",ocrDetails.getNoimageView());
		mav.addObject("ocid",id);
		mav.addObject("vidn",vehicleID);
		mav.addObject("vid",vehicleID);
	
		return mav;
		
	}
	
	// save owner
	@RequestMapping(value = "/saveVOwner", method = RequestMethod.POST)
	public String saveVehicleOwner(@Valid @ModelAttribute("veOwner")VehicleOwner vehicleOwner,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "vehicleOwner";
		} 
		else 
		{
			if(vehicleOwner.getOwnerID().isEmpty())
			{
				vehicleOwner.setOwnerID("0000".substring(vehicleService.maxVOwnerID().length()) + vehicleService.maxVOwnerID());
			}
			
			vehicleService.saveVOwner(vehicleOwner);
			
			vehicleService.updateOwnerStatus(vehicleOwner.getOwnerID(), vehicleOwner.getVehicleID().getVehicleID());
			
			return "redirect:/vehicleRegistration?vid="+vehicleOwner.getVehicleID().getVehicleID();
		}
	}
	 
	
	@ModelAttribute("couCode")
	public List<CountryMaster> countryList() {
		List<CountryMaster> c = regionalService.getAll();
		return c;
	}
	
	
	@ModelAttribute("veMake")
	public List<VehicleMake> getAllMakeDetails() {
		List<VehicleMake> makedrop = vehicleService.getActiveMakes();
		return makedrop;
	}

	@ModelAttribute("vemodel")
	public List<VehicleModel> getAllModelDetails() {
		List<VehicleModel> makedrop = vehicleService.getVModel();
		return makedrop;
	}

	@ModelAttribute("fuelType")
	public List<FuelType> getAllFualDetails() {
	List<FuelType> makedrop = vehicleService.getFuelType();
	return makedrop;
	}
	
	@ModelAttribute("veclass")
	public List<VehicleClass> getAllClassDetails() {
		List<VehicleClass> makedrop = vehicleService.getVClass();
		return makedrop;
	}
	@RequestMapping("/vehicleRegistration")
	public String getREG(Model m,HttpSession session) {
		//OcrDetails ocrDetails=vehicleService.getOcrDetailsById(Integer.parseInt(id));
		//ocrDetails.setOcrid(Long.parseLong(id));
		VehicleRegistration vecir=new VehicleRegistration();
	//	vecir.setOcrid(ocrDetails);
	//	VehicleMaster vm=vehicleService.getVMasterById(vid);
		//vm.setVehicleID(vid);
		//vecir.setVid(vm);
		
		//vecir.setCurrentMilage(Long.parseLong(curMi));
		m.addAttribute("VehicleRegistration",vecir);
	//	m.addAttribute("imgVimg",ocrDetails.getNoimageView());
		
		
	//	m.addAttribute("pre_vehicle",vehicleService.getPerviousRegistrationVehicle(vid));
	//	m.addAttribute("vclassid",vm.getVmodel().getVehicleClass().getVehicleClassID());
		
		
		List<TestLaneHead> allCenterLane=laneServices.getTestLaneHeadDetailByCenter(session.getAttribute("centerid")+"");
		m.addAttribute("allLane",allCenterLane);
	 
	 
		return "VehicleRegistration";
	}
	//////////////REGISTRATION///////
	@RequestMapping("/vehicleRegistrationAuto")
	public String getREG(Model m,@RequestParam String vid,@RequestParam String id,HttpSession session) {
		OcrDetails ocrDetails=vehicleService.getOcrDetailsById(Integer.parseInt(id));
		VehicleRegistration vecir=new VehicleRegistration();
		if(!ocrDetails.getAppNo().equals("0")) {
			System.out.println("dfdf="+ocrDetails.getAppNo());
		Appointment appointment=appointmentService.getAppointmentDetailsById(ocrDetails.getAppNo());
		vecir.setTestCategory(appointment.getCategoryId());
		
		m.addAttribute("apoTime",appointment.getAppointmentTime());
		}
		m.addAttribute("apono",ocrDetails.getAppNo());
		//ocrDetails.setOcrid(Long.parseLong(id));

		ocrDetails.setVmStatus("completed");
		vehicleService.saveOcrDetailsRepo(ocrDetails);
		
		vecir.setOcrid(ocrDetails);
		VehicleMaster vm=vehicleService.getVMasterById(vid);
		//vm.setVehicleID(vid);
		vecir.setVid(vm);	
		vecir.setCurrentMilage(ocrDetails.getCurrentMilage());
		
		m.addAttribute("vid",vid);
		m.addAttribute("VehicleRegistration",vecir);
		m.addAttribute("imgVimg",ocrDetails.getNoimageView());
		m.addAttribute("pre_vehicle",vehicleService.getPerviousRegistrationVehicle(vid));
		m.addAttribute("vclassid",vm.getVmodel().getVehicleClass().getVehicleClassID());
		
		
	
		session.setAttribute("vRocr", id);

		m.addAttribute("ocid",id);
		m.addAttribute("vvid",vid);
		
		List<TestLaneHead> allCenterLane=laneServices.getTestLaneHeadDetailByCenter(session.getAttribute("centerid")+"");
		m.addAttribute("allLane",allCenterLane);
	 
	 
		return "VehicleRegistration";
	}

	@ModelAttribute("transactionList")
	public List<Transaction> getTransaction(){
		List <Transaction> vreg =vehicleService.listTransaction();
		return vreg;
	}
	
	@ModelAttribute("vehicleList")
	public List<VehicleMaster> getVehicleMasterList(){
		List <VehicleMaster> vlist= vehicleService.getVehicleMasterAllDetail();
		return vlist;
	}
	
	@ModelAttribute("regTypeList")
	public List<VehicleRegisterType> getVregType(){
		List <VehicleRegisterType> list= vehicleService.getAllVType();
		return list;
	}
	
	@ModelAttribute("regUsers")
	public List<Users> getUser(){
		List <Users> ulist=  vehicleService.userList();
		return ulist;
	}
	@ModelAttribute("centerList")
	public List<CenterMaster> getCenterList(){
		List <CenterMaster> clist= vehicleService.centerMasterList();
		return clist;
	}
	@ModelAttribute("BusinessPartnerList")
	public List <BusinessPartner> getPartnerList(){
		List <BusinessPartner> blist =  vehicleService.businessPartnerList();
		return blist;
	}
	@ModelAttribute("testlane")
	public List <TestLane> getTestDetails(){
		List <TestLane> tlane = vehicleService.testlaneDetails();
		return tlane;
	}
	
	
	//get data for combo in vmodel interface
	@RequestMapping(value="/getImageForCombo", method=RequestMethod.GET)
	public @ResponseBody String search(@RequestParam String vmake) {
		VehicleMake listlogs = vehicleService.searchlogomake(vmake);
		return listlogs.getMakeLogoView();
	}
	//editTestlaneDetailsComboTable
	@RequestMapping("/updateTDInfo")
	public ModelAndView editTestDetailsInfo(@RequestParam String testLaneDetails) {
		ModelAndView mav = new ModelAndView("TestLaneDetails");
		TestLaneDetails tt = centerService.getTestLaneDetailsBYID(testLaneDetails);
		mav.addObject("TestLaneDetails", tt);
		return mav;
	}
	
	//get lanes according to centers in vreg. jsp
	@RequestMapping(value="/getLanesifOneLane", method=RequestMethod.GET)
	public @ResponseBody String[][] searchlane(@RequestParam String center) {
		String[][] listlogs =laneServices.getLaneForLaneDetails(center);
	
			return listlogs;
	}
	
	@RequestMapping(value="/getLanesifmorLane", method=RequestMethod.GET)
	public @ResponseBody String[][] getLanesifmorLane(@RequestParam String center,@RequestParam String veClassId) {
		String[][] listlogs =laneServices.getLanesifmorLane(center,veClassId);
	
			return listlogs;
	}
	
	@RequestMapping(value="/getLanesifmorLaneCat", method=RequestMethod.GET)
	public @ResponseBody String[][] getLanesifmorLaneCat(@RequestParam String center,@RequestParam String veClassId,@RequestParam String testCat) {
		String[][] listlogs =laneServices.getLanesifmorLaneCat(center,veClassId,testCat);
	
			return listlogs;
	}
	

	//load testlane combo table to vehicle registration jsp
	@RequestMapping(value="/getLaneDtails", method=RequestMethod.GET)
	public   @ResponseBody List<TestLaneDetails> comboTable(@RequestParam String testLaneDetailsid ) {
		List<TestLaneDetails> test1 = vehicleService.searchLaneDEtails(testLaneDetailsid);
		return test1;
	}
	@RequestMapping("/laneEntryView")
	public String getLaneEntryView(Model m,HttpSession session) {
	
		VehicleRegistration vecir=new VehicleRegistration();

	//	String vid=ocrDetails.getOcrVid();
		m.addAttribute("VehicleRegistration",vecir);

		
		return "LaneEntryView";
	}
	@RequestMapping(value="/getPerviousVehicleRegistation" ,method=RequestMethod.POST)
	public @ResponseBody List<VehicleRegistration> getVehicleRegistation(@RequestParam String veno) {
		return vehicleService.getPerviousRegistrationVehicle(veno);
		
	
	}
	@RequestMapping(value="/getVehicleRegistation" ,method=RequestMethod.POST)
	public @ResponseBody VehicleRegistration getVehicleRegistation(@RequestParam int ocrid) {
		return vehicleService.getRegistrationVehicleByOcrid(ocrid);
		
	
	}
	@RequestMapping(value="/pendingLaneEntryData" ,method=RequestMethod.POST)
	public @ResponseBody List<OcrDetails> getPendingLaneEntryData() {
		return vehicleService.pendingLaneEntryData();
		
	
	}
	@RequestMapping("/LaneEntry")
	public String getLaneEntry(Model m,@RequestParam String id,HttpSession session) {
		OcrDetails ocrDetails=vehicleService.getOcrDetailsById(Integer.parseInt(id));
		VehicleRegistration vecir=vehicleService.getRegistrationVehicleByOcrid(ocrDetails.getOcrid());

		String vid=ocrDetails.getOcrVid();
		m.addAttribute("VehicleRegistration",vecir);
		if(vecir.getCusid().getId()=="0000") {
			m.addAttribute("custom","Owner");
		}else {
			m.addAttribute("custom",vecir.getCusid().getName());	
		}
		m.addAttribute("imgVimg",ocrDetails.getNoimageView());
	 	m.addAttribute("pre_vehicle",vehicleService.getPerviousRegistrationVehicle(vid));

		
		m.addAttribute("vehNo",vid);
		m.addAttribute("ocid",id);
	

	 

		return "LaneEntry";
	}
		
	@RequestMapping(value="/saveLaneEntry" ,method=RequestMethod.POST)
	public @ResponseBody String saveVehicleRegistration(@RequestParam String vregno,HttpSession session) {
	
        	try {
        		
        		VehicleRegistration vehiclereg=vehicleService.getRegistrationByRegisterId(vregno);
        		CenterMaster centerMaster=centerService.getcenterById(vehiclereg.getCentermaster().getCenter_ID());
	        	
        		VehicleMaster vehicleMaster = vehicleService.getVMasterById(vehiclereg.getVid().getVehicleID());
        		
        		String checkTextFilePath=centerMaster.getEsInPath();
	            String checkXmlFilePath=centerMaster.getEsInXmlPath();
	        	File texEsin = new File(checkTextFilePath);  
	        	File xmlEsin = new File(checkXmlFilePath);  		
	        	OcrDetails ocrDetails=vehicleService.getOcrDetailsById(vehiclereg.getOcrid().getOcrid());
	        	
	        	
	        	
	        	if (session.getAttribute("username")==null) {
	        		return "1";	
	        	}else if (ocrDetails.getNoimage().length==0) {
        			return "2";  	 
	        	}else if (!texEsin.isDirectory()) {
        			return "3";  	 
	        	}else if (!xmlEsin.isDirectory()) {
        			return "4";  	 
	        	}else if (ocrDetails.getVrStatus().equals("completed")) {
        			return "5";  	 
	        	}else {
	        		
	        		List<ConfigSystem> configSystem=vehicleService.getConfigSystemByCenter(vehiclereg.getCentermaster().getCenter_ID(),vehiclereg.getTestLaneHeadId().getTestLaneHeadId());	
	                 
	                boolean correct=false;
	                String hostname="";
	                String username="";
	                String password="";
	                String rootpath="";
	                String xmlPath="";
	                InetAddress inet = null;
	        		
	                for(ConfigSystem conSys:configSystem) {
	                     inet = InetAddress.getByName(hostname);
	                     if(inet.isReachable(0)==true) {
	                    	 correct=true; 
	                     }else {
	                    	 correct=false; 
	                    	 break;
	                     }

	                }
	                if((configSystem.size()==0)) {
	                 	correct=true;
	                 }
	                if(correct) {
	                
	                	Users user=usersService.searchUser(vehiclereg.getUser().getUserId());
	                	
	                	
						String path1 = this.getClass().getClassLoader().getResource("").getPath();
						String fullPath = URLDecoder.decode(path1, "UTF-8");		
						String pathArr[] = fullPath.split("/WEB-INF/classes/");
						String textFilePath=centerMaster.getEsInPath()+"\\"+vehiclereg.getVid().getVehicleID()+".txt";
	                	
						File file = new File(textFilePath);	                	
				        if (!file.exists()) {
				           file.createNewFile();
				         }
	                	
	                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
	                    BufferedWriter bw = new BufferedWriter(fw);
	                    bw.write("[HEADER]");
		                bw.write("\r\n"); 
		                bw.write("10100="+vehiclereg.getVid().getVehicleID());
		                bw.write("\r\n"); 
		                bw.write("15012="+user.getUserName());
		                bw.write("\r\n"); 
		                bw.write("10190="+vehicleMaster.getNoWheel());	                
		                bw.write("\r\n"); 
		                bw.write("10191="+vehicleMaster.getVmodel().getVehicleClass().getCategoryID().getCategoryID());                
		                
		                
		                
		                bw.write("\r\n");
		                bw.write("\r\n");
		                bw.write("[ENDOFFILE]");
		               
		                
	                    bw.close();
				        
				        
	                    //  String xpath= pathArr[0]+"/Upload/XML_ES_IN/";	
	                   	String xmlFilePath=centerMaster.getEsInXmlPath()+"\\"+vehiclereg.getVid().getVehicleID()+".xml";
	                   	
	                   	File xmlfile = new File(xmlFilePath);
	                   	if (!xmlfile.exists()) {
	    	        	   xmlfile.createNewFile();
	    	            }
				        
	                   	FileWriter fwX = new FileWriter(xmlfile.getAbsoluteFile());
                        BufferedWriter bwx = new BufferedWriter(fwX);
                        bwx.write("<?xml version=\"1.0\"?>"
                        		+ "\r\n");
                        
                        bwx.write("<Report>"); 
                        bwx.write("\r\n"); 
                        bwx.write("<ROW num=\"Vehicle Registration No\">"
                        		+ "\r\n<CODE>10100</CODE>");
                        bwx.write("\r\n"); 
                        bwx.write("<DATA>"+vehiclereg.getVid().getVehicleID()+"</DATA>");
                        bwx.write("\r\n"); 
                        bwx.write("</ROW>");
                        bwx.write("\r\n"); 
                        
                        bwx.write("<ROW num=\"User\">"
                        		+ "\r\n<CODE>15012</CODE>");
                        bwx.write("\r\n"); 
                        bwx.write("<DATA>"+user.getUserName()+"</DATA>");
                        bwx.write("\r\n"); 
                        bwx.write("</ROW>");                       
                        bwx.write("\r\n"); 
                        
                        bwx.write("<ROW num=\"Make\">"
                        		+ "\r\n<CODE>15015</CODE>");
                        bwx.write("\r\n"); 
                        bwx.write("<DATA>"+vehicleMaster.getVmodel().getVehicleMakeID().getVehicleMake()+"</DATA>");
                        bwx.write("\r\n"); 
                        bwx.write("</ROW>");                       
                        bwx.write("\r\n"); 
                        
                        bwx.write("<ROW num=\"Model\">"
                        		+ "\r\n<CODE>15016</CODE>");
                        bwx.write("\r\n"); 
                        bwx.write("<DATA>"+vehicleMaster.getVmodel().getVehicleModel()+"</DATA>");
                        bwx.write("\r\n"); 
                        bwx.write("</ROW>");  
                        bwx.write("\r\n"); 
                        
                        bwx.write("<ROW num=\"Fuel Type\">"
                        		+ "\r\n<CODE>15017</CODE>");
                        bwx.write("\r\n"); 
                        bwx.write("<DATA>"+vehicleMaster.getFtype().getFuel()+"</DATA>");
                        bwx.write("\r\n"); 
                        bwx.write("</ROW>");  
                        bwx.write("\r\n"); 
                        
                        bwx.write("<ROW num='Engine Stroke'>"
                        		+ "<CODE>15018</CODE>");
                        bwx.write("<DATA>4 Stroke</DATA>");
                        bwx.write("</ROW>");  
                        bwx.write("\r\n"); 
       
                        bwx.write("<ROW num=\"Category\">"
                        		+ "\r\n<CODE>10191</CODE>");
                        bwx.write("\r\n"); 
                        bwx.write("<DATA>"+vehicleMaster.getVmodel().getVehicleClass().getVehicleClass()+"</DATA>");
                        bwx.write("\r\n"); 
                        bwx.write("</ROW>"); 
                        bwx.write("\r\n"); 
                        
                        bwx.write("<ROW num=\"Date of Mfg\">"
                        		+ "\r\n<CODE>10199</CODE>");
                        bwx.write("\r\n"); 
                        bwx.write("<DATA>01-Jan-"+vehicleMaster.getManufactureYear()+"</DATA>");
                        bwx.write("\r\n"); 
                        bwx.write("</ROW>"); 
                        bwx.write("\r\n");  
                        
                        
                        bwx.write("<ROW num=\"Emission Norms\">"
                        		+ "\r\n<CODE>10190</CODE>");
                        bwx.write("\r\n"); 
                        bwx.write("<DATA>"+vehicleMaster.getEmissionNorms()+"</DATA>");
                        bwx.write("\r\n"); 
                        bwx.write("</ROW>");
                        bwx.write("\r\n"); 
        
                        bwx.write("<ROW num=\"Wheel\">"
                        		+ "\r\n<CODE>10192</CODE>");
                        bwx.write("\r\n"); 
                        bwx.write("<DATA>"+vehicleMaster.getNoWheel()+"</DATA>");
                        bwx.write("\r\n"); 
                        bwx.write("</ROW>");
                        bwx.write("\r\n"); 
                        bwx.write("</Report>");  
                        bwx.close(); 
				        
                        if(configSystem.size()!=0) {

         	                   for(ConfigSystem conSys:configSystem) {
         	                     hostname=conSys.getIpaddress();
         	                     username=conSys.getUserName();
         	                     password=conSys.getPassword();  
         	                     rootpath=conSys.getRootPath();
         	                     xmlPath=conSys.getXmlPath();
         	                     inet = InetAddress.getByName(hostname);
         	                 
         	
         	                   
         	                    FTPUploader ftpUploader = new FTPUploader(hostname, username, password);
         	
         	                    //FTP server path is relative. So if FTP account HOME directory is "/home/pankaj/public_html/" and you need to upload
         	                    // files to "/home/pankaj/public_html/wp-content/uploads/image2/", you should pass directory parameter as "/wp-content/uploads/image2/"
         	                    ftpUploader.uploadFile(textFilePath, vehiclereg.getVid().getVehicleID()+".txt", rootpath+"/");//public_ftp
         	                   
         	                    //sava FTp to xml
         	                    ftpUploader.uploadFile(xmlFilePath, vehiclereg.getVid().getVehicleID()+".xml", xmlPath+"/");//public_ftp
         	                    
         	                    
         	                    ftpUploader.disconnect();
         	                    file.delete();
         	                    xmlfile.delete();
         	                    
         	                   }
         	            }	
                        
                		ocrDetails.setVrStatus("completed");
                		vehicleService.saveOcrDetailsRepo(ocrDetails);
                        
                		return "0";
	                	
	                }else {
	  	        	  return "6"; 
	  		          
	  	          }
	        	}
        		
        	} catch (Exception e) {
        		return "7";
        	}
        
				
	 }
	
	
	
	//save vehicle registration data
	@RequestMapping(value="/vehicleRegAction" ,method=RequestMethod.POST)
	public @ResponseBody String saveVehicleRegistration(@Valid @ModelAttribute("VehicleRegistration") VehicleRegistration vehiclereg,  BindingResult br,HttpServletRequest request,RedirectAttributes redirectAttributes,HttpSession session) {
		if(br.hasErrors())  
        {  
		 	return "0";  
        }  
        else  
        {	
        	try {
        		CenterMaster centerMaster=centerService.getcenterById(vehiclereg.getCentermaster().getCenter_ID()); 
        		OcrDetails ocrDetails=vehicleService.getOcrDetailsById(vehiclereg.getOcrid().getOcrid());
        		List<VehicleRegistration> isVehicale=vehicleService.getTestStatusVehicleRegistation(vehiclereg.getVid().getVehicleID());
        		
           
        		if (session.getAttribute("username")==null) {
        			return "1";	
        		}else if (!ocrDetails.getDocStatus().equals("completed")) {
	        		return "2";  	 
	        	}else if (isVehicale.size()!=0) {
	        		return "3";  	 
	        	}else {
    	    	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
    	    	    Date date = new Date();  
    	    	    DateTimeFormatter formattertime = DateTimeFormatter.ofPattern("HH:mm");
    	    	    LocalTime time = LocalTime.now();
    	    	    
    	    	    //get Token  no
    	    	    String tansactionId = "0000".substring(transactionservice.maxtrID().length())+transactionservice.maxtrID();
    	    	    
    	    	    String vRegID = "0000".substring(vehicleService.maxVRegID().length())+vehicleService.maxVRegID();
    	    	    
    	    		Transaction tr = new Transaction();
    	    		tr.setTrID(tansactionId);
    	    		tr.setStatus("ACTIVE");
    	    		tr.setRemarks("New Vehicle Registration ("+vRegID+")");
    	    		transactionservice.saveTransaction(tr);
    	    		
    	    		vehiclereg.setTime(time.format(formattertime));
    	    		vehiclereg.setDate(formatter.format(date));
    	    		vehiclereg.setViTestStatus("pending");
    	    		vehiclereg.setTestStatus("pending");	
    	    		vehiclereg.setTrid(tr);	    		
    	    		vehiclereg.setVregID(vRegID);
    	    		vehiclereg.setPayType("Cash");
    	    		vehiclereg.setStatus("ACTIVE");
    	    		vehicleService.saveVehicleRegister(vehiclereg);
	
                	TestCategory testCategory=centerService.getCategoryId(vehiclereg.getTestCategory().getCategoryId());	            	
                	String countrcode=centerMaster.getPartner_ID().getCountry_Code().getCountryCode();
                	List<TaxConfiguration> getTaxFromCountrylist=vehicleService.getTaxFromCountry(countrcode);
                	VehicleRegisterType vrtyp=vehicleService.getRegType(vehiclereg.getVtype().getvRegTypeID());
                	
                	VehicleMaster vehicleMaster = vehicleService.getVMasterById(vehiclereg.getVid().getVehicleID());
                	//create Next Receipt No
                	int maxrecno=centerMaster.getPartner_ID().getMaxRecNo();
                	String recFormate=centerMaster.getPartner_ID().getRecformate();
                	String nextRecno=recFormate+(maxrecno+1);
                	long testFee=testCategory.getCategoryFee();
                	long testFeePresent=vrtyp.getvTestFeePre();
                	long nettotal=0;
                	
                	long calTestFee=testFee*testFeePresent/100;	
                	//update  Last Receipt No
                	businessPartnerService.setUpdateLastRecNo(centerMaster.getPartner_ID().getPartner_ID());
                	
                	ReceiptHead receiptHead=new ReceiptHead(nextRecno, vehiclereg, vehiclereg.getDate(),vehiclereg.getTime(),calTestFee,"New Vehicle Register",ocrDetails.getAppNo(),"ACTIVE");
                	
                	List<ReceiptDetails> eceiptDetailsArrayList = new ArrayList<ReceiptDetails>();
                	
	            	for(TaxConfiguration taxdetail:getTaxFromCountrylist) {
	            		Long taxamt=Long.parseLong("0");
	            		if(taxdetail.getType().equals("Rate")) {
	            		 taxamt=calTestFee*taxdetail.getTaxRate()/10000;
	            		}else {
	            		 taxamt=taxdetail.getTaxRate();	
	            			
	            		} 		
	            		ReceiptDetails receiptDetails= new ReceiptDetails(receiptHead, taxdetail, taxdetail.getTaxRate(),taxamt);
	            		nettotal=nettotal+taxamt;
	            		eceiptDetailsArrayList.add(receiptDetails);
	            	}
	            	receiptHead.setNetTotal(nettotal+calTestFee);
	            	//save ReceiptHead date & ReceiptDetails
	            	vehicleService.saveReciptHead(receiptHead);
	            	vehicleService.saveReciptDetailsAll(eceiptDetailsArrayList);
	            	
                	
                	
            		ocrDetails.setPaymentStatus("completed");
            		vehicleService.saveOcrDetailsRepo(ocrDetails);
                	
            		return "vehicalRecORG?recno="+nextRecno+"";
        		}
        		
        	} catch (Exception e) {
        		return "0";
        	}
        }
				
	 }
	

	@RequestMapping(value="/vehicleInvoiceRegAction" ,method=RequestMethod.POST)
	public @ResponseBody String saveVehicleInvoiceRegistration(@Valid @ModelAttribute("VehicleRegistration") VehicleRegistration vehiclereg,  BindingResult br,HttpServletRequest request) {

		if(br.hasErrors())  
        {  
		// System.out.println("jjjjjjjjjj");
		 //redirectAttributes.addFlashAttribute("success", 0);
		 	return "0";  
        }  
        else  
        { 
          try { 
        	  
           List<ConfigSystem> configSystem=vehicleService.getConfigSystemByCenter(vehiclereg.getCentermaster().getCenter_ID(),vehiclereg.getTestLaneHeadId().getTestLaneHeadId());	
              
            boolean correct=false;
            String hostname="";
            String username="";
            String password="";
            String rootpath="";
            String xmlPath="";
            InetAddress inet = null;
            for(ConfigSystem conSys:configSystem) {
//                 hostname=conSys.getIpaddress();
//                 username=conSys.getUserName();
//                 password=conSys.getPassword();  
//                 rootpath=conSys.getRootPath();
//                 xmlPath=conSys.getXmlPath();
                 inet = InetAddress.getByName(hostname);
                 if(inet.isReachable(0)==true) {
                	 correct=true; 
                 }else {
                	 correct=false; 
                	 break;
                 }

            }  	
            
            if((configSystem.size()==0)) {
             	correct=true;
             }  
           
            
            
        	  
            if(correct) {
        	  
        	  
        	  List<VehicleRegistration> isVehicale=vehicleService.getTestStatusVehicleRegistation(vehiclereg.getVid().getVehicleID());
        	  
        	 if(isVehicale.size()==0) { 
        	
        //	  transaction.begin();
           System.out.println("mmmmmmmmmmmm");
    	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
    	    Date date = new Date();  
    	    DateTimeFormatter formattertime = DateTimeFormatter.ofPattern("HH:mm");
    	    LocalTime time = LocalTime.now();
        
            //	transactionStatus=TransactionAspectSupport.currentTransactionStatus();
            //get next Transaction no	
        	String tansactionId = "0000".substring(transactionservice.maxtrID().length())+transactionservice.maxtrID();
        	//get next vehicle Register 
    		String vRegID = "0000".substring(vehicleService.maxVRegID().length())+vehicleService.maxVRegID();
    		
    		// insert Transaction Table data   		    	
    		Transaction tr = new Transaction();
    		tr.setTrID(tansactionId);
    		tr.setStatus("ACTIVE");
    		tr.setRemarks("New Vehicle Registration (vRegID)");
    		
    		//set Vehicle table to transaction id
    		
    		vehiclereg.setTime(time.format(formattertime));
    		vehiclereg.setDate(formatter.format(date));
    		vehiclereg.setViTestStatus("pending");
    		vehiclereg.setTestStatus("pending");
    		
    		vehiclereg.setTrid(tr);	    		
    		vehiclereg.setVregID(vRegID);
    		vehiclereg.setPayType("Credit");
    		//save transaction
    		transactionservice.saveTransaction(tr);
    		//save  VehicleRegister table
        	vehicleService.saveVehicleRegister(vehiclereg);
        	
        	
        	CenterMaster centerMaster=centerService.getcenterById(vehiclereg.getCentermaster().getCenter_ID());
        	TestCategory testCategory=centerService.getCategoryId(vehiclereg.getTestCategory().getCategoryId());	            	
        	String countrcode=centerMaster.getPartner_ID().getCountry_Code().getCountryCode();
        	List<TaxConfiguration> getTaxFromCountrylist=vehicleService.getTaxFromCountry(countrcode);
        	VehicleRegisterType vrtyp=vehicleService.getRegType(vehiclereg.getVtype().getvRegTypeID());
        	
        	VehicleMaster vehicleMaster = vehicleService.getVMasterById(vehiclereg.getVid().getVehicleID());
        	
        //	TestLaneHead testLaneHead=laneServices.getTestLaneHeadById(vehiclereg.getTestLaneHeadId().getTestLaneHeadId());
        	

        	long testFee=testCategory.getCategoryFee();
        	long testFeePresent=vrtyp.getvTestFeePre();
        	long nettotal=0;
        	
        	long calTestFee=testFee*testFeePresent/100;
        	
        	//System.out.println("ghghg="+centerMaster.getEsInPath()+"\\"+vehiclereg.getTestLaneHeadId().getLaneName()+"\\"+vehiclereg.getVid().getVehicleID()+".txt");
        	//create Next Receipt No
        	//businessPartnerService.setUpdateLastRecNo(centerMaster.getPartner_ID().getPartner_ID());
        	OcrDetails ocrDetails=vehicleService.getOcrDetailsById(vehiclereg.getOcrid().getOcrid());
        //	if(testFeePresent!=0) {
        	//insert InvoiceHead date & InvoiceDetails
        	int maxinvno=centerMaster.getPartner_ID().getMaxInvNo();
        	String invFormate=centerMaster.getPartner_ID().getInvformate();
        	String nextinvno=invFormate+(maxinvno+1);
        	businessPartnerService.setUpdateLastInvNo(centerMaster.getPartner_ID().getPartner_ID());
        	
        	Customer  cusdetail=usersService.viewCustomersDetailByID(vehiclereg.getCusid().getId());
			InvoiceHead invHead=new InvoiceHead(nextinvno, vehiclereg, vehiclereg.getDate(),vehiclereg.getTime(),calTestFee,"New Vehicle Register","ACTIVE","N/A","Open");
			
	
			List<InvoiceDetails> invDetailsList = new ArrayList<InvoiceDetails>();
			
			
			
        	for(TaxConfiguration taxdetail:getTaxFromCountrylist) {
        		Long taxamt=Long.parseLong("0");
        		if(taxdetail.getType().equals("Rate")) {
        		 taxamt=calTestFee*taxdetail.getTaxRate()/10000;
        		}else {
        		 taxamt=taxdetail.getTaxRate();	
        			
        		}
        		
        		InvoiceDetails invDetails= new InvoiceDetails(invHead, taxdetail, taxdetail.getTaxRate(),taxamt);
        		nettotal=nettotal+taxamt;
        		invDetailsList.add(invDetails);
        	}
        	invHead.setNetTotal(nettotal+calTestFee);
        	invHead.setBalance(nettotal+calTestFee);
        	
        	Long balance=nettotal+calTestFee+cusdetail.getCrBalance();
        	cusdetail.setCrBalance(balance);
        	usersService.saveCustomer(cusdetail);
        	
        	
        	
        	invHead.setPayAmount(Long.parseLong("0"));
    //save invHead date & invDetails
        	vehicleService.saveInvoiceHead(invHead);
        	vehicleService.saveInvoiceDetailsAll(invDetailsList);
        	Users user=usersService.searchUser(vehiclereg.getUser().getUserId());
        //    }
            	
				String path1 = this.getClass().getClassLoader().getResource("").getPath();
				String fullPath = URLDecoder.decode(path1, "UTF-8");

				String pathArr[] = fullPath.split("/WEB-INF/classes/");
//			
//				String path= pathArr[0]+"/Upload/ES_IN/";	
            	
            	
				String textFilePath=centerMaster.getEsInPath()+"\\"+vehiclereg.getVid().getVehicleID()+".txt";
            	
            
            //create Text file & get ES in path
            //	String textFilePath=path+"/"+vehiclereg.getVid().getVehicleID()+".txt";
            	
        	File file = new File(textFilePath);
    
           if (!file.exists()) {
                file.createNewFile();
              }
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("[HEADER]");
                bw.write("\r\n"); 
                bw.write("10100="+vehiclereg.getVid().getVehicleID());
                bw.write("\r\n"); 
                bw.write("15012="+user.getUserName());
                bw.write("\r\n"); 
                bw.write("10190="+vehicleMaster.getNoWheel());	                
                bw.write("\r\n"); 
                bw.write("10191="+vehicleMaster.getVmodel().getVehicleClass().getCategoryID().getCategoryID());                
                
                
                
                bw.write("\r\n");
                bw.write("\r\n");
                bw.write("[ENDOFFILE]");
               
                
                bw.close();
                
              //  String xpath= pathArr[0]+"/Upload/XML_ES_IN/";	
               	String xmlFilePath=centerMaster.getEsInXmlPath()+"\\"+vehiclereg.getVid().getVehicleID()+".xml";
            	
            	File xmlfile = new File(xmlFilePath);
        
	           if (!xmlfile.exists()) {
	        	   xmlfile.createNewFile();
	              }
                    FileWriter fwX = new FileWriter(xmlfile.getAbsoluteFile());
                    BufferedWriter bwx = new BufferedWriter(fwX);
                    bwx.write("<?xml version=\"1.0\"?>"
                    		+ "\r\n");
                    
                    bwx.write("<Report>"); 
                    bwx.write("\r\n"); 
                    bwx.write("<ROW num=\"Vehicle Registration No\">"
                    		+ "\r\n<CODE>10100</CODE>");
                    bwx.write("\r\n"); 
                    bwx.write("<DATA>"+vehiclereg.getVid().getVehicleID()+"</DATA>");
                    bwx.write("\r\n"); 
                    bwx.write("</ROW>");
                    bwx.write("\r\n"); 
                    
                    bwx.write("<ROW num=\"User\">"
                    		+ "\r\n<CODE>15012</CODE>");
                    bwx.write("\r\n"); 
                    bwx.write("<DATA>"+user.getUserName()+"</DATA>");
                    bwx.write("\r\n"); 
                    bwx.write("</ROW>");                       
                    bwx.write("\r\n"); 
                    
                    bwx.write("<ROW num=\"Make\">"
                    		+ "\r\n<CODE>15015</CODE>");
                    bwx.write("\r\n"); 
                    bwx.write("<DATA>"+vehicleMaster.getVmodel().getVehicleMakeID().getVehicleMake()+"</DATA>");
                    bwx.write("\r\n"); 
                    bwx.write("</ROW>");                       
                    bwx.write("\r\n"); 
                    
                    bwx.write("<ROW num=\"Model\">"
                    		+ "\r\n<CODE>15016</CODE>");
                    bwx.write("\r\n"); 
                    bwx.write("<DATA>"+vehicleMaster.getVmodel().getVehicleModel()+"</DATA>");
                    bwx.write("\r\n"); 
                    bwx.write("</ROW>");  
                    bwx.write("\r\n"); 
                    
                    bwx.write("<ROW num=\"Fuel Type\">"
                    		+ "\r\n<CODE>15017</CODE>");
                    bwx.write("\r\n"); 
                    bwx.write("<DATA>"+vehicleMaster.getFtype().getFuel()+"</DATA>");
                    bwx.write("\r\n"); 
                    bwx.write("</ROW>");  
                    bwx.write("\r\n"); 
                    
                    bwx.write("<ROW num='Engine Stroke'>"
                    		+ "<CODE>15018</CODE>");
                    bwx.write("<DATA>4 Stroke</DATA>");
                    bwx.write("</ROW>");  
                    bwx.write("\r\n"); 
   
                    bwx.write("<ROW num=\"Category\">"
                    		+ "\r\n<CODE>10191</CODE>");
                    bwx.write("\r\n"); 
                    bwx.write("<DATA>"+vehicleMaster.getVmodel().getVehicleClass().getVehicleClass()+"</DATA>");
                    bwx.write("\r\n"); 
                    bwx.write("</ROW>"); 
                    bwx.write("\r\n"); 
                    
                    bwx.write("<ROW num=\"Date of Mfg\">"
                    		+ "\r\n<CODE>10199</CODE>");
                    bwx.write("\r\n"); 
                    bwx.write("<DATA>"+vehicleMaster.getManufactureYear()+"</DATA>");
                    bwx.write("\r\n"); 
                    bwx.write("</ROW>"); 
                    bwx.write("\r\n");  
                    
                    
                    bwx.write("<ROW num=\"Emission Norms\">"
                    		+ "\r\n<CODE>10190</CODE>");
                    bwx.write("\r\n"); 
                    bwx.write("<DATA>"+vehicleMaster.getEmissionNorms()+"</DATA>");
                    bwx.write("\r\n"); 
                    bwx.write("</ROW>");
                    bwx.write("\r\n"); 
    
                    bwx.write("<ROW num=\"Wheel\">"
                    		+ "\r\n<CODE>10192</CODE>");
                    bwx.write("\r\n"); 
                    bwx.write("<DATA>"+vehicleMaster.getNoWheel()+"</DATA>");
                    bwx.write("\r\n"); 
                    bwx.write("</ROW>");
                    bwx.write("\r\n"); 
                    bwx.write("</Report>");  
                    bwx.close();   
//                
                
        
                

             //  List<ConfigSystem> configSystem=vehicleService.getConfigSystemByCenter(vehiclereg.getCentermaster().getCenter_ID(),vehiclereg.getTestLaneHeadId().getTestLaneHeadId());	
              
               
//               String hostname="";
//               String username="";
//               String password="";
//               String rootpath="";
//               String xmlPath="";
//               for(ConfigSystem conSys:configSystem) {
//                    hostname=conSys.getIpaddress();
//                    username=conSys.getUserName();
//                    password=conSys.getPassword();  
//                    rootpath=conSys.getRootPath();
//                    xmlPath=conSys.getXmlPath();
//               }
               
               
               if(configSystem.size()!=0) {
               System.out.println("Start");
               
                   for(ConfigSystem conSys:configSystem) {
                     hostname=conSys.getIpaddress();
                     username=conSys.getUserName();
                     password=conSys.getPassword();  
                     rootpath=conSys.getRootPath();
                     xmlPath=conSys.getXmlPath();
                     inet = InetAddress.getByName(hostname);
                 

                   
                    FTPUploader ftpUploader = new FTPUploader(hostname, username, password);

                    //FTP server path is relative. So if FTP account HOME directory is "/home/pankaj/public_html/" and you need to upload
                    // files to "/home/pankaj/public_html/wp-content/uploads/image2/", you should pass directory parameter as "/wp-content/uploads/image2/"
                    ftpUploader.uploadFile(textFilePath, vehiclereg.getVid().getVehicleID()+".txt", rootpath+"/");//public_ftp
                   
                    //sava FTp to xml
                    ftpUploader.uploadFile(xmlFilePath, vehiclereg.getVid().getVehicleID()+".xml", xmlPath+"/");//public_ftp
                    
                    
                    ftpUploader.disconnect();
                    file.delete();
                    xmlfile.delete();
                    
                   }
            }
                System.out.println("Done");
                
               
                
              //  OcrDetails ocrDetails=vehicleService.getOcrDetailsById(vehiclereg.getOcrid().getOcrid());	
        		ocrDetails.setVrStatus("completed");
        		vehicleService.saveOcrDetailsRepo(ocrDetails);
        		
        		//redirectAttributes.addFlashAttribute("success", 1);
        		  System.out.println("1");
        		return "vehicalInvORG?invNo="+nextinvno+"";
        		
        	 }else {
        		// redirectAttributes.addFlashAttribute("success", 3);
        		//  System.out.println("3");
        		 return "3"; 
        		 
        	 }
                
        		 
        	//	transaction.commit();
                
          
          
          }else {
        	 // redirectAttributes.addFlashAttribute("success", 2);
        	//  System.out.println("2 vecNo="+vehiclereg.getVid().getVehicleID()+"&curMi="+vehiclereg.getCurrentMilage()+"&id="+vehiclereg.getOcrid().getOcrid());
        	 // return "vehicleRegistrationAuto";
        	  return "2"; 
          
          }
          		// "vehicleRegistration?vid="+"";	    	    	    	    	      	    	          	
        } catch (Exception e) {
        //	transaction.getRollbackOnly();
        	//transactionStatus.setRollbackOnly();
           e.printStackTrace();
          
           return "0";
        }
     }
				
	 }
	  @RequestMapping(value = "/vehicalInvCOPY", method=RequestMethod.GET) 
	  public String getVehicalInvCOPY(Map<String, String> model) { 

		  return "VehicleInvoiceRePrint";
	  }
	  @RequestMapping(value = "/vehicalInvORG", method=RequestMethod.GET) 
	  public ModelAndView getVehicleInvoiceORG(@RequestParam String invNo,HttpServletResponse response) { 
		  ModelAndView mav = new ModelAndView("VehicleInvoice");
		  InvoiceHead invoiceHead=vehicleService.getInvoiceHeadByInvNo(invNo);
		  VehicleRegistration vehiclereg=vehicleService.VehicleRegInfoByID(invoiceHead.getvRegisterID().getVregID());
		  mav.addObject("vecno" ,vehiclereg.getVid().getVehicleID());
		  mav.addObject("invNo" ,invNo);
		  mav.addObject("invDate" ,vehiclereg.getDate());
		 
		  String invValue=vehicalInvoiceGeaerate(invNo,response);
		  String tokValue=vehicalTokenGeaerate(vehiclereg.getVid().getVehicleID(), vehiclereg.getDate(),invoiceHead.getNetTotal(),invoiceHead.getvRegisterID().getVregID(),response);

		  mav.addObject("pdfViewEq", invValue); 
		  mav.addObject("pdftokValue", tokValue);

		  return mav;
	  }	
	
	  public String vehicalInvoiceGeaerate(String invNo,HttpServletResponse response) {
		  
		  	InvoiceHead invHed=vehicleService.getInvoiceHeadByInvNo(invNo);
		//System.out.println("fffffffffffffffff"+invHed.getStatus());
		  	if(invHed.getStatus().toString().equals("ACTIVE")) {
		  	//	invHed.getvRegisterID();
		  	VehicleRegistration vehiclereg=vehicleService.VehicleRegInfoByID(invHed.getvRegisterID().getVregID());
		  	Customer  cusdetail=usersService.viewCustomersDetailByID(vehiclereg.getCusid().getId());
		  
		  	CenterMaster centerMaster=centerService.getcenterById(vehiclereg.getCentermaster().getCenter_ID());
		  	VehicleOwner vehicleOwner=vehicleService.getVehicleOwnerIDByVehicleID(vehiclereg.getVid().getVehicleID());
		  	
		  	List<InvoiceDetails> invDetails=vehicleService.getInvoiceDetails(invNo);
		  	
		  	List<VehicleInvoiceBeen> vehicleInvoiceBeenList = new ArrayList<VehicleInvoiceBeen>();
		  	
		  	

		  	
		  	VehicleInvoiceBeen vehicleInvoiceBeen1=new VehicleInvoiceBeen();
		  	vehicleInvoiceBeen1.setRate(0);
		  	vehicleInvoiceBeen1.setAmount(Double.parseDouble((invHed.getTestFee())+"")/100);
		  	vehicleInvoiceBeen1.setDescription("Test Fee");
		  	vehicleInvoiceBeen1.setStyle(false);
		  	vehicleInvoiceBeen1.setType("");
		  	vehicleInvoiceBeen1.setCurrency(centerMaster.getCountrycode().getCurrency());
		  	vehicleInvoiceBeenList.add(vehicleInvoiceBeen1);
		  	
		  	
		  	
		  	for(InvoiceDetails vrData:invDetails) {
		  		VehicleInvoiceBeen vehicleInvoiceBeen2=new VehicleInvoiceBeen();
		  		vehicleInvoiceBeen2.setRate(Double.parseDouble((vrData.getTaxRate())+"")/100);
		  		vehicleInvoiceBeen2.setAmount(Double.parseDouble((vrData.getTaxAmount())+"")/100);
		  		vehicleInvoiceBeen2.setDescription(vrData.getTaxCode().getTax());
		  		if(vrData.getTaxCode().getType().equals("Rate")) {
		  			vehicleInvoiceBeen2.setType("%");
		  		}else {
		  			vehicleInvoiceBeen2.setType("");	
		  		}
		  		
		  		vehicleInvoiceBeen2.setCurrency(centerMaster.getCountrycode().getCurrency());
		  		vehicleInvoiceBeen2.setStyle(false);
		  		vehicleInvoiceBeenList.add(vehicleInvoiceBeen2);
		  	}
		  	VehicleInvoiceBeen vehicleInvoiceBeen3=new VehicleInvoiceBeen();
		  	vehicleInvoiceBeen3.setRate(Double.parseDouble((0)+""));
		  	vehicleInvoiceBeen3.setAmount(Double.parseDouble((invHed.getNetTotal())+"")/100);
		  	vehicleInvoiceBeen3.setDescription("Net Total");
		  	vehicleInvoiceBeen3.setStyle(true);
		  	vehicleInvoiceBeen3.setCurrency(centerMaster.getCountrycode().getCurrency());
		  	vehicleInvoiceBeen3.setType("");
		  	vehicleInvoiceBeenList.add(vehicleInvoiceBeen3);
		  			  
    //recipt Print
		  
        	ReportViewe review=new ReportViewe();
        	Map<String,Object> params = new HashMap<>();
        	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
        	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
        	params.put("address",centerMaster.getAdd03() );
     
      	  	params.put("name",cusdetail.getName());    
      	  	params.put("cusaddress",cusdetail.getAddress());
      	  	params.put("taxcode",cusdetail.getTaxcode());
      	  	params.put("mobileno",cusdetail.getTpno());
      	  	
        	params.put("invNo", invHed.getInvoiceNo());
        	params.put("vecno",vehiclereg.getVid().getVehicleID()  );
        	params.put("date",invHed.getInvoiceDate() );
        	params.put("vectype",vehiclereg.getVtype().getvRegType() );
        	params.put("category",vehiclereg.getTestCategory().getCategoryType());
        	params.put("slottime",invHed.getInvoiceTime() );	
        	params.put("apono",invHed.getAppoID());
        	params.put("footer",centerMaster.getPartner_ID().getReceiptFooter());
        	params.put("classmod",vehiclereg.getVid().getVmodel().getVehicleMakeID().getVehicleMake()+"/"+vehiclereg.getVid().getVmodel().getVehicleModel());
        	params.put("numinword",StringFormaterWeb.capitalizeWord(EnglishNumberToWords.convert(Long.parseLong((invHed.getNetTotal())+"")/100)));
        	params.put("tokno",vehiclereg.getTrid().getTrID());
        	params.put("paytyp",vehiclereg.getPayType());
        	
        	
        	
        	
        	String reptValue="";
        	
       try {
        		reptValue=review.pdfReportViewInlineSystemOpen("VehicleInvoice.jasper","Vehicle Invoice",vehicleInvoiceBeenList,params,response);
        		
        
        	}catch(Exception e) {	          		
        		e.printStackTrace();          		
        	}
		  return reptValue;
		  }else {
			  
			  return "INACTIVE";  
			  
		  }
		  
	  }
	  
	  
	
	
				 
	@RequestMapping(value="/vehicleReport")
	public String loadVehicleMasterReport()
	{
		return "vehicleMasterReport";
	}
	
	// get model according to make id in vehicleMaster.jsp
	 @RequestMapping(value="/getModelForCombo", method=RequestMethod.GET)
		public   @ResponseBody List<VehicleModel> search1(@RequestParam String makeID,@RequestParam String classID) {
			List<VehicleModel> vmodel = vehicleService.getModelByID(makeID,classID);
			return vmodel;
		}
	 
	//load Test category to vehicle registration jsp
	@ModelAttribute("regCatTypeList")
	public List <TestCategory> getTestCategory(){
		List <TestCategory> listTestCategory = centerService.getAll();
		return listTestCategory;
	}
	
	//return all vreg types on jsp
	@ModelAttribute("vehicleRegisterTypelist")
	
	public List <VehicleRegisterType> getlistofvtyps(){
		List<VehicleRegisterType> vehicleRegisterTypelist = vehicleService.getAllVType();
		return vehicleRegisterTypelist;
	}
	
	 @RequestMapping(value="/getModelImage", method=RequestMethod.GET)
		public   @ResponseBody String getModelImage(@RequestParam String vehicleModelID) {
		 VehicleModel m = vehicleService.getVmodelDetailsByID(vehicleModelID);
			return m.getModelLogoView();
		}
	 
	 //load vehicle class to vehicle model jsp
	 @ModelAttribute("vclass")
	 public List<VehicleClass> loadVClass(){
		 List<VehicleClass> vclist = vehicleService.getVClass();
		 return vclist;
	 }
	 
	 //skip button in vehicle master
	 @RequestMapping(value="/skipmaster")
	 public String skipmaster(@RequestParam("vehicleID") String vehicleID) {
		 return "redirect:/getOwnersByVehicleNo?vehicleNo="+vehicleID;
	 }
	
	 //skip button in vehicle owner
	 @RequestMapping(value="/skipowner")
	 public String skipOwner(@RequestParam("vehicleID") String vehicleID,@RequestParam("id") String id) {
		  return "redirect:/vehicleRegistration?vid="+vehicleID+"&curMi=0&id="+id;
	 }


		@RequestMapping(value = "/getOwnersByVehicleNo",method = RequestMethod.GET)
		public String getOwnersByVehicleNo(@RequestParam String vehicleNo,Model m)
		{
			List<VehicleOwner> pre_owners = vehicleService.getOwnersByVehicleNo(vehicleNo);
			
			
			if(null != pre_owners && pre_owners.size() > 0) {
				
				for (VehicleOwner detail : pre_owners) {
					
					if("currentOwner".equals(detail.getStatus()))
					{
						m.addAttribute("current_owner",detail);
					}	
				}
			}
			
			m.addAttribute("pre_owners", pre_owners);
			m.addAttribute("veOwner",new VehicleOwner());
			//m.addAttribute("updated",true);
			
			return "vehicleOwner";
			
		}
		
		@RequestMapping(value="/newOwner",method=RequestMethod.GET)
		public String loadNewOwnerForm(@RequestParam String vehicleNo,Model m)
		{
			//System.out.println("Vehicle No is"+vehicleNo);
			VehicleMaster vm = new VehicleMaster(vehicleNo);
			
			VehicleOwner obj = new VehicleOwner();
			obj.setVehicleID(vm);
			m.addAttribute("veOwner", obj);
			m.addAttribute("success",true);
			return "vehicleOwner";
			
		}

		  @RequestMapping(value = "/updateVOwner", method=RequestMethod.GET) 
		  public @ResponseBody VehicleOwner updateVehicleOwner(@RequestParam String id) { 			  
			  VehicleOwner vo = vehicleService.getVOwnerById(id);
			  return vo;
		  }
		  
		  @RequestMapping(value = "/vehicalRecCOPY", method=RequestMethod.GET) 
		  public String getVehicleReceiptCOPY(Map<String, String> model) { 

			  return "VehicleReRecipt";
		  }	
		  
		  
		  @RequestMapping(value = "/vehicalRecORG", method=RequestMethod.GET) 
		  public ModelAndView getVehicleReceiptORG(@RequestParam String recno,HttpServletResponse response) { 
			  ModelAndView mav = new ModelAndView("VehicleRecipt");
			  ReceiptHead reciptHed=vehicleService.getReciptHedDetailByRecNo(recno);
			  VehicleRegistration vehiclereg=vehicleService.VehicleRegInfoByID(reciptHed.getvRegisterID().getVregID());
			  mav.addObject("vecno" ,vehiclereg.getVid().getVehicleID());
			  mav.addObject("reccno" ,recno);
			  mav.addObject("recDate" ,vehiclereg.getDate());
			  String reptValue=vehicalRescetGeaerate(recno, response);
			  String tokValue=vehicalTokenGeaerate(vehiclereg.getVid().getVehicleID(), vehiclereg.getDate(),reciptHed.getNetTotal(),reciptHed.getvRegisterID().getVregID(),response);

			  mav.addObject("pdfViewEq", reptValue); 
			  mav.addObject("pdftokValue", tokValue);
  
			  return mav;
		  }		  
		  @RequestMapping(value="/vehiclRerecPrint" ,method=RequestMethod.POST)
		  public ModelAndView printVehicalReceipt(@RequestParam String vecno,@RequestParam String reccno,@RequestParam String recDate,HttpServletResponse response) {
			  	ModelAndView mav = new ModelAndView("recTokonPrint");
			  	String reptValue=vehicalRescetGeaerate(reccno, response);
			  	mav.addObject("pdfViewEq", reptValue); 
			  	 ReceiptHead reciptHed=vehicleService.getReciptHedDetailByRecNo(reccno);
				  	VehicleRegistration vehiclereg=vehicleService.VehicleRegInfoByID(reciptHed.getvRegisterID().getVregID());
			  	String tokValue=vehicalTokenGeaerate(vehiclereg.getVid().getVehicleID(), vehiclereg.getDate(),reciptHed.getNetTotal(),reciptHed.getvRegisterID().getVregID(),response);
			  	mav.addObject("pdftokValue", tokValue);
			  	System.out.println("jjjjj="+tokValue);
	         return mav;
		  }
		  
		  @RequestMapping(value="/vehiclInvoicePrint" ,method=RequestMethod.POST)
		  public ModelAndView vehiclInvoicePrint(@RequestParam String vecno,@RequestParam String invNo,@RequestParam String invDate,HttpServletResponse response) {
			  	ModelAndView mav = new ModelAndView("comPdfReportView");
			  	String reptValue=vehicalInvoiceGeaerate(invNo, response);
			  	mav.addObject("pdfViewEq", reptValue); 
	         return mav;
		  }
		  public String vehicalRescetGeaerate(String reccno,HttpServletResponse response) {
			  
			  	ReceiptHead reciptHed=vehicleService.getReciptHedDetailByRecNo(reccno);
			  
			  	if(reciptHed.getStatus().toString().equals("ACTIVE")) {
			  	reciptHed.getvRegisterID();
			  	VehicleRegistration vehiclereg=vehicleService.VehicleRegInfoByID(reciptHed.getvRegisterID().getVregID());
			  	Customer  cusdetail=usersService.viewCustomersDetailByID(vehiclereg.getCusid().getId());
			  
			  	CenterMaster centerMaster=centerService.getcenterById(vehiclereg.getCentermaster().getCenter_ID());
			  	VehicleOwner vehicleOwner=vehicleService.getVehicleOwnerIDByVehicleID(vehiclereg.getVid().getVehicleID());
			  	
			  	List<ReceiptDetails> vehicleRegistration=vehicleService.getReceiptDetails(reccno);
			  	
			  	List<VehicleReceiptBeen> vehicleReceiptBeenList = new ArrayList<VehicleReceiptBeen>();
			  	
			  	

			  	
		  		VehicleReceiptBeen vehicleReceiptBeen1=new VehicleReceiptBeen();
		  		vehicleReceiptBeen1.setRate(0);
		  		vehicleReceiptBeen1.setAmount(Double.parseDouble((reciptHed.getTestFee())+"")/100);
		  		vehicleReceiptBeen1.setDescription("Test Fee");//vehiclereg.getTestCategory().getCategoryType());
		  		vehicleReceiptBeen1.setStyle(false);
		  		vehicleReceiptBeen1.setType("");
		  		vehicleReceiptBeen1.setCurrency(centerMaster.getCountrycode().getCurrency());
		  		vehicleReceiptBeenList.add(vehicleReceiptBeen1);
			  	
			  	
			  	
			  	for(ReceiptDetails vrData:vehicleRegistration) {
			  		VehicleReceiptBeen vehicleReceiptBeen2=new VehicleReceiptBeen();
			  		vehicleReceiptBeen2.setRate(Double.parseDouble((vrData.getTaxRate())+"")/100);
			  		vehicleReceiptBeen2.setAmount(Double.parseDouble((vrData.getTaxAmount())+"")/100);
			  		vehicleReceiptBeen2.setDescription(vrData.getTaxCode().getTax());
			  		if(vrData.getTaxCode().getType().equals("Rate")) {
			  		vehicleReceiptBeen2.setType("%");
			  		}else {
			  		vehicleReceiptBeen2.setType("");	
			  		}
			  		
			  		vehicleReceiptBeen2.setCurrency(centerMaster.getCountrycode().getCurrency());
			  		vehicleReceiptBeen2.setStyle(false);
			  		vehicleReceiptBeenList.add(vehicleReceiptBeen2);
			  	}
		  		VehicleReceiptBeen vehicleReceiptBeen3=new VehicleReceiptBeen();
		  		vehicleReceiptBeen3.setRate(Double.parseDouble((0)+""));
		  		vehicleReceiptBeen3.setAmount(Double.parseDouble((reciptHed.getNetTotal())+"")/100);
		  		vehicleReceiptBeen3.setDescription("Net Total");
		  		vehicleReceiptBeen3.setStyle(true);
		  		vehicleReceiptBeen3.setCurrency(centerMaster.getCountrycode().getCurrency());
		  		vehicleReceiptBeen3.setType("");
		  		vehicleReceiptBeenList.add(vehicleReceiptBeen3);
			  			  
          //recipt Print
			  System.out.println("cusid="+cusdetail.getId());  
	          	ReportViewe review=new ReportViewe();
	          	Map<String,Object> params = new HashMap<>();
	        	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
	          	params.put("hedder",centerMaster.getCenter());
	          	params.put("address",centerMaster.getAdd03() );
	          if(cusdetail.getId().equals("0000")) {
	          	params.put("name",vehicleOwner.getOwnerName());
	          }else{
	        	  params.put("name",cusdetail.getName());    
	          }
	          	params.put("recno", reciptHed.getRecNo());
	          	params.put("vecno",vehiclereg.getVid().getVehicleID()  );
	          	params.put("date",vehiclereg.getDate() );
	          	params.put("vectype",vehiclereg.getVtype().getvRegType() );
	          	params.put("category",vehiclereg.getTestCategory().getCategoryType());
	          	params.put("slottime",vehiclereg.getTime() );	
	          	
	          	if(!reciptHed.getAppoID().equals("0")) {
	          		params.put("apono",reciptHed.getAppoID());
	          	}else {
	          		params.put("apono","N/A");	
	          	}
	          	
	          	
	          	params.put("footer",centerMaster.getPartner_ID().getReceiptFooter());
	          	params.put("classmod",vehiclereg.getVid().getVmodel().getVehicleMakeID().getVehicleMake()+"/"+vehiclereg.getVid().getVmodel().getVehicleModel());
	          	params.put("numinword",StringFormaterWeb.capitalizeWord(EnglishNumberToWords.convert(Long.parseLong((reciptHed.getNetTotal())+"")/100)));
	          	params.put("tokno",vehiclereg.getTrid().getTrID());
	          	params.put("paytyp",vehiclereg.getPayType());
	          	params.put("currdesc",centerMaster.getCountrycode().getCurrencyDescription());
	          	
	          	String reptValue="";
	         try {	        	
	          		reptValue=review.pdfReportViewInlineSystemOpen("VehicleReceipt.jasper","Vehicle Receipt",vehicleReceiptBeenList,params,response);	        	          
	          	}catch(Exception e) {	          		
	          		e.printStackTrace();          		
	          	}
			  return reptValue;
			  
			  
			  	}else {
			  		
			return "INACTIVE";		
			  		
			  	}
			  
		  }

			 @ModelAttribute("cusallCombo")
			 public  List<Customer> listCustomer(){
				 List<Customer> cusAll=usersService.viewAllCustomers();
				 return cusAll;
			 }
			 
			  public String vehicalTokenGeaerate(String vecno,String recDate,Long ntotal,String vregid,HttpServletResponse response) {
				  
//				  	ReceiptHead reciptHed=vehicleService.getReciptHedDetailByRecNo(reccno);
//				  	reciptHed.getvRegisterID();
				  	VehicleRegistration vehiclereg=vehicleService.VehicleRegInfoByID(vregid);  	
				  	Transaction tranction=transactionservice.getTrancionByID(vehiclereg.getTrid().getTrID());
	
				  	TestLaneHead testLaneHead=laneServices.getTestLaneHeadById(vehiclereg.getTestLaneHeadId().getTestLaneHeadId());				  	
				  	CenterMaster centerMaster=centerService.getcenterById(vehiclereg.getCentermaster().getCenter_ID());

			  			  
	          //token Print
				  		  
		          	ReportViewe review=new ReportViewe();
		          	Map<String,Object> params = new HashMap<>();
		        	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
		          	params.put("tokenno",tranction.getTrID());
		          	params.put("LaneNo",testLaneHead.getLaneName() );		   
		          	params.put("tokenDate", vehiclereg.getDate());
		         	params.put("Fee",centerMaster.getCountrycode().getCurrency()+" "+StringFormaterWeb.formatToRupees(ntotal) +"" );
		          	params.put("NumberPlate",vecno );
		          	params.put("VehiMake",vehiclereg.getVid().getVmodel().getVehicleClass().getVehicleClass() );
		          	params.put("VehiModel",vehiclereg.getVid().getVmodel().getVehicleModel());
		          	params.put("ManuYear",vehiclereg.getVid().getManufactureYear());
		          	params.put("ChassisNo",vehiclereg.getVid().getChassisNo());
		          	if(!vehiclereg.getOcrid().getAppNo().equals("0")) {
		          	params.put("appoNo",vehiclereg.getOcrid().getAppNo());
		          	}else {
		          		params.put("appoNo","N/A");	
		          	}
		          	String tokValue="";
		          	
		         try {
		        	 tokValue=review.pdfReportViewInlineSystemOpen("Token.jasper","Token",null,params,response);
		          		
		          
		          	}catch(Exception e) {	          		
		          		e.printStackTrace();          		
		          	}
				  return tokValue;
				  
			  }	
			  @RequestMapping(value = "/getVehicalDetailsByDate", method=RequestMethod.GET) 
			  public @ResponseBody List<VehicleRegistration> getVehicalDetailsByDate(@RequestParam String vRdate,@RequestParam String payTyp) { 			  
				  List<VehicleRegistration> vo = vehicleService.getVechicalDetailByDate(vRdate,payTyp);
				  return vo;
			  }
			  @RequestMapping(value = "/getReceiptHeadByVehicalRegID", method=RequestMethod.GET) 
			  public @ResponseBody List<ReceiptHead> getReceiptHeadByVehicalRegID(@RequestParam String vRdate,@RequestParam String vecid,@RequestParam String payTyp) {
				  List<ReceiptHead> rh=vehicleService.getReceiptHeadByVehicalRegID( vRdate, vecid,payTyp);
				  return rh;
			  }	  
			  
			  @RequestMapping(value = "/getInvoiceHeadByVehicalRegID", method=RequestMethod.GET) 
			  public @ResponseBody List<InvoiceHead> getInvoiceHeadByVehicalRegID(@RequestParam String vRdate,@RequestParam String vecid,@RequestParam String payTyp) {
				  List<InvoiceHead> ih=vehicleService.getInvoiceHeadByVehicalRegID( vRdate, vecid,payTyp);
				  return ih;
			  }
			  
			@ModelAttribute("vehicleCategoryCombo")
			public List<VehicleCategory> getVehicleCategory(){
					List <VehicleCategory> vcatall = vehicleService.getVehicleCategory();
					return vcatall;
			} 
			@RequestMapping(value = "/getVClassByIdData", method=RequestMethod.GET) 
			public @ResponseBody VehicleClass getVClassByIdData(@RequestParam String classid) {
				  VehicleClass vc=vehicleService.getVClassById(classid);
				  return vc;
			}	
			  
			@RequestMapping(value="/getVClassImage", method=RequestMethod.GET)
			public   @ResponseBody String getClasslImage(@RequestParam String classid) {
				 VehicleClass vc=vehicleService.getVClassById(classid);
				return vc.getVehicleclassLogoView();
			}
			@RequestMapping(value="/getFindVmaster", method=RequestMethod.GET)
			public  @ResponseBody VehicleMaster getVehicleMaster(@RequestParam String vehicleID) {
				 VehicleMaster vm =null;
				 vm= vehicleService.getVMasterById(vehicleID);
				return vm;
 
			}
			@RequestMapping(value="/getVehicleOwnerIDByVehicleID", method=RequestMethod.GET)
			public  @ResponseBody VehicleOwner getVehicleOwnerIDByVehicleID(@RequestParam String vehicleID) {
				VehicleOwner vo=vehicleService.getVehicleOwnerIDByVehicleID(vehicleID);
				return vo;
 
			}
			@RequestMapping("/vehicleInformation")
			public String logout() {
				// ModelAndView mav=new ModelAndView("login");
				return "vehicleInformation";
			}
			
			@RequestMapping(value="/getChassisNumberDetails", method=RequestMethod.GET)
			public @ResponseBody String[][] getChassisNumberDetails(@RequestParam String vinid,@RequestParam String regyea) {
				String[][] listlogs=new String[1][3];
				if(vinid.length()==17) {
					VehicalWmi vwi=vehicleService.getVwmiid(vinid.substring(0, 3));
					
					
					
						String[] vYear= {"A","B","C","D","E","F","G","H","J","K","L","M","N","P","R","S","T","V","W","X","Y","1","2","3","4","5","6","7","8","9"};
						//vinid.substring(beginIndex, endIndex)
						int b=0;
						int y=1980;
						for(int i=0;i<vYear.length;i++) {
							
							String x=vinid.substring(9, 10)+"";
							String z=vYear[i]+"";
							if(x.equals(z)) {
								b=y+i;
								if((b+30)<=Integer.parseInt(regyea.substring(0, 4))){
								    y=y+30;
								    i=0;
								}else{
								    break;
								}
						    }
							
							
						}
						listlogs[0][0]=(b)+""	;	
						if(vwi!=null) {
						listlogs[0][1]=vwi.getVehicleMakeID().getVehicleMakeID();
						listlogs[0][2]=vwi.getCountry();
						}
					}
				
			
					return listlogs;
			}
			
		    private static byte[] toByteArrayAutoClosable(BufferedImage image, String type) throws IOException {
		        try (ByteArrayOutputStream out = new ByteArrayOutputStream()){
		            ImageIO.write(image, type, out);
		            return out.toByteArray();
		        }
		    }
		    
			@RequestMapping(value = "createOcrId", method = RequestMethod.POST)
			public @ResponseBody String createOcrId( @RequestParam ("json") String json, @RequestParam ("vecno") String vecno, @RequestParam ("vtype") String vtype, @RequestParam ("apoid") String apoid) 
			{
			
				try {
			
				
			int ocrDetailsID;	
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();
		
			ocrDetailsID=vehicleService.maxOcrDetailsID();	
			
				
			 byte[] imagedata = DatatypeConverter.parseBase64Binary(json.substring(json.indexOf(",") + 1));	
				OcrDetails ocrDetails=new OcrDetails();
				ocrDetails.setOcrid(ocrDetailsID);
				ocrDetails.setOcrDate(dtf.format(now));
				ocrDetails.setNoimage(imagedata);
				ocrDetails.setOcrVid(vecno);
				ocrDetails.setVmStatus("pending");
				ocrDetails.setVrStatus("pending");
				ocrDetails.setDocStatus("pending");
				ocrDetails.setStatus("ACTIVE");
				ocrDetails.setAppNo(apoid);
				
				if(vtype.equals("1")||vtype.equals("3")) {
					ocrDetails.setVehicletype("Old");
				}else {
					ocrDetails.setVehicletype("New");
				}
				
				vehicleService.saveOcrDetailsRepo(ocrDetails);	
				
				      return ocrDetailsID+"";
			    
			   }catch(Exception e) {
				   
				  
				      e.printStackTrace();
					  return "0";
			   }
			   
			   
			   
			}
		    
			@RequestMapping(value = "changeStatusOcr", method = RequestMethod.POST)
			public @ResponseBody String changeStatusOcr(@RequestParam ("ocrid") String ocrid) 
			{
				try {		
					OcrDetails ocrDetails=vehicleService.getOcrDetailsById(Integer.parseInt(ocrid));					
					ocrDetails.setStatus("INACTIVE");
								
					vehicleService.saveOcrDetailsRepo(ocrDetails);				
					return "1";			    
			   }catch(Exception e) {				   				  
				   e.printStackTrace();
				   return "0";
			   }			      
			}
		    
			@RequestMapping(value = "saveLicensePlate", method = RequestMethod.POST)
			public @ResponseBody List<NumberDataBeen> saveWebCam( @RequestParam ("json") String json, @RequestParam ("id") String id) 
			{
				System.out.println( "ddd");
				List<NumberDataBeen> numberDataBeenlist=new ArrayList<NumberDataBeen>();
			//	System.out.println("ghgh="+id);
				try {
				String path1 = this.getClass().getClassLoader().getResource("").getPath();
				String fullPath = URLDecoder.decode(path1, "UTF-8");

				String pathArr[] = fullPath.split("/WEB-INF/classes/");

				System.out.println(fullPath);

				System.out.println(pathArr[0]);	
				
				
				
				
				
			String path= pathArr[0]+"/resources/Debug/";	
				
				
			int ocrDetailsID;	
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();
			if(id.equals("0")) {
			ocrDetailsID=vehicleService.maxOcrDetailsID();	
			
			}else {
			ocrDetailsID=Integer.parseInt(id)	;
			}	
				
				
				//public void saveOcrDetailsRepo(OcrDetails ocrDetails) 
			
				
			//	String[][] data =new String[15][2];
			   
			    byte[] imagedata = DatatypeConverter.parseBase64Binary(json.substring(json.indexOf(",") + 1));
			    System.out.println( imagedata );
			    BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
			    
			    String fileName="ocr/image/"+ocrDetailsID+".jpg";
			    File file= new File(path+fileName);
			    ImageIO.write(bufferedImage, "jpg",file);
			    
			    
				OcrDetails ocrDetails=new OcrDetails();
				ocrDetails.setOcrid(ocrDetailsID);
				ocrDetails.setOcrDate(dtf.format(now));
				ocrDetails.setNoimage(imagedata);
						
				vehicleService.saveOcrDetailsRepo(ocrDetails);
			    
			//	public String getPath() throws UnsupportedEncodingException {

		
				
				
				Runtime.getRuntime().exec(path+"sample.exe", null, new File(path)).waitFor();
				
					System.out.println("saveLicensePlate-sample");
			    
			  //    new BatRunner(path);
				
			
				//String[][] data;
			//	 Thread.sleep(15000);
				
				      File myObj = new File(path+"ocr/result/N_"+ocrDetailsID+".txt");
				      Scanner myReader = new Scanner(myObj);
				     // System.out.println("hhh="+myReader);
				     
				      
				     if (myReader.hasNextLine()) {
				    	 
				    	String str=myReader.nextLine().replace(" ", "");
	
			    	 String firstVnoset=str.substring(0,str.length()-4);
			    	 String lastForeVnoset=str.substring(str.length()-4);
				     String numbers[] = lastForeVnoset.split("[^0-9]+");
				      
			    	 
			    	 if(numbers.length!=4&&str.length()==10) {
			    		 
					    	String replacrString1=lastForeVnoset.replace("O", "0").replace("D", "0").replace("Q", "0").replace("C", "0");
					    	String replacrString2=replacrString1.replace("I", "1").replace("J", "1").replace("L", "1").replace("T", "1");
					    	String replacrString3=replacrString2.replace("B", "8").replace("S", "8");
					    	String replacrString4=replacrString3.replace("Z", "2");
					    	
						    NumberDataBeen numberDataBeen2=new NumberDataBeen();
						    numberDataBeen2.setId(ocrDetailsID);
						    numberDataBeen2.setNumber(firstVnoset+replacrString4);
						    numberDataBeenlist.add(numberDataBeen2);	
			    	 }else {
						    NumberDataBeen numberDataBeen=new NumberDataBeen();
						    numberDataBeen.setId(ocrDetailsID);	
						    numberDataBeen.setNumber(str);
						    numberDataBeenlist.add(numberDataBeen); 
			    		 
			    	 }
				    
				    
				    
				    
				    
				    
				    
				    
				     }else {
				    	 System.out.println("hhh=  gg");
						    NumberDataBeen numberDataBeen=new NumberDataBeen();
						    numberDataBeen.setId(ocrDetailsID);	
						    numberDataBeen.setNumber("");
						    numberDataBeenlist.add(numberDataBeen);	 
				    	 
				     }
				      
				     
				     
				     
				     
				     
				     
				     
				     
				     
				     // vm=data;
				      
				      
				    
				      myReader.close();
				      myObj.delete();
				      file.delete();
			          //  for(int i=0; i<data.length; i++){
			         //   	System.out.println("hh="+data[i][1]);
			         //   }
			   
				      
			    
			   }catch(Exception e) {
				   
				   System.out.println("An error occurred.");
				      e.printStackTrace();
			   }
			   
			   
			   return numberDataBeenlist;
			}
		    
			
			@RequestMapping(value = "takeAutoCapMore", method = RequestMethod.POST)
			public @ResponseBody String takeAutoCapMore( @RequestParam ("json") String json, @RequestParam ("vecno") String vecno) 
			{
			
			try {

			 byte[] imagedata = DatatypeConverter.parseBase64Binary(json.substring(json.indexOf(",") + 1));	
			 ByteArrayInputStream bais = new ByteArrayInputStream(imagedata);
		
				String path1 = this.getClass().getClassLoader().getResource("").getPath();
				String fullPath = URLDecoder.decode(path1, "UTF-8");

				String pathArr[] = fullPath.split("/WEB-INF/classes/");

				String path="";
				String exename="";
				
				String fileName="";
				String textFileName="";


				path= pathArr[0]+"/resources/Debug2/";	
				exename="SimpleLPR_UI.exe";
				fileName="image/more.jpg";
				textFileName="Number.txt";
				
				System.out.println("method 2 call");


			    	File file = new File(path+fileName);
			    	ImageIO.write(ImageIO.read(bais),"jpg",file);
			    	logger.info("Image is Saved");

			    	Runtime.getRuntime().exec(path+exename, null, new File(path)).waitFor();

			    	logger.info(exename+" Exe File Run Ok");
  
			    	String numberis="";
			    	
				      File myObj = new File(path+textFileName);
				      Scanner myReader = new Scanner(myObj);
				      if (myReader.hasNextLine()) {
				    	 
				    	  numberis= myReader.nextLine().replace(" ", "")+"";
				    	  logger.info("Get text file Data  ok");
				    
				     }else {
				    	 
				    	 numberis=""; 
				    	 logger.info("No Text File Created or Empty Text File");
				     }
				     //logger.info("Get Text file ok");

				      myReader.close();
				      myObj.delete();
				      file.delete();
				      logger.info("Image text File Deleted");
			 
			 
				return numberis;
			    
			   }catch(Exception e) {
				   
				   logger.info("Error-"+e.getLocalizedMessage());
				      e.printStackTrace();
					  return "";
			   }
			   
			   
			   
			}
			
			
			
			
			
			
		    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

		        @Override
		        public boolean accept(final File dir, final String name) {
		            
		                if (name.endsWith("." + "jpg")) {
		                    return (true);
		                
		                }else {
		            return (false);
		            }
		        }
		    };
			
			
		//Auto Capture License Plate Save Image in to DB
			
			@RequestMapping(value = "takeAutoNo", method = RequestMethod.POST)
			public @ResponseBody List<NumberDataBeen> takeAutoNo( HttpSession session) 
			{
			String centerid=session.getAttribute("centerid")+"";
			CenterMaster centerMaster=centerService.getcenterById(centerid); 
			
			String autoCapPath=centerMaster.getGetAutoCaptureImgPath();
			
			File dir = new File(autoCapPath);

				
			List<NumberDataBeen> numberDataBeenlist=new ArrayList<NumberDataBeen>();
				
				
				
		        if (dir.isDirectory()) { // make sure it's a directory
		        	
		        	int daysBack=1;
		        	
		            for (final File f : dir.listFiles(IMAGE_FILTER)) {
		                BufferedImage img = null;

		                try {
		                	long purgeTime = System.currentTimeMillis() - (daysBack  * 1 * 15 * 60 * 1000);
		                	
					        if(f.lastModified() < purgeTime) {
					            if(!f.delete()) {
					            	logger.info("Unable to delete file: " + f);
					               // System.err.println("Unable to delete file: " + f);
					            }
					         }
		                	
		                	
		                    img = ImageIO.read(f); 
		                    byte[] imgbyte=toByteArrayAutoClosable(img, "jpg");
						    NumberDataBeen numberDataBeen=new NumberDataBeen();
						    numberDataBeen.setId(1);	
						    numberDataBeen.setNumber(f.getName().replace(".jpg",""));
						   numberDataBeen.setNoimage(Base64.getEncoder().encodeToString(imgbyte));
						    numberDataBeen.setBytimage(imgbyte);
						    numberDataBeenlist.add(numberDataBeen);
                    
//		                    // you probably want something more involved here
//		                    // to display in your UI
//		                    System.out.println("image: " + f.getName());
//		                    System.out.println(" width : " + img.getWidth());
//		                    System.out.println(" height: " + img.getHeight());
//		                    System.out.println(" size  : " + f.length());
						
		                } catch (final IOException e) {
		                    // handle errors here
		                }
		            }
		        }
				
			   
			   return numberDataBeenlist;
			}			
			
			@RequestMapping(value = "getOcrVehicle", method = RequestMethod.POST)
			public @ResponseBody List<OcrDetails> takeOcrNo(HttpSession session) 
			{	List<OcrDetails> ocrStatusDetails=null;			
				ocrStatusDetails=vehicleService.pendingOcrDetails();	
				return ocrStatusDetails;
			}
			
			
			@RequestMapping(value = "takeOcrNo", method = RequestMethod.POST)
			public @ResponseBody List<OcrDetails> takeOcrNo(@RequestParam ("method") String method, HttpSession session) 
			{	List<OcrDetails> ocrStatusDetails=null;
				//ocrStatusDetails=vehicleService.pendingOcrStatusDetails(vmStatus,vrStatus,docStatus) mrthod;
				if(method.equals("vmStatus")) {
				ocrStatusDetails=vehicleService.pendingOcrStatusDetails("pending","pending","pending");
				}else if(method.equals("docStatus")) {
				ocrStatusDetails=vehicleService.pendingOcrStatusDetails("completed","pending","pending");	
				}else if(method.equals("vrStatus")) {
				ocrStatusDetails=vehicleService.pendingOcrStatusDetails("completed","pending","completed");
				}
				
				return ocrStatusDetails;
			}
			
			
			@RequestMapping(value = "getLicensePlateip", method = RequestMethod.POST)
			public @ResponseBody List<NumberDataBeen> getLicensePlateip(HttpSession session) 
			{
				
				String centerid=session.getAttribute("centerid")+"";
				List<NumberDataBeen> numberDataBeenlist=new ArrayList<NumberDataBeen>();
			//	System.out.println("ghgh="+id);
				try {
				String path1 = this.getClass().getClassLoader().getResource("").getPath();
				String fullPath = URLDecoder.decode(path1, "UTF-8");

				String pathArr[] = fullPath.split("/WEB-INF/classes/");

				System.out.println(fullPath);

				System.out.println(pathArr[0]);	
				
				
			//	int ocrDetailsID;	
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();
			//	if(id.equals("0")) {
			//	ocrDetailsID=vehicleService.maxOcrDetailsID();	
				
			//	}else {
			//	ocrDetailsID=Integer.parseInt(id)	;
			//	}
					
			
				
				String path="";
				String exename="";
				
				String fileName="";
				String textFileName="";
				
//				if(mthod.equals("1")){
//				//sample.exe  method 1
//			     path=pathArr[0]+"/resources/Debug/";	
//				 exename="sample.exe";
//				 fileName="ocr/image/"+ocrDetailsID+".jpg";
//				 textFileName="ocr/result/N_"+ocrDetailsID+".txt"; 
//				 
//				 System.out.println("method 1 call");
//				}else{
					
				path= pathArr[0]+"/resources/Debug2/";	
				exename="SimpleLPR_UI.exe";
				fileName="image/moNumber.jpg";
				textFileName="Number.txt";
				
				System.out.println("method 2 call");
//				}
				
	
				
				
			BufferedImage bufferedImage; 
			
			List<ConfigSystem> configDetails=testValueFileServices.getFTPServerInfo(centerid, "IPC");
			String ipAddress="";
			String userName="";
			String password="";
			String port="";
			String url="";
			
			for(ConfigSystem cs:configDetails) {
			 ipAddress=cs.getIpaddress();
			 userName=cs.getUserName();
			 password=cs.getPassword();
			 port=cs.getPort();
			 url=cs.getRootPath();
			 System.out.println("get Camera"+"rtsp://"+userName+":"+password+"@"+ipAddress+":"+port+"/"+url);
			}
			  logger.info("Get IpCamera Data"); 
			
			
			  OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("rtsp://"+userName+":"+password+"@"+ipAddress+":"+port+"/"+url);
			  	
			  		// "rtsp://nev:Nev123_456@192.168.1.8:554/cam/realmonitor?channel=1&subtype=0&unicast=true&proto=Onvif");
			       
			  IplImage iPimg;
			   
			    if(true) {
			 
			    	frameGrabber.start();
			    	logger.info("Ip Camera Start");
			    	iPimg = frameGrabber.grab();
			    	
			    	bufferedImage= new BufferedImage(iPimg.width(),iPimg.height(), BufferedImage.TYPE_3BYTE_BGR);
			    	iPimg.copyTo(bufferedImage);
			    	
			    	File file = new File(path+fileName);
			    	ImageIO.write(bufferedImage,"jpg",file);
			    	logger.info("Image is Saved");
			    //	canvasFrame.showImage(iPimg);
			    	frameGrabber.stop();
			    	Runtime.getRuntime().exec(path+exename, null, new File(path)).waitFor();
			    	
			    	file.delete();
			    	
			    	logger.info("Ip Camera Stop");
			    }
			    
			    
			   
//			    File file= new File(path+fileName);
//			    ImageIO.write(bufferedImage, "jpg",file);
			    
			    byte[] byteArray = toByteArrayAutoClosable(bufferedImage, "jpg");
			//	OcrDetails ocrDetails=new OcrDetails();
			//	ocrDetails.setOcrid(ocrDetailsID);
				//ocrDetails.setOcrDate(dtf.format(now));
				//ocrDetails.setNoimage(byteArray);
						
				//vehicleService.saveOcrDetailsRepo(ocrDetails);
			//	logger.info("Ocr Table Date Save");
			//	public String getPath() throws UnsupportedEncodingException {

		
				
				
				
				
				logger.info(exename+" Exe File Run Ok");
			//	 Thread.sleep(15000);
			
				
				      File myObj = new File(path+textFileName);
				      Scanner myReader = new Scanner(myObj);
				     // System.out.println("hhh="+myReader);
				      
				     if (myReader.hasNextLine()) {
				    	 System.out.println("hhh=  bb");
				    NumberDataBeen numberDataBeen=new NumberDataBeen();
			//	    numberDataBeen.setId(ocrDetailsID);	
				    numberDataBeen.setNumber(myReader.nextLine().replace(" ", ""));
				    numberDataBeen.setNoimage(Base64.getEncoder().encodeToString(byteArray));
				    numberDataBeen.setBytimage(byteArray);
				    numberDataBeenlist.add(numberDataBeen);
				    
				     }else {
				    	 System.out.println("hhh=  gg");
						    NumberDataBeen numberDataBeen=new NumberDataBeen();
					//	    numberDataBeen.setId(ocrDetailsID);	
						    numberDataBeen.setNumber("");
						    numberDataBeen.setNoimage(Base64.getEncoder().encodeToString(byteArray));
						    numberDataBeen.setBytimage(byteArray);
						    numberDataBeenlist.add(numberDataBeen);	 
				    	 
				     }
				     logger.info("Get Text file ok");
				     // vm=data;
				      
//					    	    while (myReader.hasNextLine()) {
//							    	String str=myReader.nextLine().replace(" ", "");
//							    	 if(str.length()>10) {
//								        NumberDataBeen numberDataBeen=new NumberDataBeen();
//									    numberDataBeen.setId(ocrDetailsID);	   
//									    numberDataBeen.setNumber(str.substring(str.indexOf('R'),10));
//									    numberDataBeenlist.add(numberDataBeen); 
//								    }
//								      
//							    	 NumberDataBeen numberDataBeen=new NumberDataBeen();
//									    numberDataBeen.setId(ocrDetailsID);	   
//									    numberDataBeen.setNumber(str);
//									    numberDataBeenlist.add(numberDataBeen);		
//								   
//							    	 
//							    	 String firstVnoset=str.substring(0,str.length()-4);
//							    	 String lastForeVnoset=str.substring(str.length()-4);
//								     String numbers[] = lastForeVnoset.split("[^0-9]+");
//								      
//							    	 
//							    	 if(numbers.length!=4) {
//							    		 
//							    	String replacrString1=lastForeVnoset.replace("O", "0").replace("D", "0").replace("Q", "0").replace("C", "0");
//							    	String replacrString2=replacrString1.replace("I", "1").replace("J", "1").replace("L", "1").replace("T", "1");
//							    	String replacrString3=replacrString2.replace("B", "8").replace("S", "8");
//							    	String replacrString4=replacrString3.replace("Z", "2");
//							    	
//								    NumberDataBeen numberDataBeen2=new NumberDataBeen();
//								    numberDataBeen2.setId(ocrDetailsID);
//								    numberDataBeen2.setNumber(firstVnoset+replacrString4);
//								    numberDataBeenlist.add(numberDataBeen2);	
//							    	 }
//								    
					    	 //*************************************
				    
				      myReader.close();
				      myObj.delete();
				      logger.info("Image text File Deleted");
				      //file.delete();
			          //  for(int i=0; i<data.length; i++){
			         //   	System.out.println("hh="+data[i][1]);
			         //   }
			   
				      
			    
			   }catch(Exception e) {
				   logger.error("This is an error = "+e.getMessage());
				   System.out.println("An error occurred.");
				      
			   }
			   
			   
			   return numberDataBeenlist;
			}
		
			
			
			@ModelAttribute("usercombo")
			public List<Users> viewAllUser() {
				List<Users> usercombo = usersService.listAll();
				return usercombo;

			}
	       
			
			
			@RequestMapping(value="/tesFeeDetails", method=RequestMethod.GET)
			public @ResponseBody String[] tesFeeDetails(@RequestParam String  vecCatID,@RequestParam String  vrTypId,@RequestParam String  centerId) {
				
				String[]  x=new String[4];
				
				
				TestCategory testCategory=centerService.getCategoryId(vecCatID);
				VehicleRegisterType vrtyp=vehicleService.getRegType(vrTypId);
				
				CenterMaster centerMaster=centerService.getcenterById(centerId);
				String countrcode=centerMaster.getPartner_ID().getCountry_Code().getCountryCode();
				String currency=centerMaster.getPartner_ID().getCountry_Code().getCurrency();
				long testFee=testCategory.getCategoryFee();
				long testFeePresent=vrtyp.getvTestFeePre();
            	long calTestFee=testFee*testFeePresent/100;
				
				List<TaxConfiguration> getTaxFromCountrylist=vehicleService.getTaxFromCountry(countrcode);
				
				Long taxamt=Long.parseLong("0");
            	for(TaxConfiguration taxdetail:getTaxFromCountrylist) {
	            		
	            		if(taxdetail.getType().equals("Rate")) {
	            		 taxamt=taxamt+(calTestFee*taxdetail.getTaxRate()/10000);
	            		}else {
	            		 taxamt=taxamt+taxdetail.getTaxRate();	
	            			
	            		}
	
            	}
		
            	x[0]=(calTestFee/100)+"";
            	x[1]=(taxamt/100)+"";
            	x[2]=((calTestFee+taxamt)/100)+"";	
            	x[3]=currency;
            	
            	
            	
            	
            	return x;
			}
			@RequestMapping(value="/tesTime", method=RequestMethod.GET)
			public @ResponseBody String[] tesTime(@RequestParam String  vecCatID) {
				
				String[]  x=new String[4];
				
				
				TestCategory testCategory=centerService.getCategoryId(vecCatID);
				//DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
				//Calendar cal = Calendar.getInstance();
				
				 String aprtime =testCategory.getTestAproTime();
				 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
				 Calendar cal = Calendar.getInstance();
				 String curTime = df.format(cal.getTime());
				 
				 Date d=new Date();
				try {
					d = df.parse(aprtime);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

				 cal.setTime(d);
				 cal.add(Calendar.MINUTE, Integer.parseInt(aprtime));
				 String newTime = df.format(cal.getTime());
				
				
            	x[0]=aprtime+"";
            	x[1]="0";
            	x[2]=curTime;
            	x[3]=newTime;
            	

				return x;
			}
			
			
			@RequestMapping(value="/checkVinNo", method=RequestMethod.GET)
			public @ResponseBody List<VehicleMaster> checkVinNo(@RequestParam String  vinno,@RequestParam String veNo) {				
				List<VehicleMaster> vm=vehicleService.checkVinNo(vinno,veNo);
				return vm;
			}
			
			@RequestMapping(value="/checkEngNo", method=RequestMethod.GET)
			public @ResponseBody List<VehicleMaster> checkEngNo(@RequestParam String  engno,@RequestParam String veNo) {				
				List<VehicleMaster> vm=vehicleService.checkEngNo(engno,veNo);
				return vm;
			}	
			
			
			@RequestMapping(value="/getvehicleModelSelect", method=RequestMethod.GET)
			public  @ResponseBody  List<VehicleModel> getVehicleModel(@RequestParam String make,@RequestParam String clas) {
				System.out.println("ghgggggggggggggg");
				List<VehicleModel> vmodel = vehicleService.getModelByID(make,clas);
				return vmodel;
			}
			@RequestMapping(value="/getCheckModelValue", method=RequestMethod.GET)
			public  @ResponseBody  String getCheckModel(@RequestParam String make,@RequestParam String clas,@RequestParam String modelname) {
			
				List<VehicleModel> vmodel = vehicleService.getModelCheck(make,clas,modelname);
				if(vmodel.size()>0) {
					return "0";
				}else {
					return "1";
				}
				
			}
			@RequestMapping(value="/getTestStatusVehicleRegistation", method=RequestMethod.GET)
			public  @ResponseBody  List<VehicleRegistration> getTestStatusVehicleRegistation(@RequestParam String vehicleID) {
				System.out.println("ghgggggggggggggg");
				List<VehicleRegistration> vmodel = vehicleService.getTestStatusVehicleRegistation(vehicleID);
				return vmodel;
			}	
			
			
			
			@RequestMapping(value="/getComboState", method=RequestMethod.GET)
			public   @ResponseBody List<CountryState> getComboState(@RequestParam String countryCode ) {
				List<CountryState> counState = centerService.getallStateFromCountry(countryCode);
				return counState;
			}
			
			
//			@RequestMapping(value="/getTestStatusVehicleRegistation", method=RequestMethod.GET)
//			public  @ResponseBody  List<TestLaneHead> getTestLaneHeadDetailByCenterCombo(@RequestParam String centerid) {
//				List<TestLaneHead> vmodel = laneServices.getTestLaneHeadDetailByCenter(centerid);
//				return vmodel;
//			}
//			
	
			@RequestMapping(value="/getTestLaneHeadvc", method=RequestMethod.GET)
			public @ResponseBody String[][] getTestLaneHeadDetailByCVclass(@RequestParam String  catid,@RequestParam String  vclassid,@RequestParam String  cenid) {
				
				String[][] laneList=laneServices.getTestLaneHeadDetailByCenterCategoryVclass(catid,vclassid,cenid); 
		
				return laneList;
			}	
			
			  @RequestMapping(value = "/VehicleReportPreview", method=RequestMethod.GET) 
			  public String VehicleDetailsReportPrevew(Map<String, String> model) { 

				  return "VehicleDetailsReport";
			  }	
	
			
			  @RequestMapping(value = "/VehicleDetailsReport",method=RequestMethod.POST)
			  public ModelAndView VehicleDetailsReport(String recDate,HttpServletResponse response,HttpSession session) {
				  
				  ModelAndView mav = new ModelAndView("VehicleDetailsReport");
				  
				  String centerid=session.getAttribute("centerid")+"";
				  CenterMaster centerMaster=centerService.getcenterById(centerid);
				  
				   List<VehicleRegistration> vehicleregdetail=vehicleService.getVehicleRegDetailByDate(recDate,centerid);
				  	
				  	List<VehicleReportByDateBeen> vehicleReportByDateBeenList = new ArrayList<VehicleReportByDateBeen>();
				  	for(VehicleRegistration vrData:vehicleregdetail) {
				  		VehicleReportByDateBeen vehicleReportByDateBeen=new VehicleReportByDateBeen();
				  		vehicleReportByDateBeen.setTestcat(vrData.getTestCategory().getCategoryType());
				  		vehicleReportByDateBeen.setLregid(vrData.getTestLaneHeadId().getLaneName());
				  		vehicleReportByDateBeen.setVclass(vrData.getVid().getVmodel().getVehicleClass().getVehicleClass());
				  		vehicleReportByDateBeen.setVno(vrData.getVid().getVehicleID());
				  		vehicleReportByDateBeen.setRegtime(vrData.getTime());
				  		vehicleReportByDateBeen.setRegtype(vrData.getVtype().getvRegType());
				  		vehicleReportByDateBeen.setInspecter(vrData.getUser().getUserName());
				  		
				  	
				  		ReceiptHead rechead=vehicleService.getReceiptHeadDetailsByVRid(vrData.getVregID());
				  		
				  		
				  		vehicleReportByDateBeen.setRecno(rechead.getRecNo());
				  		vehicleReportByDateBeen.setTestfee((rechead.getTestFee()/100)+"");
				  		vehicleReportByDateBeen.setNetfee((rechead.getNetTotal()/100)+"");
				  		vehicleReportByDateBeen.setCertno("");
				  		vehicleReportByDateBeen.setVistatus("");
				  		vehicleReportByDateBeen.setTeststatus("");
				  		vehicleReportByDateBeenList.add(vehicleReportByDateBeen);
				  	}
					//session.setAttribute("centerid", userObj.get(0).getCenter_ID().getCenter_ID());
					//session.setAttribute("centerName", userObj.get(0).getCenter_ID().getCenter());
				  	
				 // 	session.getAttribute("centerName");
	          
		          	ReportViewe review=new ReportViewe();
		          	Map<String,Object> params = new HashMap<>();
		          	
		          	
		          	
		        	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
		          	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
		          	params.put("address",centerMaster.getAdd03() );
		          	params.put("date",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(recDate)));
		          	
		       
		          	String reptValue="";
		          	
		         try {
		          		reptValue=review.pdfReportViewInlineSystemOpen("vehicledetailsreport.jasper","Vehicle Details Report",vehicleReportByDateBeenList,params,response);
		          		
		          
		          	}catch(Exception e) {	          		
		          		e.printStackTrace();          		
		          	}
				  
				  mav.addObject("pdfViewEq", reptValue); 
				  return mav;
			  }
			
			
			  @RequestMapping(value = "/revenueStatementPrivew", method=RequestMethod.GET) 
			  public String RevenueStatementPrevew(Map<String, String> model) { 

				  return "revenueStatement";
			  }
			
			
			
			  @RequestMapping(value = "/revenueStatement",method=RequestMethod.POST)
			  public ModelAndView RevenueStatementReport(String recDate,HttpServletResponse response,HttpSession session) {
				  
				  ModelAndView mav = new ModelAndView("VehicleDetailsReport");
				  
				  String centerid=session.getAttribute("centerid")+"";
				  CenterMaster centerMaster=centerService.getcenterById(centerid);
				  
				   List<VehicleRegistration> vehicleregdetail=vehicleService.getVehicleRegDetailByDate(recDate,centerid);
				  	
				  	List<RevenueStatementBeen> vehicleReportByDateBeenList = new ArrayList<RevenueStatementBeen>();
				  	for(VehicleRegistration vrData:vehicleregdetail) {
				  		RevenueStatementBeen vehicleReportByDateBeen=new RevenueStatementBeen();
				  		vehicleReportByDateBeen.setTestcat(vrData.getTestCategory().getCategoryType());
				  		vehicleReportByDateBeen.setLregid(vrData.getTestLaneHeadId().getLaneName());
				  		vehicleReportByDateBeen.setVclass(vrData.getVid().getVmodel().getVehicleClass().getVehicleClass());
				  		vehicleReportByDateBeen.setVno(vrData.getVid().getVehicleID());
				  		vehicleReportByDateBeen.setRegtime(vrData.getTime());
				  		vehicleReportByDateBeen.setRegtype(vrData.getVtype().getvRegType());
				  		vehicleReportByDateBeen.setInspecter(vrData.getUser().getUserName());
				  	
				  		ReceiptHead rechead=vehicleService.getReceiptHeadDetailsByVRid(vrData.getVregID());
				  		
				  		
				  		vehicleReportByDateBeen.setRecno(rechead.getRecNo());
				  		vehicleReportByDateBeen.setTestfee((rechead.getTestFee()/100)+"");
				  		vehicleReportByDateBeen.setNetfee((rechead.getNetTotal()/100)+"");
				  		vehicleReportByDateBeen.setCertno("");
				  		vehicleReportByDateBeen.setVistatus("");
				  		vehicleReportByDateBeen.setTeststatus("");
			  	 
					  	VehicleOwner vehicleOwner=vehicleService.getVehicleOwnerIDByVehicleID(vrData.getVid().getVehicleID());
				  		//System.out.println("ffffff="+vrData.getCusid().getId());
				  		if(vrData.getCusid().getId().equals("0000")) {
				  			System.out.println("owner=");
				  		vehicleReportByDateBeen.setCusname(vehicleOwner.getOwnerName());
				  		}else {
				  			System.out.println("customer=");
				  			vehicleReportByDateBeen.setCusname(vrData.getCusid().getName());
				  			
				  		}
				  		vehicleReportByDateBeen.setTax(((rechead.getNetTotal()/100)-(rechead.getTestFee()/100))+"");
				  		vehicleReportByDateBeenList.add(vehicleReportByDateBeen);
				  	}
					//session.setAttribute("centerid", userObj.get(0).getCenter_ID().getCenter_ID());
					//session.setAttribute("centerName", userObj.get(0).getCenter_ID().getCenter());
				  	
				 // 	session.getAttribute("centerName");
	          
		          	ReportViewe review=new ReportViewe();
		          	Map<String,Object> params = new HashMap<>();
		          	
		          	
		          	
		        	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
		          	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
		          	params.put("address",centerMaster.getAdd03() );
		          	params.put("date",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(recDate)));
		          	
		       
		          	String reptValue="";
		          	
		         try {
		          		reptValue=review.pdfReportViewInlineSystemOpen("revenuestatement.jasper","Revenue Statement",vehicleReportByDateBeenList,params,response);
		          		
		          
		          	}catch(Exception e) {	          		
		          		e.printStackTrace();          		
		          	}
				  
				  mav.addObject("pdfViewEq", reptValue); 
				  return mav;
			  }	
			  
			  @RequestMapping(value = "/vehicalRecCancel", method=RequestMethod.GET) 
			  public String getvehicalRecCancel(Map<String, String> model) { 

				  return "VehicleReciptCancel";
			  }				  
			  
			  @RequestMapping(value="/getRecdetailsPrivew" ,method=RequestMethod.GET)
			  public @ResponseBody String vehiclRecitDetail(@RequestParam String reccno,HttpServletResponse response) {
	
				  	String reptValue=vehicalRescetGeaerate(reccno, response);
	 
		         return reptValue;
			  }  
			  
			  @RequestMapping(value="/runCancelReceipt" ,method=RequestMethod.GET)
			  public @ResponseBody String runCancelReceipt(@RequestParam String reccno) {
				  
				  try {
				  vehicleService.setCancelReceipt(reccno);
				  return "1";
				  }catch(Exception e) {
					  
				 return "0"; 
				  }
		  		       
			  } 		  
			  
			  @RequestMapping(value = "/vehicalInvCancel", method=RequestMethod.GET) 
			  public String getVehicalInvCancel(Map<String, String> model) { 

				  return "VehicleInvoiceCancel";
			  }			  
			  
			  @RequestMapping(value="/getInvoicePrivew" ,method=RequestMethod.GET)
			  public @ResponseBody String invInvoiceCancel(@RequestParam String invNo,HttpServletResponse response) {
	
				  	String invValue=vehicalInvoiceGeaerate(invNo, response);
	 
		         return invValue;
			  }  
			  
			  @RequestMapping(value="/runCancelInvoice" ,method=RequestMethod.GET)
			  public @ResponseBody String runCancelInvoice(@RequestParam String invNo) {
				  
				  try {
				  vehicleService.setCancelInvoice(invNo);
				  return "1";
				  }catch(Exception e) {
					  
				 return "0"; 
				  }
		  		       
			  }   
 
			  @RequestMapping(value = "/getCustomerbyvehical", method=RequestMethod.GET) 
			  public @ResponseBody Customer getCustomerDetails(@RequestParam String cusid) {
				  
				  return usersService.viewCustomersDetailByID(cusid);
				  
			  }	
			  
			  @RequestMapping(value = "/invoiceSummaryReport", method=RequestMethod.GET) 
			  public String viewInvoiceSummaryReport(Map<String, String> model) { 

				  return "invoiceSummaryRpt";
			  }
			  
			  @RequestMapping(value = "/privewInvoiceSummaryReport",method=RequestMethod.POST)
			  public ModelAndView getInvoiceSummaryReport(String fromdate,String todate,String repStatu,HttpServletResponse response,HttpSession session) {
				 // System.out.println("repStatu="+repStatu);
				  ModelAndView mav = new ModelAndView("invoiceSummaryRpt");
				  
				  String centerid=session.getAttribute("centerid")+"";
				  CenterMaster centerMaster=centerService.getcenterById(centerid);
				  
				  List<InvoiceHead> invoiceheadDetails=vehicleService.getInvoiceHeadDetailBytwoDate(fromdate,todate);
				  	
				  	List<InvoiceSummaryReportBeen> invoiceSummaryReportBeenList = new ArrayList<InvoiceSummaryReportBeen>();
				  	for(InvoiceHead ihData:invoiceheadDetails) {
				  		
				  		if(repStatu==null&&ihData.getStatus().equals("INACTIVE")) {
				  			continue;
				  		}
				  		
				  		
					  	if(ihData.getvRegisterID().getCentermaster().getCenter_ID().equals(centerMaster.getCenter_ID())) {
					  		InvoiceSummaryReportBeen invoiceSummaryReportBeen=new InvoiceSummaryReportBeen();
					  		invoiceSummaryReportBeen.setInvtime(ihData.getInvoiceTime());
					  		invoiceSummaryReportBeen.setInvdate(DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(ihData.getInvoiceDate())));
					  		
					  		if(ihData.getvRegisterID().getCusid().getId().equals("0000")) {
					  			VehicleOwner vehicleOwner=vehicleService.getVehicleOwnerIDByVehicleID(ihData.getvRegisterID().getVid().getVehicleID());
					  			invoiceSummaryReportBeen.setCusname(vehicleOwner.getOwnerName());
					  		}else {				  			
					  			invoiceSummaryReportBeen.setCusname(ihData.getvRegisterID().getCusid().getName());	
					  		}
		
					  		invoiceSummaryReportBeen.setInvno(ihData.getInvoiceNo());
					  		invoiceSummaryReportBeen.setTestfee((ihData.getTestFee()/100)+"");
					  		invoiceSummaryReportBeen.setTax(((ihData.getNetTotal()/100)-(ihData.getTestFee()/100))+"");
					  		invoiceSummaryReportBeen.setNetfee((ihData.getNetTotal())+"");
					  		if(ihData.getStatus().equals("INACTIVE")) {
					  		invoiceSummaryReportBeen.setInvstatus("CANCEL INVOICE");
					  		}else {
					  			invoiceSummaryReportBeen.setInvstatus(ihData.getStatus()+" INVOICE");		
					  		}
					  		invoiceSummaryReportBeenList.add(invoiceSummaryReportBeen);
					  	}
				  	}

	          
		          	ReportViewe review=new ReportViewe();
		          	Map<String,Object> params = new HashMap<>();
		          	
		          	
		          	
		        	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
		          	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
		          	params.put("address",centerMaster.getAdd03() );
		          	params.put("fromdate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(fromdate)));
		          	params.put("todate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(todate)));
		       
		          	String reptValue="";
		          	
		         try {
		          		reptValue=review.pdfReportViewInlineSystemOpen("invoiceSummaryReport.jasper","Invoice Summary",invoiceSummaryReportBeenList,params,response);
		          		
		          
		          	}catch(Exception e) {	          		
		          		e.printStackTrace();          		
		          	}
				  
				  mav.addObject("pdfViewEq", reptValue); 
				  return mav;
			  } 
			  
			  @RequestMapping(value = "/incomingPayment", method=RequestMethod.GET) 
			  public String incomingPayment(Map<String, String> model) { 

				  return "incomingPayment";
			  } 
			  
			  @RequestMapping(value = "/getIncomingPaymentDetails", method=RequestMethod.GET) 
			  public @ResponseBody List<InvoiceHead> getIncomingPaymentDetails(@RequestParam String cusid) {
				  
				  return vehicleService.getIncomingPaymentDetails(cusid);
				  
			  }	

	@RequestMapping(value = "/payIncomingPayment", method = RequestMethod.POST)
	public ModelAndView payIncomingPayment(@RequestParam long payAmt, @RequestParam long totDueAmt ,@RequestParam String paytype, @RequestParam String name, @RequestParam String number, @RequestParam String glAccno, @RequestParam String expDate, @RequestParam long bankCharges, @RequestParam String customer, HttpServletResponse response,HttpSession session) {
		ModelAndView mav = new ModelAndView("incomingPayment");
		
		List<InvoiceHead> invoiceHead = vehicleService.getIncomingPaymentDetails(customer);

	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    Date date = new Date();  
	    DateTimeFormatter formattertime = DateTimeFormatter.ofPattern("HH:mm:ss");
	    LocalTime time = LocalTime.now();
	    
	    Customer custo=new Customer();
	    custo.setId(customer);

		  
		  String centerid=session.getAttribute("centerid")+"";
		  CenterMaster centerMaster=centerService.getcenterById(centerid);
	    
       	int maxinRecno=centerMaster.getPartner_ID().getMaxInRecNo();
    	String inRecFormate=centerMaster.getPartner_ID().getInRecformate();
    	String nextinRecNo=inRecFormate+(maxinRecno+1);
  
		IncomingReceiptHead incomingReceiptHead=new IncomingReceiptHead();
		
		incomingReceiptHead.setInRecNo(nextinRecNo);
		incomingReceiptHead.setCenter_ID(centerMaster);
		incomingReceiptHead.setCusid(custo);
		
		incomingReceiptHead.setInRecDate(formatter.format(date));
		incomingReceiptHead.setInRecTime(time.format(formattertime));
		
		incomingReceiptHead.setTotDueAmt(totDueAmt*100);
		incomingReceiptHead.setPayAmt(payAmt*100);
		
		incomingReceiptHead.setBalance((totDueAmt-payAmt)*100);
		incomingReceiptHead.setPayType(paytype);
		incomingReceiptHead.setPayName(name);
		incomingReceiptHead.setPayNumber(number);
		incomingReceiptHead.setPayGlacc(glAccno);
		incomingReceiptHead.setDate(expDate);
		incomingReceiptHead.setBankCharg(bankCharges*100);
		incomingReceiptHead.setStatus("ACTIVE");
		
		
		List<InvoiceHead> invoiceHeadList = new ArrayList<InvoiceHead>();
		 
		List<IncomingReceiptDetails> incomingReceiptDetailsList = new ArrayList<IncomingReceiptDetails>();
		
		for (InvoiceHead ihDate : invoiceHead) {

			IncomingReceiptDetails incomingReceiptDetails=new IncomingReceiptDetails();
			incomingReceiptDetails.setInvBalance(ihDate.getBalance());
			
			
			long oldPayAmt=ihDate.getPayAmount();
			long cpayAmt = 0;
			long calBal = ihDate.getBalance()/100;

			if (payAmt <= 0) {
				cpayAmt = 0;
				//calBal = 0;
			} else {
				payAmt = payAmt - (ihDate.getBalance() / 100);
				if (payAmt > 0) {
					cpayAmt = ihDate.getBalance() / 100;
					calBal = 0;
				} else {
					cpayAmt = payAmt + (ihDate.getBalance() / 100);
					calBal = (ihDate.getBalance() / 100) - cpayAmt;
				}
		}

			ihDate.setBalance(calBal*100);
			ihDate.setPayAmount((oldPayAmt+(cpayAmt*100)));
			if(calBal==0) {
			ihDate.setPayStatus("Close");
			}
			
			incomingReceiptDetails.setInRecNo(incomingReceiptHead);
			incomingReceiptDetails.setVehicle_ID(ihDate.getvRegisterID().getVid());
			incomingReceiptDetails.setInvoiceNo(ihDate);
			incomingReceiptDetails.setInvTotal(ihDate.getNetTotal());
			
			incomingReceiptDetails.setPayAmount((cpayAmt*100));
			incomingReceiptDetails.setCurBalance(calBal*100);
		
			
			if(cpayAmt>0) {
			incomingReceiptDetailsList.add(incomingReceiptDetails);
			}
			
			
		 // 	ReceiptHead receiptHead=new ReceiptHead(nextRecno, null, vehiclereg.getDate(),vehiclereg.getTime(),calTestFee,"New Vehicle Register","N/A","ACTIVE")
        //.setNetTotal(nettotal+calTestFee);
			
			invoiceHeadList.add(ihDate);
			
	
		}
		
		vehicleService.saveAllInvoiceHead(invoiceHeadList);
		
		businessPartnerService.setUpdateLastinRecNo(centerMaster.getPartner_ID().getPartner_ID());
		
		
		vehicleService.saveIncomingReceiptHead(incomingReceiptHead);
		vehicleService.saveAllIncomingReceiptDetails(incomingReceiptDetailsList);
		
		
		
		
	 String reptValue=incomingReceiptGeaerate(incomingReceiptHead,incomingReceiptDetailsList,response);
	 mav.addObject("pdfViewEq", reptValue); 
	 
	 return mav;
	}	
	
	public String incomingReceiptGeaerate(IncomingReceiptHead incomingReceiptHead,
	   List<IncomingReceiptDetails> incomingReceiptDetailsList, HttpServletResponse response) {

		if (incomingReceiptHead.getStatus().toString().equals("ACTIVE")) {
			long totalPay=0;

			List<IncomingReceiptBeen> incomingReceiptBeenList=new ArrayList<IncomingReceiptBeen>(); 
			for(IncomingReceiptDetails incomingReceiptDetails:incomingReceiptDetailsList) {
			IncomingReceiptBeen incomingReceiptBeen=new IncomingReceiptBeen();
			incomingReceiptBeen.setInvno(incomingReceiptDetails.getInvoiceNo().getInvoiceNo());
			incomingReceiptBeen.setVecno(incomingReceiptDetails.getVehicle_ID().getVehicleID());
			incomingReceiptBeen.setInctotal(StringFormaterWeb.formatToRupees(incomingReceiptDetails.getInvTotal()));
			incomingReceiptBeen.setPayamount(StringFormaterWeb.formatToRupees(incomingReceiptDetails.getPayAmount()));
			incomingReceiptBeen.setBalance(StringFormaterWeb.formatToRupees(incomingReceiptDetails.getCurBalance()));
			incomingReceiptBeen.setStyle(false);
			incomingReceiptBeenList.add(incomingReceiptBeen);
			
			totalPay=totalPay+incomingReceiptDetails.getPayAmount();
			}
			
			
			IncomingReceiptBeen incomingReceiptBeen2=new IncomingReceiptBeen();
			incomingReceiptBeen2.setInvno("TOTAL");
			incomingReceiptBeen2.setVecno("");
			incomingReceiptBeen2.setInctotal("");
			incomingReceiptBeen2.setPayamount(StringFormaterWeb.formatToRupees(totalPay));
			incomingReceiptBeen2.setBalance("");
			incomingReceiptBeen2.setStyle(true);
			incomingReceiptBeenList.add(incomingReceiptBeen2);
			
			
			
			
//			CenterMaster centerMaster = centerService.getcenterById(vehiclereg.getCentermaster().getCenter_ID());

			ReportViewe review = new ReportViewe();
			Map<String, Object> params = new HashMap<>();
			params.put("img", incomingReceiptHead.getCenter_ID().getPartner_ID().getPartner_Logo());
			params.put("hedder", incomingReceiptHead.getCenter_ID().getPartner_ID().getReceiptHeader());
			params.put("address", incomingReceiptHead.getCenter_ID().getAdd03());
			params.put("footer", incomingReceiptHead.getCenter_ID().getPartner_ID().getReceiptFooter());
		
           Customer customer=usersService.viewCustomersDetailByID(incomingReceiptHead.getCusid().getId());
			params.put("name", customer.getName());
			params.put("mobileno", customer.getTpno());
			params.put("cusaddress", customer.getAddress());
			params.put("taxcode", customer.getTaxcode());
			
			params.put("inrecno", incomingReceiptHead.getInRecNo());
			params.put("inrectime", incomingReceiptHead.getInRecTime());
			params.put("inreDate", incomingReceiptHead.getInRecDate());
			params.put("paytype", incomingReceiptHead.getPayType());
			
			
			String reptValue = "";

			try {
				reptValue = review.pdfReportViewInlineSystemOpen("incomingReceipt.jasper", "Incoming Receipt",
						incomingReceiptBeenList, params, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return reptValue;
		} else {

			return "INACTIVE";

		}

	}
	
	  @RequestMapping(value = "/reprintIncomingReceipt", method=RequestMethod.GET) 
	  public String getreprintIncomingReceipt(Map<String, String> model) { 
		  
		  return "ReprintIncomingReceipt";
	  }	
	  
	  @RequestMapping(value="/PrivewReprintIncomingReceipt" ,method=RequestMethod.POST) 
	  public ModelAndView printReprintIncomingReceipt(@RequestParam String inreccno,@RequestParam String inrecDate,HttpServletResponse response) {
		  	ModelAndView mav = new ModelAndView("ReprintIncomingReceipt");
  	
		  	IncomingReceiptHead incomingReceiptHead=vehicleService.getIncomingReceiptHeadbyInvoiceNo(inreccno);	  	
		  	List<IncomingReceiptDetails> incomingReceiptDetailsList=vehicleService.getIncomingReceiptDetailsbyInvoiceNo(inreccno);
		  	String reptValue=incomingReceiptGeaerate(incomingReceiptHead,incomingReceiptDetailsList, response);
		  	mav.addObject("pdfViewEq", reptValue); 
         return mav;
	  }
	  @RequestMapping(value = "/getIncomingReceiptNoByDate", method=RequestMethod.GET) 
	  public @ResponseBody List<IncomingReceiptHead> getIncomingReceiptNoByDate(@RequestParam String vRdate) { 			  
		  List<IncomingReceiptHead> incomingReceiptHead = vehicleService.getIncomingReceiptNoByDate(vRdate);
		  return incomingReceiptHead;
	  }
	  @RequestMapping(value = "/incomingReceiptSummary", method=RequestMethod.GET) 
	  public String getIncomingReceiptSummaryRpt(Map<String, String> model) { 
		 // incomingReceiptSummaryRpt
		  return "incomingReceiptSummaryRpt";
	  }
	  
	  @RequestMapping(value = "/PreviewIncomingReceiptSummary",method=RequestMethod.POST)
	  public ModelAndView getInvoiceSummaryReport(String fromdate,String todate,HttpServletResponse response,HttpSession session) {
		 // System.out.println("repStatu="+repStatu);
		  ModelAndView mav = new ModelAndView("incomingReceiptSummaryRpt");
		  
		  String centerid=session.getAttribute("centerid")+"";
		  CenterMaster centerMaster=centerService.getcenterById(centerid);
		  
		  List<IncomingReceiptHead> incomingReceiptHeadlist=vehicleService.getIncomingReceiptHeadBytwoDate(fromdate,todate);
		  
		  List<IncomingReceiptSummaryBeen> incomingReceiptSummaryBeenList = new ArrayList<IncomingReceiptSummaryBeen>();
		  
		  	for(IncomingReceiptHead ihData:incomingReceiptHeadlist) {
	
			  	if(ihData.getCenter_ID().getCenter_ID().equals(centerMaster.getCenter_ID())) {
			  		IncomingReceiptSummaryBeen incomingReceiptSummaryBeen=new IncomingReceiptSummaryBeen();
			  		
			  		incomingReceiptSummaryBeen.setIncrecno(ihData.getInRecNo());
			  		incomingReceiptSummaryBeen.setCusname(ihData.getCusid().getName());
			  		incomingReceiptSummaryBeen.setInrecdate(ihData.getInRecDate());
			  		incomingReceiptSummaryBeen.setInrectime(ihData.getInRecTime());
			  		incomingReceiptSummaryBeen.setTotdue(StringFormaterWeb.formatToRupees(ihData.getTotDueAmt()));
			  		incomingReceiptSummaryBeen.setPayamt(StringFormaterWeb.formatToRupees(ihData.getPayAmt()));
			  		incomingReceiptSummaryBeen.setBalance(StringFormaterWeb.formatToRupees(ihData.getBalance()));
			  		incomingReceiptSummaryBeen.setPaytype(ihData.getPayType());
			  		incomingReceiptSummaryBeen.setSatus(ihData.getStatus());
			  		incomingReceiptSummaryBeen.setCurrency(centerMaster.getPartner_ID().getCountry_Code().getCurrency());
			  		
			  
			  		incomingReceiptSummaryBeenList.add(incomingReceiptSummaryBeen);
			  	}
		  	}
	
          	ReportViewe review=new ReportViewe();
          	Map<String,Object> params = new HashMap<>();

        	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
          	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
          	params.put("address",centerMaster.getAdd03() );
          	params.put("fromdate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(fromdate)));
          	params.put("todate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(todate)));
       
          	String reptValue="";
          	
         try {
          		reptValue=review.pdfReportViewInlineSystemOpen("incomingReceiptSummaryReport.jasper","Incoming ReceiptS ummary",incomingReceiptSummaryBeenList,params,response);
          		
          
          	}catch(Exception e) {	          		
          		e.printStackTrace();          		
          	}
		  
		  mav.addObject("pdfViewEq", reptValue); 
		  return mav;
	  } 
	  
	  @RequestMapping(value = "/ageAnalysisReport", method=RequestMethod.GET) 
	  public String getAgeAnalysisReport(Map<String, String> model) { 
		 // incomingReceiptSummaryRpt ageAnalysisReport
		  return "ageAnalysisRpt";
	  }
	  
	  
	  @RequestMapping(value = "/PreviewAnalysisReport",method=RequestMethod.POST)
	  public ModelAndView getInvoiceSummaryReport(HttpServletResponse response,HttpSession session) {
		 // System.out.println("repStatu="+repStatu);
		  ModelAndView mav = new ModelAndView("ageAnalysisRpt");
		  
		  String centerid=session.getAttribute("centerid")+"";
		  CenterMaster centerMaster=centerService.getcenterById(centerid);
		  
		  List<InvoiceHead> invoiceHeadlist=vehicleService.getAllActiveInvoiceHead();
		  
		  
		  List<AnalysisReportBeen> analysisReportBeenList = new ArrayList<AnalysisReportBeen>();
		  for(InvoiceHead ihData:invoiceHeadlist) {
			  AnalysisReportBeen analysisReportBeen=new AnalysisReportBeen();
			  analysisReportBeen.setCusname(ihData.getvRegisterID().getCusid().getName());
			  analysisReportBeen.setInvoiceno(ihData.getInvoiceNo());
			  
			  
			  int diff = DateHelperWeb.stringDateDiff(ihData.getInvoiceDate(),LocalDate.now().toString());
			  if(diff<30) {

			  analysisReportBeen.setArr1(StringFormaterWeb.formatToRupees(ihData.getBalance()));
			  
			  analysisReportBeen.setArr2("0.00");
			  analysisReportBeen.setArr3("0.00");
			  analysisReportBeen.setArr4("0.00");
			  
			  }else if((diff>=30)&&(diff<60)) {
			  analysisReportBeen.setArr2(StringFormaterWeb.formatToRupees(ihData.getBalance()));
			  
			  analysisReportBeen.setArr1("0.00");
			  analysisReportBeen.setArr3("0.00");
			  analysisReportBeen.setArr4("0.00");
			  }else if((diff>=60)&&(diff<90)) {
			  analysisReportBeen.setArr3(StringFormaterWeb.formatToRupees(ihData.getBalance()));
			  
			  analysisReportBeen.setArr2("0.00");
			  analysisReportBeen.setArr1("0.00");
			  analysisReportBeen.setArr4("0.00");
			  }else if(diff>=90) {
			  analysisReportBeen.setArr4(StringFormaterWeb.formatToRupees(ihData.getBalance()));
			  
			  analysisReportBeen.setArr2("0.00");
			  analysisReportBeen.setArr3("0.00");
			  analysisReportBeen.setArr1("0.00");
			  }
			  
			  
			  analysisReportBeen.setTotdue("0");
			  
		  
			  
			  analysisReportBeenList.add(analysisReportBeen);
		  }
		  
		 
	
	
          	ReportViewe review=new ReportViewe();
          	Map<String,Object> params = new HashMap<>();

        	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
          	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
          	params.put("address",centerMaster.getAdd03() );
          	params.put("todate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(LocalDate.now().toString())));
       
          	String reptValue="";
          	
         try {
          		reptValue=review.pdfReportViewInlineSystemOpen("ageAnalysisReport.jasper","Age Analysis Report",analysisReportBeenList,params,response);
          		
          
          	}catch(Exception e) {	          		
          		e.printStackTrace();          		
          	}
		  
		  mav.addObject("pdfViewEq", reptValue); 
		  return mav;
	  } 
	  
	  	@RequestMapping(value="getComboVmak", method=RequestMethod.GET)		
		public  @ResponseBody List<VehicleMake> getComboOrdermake(){
			List <VehicleMake> vlist = vehicleService.getActiveMakes();
			return vlist;
		}
	  	@RequestMapping(value="getComboVmakV", method=RequestMethod.GET)		
		public  @ResponseBody List<VehicleMake> getComboVmak(){
			List <VehicleMake> vlist = vehicleService.getMakelistAll();
			return vlist;
		}
	  	@RequestMapping(value="getAllPendingAppointment", method=RequestMethod.GET)		
		public  @ResponseBody List<Appointment> getAllPendingAppointment(){
	  		List<Appointment> AppointmentList=appointmentService.getAllPendingAppointment();
			return AppointmentList;
		}
	  	//"redirect:/checkDocument?vid="+vmaster.getVehicleID()+"&curMi="+currentMilage+"&id="+ocid;
		@RequestMapping("/checkDocument")
		public String checkDocument(Map<String, Object> model) {
			//,@RequestParam String vid,@RequestParam String curMi,@RequestParam String id
		Document document=new Document();
		
//		model.put("documentmodel", document);
//		model.put("vid", vid);
//		model.put("curMi", curMi);
//		model.put("documentmodel", id);
		List<Document> documentlist = documentScrvice.getAllActiveDocument();			
		model.put("documentlist", documentlist);
			return "checkDocument";
		}
		@ModelAttribute("documentlist")
		public List<Document> getdocumentlist() {
			
			
			List<Document> documentlist = documentScrvice.getAllActiveDocument();			
			

			return documentlist;
		}
		
		@RequestMapping("/checkDocumentAuto")
		public String checkDocumentAuto(@RequestParam("vecNo") String vecNo,@RequestParam("curMi") String curMi,@RequestParam("id") String id,Map<String, Object> model) {	
	
			model.put("vecNo", vecNo);
			model.put("curMi", curMi);
			model.put("id", id);
			OcrDetails ocrDetails=vehicleService.getOcrDetailsById(Integer.parseInt(id));
			model.put("imgVe",ocrDetails.getNoimageView());
		List<Document> documentlist = documentScrvice.getAllActiveDocument();			
		model.put("documentlist", documentlist);
		
		
			return "checkDocument";
		}
		
		
		
		
		
		 
		
		@RequestMapping(value = "/savaCheckDocument", method = RequestMethod.POST)
		public @ResponseBody String savaCheckDocument(@RequestParam("docheadid") String docheadid,@RequestParam("vehNO") String vecNo,@RequestParam("mocrid") String id,@RequestParam("doc") String[] docid,@RequestParam("rem") String[] rem,@RequestParam("docStatus") String[] docStatus)/*,@RequestParam("docStatus") String[] docStatus)*/ {

			try {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    Date date = new Date(); 
		    String maxid="";
		    System.out.println(" hh= "+docheadid.isEmpty());
		   if(docheadid.isEmpty()) {
			   System.out.println("new");
			 maxid=documentScrvice.maxDocumentCheckHeadID();
				DocumentCheckHead documentCheckHead=new DocumentCheckHead();
				documentCheckHead.setDocumentcheckheadid(maxid);
				documentCheckHead.setDate(formatter.format(date));
			 
				documentCheckHead.setVehicleID(vecNo);
				OcrDetails ocrDetails=vehicleService.getOcrDetailsById(Integer.parseInt(id));			
				
				documentCheckHead.setStatus("ACTIVE");
				
				documentScrvice.saveDocumentCheckHead(documentCheckHead);
				
				List<DocumentCheckDetails>  docCheckDetailsList=new ArrayList<DocumentCheckDetails>();
			       for(int i=0; i < docid.length; i++){
			    	   DocumentCheckDetails documentCheckDetails=new DocumentCheckDetails();
			    	   
			    	   documentCheckDetails.setDocumentCheckHeadID(documentCheckHead);
			    	  
			    	   Document document=new Document();
			    	   document.setDocumentid(Integer.parseInt(docid[i]));
			    	   documentCheckDetails.setDocumentid(document); 
			    	   documentCheckDetails.setRemarks(rem[i]); 
			    	   documentCheckDetails.setCheckStatus(docStatus[i]);
			    	   
			    	   docCheckDetailsList.add(documentCheckDetails);
			       }
				
				documentScrvice.saveAllDocumentCheckDetails(docCheckDetailsList);
				
				ocrDetails.setDocStatus("completed");
				ocrDetails.setDocumentCheckHeadID(documentCheckHead);
	    		vehicleService.saveOcrDetailsRepo(ocrDetails);
		   }else {
			   System.out.println("Edit"+docheadid);

		    
		    
		       for(int i=0; i < docid.length; i++){
	
		    	   
		    	   DocumentCheckDetails documentCheckDetails=documentScrvice.getCheckDocumentDetailsByid(Integer.parseInt(docid[i]));
		    	   
		    	 
		    	  
//		    	   Document document=new Document();
//		    	   document.setDocumentid(Integer.parseInt(docid[i]));
		    	   
		    	   documentCheckDetails.setRemarks(rem[i]); 
		    	   documentCheckDetails.setCheckStatus(docStatus[i]);
		    	   
		    	   documentScrvice.saveDocumentCheckDetails(documentCheckDetails);
		    	   OcrDetails ocrDetails=vehicleService.getOcrDetailsById(Integer.parseInt(id));
					ocrDetails.setDocStatus("completed");
					
		    		vehicleService.saveOcrDetailsRepo(ocrDetails);
		       }
		    
		    
		   }

		
			


          // OcrDetails ocrDetails=vehicleService.getOcrDetailsById();
//			

			
			
			//return "checkDocument";
			return "1"; 
			}catch (Exception e) {
				e.printStackTrace();
				return "0"; 
			}
			
		}
		
		
		
	  	@RequestMapping(value="checkDocTable", method=RequestMethod.GET)		
		public  @ResponseBody List<DocumentCheckDetails> getcheckDocTable(@RequestParam("ocrid") int ocrid){
	  		
	  		 List<DocumentCheckDetails> documentCheckDetails=documentScrvice.getCheckDocumentDetails(ocrid);
	  		
			return documentCheckDetails;
		}
		
		
		@RequestMapping("/document")
		public String viewDocumente(Map<String, Object> model) {
			Document document = new Document();
	
			model.put("document", document);
			List<Document> listdocument = documentScrvice.listAllDocument();
			model.put("allDucument", listdocument);
			return "document";
		}
		
		@RequestMapping(value = "/saveDocument", method = RequestMethod.POST)
		public String saveUser(@Valid @ModelAttribute("document")  Document document , BindingResult br,RedirectAttributes redirectAttributes) {
			
			if(br.hasErrors()) {
				redirectAttributes.addFlashAttribute("success", 0);
				return "document";
				
			} else {
				if(document.getDocumentid()!=0) {
					document.setDocumentid(document.getDocumentid());
				}
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			    Date date = new Date();  
			    
				document.setStatus("ACTIVE");
				document.setAddDate(formatter.format(date));
				documentScrvice.saveDocument(document);
				redirectAttributes.addFlashAttribute("success", 1);
				return "redirect:/document.do";
		    	  
			}
		  		
		}
		
		@RequestMapping("/editDocument")
		public ModelAndView editDocument(@RequestParam String id) {
			ModelAndView mav = new ModelAndView("document");
			Document document = documentScrvice.listDocumentById(Integer.parseInt(id));
			mav.addObject("document", document);
			return mav;
		}
	
		@ModelAttribute("vehiclesSubCategorylist")
		public List<VehiclesSubCategory> vehiclesSubCategorylist() {
			List<VehiclesSubCategory> vCatList = vehicleService.vehiclesSubCategorylist();
			return vCatList;
		}
	  	@RequestMapping(value="getOCRVehiclesByDates", method=RequestMethod.GET)		
		public  @ResponseBody List<OcrDetails> getOCRVehiclesByDates(@RequestParam Date todayDate){
	  		
	  		
	  		List<OcrDetails> vlist = vehicleService.getOCRVehiclesByDates(DateHelperWeb.getFormatStringDate2(todayDate));
			return vlist;
		}
	
	  	
		@RequestMapping(value = "saveNewOcrPlate", method = RequestMethod.POST)
		public @ResponseBody String saveWNewOcrImage( @RequestParam ("json") String json, @RequestParam ("id") String id) 
		{

			try {
		
	
		    byte[] imagedata = DatatypeConverter.parseBase64Binary(json.substring(json.indexOf(",") + 1));
		    
		   
			OcrDetails ocrDetails=vehicleService.getOcrDetailsById(Integer.parseInt(id));;
			
			//ocrDetails.setOcrDate(dtf.format(now));
			ocrDetails.setNoimage(imagedata);
					
			vehicleService.saveOcrDetailsRepo(ocrDetails);
		    
			return "1";
		    
		   }catch(Exception e) {
			   
			   System.out.println("An error occurred.");
			      e.printStackTrace();
			      return "0";
		   }
		   
		   
		   
		}
	  	
	  	
	  	
}

