package com.navitsa.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navitsa.entity.CountryMaster;
import com.navitsa.repository.CountryMasterRepository;

@Service
@Transactional
public class RegionalService {

	@Autowired
	 CountryMasterRepository cRepo;
	
	public void save(CountryMaster cMaster) {
		cRepo.save(cMaster);
	}

	public CountryMaster geAllCountrybyID(String id) {
		return cRepo.findById(id).get();
	}
	
	public List<CountryMaster> getAll() {
		return (List<CountryMaster>) cRepo.findAll();
	}
	//set default status
	public int setDefault(String countryCode) {
		return cRepo.setDefault(countryCode);
	}
}
