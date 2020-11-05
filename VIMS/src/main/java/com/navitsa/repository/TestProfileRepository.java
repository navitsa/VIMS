package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.TestProfile;

public interface TestProfileRepository extends CrudRepository<TestProfile, Integer> {
	
	@Query(value = "SELECT (max(tpro.testProfileID)+1) FROM TestProfile tpro")
    public String maxTestProfileID();

}
