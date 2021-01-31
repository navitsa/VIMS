package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.TestProfileStatus;

public interface TestProfileStatusRepository extends CrudRepository<TestProfileStatus, Integer> {

	@Query(value = "SELECT s FROM TestProfileStatus s "
			+ "WHERE s.profile_id.testProfileID=:pro_id "
			+ "AND s.type_id.typeId=:type_id")
	public TestProfileStatus findBy(@Param("pro_id") int pro_id, 
			@Param("type_id") String type_id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE TestProfileStatus s SET s.status=:status WHERE s.s_id=:s_id")
	public void updateRecord(@Param("s_id") int s_id,@Param("status") int status);
	
	@Query(value = "SELECT s FROM TestProfileStatus s ORDER BY s.profile_id.testProfileID")
	public List<TestProfileStatus> getAll();

}
