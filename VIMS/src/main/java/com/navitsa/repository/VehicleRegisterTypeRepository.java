package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.VehicleRegisterType;

public interface VehicleRegisterTypeRepository extends CrudRepository<VehicleRegisterType, String> {

	@Query(value = "SELECT (max(e.vRegTypeID)+1) FROM VehicleRegisterType e ")
	public String maxVRegTypeID();
}
