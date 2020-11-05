package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.TestLane;

public interface TestLaneRepository extends CrudRepository<TestLane, String> {
	
	
	//@Query(value = "SELECT tl FROM TestLane tl WHERE tl.centerId.center_ID =:center")
	//public List<TestLane> searchlanes(@Param("center") String center);
	
//	@Query(value = "SELECT l FROM TestLane l where l.centerId.center_ID=:centerId order by l.laneId")
//	List<TestLane> getLaneForLaneDetails(@Param("centerId") String centeID);
	
	@Query(value = "SELECT (max(l.laneId)+1) FROM TestLane l")
	String maxlanetyid();	
	
}
