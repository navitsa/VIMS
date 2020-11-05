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
@Table(name = "emission_diesel_certificate_data")
public class EmissionDieselCertificateData {

	@Id
	@NotEmpty
	@Column(name="id_no")
	private String id_no;
	
	@Column(name="vehicle_no")
	private String vehicle_no;
	
	@Column(name="hsu_pres")
	private String hsu_pres;
	
	@Column(name="k_pres")
	private String k_pres;
	
	@Column(name="result")
	private String result;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "V_Register_ID",referencedColumnName = "V_Register_ID")
	private VehicleRegistration reg_id;

	public EmissionDieselCertificateData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmissionDieselCertificateData(String id_no, String vehicle_no, String result,
			VehicleRegistration reg_id) {
		super();
		this.id_no = id_no;
		this.vehicle_no = vehicle_no;
		this.result = result;
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

	public VehicleRegistration getReg_id() {
		return reg_id;
	}

	public void setReg_id(VehicleRegistration reg_id) {
		this.reg_id = reg_id;
	}

	public String getHsu_pres() {
		return hsu_pres;
	}

	public void setHsu_pres(String hsu_pres) {
		this.hsu_pres = hsu_pres;
	}

	public String getK_pres() {
		return k_pres;
	}

	public void setK_pres(String k_pres) {
		this.k_pres = k_pres;
	}
	
}
