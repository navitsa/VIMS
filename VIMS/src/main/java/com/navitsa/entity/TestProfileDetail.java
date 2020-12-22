package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "test_profile_detail")
public class TestProfileDetail {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="test_profile_detail_id")
//	private int testProfileDetailID;
	
	@EmbeddedId
	private Ck_testProfileDetailId ck_testProfileDetailId;

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
	
	@Column(name="tolerance")
	private Double tolerance;

	public TestProfileDetail(Ck_testProfileDetailId ck_testProfileDetailId,
			String limitValueDesc, String operator, Double limitValue, Double minValue, Double maxValue, Double tolerance) {
		super();
		//this.testProfileDetailID = testProfileDetailID;
		this.ck_testProfileDetailId = ck_testProfileDetailId;
		this.limitValueDesc = limitValueDesc;
		this.operator = operator;
		this.limitValue = limitValue;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.tolerance = tolerance;
	}

/*	public int getTestProfileDetailID() {
		return testProfileDetailID;
	}

	public void setTestProfileDetailID(int testProfileDetailID) {
		this.testProfileDetailID = testProfileDetailID;
	}*/

	public Ck_testProfileDetailId getCk_testProfileDetailId() {
		return ck_testProfileDetailId;
	}

	public void setCk_testProfileDetailId(Ck_testProfileDetailId ck_testProfileDetailId) {
		this.ck_testProfileDetailId = ck_testProfileDetailId;
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
		if(operator=="")
			this.operator = null;
		else
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

	public Double getTolerance() {
		return tolerance;
	}

	public void setTolerance(Double tolerance) {
		this.tolerance = tolerance;
	}

	public TestProfileDetail() {
	}

}
