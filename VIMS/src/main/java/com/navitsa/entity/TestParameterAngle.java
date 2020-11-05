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
@Table(name = "test_parameter_angle")
public class TestParameterAngle {

	@Id
	@Column(name="parameter_angle_id")
	private String paraAngleID;
	
	@NotEmpty(message = "required")
	@Column(name="angle_name")
	private String angleName;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "test_parameter_id",referencedColumnName = "test_parameter_id")
	private TestParameter testParameter;

	public TestParameterAngle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestParameterAngle(String paraAngleID, String angleName, TestParameter testParameter) {
		super();
		this.paraAngleID = paraAngleID;
		this.angleName = angleName;
		this.testParameter = testParameter;
	}

	public String getParaAngleID() {
		return paraAngleID;
	}

	public void setParaAngleID(String paraAngleID) {
		this.paraAngleID = paraAngleID;
	}

	public String getAngleName() {
		return angleName;
	}

	public void setAngleName(String angleName) {
		this.angleName = angleName;
	}

	public TestParameter getTestParameter() {
		return testParameter;
	}

	public void setTestParameter(TestParameter testParameter) {
		this.testParameter = testParameter;
	}

}
