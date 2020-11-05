package com.navitsa.entity;

import java.io.IOException;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="test_type")
public class Test_type {

	@Id
	@Column(name ="type_id")
	private String typeId;
	
	@NotEmpty(message = "Enter a valid Test Type")
	@Pattern(regexp="^([a-zA-Z0-9 ]+$)?",message="Special Characters Not Allowed")
	@Column(name ="test_type")
	private String type;
	
	@Column(name ="remarks")
	private String remarks;
	
	@Column(name = "image")
	private byte[] image;
	
	@Column(name ="evaluation_code")
	private String evaluationCode;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Test_type() {
		super();
	}
	
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Test_type(String typeId) {
		this.typeId = typeId;
	}

	public Test_type(String typeId, String type) {
		
		this.typeId = typeId;
		this.type = type;
	}

	public Test_type(String typeId,String type, String remarks, MultipartFile image, String evaluationCode ) throws IOException {
		super();
		this.typeId = typeId;
		this.type = type;
		this.remarks = remarks;
		this.image = image.getBytes();
		this.evaluationCode = evaluationCode;
	}
	
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(MultipartFile image) throws IOException {
		
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

	public String getEvaluationCode() {
		return evaluationCode;
	}

	public void setEvaluationCode(String evaluationCode) {
		this.evaluationCode = evaluationCode;
	}
	
}
