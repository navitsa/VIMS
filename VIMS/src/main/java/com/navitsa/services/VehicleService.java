package com.navitsa.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.BusinessPartner;
import com.navitsa.entity.CenterMaster;
import com.navitsa.entity.ConfigSystem;
import com.navitsa.entity.FuelType;
import com.navitsa.entity.IncomingReceiptDetails;
import com.navitsa.entity.IncomingReceiptHead;
import com.navitsa.entity.InvoiceDetails;
import com.navitsa.entity.InvoiceHead;
import com.navitsa.entity.OcrDetails;
import com.navitsa.entity.ReceiptDetails;
import com.navitsa.entity.ReceiptHead;
import com.navitsa.entity.TaxConfiguration;
import com.navitsa.entity.TestLane;
import com.navitsa.entity.TestLaneDetails;
import com.navitsa.entity.Transaction;
import com.navitsa.entity.Users;
import com.navitsa.entity.VehicalWmi;
import com.navitsa.entity.VehicleCategory;
import com.navitsa.entity.VehicleClass;
import com.navitsa.entity.VehicleMake;
import com.navitsa.entity.VehicleMaster;
import com.navitsa.entity.VehicleModel;
import com.navitsa.entity.VehicleOwner;
import com.navitsa.entity.VehicleRegisterType;
import com.navitsa.entity.VehicleRegistration;
import com.navitsa.entity.VehiclesSubCategory;
import com.navitsa.repository.BusinessPartnerRepository;
import com.navitsa.repository.CenterMasterRepository;
import com.navitsa.repository.ConfigSystemRepository;
import com.navitsa.repository.FuelTypeRepository;
import com.navitsa.repository.IncomingReceiptDetailsRepository;
import com.navitsa.repository.IncomingReceiptHeadRepository;
import com.navitsa.repository.InvoiceDetailsRepository;
import com.navitsa.repository.InvoiceHeadRepository;
import com.navitsa.repository.OcrDetailsRepository;
import com.navitsa.repository.ReceiptDetailsRepository;
import com.navitsa.repository.ReceiptHeadRepository;
import com.navitsa.repository.TaxConfigurationRepository;
import com.navitsa.repository.TestLaneDetailsRepository;
import com.navitsa.repository.TestLaneRepository;
import com.navitsa.repository.TransactionRepository;
import com.navitsa.repository.UsersRepository;
import com.navitsa.repository.VehicalWmiRepository;
import com.navitsa.repository.VehicleCategoryRepository;
import com.navitsa.repository.VehicleMasterRepository;
import com.navitsa.repository.VehicleModelRepository;
import com.navitsa.repository.VehicleOwnerRepository;
import com.navitsa.repository.VehicleRegisterTypeRepository;
import com.navitsa.repository.VehicleRegistrationRepository;
import com.navitsa.repository.VehiclesSubCategoryRepository;
import com.navitsa.repository.vehicleClassRepository;
import com.navitsa.repository.vehicleMakeRepository;

@Service
@Transactional
public class VehicleService {
	@Autowired
	vehicleMakeRepository repo;

	@Autowired
	VehicleModelRepository modelRepo;

	@Autowired
	VehicleRegisterTypeRepository vRegTypeRepo;

	@Autowired
	vehicleClassRepository classRepo;

	@Autowired
	FuelTypeRepository fuelRepo;

	@Autowired
	VehicleMasterRepository masterRepo;

	@Autowired
	VehicleOwnerRepository ownerRepo;
	
	@Autowired
	VehicleRegistrationRepository vehicleregRepo;
	
	@Autowired
	TransactionRepository transactionRepo;
	
	@Autowired
	UsersRepository userRepo;
	
	@Autowired
	CenterMasterRepository centerRepo;
	
	@Autowired
	BusinessPartnerRepository partnerRepo;
	
	@Autowired
	TestLaneRepository testlaneRepo;
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	TestLaneDetailsRepository testlaneDetailsRepo1;
	
	@Autowired
	TaxConfigurationRepository taxConfigurationRepository;
	
	@Autowired
	ReceiptHeadRepository receiptHeadRepository;
	
	@Autowired
	ReceiptDetailsRepository receiptDetailsRepository;
	
	@Autowired
	VehicleCategoryRepository vehicleCategoryRepo;
	
