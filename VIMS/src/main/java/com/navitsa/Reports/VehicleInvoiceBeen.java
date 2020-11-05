package com.navitsa.Reports;

public class VehicleInvoiceBeen {

	private String description;
	private double rate;
	private double amount;
	private boolean style;
	private String type;
	private String currency;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isStyle() {
		return style;
	}
	public void setStyle(boolean style) {
		this.style = style;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
