package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "emission_petrol_certificate_data")
public class EmissionPetrolCertificateData {

	@Id
	@NotEmpty
	@Column(name="id_no")
	private String id_no;
	
	@Column(name="vehicle_no")
	private String vehicle_no;
	
	@Column(name="result")
	private String result;
	
	@Column(name="cancelled")
	private String cancelled;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "V_Register_ID",referencedColumnName = "V_Register_ID")
	private VehicleRegistration reg_id;

	public EmissionPetrolCertificateData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmissionPetrolCertificateData(String id_no, String vehicle_no, String result, String cancelled,
			VehicleRegistration reg_id) {
		super();
		this.id_no = id_no;
		this.vehicle_no = vehicle_no;
		this.result = result;
		this.cancelled = cancelled;
		this.reg_id = reg_id;
	}

	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	public String getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCancelled() {
		return cancelled;
	}

	public void setCancelled(String cancelled) {
		this.cancelled = cancelled;
	}

	public VehicleRegistration getReg_id() {
		return reg_id;
	}

	public void setReg_id(VehicleRegistration reg_id) {
		this.reg_id = reg_id;
	}
}
