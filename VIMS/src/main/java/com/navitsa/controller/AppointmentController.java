package com.navitsa.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.entity.Appointment;
import com.navitsa.entity.AppointmentForm;
import com.navitsa.entity.AppointmentOnline;
import com.navitsa.entity.CountryMaster;
import com.navitsa.entity.CountryState;
import com.navitsa.entity.Customer;
import com.navitsa.entity.FuelType;
import com.navitsa.entity.OcrDetails;
import com.navitsa.entity.TestCategory;
import com.navitsa.entity.TestLaneHead;
import com.navitsa.entity.VehicleClass;
import com.navitsa.entity.VehicleMake;
import com.navitsa.entity.VehicleMaster;
import com.navitsa.entity.VehicleModel;
import com.navitsa.entity.VehicleOwner;
import com.navitsa.entity.VehiclesSubCategory;
import com.navitsa.services.AppointmentService;
import com.navitsa.services.CenterService;
import com.navitsa.services.LaneServices;
import com.navitsa.services.UsersService;
import com.navitsa.services.VehicleService;
import com.navitsa.utils.JDBCSingleton;

@Controller
public class AppointmentController {
	
	@Autowired
	private CenterService centerService;
	
	@Autowired
	private LaneServices laneService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private UsersService userService;

	@RequestMapping("/appointment")
	public String loadingAppointmentForm(Model m) {
		
		AppointmentForm newApointment = new AppointmentForm();
		m.addAttribute("appointmentForm", newApointment);
		return "appointment";	
	}

