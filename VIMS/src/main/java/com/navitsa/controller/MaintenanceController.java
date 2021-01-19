package com.navitsa.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.navitsa.Reports.CalibratedEqupmentReportBeen;
import com.navitsa.Reports.EqupmentCalibrationReportBeen;
import com.navitsa.Reports.EqupmentServicesReportBeen;
import com.navitsa.Reports.IssueTicketReportBeen;
import com.navitsa.Reports.ServiceEqupmentReportBeen;
import com.navitsa.entity.Appointment;
import com.navitsa.entity.CenterMaster;
import com.navitsa.entity.EquipmentMaster;
import com.navitsa.entity.EquipmentType;
import com.navitsa.entity.EquipmentsCalibration;
import com.navitsa.entity.IssueTicket;
import com.navitsa.entity.ServicesEquipment;
import com.navitsa.entity.TestLane;
import com.navitsa.entity.TestLaneHead;
import com.navitsa.entity.TicketClose;
import com.navitsa.entity.Users;
import com.navitsa.services.AppointmentService;
import com.navitsa.services.CenterService;
import com.navitsa.services.EquipmentService;
import com.navitsa.services.LaneServices;
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
	@Autowired
	LaneServices laneServices;
	@Autowired
	AppointmentService appointmentService;
	
	  @RequestMapping(value = "/serviceSchedule", method=RequestMethod.GET) 
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
		  equpmentServicesReportBeen.setNextservicesdate(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(eqMaster.getNextServiceDate())));
		  equpmentServicesReportBeen.setLastservicesdate(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(eqMaster.getLastServiceDate())));
		  equpmentServicesReportBeenList.add(equpmentServicesReportBeen);
		  }
	       	ReportViewe review=new ReportViewe();
	      	Map<String,Object> params = new HashMap<>();
	
	    	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
	      	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
	      	params.put("address",centerMaster.getAdd03() );
	      	params.put("todate",DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(LocalDate.now().toString())));
	   
	      	String reptValue="";
      	
	      	try {
	      		reptValue=review.pdfReportViewInlineSystemOpen("EquipmentServiceSchedule.jasper","Equipment Service Report",equpmentServicesReportBeenList,params,response);
	      		
	      
	      	}catch(Exception e) {	          		
	      		e.printStackTrace();          		
	      	}
	     	ModelAndView mav = new ModelAndView("serviceSchedule");
	     	mav.addObject("pdfViewEq", reptValue); 
		  
		  return mav;
	  }
	  
	  
	  
	  @RequestMapping(value = "/calibrationSchedule", method=RequestMethod.GET) 
	  public ModelAndView calibrationSchedule(HttpServletResponse response,HttpSession session) { 
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
			  equpmentCalibrationReportBeen.setNextscalibrationdate(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(eqMaster.getNextCalibrationDate())));
			  equpmentCalibrationReportBeen.setLastcalibrationdate(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(eqMaster.getLastCalibrationDate())));
			  equpmentCalibrationReportBeenList.add(equpmentCalibrationReportBeen);
			  
			  
			  
		  }
	       	ReportViewe review=new ReportViewe();
	      	Map<String,Object> params = new HashMap<>();
	
	    	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
	      	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
	      	params.put("address",centerMaster.getAdd03() );
	      	params.put("todate",DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(LocalDate.now().toString())));
	   
	      	String reptValue="";
      	
	      	try {
	      		reptValue=review.pdfReportViewInlineSystemOpen("calibrationScheduleReport.jasper","Calibration Schedule",equpmentCalibrationReportBeenList,params,response);
	      		
	      
	      	}catch(Exception e) {	          		
	      		e.printStackTrace();          		
	      	}
	     	ModelAndView mav = new ModelAndView("calibrationSchedule");
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
			  @RequestMapping("/equipmentsCalibrationRpt") 
			  public String equipmentsCalibrationRpt(Map<String, Object> model) { 
			//	model.put("equipmentsService", new ServicesEquipment());
				
			//	model.put("allEquipmentsService", eqervice.getEquipmentServicesAll());
				
				  return "equipmentsCalibrationRpt";
			  } 
			  @RequestMapping(value = "/privewEquipmentsCalibratedReport", method=RequestMethod.POST) 
			  public ModelAndView privewEquipmentsCalibratedReport(@RequestParam String calibratedDate,HttpServletResponse response,HttpSession session) { 
				  String centerid=session.getAttribute("centerid")+"";
				  CenterMaster centerMaster=centerService.getcenterById(centerid);
				  
				 // DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			     // String surrDate= dateFormat.format(DateHelperWeb.getDate(LocalDate.now().toString()));
				  
				  List<EquipmentsCalibration>  getEquipmentsCalib=eqervice.getCalibratedEquipmentsReport(calibratedDate,centerid);
				 
				  List<CalibratedEqupmentReportBeen> calibratedEqupmentReportBeenList = new ArrayList<CalibratedEqupmentReportBeen>();
				 
				  for(EquipmentsCalibration eqCalib:getEquipmentsCalib) {		
					  CalibratedEqupmentReportBeen calibratedEqupmentReportBeen=new CalibratedEqupmentReportBeen();
				  
					  calibratedEqupmentReportBeen.setEqtype(eqCalib.getEquipmentID().getEqModelID().getEqTypeID().getEqType());
					  calibratedEqupmentReportBeen.setEqmake(eqCalib.getEquipmentID().getEqModelID().getEqMakeID().getEqMake());
					  calibratedEqupmentReportBeen.setEqmodel(eqCalib.getEquipmentID().getEqModelID().getEqModel());
					  calibratedEqupmentReportBeen.setSerialno(eqCalib.getEquipmentID().getSerialNo());
					  calibratedEqupmentReportBeen.setNextscalibrationdate(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(eqCalib.getNextCalibratedDate())));
					  calibratedEqupmentReportBeen.setLastcalibrationdate(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(eqCalib.getLastCalibrationDate())));
					  
					  calibratedEqupmentReportBeen.setCalibrateddate(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(eqCalib.getCalibratedDate())));
					  calibratedEqupmentReportBeen.setCalibrationstatus(eqCalib.getCalibrationStatus());
					  calibratedEqupmentReportBeen.setRemarks(eqCalib.getRemarks());
					  calibratedEqupmentReportBeen.setCalibrationuser(eqCalib.getUserId().getUserName());
					  
					  
					  calibratedEqupmentReportBeenList.add(calibratedEqupmentReportBeen);
				  }
			       	ReportViewe review=new ReportViewe();
			      	Map<String,Object> params = new HashMap<>();
			
			    	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
			      	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
			      	params.put("address",centerMaster.getAdd03() );
			      	params.put("todate",DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(LocalDate.now().toString())));
			   
			      	String reptValue="";
		      	
			      	try {
			      		reptValue=review.pdfReportViewInlineSystemOpen("CalibratedEquipmentReport.jasper","Calibrated Equipment Report",calibratedEqupmentReportBeenList,params,response);
			      		
			      
			      	}catch(Exception e) {	          		
			      		e.printStackTrace();          		
			      	}
			     	ModelAndView mav = new ModelAndView("equipmentsCalibrationRpt");
			     	mav.addObject("pdfViewEq", reptValue);
			     	return mav;
					  }
			  
			  
			  @RequestMapping("/equipmentsServiceRpt") 
			  public String equipmentsServiceRpt(Map<String, Object> model) { 
				  return "equipmentsServiceRpt";
			  }
			  
			  @RequestMapping(value = "/privewEquipmentsServiceReport", method=RequestMethod.POST) 
			  public ModelAndView privewEquipmentsServiceReport(@RequestParam String serviceDate,HttpServletResponse response,HttpSession session) { 
				  String centerid=session.getAttribute("centerid")+"";
				  CenterMaster centerMaster=centerService.getcenterById(centerid);
				  
				 // DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			     // String surrDate= dateFormat.format(DateHelperWeb.getDate(LocalDate.now().toString()));
				  
				  List<ServicesEquipment>  getEquipmentsser=eqervice.getServicedEquipmentsReport(serviceDate,centerid);
				 
				  List<ServiceEqupmentReportBeen> serviceEqupmentReportBeenList = new ArrayList<ServiceEqupmentReportBeen>();
				 
				  for(ServicesEquipment eqser:getEquipmentsser) {		
					  ServiceEqupmentReportBeen serviceEqupmentReportBeen=new ServiceEqupmentReportBeen();
				  
					  serviceEqupmentReportBeen.setEqtype(eqser.getEquipmentID().getEqModelID().getEqTypeID().getEqType());
					  serviceEqupmentReportBeen.setEqmake(eqser.getEquipmentID().getEqModelID().getEqMakeID().getEqMake());
					  serviceEqupmentReportBeen.setEqmodel(eqser.getEquipmentID().getEqModelID().getEqModel());
					  serviceEqupmentReportBeen.setSerialno(eqser.getEquipmentID().getSerialNo());
					  serviceEqupmentReportBeen.setNextservicedate(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(eqser.getNextServicesDate())));
					  serviceEqupmentReportBeen.setLastservicedate(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(eqser.getLastServicesDate())));
					  
					  serviceEqupmentReportBeen.setServiceddate(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(eqser.getServicedDate())));
					
					  serviceEqupmentReportBeen.setRemarks(eqser.getRemarks());
					  serviceEqupmentReportBeen.setServiceuser(eqser.getUserId().getUserName());
					  
					  
					  serviceEqupmentReportBeenList.add(serviceEqupmentReportBeen);
				  }
			       	ReportViewe review=new ReportViewe();
			      	Map<String,Object> params = new HashMap<>();
			
			    	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
			      	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
			      	params.put("address",centerMaster.getAdd03() );
			      	params.put("todate",DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(LocalDate.now().toString())));
			   
			      	String reptValue="";
		      	
			      	try {
			      		reptValue=review.pdfReportViewInlineSystemOpen("ServiceEquipmentReport.jasper","Serviced Equipment Report",serviceEqupmentReportBeenList,params,response);
			      		
			      
			      	}catch(Exception e) {	          		
			      		e.printStackTrace();          		
			      	}
			     	ModelAndView mav = new ModelAndView("equipmentsServiceRpt");
			     	mav.addObject("pdfViewEq", reptValue);
			     	return mav;
					  } 
			  
			  @RequestMapping("/issueTicket") 
			  public String issueTicket(Map<String, Object> model) { 
				  model.put("equipmentsIssue", new IssueTicket());
	 
				  return "issueTicket";
			  }
			 @RequestMapping(value="/getEquipmentByType", method=RequestMethod.POST)
				public   @ResponseBody List<EquipmentMaster> getEquipmentByType(@RequestParam String eqtype,HttpSession session) {
				 String centerid=session.getAttribute("centerid")+"";
				 List<EquipmentMaster> equipmentMaster = eqervice.getEquipmentByType(eqtype,centerid);
					return equipmentMaster;
				}
				
				@RequestMapping(value = "/saveEquipmentsIssue", method = RequestMethod.POST)
				public @ResponseBody String saveEquipmentsIssue(@ModelAttribute("equipmentsIssue") IssueTicket issueTicket,HttpSession session)
				 {		//System.out.println("dfffffffffff="+equipmentscalibration.getEquipmentID().getEquipmentID()); 							
					try {
						System.out.println(issueTicket.getEquipmentID().getEquipmentID());
						if(issueTicket.getEquipmentID().getEquipmentID().toString().equals("000")) {
							EquipmentMaster eqid=new EquipmentMaster();							
							issueTicket.setEquipmentID(eqid);
							System.out.println("ghjvhjh");
						}
						
						if(issueTicket.getTestLaneHeadId().getTestLaneHeadId()=="000") {
							TestLaneHead eqid=new TestLaneHead();							
							issueTicket.setTestLaneHeadId(eqid);							
						}else {
							
							if(issueTicket.getLaneStatus()!="Working") {
							TestLaneHead testLaneHead=laneServices.getTestLaneHeadById(issueTicket.getTestLaneHeadId().getTestLaneHeadId());
							testLaneHead.setStatus("INACTIVE");
							laneServices.saveTestLaneHead(testLaneHead);
							}
							
						}
						
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
					    Date date = new Date();
					    DateTimeFormatter formattertime = DateTimeFormatter.ofPattern("HH:mm");
	    	    	    LocalTime time = LocalTime.now();
	    	    	    
					    issueTicket.setIssueDate(formatter.format(date));
					    issueTicket.setIssueTime(time.format(formattertime));
					    issueTicket.setIssueStatus("Open");
					    issueTicket.setStatus("ACTIVE");
						//eqervice.saveIssueTicket(issueTicket);
					    IssueTicket resIssueTicket= eqervice.saveIssueTicket(issueTicket);
						return resIssueTicket.getTicketNo()+"";
						
					}catch(Exception e) {
						System.out.println(e);
						e.printStackTrace();
						return "0";
					}
					
						
				}	
				
				@ModelAttribute("lanesissue")
				 public List<TestLaneHead> listTestLaneHead(){
					 List<TestLaneHead> lhlist = laneServices.listTestLaneHead();
					 return lhlist;
				 } 
			  	@RequestMapping(value="getLaneAppointment", method=RequestMethod.POST)		
				public  @ResponseBody List<Appointment> getApposByDate(@RequestParam String lane){
			  		
			
			  		List<Appointment> todayAppoList = appointmentService.getPendingLaneAppointmentsByDate(lane);
					return todayAppoList;
				}
				  @RequestMapping("/incidentReport") 
				  public String incidentReport(Map<String, Object> model) { 
//					  model.put("equipmentsIssue", new IssueTicket());
		 
					  return "incidentReport";
				  }
			  	
				  
				  @RequestMapping(value = "/privewIncidentReport", method=RequestMethod.POST) 
				  public ModelAndView privewIncidentReport(@RequestParam String fromDate,@RequestParam String toDate,HttpServletResponse response,HttpSession session) { 
					  String centerid=session.getAttribute("centerid")+"";
					  CenterMaster centerMaster=centerService.getcenterById(centerid);

					  List<IssueTicket>  issueTicketList=eqervice.getIncidentDetails(fromDate,toDate);
					 
					  List<IssueTicketReportBeen> incidentReportBeenList = new ArrayList<IssueTicketReportBeen>();
					 
					  
					  
					  
					  for(IssueTicket issueTicket:issueTicketList) {		
						  IssueTicketReportBeen issueTicketReportBeen=new IssueTicketReportBeen();
						  issueTicketReportBeen.setTicketno(issueTicket.getTicketNo());
						  issueTicketReportBeen.setIssue(issueTicket.getIssue());
						  issueTicketReportBeen.setIssuetype(issueTicket.getIssueType());
						  issueTicketReportBeen.setIssuedate(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(issueTicket.getIssueDate())));
						  issueTicketReportBeen.setIssuetime(issueTicket.getIssueTime());
						  issueTicketReportBeen.setIssuestatus(issueTicket.getIssueStatus());
						  issueTicketReportBeen.setLane(issueTicket.getTestLaneHeadId().getLaneName());
						  issueTicketReportBeen.setLanestatus(issueTicket.getLaneStatus());
						  issueTicketReportBeen.setLaneissuetyme(issueTicket.getLaneIssueTime());
						  issueTicketReportBeen.setEquipment(issueTicket.getEquipmentID().getSerialNo());
						  issueTicketReportBeen.setEquipmentstatus(issueTicket.getEqIsWorking());
						  issueTicketReportBeen.setEqissuetime(issueTicket.getEquipmentIssueTime());
						  issueTicketReportBeen.setStatus(issueTicket.getStatus());
						  issueTicketReportBeen.setIssuelevel(issueTicket.getIssueLevel());
						  incidentReportBeenList.add(issueTicketReportBeen);
					  }
				       	ReportViewe review=new ReportViewe();
				      	Map<String,Object> params = new HashMap<>();
				
				    	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
				      	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
				      	params.put("address",centerMaster.getAdd03() );
				      	params.put("todate",DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(fromDate)) +" To "+DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(toDate)));
				   
				      	String reptValue="";
			      	
				      	try {
				      		reptValue=review.pdfReportViewInlineSystemOpen("IncidentReport.jasper","Incident Report",incidentReportBeenList,params,response);
				      		
				      
				      	}catch(Exception e) {	          		
				      		e.printStackTrace();          		
				      	}
				     	ModelAndView mav = new ModelAndView("incidentReport");
				     	mav.addObject("pdfViewEq", reptValue);
				     	return mav;
						  }	  
				  
				  
				  
				  @RequestMapping("/statusTicketReport") 
				  public String statusTicketReport(Map<String, Object> model) { 
//					  model.put("equipmentsIssue", new IssueTicket());
		 
					  return "statusTicketReport";
				  }
				  
				  
				  
				  
				  
				  @RequestMapping(value = "/privewOpenTicketReport", method=RequestMethod.POST) 
				  public ModelAndView getOpenTicketReport(@RequestParam String ticketStatus,HttpServletResponse response,HttpSession session) { 
					  String centerid=session.getAttribute("centerid")+"";
					  CenterMaster centerMaster=centerService.getcenterById(centerid);

					  List<IssueTicket>  issueTicketList=eqervice.getOpenTicketDetails(ticketStatus);
					 
					  List<IssueTicketReportBeen> incidentReportBeenList = new ArrayList<IssueTicketReportBeen>();
					 
					  
					  
					  
					  for(IssueTicket issueTicket:issueTicketList) {		
						  IssueTicketReportBeen issueTicketReportBeen=new IssueTicketReportBeen();
						  issueTicketReportBeen.setTicketno(issueTicket.getTicketNo());
						  issueTicketReportBeen.setIssue(issueTicket.getIssue());
						  issueTicketReportBeen.setIssuetype(issueTicket.getIssueType());
						  issueTicketReportBeen.setIssuedate(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(issueTicket.getIssueDate())));
						  issueTicketReportBeen.setIssuetime(issueTicket.getIssueTime());
						  issueTicketReportBeen.setIssuestatus(issueTicket.getIssueStatus());
						  issueTicketReportBeen.setLane(issueTicket.getTestLaneHeadId().getLaneName());
						  issueTicketReportBeen.setLanestatus(issueTicket.getLaneStatus());
						  issueTicketReportBeen.setLaneissuetyme(issueTicket.getLaneIssueTime());
						  issueTicketReportBeen.setEquipment(issueTicket.getEquipmentID().getSerialNo());
						  issueTicketReportBeen.setEquipmentstatus(issueTicket.getEqIsWorking());
						  issueTicketReportBeen.setEqissuetime(issueTicket.getEquipmentIssueTime());
						  issueTicketReportBeen.setStatus(issueTicket.getStatus());
						 
						  incidentReportBeenList.add(issueTicketReportBeen);
					  }
				       	ReportViewe review=new ReportViewe();
				      	Map<String,Object> params = new HashMap<>();
				
				    	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
				      	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
				      	params.put("address",centerMaster.getAdd03() );
				      	params.put("todate",DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(LocalDate.now().toString())));
				      	params.put("sta",ticketStatus);
				      	String reptValue="";
			      	
				      	try {
				      		reptValue=review.pdfReportViewInlineSystemOpen("TicketStatusReport.jasper","Ticket Status Report",incidentReportBeenList,params,response);
				      		
				      
				      	}catch(Exception e) {	          		
				      		e.printStackTrace();          		
				      	}
				     	ModelAndView mav = new ModelAndView("statusTicketReport");
				     	mav.addObject("pdfViewEq", reptValue);
				     	return mav;
						  }
				  
				  
				  @RequestMapping("/closeTicket") 
				  public String closeTicket(Map<String, Object> model) { 
					  model.put("closeTicket", new TicketClose());
		 
					  return "closeTicket";
				  }				  
				  
					@ModelAttribute("openTicket")
					 public List<IssueTicket>  getOpenTicketDetails(){
						return eqervice.getOpenTicketDetails("Open");
						
					 } 
				  
					@RequestMapping(value = "/saveCloseTicket", method = RequestMethod.POST)
					public   @ResponseBody String saveTicketClose(@ModelAttribute("closeTicket") TicketClose ticketClose,HttpSession session)
					 {		//System.out.println("dfffffffffff="+equipmentscalibration.getEquipmentID().getEquipmentID()); 							
						try {
							IssueTicket issueTicket=eqervice.getTicketById(ticketClose.getTicketNo().getTicketNo());
							if(issueTicket.getTestLaneHeadId()!=null) {
							TestLaneHead testLaneHead=laneServices.getTestLaneHeadById(issueTicket.getTestLaneHeadId().getTestLaneHeadId());
							testLaneHead.setStatus("ACTIVE");
							laneServices.saveTestLaneHead(testLaneHead);
							}
							
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
						    Date date = new Date();
						    DateTimeFormatter formattertime = DateTimeFormatter.ofPattern("HH:mm");
		    	    	    LocalTime time = LocalTime.now();
		    	    	    
		    	    	    ticketClose.setCloseDate(formatter.format(date));						   
						    ticketClose.setStatus("ACTIVE");
						    TicketClose reTicclos=eqervice.saveCloseTicket(ticketClose);
						
							//update Issue Ticket
							issueTicket.setIssueStatus("Close");
							eqervice.saveIssueTicket(issueTicket);
							return reTicclos.getTicketNo().getTicketNo()+"";
							
							
						}catch(Exception e) {
							System.out.println(e);
							e.printStackTrace();
							//return "redirect:/closeTicket.do";
							return "0";
						}
						
							
					}
					
					
		  	@RequestMapping(value="getOpenTicketDetails", method=RequestMethod.POST)		
			public  @ResponseBody IssueTicket getOpenTicketDetails(@RequestParam int ticketNo){
		  		
		  		IssueTicket issueTicket=eqervice.getTicketById(ticketNo);
				return issueTicket;
			}	
					
		  @RequestMapping("/downTimeReport") 
		  public String downTimeReport(Map<String, Object> model) { 
//				  model.put("equipmentsIssue", new IssueTicket());
 
			  return "downTimeReport";
		  }		
				
		  			
					
		  @RequestMapping(value = "/privewDownTimeReport", method=RequestMethod.POST) 
		  public ModelAndView privewDownTimeReport(@RequestParam String status,HttpServletResponse response,HttpSession session) { 
			  String centerid=session.getAttribute("centerid")+"";
			  CenterMaster centerMaster=centerService.getcenterById(centerid);

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			    Date date = new Date();

			  
			  List<TicketClose>  ticketCloseList=eqervice.privewDownTimeReport(formatter.format(date));
			 
			  List<IssueTicketReportBeen> incidentReportBeenList = new ArrayList<IssueTicketReportBeen>();
			 
			  
			  
			  
			  for(TicketClose ticketClose:ticketCloseList) {
				  
				  IssueTicketReportBeen issueTicketReportBeen=new IssueTicketReportBeen();
				  issueTicketReportBeen.setTicketno(ticketClose.getTicketNo().getTicketNo());
				  issueTicketReportBeen.setIssue(ticketClose.getTicketNo().getIssue());
				  issueTicketReportBeen.setIssuetype(ticketClose.getTicketNo().getIssueType());				
				  issueTicketReportBeen.setIssuedate(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(ticketClose.getTicketNo().getIssueDate())));
				  issueTicketReportBeen.setIssuetime(ticketClose.getTicketNo().getIssueTime());
				  issueTicketReportBeen.setIssuestatus(ticketClose.getTicketNo().getIssueStatus());
				  issueTicketReportBeen.setLane(ticketClose.getTicketNo().getTestLaneHeadId().getLaneName());
				  issueTicketReportBeen.setLanestatus(ticketClose.getTicketNo().getLaneStatus());
			//Task Close time
				  issueTicketReportBeen.setLaneissuetyme(ticketClose.getCloseTime());
			//Task Close Date 
				  issueTicketReportBeen.setEqissuetime(DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(ticketClose.getCloseDate()))); 
			//Down Time......................  
				  DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

				  LocalDateTime dateTime1= LocalDateTime.parse(ticketClose.getTicketNo().getIssueDate()+" "+ticketClose.getTicketNo().getIssueTime(), formatter1);
				  LocalDateTime dateTime2= LocalDateTime.parse(ticketClose.getCloseDate()+" "+ticketClose.getCloseTime(), formatter1);

				  long diffInMilli = java.time.Duration.between(dateTime1, dateTime2).toMillis();
				  long diffInSeconds = java.time.Duration.between(dateTime1, dateTime2).getSeconds();
				  long diffInMinutes = java.time.Duration.between(dateTime1, dateTime2).toMinutes();
				  
				  issueTicketReportBeen.setStatus(diffInMinutes+" Minutes");
				 
				  
				  
			//.................................	  
				  
				  issueTicketReportBeen.setEquipment(ticketClose.getTicketNo().getEquipmentID().getSerialNo());
				  issueTicketReportBeen.setEquipmentstatus(ticketClose.getTicketNo().getEqIsWorking());
				
			//	  issueTicketReportBeen.setEqissuetime(ticketClose.getTicketNo().getEquipmentIssueTime());
				 // issueTicketReportBeen.setStatus(ticketClose.getTicketNo().getStatus());
				 
				  incidentReportBeenList.add(issueTicketReportBeen);
			  }
		       	ReportViewe review=new ReportViewe();
		      	Map<String,Object> params = new HashMap<>();
		
		    	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
		      	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
		      	params.put("address",centerMaster.getAdd03() );
		      	params.put("todate",DateHelperWeb.getFormatStringDate4(DateHelperWeb.getDate(LocalDate.now().toString())));
		    	params.put("sta",status);
		      	String reptValue="";
	      	
		      	try {
		      		reptValue=review.pdfReportViewInlineSystemOpen("downTimeReport.jasper","Down Time Report",incidentReportBeenList,params,response);
		      		
		      
		      	}catch(Exception e) {	          		
		      		e.printStackTrace();          		
		      	}
		     	ModelAndView mav = new ModelAndView("downTimeReport");
		     	mav.addObject("pdfViewEq", reptValue);
		     	return mav;
				  }			
					
					
}
