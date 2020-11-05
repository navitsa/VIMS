package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navitsa.entity.BusinessPartner;
import com.navitsa.entity.CenterMaster;
import com.navitsa.entity.CenterTypes;
import com.navitsa.entity.CountryMaster;
import com.navitsa.entity.CountryState;
import com.navitsa.entity.EquipmentMake;
import com.navitsa.entity.EquipmentMaster;
import com.navitsa.entity.EquipmentModel;
import com.navitsa.entity.EquipmentType;
import com.navitsa.entity.InventoryLocation;
import com.navitsa.entity.TestCategory;
import com.navitsa.entity.TestLane;
import com.navitsa.entity.TestLaneDetails;
import com.navitsa.entity.Test_type;
import com.navitsa.entity.Users;
import com.navitsa.repository.BusinessPartnerRepository;
import com.navitsa.repository.CenterMasterRepository;
import com.navitsa.repository.CenterTypeRepository;
import com.navitsa.repository.CountryMasterRepository;
import com.navitsa.repository.CountryStateRepository;
import com.navitsa.repository.EquipmentMakeRepository;
import com.navitsa.repository.EquipmentMasterRepository;
import com.navitsa.repository.EquipmentModelRepository;
import com.navitsa.repository.EquipmentTypeRepository;
import com.navitsa.repository.InventoryLocationRepository;
import com.navitsa.repository.TestCategoryRepository;
import com.navitsa.repository.TestLaneDetailsRepository;
import com.navitsa.repository.TestLaneRepository;
import com.navitsa.repository.Test_typeRepository;
import com.navitsa.repository.UsersRepository;

@Service
public class CenterService {
	@Autowired
	CenterTypeRepository repo1;
	
	
	@Autowired
	CenterMasterRepository repo2;
	
	@Autowired
	CountryMasterRepository repo3;
	
	@Autowired
	BusinessPartnerRepository repo4;
	
	@Autowired
	TestLaneDetailsRepository testlaneDetailsRepo;
	
	@Autowired
	EquipmentTypeRepository equipmentTypeRepo;
	
	@Autowired
	TestLaneRepository testlaneRepo;
	
	@Autowired
	EquipmentMakeRepository eqMakeRepo;
	
	@Autowired
	EquipmentModelRepository eqModelrepo;
	
	@Autowired
	EquipmentMasterRepository eqMasterrepo;
	
	@Autowired
	UsersRepository userRepo;
	
	@Autowired
	TestCategoryRepository categoryRepo;
	
	@Autowired
	Test_typeRepository testTypeRepo;
	
	@Autowired
	InventoryLocationRepository inventoryLocationRepo;
	
	@Autowired
	CountryStateRepository countStateRepo;
	
	
	public void save(CenterTypes centerType) {
		repo1.save(centerType);
	}
	
	//center type id
	public String getId() {
		if(repo1.maxCTypeID() == null) {
		return "1";
	} else {
		return repo1.maxCTypeID();
	}
}
	
	//get all centertypes
	public List<CenterTypes> getAllCTypes() {
		return  (List<CenterTypes>) repo1.findAll();
	}
	
	public CenterTypes get(String id) {
		
		return repo1.findById(id).get();
	}
	 
	//findLocation
	public List<CountryMaster> setCountry(String countryCode) {
		return repo2.setCountry(countryCode);
	}
	
	public List <CenterTypes> listcenters(){
		return(List<CenterTypes>) repo1.findAll();
	}
	
	public void delete(String id) {
		repo1.deleteById(id);
	}
	
	public void saveMaster(CenterMaster cm) {
		repo2.save(cm);
	
	}
	
	public String maxCenterMID() {
		if (repo2.maxCenterMID() == null) {
			return "1";
		} else {

			return repo2.maxCenterMID();
		}

	}
	
	public List<CenterMaster> listAll(){
		return (List<CenterMaster>) repo2.findAll();
		
	}
	
	public CenterMaster getcenterById(String center_ID) {
		return repo2.findById(center_ID).get();
	}
	 
	public List<CountryMaster> getClistAll() {
		return (List<CountryMaster>) repo3.findAll();

	}
	
	public List<BusinessPartner > getBusinesslistAll() {
		return (List<BusinessPartner >) repo4.findAll();

	}
	
	public void save(TestLaneDetails testlanedetails) {
		testlaneDetailsRepo.save(testlanedetails);
	}
	
	public List <TestLaneDetails> listTestDetails(String headid){
		return (List<TestLaneDetails>) testlaneDetailsRepo.searchLaneDetails(headid);
	}
	
	public String maxlaneid() {
		if (testlaneDetailsRepo.maxlaneid() == null) {
			return "1";
		} else {

			return testlaneDetailsRepo.maxlaneid();
		}

	}
	
	public TestLaneDetails getTestLaneDetailsBYID(String testLaneDetails) {
		return testlaneDetailsRepo.findById(testLaneDetails).get();
	}
	
	public List<EquipmentType> getEqAll() {
		return (List<EquipmentType>) equipmentTypeRepo.findAll();

	}
	public List<TestLane> getLaneListDetails(){
		return (List<TestLane>) testlaneRepo.findAll();
	}
	
	public List<EquipmentMake> getListOfEQMakeList(){
		return (List<EquipmentMake>) eqMakeRepo.findAll();

	}
	public List <EquipmentModel> getListOFEQModelList(){
		return (List<EquipmentModel>) eqModelrepo.findAll();
		}
	
	public List <EquipmentMaster> getListOFEQMaster(){
		return (List<EquipmentMaster>) eqMasterrepo.findAll();
	}
	public List <Users> getUserListD (){
		return (List<Users>) userRepo.findAll();
		
	}
	public void saveTestLaneDetails(TestLaneDetails tl) {
		testlaneDetailsRepo.save(tl);
	}
	public List<Test_type> getTest_typedetails(){
		return (List<Test_type>) testTypeRepo.findAll();
	}
	
	public void saveTestType(Test_type testType) {
		testTypeRepo.save(testType);
	}

	public Test_type getTesttypeDetailsBYID(String typeId) {
		return testTypeRepo.findById(typeId).get();
	}

	//test category
	public String getCategoryId() {
		if(categoryRepo.maxCategoryId() == null) {
			return "1";
		} else {
			return categoryRepo.maxCategoryId();
		}
	}
	//save
	public void savecategory(TestCategory category) {
		categoryRepo.save(category);
	}
	
	public TestCategory getCategoryId(String categoryId) {
		return categoryRepo.findById(categoryId).get();
	}
	
	public List<TestCategory> getAll() {
		return (List<TestCategory>) categoryRepo.findAll();
	}
	
	public int getProfileID(String cat_id)
	{
		return categoryRepo.getProfileID(cat_id);
	}
	public void saveInventoryLocation(InventoryLocation inventoryLocation) {
		inventoryLocationRepo.save(inventoryLocation);
	}
	public InventoryLocation getInventoryLocationByCenterID(String centerID){
		return inventoryLocationRepo.getInventoryLocationByCenterID(centerID);
		
	}
	public List<InventoryLocation> getAllInventoryLocation() {
		return (List<InventoryLocation>)inventoryLocationRepo.findAll();
	}
	
	public List<CountryState> getallStateFromCountry(String countyrCode){
		return countStateRepo.getallStateFromCountry(countyrCode);
		
	}
}
