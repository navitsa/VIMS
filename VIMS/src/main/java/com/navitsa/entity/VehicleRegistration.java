package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="vehicle_registration")
public class VehicleRegistration {
	
	@Id
	@Column(name="V_Register_ID")
	private String vregID;
	
	@Column(name="CurrentMilage")
	private Long currentMilage;
	
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name="vtime")
	private String time;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@Column(name="date")
	private String date;
	
	@Column(name="Vi_Test")
	private String viTestStatus;
	
	@Column(name="Test_Status")
	private String testStatus;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "testLaneHead_Id", referencedColumnName = "testLaneHead_Id")
	private TestLaneHead testLaneHeadId;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "TR_ID", referencedColumnName = "TR_ID")
	private Transaction trid;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Vehicle_ID" , referencedColumnName="Vehicle_ID")
	private VehicleMaster  vid;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="V_Register_Type_ID", referencedColumnName ="V_Register_Type_ID")
	private VehicleRegisterType vtype;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="userId", referencedColumnName ="userId")
	private Users user;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Center_ID",referencedColumnName ="Center_ID")
	private CenterMaster centermaster;

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Category_Id", referencedColumnName ="Category_Id")
	private TestCategory testCategory;

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "cusid",referencedColumnName = "id")
	private Customer cusid;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "ocrid",referencedColumnName = "ocrid")
	private OcrDetails ocrid;
	
	@Column(name="payType")
	private String payType;
	
	@Column(name="Status")
	private String status;
	
	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public VehicleRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleRegistration(String vregID, Long currentMilage, String time, String date, String viTestStatus,
			String testStatus, TestLaneHead testLaneHeadId, Transaction trid, VehicleMaster vid, VehicleRegisterType vtype,
			Users user, CenterMaster centermaster, TestCategory testCategory,Customer cusid) {
		super();
		this.vregID = vregID;
		this.currentMilage = currentMilage;
		this.time = time;
		this.date = date;
		this.viTestStatus = viTestStatus;
		this.testStatus = testStatus;
		this.testLaneHeadId = testLaneHeadId;
		this.trid = trid;
		this.vid = vid;
		this.vtype = vtype;
		this.user = user;
		this.centermaster = centermaster;
		this.testCategory = testCategory;
		this.cusid=cusid;
	}

	public String getVregID() {
		return vregID;
	}

	public void setVregID(String vregID) {
		this.vregID = vregID;
	}

	public Long getCurrentMilage() {
		return currentMilage;
	}

	public void setCurrentMilage(Long currentMilage) {
		this.currentMilage = currentMilage;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getViTestStatus() {
		return viTestStatus;
	}

	public void setViTestStatus(String viTestStatus) {
		this.viTestStatus = viTestStatus;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	public TestLaneHead getTestLaneHeadId() {
		return testLaneHeadId;
	}

	public void setTestLaneHeadId(TestLaneHead testLaneHeadId) {
		this.testLaneHeadId = testLaneHeadId;
	}

	public Transaction getTrid() {
		return trid;
	}

	public void setTrid(Transaction trid) {
		this.trid = trid;
	}

	public VehicleMaster getVid() {
		return vid;
	}

	public void setVid(VehicleMaster vid) {
		this.vid = vid;
	}

	public VehicleRegisterType getVtype() {
		return vtype;
	}

	public void setVtype(VehicleRegisterType vtype) {
		this.vtype = vtype;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public CenterMaster getCentermaster() {
		return centermaster;
	}

	public void setCentermaster(CenterMaster centermaster) {
		this.centermaster = centermaster;
	}

	public TestCategory getTestCategory() {
		return testCategory;
	}

	public void setTestCategory(TestCategory testCategory) {
		this.testCategory = testCategory;
	}

	public Customer getCusid() {
		return cusid;
	}

	public void setCusid(Customer cusid) {
		this.cusid = cusid;
	}

	public OcrDetails getOcrid() {
		return ocrid;
	}

	public void setOcrid(OcrDetails ocrid) {
		this.ocrid = ocrid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