	@Autowired
	VehicalWmiRepository vehicalWmiRepo;
	
	@Autowired
	OcrDetailsRepository ocrDetailsRepo;
	
	
	@Autowired
	InvoiceHeadRepository invoiceHeadRepo;
	
	@Autowired
	InvoiceDetailsRepository invoiceDetailsRepo;
	
	@Autowired
	IncomingReceiptDetailsRepository incomingReceiptDetailsRepo;
	
	@Autowired
	IncomingReceiptHeadRepository incomingReceiptHeadRepo;
	
	@Autowired
	ConfigSystemRepository configSystemRepo;
	
	@Autowired
	private VehiclesSubCategoryRepository vehiclesSubCategoryRepository;
	
	
	public List<VehicleMake> getMakelistAll() {
		return (List<VehicleMake>) repo.findAll();

	}
	public List<VehicleMake> getActiveMakes() {
		return (List<VehicleMake>) repo.getActiveMakes();

	}
	public String maxModelID() {
		if (modelRepo.maxModelID() == null) {
			return "1";
		} else {

			return modelRepo.maxModelID();
		}

	}
	//getting vehicle make logo by make id 
	public VehicleMake searchlogomake(String vmake) {
		return repo.searchlogo(vmake);
	}
	
	public void saveVModel(VehicleModel vModel) {
		modelRepo.save(vModel);
	}
	public List<VehicleModel> getVModel() {
		return (List<VehicleModel>) modelRepo.findAll();
	}
	public VehicleModel getVmodelDetailsByID(String vehicleModelID) {
		return modelRepo.findById(vehicleModelID).get();
	}
	
	// save vType
	public void saveVRegType(VehicleRegisterType vRegType) {
		vRegTypeRepo.save(vRegType);
	}

	// getAll vTypes
	public List<VehicleRegisterType> getAllVType() {
		return (List<VehicleRegisterType>) vRegTypeRepo.findAll();
	}

	// get reg type
	public VehicleRegisterType getRegType(String id) {
		return vRegTypeRepo.findById(id).get();
	}

	// delete v reg type
	public void deleteVRegType(String id) {
		vRegTypeRepo.deleteById(id);
	}

	public String maxTypeID() {
		if(vRegTypeRepo.maxVRegTypeID() == null) {
			return "1";
		} else {
			
		return vRegTypeRepo.maxVRegTypeID();
		}
	}
	

	public VehicleRegisterType update(VehicleRegisterType vRType) {
		return vRegTypeRepo.save(vRType);
	}

	public void saveVClass(VehicleClass vClass) {
		classRepo.save(vClass);
	}

	public List<VehicleClass> getVClass() {
		return (List<VehicleClass>) classRepo.findAll();
	}
	
	public String maxVClassID() {
		if(classRepo.maxClassID() == null) {
			return "1";
		} else {
		return classRepo.maxClassID();
	
		}
	}
	public void saveVMake(VehicleMake vMake) {
		repo.save(vMake);
	}

	public VehicleClass getVClassById(String id) {
		return classRepo.findById(id).get();
	}

	public VehicleMake getVMakeById(String id) {
		return repo.findById(id).get();
	}

	public List<FuelType> getFuelType() {
		return (List<FuelType>) fuelRepo.findAll();
	}

	public VehicleMaster saveVMaster(VehicleMaster vMaster) {
		return masterRepo.save(vMaster);
	}

	public List<VehicleMaster> getVehicleMasterAllDetail() {
		return (List<VehicleMaster>) masterRepo.findAll();

	}

	public String maxVehicleId() {
		return masterRepo.maxVehicleId();

	};

	public VehicleMaster getVMasterById(String id) {
		try {
			return masterRepo.findById(id).get();
		}catch(Exception e) {
			return null;
		}
	}

	public List<VehicleOwner> getVehicleOwnerlistAll() {
		return (List<VehicleOwner>) ownerRepo.findAll();

	}
	
	public void saveVehicleRegister(VehicleRegistration vreg) {
		vehicleregRepo.save(vreg);
	}
	public List <VehicleRegistration> listVehicleRegistration(){
		return(List<VehicleRegistration>) vehicleregRepo.findAll();
	}
	public List<Transaction> listTransaction(){
		return(List<Transaction>) transactionRepo.findAll();
	}
	
