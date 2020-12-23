package com.navitsa.entity;

import java.io.IOException;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="business_partner")
public class BusinessPartner {
	
	
	@Id
	@Column(name="Partner_ID")
	private String  partner_ID;
	
	@NotEmpty(message = "Please enter your business partner name")
	//@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name="Partner_Name")
	private String  partner_Name;
	
	@Pattern(regexp="(?:[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\\.)+[a-z0-9][a-z0-9-]{0,61}[a-z0-9]?",
			message="Web site is not valid")
	@Column(name="Web")
	private String  web;
	
	@Column(name="Email")
	private String  email;
	
	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name="Contact_Per")
	private String  contact_Per;
	
	@Pattern(regexp="^([+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$)?",message="Mobile no is not valid")
	@Column(name="Tele")
	private String  tele;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "Country_Code", referencedColumnName = "Country_Code")
	private CountryMaster  country_Code;
	
	@Column(name="address")
	private String address;
	
	@Lob
	@Column(name="Partner_Logo")
	private byte[] partner_Logo;
	
	@Column(name="Default_Partner")
	private String defaultPartner;
	
	@Column(name="Receipt_Header")
	private String receiptHeader;
	
	@Column(name="Receipt_Footer")
	private String receiptFooter;
	
	@Column(name="maxRecNo")
	private int maxRecNo;
	
	@Column(name="recformate")
	private String recformate;
	
	@Column(name="Report_Header")
	private String reportHeader;

	@Column(name="Report_Footer")
	private String reportFooter;

	@Column(name="ES_IN_Path")
	private String  esInPath;
	
	@Column(name="ES_OUT_Path")
	private String esOutPath;
	
	@Column(name="maxInvNo")
	private int maxInvNo;
	
	@Column(name="invformate")
	private String invformate;
	
	@Column(name="maxInRecNo")
	private int maxInRecNo;
	
	@Column(name="inRecformate")
	private String inRecformate;
	
	@Column(name="maxVouNo")
	private int maxVouNo;
	
	@Column(name="outVouFormate")
	private String outVouFormate;
		
	@Column(name="chequePrintConfig")
	private String chequePrintConfig;
	
	@Column(name="dbBackupPath")
	private String dbBackupPath;
	

	public String getPartner_ID() {
		return partner_ID;
	}

	public void setPartner_ID(String partner_ID) {
		this.partner_ID = partner_ID;
	}

	public CountryMaster getCountry_Code() {
		return country_Code;
	}

	public void setCountry_Code(CountryMaster country_Code) {
		this.country_Code = country_Code;
	}

	public String getPartner_Name() {
		return partner_Name;
	}

	public void setPartner_Name(String partner_Name) {
		this.partner_Name = partner_Name;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact_Per() {
		return contact_Per;
	}

	public void setContact_Per(String contact_Per) {
		this.contact_Per = contact_Per;
	}

	public byte[] getPartner_Logo() {
		return partner_Logo;
	}

	public void setPartner_Logo(MultipartFile partner_Logo) throws IOException {
		if(partner_Logo.isEmpty()) {
			partner_Logo = null;
		} else {
		this.partner_Logo = partner_Logo.getBytes();
		}
	}

	public String getPartnerImgView() {
		return Base64.getEncoder().encodeToString(this.partner_Logo);
	}
	
	public String getEsInPath() {
		return esInPath;
	}

	public void setEsInPath(String esInPath) {
		this.esInPath = esInPath;
	}

	public String getEsOutPath() {
		return esOutPath;
	}

	public void setEsOutPath(String esOutPath) {
		this.esOutPath = esOutPath;
	}

	public String getReceiptHeader() {
		return receiptHeader;
	}

	public void setReceiptHeader(String receiptHeader) {
		this.receiptHeader = receiptHeader;
	}

	public String getReceiptFooter() {
		return receiptFooter;
	}

	public void setReceiptFooter(String receiptFooter) {
		this.receiptFooter = receiptFooter;
	}

	public String getReportHeader() {
		return reportHeader;
	}

	public void setReportHeader(String reportHeader) {
		this.reportHeader = reportHeader;
	}

	public String getReportFooter() {
		return reportFooter;
	}

	public void setReportFooter(String reportFooter) {
		this.reportFooter = reportFooter;
	}
	
	public String getDefaultPartner() {
		return defaultPartner;
	}

	public void setDefaultPartner(String defaultPartner) {
		this.defaultPartner = defaultPartner;
	}

	public BusinessPartner() {
	}

	
	public int getMaxRecNo() {
		return maxRecNo;
	}

	public void setMaxRecNo(int maxRecNo) {
		this.maxRecNo = maxRecNo;
	}

	public String getRecformate() {
		return recformate;
	}

	public void setRecformate(String recformate) {
		this.recformate = recformate;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BusinessPartner(String partner_ID, CountryMaster country_Code, String partner_Name, 
			String tele, String web, String email, String contact_Per,
			MultipartFile partner_Logo,String receiptHeader,String receiptFooter,String reportHeader,
			String reportFooter,String defaultPartner,String esInPath,String esOutPath) throws IOException {
		this.partner_ID = partner_ID;
		this.country_Code = country_Code;
		this.partner_Name = partner_Name;
		this.tele = tele;
		this.web = web;
		this.email = email;
		this.contact_Per = contact_Per;
		this.partner_Logo = partner_Logo.getBytes();
		this.receiptHeader = receiptHeader;
		this.receiptFooter = receiptFooter;
		this.reportHeader = reportHeader;
		this.reportFooter = reportFooter;
		this.defaultPartner = defaultPartner;
		this.esInPath = esInPath;
		this.esOutPath = esOutPath;
	}

	public BusinessPartner(String partner_ID) {
		this.partner_ID = partner_ID;
	}

	public int getMaxInvNo() {
		return maxInvNo;
	}

	public void setMaxInvNo(int maxInvNo) {
		this.maxInvNo = maxInvNo;
	}

	public String getInvformate() {
		return invformate;
	}

	public void setInvformate(String invformate) {
		this.invformate = invformate;
	}

	public int getMaxInRecNo() {
		return maxInRecNo;
	}

	public void setMaxInRecNo(int maxInRecNo) {
		this.maxInRecNo = maxInRecNo;
	}

	public String getInRecformate() {
		return inRecformate;
	}

	public void setInRecformate(String inRecformate) {
		this.inRecformate = inRecformate;
	}

	public int getMaxVouNo() {
		return maxVouNo;
	}

	public void setMaxVouNo(int maxVouNo) {
		this.maxVouNo = maxVouNo;
	}

	public String getOutVouFormate() {
		return outVouFormate;
	}

	public void setOutVouFormate(String outVouFormate) {
		this.outVouFormate = outVouFormate;
	}

	public String getChequePrintConfig() {
		return chequePrintConfig;
	}

	public void setChequePrintConfig(String chequePrintConfig) {
		this.chequePrintConfig = chequePrintConfig;
	}

	public String getDbBackupPath() {
		return dbBackupPath;
	}

	public void setDbBackupPath(String dbBackupPath) {
		this.dbBackupPath = dbBackupPath;
	}
	
	
	
	
}
