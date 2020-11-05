package com.navitsa.entity;
import java.io.IOException;
import java.util.Arrays;
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
@Table(name="visual_profile_items")
public class VisualProfileItems {
	
	@Id
	@NotEmpty
	@Column(name = "Visual_Profile_Item_ID")
	private String itemId;

	@NotEmpty(message = "Please enter a item name")
	@Pattern(regexp="^([a-zA-Z0-9/ ]+$)?",message="Allowed Characters: a-z, A-Z, 0-9, /")
	@Column(name = "Visual_Profile_Item")
	private String itemName;
	
	@NotEmpty(message = "Please enter the serial no")
	@Pattern(regexp="^([a-zA-Z0-9.]+$)?",message="Invalid serial number !")
	@Column(name = "Item_Serial_No")
	private String serialNo;
	
	@Column(name = "image")
	byte[] itemImage;
	
	@NotEmpty(message = "Select a profile")
	@Column(name="Visual_Profile_ID")
	private String profile;
	
	@NotNull
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Visual_Profile_Stage_ID",referencedColumnName = "Visual_Profile_Stage_ID")
	private ProfileStages stage;
	
	//private String itemImageView;

	public VisualProfileItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VisualProfileItems(String itemId, String itemName, String serialNo, MultipartFile itemImage, String profile,
			ProfileStages stage) throws IOException{
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.serialNo = serialNo;
		this.itemImage = itemImage.getBytes();
		this.profile = profile;
		this.stage = stage;
	
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public ProfileStages getStage() {
		return stage;
	}

	public void setStage(ProfileStages stage) {
		this.stage = stage;
	}

	public byte[] getItemImage() {
		return itemImage;
	}

	public void setItemImage(MultipartFile itemImage) throws IOException {
		
		if(itemImage.isEmpty())
		{
			this.itemImage = null;
		}
		else {
			this.itemImage = itemImage.getBytes();
			}
		
	}
	
	public String getItemImageView() {
		return Base64.getEncoder().encodeToString(this.itemImage);
	}

	@Override
	public String toString() {
		return "VisualProfileItems [itemId=" + itemId + ", itemName=" + itemName + ", serialNo=" + serialNo
				+ ", itemImage=" + Arrays.toString(itemImage) + ", profile=" + profile + ", stage=" + stage + "]";
	}

}
