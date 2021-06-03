package com.navitsa.hrm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.hrm.entity.SalaryGrade;

public interface SalaryGradeRepository extends CrudRepository<SalaryGrade, String>{
	
	//get max id
	@Query(value = "SELECT (max(s.gradeID)+1) FROM SalaryGrade s ")
	public String maxSgid();

}
