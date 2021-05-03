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

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@Column(name ="userId")
	private String userId;
	
	@Column(name ="empId")
	private String empId;
		
	@Column(name ="password")
	private String password;
	
	@Column(name ="userName")
	private String userName;
	
//	@Column(name = "createdDate")
//	private String createdDate;

//	@Column(name ="expireDate")
//	private String expireDate;
	
	@ManyToOne(optional = true,fetch = FetchType.EAGER)
	@JoinColumn(name ="center_ID" , referencedColumnName="Center_ID")
	private CenterMaster center_ID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name ="level_ID" , referencedColumnName="level_ID")
	private UserLevel ulid;
	
	@Column(name= "user_Img")
	private byte[] user_Img;
	
	@Column(name ="login")
	private String login;
	
	@Column(name = "Status")
	private String status;
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Users() {}

	public Users(String userId) {
	
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getCreatedDate() {
//		return this.createdDate;
//	}
//
//	public void setCreatedDate(String createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	public String getExpireDate() {
//		return this.expireDate;
//	}
//
//	public void setExpireDate(String expireDate) {
//		this.expireDate = expireDate;
//	}

	public UserLevel getUlid() {
		return ulid;
	}

	public void setUlid(UserLevel ulid) {
		this.ulid = ulid;
	}

	public String getuser_ImgView() {
		return Base64.getEncoder().encodeToString(this.user_Img);
	}
	
	public byte[] getUser_Img() {
		return user_Img;
	}

	public void setUser_Img(MultipartFile user_Img) throws IOException {
	
		if(user_Img.isEmpty()) {
			user_Img = null;
		}
		else {
			this.user_Img = user_Img.getBytes();
		}
	}
	

	public Users(String userId, String empId, String password, String userName,
			 UserLevel ulid, MultipartFile user_Img) throws IOException {
		super();
		this.userId = userId;
		this.empId = empId;
		this.password = password;
		this.userName = userName;
		this.ulid = ulid;
		this.user_Img = user_Img.getBytes();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center_ID == null) ? 0 : center_ID.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((ulid == null) ? 0 : ulid.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		if(result<0) {
			return result*-1;
		}else {
			return result;	
			
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (center_ID == null) {
			if (other.center_ID != null)
				return false;
		} else if (!center_ID.equals(other.center_ID))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (ulid == null) {
			if (other.ulid != null)
				return false;
		} else if (!ulid.equals(other.ulid))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	public CenterMaster getCenter_ID() {
		return center_ID;
	}

	public void setCenter_ID(CenterMaster center_ID) {
		this.center_ID = center_ID;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	
}
	