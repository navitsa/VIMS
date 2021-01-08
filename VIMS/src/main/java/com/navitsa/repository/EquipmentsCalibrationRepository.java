package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.EquipmentsCalibration;

public interface EquipmentsCalibrationRepository extends CrudRepository<EquipmentsCalibration, Integer> {

	@Query(value="SELECT ec FROM EquipmentsCalibration ec WHERE ec.calibratedDate=:calibratedDate and ec.centerID.center_ID=:center and ec.status='ACTIVE'")
	public List<EquipmentsCalibration> getCalibratedEquipmentsReport(@Param("calibratedDate")String calibratedDate,@Param("center") String center);
	
	
	
}
