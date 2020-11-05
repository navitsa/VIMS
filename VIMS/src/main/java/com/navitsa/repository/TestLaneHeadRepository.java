package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.TestLaneHead;

public interface TestLaneHeadRepository extends CrudRepository<TestLaneHead, String> {

	@Query(value = "SELECT (max(s.testLaneHeadId)+1) FROM TestLaneHead s ")
    public String maxlaneHeadid();
	
	@Query(value = "SELECT s FROM TestLaneHead s where s.centerID.center_ID=:cid ")
    public List<TestLaneHead> getTestLaneHeadDetailByCenter(@Param("cid")String cid);
	
	
	@Query(value = "select s.* FROM test_lane_head s,add_lanehead_category lc,add_lanehead_vehicleclass lv "
			+ "WHERE s.testLaneHead_Id=lc.testLaneHead_Id and s.testLaneHead_Id=lv.testLaneHead_Id "
			+ " and lc.Category_Id=:catid and lv.Vehicle_Class_ID=:vclassid and s.Center_ID=:cenid ",nativeQuery = true)
   String[][] getTestLaneHeadDetailByCenterCategoryVclass(@Param("catid")String catid,@Param("vclassid")String vclassid,@Param("cenid")String cenid);
	 

	
}
