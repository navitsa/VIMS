package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.TestParameter;

public interface TestParameterRepository extends CrudRepository<TestParameter, String> {
	
    @Query(value = "SELECT tp FROM TestParameter tp WHERE tp.testType.typeId =:typeID")
    List<TestParameter> findAllById(@Param("typeID") String typeID);
    
	@Query(value = "SELECT (max(tp.testParameterId)) FROM TestParameter tp WHERE tp.testType.typeId =:typeID")
    public String maxTestParaID(@Param("typeID") String typeID);

}
