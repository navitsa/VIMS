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
@Table(name = "items_status_remarks")
public class ItemRemarks {
	
	@Id
	@NotEmpty(message = "Required")
	@Column(name = "Item_Status_Remarks_ID")
	private String remarksID;

	@NotEmpty(message = "Select a profile")
	@Column(name = "Visual_Profile_ID")
	private String profileID;
	
	@NotEmpty(message = "Select a stage")
	@Column(name = "Visual_Profile_Stage_ID")
	private String stage;
	
	@NotEmpty(message = "Select an item")
	@Column(name="Visual_Profile_Item_ID")
	private String itemID;
	
	@NotEmpty(message = "Please enter the serial no")
	@Pattern(regexp="^([a-zA-Z0-9.]+$)?",message="Invalid serial number !")
	@Column(name="Remark_Serial_No")
	private String serialNo;
	
	@NotEmpty(message = "Please enter a remark")
	//@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Special Characters Not Allowed")
	@Column(name="Item_Status_Remarks")
	private String remarks;
	
	@NotNull(message = "required")
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "V_Profile_Item_Status_ID",referencedColumnName = "V_Profile_Item_Status_ID")
	private ProfileItemsStatus is;

	public ItemRemarks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemRemarks(String remarksID, String profileID, String stage, String itemID, String serialNo, String remarks,
			ProfileItemsStatus is) {
		super();
		this.remarksID = remarksID;
		this.profileID = profileID;
		this.stage = stage;
		this.itemID = itemID;
		this.serialNo = serialNo;
		this.remarks = remarks;
		this.is = is;
	}

	public String getRemarksID() {
		return remarksID;
	}

	public void setRemarksID(String remarksID) {
		this.remarksID = remarksID;
	}

	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ProfileItemsStatus getIs() {
		return is;
	}

	public void setIs(ProfileItemsStatus is) {
		this.is = is;
	}
}
