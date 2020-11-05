package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "test_category")
public class TestCategory {

	@Id
	@Column(name="Category_Id")
	private String categoryId;
	
	@NotEmpty(message = "Please enter a category")
	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")
	@Column(name="Category_Type")
	private String categoryType;
	
	//@Pattern(regexp="^([0-9.+$)?",message="Category fee should be a number")
	@Column(name="Category_Fee")
	private Long categoryFee;

	//@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Special Characters Not Allowed")
	@Column(name="Category_Remarks")
	private String remarks;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id",referencedColumnName = "profile_id")
	private TestProfile testProfileId;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Visual_Profile_ID",referencedColumnName = "Visual_Profile_ID")
	private VisualProfile viProfileId;
	
	@Pattern(regexp="^([0-9]+$)?",message="Please enter the duration in minutes")
	@Column(name="testAproTime")
	private String testAproTime;
	
	public TestCategory(String categoryId) {
		this.categoryId = categoryId;
	}

	public TestCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestCategory(String categoryId, String categoryType, Long categoryFee, String remarks,
			TestProfile testProfileId, VisualProfile viProfileId, String testAproTime ) {
		super();
		this.categoryId = categoryId;
		this.categoryType = categoryType;
		//Long catFee = (long) (categoryFee*100);
		this.categoryFee = categoryFee;
		this.remarks = remarks;
		this.testProfileId = testProfileId;
		this.viProfileId = viProfileId;
		this.testAproTime = testAproTime;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public Long getCategoryFee() {	
		return categoryFee;
	}

	public void setCategoryFee(Long categoryFee) {
		//Long catFee = (long) (categoryFee*100);
		this.categoryFee = categoryFee;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public TestProfile getTestProfileId() {
		return testProfileId;
	}

	public void setTestProfileId(TestProfile testProfileId) {
		this.testProfileId = testProfileId;
	}

	public VisualProfile getViProfileId() {
		return viProfileId;
	}

	public void setViProfileId(VisualProfile viProfileId) {
		this.viProfileId = viProfileId;
	}

	public String getTestAproTime() {
		return testAproTime;
	}

	public void setTestAproTime(String testAproTime) {
		this.testAproTime = testAproTime;
	}	
	
}
