package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.TestParameterAngle;

public interface TestParameterAngleRepository extends CrudRepository<TestParameterAngle, String> {
	
    @Query(value = "SELECT pa FROM TestParameterAngle pa WHERE pa.testParameter.testParameterId =:paraID")
    List<TestParameterAngle> findAllByTestParaID(@Param("paraID") String paraID);
    
	@Query(value = "SELECT (max(tpa.paraAngleID)) FROM TestParameterAngle tpa WHERE tpa.testParameter.testParameterId =:paraID")
    public String maxAngleID(@Param("paraID") String paraID);

}
