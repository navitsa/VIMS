package com.navitsa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.EmissionCodeMapping;
import com.navitsa.entity.EmissionDieselCertificateData;
import com.navitsa.entity.EmissionDieselCertificateReadings;
import com.navitsa.entity.EmissionPetrolCertificateData;
import com.navitsa.entity.EmissionPetrolCertificateGas;
import com.navitsa.entity.EmissionPetrolCertificateLembda;
import com.navitsa.entity.EmissionPetrolCertificatePetrol;
import com.navitsa.entity.ParameterCodes;
import com.navitsa.entity.TestLimitRule;
import com.navitsa.entity.TestParameter;
import com.navitsa.entity.TestParameterAngle;
import com.navitsa.entity.TestParameterCategory;
import com.navitsa.entity.TestPoint;
import com.navitsa.entity.TestProfile;
import com.navitsa.entity.TestProfileDetail;
import com.navitsa.repository.EmissionCodeMappingRepository;
import com.navitsa.repository.EmissionDieselCertificateDataRepo;
import com.navitsa.repository.EmissionDieselCertificateReadingsRepo;
import com.navitsa.repository.EmissionPetrolCertificateDataRepo;
import com.navitsa.repository.EmissionPetrolCertificateGasRepo;
import com.navitsa.repository.EmissionPetrolCertificateLembdaRepo;
import com.navitsa.repository.EmissionPetrolCertificatePetrolRepo;
import com.navitsa.repository.ParameterCodesRepository;
import com.navitsa.repository.TestLimitRuleRepository;
import com.navitsa.repository.TestParameterAngleRepository;
import com.navitsa.repository.TestParameterCategoryRepository;
import com.navitsa.repository.TestParameterRepository;
import com.navitsa.repository.TestPointRepository;
import com.navitsa.repository.TestProfileDetailRepository;
import com.navitsa.repository.TestProfileRepository;

@Service
@Transactional
public class TestReportConfigService {

	@Autowired
	TestParameterRepository tpRepo;

	@Autowired
	TestProfileRepository tproRepo;

	@Autowired
	TestProfileDetailRepository tproDetailRepo;

	@Autowired
	TestParameterCategoryRepository tpCategoryRepo;

	@Autowired
	TestPointRepository testPointRepo;

	@Autowired
	TestParameterAngleRepository paraAngleRepo;

	@Autowired
	ParameterCodesRepository paraCodesRepo;

	@Autowired
	EmissionDieselCertificateDataRepo emissionDieselCerDataRepo;

	@Autowired
	EmissionDieselCertificateReadingsRepo emissionDieselCerReadingsRepo;

	@Autowired
	EmissionPetrolCertificateDataRepo emPetrolCDataRepo;

	@Autowired
	EmissionPetrolCertificateGasRepo emPetrolCGasRepo;

	@Autowired
	EmissionPetrolCertificateLembdaRepo emPetrolCLambdaRepo;

	@Autowired
	EmissionPetrolCertificatePetrolRepo emPetrolCPetrolRepo;

	@Autowired
	EmissionCodeMappingRepository emissionCodeMappingRepo;

	@Autowired
	TestLimitRuleRepository testLimitRuleRepo;

	public void saveParameters(TestParameter tp) {
		tpRepo.save(tp);
	}

	public List<TestParameter> listAll() {
		return (List<TestParameter>) tpRepo.findAll();
	}

	public List<TestParameter> get_para_by_test_type_id(String typeID) {
		return tpRepo.findAllById(typeID);
	}

	public void saveTestProfile(TestProfile tp) {
		tproRepo.save(tp);
	}

	public String maxTestProfileID() {

		if (tproRepo.maxTestProfileID() == null)
			return "1";
		else
			return tproRepo.maxTestProfileID();
	}

	public List<TestProfile> listAllProfiles() {
		return (List<TestProfile>) tproRepo.findAll();
	}

	public void saveTestProfileDetial(TestProfileDetail test_pro_detail) {
		tproDetailRepo.save(test_pro_detail);
	}

