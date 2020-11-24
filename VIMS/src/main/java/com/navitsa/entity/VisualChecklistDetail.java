package com.navitsa.entity;

import java.io.IOException;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.navitsa.utils.ImageResizer;

@Entity
@Table(name = "visual_checklist_details")
public class VisualChecklistDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idvisual_checklist_details")
	private int cheklistDetail_ID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Visual_Checklist_ID",referencedColumnName = "Visual_Checklist_ID")
	private VisualChecklistMaster vcm;
	
	//@Column(name="Visual_Checklist_ID")
	//private String cheklistID;
	
	@Column(name="Partner_ID")
	private String partnerID;// default ekk set krala yawnne
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Visual_Profile_Stage_ID",referencedColumnName = "Visual_Profile_Stage_ID")
	//private String stageID;
	private ProfileStages stage;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Visual_Profile_Item_ID",referencedColumnName = "Visual_Profile_Item_ID")
	//private String itemID;
	private VisualProfileItems item;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "V_Profile_Item_Status_ID",referencedColumnName = "V_Profile_Item_Status_ID")
	//private String statusID;
	private ProfileItemsStatus status;
	
	@Column(name="Status")
	private String statusName;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "Item_Status_Remarks_ID",referencedColumnName = "Item_Status_Remarks_ID")
	//private String remakID;
	private ItemRemarks remark;
	
	@Column(name="Remark")
	private String remarkName;
	
	@Column(name = "image")
	byte[] image;

	public VisualChecklistDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VisualChecklistDetail(int cheklistDetail_ID, VisualChecklistMaster vcm, String partnerID,
			ProfileStages stage, VisualProfileItems item, ProfileItemsStatus status, String statusName,
			ItemRemarks remark, String remarkName,MultipartFile image) throws IOException {
		super();
		this.cheklistDetail_ID = cheklistDetail_ID;
		this.vcm = vcm;
		this.partnerID = partnerID;
		this.stage = stage;
		this.item = item;
		this.status = status;
		this.statusName = statusName;
		this.remark = remark;
		this.remarkName = remarkName;
		this.image = image.getBytes();
	}

	public int getCheklistDetail_ID() {
		return cheklistDetail_ID;
	}

	public void setCheklistDetail_ID(int cheklistDetail_ID) {
		this.cheklistDetail_ID = cheklistDetail_ID;
	}

	public VisualChecklistMaster getVcm() {
		return vcm;
	}

	public void setVcm(VisualChecklistMaster vcm) {
		this.vcm = vcm;
	}

	public String getPartnerID() {
		return partnerID;
	}

	public void setPartnerID(String partnerID) {
		this.partnerID = partnerID;
	}

	public ProfileStages getStage() {
		return stage;
	}

	public void setStage(ProfileStages stage) {
		this.stage = stage;
	}

	public VisualProfileItems getItem() {
		return item;
	}

	public void setItem(VisualProfileItems item) {
		this.item = item;
	}

	public ProfileItemsStatus getStatus() {
		return status;
	}

	public void setStatus(ProfileItemsStatus status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public ItemRemarks getRemark() {
		return remark;
	}

	public void setRemark(ItemRemarks remark) {
		this.remark = remark;
	}

	public String getRemarkName() {
		return remarkName;
	}

	public void setRemarkName(String remarkName) {
		this.remarkName = remarkName;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(MultipartFile image) throws IOException {
		//ImageResizer obj = new ImageResizer();
		//obj.resize(image);
		if(image.isEmpty())
		{
			this.image = null;
		}
		else {
			this.image = image.getBytes();
		}
	}
	
	public String getImageView() {
		return Base64.getEncoder().encodeToString(this.image);
	}

}
