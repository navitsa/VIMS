package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parameter_code")
public class ParameterCodes {
	
	@Column(name="s_id")
	private int s_id;
	
	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id",referencedColumnName = "type_id")
	private Test_type testType;

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "test_point_id",referencedColumnName = "test_point_id")
	private TestPoint testPoint;
	
	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "test_parameter_id",referencedColumnName = "test_parameter_id")
	private TestParameter testParameter;
	
	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "parameter_angle_id",referencedColumnName = "parameter_angle_id")
	private TestParameterAngle testParameterAngle;
	
	@Column(name="limit_value_desc")
	private String limitValueDesc;
	
	@Column(name="operator")
	private String operator;
	
	@Column(name="limit_value")
	private Double limitValue;
	
	@Column(name="min_value")
	private Double minValue;
	
	@Column(name="max_value")
	private Double maxValue;

	public ParameterCodes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParameterCodes(String code, String description, Test_type testType, TestPoint testPoint,
			TestParameter testParameter, TestParameterAngle testParameterAngle, String limitValueDesc, String operator,
			Double limitValue, Double minValue, Double maxValue) {
		super();
		this.code = code;
		this.description = description;
		this.testType = testType;
		this.testPoint = testPoint;
		this.testParameter = testParameter;
		this.testParameterAngle = testParameterAngle;
		this.limitValueDesc = limitValueDesc;
		this.operator = operator;
		this.limitValue = limitValue;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Test_type getTestType() {
		return testType;
	}

	public void setTestType(Test_type testType) {
		this.testType = testType;
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

	public String getLimitValueDesc() {
		return limitValueDesc;
	}

	public void setLimitValueDesc(String limitValueDesc) {
		this.limitValueDesc = limitValueDesc;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Double getLimitValue() {
		return limitValue;
	}

	public void setLimitValue(Double limitValue) {
		this.limitValue = limitValue;
	}

	public Double getMinValue() {
		return minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}
	
}
