package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.TestPoint;

public interface TestPointRepository extends CrudRepository<TestPoint, String> {
	
    @Query(value = "SELECT tp FROM TestPoint tp WHERE tp.testType.typeId =:typeID")
    List<TestPoint> findAllByTestTypeID(@Param("typeID") String typeID);
    
	@Query(value = "SELECT (max(tp.testPointID)) FROM TestPoint tp WHERE tp.testType.typeId =:typeID")
    public String maxTestPointID(@Param("typeID") String typeID);

}
