package com.navitsa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Ck_paraCodeId implements Serializable {

	@Column(name = "code")
	private String code;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id", referencedColumnName = "type_id")
	private Test_type testType;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "test_parameter_id", referencedColumnName = "test_parameter_id")
	private TestParameter testParameter;

	public Ck_paraCodeId(String code, Test_type testType, TestParameter testParameter) {
		super();
		this.code = code;
		this.testType = testType;
		this.testParameter = testParameter;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Test_type getTestType() {
		return testType;
	}

	public void setTestType(Test_type testType) {
		this.testType = testType;
	}

	public Ck_paraCodeId() {
	}

	public TestParameter getTestParameter() {
		return testParameter;
	}

	public void setTestParameter(TestParameter testParameter) {
		this.testParameter = testParameter;
	}

}
