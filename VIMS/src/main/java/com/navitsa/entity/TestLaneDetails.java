package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="test_lanes_details")

public class TestLaneDetails {
	
	@Id
	@Column(name="Test_lanes_details_id")
	private String testLaneDetailsid;
	
	@Column(name="Eq_Type_ID")
	private String eqTypeid;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="testLaneHead_Id" , referencedColumnName="testLaneHead_Id")
	private TestLaneHead testLaneHeadId;
	
	@Column(name="Eq_Make_ID")
	private String eqMakeID;
	
	@Column(name="Eq_Model_ID")
	private String eqModelID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Equipment_ID" , referencedColumnName="Equipment_ID")
	private EquipmentMaster equipmentID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Center_ID" , referencedColumnName="Center_ID" )
	private CenterMaster centerID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="test_type" , referencedColumnName="type_id")
	private Test_type testType;


	public TestLaneHead getTestLaneHeadId() {
		return testLaneHeadId;
	}

	public void setTestLaneHeadId(TestLaneHead testLaneHeadId) {
		this.testLaneHeadId = testLaneHeadId;
	}

	public String getTestLaneDetailsid() {
		return testLaneDetailsid;
	}

	public void setTestLaneDetailsid(String testLaneDetailsid) {
		this.testLaneDetailsid = testLaneDetailsid;
	}


	public String getEqTypeid() {
		return eqTypeid;
	}




	public void setEqTypeid(String eqTypeid) {
		this.eqTypeid = eqTypeid;
	}




	public String getEqMakeID() {
		return eqMakeID;
	}




	public void setEqMakeID(String eqMakeID) {
		this.eqMakeID = eqMakeID;
	}




	public String getEqModelID() {
		return eqModelID;
	}




	public void setEqModelID(String eqModelID) {
		this.eqModelID = eqModelID;
	}




	public EquipmentMaster getEquipmentID() {
		return equipmentID;
	}




	public void setEquipmentID(EquipmentMaster equipmentID) {
		this.equipmentID = equipmentID;
	}


	public CenterMaster getCenterID() {
		return centerID;
	}




	public void setCenterID(CenterMaster centerID) {
		this.centerID = centerID;
	}




	public Test_type getTestType() {
		return testType;
	}




	public void setTestType(Test_type testType) {
		this.testType = testType;
	}




	public TestLaneDetails() {
		
	}




	public TestLaneDetails(String testLaneDetailsid, String eqTypeid,
			String eqMakeID, String eqModelID, EquipmentMaster equipmentID,  
			CenterMaster centerID, Test_type testType) {
		super();
		this.testLaneDetailsid = testLaneDetailsid;
		this.eqTypeid = eqTypeid;
		this.eqMakeID = eqMakeID;
		this.eqModelID = eqModelID;
		this.equipmentID = equipmentID;
		this.centerID = centerID;
		this.testType = testType;
	}

	
}
