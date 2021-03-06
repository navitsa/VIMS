package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="test_lane_head")
public class TestLaneHead {

	@Id
	@Column(name="testLaneHead_Id")
	private String testLaneHeadId;
	
	@Column(name="Lane_Name")
	private String laneName;
	
	@Column(name = "Current_Status")
	private String status;
	
	@Column(name = "Remarks")
	private String remark;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Center_ID" , referencedColumnName="Center_ID" )
	private CenterMaster centerID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Lane_ID" , referencedColumnName="Lane_ID" )
	TestLane laneID;

	@Column(name = "LaneCap")
	private String laneCap;
	
	@Column(name = "Avl_Path")
	private String avlPath;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="GateID" , referencedColumnName="GateID" )
	private Gate gateID;
	
	public String getTestLaneHeadId() {
		return testLaneHeadId;
	}

	public void setTestLaneHeadId(String testLaneHeadId) {
		this.testLaneHeadId = testLaneHeadId;
	}

	public String getLaneName() {
		return laneName;
	}

	public void setLaneName(String laneName) {
		this.laneName = laneName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public CenterMaster getCenterID() {
		return centerID;
	}

	public void setCenterID(CenterMaster centerID) {
		this.centerID = centerID;
	}


	public String getLaneCap() {
		return laneCap;
	}

	public void setLaneCap(String laneCap) {
		this.laneCap = laneCap;
	}

	
	public TestLane getLaneID() {
		return laneID;
	}

	public void setLaneID(TestLane laneID) {
		this.laneID = laneID;
	}

	public String getAvlPath() {
		return avlPath;
	}

	public void setAvlPath(String avlPath) {
		this.avlPath = avlPath;
	}

	public TestLaneHead() {	
	}

	public TestLaneHead(String testLaneHeadId, String laneName, String status, String remark, CenterMaster centerID,
			TestLane laneID, String laneCap, String avlPath) {
		super();
		this.testLaneHeadId = testLaneHeadId;
		this.laneName = laneName;
		this.status = status;
		this.remark = remark;
		this.centerID = centerID;
		this.laneID = laneID;
		this.laneCap = laneCap;
		this.avlPath = avlPath;
	}
	
}
