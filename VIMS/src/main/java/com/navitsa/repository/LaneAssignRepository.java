package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.LaneAssign;

public interface LaneAssignRepository extends CrudRepository<LaneAssign, Integer>{

	@Query(value = "SELECT l FROM LaneAssign l WHERE l.status='ACTIVE' and l.testLaneHeadId.testLaneHeadId=:laneid and :nowdate between l.fromDate and l.toDate and :nowtime between l.fromTime and l.toTime")
	public List<LaneAssign> getLaneInspector(@Param("laneid") String laneid,@Param("nowdate") String nowdate,@Param("nowtime") String nowtime);
}
