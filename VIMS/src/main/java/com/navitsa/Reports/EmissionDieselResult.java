package com.navitsa.Reports;

import java.util.List;

import com.navitsa.entity.EmissionDieselCertificateData;
import com.navitsa.entity.EmissionDieselCertificateReadings;

public class EmissionDieselResult {
	private EmissionDieselCertificateData edcd; 
	private List<EmissionDieselCertificateReadings> list ;

	public EmissionDieselResult(EmissionDieselCertificateData edcd, List<EmissionDieselCertificateReadings> list) 
    { 
    	this.edcd = edcd; 
    	this.list = list;
    }

	public EmissionDieselCertificateData getEdcd() {
		return edcd;
	}

	public void setEdcd(EmissionDieselCertificateData edcd) {
		this.edcd = edcd;
	}

	public List<EmissionDieselCertificateReadings> getList() {
		return list;
	}

	public void setList(List<EmissionDieselCertificateReadings> list) {
		this.list = list;
	}
		
}
