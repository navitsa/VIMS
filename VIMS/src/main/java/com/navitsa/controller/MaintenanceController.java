package com.navitsa.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.Reports.AnalysisReportBeen;
import com.navitsa.Reports.EqupmentCalibrationReportBeen;
import com.navitsa.Reports.EqupmentServicesReportBeen;
import com.navitsa.entity.CenterMaster;
import com.navitsa.entity.EquipmentMaster;
import com.navitsa.entity.EquipmentModel;
import com.navitsa.entity.EquipmentType;
import com.navitsa.entity.EquipmentsCalibration;
import com.navitsa.entity.InvoiceHead;
import com.navitsa.entity.ItemRemarks;
import com.navitsa.entity.ServicesEquipment;
import com.navitsa.entity.Users;
import com.navitsa.services.CenterService;
import com.navitsa.services.EquipmentService;
import com.navitsa.services.UsersService;
import com.navitsa.utils.DateHelperWeb;
import com.navitsa.utils.ReportViewe;

@Controller
public class MaintenanceController {

	@Autowired
	private EquipmentService eqervice;
	@Autowired
	CenterService centerService;
	@Autowired
	UsersService usersService;	
	
	  @RequestMapping(value = "/serviceReport", method=RequestMethod.GET) 
	  public ModelAndView getAgeAnalysisReport(Map<String, String> model,HttpServletResponse response,HttpSession session) { 

		  String centerid=session.getAttribute("centerid")+"";
		  CenterMaster centerMaster=centerService.getcenterById(centerid);
		  
		  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	      String surrDate= dateFormat.format(DateHelperWeb.getDate(LocalDate.now().toString()));
		  
		  List<EquipmentMaster>  getEqmasterDetails=eqervice.equmentServiceReport(surrDate,centerid);
		  System.out.println("ggg="+getEqmasterDetails.size()+"   "+surrDate+"  "+centerid);
		  List<EqupmentServicesReportBeen> equpmentServicesReportBeenList = new ArrayList<EqupmentServicesReportBeen>();
		 
		  for(EquipmentMaster eqMaster:getEqmasterDetails) {		
		  EqupmentServicesReportBeen equpmentServicesReportBeen=new EqupmentServicesReportBeen();
		  
		  equpmentServicesReportBeen.setEqtype(eqMaster.getEqModelID().getEqTypeID().getEqType());
		  equpmentServicesReportBeen.setEqmake(eqMaster.getEqModelID().getEqMakeID().getEqMake());
		  equpmentServicesReportBeen.setEqmodel(eqMaster.getEqModelID().getEqModel());
		  equpmentServicesReportBeen.setSerialno(eqMaster.getSerialNo());
		  equpmentServicesReportBeen.setNextservicesdate(eqMaster.getNextServiceDate());
		  equpmentServicesReportBeen.setLastservicesdate(eqMaster.getLastServiceDate());
		  equpmentServicesReportBeenList.add(equpmentServicesReportBeen);
		  }
	       	ReportViewe review=new ReportViewe();
	      	Map<String,Object> params = new HashMap<>();
	
	    	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
	      	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
	      	params.put("address",centerMaster.getAdd03() );
	      	params.put("todate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(LocalDate.now().toString())));
	   
	      	String reptValue="";
      	
	      	try {
	      		reptValue=review.pdfReportViewInlineSystemOpen("EquipmentServiceReport.jasper","Equipment Service Report",equpmentServicesReportBeenList,params,response);
	      		
	      
	      	}catch(Exception e) {	          		
	      		e.printStackTrace();          		
	      	}
	     	ModelAndView mav = new ModelAndView("serviceReport");
	     	mav.addObject("pdfViewEq", reptValue); 
		  
		  return mav;
	  }
	  
	  
	  
	  @RequestMapping(value = "/calibrationReport", method=RequestMethod.GET) 
	  public ModelAndView getCalibrationReport(HttpServletResponse response,HttpSession session) { 
		  String centerid=session.getAttribute("centerid")+"";
		  CenterMaster centerMaster=centerService.getcenterById(centerid);
		  
		  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	      String surrDate= dateFormat.format(DateHelperWeb.getDate(LocalDate.now().toString()));
		  
		  List<EquipmentMaster>  getEqmasterDetails=eqervice.equmentCalibrationReport(surrDate,centerid);
		  System.out.println("ggg="+getEqmasterDetails.size()+"   "+surrDate+"  "+centerid);
		  List<EqupmentCalibrationReportBeen> equpmentCalibrationReportBeenList = new ArrayList<EqupmentCalibrationReportBeen>();
		 
		  for(EquipmentMaster eqMaster:getEqmasterDetails) {		
			  EqupmentCalibrationReportBeen equpmentCalibrationReportBeen=new EqupmentCalibrationReportBeen();
		  
			  equpmentCalibrationReportBeen.setEqtype(eqMaster.getEqModelID().getEqTypeID().getEqType());
			  equpmentCalibrationReportBeen.setEqmake(eqMaster.getEqModelID().getEqMakeID().getEqMake());
			  equpmentCalibrationReportBeen.setEqmodel(eqMaster.getEqModelID().getEqModel());
			  equpmentCalibrationReportBeen.setSerialno(eqMaster.getSerialNo());
			  equpmentCalibrationReportBeen.setNextscalibrationdate(eqMaster.getNextCalibrationDate());
			  equpmentCalibrationReportBeen.setLastcalibrationdate(eqMaster.getLastCalibrationDate());
			  equpmentCalibrationReportBeenList.add(equpmentCalibrationReportBeen);
		  }
	       	ReportViewe review=new ReportViewe();
	      	Map<String,Object> params = new HashMap<>();
	
	    	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
	      	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
	      	params.put("address",centerMaster.getAdd03() );
	      	params.put("todate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(LocalDate.now().toString())));
	   
	      	String reptValue="";
      	
	      	try {
	      		reptValue=review.pdfReportViewInlineSystemOpen("EquipmentCalibrationReport.jasper","Equipment Calibration Report",equpmentCalibrationReportBeenList,params,response);
	      		
	      
	      	}catch(Exception e) {	          		
	      		e.printStackTrace();          		
	      	}
	     	ModelAndView mav = new ModelAndView("serviceReport");
	     	mav.addObject("pdfViewEq", reptValue);
	     	return mav;
			  }
	  
	  @RequestMapping(value = "/calibrationCalendar", method=RequestMethod.GET) 
	  public String calibrationCalendar(Map<String, String> model) { 
		 // incomingReceiptSummaryRpt ageAnalysisReport
		 
		  return "calibrationCalendar";
	  }
	  
		 @RequestMapping(value="/getequmentCalendar", method=RequestMethod.GET)
			public   @ResponseBody List<EquipmentMaster> equmentCalibrationCalendar(@RequestParam String centerID) {
			 List<EquipmentMaster> equipmentMaster = eqervice.equmentCalendar(centerID);
				return equipmentMaster;
			}
	  
		 
		  @RequestMapping(value = "/serviceCalendar", method=RequestMethod.GET) 
		  public String serviceCalendar(Map<String, String> model) { 
			 // incomingReceiptSummaryRpt ageAnalysisReport
			 
			  return "serviceCalendar";
		  } 
		  @RequestMapping("/equipmentsCalibration") 
		  public String equipmentsCalibration(Map<String, Object> model) { 
			model.put("equipmentscalibration", new EquipmentsCalibration());
			
			model.put("allCalibration", eqervice.getCalibrationAll());
			
			  return "equipmentsCalibration";
		  }		 
		@ModelAttribute("eqTypeCmbfor")
		public List<EquipmentType> getAllTypeDetails() {
			List<EquipmentType> typedrop = eqervice.findAllEquipmentType();
			return typedrop;
		}
		 
		@ModelAttribute("calibrationUsercombo")
		public List<Users> viewAllUser() {
			List<Users> usercombo = usersService.listAll();
			return usercombo;

		}	
		 @RequestMapping(value="/getEquipmentCalibration", method=RequestMethod.POST)
			public   @ResponseBody List<EquipmentMaster> getEquipmentCalibration(@RequestParam String eqtype,@RequestParam String calibrationDate,HttpSession session) {
			 String centerid=session.getAttribute("centerid")+"";
			 List<EquipmentMaster> equipmentMaster = eqervice.getEquipmentCalibration(eqtype,calibrationDate,centerid);
				return equipmentMaster;
			}
		 
			@RequestMapping(value = "/saveEquipmentsCalibration", method = RequestMethod.POST)
			public String equipmentscalibration(@ModelAttribute("equipmentscalibration") EquipmentsCalibration equipmentscalibration,HttpSession session)
			 {		//System.out.println("dfffffffffff="+equipmentscalibration.getEquipmentID().getEquipmentID()); 							
				try {
					 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
					    Date date = new Date();
					    
					EquipmentMaster eequipmentMaster=eqervice.equipmentMasterByID(equipmentscalibration.getEquipmentID().getEquipmentID());
					
					String centerid=session.getAttribute("centerid")+"";	
					String userId=session.getAttribute("userId")+"";
					
					
					CenterMaster cm=new CenterMaster();
					cm.setCenter_ID(centerid);
					//equipmentscalibration.setCalibrationDate("");
					equipmentscalibration.setLastCalibrationDate(eequipmentMaster.getLastCalibrationDate());
					equipmentscalibration.setCenterID(cm);
					equipmentscalibration.setStatus("ACTIVE");
					equipmentscalibration.setTranctionDate(formatter.format(date));
					equipmentscalibration.setTranctionUser(userId);
					
					eqervice.saveEquipmentsCalibration(equipmentscalibration);
					
					eequipmentMaster.setLastCalibrationDate(equipmentscalibration.getCalibratedDate());					
					eequipmentMaster.setNextCalibrationDate(equipmentscalibration.getNextCalibratedDate());
					eqervice.saveEquipmentMaster(eequipmentMaster);
					
				}catch(Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
				return "redirect:/equipmentsCalibration.do";
					
			}
			
			 @RequestMapping(value="/getNextCalDate", method=RequestMethod.GET)
			 public @ResponseBody String setDate(@RequestParam String id,@RequestParam String date,@RequestParam String typ) {
				 System.out.println("dddddddddddd");
				 int cint=0;
				EquipmentMaster eequipmentMaster=eqervice.equipmentMasterByID(id);
				if(typ.equals("CAL") ) {
					System.out.println("CAL");
					cint=Integer.parseInt(eequipmentMaster.getEqModelID().getCalibrationInt());
				}else {
					System.out.println("SER");
					cint=Integer.parseInt(eequipmentMaster.getEqModelID().getServiceInt());
				}
				return DateHelperWeb.getFormatStringDate3(DateHelperWeb.addMonths(DateHelperWeb.getDate(date), cint));

			 }
			  @RequestMapping("/equipmentsService") 
			  public String equipmentsService(Map<String, Object> model) { 
				model.put("equipmentsService", new ServicesEquipment());
				
				model.put("allEquipmentsService", eqervice.getEquipmentServicesAll());
				
				  return "equipmentsService";
			  }	
				 @RequestMapping(value="/getEquipmentServices", method=RequestMethod.POST)
					public   @ResponseBody List<EquipmentMaster> getEquipmentServices(@RequestParam String eqtype,@RequestParam String servicesDate,HttpSession session) {
					 String centerid=session.getAttribute("centerid")+"";
					 List<EquipmentMaster> equipmentMaster = eqervice.getEquipmentServices(eqtype,servicesDate,centerid);
						return equipmentMaster;
					}			
		
					@RequestMapping(value = "/saveEquipmentsService", method = RequestMethod.POST)
					public String saveEquipmentsService(@ModelAttribute("equipmentsService") ServicesEquipment servicesEquipment,HttpSession session)
					 {		//System.out.println("dfffffffffff="+equipmentscalibration.getEquipmentID().getEquipmentID()); 							
						try {
							 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
							    Date date = new Date();
							    
							EquipmentMaster eequipmentMaster=eqervice.equipmentMasterByID(servicesEquipment.getEquipmentID().getEquipmentID());
							
							String centerid=session.getAttribute("centerid")+"";	
							String userId=session.getAttribute("userId")+"";
							
							
							CenterMaster cm=new CenterMaster();
							cm.setCenter_ID(centerid);
							//equipmentscalibration.setCalibrationDate("");
							servicesEquipment.setLastServicesDate(eequipmentMaster.getLastServiceDate());
							servicesEquipment.setCenterID(cm);
							servicesEquipment.setStatus("ACTIVE");
							servicesEquipment.setTranctionDate(formatter.format(date));
							servicesEquipment.setTranctionUser(userId);
							
							eqervice.saveEquipmentsService(servicesEquipment);
							
							eequipmentMaster.setLastServiceDate(servicesEquipment.getServicedDate());					
							eequipmentMaster.setNextServiceDate(servicesEquipment.getNextServicesDate());
							eqervice.saveEquipmentMaster(eequipmentMaster);
							
						}catch(Exception e) {
							System.out.println(e);
							e.printStackTrace();
						}
						return "redirect:/equipmentsService.do";
							
					}	 
			 
			//public void saveEquipmentsCalibration(EquipmentsCalibration equipmentsCalibration)
		 
}