	public List <Users> userList(){
		return(List<Users>) userRepo.findAll();
	}
	
	public List<CenterMaster> centerMasterList(){
		return(List<CenterMaster>) centerRepo.findAll();
	}
	
	public List<BusinessPartner> businessPartnerList(){
		return (List<BusinessPartner>) partnerRepo.findAll();
	}
	public VehicleRegistration VehicleRegInfoByID(String vregID) {
		VehicleRegistration	res=vehicleregRepo.findById(vregID).get();
		return res;
	}
	 
	public List<TestLane> testlaneDetails(){
		return (List<TestLane>) testlaneRepo.findAll();
	}
	public TestLane testLaneDetailsGetByID (String laneId) {
		TestLane testlane = testlaneRepo.findById(laneId).get();
			return testlane;
	}
	//vehicle owner
	//get all ve owner details
		public List<VehicleOwner> getAll() {
			return (List<VehicleOwner>) ownerRepo.findAll();
		}
		
		//max veo id
		public String maxVOwnerID() {
			if(ownerRepo.maxVOwnerID() == null) {
				return "1";
			} else {
			return ownerRepo.maxVOwnerID();
		}
	}
		//save
		public void saveVOwner(VehicleOwner vOwner) {
			ownerRepo.save(vOwner);
		}
		public  VehicleOwner getVOwnerById(String id) {
			return ownerRepo.findById(id).get();
		}
		
		
		//set vid
		public List<VehicleMaster> findVId(String vehicleID) {
			return masterRepo.setVId(vehicleID);
		}
	
		public List<VehicleOwner> getVehicleOwnerByVehicleID(String vehicleID) {
			return ownerRepo.getVehicleOwnerByVehicleID(vehicleID);
		}
		
		//changeOwner
		public int updateOwnerStatus(String ownerID, String vehicleID) {
			return ownerRepo.updateOwnerStatus(ownerID,vehicleID);
		}
		
    public String maxVMakeID() {
    	
    	if(repo.maxVMakeID() == null)
    		
    		return "1";
    	else
    		return repo.maxVMakeID();
    }
    public String maxVRegID() {
		if(vehicleregRepo.maxVRegID() == null) {
			return "1";
		} else {
			
		return vehicleregRepo.maxVRegID();
		}
	}
//getTest lanes according to centers
    
    /*public  List<TestLane> searchlanestoCombo(String center) {
		return testlaneRepo.searchlanes(center);
	}*/
   
	public List<TestLaneDetails> searchLaneDEtails(String testLaneDetailsid) {
		
		return testlaneDetailsRepo1.searchLaneDetails(testLaneDetailsid);
	}
//getTest lanes according to centers
    
//    public  List<TestLane> searchlanestoCombo(String center) {
//		return testlaneRepo.searchlanes(center);
//	}
//    
	public List<VehicleModel> getModelByID(String makeID,String vehicleClassID) {
		return modelRepo.getModelByID(makeID,vehicleClassID);
	}
	public List<VehicleModel> getModelCheck(String makeID,String vehicleClassID,String modelname) {
		return modelRepo.getModelCheck(makeID,vehicleClassID,modelname);
	}

	public VehicleOwner getVehicleOwnerIDByVehicleID(String vehicleID) {
		return ownerRepo.getVehicleOwnerIDByVehicleID(vehicleID);
	}
	
	public List<VehicleOwner> getOwnersByVehicleNo(String vehicleNo){
		return ownerRepo.getOwnersByVehicleNo(vehicleNo);
	}
	
	public List<TaxConfiguration> getTaxFromCountry(String country){		
		return taxConfigurationRepository.getTaxFromCountry(country);
	}
	
	public void saveReciptHead(ReceiptHead receiptHead) {
		receiptHeadRepository.save(receiptHead);			
	}
	public void saveReciptDetailsAll(List<ReceiptDetails> receiptDetails) {
		receiptDetailsRepository.saveAll(receiptDetails);			
	}
	public ReceiptHead getReciptHedDetailByRecNo(String recno) {
		return receiptHeadRepository.findById(recno).get();			
	}	
	public List<ReceiptDetails> getReceiptDetails(String recNo){
		return receiptDetailsRepository.getReceiptDetails(recNo);
		
	}
	
