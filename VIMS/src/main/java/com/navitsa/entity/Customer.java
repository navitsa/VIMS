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
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "title")
	private String title;
	
	@NotEmpty(message = "Please enter a customer name")
	@Column(name = "name")
	private String name;
	
	@NotEmpty(message = "Please enter a mobile no")
	@Column(name = "mobileNo")
	private String tpno;

	@Column(name = "email")
	private String email;

	@Column(name = "postalBox")
	private String address;
	
	@Column(name = "city")
	private String city;

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "state", referencedColumnName = "State_id")
	private CountryState stateid;
	
	@Column(name = "taxcode")
	private String taxcode;
	
	@Column(name = "isCredit")
	private String isCredeit;
	
	@Column(name = "crLimit")
	private Long crLimit;
	
	@Column(name = "crBalance")
	private Long crBalance;
	
	public Customer() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTpno() {
		return tpno;
	}

	public void setTpno(String tpno) {
		this.tpno = tpno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTaxcode() {
		return taxcode;
	}

	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
	}

	public String getIsCredeit() {
		return isCredeit;
	}

	public void setIsCredeit(String isCredeit) {
		this.isCredeit = isCredeit;
	}

	public Long getCrLimit() {
		return crLimit;
	}

	public void setCrLimit(Long crLimit) {
		this.crLimit = crLimit;
	}

	public Long getCrBalance() {
		return crBalance;
	}

	public void setCrBalance(Long string) {
		this.crBalance = string;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CountryState getStateid() {
		return stateid;
	}

	public void setStateid(CountryState stateid) {
		this.stateid = stateid;
	}

}
