package com.navitsa.entity;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Ck_testWisePrintOrderId implements Serializable{

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id",referencedColumnName = "profile_id")
	private TestProfile testProfile;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id",referencedColumnName = "type_id")
	private Test_type testType;

	public TestProfile getTestProfile() {
		return testProfile;
	}

	public void setTestProfile(TestProfile testProfile) {
		this.testProfile = testProfile;
	}

	public Test_type getTestType() {
		return testType;
	}

	public void setTestType(Test_type testType) {
		this.testType = testType;
	}

	public Ck_testWisePrintOrderId(TestProfile testProfile, Test_type testType) {
		super();
		this.testProfile = testProfile;
		this.testType = testType;
	}

	public Ck_testWisePrintOrderId() {
	}

}
