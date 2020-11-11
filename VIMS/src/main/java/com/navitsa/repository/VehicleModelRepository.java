package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.VehicleModel;

public interface VehicleModelRepository extends CrudRepository<VehicleModel, String> {

	@Query(value = "SELECT (max(s.vehicleModelID)+1) FROM VehicleModel s ")
    public String maxModelID();
	
	@Query(value = "SELECT vm FROM VehicleModel vm WHERE vm.vehicleMakeID.vehicleMakeID =:makeID AND vm.vehicleClass.vehicleClassID=:vehicleClassID")
	public List<VehicleModel> getModelByID(@Param("makeID") String makeID,@Param("vehicleClassID")String vehicleClassID);

	
	@Query(value = "SELECT vm FROM VehicleModel vm WHERE vm.vehicleMakeID.vehicleMakeID =:makeID AND vm.vehicleClass.vehicleClassID=:vehicleClassID and vm.vehicleModel=:modelname")
	public List<VehicleModel> getModelCheck(@Param("makeID") String makeID,@Param("vehicleClassID")String vehicleClassID,@Param("modelname")String modelname);
	

}