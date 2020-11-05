package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.EquipmentType;

public interface EquipmentTypeRepository extends CrudRepository<EquipmentType, String> {

	@Query(value = "SELECT (max(e.eqTypeID)+1) FROM EquipmentType e ")
	public String maxEqTypeID();

}
