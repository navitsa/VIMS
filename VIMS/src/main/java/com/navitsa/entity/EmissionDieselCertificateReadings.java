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
@Table(name = "emission_diesel_certificate_readings")
public class EmissionDieselCertificateReadings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "id_no",referencedColumnName = "id_no")
	private EmissionDieselCertificateData edc_id;
	
	@Column(name="k")
	private String k;
	
	@Column(name="hsu")
	private String hsu;
	
	@Column(name="rpm_min")
	private String rpm_min;
	
	@Column(name="rpm_max")
	private String rpm_max;
	
	@Column(name="oil_temp")
	private String oil_temp;

	public EmissionDieselCertificateReadings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmissionDieselCertificateReadings(int id, EmissionDieselCertificateData edc_id, String k, String hsu,
			String rpm_min, String rpm_max, String oil_temp) {
		super();
		this.id = id;
		this.edc_id = edc_id;
		this.k = k;
		this.hsu = hsu;
		this.rpm_min = rpm_min;
		this.rpm_max = rpm_max;
		this.oil_temp = oil_temp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmissionDieselCertificateData getEdc_id() {
		return edc_id;
	}

	public void setEdc_id(EmissionDieselCertificateData edc_id) {
		this.edc_id = edc_id;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getHsu() {
		return hsu;
	}

	public void setHsu(String hsu) {
		this.hsu = hsu;
	}

	public String getRpm_min() {
		return rpm_min;
	}

	public void setRpm_min(String rpm_min) {
		this.rpm_min = rpm_min;
	}

	public String getRpm_max() {
		return rpm_max;
	}

	public void setRpm_max(String rpm_max) {
		this.rpm_max = rpm_max;
	}

	public String getOil_temp() {
		return oil_temp;
	}

	public void setOil_temp(String oil_temp) {
		this.oil_temp = oil_temp;
	}
}
