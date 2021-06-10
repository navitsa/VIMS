package com.navitsa.services;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navitsa.entity.EquipmentMake;
import com.navitsa.entity.EquipmentMaster;
import com.navitsa.entity.EquipmentModel;
import com.navitsa.entity.EquipmentType;
import com.navitsa.entity.EquipmentsCalibration;
import com.navitsa.entity.IssueTicket;
import com.navitsa.entity.ServicesEquipment;
import com.navitsa.entity.TicketClose;
import com.navitsa.entity.VehicleRegistration;
import com.navitsa.repository.EquipmentMakeRepository;
import com.navitsa.repository.EquipmentMasterRepository;
import com.navitsa.repository.EquipmentModelRepository;
import com.navitsa.repository.EquipmentTypeRepository;
import com.navitsa.repository.EquipmentsCalibrationRepository;
import com.navitsa.repository.IssueTicketRepository;
import com.navitsa.repository.ServicesEquipmentRepository;
import com.navitsa.repository.TicketCloseRepository;

@Service
public class EquipmentService {

	@Autowired
	EquipmentTypeRepository eqTypeRepo;
	@Autowired
	EquipmentModelRepository eqModelRepo;
	@Autowired
	EquipmentMakeRepository egMakeRepo;
	@Autowired
	EquipmentMasterRepository egMastRepo;
	@Autowired
	EquipmentsCalibrationRepository equipmentsCalibrationRepository;
	@Autowired
	ServicesEquipmentRepository servicesEquipmentRepository;
	@Autowired
	IssueTicketRepository issueTicketRepository;
	@Autowired
	TicketCloseRepository ticketCloseRepository;
	
	public void saveEquipmentTyp(EquipmentType equipmentType) {
		eqTypeRepo.save(equipmentType);
	}

	public String maxEqTypeID() {
		if (eqTypeRepo.maxEqTypeID() == null) {
			return "1";
		} else {

			return eqTypeRepo.maxEqTypeID();
		}

	}

	public String maxEqMakeID() {

		if (egMakeRepo.maxEqMakeID() == null) {
			return "1";
		} else {

			return egMakeRepo.maxEqMakeID();
		}

	}

	public String maxEqModelID() {
		if (eqModelRepo.maxEqModelID() == null) {
			return "1";
		} else {

			return eqModelRepo.maxEqModelID();
		}

	}

	public String maxEquipmentID() {
		if (egMastRepo.maxEquipmentID() == null) {
			return "1";
		} else {

			return egMastRepo.maxEquipmentID();
		}
	}

	public List<EquipmentType> findAllEquipmentType() {
		return (List<EquipmentType>) eqTypeRepo.findAll();

	}

	public EquipmentType equipmentTypeByID(String eqId) {
		EquipmentType reselt = eqTypeRepo.findById(eqId).get();
		return reselt;
	}

	public void saveEquipmentMake(EquipmentMake equipmentMake) {
		egMakeRepo.save(equipmentMake);
	}

	public List<EquipmentMake> findAllEquipmentMake() {
		return (List<EquipmentMake>) egMakeRepo.findAll();
	}

	public EquipmentMake equipmentMakeByID(String eqmakeId) {
		EquipmentMake reselt = egMakeRepo.findById(eqmakeId).get();
		return reselt;
	}

	public void saveEquipmentModel(EquipmentModel equipmentModel) {
		eqModelRepo.save(equipmentModel);
	}

	public EquipmentModel equipmentModelByID(String eqmakeId) {
		EquipmentModel reselt = eqModelRepo.findById(eqmakeId).get();
		return reselt;
	}

	public List<EquipmentModel> findAllEquipmentModel() {
		return (List<EquipmentModel>) eqModelRepo.findAll();
	}

	public void saveEquipmentMaster(EquipmentMaster equipmentMaster) {
		egMastRepo.save(equipmentMaster);
	}

	public List<EquipmentMaster> findAllEquipmentMaster() {	
		return (List<EquipmentMaster>) egMastRepo.getfindAll();
	}

	public EquipmentMaster equipmentMasterByID(String eqMasterId) {
		EquipmentMaster reselt = egMastRepo.findById(eqMasterId).get();
		return reselt;
	}

	public List<EquipmentModel> searcheqmodel(String eqMakeid) {
		return eqModelRepo.searcheq(eqMakeid);
	}
	
	public List<EquipmentModel> searchModel(String eqMakeid,String eqTypeID) {
		return eqModelRepo.search(eqMakeid,eqTypeID);
	}
	
	public List<EquipmentMaster> searchEq(String eqModelID,String center) {
		return egMastRepo.searchEq(eqModelID,center);
	}
	
