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
@Table(name = "test_parameter")
public class TestParameter {

	@Id
	@Column(name="test_parameter_id")
	private String testParameterId;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id",referencedColumnName = "type_id")
	private Test_type testType;
	
	@NotEmpty(message = "required")
	@Column(name="para_name")
	private String paraName;

	public TestParameter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestParameter(String testParameterId, Test_type testType, String paraName) {
		super();
		this.testParameterId = testParameterId;
		this.testType = testType;
		this.paraName = paraName;
	}

	public String getTestParameterId() {
		return testParameterId;
	}

	public void setTestParameterId(String testParameterId) {
		this.testParameterId = testParameterId;
	}

	public Test_type getTestType() {
		return testType;
	}

	public void setTestType(Test_type testType) {
		this.testType = testType;
	}

	public String getParaName() {
		return paraName;
	}

	public void setParaName(String paraName) {
		this.paraName = paraName;
	}

}
