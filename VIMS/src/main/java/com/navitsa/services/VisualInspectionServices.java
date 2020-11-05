package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.ItemRemarks;
import com.navitsa.entity.ProfileItemsStatus;
import com.navitsa.entity.ProfileStages;
import com.navitsa.entity.TestCategory;
import com.navitsa.entity.VehicleRegistration;
import com.navitsa.entity.VisualChecklistDetail;
import com.navitsa.entity.VisualChecklistMaster;
import com.navitsa.entity.VisualProfile;
import com.navitsa.entity.VisualProfileItems;
import com.navitsa.repository.ItemStatusRemarksRepository;
import com.navitsa.repository.ProfileItemsStatusRepository;
import com.navitsa.repository.ProfileStagesRepository;
import com.navitsa.repository.TestCategoryRepository;
import com.navitsa.repository.VehicleRegistrationRepository;
import com.navitsa.repository.VisuaProfileItemRepository;
import com.navitsa.repository.VisualChecklistDetailRepo;
import com.navitsa.repository.VisualChecklistMasterRepo;
import com.navitsa.repository.VisualInspectionRepository;

@Service
@Transactional
public class VisualInspectionServices {

	@Autowired
	VisualInspectionRepository profileRepo;
	
	@Autowired
	ProfileStagesRepository stageRepo;
	
	@Autowired
	ProfileItemsStatusRepository itemStatusRepo;
	
	@Autowired
	VisuaProfileItemRepository itemRepo;
	
	@Autowired
	ItemStatusRemarksRepository remarkRepo;
	
	@Autowired
	VehicleRegistrationRepository vehicleRegRepo;
	
	@Autowired
	VisualChecklistMasterRepo chMasterRepo;
	
	@Autowired
	VisualChecklistDetailRepo chDetailRepo;
	
	@Autowired
	TestCategoryRepository testCatRepo;

/*------------------------------------------------------------------*/
//Following has profile methods
	
	public void saveProfile(VisualProfile profile) {
		profileRepo.save(profile);
	}

	public List<VisualProfile> listProfiles() {
		return (List<VisualProfile>) profileRepo.findAll();
	}
	
	public VisualProfile getProfile(String id) {
		return profileRepo.findById(id).get();
	}
    public String maxProfileID() {
    	
    	if(profileRepo.maxProfileID()==null)
    		return "1";
    	else
    		return profileRepo.maxProfileID();
    }
/*-----------------------------------------------------------------*/
  //Following has stage methods
    
	public List<ProfileStages> searchStages(String profileID) {
		return stageRepo.search(profileID);
	}
	
	public void saveStage(ProfileStages stage) {
		stageRepo.save(stage);
	}
	
	public ProfileStages getStage(String id) {
		return stageRepo.findById(id).get();
	}
	
	public List<ProfileStages> listStages() {
		return (List<ProfileStages>) stageRepo.findAll();
	}
	
	public List<ProfileStages> getStagesByProID(String proID) {
		return (List<ProfileStages>) stageRepo.getStagesByProID(proID);
	}
	
    public String maxStageID() {
    	if(stageRepo.maxStageID()==null)
    		return "1";
    	else
    		return stageRepo.maxStageID();
    }

/*...............................................................*/
  //Following has item status methods
    
	public  List<ProfileItemsStatus> listStatus(){
		return (List<ProfileItemsStatus>) itemStatusRepo.findAll();
	}
	public void saveStatus(ProfileItemsStatus status) {
		itemStatusRepo.save(status);
	}
	public ProfileItemsStatus getStatus(String id) {
		return itemStatusRepo.findById(id).get();
	}
	public List<ProfileItemsStatus> searchStatus(String profileID,String stageID,String itemID) {
		return itemStatusRepo.search(profileID,stageID,itemID);
	}
    public String maxStatusID() {
    	
    	if(itemStatusRepo.maxStatusID()==null)
    		return "1";
    	else
    		return itemStatusRepo.maxStatusID();
    }
/*-----------------------------------------------------------------*/
	// this method used to get pending vehicles in checklist form
	public VehicleRegistration getPendingVehicleForInspection(String vReg_Id) {
		return vehicleRegRepo.findById(vReg_Id).get();
	}
	
	public List<VehicleRegistration> getPendingVehiclesForInspection() {
		return vehicleRegRepo.getPendingVehicle();
	}

/*-----------------------------------------------------------------*/
	/*Following has Item methods*/
	
    public String maxItemID() {
    	
    	if(itemRepo.maxItemID()==null)
    		return "1";
    	else
    		return itemRepo.maxItemID();
    		
    }
    
	public void save(VisualProfileItems pro) {
		itemRepo.save(pro);
	}
	
	public List<VisualProfileItems> listAll1(){
		return (List<VisualProfileItems>) itemRepo.findAll();
	}
	
	public VisualProfileItems profileItemByID(String id) {
		return itemRepo.findById(id).get();
	}
	
	public List<VisualProfileItems> searchItems(String profileID,String stageID) {
		return itemRepo.search(profileID,stageID);
	}
	 
/*-----------------------------------------------------------------*/
	
	/*following has item status remark methods*/
	
    public String maxRemarkID() {
    	
    	if(remarkRepo.maxRemarkID()==null)
    		return "1";
    	else
    		return remarkRepo.maxRemarkID();
    }
    
	public  List<ItemRemarks> listRemarks(){
		return (List<ItemRemarks>) remarkRepo.findAll();
	}
	
	public void save(ItemRemarks remarks) {
		remarkRepo.save(remarks);
	}
	
	public ItemRemarks itemRemarkByID(String id) {
		return remarkRepo.findById(id).get();
	}
	
	public List<ItemRemarks> searchRemarks(String statusID) {
		return remarkRepo.searchRemark(statusID);
	}
/*-----------------------------------------------------------------*/
	//Following has checklist methods
	
	public void saveChMasterData(VisualChecklistMaster vcm) {
		chMasterRepo.save(vcm);
	}
	
	public void saveChDetailData(VisualChecklistDetail abc) {
		chDetailRepo.save(abc);
	}
	
    public String maxCheckListMasterID() {
    	
    	if(chMasterRepo.maxCheckListMasterID()==null)
    		return "1";
    	else
    		return chMasterRepo.maxCheckListMasterID();
    }
    
	public  VisualChecklistMaster getLastRecord(String chMasterID){
		return (VisualChecklistMaster) chMasterRepo.getLastRecord(chMasterID);
	}
	
	public  List<VisualChecklistDetail> getAllData(String chMasterID){
		return chDetailRepo.getAllData(chMasterID);
	}
	
	public  List<VisualChecklistDetail> getCheckedData(String chMasterID){
		return chDetailRepo.getCheckedData(chMasterID);
	}
	
	public void update_Vi_test_status(String vRegID)
	{
		vehicleRegRepo.update_vi_test_status(vRegID);
	}
	public  List<VisualChecklistMaster> getAll(){
		return (List<VisualChecklistMaster>) chMasterRepo.getAll();
	}
	
	public String[][] getSummary(String proId) {
		return profileRepo.getSummary(proId);
	}
	
	public List<TestCategory> getTestCat() {
		return (List<TestCategory>) testCatRepo.findAll();
	}
	
	public String getProfileByCatID(String catID) {
		return testCatRepo.getVIProfileID(catID);
	}
	
	public List<ItemRemarks> getRemarks(String statusID) {
		return remarkRepo.searchRemark(statusID);
	}
	
	public  VisualChecklistMaster getChecklistMasterData(String regID){
		return (VisualChecklistMaster) chMasterRepo.getChecklistMasterData(regID);
	}
}