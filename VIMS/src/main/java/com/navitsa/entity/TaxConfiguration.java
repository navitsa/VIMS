package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="taxconfiguration")
public class TaxConfiguration {
	
	
	@Id
	@Column(name ="taxCode")
	private String taxCode;
	
	@NotEmpty(message = "Please enter a tax")
	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name ="tax")
	private String tax;
	
	//@Digits(message="Please enter a valid tax rate",fraction = 0, integer = 10)
	@Column(name ="taxRate")
	private Long taxRate;
	
	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name ="remarks")
	private String remarks;
	
	@Column(name ="status")
	private String status;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "GlAccNo", referencedColumnName = "GlAccNo")
	private Glaccount glAccNo;
	
	@NotEmpty(message = "Please select a sequence no")
	@Column(name ="sequence_id")
	private String sequenceId;

	@NotEmpty(message = "Please select a country")
	@Column(name ="Country_Code")
	private String countryCode;
	
	@Column(name ="Type")
	private String type;

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public Long getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Long taxRate) {
		this.taxRate = taxRate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Glaccount getGlAccNo() {
		return glAccNo;
	}

	public void setGlAccNo(Glaccount glAccNo) {
		this.glAccNo = glAccNo;
	}

	public String getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(String sequenceId) {
		this.sequenceId = sequenceId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	
	
}
