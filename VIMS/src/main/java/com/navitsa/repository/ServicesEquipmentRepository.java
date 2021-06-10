package com.navitsa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.EquipmentMaster;
import com.navitsa.entity.ServicesEquipment;

public interface ServicesEquipmentRepository  extends CrudRepository<ServicesEquipment, Integer> {
	
	@Query(value="SELECT ec FROM ServicesEquipment ec WHERE ec.servicedDate between :fromdate and :todate")
	public List<ServicesEquipment> getServicedEquipmentsReport(@Param("fromdate")String fromdate,@Param("todate") String todate);

	@Query(value="SELECT ec FROM ServicesEquipment ec WHERE ec.servicedDate between :fromdate and :todate")
	public List<ServicesEquipment> getDetailsByDate(@Param("fromdate")String fromdate,@Param("todate") String todate);

	
	
	@Query(value="SELECT servicesReport FROM ServicesEquipment")
	public List<ServicesEquipment> getServiceReport();

	/*
	 * @Query(value="SELECT * FROM ServicesEquipment") public
	 * List<ServicesEquipment> getAll();
	 */

	/*
	 * @Query(value="SELECT servicesReport FROM ServicesEquipment") public
	 * List<ServicesEquipment> getReport(@Param("now")String now);
	 */



	
	
	
}
