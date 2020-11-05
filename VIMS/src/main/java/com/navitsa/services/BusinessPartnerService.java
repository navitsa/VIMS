package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navitsa.entity.BusinessPartner;
import com.navitsa.repository.BusinessPartnerRepository;

@Service
public class BusinessPartnerService {

	@Autowired
	BusinessPartnerRepository partnerRepo;
	
	public String partnerMaxID() {
		if(partnerRepo.maxPartnerID() == null) {
			return "1";
		} else {
		return partnerRepo.maxPartnerID();
		}
	}
	
	public List<BusinessPartner> listPartners() {
		return (List<BusinessPartner>) partnerRepo.findAll();
	}
	
	public void savePartner(BusinessPartner bPartner) {
		partnerRepo.save(bPartner);
	}
	
	public BusinessPartner getPartnerId(String partner_ID) {
		BusinessPartner partner = partnerRepo.findById(partner_ID).get();
		return partner;
	}
	//setDefaultPartner
	public int setDefaultPartner(String partner_ID) {
		return partnerRepo.setPartner(partner_ID);
	}
	
	public BusinessPartner getDefaultPartner() {
		
		return partnerRepo.getDefaultPartner();
		
	}
	public int setUpdateLastRecNo(String partner_ID) {
		return partnerRepo.setUpdateLastRecNo(partner_ID);
		
	}
	public int setUpdateLastInvNo(String partner_ID) {
		return partnerRepo.setUpdateLastInvNo(partner_ID);
		
	}
	
	public int setUpdateLastinRecNo(String partner_ID) {
		return partnerRepo.setUpdateLastinRecNo(partner_ID);
		
	}
	
	public int setUpdateLastPaymentVoucherNo(String partner_ID) {
		return partnerRepo.setUpdateLastPaymentVoucherNo(partner_ID);
		
	}
}
