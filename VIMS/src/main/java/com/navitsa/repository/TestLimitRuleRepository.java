package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.TestLimitRule;

public interface TestLimitRuleRepository extends CrudRepository<TestLimitRule, Integer> {

//	@Query(value = "SELECT * FROM test_limit_rule WHERE effective_from < :year AND effective_to > :year "
//			+ "AND fuel_type=:fuelID "
//			+ "AND vehicle_category_type =:vehicleCatTypeID "
//			+ "AND stroke =:stroke",nativeQuery = true)
//	public TestLimitRule findRuleByYear(@Param("year") String year,
//			@Param("fuelID") String fuelID,
//			@Param("vehicleCatTypeID") String vehicleCatTypeID,
//			@Param("stroke") String stroke);
	
	@Query(value = "SELECT t FROM TestLimitRule t WHERE t.effectiveFrom < :year AND effectiveTo > :year AND t.fuelType.fuelTypeID = :fuel")
	public TestLimitRule filterVehicle(@Param("year") String year,@Param("fuel") String fuel);
	
	@Query(value = "SELECT (max(a.ruleCode)+1) FROM TestLimitRule a")
    public String nextTestLimitRuleId();

	@Query(value = "SELECT t.ruleCode FROM TestLimitRule t WHERE t.ruleName=:emissionNorms")
	public int getRuleCode(@Param("emissionNorms") String emissionNorms);

}
