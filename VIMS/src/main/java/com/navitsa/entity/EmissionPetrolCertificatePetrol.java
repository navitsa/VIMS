package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emission_petrol_certificate_petrol")
public class EmissionPetrolCertificatePetrol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="s_no")
	private String s_no;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "id_no",referencedColumnName = "id_no")
	private EmissionPetrolCertificateData id_no;
	
	@Column(name="pres_co")
	private String pres_co;
	
	@Column(name="pres_hc")
	private String pres_hc;
	
	@Column(name="co")
	private String co;
	
	@Column(name="hc")
	private String hc;
	
	@Column(name="co2")
	private String co2;
	
	@Column(name="o2")
	private String o2;
	
	@Column(name="nox")
	private String nox;
	
	@Column(name="lembda")
	private String lembda;
	
	@Column(name="rpm")
	private String rpm;

	public EmissionPetrolCertificatePetrol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmissionPetrolCertificatePetrol(String s_no, EmissionPetrolCertificateData id_no, String pres_co,
			String pres_hc, String co, String hc, String co2, String o2, String nox, String lembda, String rpm) {
		super();
		this.s_no = s_no;
		this.id_no = id_no;
		this.pres_co = pres_co;
		this.pres_hc = pres_hc;
		this.co = co;
		this.hc = hc;
		this.co2 = co2;
		this.o2 = o2;
		this.nox = nox;
		this.lembda = lembda;
		this.rpm = rpm;
	}

	public String getS_no() {
		return s_no;
	}

	public void setS_no(String s_no) {
		this.s_no = s_no;
	}

	public EmissionPetrolCertificateData getId_no() {
		return id_no;
	}

	public void setId_no(EmissionPetrolCertificateData id_no) {
		this.id_no = id_no;
	}

	public String getPres_co() {
		return pres_co;
	}

	public void setPres_co(String pres_co) {
		this.pres_co = pres_co;
	}

	public String getPres_hc() {
		return pres_hc;
	}

	public void setPres_hc(String pres_hc) {
		this.pres_hc = pres_hc;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getHc() {
		return hc;
	}

	public void setHc(String hc) {
		this.hc = hc;
	}

	public String getCo2() {
		return co2;
	}

	public void setCo2(String co2) {
		this.co2 = co2;
	}

	public String getO2() {
		return o2;
	}

	public void setO2(String o2) {
		this.o2 = o2;
	}

	public String getNox() {
		return nox;
	}

	public void setNox(String nox) {
		this.nox = nox;
	}

	public String getLembda() {
		return lembda;
	}

	public void setLembda(String lembda) {
		this.lembda = lembda;
	}

	public String getRpm() {
		return rpm;
	}

	public void setRpm(String rpm) {
		this.rpm = rpm;
	}
}
