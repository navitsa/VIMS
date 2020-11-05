package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.InventoryLocation;

public interface InventoryLocationRepository extends CrudRepository<InventoryLocation, Integer> {

	@Query(value = "SELECT il FROM InventoryLocation il WHERE il.centerID.center_ID=:centerID")
	public InventoryLocation getInventoryLocationByCenterID(@Param("centerID")String centerID);
}
