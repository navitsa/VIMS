package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.VehiclesSubCategory;
import com.navitsa.repository.VehiclesSubCategoryRepository;

@Service
@Transactional
public class VehicleSubCategoryService {

	@Autowired
	VehiclesSubCategoryRepository vSubCatRepo;
	
	
	public List<VehiclesSubCategory> findAll(){
		
		return (List<VehiclesSubCategory>) vSubCatRepo.findAll();
		
	}
}
