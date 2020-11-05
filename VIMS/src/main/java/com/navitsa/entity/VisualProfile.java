package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "visual_profile_master")
public class VisualProfile {
	
	
	@Id
	@NotEmpty(message = "required")
	@Column(name="Visual_Profile_ID")
	private String visualProfileID;
	
	@NotEmpty(message = "Please enter a profile name")
	//@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name="Profile_Name")
	private String profileName;

	//@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name="Profile_Header")
	private String profileHeader;
	 
	//@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name="Profile_Sub_Header")
	private String profileSubHeader;
	
	//@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name="Profile_Footer")
	private String profileFooter;
	
	//@Pattern(regexp="^([a-zA-Z0-9/ ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name="Remark")
	private String remark;
	
	
	public VisualProfile() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VisualProfile(String visualProfileID,String profileName,String profileHeader,String profileSubHeader,String profileFooter,String remark) {
		super();
		this.visualProfileID = visualProfileID;
		this.profileName = profileName;
		this.profileHeader = profileHeader;
		this.profileSubHeader = profileSubHeader;
		this.profileFooter = profileFooter;
		this.remark = remark;

	}


	public String getVisualProfileID() {
		return visualProfileID;
	}


	public void setVisualProfileID(String visualProfileID) {
		this.visualProfileID = visualProfileID;
	}


	public String getProfileName() {
		return profileName;
	}


	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}


	public String getProfileHeader() {
		return profileHeader;
	}


	public void setProfileHeader(String profileHeader) {
		this.profileHeader = profileHeader;
	}


	public String getProfileSubHeader() {
		return profileSubHeader;
	}


	public void setProfileSubHeader(String profileSubHeader) {
		this.profileSubHeader = profileSubHeader;
	}


	public String getProfileFooter() {
		return profileFooter;
	}


	public void setProfileFooter(String profileFooter) {
		this.profileFooter = profileFooter;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}

}
