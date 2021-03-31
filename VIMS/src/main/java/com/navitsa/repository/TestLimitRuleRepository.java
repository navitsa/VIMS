package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.TestLimitRule;

public interface TestLimitRuleRepository extends CrudRepository<TestLimitRule, Integer> {

	@Query(value = "SELECT * FROM test_limit_rule WHERE effective_from < :year AND effective_to > :year",nativeQuery = true)
	public TestLimitRule findRuleByYear(@Param("year") String year);
	
	@Query(value = "SELECT (max(a.ruleCode)+1) FROM TestLimitRule a")
    public String nextTestLimitRuleId();

}
