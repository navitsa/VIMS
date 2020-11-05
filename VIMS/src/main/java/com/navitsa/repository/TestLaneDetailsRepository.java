package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.navitsa.entity.TestLaneDetails;

public interface TestLaneDetailsRepository extends CrudRepository<TestLaneDetails, String> {
	@Query(value = "SELECT (max(s.testLaneDetailsid)+1) FROM TestLaneDetails s ")
    public String maxlaneid();
	
	@Query(value = "SELECT s.testType.typeId FROM TestLaneDetails s group by s.testType.typeId order by s.testType.typeId ")
    public String[] testLaneDetailsByGroup();
	
	@Query(value = "SELECT  s FROM TestLaneDetails s WHERE s.testLaneHeadId.testLaneHeadId = :testLaneDetailsid")
	public List<TestLaneDetails> searchLaneDetails(@Param("testLaneDetailsid") String testLaneDetailsid);

	@Query(value = "SELECT * FROM test_lanes_details_lane_view l where l.Center_ID=:center",nativeQuery = true)
	String[][] getLaneForLaneDetails(@Param("center") String center);
	
	@Query(value = "SELECT * FROM test_lane_for_vclass l where l.Center_ID=:center and l.Vehicle_Class_ID=:veClassId  GROUP BY l.Category_Id",nativeQuery = true)
	String[][] getLanesifmorLane(@Param("center") String center,@Param("veClassId") String veClassId);
	
	@Query(value = "SELECT * FROM test_lane_for_vclass l where l.Center_ID=:center and l.Vehicle_Class_ID=:veClassId and l.Category_Id=:testCat GROUP BY l.Lane_ID",nativeQuery = true)
	String[][] getLanesifmorLaneCat(@Param("center") String center,@Param("veClassId") String veClassId,@Param("testCat")String testCat);
	
	
}