	public  List<EquipmentMaster> getEqumentDatabyEqTyoEqModel(String eqTypeid,String eqModelID){
		return egMastRepo.getEqumentDatabyEqTyoEqModel(eqTypeid, eqModelID);
	}
	
	public EquipmentMake searchLogo(String eqMakeID) {
		return egMakeRepo.searchImg(eqMakeID);
	}
	
	public List<EquipmentMaster> equmentServiceReport(String servicesDate,String center) {
		return egMastRepo.equmentServiceReport(servicesDate,center);
	}
	public List<EquipmentMaster> equmentCalibrationReport(String nextCaliDate,String center) {
		return egMastRepo.equmentCalibrationReport(nextCaliDate,center);
	}
	public List<EquipmentMaster> equmentCalendar(String center){
		return egMastRepo.equmentCalendar(center);
		
	}
	public void saveEquipmentsCalibration(EquipmentsCalibration equipmentsCalibration) {
		equipmentsCalibrationRepository.save(equipmentsCalibration);
	}
	public List<EquipmentsCalibration> getCalibrationAll() {
		return (List<EquipmentsCalibration>) equipmentsCalibrationRepository.findAll();
	}
	public List<EquipmentMaster> getEquipmentCalibration(String eqtype,String calibrationDate,String center){
		return egMastRepo.getEquipmentCalibration(eqtype,calibrationDate,center);
		
	}
	public List<ServicesEquipment> getEquipmentServicesAll() {
		return (List<ServicesEquipment>) servicesEquipmentRepository.findAll();
	}
	public List<EquipmentMaster> getEquipmentServices(String eqtype,String servicesDate,String center){
		return egMastRepo.getEquipmentServices(eqtype,servicesDate,center);
		
	}
	public void saveEquipmentsService(ServicesEquipment servicesEquipment) {
		servicesEquipmentRepository.save(servicesEquipment);
	}
	public List<EquipmentsCalibration> getCalibratedEquipmentsReport(String fromCalibratedDate,String toCalibratedDate) {
		return (List<EquipmentsCalibration>) equipmentsCalibrationRepository.getCalibratedEquipmentsReport(fromCalibratedDate,toCalibratedDate);
	}
	public List<ServicesEquipment> getServicedEquipmentsReport(String fromdate,String todate) {
		return (List<ServicesEquipment>) servicesEquipmentRepository.getServicedEquipmentsReport(fromdate,todate);
	}
	public List<EquipmentMaster> getEquipmentByType(String eqtype,String center){
		return egMastRepo.getEquipmentByType(eqtype,center);
	}
		
	public IssueTicket saveIssueTicket(IssueTicket issueTicket) {
		return issueTicketRepository.save(issueTicket);
	}
	public List<IssueTicket> getIncidentDetails(String fromDate,String toDate){
		return issueTicketRepository.getEquipmentByType(fromDate,toDate);
	}
	public List<IssueTicket> getOpenTicketDetails(String ticketStatus){
		return issueTicketRepository.getOpenTicketDetails(ticketStatus);
	}
	public IssueTicket getTicketById(int id){
		return issueTicketRepository.findById(id).get();
	}
	public TicketClose saveCloseTicket(TicketClose ticketClose){
		return ticketCloseRepository.save(ticketClose);
	}
	public List<TicketClose> privewDownTimeReport(String toDate){
		
		return  ticketCloseRepository.privewDownTimeReport(toDate);
	}

	public List<ServicesEquipment> getEquipmentServicesAll(String date, String id) {
		return egMastRepo.getEquipmentServicesAll(date, id);
		
	}

	
public List<ServicesEquipment> getDetailsByDate(String fromdate,String todate) {
		
		return servicesEquipmentRepository.getDetailsByDate(fromdate,todate);
	}


public List<EquipmentsCalibration> getCalibarationByDate(String fromCalibratedDate, String toCalibratedDate) {
	return equipmentsCalibrationRepository.getCalibarationByDate(fromCalibratedDate,toCalibratedDate);
}

public List<EquipmentMaster> findActiveEquipmentMaster() {
	return (List<EquipmentMaster>) egMastRepo.findActiveAll();
}

public List<TicketClose> findAllTickets() {
	return (List<TicketClose>) ticketCloseRepository.findAllTickets();
}

public String getTotal() {
	return  ticketCloseRepository.getTotal();
}

public List<ServicesEquipment> getServiceReport() {
	return  servicesEquipmentRepository.getServiceReport();
}

	/*
	 * public List<ServicesEquipment> getAll() { return
	 * servicesEquipmentRepository.getAll(); }
	 */



}
	

