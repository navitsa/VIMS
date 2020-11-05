package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.ProfileStages;

public interface ProfileStagesRepository extends CrudRepository<ProfileStages,String> {

	@Query(value = "SELECT s FROM ProfileStages s WHERE s.vp.visualProfileID =:q")
	public List<ProfileStages> search(@Param("q") String q);
	
	@Query(value = "SELECT (max(s.stageID)+1) FROM ProfileStages s ")
    public String maxStageID();
	
	@Query(value = "SELECT s FROM ProfileStages s WHERE s.vp.visualProfileID =:proID")
	public List<ProfileStages> getStagesByProID(@Param("proID") String proID);
	
}
