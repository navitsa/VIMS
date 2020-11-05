package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "test_profile_header")
public class TestProfile {

	@Id
	@Column(name="profile_id")
	private int testProfileID;
	
	@NotEmpty(message = "Please enter a profile name")
	@Column(name="profile_name")
	private String testProfileName;
	
	@Column(name="description")
	private String description;
	
	@NotEmpty(message = "Please select a status")
	@Column(name="status")
	private String status;

	public TestProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestProfile(int testProfileID, String testProfileName, String description, String status) {
		super();
		this.testProfileID = testProfileID;
		this.testProfileName = testProfileName;
		this.description = description;
		this.status = status;
	}

	public int getTestProfileID() {
		return testProfileID;
	}

	public void setTestProfileID(int testProfileID) {
		this.testProfileID = testProfileID;
	}

	public String getTestProfileName() {
		return testProfileName;
	}

	public void setTestProfileName(String testProfileName) {
		this.testProfileName = testProfileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
