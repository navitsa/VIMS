package com.navitsa.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.Glaccount;

public interface GlaccountRepository extends CrudRepository<Glaccount, String> {
	
	@Query(value = "SELECT e FROM Glaccount e where e.primaryAccount=:priAccount")
	public  List<Glaccount> getglaccountByPrimary(@Param("priAccount")String priAccount);
	
	@Query(value = "SELECT e FROM Glaccount e where e.glAccNo=:glaccno")
	public Glaccount getById(@Param("glaccno")String glaccno);
	
}
