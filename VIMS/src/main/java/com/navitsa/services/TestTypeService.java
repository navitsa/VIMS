package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.EquipmentType;
import com.navitsa.entity.TestTypeEqumentType;
import com.navitsa.entity.Test_type;
import com.navitsa.repository.TestTypeEqumentTypeRepository;
import com.navitsa.repository.Test_typeRepository;

@Service
@Transactional
public class TestTypeService {
	
	@Autowired
	Test_typeRepository testTypeRepo;
	@Autowired
	TestTypeEqumentTypeRepository testTypeEqumentTypeRepo;
	
	
	public List<Test_type> listAll() {
		return (List<Test_type>) testTypeRepo.findAll();
	}
	
	public Test_type listTestTypeById(String id) {
		return testTypeRepo.findById(id).get();
	}
	
	public List<TestTypeEqumentType> listTestTypeEqumentType() {
		return (List<TestTypeEqumentType>) testTypeEqumentTypeRepo.findAll();
	}

	public void saveTestTypeEqumentType(TestTypeEqumentType testTypeEqumentType) {
		testTypeEqumentTypeRepo.save(testTypeEqumentType);
	}
	public List<EquipmentType> getEqupmentTypeByTestType(String testType) {
		return (List<EquipmentType>) testTypeEqumentTypeRepo.getEqupmentTypeByTestType(testType);
	}	
	
	
}
