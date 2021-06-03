package com.navitsa.hrm.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.hrm.entity.leaveClass;


public interface LeaveClassReository extends CrudRepository <leaveClass, String> {

	@Query(value = "SELECT (max(rm.leaveCode)+1) FROM leaveClass rm")
	public String getMaxL();

}

