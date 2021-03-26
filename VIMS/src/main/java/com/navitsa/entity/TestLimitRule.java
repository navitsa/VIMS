package com.navitsa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	private Date effectiveFrom;
	
	@Column(name="effective_to")
	private Date effectiveTo;

	public TestLimitRule() {
		super();
	}

	public TestLimitRule(int ruleCode, String ruleName, String ruleDesc, Date effectiveFrom, Date effectiveTo) {
		super();
		this.ruleCode = ruleCode;
		this.ruleName = ruleName;
		this.ruleDesc = ruleDesc;
		this.effectiveFrom = effectiveFrom;
		this.effectiveTo = effectiveTo;
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

	public Date getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(Date effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public Date getEffectiveTo() {
		return effectiveTo;
	}

	public void setEffectiveTo(Date effectiveTo) {
		this.effectiveTo = effectiveTo;
	}	
	

}