	// following are test certificate methods
	
	public String getCategoryID(String register_id)
	{
		return vehicleregRepo.getCategoryID(register_id);
	}
	public VehicleRegistration getRegistraionInfo(String register_id)
	{
		return vehicleregRepo.findById(register_id).get();
	}
	
	public int update_test_status(String register_id)
	{
		return vehicleregRepo.update_test_status(register_id);
	}
	
	public String getRegistrationID(String vehicle_id)
	{
		return vehicleregRepo.getRegistrationID(vehicle_id);
	}
	public List<VehicleRegistration> getVechicalDetailByDate(String vRdate,String payTyp) {
		
		return vehicleregRepo.getVechicalDetailByDate(vRdate,payTyp);
	}
	public List<ReceiptHead> getReceiptHeadByVehicalRegID(String vRdate,String vecid,String payTyp){
		
		return receiptHeadRepository.getReceiptHeadByVehicalRegID(vRdate, vecid,payTyp);
	}
	public List<InvoiceHead> getInvoiceHeadByVehicalRegID(String vRdate,String vecid,String payTyp){
		
		return invoiceHeadRepo.getInvoiceHeadByVehicalRegID(vRdate, vecid,payTyp);
	}
	
	public List<VehicleCategory> getVehicleCategory(){
		
		return (List<VehicleCategory>) vehicleCategoryRepo.findAll();
		
	}
	public VehicleCategory getVehicleCategoryById(String classid){
		
		return vehicleCategoryRepo.findById(classid).get();
		
	}
		
	public VehicalWmi getVwmiid(@Param("wmiid")String wmiid){
		
		return vehicalWmiRepo.getVwmiid(wmiid);
	
	}
	
	public void saveOcrDetailsRepo(OcrDetails ocrDetails) {
		ocrDetailsRepo.save(ocrDetails);			
	}
	public int maxOcrDetailsID() {	
	
		if(ocrDetailsRepo.maxOcrDetailsID()==null) {
			return 1;
		} else {
			
		return Integer.parseInt(ocrDetailsRepo.maxOcrDetailsID());
		}	
		//return ocrDetailsRepo.maxOcrDetailsID();
		
	}
	public OcrDetails getOcrDetailsById(int id)
	{
		return ocrDetailsRepo.findById(id).get();
	}
	public List<VehicleMaster> checkVinNo(String vinno, String veNo){
		
		return  masterRepo.checkVinNo(vinno,veNo);
			
	}
	
	public List<VehicleMaster> checkEngNo(String engno, String veNo){
		
		return  masterRepo.checkEngNo(engno,veNo);
			
	}
	public List<VehicleRegistration> getPerviousRegistrationVehicle(String vehicle_no) {
		
		return  vehicleregRepo.getPerviousRegistrationVehicle(vehicle_no);
	}
	public List<VehicleRegistration> getTestStatusVehicleRegistation(String vehicleID){
		
		return  vehicleregRepo.getTestStatusVehicleRegistation(vehicleID);
		
	}
	
	public List<VehicleRegistration> getVehicleRegDetailByDate(String date,String centerid){
		
		return  vehicleregRepo.getVehicleRegDetailByDate(date,centerid);
		
	}
	
	public ReceiptHead getReceiptHeadDetailsByVRid(String vregid) {
		return receiptHeadRepository.getReceiptHeadDetailsByVRid(vregid);
		
	}
	public List<ReceiptHead> getReceiptHeadByDate(@Param("recDate") String recDate) {
		return receiptHeadRepository.getReceiptHeadByDate(recDate);
		
	}
	public void saveInvoiceHead(InvoiceHead invoiceHead) {
		invoiceHeadRepo.save(invoiceHead);			
	}
	public void saveInvoiceDetailsAll(List<InvoiceDetails> invoiceDetails) {
		invoiceDetailsRepo.saveAll(invoiceDetails);
	}
	public InvoiceHead getInvoiceHeadByInvNo(String invno) {
		return invoiceHeadRepo.findById(invno).get();			
	}	
	public List<InvoiceDetails> getInvoiceDetails(String recNo){
		return invoiceDetailsRepo.getInvoiceDetails(recNo);
		
	}
	public int setCancelReceipt(String recNo) {
		return receiptHeadRepository.setCancelReceipt(recNo);
		
	}
	public int setCancelInvoice(String invNo) {
		return invoiceHeadRepo.setCancelInvoice(invNo);
		
	}
	public List<InvoiceHead> getInvoiceHeadDetailBytwoDate(String fromdate,String todate){
		return invoiceHeadRepo.getInvoiceHeadDetailBytwoDate(fromdate,todate);
	}
	public List<InvoiceHead> getIncomingPaymentDetails(String cusid){
		return invoiceHeadRepo.getIncomingPaymentDetails(cusid);
	}
	
