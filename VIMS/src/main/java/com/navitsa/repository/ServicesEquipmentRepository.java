package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.ServicesEquipment;

public interface ServicesEquipmentRepository  extends CrudRepository<ServicesEquipment, Integer> {
	
	@Query(value="SELECT ec FROM ServicesEquipment ec WHERE ec.servicedDate=:servicedDate and ec.centerID.center_ID=:center and ec.status='ACTIVE'")
	public List<ServicesEquipment> getServicedEquipmentsReport(@Param("servicedDate")String servicedDate,@Param("center") String center);
	
	
}
