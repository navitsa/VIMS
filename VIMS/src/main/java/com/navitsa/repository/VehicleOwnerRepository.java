package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.VehicleOwner;

public interface VehicleOwnerRepository extends CrudRepository<VehicleOwner, String> {

	@Query(value = "SELECT (max(e.ownerID)+1) FROM VehicleOwner e ")
	public String maxVOwnerID();
	
	@Query(value="SELECT vo FROM VehicleOwner vo WHERE vo.vehicleID.vehicleID =:vehicleID")
	public List<VehicleOwner> getVehicleOwnerByVehicleID(@Param("vehicleID")String vehicleID);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE VehicleOwner vo SET vo.status ='previousOwner' WHERE vo.ownerID !=:ownerID AND vo.vehicleID.vehicleID =:vehicleID")
	public int updateOwnerStatus(@Param("ownerID")String ownerID,@Param("vehicleID")String vehicleID);

	@Query(value="SELECT vo FROM VehicleOwner vo WHERE vo.vehicleID.vehicleID =:vehicleID AND vo.status ='currentOwner'")
	public VehicleOwner getVehicleOwnerIDByVehicleID(@Param("vehicleID")String vehicleID);
	
	//Nuwan define methods
	@Query(value="SELECT vo FROM VehicleOwner vo WHERE vo.vehicleID.vehicleID =:vehicleNo")
	public List<VehicleOwner> getOwnersByVehicleNo(@Param("vehicleNo")String vehicleNo);

	
}