	public void saveIncomingReceiptHead(IncomingReceiptHead incomingReceiptHead){
		 incomingReceiptHeadRepo.save(incomingReceiptHead);
	}
	
	public void saveAllIncomingReceiptDetails(List<IncomingReceiptDetails> incomingReceiptDetails){
		 incomingReceiptDetailsRepo.saveAll(incomingReceiptDetails);
	}
	public void saveAllInvoiceHead(List<InvoiceHead> invoiceHead) {
		invoiceHeadRepo.saveAll(invoiceHead);			
	}
	public IncomingReceiptHead getIncomingReceiptHeadbyInvoiceNo(String incRecId) {
		return incomingReceiptHeadRepo.findById(incRecId).get();			
	}
	public List<IncomingReceiptDetails> getIncomingReceiptDetailsbyInvoiceNo(String incRecId) {
		return incomingReceiptDetailsRepo.getIncomingReceiptDetailsbyInvoiceNo(incRecId);			
	}
	public List<IncomingReceiptHead> getIncomingReceiptNoByDate(String vRdate){
		return incomingReceiptHeadRepo.getIncomingReceiptNoByDate(vRdate);
	}
	
	public List<IncomingReceiptHead> getIncomingReceiptHeadBytwoDate(String fromdate,String todate){
		return incomingReceiptHeadRepo.getIncomingReceiptHeadBytwoDate(fromdate,todate);
	}
	public List<InvoiceHead> getAllActiveInvoiceHead(){	
		return invoiceHeadRepo.getAllActiveInvoiceHead();
	}
	public List<ConfigSystem> getConfigSystemByCenter(String centerid,String lanehId){	
		return configSystemRepo.getConfigSystemByCenter(centerid,lanehId);
	}
	public int setVmAndVrStatus(String vmStatus,String vrStatus,String docStatus,String ocrid) {
		return ocrDetailsRepo.setVmAndVrStatus(vmStatus,vrStatus,docStatus,ocrid);

	}
	public List<OcrDetails> pendingOcrStatusDetails(String vmStatus,String vrStatus,String docStatus){
		return ocrDetailsRepo.pendingOcrStatusDetails(vmStatus,vrStatus,docStatus);		
	}
	public List<OcrDetails> pendingOcrDetails(){
		return ocrDetailsRepo.pendingOcrDetails();		
	}
	
	public void updateVehicleMaster(String engineNo, String chassisNo, String mYear, String rYear,
			String engineC, String noOfWheel, String emisNorms, String modelID,String fuelID, String vehicleNo) {
		masterRepo.updateVehicleMaster(engineNo, chassisNo, mYear, rYear, engineC, noOfWheel, emisNorms, modelID, fuelID, vehicleNo);
		
	}
	public List<VehiclesSubCategory> vehiclesSubCategorylist(){
		return (List<VehiclesSubCategory>)vehiclesSubCategoryRepository.findAll();
	}
	public List<OcrDetails> getOCRVehiclesByDates(@Param("todayDate")String todayDate){
		return ocrDetailsRepo.getOCRVehiclesByDates(todayDate);	
	}
	public VehicleRegistration getRegistrationVehicleByOcrid(int ocrid) {
		
		return vehicleregRepo.getRegistrationVehicleByOcrid(ocrid);
	}
	public VehicleRegistration getRegistrationByRegisterId(String ocrid) {
		
		return vehicleregRepo.getRegistrationByRegisterId(Integer.parseInt(ocrid));
	}
	public List<OcrDetails> pendingLaneEntryData(){
		return ocrDetailsRepo.pendingLaneEntryData();
		
	}

	
}


