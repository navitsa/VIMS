package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.ConfigSystem;
import com.navitsa.entity.TestValueFileDetail;
import com.navitsa.entity.TestValueFileHeader;
import com.navitsa.repository.ConfigSystemRepository;
import com.navitsa.repository.FtpServerInfoEsoutRepository;
import com.navitsa.repository.TestValueFileDetailRepository;
import com.navitsa.repository.TestValueFileHeaderRepository;





@Service
@Transactional
public class TestValueFileService {

	@Autowired
	TestValueFileDetailRepository testValueDetailRepo;
	@Autowired
	TestValueFileHeaderRepository testValueFileHeaderRepo;
	@Autowired
	FtpServerInfoEsoutRepository ftpServerInfoEsoutRepo;
	@Autowired
	ConfigSystemRepository configSystemRepo;
	
	public void saveDetails(TestValueFileDetail objDetail) {
		testValueDetailRepo.save(objDetail);
	}
	
	public void saveTestValueHead(TestValueFileHeader testValueFileHeader) {
		testValueFileHeaderRepo.save(testValueFileHeader);
	}
	
	public List<TestValueFileHeader> listHeaderInfo() {
		return (List<TestValueFileHeader>) testValueFileHeaderRepo.findAll();
	}
	
	public void saveAllDetail(List<TestValueFileDetail> testResultList) {
		testValueDetailRepo.saveAll(testResultList);
	}

    public String getMaxHeaderID() {
    	
    	if(testValueFileHeaderRepo.getMaxHeaderID()==null)
    		return "1";
    	else
    		return testValueFileHeaderRepo.getMaxHeaderID();
    }
    
	public List<TestValueFileHeader> listPendingHeaderInfo() {
		return testValueFileHeaderRepo.getPendingReports();
	}
    
	public int update_status(String register_id)
	{
		return testValueFileHeaderRepo.update_status(register_id);
	}
	
	public List<TestValueFileHeader> listCompletedHeaderInfo() {
		return testValueFileHeaderRepo.getCompletedReports();
	}

	public List<ConfigSystem> getFTPServerInfo(String center_id,String type) {
		return configSystemRepo.getFTPServerInfo(center_id,type);
	}

}
