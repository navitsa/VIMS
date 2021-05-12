package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navitsa.entity.Gate;
import com.navitsa.entity.VehicleCategory;
import com.navitsa.entity.VehicleCategoryType;
import com.navitsa.entity.VehicleMake;
import com.navitsa.repository.VehicleCategoryRepository;
import com.navitsa.repository.VehicleCategoryTypeRepository;

@Service
public class VehicleCategoryService {

	@Autowired
	VehicleCategoryRepository vehicleCategoryRepository;
	
	@Autowired
	VehicleCategoryTypeRepository vehicleCategoryTyperepo;

	public void saveVehicleCategory(VehicleCategory vehicleCategory) {
		vehicleCategoryRepository.save(vehicleCategory);
	}

	public List<VehicleCategory> getCategoryList() {
		return (List<VehicleCategory>) vehicleCategoryRepository.findAll();
	}

	public VehicleCategory getVehicleCategoryById(String id) {
		return vehicleCategoryRepository.findById(id).get();
	}

	public List<VehicleCategoryType> getAlltypes() {
		return (List<VehicleCategoryType>) vehicleCategoryTyperepo.findAll();
	}
	
}
