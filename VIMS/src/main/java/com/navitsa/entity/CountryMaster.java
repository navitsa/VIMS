package com.navitsa.entity;

import java.io.IOException;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="country_master")
public class CountryMaster {

	@Id
	@NotEmpty(message = "Please enter a country code")
	@Pattern(regexp="^([0-9+]+$)?",message="The country code is not valid")
	@Column(name="Country_Code")
	private String countryCode;
	
	@NotEmpty(message = "Please enter a country name")
	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name="Country")
	private String country;
	
	@Lob
	@Column(name = "Flag_Img")
	private byte[] flagImg;

	@NotEmpty(message = "Please enter the currency")
	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name = "Currency")
	private String currency;
	
	@Column(name = "CurrencyDes")
	private String currencyDescription;
	
	@Column(name = "Status")
	private String status;
	
	
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public byte[] getFlagImg() {
		return flagImg;
	}

	public void setFlagImg(MultipartFile flagImg) throws IOException {
		if(flagImg.isEmpty()) {
			flagImg = null;
		} else {
		this.flagImg = flagImg.getBytes();
		}
	}
	
	public String getFlagImgView() {
		return Base64.getEncoder().encodeToString(this.flagImg);
	}
	
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CountryMaster(String countryCode, String country, MultipartFile flagImg,String currency,String status) throws IOException {
		this.countryCode = countryCode;
		this.country = country;
		this.flagImg = flagImg.getBytes();
		this.currency = currency;
		this.status = status;
	}

	public CountryMaster() {
	}

	public CountryMaster(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCurrencyDescription() {
		return currencyDescription;
	}

	public void setCurrencyDescription(String currencyDescription) {
		this.currencyDescription = currencyDescription;
	}

	
	
	
}
