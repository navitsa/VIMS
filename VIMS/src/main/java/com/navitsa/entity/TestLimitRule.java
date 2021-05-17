package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_limit_rule")
public class TestLimitRule {

	@Id
	@Column(name="rule_code")
	private int ruleCode;
	
	@Column(name="rule_name")
	private String ruleName;
	
	@Column(name="rule_description")
	private String ruleDesc;
	
	@Column(name="effective_from")
	private String effectiveFrom;
	
	@Column(name="effective_to")
	private String effectiveTo;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "fuel_type",referencedColumnName = "Fuel_Type_ID")
	private FuelType fuelType;
	
	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_category_type",referencedColumnName = "Type_ID")
	private VehicleCategoryType vechicleCatType;
	
	@Column(name="stroke")
	private String stroke;

	public TestLimitRule() {
		super();
	}

	public TestLimitRule(int ruleCode, String ruleName, String ruleDesc, String effectiveFrom, String effectiveTo,
			String status, FuelType fuelType, VehicleCategoryType vechicleCatType, String stroke) {
		super();
		this.ruleCode = ruleCode;
		this.ruleName = ruleName;
		this.ruleDesc = ruleDesc;
		this.effectiveFrom = effectiveFrom;
		this.effectiveTo = effectiveTo;
		this.status = status;
		this.fuelType = fuelType;
		this.vechicleCatType = vechicleCatType;
		this.stroke = stroke;
	}

	public int getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(int ruleCode) {
		this.ruleCode = ruleCode;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public String getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(String effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public String getEffectiveTo() {
		return effectiveTo;
	}

	public void setEffectiveTo(String effectiveTo) {
		this.effectiveTo = effectiveTo;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public VehicleCategoryType getVechicleCatType() {
		return vechicleCatType;
	}


	public void setVechicleCatType(VehicleCategoryType vechicleCatType) {
		this.vechicleCatType = vechicleCatType;
	}

	public String getStroke() {
		return stroke;
	}

	public void setStroke(String stroke) {
		this.stroke = stroke;
	}

}
