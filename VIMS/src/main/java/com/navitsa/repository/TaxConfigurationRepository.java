package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.TaxConfiguration;

public interface TaxConfigurationRepository extends CrudRepository<TaxConfiguration , String> {

	@Query(value = "SELECT (max(t.taxCode)+1) FROM TaxConfiguration t ")
	public String maxtaxID();
	
	@Query(value = "SELECT t FROM TaxConfiguration t where t.countryCode=:country ")
	public List<TaxConfiguration> getTaxFromCountry(@Param("country") String country);
	
}
