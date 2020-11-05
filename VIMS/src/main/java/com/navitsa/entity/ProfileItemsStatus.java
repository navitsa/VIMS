package com.navitsa.entity;

import java.io.IOException;
import java.util.Base64;

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

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="v_profile_item_status")
public class ProfileItemsStatus {
	
	@Id
	@NotEmpty(message = "Required")
	@Column(name ="V_Profile_Item_Status_ID")
	private String profileItemStatusID;
	
	@NotEmpty(message = "Select a Profile")
	@Column(name ="Visual_Profile_ID")
	private String visualprofileID;
	
	@NotEmpty(message = "Select a Stage")
	@Column(name ="Visual_Profile_Stage_ID")
	private String visualProfileStageID;
	
	@NotEmpty(message = "Please enter a Item Status")
	//@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Special Characters Not Allowed")
	@Column(name="V_Profile_Item_Status")
	private String vprofileItemStatus;
	
	@NotEmpty(message = "Please enter the serial no")
	@Pattern(regexp="^([a-zA-Z0-9.]+$)?",message="Invalid serial number !")
	@Column(name="Status_Serial_No")
	private String statusSerialNo;
	
	@Column(name = "Status_Mark")
	private byte[] statusMark;
	
	@NotNull(message = "Required")
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Visual_Profile_Item_ID",referencedColumnName = "Visual_Profile_Item_ID")
	private VisualProfileItems item;


	public ProfileItemsStatus() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProfileItemsStatus(String profileItemStatusID, String visualprofileID, String visualProfileStageID,
			String vprofileItemStatus, String statusSerialNo, MultipartFile statusMark, VisualProfileItems item) throws IOException {
		super();
		this.profileItemStatusID = profileItemStatusID;
		this.visualprofileID = visualprofileID;
		this.visualProfileStageID = visualProfileStageID;
		this.vprofileItemStatus = vprofileItemStatus;
		this.statusSerialNo = statusSerialNo;
		this.statusMark = statusMark.getBytes();
		this.item = item;
	}


	public String getProfileItemStatusID() {
		return profileItemStatusID;
	}


	public void setProfileItemStatusID(String profileItemStatusID) {
		this.profileItemStatusID = profileItemStatusID;
	}


	public String getVisualprofileID() {
		return visualprofileID;
	}


	public void setVisualprofileID(String visualprofileID) {
		this.visualprofileID = visualprofileID;
	}


	public String getVisualProfileStageID() {
		return visualProfileStageID;
	}


	public void setVisualProfileStageID(String visualProfileStageID) {
		this.visualProfileStageID = visualProfileStageID;
	}


	public String getVprofileItemStatus() {
		return vprofileItemStatus;
	}


	public void setVprofileItemStatus(String vprofileItemStatus) {
		this.vprofileItemStatus = vprofileItemStatus;
	}


	public String getStatusSerialNo() {
		return statusSerialNo;
	}


	public void setStatusSerialNo(String statusSerialNo) {
		this.statusSerialNo = statusSerialNo;
	}


	public byte[] getStatusMark() {
		return statusMark;
	}


	public void setStatusMark(MultipartFile statusMark) throws IOException {
		
		if(statusMark.isEmpty())
		{
			this.statusMark = null;
		}
		else {
			this.statusMark = statusMark.getBytes();
			}
	}


	public VisualProfileItems getItem() {
		return item;
	}


	public void setItem(VisualProfileItems item) {
		this.item = item;
	}
	
	public String getStatusMarkView() {
		return Base64.getEncoder().encodeToString(this.statusMark);
	}

}
