package com.navitsa.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.navitsa.entity.AddLaneHeadCategory;
import com.navitsa.entity.AddLaneHeadVehicleClass;
import com.navitsa.entity.TestLane;
import com.navitsa.entity.TestLaneDetails;
import com.navitsa.entity.TestLaneHead;
import com.navitsa.entity.Test_type;
import com.navitsa.entity.VehicleRegisterType;
import com.navitsa.repository.AddLaneHeadCategoryRepository;
import com.navitsa.repository.AddLaneHeadVehicleClassRepository;
import com.navitsa.repository.TestLaneDetailsRepository;
import com.navitsa.repository.TestLaneHeadRepository;
import com.navitsa.repository.TestLaneRepository;
import com.navitsa.repository.Test_typeRepository;

@Service
@Transactional
public class LaneServices {
	@Autowired
	TestLaneRepository laneRepo;	
	@Autowired
	TestLaneDetailsRepository testlaneDetailsRepo;
	@Autowired
	Test_typeRepository testTypeRepo;
	@Autowired
	TestLaneRepository testLaneRepo;
	@Autowired
	TestLaneHeadRepository testLaneHeadRepo;
	@Autowired
	AddLaneHeadCategoryRepository addLaneHeadCategoryRepo;
	@Autowired
	AddLaneHeadVehicleClassRepository addLaneHeadVehicleClassRepo;
	
	public void saveTestLane(TestLane testLane) {
		laneRepo.save(testLane);
	}

	public List<TestLane> getAllLaneDetails() {
		return (List<TestLane>) laneRepo.findAll();
	}
	public TestLane getAllLaneDetailsByID(String id) {
		return  laneRepo.findById(id).get();
	}
	
	public void saveTestLaneDetails(TestLaneDetails testlanedetails) {
		testlaneDetailsRepo.save(testlanedetails);
	}
	
	public List <TestLaneDetails> listTestDetails(){
		return (List<TestLaneDetails>) testlaneDetailsRepo.findAll();
	}
	
	public String maxlaneDetailsid() {
		if (testlaneDetailsRepo.maxlaneid() == null) {
			return "1";
		} else {

			return testlaneDetailsRepo.maxlaneid();
		}

	}
	
	public List <Test_type> getTesttypeCombo(){
		return (List<Test_type>) testTypeRepo.findAll();
	}
	
	
    public String[] testLaneDetailsByGroup() {
    	return testlaneDetailsRepo.testLaneDetailsByGroup();
    }
	
	
    public String[][] getLaneForLaneDetails(String center){   	
    	return testlaneDetailsRepo.getLaneForLaneDetails(center);
    }
    public String[][] getLanesifmorLane(String center,String veClassId){   	
    	return testlaneDetailsRepo.getLanesifmorLane(center,veClassId);
    }
    
    public String[][] getLanesifmorLaneCat(String center,String veClassId,String testCat){   	
    	return testlaneDetailsRepo.getLanesifmorLaneCat(center,veClassId,testCat);
    }
    
   
	public String maxlanetyid() {
		if (testLaneRepo.maxlanetyid() == null) {
			return "1";
		} else {

			return testLaneRepo.maxlanetyid();
		}

	}
	
	public TestLane getTestLaneById(String laneId) {
		return laneRepo.findById(laneId).get();
	}

	public List <TestLaneHead> listTestLaneHead(){
		return (List<TestLaneHead>) testLaneHeadRepo.findAll();
	}
	public void saveTestLaneHead(TestLaneHead testLaneHead) {
		testLaneHeadRepo.save(testLaneHead);
	}
	public String maxlaneHeadid() {
		if (testLaneHeadRepo.maxlaneHeadid()== null) {
			return "1";
		} else {

			return testLaneHeadRepo.maxlaneHeadid();
		}
	
	}

	public TestLaneDetails testDetailsByID(String id){
		return  testlaneDetailsRepo.findById(id).get();
	}
	public TestLaneHead getTestLaneHeadById(String id) {
		return testLaneHeadRepo.findById(id).get();
	}
	public List<TestLaneHead> getAllTestLaneHead(){
		return (List<TestLaneHead>) testLaneHeadRepo.findAll();
	}
	
	public List<TestLaneHead> getTestLaneHeadDetailByCenter(String cid){
		return (List<TestLaneHead>) testLaneHeadRepo.getTestLaneHeadDetailByCenter(cid);
	}
	
	public void saveLaneHeadCategory(AddLaneHeadCategory addLaneHeadCategory) {		
		addLaneHeadCategoryRepo.save(addLaneHeadCategory);		
	}
	public void saveLaneHeadVehicleClass(AddLaneHeadVehicleClass addLaneHeadVehicleClass) {		
		addLaneHeadVehicleClassRepo.save(addLaneHeadVehicleClass);		
	}
	
	public List<AddLaneHeadVehicleClass> listAddLaneHeadVehicleClass(String cid){
		return (List<AddLaneHeadVehicleClass>) addLaneHeadVehicleClassRepo.getlistAddLaneHeadVehicleClass(cid);
	}
	
	public List<AddLaneHeadCategory> listAddLaneHeadCategory(String cid){
		return (List<AddLaneHeadCategory>) addLaneHeadCategoryRepo.listAddLaneHeadCategory(cid);
	}	
	public String[][] getTestLaneHeadDetailByCenterCategoryVclass(String catid,String vclassid,String cenid){
		return  testLaneHeadRepo.getTestLaneHeadDetailByCenterCategoryVclass(catid,vclassid,cenid);
	 
	 }
}
