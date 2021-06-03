package com.navitsa.hrm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.hrm.entity.JobProfileDetails;

public interface JobProfileDetailsRepository extends CrudRepository<JobProfileDetails, String> {

	@Query(value = "SELECT (max(j.jobProfileID)+1) FROM JobProfileDetails j ")
	public String maxJobDetailsID();
	
}
