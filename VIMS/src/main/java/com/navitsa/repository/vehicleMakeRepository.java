package com.navitsa.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.VehicleMake;

public interface vehicleMakeRepository extends CrudRepository<VehicleMake, String> {


	@Query(value = "SELECT vm FROM VehicleMake vm WHERE vm.vehicleMakeID =:vmake")
	public VehicleMake searchlogo(@Param("vmake") String vmake);
	
	@Query(value = "SELECT (max(vm.vehicleMakeID)+1) FROM VehicleMake vm")
    public String maxVMakeID();

	@Query(value = "SELECT vm FROM VehicleMake vm WHERE vm.status ='Active' ORDER BY vm.vehicleMake ASC")
	public List<VehicleMake> getActiveMakes();
}
