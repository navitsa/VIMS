package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gate")
public class Gate {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GateID")	
	private String gateID;
	
	@Column(name="GateName")	
	private String gateName;
	
	@Column(name="GatePath")	
	private String gatePath;
	
	@Column(name="GateIP")	
	private String gateIP;
	
	@Column(name="CameraIP")	
	private String cameraIP;

	public String getGateID() {
		return gateID;
	}

	public void setGateID(String gateID) {
		this.gateID = gateID;
	}

	public String getGateName() {
		return gateName;
	}

	public void setGateName(String gateName) {
		this.gateName = gateName;
	}

	public String getGatePath() {
		return gatePath;
	}

	public void setGatePath(String gatePath) {
		this.gatePath = gatePath;
	}

	public String getGateIP() {
		return gateIP;
	}

	public void setGateIP(String gateIP) {
		this.gateIP = gateIP;
	}

	public String getCameraIP() {
		return cameraIP;
	}

	public void setCameraIP(String cameraIP) {
		this.cameraIP = cameraIP;
	}
	
	
}
