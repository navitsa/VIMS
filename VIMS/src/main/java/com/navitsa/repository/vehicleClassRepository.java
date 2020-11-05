package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.VehicleClass;

public interface vehicleClassRepository extends CrudRepository<VehicleClass, String> {
	
	@Query(value="SELECT (max(v.vehicleClassID)+1) FROM VehicleClass v ")
	public String maxClassID();


}
