package com.navitsa.entity;

import java.util.List;

public class TestProfileStatusJsonRespone {

	private List<TestProfileStatus> profile_status_list;
	private int success;
	

	public List<TestProfileStatus> getProfile_status_list() {
		return profile_status_list;
	}
	public void setProfile_status_list(List<TestProfileStatus> profile_status_list) {
		this.profile_status_list = profile_status_list;
	}
	
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	
	
}
