package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.AddLaneHeadCategory;

public interface AddLaneHeadCategoryRepository extends CrudRepository<AddLaneHeadCategory , Integer> {

	
	@Query(value = "SELECT  s FROM AddLaneHeadCategory s WHERE s.testLaneHeadId.testLaneHeadId = :lhid")
	List<AddLaneHeadCategory> listAddLaneHeadCategory(@Param("lhid") String cid);
}
