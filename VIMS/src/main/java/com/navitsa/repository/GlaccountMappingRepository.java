package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.GlaccountMapping;

public interface GlaccountMappingRepository  extends CrudRepository<GlaccountMapping, Integer>{

	@Query(value="SELECT gm FROM GlaccountMapping gm WHERE gm.docid.docid=:docid")
	public List<GlaccountMapping> getGlaccountMappingByDocId(@Param("docid")int docid);
	
}
