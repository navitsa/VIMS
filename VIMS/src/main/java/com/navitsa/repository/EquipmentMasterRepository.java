package com.navitsa.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.EquipmentMaster;
import com.navitsa.entity.ServicesEquipment;

public interface EquipmentMasterRepository extends CrudRepository<EquipmentMaster, String> {

	@Query(value ="SELECT (max(e.equipmentID)+1) FROM EquipmentMaster e")
	public String maxEquipmentID();

	@Query(value="SELECT em FROM EquipmentMaster em order by em.eqModelID.eqTypeID.eqTypeID,em.eqModelID.eqMakeID.eqMake,em.eqModelID.eqModel")
	public List<EquipmentMaster> getfindAll();
	
	@Query(value="SELECT em FROM EquipmentMaster em where em.eqModelID.eqTypeID.eqTypeID=:eqTypeid AND em.eqModelID.eqModelID=:eqModelID")
	public List<EquipmentMaster> getEqumentDatabyEqTyoEqModel(@Param("eqTypeid") String eqTypeid,@Param("eqModelID") String eqModelID);

	@Query(value="SELECT em FROM EquipmentMaster em WHERE em.eqModelID.eqModelID=:eqModelID and  invLoID.centerID.center_ID=:center")
	public List<EquipmentMaster> searchEq(@Param("eqModelID")String eqmodelID,@Param("center")String center);
	
	@Query(value="SELECT em FROM EquipmentMaster em WHERE em.nextServiceDate between :servicesDate and concat(YEAR(:servicesDate),'-12','-31') and  em.invLoID.centerID.center_ID=:center and em.status='ACTIVE'")
	public List<EquipmentMaster> equmentServiceReport(@Param("servicesDate")String servicesDate,@Param("center")String center);

	@Query(value="SELECT em FROM EquipmentMaster em WHERE em.nextCalibrationDate between :nextCaliDate and concat(YEAR(:nextCaliDate),'-12','-31') and  em.invLoID.centerID.center_ID=:center and em.status='ACTIVE'")
	public List<EquipmentMaster> equmentCalibrationReport(@Param("nextCaliDate")String nextCaliDate,@Param("center")String center);

	@Query(value="SELECT equipment_master.Equipment_ID,\n" + 
			"equipment_model.Eq_Model_ID,\n" + 
			"equipment_master.Serial_No,\n" + 
			"equipment_master.Status,\n" + 
			"equipment_master.Last_Calibration_Date,\n" + 
			"equipment_master.Last_Service_Date,\n" + 
			"equipment_master.Next_Calibration_Date,\n" + 
			"equipment_master.Next_Service_Date,\n" + 
			"equipment_master.Install_Date,\n" + 
			"equipment_master.Comm_Date,\n" + 
			"equipment_master.Train_Date,\n" + 
			"equipment_master.invLoID,\n" + 
			"test_lanes_details.testLaneHead_Id,\n" + 
			"test_lanes_details.Center_ID,\n" + 
			"test_lane_head.Lane_Name,\n" + 
			"equipment_type.Eq_Type\n" + 
			"FROM equipment_master\n" + 
			"LEFT JOIN test_lanes_details ON equipment_master.Equipment_ID = test_lanes_details.Equipment_ID\n" + 
			"LEFT JOIN test_lane_head ON test_lanes_details.testLaneHead_Id = test_lane_head.testLaneHead_Id\n"+
			"LEFT JOIN equipment_model ON equipment_master.Eq_Model_ID = equipment_model.Eq_Model_ID\n"+
			"LEFT JOIN equipment_type ON equipment_model.Eq_Type_ID = equipment_type.Eq_Type_ID\n"+
			"WHERE test_lanes_details.Center_ID=:center and equipment_master.Status='ACTIVE'",nativeQuery = true)
	public String[][] equmentCalendar(@Param("center")String centerID);
	
	
	
	/*
	 * @Query(
	 * value="SELECT em as EquipmentMaster,TestLaneDetails.testLaneDetailsid FROM EquipmentMaster em left join TestLaneDetails on EquipmentMaster.equipmentID=TestLaneDetails.equipmentID WHERE em.invLoID.centerID.center_ID=:center and em.status='ACTIVE'"
	 * ) public List<EquipmentMaster> equmentCalendar(@Param("center")String
	 * center);
	 */
	
	
	
	@Query(value="SELECT em FROM EquipmentMaster em WHERE em.nextCalibrationDate=:calibrationDate and em.eqModelID.eqTypeID.eqTypeID=:eqtype and em.invLoID.centerID.center_ID=:center and em.status='ACTIVE'")
	public List<EquipmentMaster> getEquipmentCalibration(@Param("eqtype")String eqtype,@Param("calibrationDate")String calibrationDate,@Param("center")String center);

	@Query(value="SELECT em FROM EquipmentMaster em WHERE em.nextServiceDate=:servicesDate and em.eqModelID.eqTypeID.eqTypeID=:eqtype and em.invLoID.centerID.center_ID=:center and em.status='ACTIVE'")
	public List<EquipmentMaster> getEquipmentServices(@Param("eqtype")String eqtype,@Param("servicesDate")String servicesDate,@Param("center")String center);

	@Query(value="SELECT em FROM EquipmentMaster em WHERE em.eqModelID.eqTypeID.eqTypeID=:eqtype and em.invLoID.centerID.center_ID=:center and em.status='ACTIVE'")
	public List<EquipmentMaster> getEquipmentByType(@Param("eqtype")String eqtype,@Param("center")String center);

	@Query(value="SELECT ec FROM ServicesEquipment ec WHERE ec.servicedDate between :fromdate and :todate")
	public List<ServicesEquipment> getEquipmentServicesAll(@Param("fromdate")String fromdate,@Param("todate")String todate);

	@Query(value="SELECT em FROM EquipmentMaster em WHERE em.status='ACTIVE'")
	public List<EquipmentMaster> findActiveAll();

}
