package com.navitsa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.CountryMaster;

public interface CountryMasterRepository extends CrudRepository<CountryMaster, String> {

	@Transactional
	@Modifying
	@Query(value="UPDATE CountryMaster cm SET cm.status='Inactive' WHERE cm.countryCode !=:countryCode")
	public int setDefault(@Param("countryCode")String countryCode);
}
