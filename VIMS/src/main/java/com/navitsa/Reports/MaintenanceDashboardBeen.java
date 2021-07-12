package com.navitsa.Reports;

import java.time.LocalDateTime;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.navitsa.entity.Users;

public class MaintenanceDashboardBeen {

	private int totcal;
	private String calib;
	private String totSer;
	private String ser;
	private int totTicket;
	private int openTicket;
	private int closeticket;
	private String lane;
	private int serover;
	private int ser60;
	private int ser30;
	private int cali60;
	private int cali30;
	

	
	
	public int getSerover() {
		return serover;
	}
	public void setSerover(int serover) {
		this.serover = serover;
	}
	public int getSer60() {
		return ser60;
	}
	public void setSer60(int ser60) {
		this.ser60 = ser60;
	}
	public int getSer30() {
		return ser30;
	}
	public void setSer30(int ser30) {
		this.ser30 = ser30;
	}
	public int getCali30() {
		return cali30;
	}
	public void setCali30(int cali30) {
		this.cali30 = cali30;
	}
	public int getCali60() {
		return cali60;
	}
	public void setCali60(int due60cali) {
		this.cali60 = due60cali;
	}
	
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	public int getTotcal() {
		return totcal;
	}
	public void setTotcal(int overduecali) {
		this.totcal = overduecali;
	}
	public String getCalib() {
		return calib;
	}
	public void setCalib(String calib) {
		this.calib = calib;
	}
	public String getTotSer() {
		return totSer;
	}
	public void setTotSer(String totSer) {
		this.totSer = totSer;
	}
	public String getSer() {
		return ser;
	}
	public void setSer(String ser) {
		this.ser = ser;
	}
	public int getTotTicket() {
		return totTicket;
	}
	public void setTotTicket(int issueTickets) {
		this.totTicket = issueTickets;
	}
	public int getOpenTicket() {
		return openTicket;
	}
	public void setOpenTicket(int i) {
		this.openTicket = i;
	}
	public int getCloseticket() {
		return closeticket;
	}
	public void setCloseticket(int closeTickets) {
		this.closeticket = closeTickets;
	}

	
	
	
}
