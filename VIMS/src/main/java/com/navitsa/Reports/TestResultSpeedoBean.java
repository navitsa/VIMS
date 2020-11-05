package com.navitsa.Reports;

public class TestResultSpeedoBean {

	private String value1;
	private double value2;
	private double value3;
	private String value4;
	private double value5;
	private double value6;
	private String limitDes;
	
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public double getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		if(value2 != null)
			this.value2 = Double.parseDouble(value2);
	}
	public double getValue3() {
		return value3;
	}
	public void setValue3(String value3) {
		if(value3 != null)
			this.value3 = Double.parseDouble(value3);
	}
	public String getValue4() {
		return value4;
	}
	public void setValue4(String value4) {
		this.value4 = value4;
	}
	public double getValue5() {
		return value5;
	}
	public void setValue5(String value5) {
		if(value5 != null)
			this.value5 = Double.parseDouble(value5);
	}
	public double getValue6() {
		return value6;
	}
	public void setValue6(String value6) {
		if(value6 != null)
			this.value6 = Double.parseDouble(value6);
	}
	public String getLimitDes() {
		return limitDes;
	}
	public void setLimitDes(String limitDes) {
		this.limitDes = limitDes;
	}

}
