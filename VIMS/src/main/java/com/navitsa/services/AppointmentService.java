package com.navitsa.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.Appointment;
import com.navitsa.entity.AppointmentOnline;
import com.navitsa.entity.Customer;
import com.navitsa.entity.OcrDetails;
import com.navitsa.entity.VehicleMaster;
import com.navitsa.repository.AppointmentOnlineRepository;
import com.navitsa.repository.AppointmentRepository;
import com.navitsa.repository.CustomerRepository;
import com.navitsa.repository.OcrDetailsRepository;
import com.navitsa.repository.TestLaneHeadRepository;
import com.navitsa.repository.VehicleMasterRepository;

@Service
@Transactional
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private VehicleMasterRepository vehicleMasterRepo;
	
	@Autowired
	private TestLaneHeadRepository testLaneHeadRepo;
	
	@Autowired
	private OcrDetailsRepository ocrDetailsRepo;
	
	@Autowired
	private AppointmentOnlineRepository appointmentOnlineRepo;

    public String nextAppointmentId() {
    	
    	if(appointmentRepo.nextId()==null)
    		return "1";
    	else
    		return appointmentRepo.nextId();
    }

	public void save(Appointment appointment) {
		appointmentRepo.save(appointment);
	}

	public Customer getCustomerByMobileNo(String mobileNo) {
		// TODO Auto-generated method stub
		return customerRepo.getCustomerByMobileNo(mobileNo);
	}

	public String[] getReservedTimes(Date selectedDate, String catID) {
		
		return appointmentOnlineRepo.getReservedTimes(selectedDate,catID);
	}
	
	public List<Appointment> getAllPendingAppointment() {
		
		return appointmentRepo.getAllPendingAppointment();
	}
	public Appointment getAppointmentDetailsById(String id) {
		
		return appointmentRepo.findById(id).get();
	}
	
//	public List<Appointment> getPendingAppointmentsByDate(String selectedDate) {
//		
//		return appointmentRepo.getPendingAppointmentsByDate(selectedDate);
//	}

	public Optional<VehicleMaster> getVehicleByID(String vehicleID) {
		// TODO Auto-generated method stub
		return vehicleMasterRepo.findById(vehicleID);
	}

	public String[][] findBestLane(String catid, String vclassid, String cenid) {
		// TODO Auto-generated method stub
		return  testLaneHeadRepo.getTestLaneHeadDetailByCenterCategoryVclass(catid,vclassid,cenid);
	}

	public List<OcrDetails> getOCRVehicles(String todayDate) {

		return ocrDetailsRepo.getOCRVehicles(todayDate);

	}
	public String[][] getDashBordApoymentDetails(String selectedDate){
		return appointmentRepo.getDashBordApoymentDetails(selectedDate);
		
	}
//	public List<Appointment> getLateAppointments() {
//		// TODO Auto-generated method stub
//		return appointmentRepo.getLateAppos();
//	}

//	public void cancellingAppointment(String appoID) {
//		// TODO Auto-generated method stub
//		appointmentRepo.cancellingAppointment(appoID);
//	}

	public void reschedulingAppointment(String appoID, Date date, String time) {
		// TODO Auto-generated method stub
		appointmentRepo.reschedulingAppointment(appoID,date,time);
	}
	public List<Appointment> getPendingLaneAppointmentsByDate(String lane) {
		
		return appointmentRepo.getPendingLaneAppointmentsByDate(lane);
	}

	/* New */
	
	public void saveAppointmentOnline(AppointmentOnline ao) {
		appointmentOnlineRepo.save(ao);
	}
	
	public List<AppointmentOnline> viewAppointmentsAtGate(String selectedDate) {		
		return appointmentOnlineRepo.viewAppointmentsAtGate(selectedDate);
	}
	
	public List<AppointmentOnline> getLateAppointments() {
		return appointmentOnlineRepo.getLateAppos();
	}
	
	public void cancellingAppointment(String appoID) {
		
		appointmentOnlineRepo.cancellingAppointment(appoID);
	}
}
