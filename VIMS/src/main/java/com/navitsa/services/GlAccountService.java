package com.navitsa.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.DocType;
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

	public List<GlaccountMapping> getGlaccountMappingByDocId(int docid) {
		return glaccountMappingRepository.getGlaccountMappingByDocId(docid);

	}

	public GlPostingHead saveGlPostingHeadRepository(GlPostingHead glPostingHead) {
		return glPostingHeadRepository.save(glPostingHead);
	}

	public void saveAllGlPostingDetailsRepository(List<GlPostingDetails> glPostingDetails) {
		glPostingDetailsRepository.saveAll(glPostingDetails);
	}

	public String[][] getGlPostingDateByDate(String fromdate, String todate, String centerid) {

		return glPostingDetailsRepository.getGlPostingDateByDate(fromdate, todate, centerid);
	}

	public String[][] getProfitsAndLossData(String todate, String centerid) {

		return glPostingDetailsRepository.getProfitsAndLossData(todate, centerid);

	}

	public List<Glaccount> findAll() {
		// TODO Auto-generated method stub
		return (List<Glaccount>) glaccountRepository.findAll();
	}

	public String[][] getGlPostingDateByGlaccno(String fromdate, String todate, String glaccno, String centerid) {

		return glPostingDetailsRepository.getGlPostingDateByGlaccno(fromdate, todate, glaccno, centerid);

	}

	public DocType getDocTypeById(Integer docTypeId) {
		return docTypeRepository.findById(docTypeId).get();
	}

	public Glaccount getGlaccountById(String id) {
		return glaccountRepository.findById(id).get();
	}

	public void saveDocType(DocType docType) {
		docTypeRepository.save(docType);
	}

	public List<DocType> getDocumentList() {
		return (List<DocType>) docTypeRepository.findAll();
	}

	public List<GlPostingHead> getGLPostingHeadsByDocId(int docId) {
		return glPostingHeadRepository.getGLPostingHeadsByDocId(docId);
	}

	public GlPostingHead getGlPostingHeadByDocNo(String docNo) {
		return glPostingHeadRepository.getGlPostingHeadByDocNo(docNo);
	}

	public List<GlPostingDetails> getGlPostingDetailsByJournalNo(int journalNo) {
		return glPostingDetailsRepository.getGlPostingDetailsByJournalNo(journalNo);
	}

	public List<GlaccountMapping> getGLMappingList() {
		return (List<GlaccountMapping>) glaccountMappingRepository.findAll();
	}

	public GlaccountMapping saveGLAccountMapping(@Valid GlaccountMapping glAccountMapping) {
		return glaccountMappingRepository.save(glAccountMapping);
	}

	public GlaccountMapping getGLAccountMappingById(int id) {
		return glaccountMappingRepository.findById(id).get();
	}
}