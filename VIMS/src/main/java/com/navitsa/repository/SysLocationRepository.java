package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.navitsa.entity.SysLocation;

public interface SysLocationRepository  extends CrudRepository<SysLocation, String>{

//	@Query(value = "SELECT s FROM SysLocation e where e.glAccNo=:glaccno")
//	public SysLocation getById(@Param("glaccno")String glaccno);
	
}
