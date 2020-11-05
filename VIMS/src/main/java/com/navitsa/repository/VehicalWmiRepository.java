package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.VehicalWmi;

public interface VehicalWmiRepository extends CrudRepository<VehicalWmi, String> {

	@Query(value = "SELECT vw FROM VehicalWmi vw WHERE vw.wmiid =:wmiid")
	public VehicalWmi getVwmiid(@Param("wmiid")String wmiid); 
	
	
	
}
