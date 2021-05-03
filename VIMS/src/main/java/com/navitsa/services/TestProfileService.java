package com.navitsa.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.ParameterCodes;
import com.navitsa.entity.TestLimitRule;
import com.navitsa.entity.TestParameter;
import com.navitsa.entity.TestParameterAngle;
import com.navitsa.entity.TestPoint;
import com.navitsa.entity.TestProfile;
import com.navitsa.entity.TestProfileDetail;
import com.navitsa.entity.TestProfileStatus;
import com.navitsa.entity.TestWisePrintOrder;
import com.navitsa.repository.ParameterCodesRepository;
import com.navitsa.repository.TestLimitRuleRepository;
import com.navitsa.repository.TestParameterAngleRepository;
import com.navitsa.repository.TestParameterRepository;
import com.navitsa.repository.TestPointRepository;
import com.navitsa.repository.TestProfileDetailRepository;
import com.navitsa.repository.TestProfileRepository;
import com.navitsa.repository.TestProfileStatusRepository;
import com.navitsa.repository.TestWisePrintOrderRepository;

@Service
@Transactional
public class TestProfileService {

	@Autowired
	TestPointRepository testPointRepo;
	
	@Autowired
	TestParameterRepository testParaRepo;
	
	@Autowired
	TestParameterAngleRepository paraAngleRepo;
	
	@Autowired
	ParameterCodesRepository paraCodesRepo;
	
	@Autowired
	TestProfileRepository tproRepo;
	
	@Autowired
	TestProfileDetailRepository tproDetailRepo;
	
	@Autowired
	TestProfileStatusRepository tproStatusRepo;
	
	@Autowired
	TestLimitRuleRepository testLimitRuleRepo;
	
	@Autowired
	TestWisePrintOrderRepository testWisePrintOrderRepo;
	

	public void save(TestPoint obj) {
		// TODO Auto-generated method stub
		testPointRepo.save(obj);
	}
	
    public String maxTestPointID(String typeID) {
    	
    	if(testPointRepo.maxTestPointID(typeID)==null)
    		return null;
    	else
    		return testPointRepo.maxTestPointID(typeID);
    }
    
	public void saveParameter(TestParameter tp) {
		testParaRepo.save(tp);
	}

    public String maxTestParaID(String typeID) {
    	
    	if(testParaRepo.maxTestParaID(typeID)==null)
    		return null;
    	else
    		return testParaRepo.maxTestParaID(typeID);
    }
    
	public List<TestParameter> listAll() {
		return (List<TestParameter>) testParaRepo.findAll();
	}
	
    public String maxAngleID(String paraID) {
    	
    	if(paraAngleRepo.maxAngleID(paraID)==null)
    		return null;
    	else
    		return paraAngleRepo.maxAngleID(paraID);
    }

	public void saveAngle(TestParameterAngle obj) {
		// TODO Auto-generated method stub
		paraAngleRepo.save(obj);
	}

	public List<TestProfile> listAllProfiles() {
		// TODO Auto-generated method stub
		return (List<TestProfile>) tproRepo.findAll();
	}
	
	public List<TestProfileDetail> listAllProfileDetails() {
		// TODO Auto-generated method stub
		return (List<TestProfileDetail>) tproDetailRepo.findAll();
	}
	public List<TestProfileDetail> listAllProfileDetailsByProfileId(int profile_id) {
		return (List<TestProfileDetail>) tproDetailRepo.findByProfileId(profile_id);
	}

	public List<TestProfileStatus> getAllTestProfileStatus() {
		// TODO Auto-generated method stub
		return  (List<TestProfileStatus>) tproStatusRepo.getAll();
	}

	public void saveTestProStatus(TestProfileStatus testProStatus) {
		tproStatusRepo.save(testProStatus);
		
	}

	public TestProfileStatus findBy(int pro_id, String type_id) {
		return tproStatusRepo.findBy(pro_id,type_id);	 
	}

	public void updateRecord(int s_id,int status) {
		tproStatusRepo.updateRecord(s_id,status);
		
	}

	public List<ParameterCodes> getAllCodes() {
		// TODO Auto-generated method stub
		return (List<ParameterCodes>) paraCodesRepo.findAll();
	}

	public List<ParameterCodes> getTestCodes4(String typeID) {
		return paraCodesRepo.getTestCodes4(typeID);
	}

	public void saveTestProDetail(TestProfileDetail tpd) {
		tproDetailRepo.save(tpd);
		
	}
	public List<TestPoint> listAllTestPoints() {
		return (List<TestPoint>) testPointRepo.findAll();
	}
	public List<TestParameterAngle> listAllTestParameterAngles() {
		return (List<TestParameterAngle>) paraAngleRepo.findAll();
	}
	
	public List<TestPoint> getTestPointsByTestTypeID(String typeID) {
		return testPointRepo.findAllByTestTypeID(typeID);
	}
	
	public List<TestLimitRule> findAllRules() {
		return (List<TestLimitRule>) testLimitRuleRepo.findAll();
	}

	public List<TestWisePrintOrder> getAllTestWisePrintOrder() {
		return (List<TestWisePrintOrder>) testWisePrintOrderRepo.findAll();
	}

	public void saveTestWisePrintOrder(List<TestWisePrintOrder> ls) {
		testWisePrintOrderRepo.saveAll(ls);		
	}

	public String[] getPrintingOrder(int test_pro_id) {
		return testWisePrintOrderRepo.getPrintingOrder(test_pro_id);
		
	}

    public String nextTestLimitRuleId() {
    	
    	if(testLimitRuleRepo.nextTestLimitRuleId()==null)
    		return "1";
    	else
    		return testLimitRuleRepo.nextTestLimitRuleId();
    }
    
	public void saveTestLimitRule(TestLimitRule rule) {
		testLimitRuleRepo.save(rule);
	}

	public Optional<TestLimitRule> findRuleById(int ruleCode) {
		return testLimitRuleRepo.findById(ruleCode);
	}
}
