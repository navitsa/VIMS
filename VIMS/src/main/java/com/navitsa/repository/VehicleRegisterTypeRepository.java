package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.VehicleRegisterType;

public interface VehicleRegisterTypeRepository extends CrudRepository<VehicleRegisterType, String> {

	@Query(value = "SELECT (max(e.vRegTypeID)+1) FROM VehicleRegisterType e ")
	public String maxVRegTypeID();
	
	@Query(value = "SELECT e FROM VehicleRegisterType e where e.status='Active'")
	public List<VehicleRegisterType> getActiveVehicleRegisterType();	
	
}
