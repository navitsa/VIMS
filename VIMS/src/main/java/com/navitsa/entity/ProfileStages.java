package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "visual_profile_stages")
public class ProfileStages {
	
	@Id
	@NotEmpty
	@Column(name="Visual_Profile_Stage_ID")
	private String stageID;

	@NotEmpty(message = "Please enter the serial no")
	@Pattern(regexp="^([a-zA-Z0-9.]+$)?",message="Invalid serial number !")
	@Column(name="Stage_Serial_No")
	private String stageNo;
	
	@NotEmpty(message = "Please enter a stage")
	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9")	
	@Column(name="Stage")
	private String stage;
	
	@NotNull
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Visual_Profile_ID",referencedColumnName = "Visual_Profile_ID")
	private VisualProfile vp;

	public ProfileStages(String stageID, String stageNo, String stage, VisualProfile vp) {
		super();
		this.stageID = stageID;
		this.stageNo = stageNo;
		this.stage = stage;
		this.vp = vp;
	}

	public ProfileStages() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStageID() {
		return stageID;
	}

	public void setStageID(String stageID) {
		this.stageID = stageID;
	}

	public String getStageNo() {
		return stageNo;
	}

	public void setStageNo(String stageNo) {
		this.stageNo = stageNo;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public VisualProfile getVp() {
		return vp;
	}

	public void setVp(VisualProfile vp) {
		this.vp = vp;
	}

	@Override
	public String toString() {
		return "ProfileStages [stageID=" + stageID + ", stageNo=" + stageNo + ", stage=" + stage + ", vp=" + vp + "]";
	}
	
}
