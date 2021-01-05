package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.EquipmentMaster;

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

	@Query(value="SELECT em FROM EquipmentMaster em WHERE em.invLoID.centerID.center_ID=:center and em.status='ACTIVE'")
	public List<EquipmentMaster> equmentCalendar(@Param("center")String center);
	
	
	
}
