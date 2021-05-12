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
	
	@Column(name = "ES_IN")
	private String mahaES_IN;
	
	@Column(name = "ES_OUT")
	private String mahaES_OUT;
	
	@Column(name = "AVL_PC_IP")
	private String avlPcIp;
	
	@Column(name = "XML_IN")
	private String xmlIN;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Center_ID" , referencedColumnName="Center_ID" )
	private CenterMaster centerID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Lane_ID" , referencedColumnName="Lane_ID" )
	TestLane laneID;

	@Column(name = "LaneCap")
	private String laneCap;
	
	@Column(name = "Maha_FT_U_Name")
	private String mahaFTPUs;
	
	@Column(name = "Maha_FT_pwd")
	private String mahaFTPPass;
	
	@Column(name = "AVL_FT_U_Name")
	private String avlFTPUs;
	
	@Column(name = "AVL_FT_Pwd")
	private String avlFTPPass;
	
	@Column(name = "Maha_F_Status")
	private String mahaFstatus;
	
	@Column(name = "AVL_F_Status")
	private String avlFstatus;

	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name="GateID" , referencedColumnName="GateID" )
	private Gate gateID;
	
	
	public String getMahaES_IN() {
		return mahaES_IN;
	}

	public void setMahaES_IN(String mahaES_IN) {
		this.mahaES_IN = mahaES_IN;
	}

	public String getMahaES_OUT() {
		return mahaES_OUT;
	}

	public void setMahaES_OUT(String mahaES_OUT) {
		this.mahaES_OUT = mahaES_OUT;
	}

	public String getXmlIN() {
		return xmlIN;
	}

	public void setXmlIN(String xmlIN) {
		this.xmlIN = xmlIN;
	}

	public String getMahaFstatus() {
		return mahaFstatus;
	}

	public void setMahaFstatus(String mahaFstatus) {
		this.mahaFstatus = mahaFstatus;
	}

	public String getAvlFstatus() {
		return avlFstatus;
	}

	public void setAvlFstatus(String avlFstatus) {
		this.avlFstatus = avlFstatus;
	}

	public String getMahaFTPUs() {
		return mahaFTPUs;
	}

	public void setMahaFTPUs(String mahaFTPUs) {
		this.mahaFTPUs = mahaFTPUs;
	}

	public String getMahaFTPPass() {
		return mahaFTPPass;
	}

	public void setMahaFTPPass(String mahaFTPPass) {
		this.mahaFTPPass = mahaFTPPass;
	}

	public String getAvlFTPUs() {
		return avlFTPUs;
	}

	public void setAvlFTPUs(String avlFTPUs) {
		this.avlFTPUs = avlFTPUs;
	}

	public String getAvlFTPPass() {
		return avlFTPPass;
	}

	public void setAvlFTPPass(String avlFTPPass) {
		this.avlFTPPass = avlFTPPass;
	}

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

	public String getAvlPcIp() {
		return avlPcIp;
	}

	public void setAvlPcIp(String avlPcIp) {
		this.avlPcIp = avlPcIp;
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
		this.mahaPcIp = mahaPcIp;	
		this.avlPcIp = avlPcIp;
	}
	
}
