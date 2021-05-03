package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.TestProfileDetail;

public interface TestProfileDetailRepository extends CrudRepository<TestProfileDetail, Integer> {

	
	@Query(value ="SELECT \r\n" + 
			"    test_value_result_header.`Vehicle_ID` AS Vehicle_ID,\r\n" + 
			"    test_value_result_detail.`Code` AS Code,\r\n" + 
			"    test_value_result_detail.`Result` AS Result,\r\n" + 
			"    test_type.`type_id` AS type_id,\r\n" + 
			"    test_type.`test_type` AS test_type,\r\n" + 
			"    test_point.`test_point_name` AS test_point,\r\n" + 
			"    test_parameter.`para_name` AS para_name,\r\n" + 
			"    test_parameter_angle.`angle_name` AS angle_name,\r\n" + 
			"    test_profile_detail.limit_value_desc AS limit_value_desc,\r\n" + 
			"    test_profile_detail.operator AS operator,\r\n" + 
			"    test_profile_detail.limit_value AS limit_value,\r\n" + 
			"    test_profile_detail.min_value AS min_value,\r\n" + 
			"    test_profile_detail.max_value AS max_value,\r\n" + 
			"    test_profile_status.`status` AS test_profile_status_status,\r\n" + 
			"    test_point.`unit` AS point_unit,\r\n" + 
			"    test_parameter.`unit` AS para_unit,\r\n" + 
			"    test_parameter_angle.`unit` AS angle_unit,\r\n" +
			"    test_profile_detail.`tolerance_plus` AS tolerance_plus,\r\n" +
			"    test_profile_detail.`tolerance_minus` AS tolerance_minus\r\n" + 
			"FROM\r\n" + 
			"    test_profile_header\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_profile_detail ON test_profile_header.`profile_id` = test_profile_detail.`profile_id`\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_value_result_detail ON test_profile_detail.`code` = test_value_result_detail.`Code`\r\n" + 
			"        INNER JOIN\r\n" + 
			"	test_value_result_header ON test_value_result_detail.`Test_Value_File_ID` = test_value_result_header.`Test_Value_File_ID`\r\n" + 
			"		INNER JOIN\r\n" + 
			"    parameter_code ON test_profile_detail.`code` = parameter_code.`code`\r\n" + 
			"		AND test_profile_detail.`type_id` = parameter_code.`type_id`\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_type ON parameter_code.`type_id` = test_type.`type_id`\r\n" + 
			"        LEFT OUTER JOIN\r\n" + 
			"    test_point ON parameter_code.`test_point_id` = test_point.`test_point_id`\r\n" + 
			"        LEFT OUTER JOIN\r\n" + 
			"    test_parameter ON parameter_code.`test_parameter_id` = test_parameter.`test_parameter_id`\r\n" + 
			"        LEFT OUTER JOIN\r\n" + 
			"    test_parameter_angle ON parameter_code.`parameter_angle_id` = test_parameter_angle.`parameter_angle_id`\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_profile_status ON test_type.`type_id` = test_profile_status.`type_id`\r\n" + 
			"        AND test_profile_header.`profile_id` = test_profile_status.`profile_id`    \r\n" + 
			"WHERE\r\n" + 
			"    test_value_result_header.`Test_Value_File_ID` =:test_value_file_id\r\n" + 
			"        AND test_profile_header.`profile_id` =:test_pro_id\r\n" + 
			"        AND test_profile_detail.`vehicle_cat_id` =:vehicle_cat_id AND (test_profile_detail.`rule`=0 OR test_profile_detail.`rule`=:rule)",nativeQuery = true)
	public String[][] getTestResult(@Param("test_pro_id") int test_pro_id,@Param("test_value_file_id") String test_value_file_id,@Param("vehicle_cat_id") String vehicle_cat_id,@Param("rule") int rule);
	
