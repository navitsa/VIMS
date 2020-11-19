package com.navitsa.entity;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ocr_details")
public class OcrDetails {

	@Id
	@Column(name = "ocrid")
	private int ocrid;
	
	@Column(name = "ocrDate")
	private String ocrDate;
	
	@Column(name = "noimage")
	private byte[] noimage;
	
	@Column(name = "ocrVid")
	private String ocrVid;

	@Column(name = "vm_Status")
	private String vmStatus;

	@Column(name = "vr_Status")
	private String vrStatus;
	
	@Column(name = "doc_Status")
	private String docStatus; 
	
	@Column(name = "ve_type")
	private String vehicletype;
	
	@Column(name="CurrentMilage")
	private Long currentMilage;
	
	@Column(name = "appNo")
	private String appNo;
	
	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}

	public String getVmStatus() {
		return vmStatus;
	}

	public void setVmStatus(String vmStatus) {
		this.vmStatus = vmStatus;
	}

	public String getVrStatus() {
		return vrStatus;
	}

	public void setVrStatus(String vrStatus) {
		this.vrStatus = vrStatus;
	}

	public int getOcrid() {
		return ocrid;
	}

	public void setOcrid(int ocrid) {
		this.ocrid = ocrid;
	}

	public String getOcrDate() {
		return ocrDate;
	}

	public void setOcrDate(String ocrDate) {
		this.ocrDate = ocrDate;
	}

	public byte[] getNoimage() {
		return this.noimage;
	}

	public void setNoimage(byte[] noimage) {		
			this.noimage = noimage;
			
	}

	public String getNoimageView() {
		return Base64.getEncoder().encodeToString(this.noimage);
	}
	
	
	public String getOcrVid() {
		return ocrVid;
	}

	public void setOcrVid(String ocrVid) {
		this.ocrVid = ocrVid;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public Long getCurrentMilage() {
		return currentMilage;
	}

	public void setCurrentMilage(Long currentMilage) {
		this.currentMilage = currentMilage;
	}

	public String getAppNo() {
		return appNo;
	}

	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}
	
	
	
	
	
}
