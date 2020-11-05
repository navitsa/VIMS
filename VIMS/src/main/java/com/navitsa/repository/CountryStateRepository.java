package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.CountryState;

public interface CountryStateRepository  extends CrudRepository<CountryState , String>{

	@Query(value = "SELECT cs FROM CountryState cs WHERE cs.countryCode.countryCode=:countyrCode")
	public List<CountryState> getallStateFromCountry(@Param("countyrCode")String countyrCode);

}