	@Query(value ="SELECT \r\n" + 
			"    test_point.`test_point_name` AS test_point,\r\n" + 
			"    test_parameter.`para_name` AS para_name,\r\n" + 
			"    test_value_result_detail.`Result` AS Result,\r\n" + 
			"    test_type.`type_id` AS type_id,\r\n" + 
			"    test_type.`test_type` AS test_type,\r\n" +
			"    test_profile_detail.`tolerance_plus` AS tolerance_plus,\r\n" +
			"    test_profile_detail.`tolerance_minus` AS tolerance_minus,\r\n" +
			"    test_profile_status.`status` AS test_profile_status_status,\r\n" +
			"	 test_parameter.`unit` AS para_unit\r\n" +
			"FROM\r\n" + 
			"    test_profile_header\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_profile_detail ON test_profile_header.`profile_id` = test_profile_detail.`profile_id`\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_value_result_detail ON test_profile_detail.`code` = test_value_result_detail.`Code`\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_value_result_header ON test_value_result_detail.`Test_Value_File_ID` = test_value_result_header.`Test_Value_File_ID`\r\n" + 
			"        INNER JOIN\r\n" + 
			"    parameter_code ON test_profile_detail.`code` = parameter_code.`code`\r\n" + 
			"        AND test_profile_detail.`type_id` = parameter_code.`type_id`\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_type ON parameter_code.`type_id` = test_type.`type_id`\r\n" + 
			"        LEFT OUTER JOIN\r\n" + 
			"    test_point ON parameter_code.`test_point_id` = test_point.`test_point_id`\r\n" + 
			"        LEFT OUTER JOIN\r\n" + 
			"    test_parameter ON parameter_code.`test_parameter_id` = test_parameter.`test_parameter_id`\r\n" + 
			"        LEFT OUTER JOIN\r\n" + 
			"    test_parameter_angle ON parameter_code.`parameter_angle_id` = test_parameter_angle.`parameter_angle_id`\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_profile_status ON test_type.`type_id` = test_profile_status.`type_id`\r\n" + 
			"        AND test_profile_header.`profile_id` = test_profile_status.`profile_id`\r\n" + 
			"WHERE\r\n" + 
			"    test_value_result_header.`Test_Value_File_ID` =:test_value_file_id\r\n" + 
			"        AND test_profile_header.`profile_id` =:test_pro_id\r\n" + 
			"        AND test_profile_detail.`vehicle_cat_id` =:vehicle_cat_id\r\n" + 
			"        AND test_type.`type_id` = '37000-37999' ORDER BY parameter_code.s_id;",nativeQuery = true)
	public String[][] getSpeedoTestResult(@Param("test_pro_id") int test_pro_id,@Param("test_value_file_id") String test_value_file_id,@Param("vehicle_cat_id") String vehicle_cat_id);

	
	@Query(value ="SELECT \r\n" + 
			"    test_type.`type_id` AS type_id,\r\n" + 
			"    test_type.`test_type` AS test_type,\r\n" + 
			"    test_value_result_detail.`Code` AS Code,\r\n" + 
			"    test_value_result_detail.`Result` AS Result,\r\n" + 
			"    test_profile_detail.operator AS operator,\r\n" + 
			"    test_profile_detail.limit_value AS limit_value,\r\n" + 
			"    test_profile_detail.`tolerance_plus` AS tolerance,\r\n" + 
			"    test_profile_status.`status` AS test_profile_status_status\r\n" + 
			"FROM\r\n" + 
			"    test_profile_header\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_profile_detail ON test_profile_header.`profile_id` = test_profile_detail.`profile_id`\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_value_result_detail ON test_profile_detail.`code` = test_value_result_detail.`Code`\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_value_result_header ON test_value_result_detail.`Test_Value_File_ID` = test_value_result_header.`Test_Value_File_ID`\r\n" + 
			"        INNER JOIN\r\n" + 
			"    parameter_code ON test_profile_detail.`code` = parameter_code.`code`\r\n" + 
			"        AND test_profile_detail.`type_id` = parameter_code.`type_id`\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_type ON parameter_code.`type_id` = test_type.`type_id`\r\n" + 
			"        LEFT OUTER JOIN\r\n" + 
			"    test_point ON parameter_code.`test_point_id` = test_point.`test_point_id`\r\n" + 
			"        LEFT OUTER JOIN\r\n" + 
			"    test_parameter ON parameter_code.`test_parameter_id` = test_parameter.`test_parameter_id`\r\n" + 
			"        LEFT OUTER JOIN\r\n" + 
			"    test_parameter_angle ON parameter_code.`parameter_angle_id` = test_parameter_angle.`parameter_angle_id`\r\n" + 
			"        INNER JOIN\r\n" + 
			"    test_profile_status ON test_type.`type_id` = test_profile_status.`type_id`\r\n" + 
			"        AND test_profile_header.`profile_id` = test_profile_status.`profile_id`\r\n" + 
			"WHERE\r\n" + 
			"    test_value_result_header.`Test_Value_File_ID` =:test_value_file_id\r\n" + 
			"        AND test_profile_header.`profile_id` =:test_pro_id\r\n" + 
			"        AND test_profile_detail.`vehicle_cat_id` =:vehicle_cat_id\r\n" + 
			"        AND test_profile_detail.`vehicle_sub_cat_id` =:vehicle_sub_cat_id",nativeQuery = true)
	public String[][] getMaxSpeedResult(@Param("test_pro_id") int test_pro_id,@Param("test_value_file_id") String test_value_file_id,@Param("vehicle_cat_id") String vehicle_cat_id,@Param("vehicle_sub_cat_id") String vehicle_sub_cat_id);

	@Query(value="SELECT * FROM test_profile_detail WHERE profile_id=:profile_id",nativeQuery = true)
	public List<TestProfileDetail> findByProfileId(@Param("profile_id") int profile_id);
	
}
