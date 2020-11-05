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
@Table(name = "test_point")
public class TestPoint {

	@Id
	@NotEmpty(message = "required")
	@Column(name="test_point_id")
	private String testPointID;
	
	@NotEmpty(message = "required")
	@Column(name="test_point_name")
	private String testPointName;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id",referencedColumnName = "type_id")
	private Test_type testType;
	

	public TestPoint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestPoint(String testPointID, String testPointName, Test_type testType) {
		super();
		this.testPointID = testPointID;
		this.testPointName = testPointName;
		this.testType = testType;
	}

	public String getTestPointID() {
		return testPointID;
	}

	public void setTestPointID(String testPointID) {
		this.testPointID = testPointID;
	}

	public String getTestPointName() {
		return testPointName;
	}

	public void setTestPointName(String testPointName) {
		this.testPointName = testPointName;
	}

	public Test_type getTestType() {
		return testType;
	}

	public void setTestType(Test_type testType) {
		this.testType = testType;
	}
	
}
