package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.EmissionCodeMapping;

public interface EmissionCodeMappingRepository extends CrudRepository<EmissionCodeMapping , Integer> {

	@Query(value = "SELECT * FROM emission_code_mapping WHERE test_type_id =:testType",nativeQuery=true)
	public List<EmissionCodeMapping> findAllByTestType(@Param("testType") String testType);

	@Query(value="SELECT ID_No FROM edt_certificate_data\n" + 
			"WHERE Vehicle_No=:vehicleID ORDER BY ID_No DESC LIMIT 1;",nativeQuery=true)
	public int find_edt_id(@Param("vehicleID") String vehicleID);
	
	@Query(value="CALL FIND_EDT_DATA(:columnName,:id_no);",nativeQuery=true)
	public String find_edt_data(@Param("columnName") String columnName,@Param("id_no") int id_no);

	@Query(value="SELECT ID_No FROM ept_certificate_data\n" + 
			"WHERE Vehicle_No=:vehicleID ORDER BY ID_No DESC LIMIT 1;",nativeQuery=true)
	public int find_ept_id(@Param("vehicleID") String vehicleID);

	@Query(value="CALL FIND_EPT_PETROL(:tableName,:columnName,:id_no);",nativeQuery=true)
	public String find_ept_petrol(@Param("tableName") String tableName,@Param("columnName") String columnName, @Param("id_no") int id_no);


	
}
