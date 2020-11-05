package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.AddLaneHeadVehicleClass;

public interface AddLaneHeadVehicleClassRepository extends CrudRepository<AddLaneHeadVehicleClass , Integer>{
	
	
	@Query(value = "SELECT  s FROM AddLaneHeadVehicleClass s WHERE s.testLaneHeadId.testLaneHeadId = :lhid")
	List<AddLaneHeadVehicleClass> getlistAddLaneHeadVehicleClass(@Param("lhid") String cid);

}
