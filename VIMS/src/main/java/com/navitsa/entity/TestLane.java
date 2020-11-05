package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "test_lanes")
public class TestLane {
	@Id
	@Column(name = "Lane_ID")
	String laneId;

	@Size(min=1, message="Required Lane")
	@Column(name = "Lane")
	String lane;
	
	@Column(name = "Current_Status")
	String status;
	
	@Column(name = "Remarks")
	String remark;

	
	public String getLaneId() {
		return laneId;
	}

	public void setLaneId(String laneId) {
		this.laneId = laneId;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
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

	public TestLane() {
	}

	public TestLane(String laneId, String lane, String status, String remark) {
		this.laneId = laneId;	
		this.lane = lane;
		this.status = status;
		this.remark = remark;
	}

	public TestLane(String laneId) {
		this.laneId = laneId;
	}
	
	
	
	
	
	
}