	public String[][] getTestResult(int test_pro_id, String test_value_file_id, String vehicle_cat_id, int rule) {

		return tproDetailRepo.getTestResult(test_pro_id, test_value_file_id, vehicle_cat_id, rule);
	}

	public List<TestParameterCategory> getAllTestParaCat() {
		return (List<TestParameterCategory>) tpCategoryRepo.findAll();
	}

	public List<TestPoint> listAllTestPoints() {
		return (List<TestPoint>) testPointRepo.findAll();
	}

	public List<TestParameterAngle> listAllTestParameterAngles() {
		return (List<TestParameterAngle>) paraAngleRepo.findAll();
	}

//	public List<TestPoint> getTestPointsByTestTypeID(String typeID) {
//		return testPointRepo.findAllByTestTypeID(typeID);
//	}

	public List<TestParameterAngle> getTestAnglesByTestPara(String paraID) {
		return paraAngleRepo.findAllByTestParaID(paraID);
	}

//	public List<ParameterCodes> getTestCodes(String typeID, String pointID, String paraID) {
//		
//		return paraCodesRepo.getTestCodes(typeID,pointID,paraID);
//	}

//	public List<ParameterCodes> getTestCodes2(String typeID, String pointID, String paraID, String angleID) {
//		
//		return paraCodesRepo.getTestCodes2(typeID,pointID,paraID,angleID);
//	}

//	public void setLimitValues(String operator,Double limitValue,Double minValue,Double maxValue,String code) {
//		paraCodesRepo.setLimitValues(operator,limitValue,minValue,maxValue,code);
//	}

	public List<ParameterCodes> getAllCodes() {
		// TODO Auto-generated method stub
		return (List<ParameterCodes>) paraCodesRepo.findAll();
	}

//	public List<ParameterCodes> getTestCodes3(String typeID, String pointID) {
//		return paraCodesRepo.getTestCodes3(typeID,pointID);
//	}

	/*
	 * public ParameterCodes getData(String code) { // TODO Auto-generated method
	 * stub return paraCodesRepo.findById(code).get(); }
	 * 
	 * public Optional<ParameterCodes> getDataByCode(String code) { // TODO
	 * Auto-generated method stub return paraCodesRepo.findById(code); }
	 */

	public void saveParaCode(ParameterCodes pc) {
		// TODO Auto-generated method stub
		paraCodesRepo.save(pc);
	}

	public void saveEmissionDieselCertificateData(EmissionDieselCertificateData obj) {
		// TODO Auto-generated method stub
		emissionDieselCerDataRepo.save(obj);

	}

	public void saveEmissionDieselCertificateReadings(EmissionDieselCertificateReadings obj) {
		// TODO Auto-generated method stub
		emissionDieselCerReadingsRepo.save(obj);
	}

	public EmissionDieselCertificateData getEmiDieselCerData(String register_id) {
		// TODO Auto-generated method stub
		return (EmissionDieselCertificateData) emissionDieselCerDataRepo.getEmiDieselCerData(register_id);
	}

	public List<EmissionDieselCertificateReadings> getEmiDieselCerReadings(String id_no) {
		// TODO Auto-generated method stub
		return emissionDieselCerReadingsRepo.getEmiDieselCerReadings(id_no);
	}

	public void saveEmissionPetrolCertificateData(EmissionPetrolCertificateData obj) {
		// TODO Auto-generated method stub
		emPetrolCDataRepo.save(obj);
	}

	public void saveEmissionPetrolCertificateGas(EmissionPetrolCertificateGas obj) {
		// TODO Auto-generated method stub
		emPetrolCGasRepo.save(obj);
	}

	public void saveEmissionPetrolCertificateLambda(EmissionPetrolCertificateLembda obj) {
		// TODO Auto-generated method stub
		emPetrolCLambdaRepo.save(obj);
	}

	public void saveEmissionPetrolCertificatePetrol(EmissionPetrolCertificatePetrol obj) {
		// TODO Auto-generated method stub
		emPetrolCPetrolRepo.save(obj);
	}

