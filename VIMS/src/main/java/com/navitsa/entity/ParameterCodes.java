package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parameter_code")
public class ParameterCodes {
	
	@Column(name="s_id")
	private int s_id;
	
	@EmbeddedId
	private Ck_paraCodeId ck_paraCodeId;
	
	@Column(name="description")
	private String description;

	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "test_point_id",referencedColumnName = "test_point_id")
	private TestPoint testPoint;
	
	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "test_parameter_id",referencedColumnName = "test_parameter_id")
	private TestParameter testParameter;
	
	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "parameter_angle_id",referencedColumnName = "parameter_angle_id")
	private TestParameterAngle testParameterAngle;

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public Ck_paraCodeId getCk_paraCodeId() {
		return ck_paraCodeId;
	}

	public void setCk_paraCodeId(Ck_paraCodeId ck_paraCodeId) {
		this.ck_paraCodeId = ck_paraCodeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TestPoint getTestPoint() {
		return testPoint;
	}

	public void setTestPoint(TestPoint testPoint) {
		this.testPoint = testPoint;
	}

	public TestParameter getTestParameter() {
		return testParameter;
	}

	public void setTestParameter(TestParameter testParameter) {
		this.testParameter = testParameter;
	}

	public TestParameterAngle getTestParameterAngle() {
		return testParameterAngle;
	}

	public void setTestParameterAngle(TestParameterAngle testParameterAngle) {
		this.testParameterAngle = testParameterAngle;
	}

	public ParameterCodes(int s_id, Ck_paraCodeId ck_paraCodeId, String description, TestPoint testPoint,
			TestParameter testParameter, TestParameterAngle testParameterAngle) {
		super();
		this.s_id = s_id;
		this.ck_paraCodeId = ck_paraCodeId;
		this.description = description;
		this.testPoint = testPoint;
		this.testParameter = testParameter;
		this.testParameterAngle = testParameterAngle;
	}

	public ParameterCodes() {
	}

}
