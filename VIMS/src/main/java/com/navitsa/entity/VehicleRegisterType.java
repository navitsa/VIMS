package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "v_register_types")
public class VehicleRegisterType {

	@Id
	@NotEmpty(message = "required")
	@Column(name = "V_Register_Type_ID")
	private String vRegTypeID;
	
	@NotEmpty(message = "Please enter a entry type")
	@Column(name = "V_Register_Type")
	private String vRegType;

	@Column(name = "Remark")
	private String remark;
	
	@Column(name = "vTestFeePre")
	private Long vTestFeePre;
	
	@Column(name = "Validity_for_Repeat_Test ")
	private String vRT;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name ="sequence")
	private String sequence;
	
	

	public String getvRT() {
		return vRT;
	}

	public void setvRT(String vRT) {
		this.vRT = vRT;
	}

	public Long getvTestFeePre() {
		return vTestFeePre;
	}

	public void setvTestFeePre(Long vTestFeePre) {
		this.vTestFeePre = vTestFeePre;
	}

	public String getvRegTypeID() {
		return vRegTypeID;
	}

	public void setvRegTypeID(String vRegTypeID) {
		this.vRegTypeID = vRegTypeID;
	}

	public String getvRegType() {
		return vRegType;
	}

	public void setvRegType(String vRegType) {
		this.vRegType = vRegType;
	}

	public VehicleRegisterType(String vRegTypeID) {
		
		this.vRegTypeID = vRegTypeID;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public VehicleRegisterType() {
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	
}
