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
@Table(name="configsystem")
public class ConfigSystem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")	
	private String  id;

	@Column(name="ipaddress")	
	private String  ipaddress;
	
	@Column(name="userName")	
	private String  userName;
	
	@Column(name="password")	
	private String  password;
	
	@Column(name="port")	
	private String  port;
	
	@Column(name="ftp_esin")	
	private String  rootPath;
	
	@Column(name="ftp_esout")	
	private String  ftpEsOut;
	
	@Column(name="xmlPath")	
	private String  xmlPath;
	
	@Column(name="type")	
	private String  type;	
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="Center_ID",referencedColumnName ="Center_ID")
	private CenterMaster centermaster;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="testLaneHead_Id" , referencedColumnName="testLaneHead_Id")
	private TestLaneHead testLaneHeadId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public CenterMaster getCentermaster() {
		return centermaster;
	}

	public void setCentermaster(CenterMaster centermaster) {
		this.centermaster = centermaster;
	}

	public String getXmlPath() {
		return xmlPath;
	}


	public void setXmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
	}
	
	public TestLaneHead getTestLaneHeadId() {
		return testLaneHeadId;
	}

	public void setTestLaneHeadId(TestLaneHead testLaneHeadId) {
		this.testLaneHeadId = testLaneHeadId;
	}

	public String getFtpEsOut() {
		return ftpEsOut;
	}

	public void setFtpEsOut(String ftpEsOut) {
		this.ftpEsOut = ftpEsOut;
	}
	
}
