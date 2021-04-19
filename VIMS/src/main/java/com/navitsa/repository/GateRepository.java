package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.Gate;

public interface GateRepository extends CrudRepository<Gate, String>{

	@Query(value="SELECT (max(g.gateID)+1) FROM Gate g ")
	public String maxGateID();

}
