package com.navitsa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.BusinessPartner;

public interface BusinessPartnerRepository extends CrudRepository<BusinessPartner , String> {

	@Query(value = "SELECT (max(p.partner_ID)+1) FROM BusinessPartner p ")
	public String maxPartnerID();
	
	@Transactional
	@Modifying
	@Query(value="UPDATE BusinessPartner bp SET bp.defaultPartner = 'Inactive' WHERE bp.partner_ID !=:partner_ID")
	public int setPartner(@Param("partner_ID")String partner_ID);
	
	@Query(value = "SELECT bp FROM BusinessPartner bp WHERE bp.defaultPartner = 'Active' ")
	public BusinessPartner getDefaultPartner();
	
	@Transactional
	@Modifying
	@Query(value="UPDATE BusinessPartner bp SET bp.maxRecNo=(bp.maxRecNo+1) WHERE bp.partner_ID =:partner_ID")
	public int setUpdateLastRecNo(@Param("partner_ID")String partner_ID);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE BusinessPartner bp SET bp.maxInvNo=(bp.maxInvNo+1) WHERE bp.partner_ID =:partner_ID")
	public int setUpdateLastInvNo(@Param("partner_ID")String partner_ID);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE BusinessPartner bp SET bp.maxInRecNo=(bp.maxInRecNo+1) WHERE bp.partner_ID =:partner_ID")
	public int setUpdateLastinRecNo(@Param("partner_ID")String partner_ID);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE BusinessPartner bp SET bp.maxVouNo=(bp.maxVouNo+1) WHERE bp.partner_ID =:partner_ID")
	public int setUpdateLastPaymentVoucherNo(@Param("partner_ID")String partner_ID);
	
	
	
	
	
}
