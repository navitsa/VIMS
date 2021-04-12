package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.VehicleMaster;

public interface VehicleMasterRepository extends CrudRepository<VehicleMaster, String> {

	@Query(value = "SELECT (max(e.vehicleID)+1) FROM VehicleMaster e ")
	public String maxVehicleId();
	
	@Query(value="SELECT (max(v.vehicleClassID)) FROM VehicleClass v ")
	public String maxClassID();
	
	@Query(value = "SELECT vm FROM VehicleMaster vm WHERE vm.vehicleID =:vehicleID")
	public List<VehicleMaster> setVId(@Param("vehicleID")String vehicleID); 
	
	@Query(value = "SELECT vm FROM VehicleMaster vm WHERE vm.chassisNo =:vinno and vm.vehicleID!=:veNo")
	public List<VehicleMaster> checkVinNo(@Param("vinno")String vinno,@Param("veNo")String veNo); 
	
	@Query(value = "SELECT vm FROM VehicleMaster vm WHERE vm.engineNo =:engine and vm.vehicleID!=:veNo")
	public List<VehicleMaster> checkEngNo(@Param("engine")String engine,@Param("veNo")String veNo); 
	
	@Transactional
	@Modifying
	@Query(value="UPDATE VehicleMaster vm SET vm.engineNo=:engineNo,vm.chassisNo=:chassisNo,"
			+ "vm.manufactureYear=:mYear,vm.registeredYear=:rYear,vm.engineCapacity=:engineC,"
			+ "vm.noWheel=:noOfWheel,vm.emissionNorms=:emisNorms,"
			+ "vm.vmodel.vehicleModelID=:modelID , vm.ftype.fuelTypeID=:fuelID "
			+ "WHERE vm.vehicleID=:vehicleNo")
	public int updateVehicleMaster(@Param("engineNo")String engineNo,@Param("chassisNo")String chassisNo,
			@Param("mYear")String mYear,@Param("rYear")String rYear,@Param("engineC")String engineC,
			@Param("noOfWheel")String noOfWheel,@Param("emisNorms")String emisNorms,
			@Param("modelID")String modelID,@Param("fuelID")String fuelID,
			@Param("vehicleNo")String vehicleNo);

	
	
}
