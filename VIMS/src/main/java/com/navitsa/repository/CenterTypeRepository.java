package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.CenterTypes;

public interface CenterTypeRepository extends CrudRepository<CenterTypes, String>{

	@Query(value = "SELECT (max(e.centerTypeID)+1) FROM CenterTypes e")
	public String maxCTypeID();
	
	
}
