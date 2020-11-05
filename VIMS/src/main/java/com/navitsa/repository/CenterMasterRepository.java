package com.navitsa.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.CenterMaster;
import com.navitsa.entity.CountryMaster;


public interface CenterMasterRepository extends CrudRepository<CenterMaster, String>{
	
	@Query(value = "SELECT (max(s.center_ID)+1) FROM CenterMaster s ")
    public String maxCenterMID();
	
	@Query(value = "SELECT cm FROM CountryMaster cm WHERE status = 'Active' AND cm.countryCode =:countryCode")
	public List<CountryMaster> setCountry(@Param("countryCode")String countryCode);
	
}
