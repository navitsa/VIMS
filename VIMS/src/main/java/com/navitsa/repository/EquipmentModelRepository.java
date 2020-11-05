package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.EquipmentModel;

public interface EquipmentModelRepository extends CrudRepository<EquipmentModel, String> {

	@Query(value = "SELECT (max(e.eqModelID)+1) FROM EquipmentModel e ")
	public String maxEqModelID();


	@Query(value = "SELECT e FROM EquipmentModel e WHERE e.eqMakeID.eqMakeID=:eqMakeid")
	public List<EquipmentModel> searcheq(@Param("eqMakeid") String eqMakeid);
	
	@Query(value = "SELECT e FROM EquipmentModel e WHERE e.eqMakeID.eqMakeID=:eqMakeid AND e.eqTypeID.eqTypeID=:eqTypeID AND e.status='ACTIVE'")
	public List<EquipmentModel> search(@Param("eqMakeid") String eqMakeid,@Param("eqTypeID")String eqTypeID);

	@Query(value="SELECT em FROM EquipmentModel em WHERE em.eqModelID=:id")
	public EquipmentModel setDate(@Param("id")String id);
	
}
