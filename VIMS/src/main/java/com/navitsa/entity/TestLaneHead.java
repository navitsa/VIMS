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
	
	@Column(name = "Maha_PC_IP")
	private String mahaPcIp;
	
	@Column(name = "Maha_FTP_Path")
	private String mahaFtpPath;
	
	@Column(name = "AVL_PC_IP")
	private String avlPcIp;
	
	@Column(name = "AVL_FTP_Path")
	private String avlFtpPath;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Center_ID" , referencedColumnName="Center_ID" )
	private CenterMaster centerID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Lane_ID" , referencedColumnName="Lane_ID" )
	TestLane laneID;

	@Column(name = "LaneCap")
	private String laneCap;
	

	@ManyToOne(optional = true,fetch = FetchType.EAGER)
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


	public String getMahaPcIp() {
		return mahaPcIp;
	}

	public void setMahaPcIp(String mahaPcIp) {
		this.mahaPcIp = mahaPcIp;
	}

	public String getMahaFtpPath() {
		return mahaFtpPath;
	}

	public void setMahaFtpPath(String mahaFtpPath) {
		this.mahaFtpPath = mahaFtpPath;
	}

	public String getAvlPcIp() {
		return avlPcIp;
	}

	public void setAvlPcIp(String avlPcIp) {
		this.avlPcIp = avlPcIp;
	}

	public String getAvlFtpPath() {
		return avlFtpPath;
	}

	public void setAvlFtpPath(String avlFtpPath) {
		this.avlFtpPath = avlFtpPath;
	}

	public Gate getGateID() {
		return gateID;
	}

	public void setGateID(Gate gateID) {
		this.gateID = gateID;
	}

	public TestLaneHead() {	
	}

	public TestLaneHead(String testLaneHeadId, String laneName, String status, String remark, CenterMaster centerID,
			TestLane laneID, String laneCap, String mahaPcIp, String mahaFtpPath, String avlPcIp, String avlFtpPath) {
		super();
		this.testLaneHeadId = testLaneHeadId;
		this.laneName = laneName;
		this.status = status;
		this.remark = remark;
		this.centerID = centerID;
		this.laneID = laneID;
		this.laneCap = laneCap;
	
		this.avlFtpPath = avlFtpPath;
		this.mahaPcIp = mahaPcIp;
		this.mahaFtpPath = mahaFtpPath;
		this.avlPcIp = avlPcIp;
	}
	
}
