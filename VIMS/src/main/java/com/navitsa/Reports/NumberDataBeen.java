package com.navitsa.Reports;

import java.util.Base64;

import javax.persistence.Column;

public class NumberDataBeen {

	private int id;
	private String number;
	private String noimage;
	private byte[] bytimage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNoimage() {
		return noimage;
	}
	public void setNoimage(String noimage) {
		this.noimage = noimage;
	}
	public byte[] getBytimage() {
		return bytimage;
	}
	public void setBytimage(byte[] bytimage) {
		this.bytimage = bytimage;
	}

	
}
