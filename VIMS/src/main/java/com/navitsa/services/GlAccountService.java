package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.GlPostingDetails;
import com.navitsa.entity.GlPostingHead;
import com.navitsa.entity.Glaccount;
import com.navitsa.entity.GlaccountMapping;
import com.navitsa.repository.DocTypeRepository;
import com.navitsa.repository.GlPostingDetailsRepository;
import com.navitsa.repository.GlPostingHeadRepository;
import com.navitsa.repository.GlaccountMappingRepository;
import com.navitsa.repository.GlaccountRepository;


@Service
@Transactional
public class GlAccountService {

	@Autowired
	GlaccountRepository glaccountRepository;
	@Autowired
	DocTypeRepository docTypeRepository;
	@Autowired
	GlaccountMappingRepository glaccountMappingRepository;
	@Autowired
	GlPostingHeadRepository glPostingHeadRepository;
	@Autowired
	GlPostingDetailsRepository glPostingDetailsRepository;
	
	
	public List<GlaccountMapping> getGlaccountMappingByDocId(int docid){
		return glaccountMappingRepository.getGlaccountMappingByDocId(docid);
		
	}
	
	public GlPostingHead saveGlPostingHeadRepository(GlPostingHead glPostingHead) {
		return glPostingHeadRepository.save(glPostingHead);
	}
	
	public void saveAllGlPostingDetailsRepository(List<GlPostingDetails> glPostingDetails) {
		glPostingDetailsRepository.saveAll(glPostingDetails);
	}
	public String[][] getGlPostingDateByDate(String fromdate,String todate,String centerid){
		
		return glPostingDetailsRepository.getGlPostingDateByDate(fromdate,todate,centerid);
	}
	public String[][] getProfitsAndLossData(String todate,String centerid){
		
		return glPostingDetailsRepository.getProfitsAndLossData(todate,centerid);
		
	}

	public List<Glaccount> findAll() {
		// TODO Auto-generated method stub
		return (List<Glaccount>) glaccountRepository.findAll();
	}
}