	@RequestMapping(value = "/saveAppointment", method = RequestMethod.POST)
	public String saveAppointment(@Valid @ModelAttribute("appointmentForm") AppointmentForm form, BindingResult br,
			Model m,RedirectAttributes redirectAttributes,HttpSession session) {

		if (br.hasErrors()) {
			return "appointment";
			
		} else {
			String nextApId = appointmentService.nextAppointmentId();
			form.setAppointmentID("0000".substring(nextApId.length())+nextApId);
			
			Optional<VehicleMaster> vmobj = appointmentService.getVehicleByID(form.getVehicleID());
			VehicleMaster vm = new VehicleMaster();
			
			
			if(vmobj.isPresent()) {
				vm.setVehicleID(vmobj.get().getVehicleID());
			}else {
				
				vm.setVehicleID(form.getVehicleID());
				vm.setVmodel(form.getVmodel());
				vm.setManufactureYear(form.getManufactureYear());
				vm.setRegisteredYear(form.getRegisteredYear());
				vm.setChassisNo(form.getChassisNo());
				vm.setEngineNo(form.getEngineNo());
				vm.setEngineCapacity(form.getEngineCapacity());
				vm.setFtype(form.getFtype());
				vm.setNoWheel(form.getNoWheel());
				vm.setEmissionNorms(form.getEmissionNorms());				
				VehiclesSubCategory vsc = new VehiclesSubCategory();
				vsc.setSubCategoryID("0");
				vm.setSubCategoryID(vsc);		
				vehicleService.saveVMaster(vm);				
			}
			
			Customer customer = new Customer();
			VehicleOwner vowner = new VehicleOwner();
			
			String centerid=(String) session.getAttribute("centerid");
			CountryMaster country_code = centerService.getcenterById(centerid).getCountrycode();
			
			if(form.getCustomer_owner_status().equalsIgnoreCase("owner")) {
				
				if(form.getCustomerID() != "") {
					vowner.setOwnerID(form.getCustomerID());
				}else {
					// new owner
					
					vowner.setOwnerID("0000".substring(vehicleService.maxVOwnerID().length()) + vehicleService.maxVOwnerID());
					vowner.setTitle(form.getCusTitle());
					vowner.setOwnerName(form.getFirstName()+" "+ form.getLastName());
					vowner.setContactNo(form.getMobileNo());
					vowner.setAdd01(form.getAddress());
					vowner.setCity(form.getCity());
					vowner.setStateid(form.getStateid());
					vowner.setPostalBox(form.getPostalCode());
					vowner.setEmail(form.getEmail());
					vowner.setStatus("currentOwner");
					vowner.setVehicleID(vm);
					vowner.setCountryCode(country_code);
					
					vehicleService.saveVOwner(vowner);
					vehicleService.updateOwnerStatus(vowner.getOwnerID(), vowner.getVehicleID().getVehicleID());
										
				}
	
			}else if(form.getCustomer_owner_status().equalsIgnoreCase("customer")) {
				
				if(form.getCustomerID() != "") {				
					customer.setId(form.getCustomerID());
				}else {		
					customer.setId("0000".substring(userService.maxCusID().length())+userService.maxCusID());
					customer.setTitle(form.getCusTitle());
					customer.setName(form.getFirstName()+" "+ form.getLastName());
					customer.setTpno(form.getMobileNo());
					customer.setEmail(form.getEmail());
					customer.setCity(form.getCity());
					customer.setStateid(form.getStateid());
					customer.setAddress(form.getPostalCode());
									
					userService.saveCustomer(customer);			
				}
			}
			
			
			  Appointment newAppointment = new Appointment();
			  newAppointment.setAppointmentID(form.getAppointmentID());
			  newAppointment.setLane(form.getLane()); 
			  newAppointment.setVehicle_id(vm);	
			  if(customer.getId() != null) {
				  newAppointment.setCustomer_id(customer);
			  }
			  if(vowner.getOwnerID() != null) {
				  newAppointment.setOwnerId(vowner.getOwnerID());
			  }		  			  
			  newAppointment.setAppointmentDate(form.getAppointmentDate());
			  newAppointment.setAppointmentTime(form.getAppointmentTime());
			  newAppointment.setStatus("pending"); 
			  newAppointment.setCategoryId(form.getCategoryId());
			  appointmentService.save(newAppointment);
			 
			/* Following code is to push data to host database */
			  
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
			SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");

			String todayDate = df2.format(new Date());
			String currentTime = df.format(new Date());

			String id = todayDate + "/" + currentTime;
			
			AppointmentOnline ao = new AppointmentOnline();
			ao.setAppointmentID(id);		
			ao.setCusName(form.getFirstName()+" "+ form.getLastName());
			ao.setCusMobileNo(form.getMobileNo());
			ao.setCusEmail(form.getEmail());
			ao.setVehicleNo(form.getVehicleID());
			ao.setVehicleClassId(form.getVclassId());
			ao.setCategoryId(form.getCategoryId());
			ao.setAppointmentDate(form.getAppointmentDate());
			ao.setAppointmentTime(form.getAppointmentTime());
			ao.setStatus("pending");
			
			JDBCSingleton jdbc= JDBCSingleton.getInstance();
			
			try {
				int recordCount = jdbc.insert(ao);
				System.out.println("Insert "+recordCount+" record to hosted database");
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
			redirectAttributes.addFlashAttribute("success", 1);
			return "redirect:/appointment";


		}

	}

	@RequestMapping(value="/getFreeTimeSlots", method=RequestMethod.GET)
	public @ResponseBody String[] getFreeTimeSlots(@RequestParam String catID,@RequestParam String laneID,@RequestParam String selectedDate,@RequestParam String date2,HttpSession session) throws ParseException{
	
		String centerid=(String) session.getAttribute("centerid");
		String open_time = centerService.getcenterById(centerid).getOpenTime();
		String close_time = centerService.getcenterById(centerid).getCloseTime();
		
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
		
		Date ot = df.parse(open_time);
		Date ct = df.parse(close_time);
		
		Date choseDate = df2.parse(selectedDate);  
		Date todayDate = df2.parse(df2.format(new Date()));
		Date currentTime = df.parse(df.format(new Date()));
		
		long difference = 0;
		Date dateObj = null;
		
//		if(choseDate.compareTo(todayDate)==0) {
//			// match
//			difference = ct.getTime() - currentTime.getTime();
//			dateObj=currentTime;
//			
//		}else if(choseDate.compareTo(todayDate)>0) {
//			// future date
//			difference = ct.getTime() - ot.getTime();
//			dateObj = ot;
//		}
		
		difference = ct.getTime() - ot.getTime();
		dateObj = ot;
		
		long diffMinutes = difference / 60000;
		//long diffHours = difference / (60 * 60 * 1000) % 24;
		
		long testAproTime = Long.valueOf(centerService.getCategoryId(catID).getTestAproTime());
		long noOfTimeSlots = diffMinutes/testAproTime;
		
		String a[]=new String[(int) noOfTimeSlots];	
		Calendar calender = Calendar.getInstance();
		//System.out.println(df.format(calender.getTime()));
		
		for (int i = 0; i < noOfTimeSlots; i++) {
			
			if(i ==0) {
				a[i]=df.format(dateObj);
			}else {
				calender.setTime(dateObj);
				calender.add(Calendar.MINUTE, (int) testAproTime);
				dateObj = calender.getTime();
				a[i]=df.format(dateObj);
			}
			
		}
		
		String[] reservedTimeList =  appointmentService.getReservedTimes(date2,laneID);
		String[] freeTimeList = new String[80];
		//SimpleDateFormat df3 = new SimpleDateFormat("hh:mm a");
		
		for (int i = 0; i < a.length; i++) {
			
			boolean flag = true;	
			Date time_slot = df.parse(a[i]);
			
			if(choseDate.compareTo(todayDate)==0 && time_slot.compareTo(currentTime)<0) {
				continue;
			}
			
			for (int j = 0; j < reservedTimeList.length; j++) {
				Date reserved_slot = df.parse(reservedTimeList[j]);
				
				if (time_slot.compareTo(reserved_slot)==0) {
					flag = false;
				}
			}
			
			if(flag==true)
				freeTimeList[i]=a[i];
				//freeTimeList[i]=df3.format(date3);
		}

		
		//AppointmentTime obj = new AppointmentTime();
		//obj.setAllTimeSlots(freeTimeList);
		//obj.setBookedTimes(reservedTimeList);
		
		return freeTimeList;
	
	}
	
	@ModelAttribute("testCategory")
	public List<TestCategory> getAllCategory() {
		List<TestCategory> tc = centerService.getAll();
		return tc;
	}
	
	@ModelAttribute("vClass") 
	public List<VehicleClass> getAllvclass() {
		List<VehicleClass> vClass = vehicleService.getVClass();
		return vClass;
	}

	 @ModelAttribute("lanes")
	 public List<TestLaneHead> listTestLaneHead(){
		 List<TestLaneHead> lhlist = laneService.listTestLaneHead();
		 return lhlist;
	 }
	
	@RequestMapping(value="/getCustomerDetails", method=RequestMethod.GET)
	public @ResponseBody Customer getCustomerDetails(@RequestParam String mobileNo){
		
		return appointmentService.getCustomerByMobileNo(mobileNo);
	}

	// getting all vehicle makes for drop down
	@ModelAttribute("vMake")
	public List<VehicleMake> getAllMakes() {
		List<VehicleMake> vmake = vehicleService.getMakelistAll();
		return vmake;
	}

	// getting vehicle make image by make id
	@RequestMapping(value="/getMakeImage", method=RequestMethod.GET)
	public @ResponseBody String search(@RequestParam String vmake) {
		VehicleMake make = vehicleService.searchlogomake(vmake);
		return make.getMakeLogoView();
	}
	
	// getting all vehicle models for drop down
	@ModelAttribute("vmodel")
	public List<VehicleModel> getAllModels() {
		List<VehicleModel> model = vehicleService.getVModel();
		return model;
	}

	// getting vehicle model image by model id
	@RequestMapping(value = "/getModelImg", method = RequestMethod.GET)
	public @ResponseBody String getModelImage(@RequestParam String vehicleModelID) {
		VehicleModel m = vehicleService.getVmodelDetailsByID(vehicleModelID);
		return m.getModelLogoView();
	}
	
	// getting models by vehicle class & make
	@RequestMapping(value = "/getModels", method = RequestMethod.GET)
	public @ResponseBody List<VehicleModel> search1(@RequestParam String makeID, @RequestParam String classID) {
		List<VehicleModel> vmodel = vehicleService.getModelByID(makeID, classID);
		return vmodel;
	}

	@ModelAttribute("fuelType")
	public List<FuelType> getAllFualDetails() {
		List<FuelType> makedrop = vehicleService.getFuelType();
		return makedrop;
	}

	@RequestMapping("/appointmentCancel")
	public String cancelAppointment(Model m) {
		return "appointmentCancel";	
	}
	
	@RequestMapping(value="/getPendigAppointments", method=RequestMethod.GET)
	public @ResponseBody List<Appointment> getPendigAppointments(@RequestParam String selectedDate){	
		return appointmentService.getPendingAppointmentsByDate(selectedDate);	
	}

	@RequestMapping(value="/getCurrentOwner", method=RequestMethod.GET)
	public @ResponseBody VehicleOwner getCurrentOwner(@RequestParam String vehicelNo){
		
		//System.out.println("abc "+vehicelNo);
		return vehicleService.getVehicleOwnerIDByVehicleID(vehicelNo);
	}
	
	@RequestMapping(value="/findBestLane", method=RequestMethod.GET)
	public @ResponseBody String[][] findBestLane(@RequestParam String vCatID,@RequestParam String vClassID,HttpSession session) {
		
		try {
			String centerid=(String) session.getAttribute("centerid");
			String[][] laneList=appointmentService.findBestLane(vCatID,vClassID,centerid);
			return laneList;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;	
	}
	
	// getting all country states
	@ModelAttribute("countryStates")
	public List<CountryState> getAllStates(HttpSession session) {
		List<CountryState> counState = centerService.getallStateFromCountry((String) session.getAttribute("countryCode"));
		return counState;
	}

	@RequestMapping("/onlineAppointments")
	public String onlineAppointments() {
		return "appointmentOnline";	
	}

	@RequestMapping(value="/getOnlineAppointments", method=RequestMethod.GET)
	public void getOnlineAppointments() {

		JDBCSingleton jdbc= JDBCSingleton.getInstance();
		
        try  {
            jdbc.view();
         } catch (Exception e) {
          System.out.println(e);
        }
	}

	@RequestMapping("/appointmentOffline")
	public String loadingAppointmentOfflineForm(Model m) {
		
		AppointmentForm newApointment = new AppointmentForm();
		m.addAttribute("appointmentForm", newApointment);
		//return "gateEntryAppointmentCard";
		return "appointmentOffline";
	}
	
	@ModelAttribute("ocr_vehicles")
	public List<OcrDetails> get_ocr_vehicles() throws ParseException {
		
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		String todayDate = df2.format(new Date());
		
		List<OcrDetails> ocrList = appointmentService.getOCRVehicles(todayDate);
		//System.out.println(ocrList.isEmpty());
		return ocrList;
	}
	
  	@RequestMapping(value="getApposByDate", method=RequestMethod.GET)		
	public  @ResponseBody List<AppointmentOnline> getApposByDate(@RequestParam String selectedDate){
  		
		//SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		//String todayDate = df2.format(new Date());
		
		//System.out.println("Selected Date is "+selectedDate);
  		//List<Appointment> todayAppoList = appointmentService.getPendingAppointmentsByDate(selectedDate);
  		
		JDBCSingleton jdbc= JDBCSingleton.getInstance();
		List<AppointmentOnline > list = null;
		
		try {
			
			list = jdbc.view();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
  	
	@RequestMapping(value="getLateAppos", method=RequestMethod.GET)
	public @ResponseBody List<Appointment> getLateAppos(){
		
		List<Appointment> lateApposList = appointmentService.getLateAppointments();
		
//		for(Appointment x : lateApposList) {
//			System.out.println(x.getVehicle_id().getVehicleID());
//		}
		
		return lateApposList;

	}
	
	@RequestMapping(value="cancelling", method=RequestMethod.GET)
	public @ResponseBody void cancelling(@RequestParam String appoID){
		//System.out.println("appointment ID "+appoID);
		appointmentService.cancellingAppointment(appoID);

	}

	@RequestMapping(value="rescheduling", method=RequestMethod.GET)
	public @ResponseBody void rescheduling(@RequestParam String appoID,
			@RequestParam Date date,@RequestParam String time){
		
		appointmentService.reschedulingAppointment(appoID,date,time);

	}
	
	@RequestMapping(value="/checkCloseTime", method=RequestMethod.GET)
	public @ResponseBody boolean checkCloseTime(HttpSession session) throws ParseException {

		String centerid=(String) session.getAttribute("centerid");
		//String open_time = centerService.getcenterById(centerid).getOpenTime();
		String close_time = centerService.getcenterById(centerid).getCloseTime();

		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		
		//Date ot = df.parse(open_time);
		Date ct = df.parse(close_time);

		Date currentTime = df.parse(df.format(new Date()));
		
		System.out.println("close time - "+ct);
		System.out.println("Current time -"+currentTime);
		
		System.out.println(currentTime.compareTo(ct));
		
		if (currentTime.compareTo(ct)==0 || currentTime.compareTo(ct)>0) {
			
			return true;
		}else {
			return false;
		}
		
		//return false;
	}
	
}
