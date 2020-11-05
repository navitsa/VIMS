package com.navitsa.entity;

public class AppointmentTime {
	
	String[] allTimeSlots;
	
	String[] bookedTimes;

	public String[] getAllTimeSlots() {
		return allTimeSlots;
	}

	public void setAllTimeSlots(String[] allTimeSlots) {
		this.allTimeSlots = allTimeSlots;
	}

	public String[] getBookedTimes() {
		return bookedTimes;
	}

	public void setBookedTimes(String[] bookedTimes) {
		this.bookedTimes = bookedTimes;
	}

}
