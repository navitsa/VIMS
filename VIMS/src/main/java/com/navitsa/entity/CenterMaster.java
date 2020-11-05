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
@Table(name="center_master")
public class CenterMaster {

	@Id
	@Column(name="Center_ID")
	private String  center_ID;
	
	@NotEmpty(message = "Please enter your center name")
	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name="Center")
	private String center;
	
	@Pattern(regexp="^([+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$)?",message="Mobile no is not valid")
	@Column(name="Tele")
	private String tele;
	
	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name="Contact_Person_ID")
	private String contactPersonID;
	
	@NotEmpty(message = "Please enter no of lanes")
	@Column(name="Lanes")
	private String lanes;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Add03")
	private String add03;
	
	@Lob
	@Column(name="Center_image")
	private byte[] center_image;
	
	@NotEmpty(message = "Please enter open time")
	@Column(name="OpenTime")
	private String openTime;
	
	@NotEmpty(message = "Please enter close time")
	@Column(name = "CloseTime")
	private String closeTime;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "Partner_ID", referencedColumnName = "Partner_ID")
	private BusinessPartner partner_ID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "Center_Type_ID", referencedColumnName = "Center_Type_ID")
	private CenterTypes centerTypeID;

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Country_code", referencedColumnName = "Country_Code")	
	private CountryMaster countrycode;
	
	@NotEmpty(message = "Please enter ES_IN path")
	@Column(name="ES_IN_Path")
	private String  esInPath;
	
	@NotEmpty(message = "Please enter ES_OUT path")
	@Column(name="ES_OUT_Path")
	private String esOutPath;

	@NotEmpty(message = "Please enter XML_ES_IN path")
	@Column(name="ES_IN_Xml_Path")
	private String  esInXmlPath;
	
	@Column(name="GET_Auto_Img_Path")
	private String  getAutoCaptureImgPath;	
	
	@Column(name="Vehicle_Auto_Config")
	private String  vehicleAutoConfig;		
	
	public String getCenter_ID() {
		return center_ID;
	}

	public void setCenter_ID(String center_ID) {
		this.center_ID = center_ID;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getContactPersonID() {
		return contactPersonID;
	}

	public void setContactPersonID(String contactPersonID) {
		this.contactPersonID = contactPersonID;
	}

	public String getLanes() {
		return lanes;
	}

	public void setLanes(String lanes) {
		this.lanes = lanes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCenter_imageView() {
		return Base64.getEncoder().encodeToString(this.center_image);
	}
	
	public byte[] getCenter_image() {
		return center_image;
	}

	public void setCenter_image(MultipartFile center_image) throws IOException{
		if(center_image.isEmpty()) {
			center_image = null;
		} else {
			this.center_image = center_image.getBytes();
		}
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}


	public BusinessPartner getPartner_ID() {
		return partner_ID;
	}

	public void setPartner_ID(BusinessPartner partner_ID) {
		this.partner_ID = partner_ID;
	}

	public CenterTypes getCenterTypeID() {
		return centerTypeID;
	}

	public void setCenterTypeID(CenterTypes centerTypeID) {
		this.centerTypeID = centerTypeID;
	}

	public CountryMaster getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(CountryMaster countrycode) {
		this.countrycode = countrycode;
	}	
	    

	
	public String getAdd03() {
		return add03;
	}

	public void setAdd03(String add03) {
		this.add03 = add03;
	}

	public CenterMaster() {
		
	}

	public String getGetAutoCaptureImgPath() {
		return getAutoCaptureImgPath;
	}

	public void setGetAutoCaptureImgPath(String getAutoCaptureImgPath) {
		this.getAutoCaptureImgPath = getAutoCaptureImgPath;
	}

	public CenterMaster(String center_ID, String center, String tele, String contactPersonID, String lanes,
			String email,MultipartFile center_image, String openTime, String closeTime, String laneCapacity,
			BusinessPartner partner_ID, CenterTypes centerTypeID, CountryMaster countrycode,
			String add01, String add02,String add03) throws IOException {
		this.center_ID = center_ID;
		this.center = center;
		this.tele = tele;
		this.contactPersonID = contactPersonID;
		this.lanes = lanes;
		this.email = email;
		this.center_image = center_image.getBytes();
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.partner_ID = partner_ID;
		this.centerTypeID = centerTypeID;
		this.countrycode = countrycode;
		this.add03 = add03;
	}

	public CenterMaster(String center_ID) {
		this.center_ID = center_ID;
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

	public String getEsInXmlPath() {
		return esInXmlPath;
	}

	public void setEsInXmlPath(String esInXmlPath) {
		this.esInXmlPath = esInXmlPath;
	}

	public String getVehicleAutoConfig() {
		return vehicleAutoConfig;
	}

	public void setVehicleAutoConfig(String vehicleAutoConfig) {
		this.vehicleAutoConfig = vehicleAutoConfig;
	}

	
}
