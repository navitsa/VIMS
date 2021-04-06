package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navitsa.entity.VehicleCategory;
import com.navitsa.entity.VehicleMake;
import com.navitsa.repository.VehicleCategoryRepository;

@Service
public class VehicleCategoryService {

	@Autowired
	VehicleCategoryRepository vehicleCategoryRepository;

	public void saveVehicleCategory(VehicleCategory vehicleCategory) {
		vehicleCategoryRepository.save(vehicleCategory);
	}

	public List<VehicleCategory> getCategoryList() {
		return (List<VehicleCategory>) vehicleCategoryRepository.findAll();
	}

	public VehicleCategory getVehicleCategoryById(String id) {
		return vehicleCategoryRepository.findById(id).get();
	}
}
