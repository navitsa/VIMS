package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.TestValueFileDetail;

public interface TestValueFileDetailRepository extends CrudRepository<TestValueFileDetail,Integer> {

	@Query(value = "SELECT * FROM test_value_result_detail WHERE Test_Value_File_ID =:test_value_file_id AND code IN (SELECT code FROM emission_code_mapping)",nativeQuery = true)
	public List<TestValueFileDetail> findTestValueFileDetailByHeaderId(@Param("test_value_file_id") int test_value_file_id);

}