	public EmissionPetrolCertificateData getEmiPetrolCerData(String register_id) {
		// TODO Auto-generated method stub
		return (EmissionPetrolCertificateData) emPetrolCDataRepo.getValuesByRegisterID(register_id);
	}

	public EmissionPetrolCertificateGas getEmiPetrolCerGas(String id_no) {
		// TODO Auto-generated method stub
		return emPetrolCGasRepo.getEmiPetrolCerGas(id_no);
	}

	public EmissionPetrolCertificateLembda getEmiPetrolCerLambda(String id_no) {
		// TODO Auto-generated method stub
		return emPetrolCLambdaRepo.getEmiPetrolCerLambda(id_no);
	}

	public EmissionPetrolCertificatePetrol getEmiPetrolCerPetrol(String id_no) {
		return emPetrolCPetrolRepo.getEmiPetrolCerPetrol(id_no);
	}

	public TestProfile getTestProfileInfo(int proId) {
		return tproRepo.findById(proId).get();
	}

	public void insertIntoEDCData(String vehicleID, String regId) {
		emissionDieselCerDataRepo.insertIntoEDCData(vehicleID, regId);
	}

	public void insertIntoEDCReadings(int id_no) {
		emissionDieselCerReadingsRepo.insertIntoEDCReadings(id_no);
	}

	public void insertIntoEPCData(String vehicleID, String regId) {
		emPetrolCDataRepo.insertIntoEPCData(vehicleID, regId);

	}

	public void insertIntoEPCGas(int id_no) {
		// TODO Auto-generated method stub
		emPetrolCGasRepo.insertIntoEPCGas(id_no);
	}

	public void insertIntoEPCLambda(int id_no) {
		// TODO Auto-generated method stub
		emPetrolCLambdaRepo.insertIntoEPCLambda(id_no);
	}

	public void insertIntoEPCPetrol(int id_no) {
		// TODO Auto-generated method stub
		emPetrolCPetrolRepo.insertIntoEPCPetrol(id_no);
	}

	public int getEPCDataID(String regId) {
		return emPetrolCDataRepo.getEPCDataID(regId);
	}

	public int getEDCDataID(String regId) {
		return emissionDieselCerDataRepo.getEDCDataID(regId);
	}

	public String[][] getSpeedoTestResult(int test_pro_id, String test_value_file_id, String vehicle_cat_id) {

		return tproDetailRepo.getSpeedoTestResult(test_pro_id, test_value_file_id, vehicle_cat_id);
	}

	public String[][] getMaxSpeedResult(int test_pro_id, String test_value_file_id, String vehicle_cat_id,
			String vehicle_sub_cat_id) {

		return tproDetailRepo.getMaxSpeedResult(test_pro_id, test_value_file_id, vehicle_cat_id, vehicle_sub_cat_id);
	}

	public List<EmissionCodeMapping> findAllCodeMapping(String testType) {
		return (List<EmissionCodeMapping>) emissionCodeMappingRepo.findAllByTestType(testType);
	}

	public String find_edt_id(String vehicleID) {
		return emissionCodeMappingRepo.find_edt_id(vehicleID);
	}

	public String find_edt_data(String columnName, int id_no) {
		return emissionCodeMappingRepo.find_edt_data(columnName, id_no);

	}

	public String find_ept_id(String vehicleID) {
		return emissionCodeMappingRepo.find_ept_id(vehicleID);
	}

	public String find_ept_petrol(String tableName, String columnName, int id_no) {
		return emissionCodeMappingRepo.find_ept_petrol(tableName, columnName, id_no);

	}

	public int getRuleCode(String emissionNorms) {
		return testLimitRuleRepo.getRuleCode(emissionNorms);
		
	}

//	public TestLimitRule findRuleByYear(String year,String fuelID,String vehicleCatTypeID,String stroke) {
//		return testLimitRuleRepo.findRuleByYear(year,fuelID,vehicleCatTypeID,stroke);
//	}

}
