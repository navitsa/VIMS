package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.EquipmentsCalibration;

public interface EquipmentsCalibrationRepository extends CrudRepository<EquipmentsCalibration, Integer> {

	@Query(value="SELECT ec FROM EquipmentsCalibration ec WHERE ec.calibratedDate between :fromCalibratedDate and :toCalibratedDate")
	public List<EquipmentsCalibration> getCalibratedEquipmentsReport(@Param("fromCalibratedDate")String fromCalibratedDate,@Param("toCalibratedDate")String toCalibratedDate);

	
	
	@Query(value="SELECT ec FROM EquipmentsCalibration ec WHERE ec.lastCalibrationDate <date")
	public List<EquipmentsCalibration> getCalibratedEquipments(String lastCalibrationDate);


	@Query(value="SELECT ec FROM EquipmentsCalibration ec WHERE ec.calibratedDate between :fromCalibratedDate and :toCalibratedDate")
	public List<EquipmentsCalibration> getCalibarationByDate(@Param("fromCalibratedDate")String fromCalibratedDate,@Param("toCalibratedDate")String toCalibratedDate);

	
	
	
}
