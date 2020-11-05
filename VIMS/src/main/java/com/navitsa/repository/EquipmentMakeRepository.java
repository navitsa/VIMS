package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.EquipmentMake;

public interface EquipmentMakeRepository extends CrudRepository<EquipmentMake, String> {

	@Query(value = "SELECT (max(e.eqMakeID)+1) FROM EquipmentMake e ")
	public String maxEqMakeID();
	
	
	@Query(value="SELECT em FROM EquipmentMake em WHERE eqMakeID=:eqMakeID")
	public EquipmentMake searchImg(@Param("eqMakeID")String eqMakeID);
}
