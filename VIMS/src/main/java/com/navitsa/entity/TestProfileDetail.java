package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_profile_detail")
public class TestProfileDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="test_profile_detail_id")
	private int testProfileDetailID;

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id",referencedColumnName = "profile_id")
	private TestProfile testProfileHeaderID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "code",referencedColumnName = "code")
	private ParameterCodes parameterCodes;

	public TestProfileDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestProfileDetail(int testProfileDetailID, TestProfile testProfileHeaderID, ParameterCodes parameterCodes) {
		super();
		this.testProfileDetailID = testProfileDetailID;
		this.testProfileHeaderID = testProfileHeaderID;
		this.parameterCodes = parameterCodes;
	}

	public int getTestProfileDetailID() {
		return testProfileDetailID;
	}

	public void setTestProfileDetailID(int testProfileDetailID) {
		this.testProfileDetailID = testProfileDetailID;
	}

	public TestProfile getTestProfileHeaderID() {
		return testProfileHeaderID;
	}

	public void setTestProfileHeaderID(TestProfile testProfileHeaderID) {
		this.testProfileHeaderID = testProfileHeaderID;
	}


	public ParameterCodes getParameterCodes() {
		return parameterCodes;
	}

	public void setParameterCodes(ParameterCodes parameterCodes) {
		this.parameterCodes = parameterCodes;
	}

}
