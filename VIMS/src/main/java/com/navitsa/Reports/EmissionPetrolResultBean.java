package com.navitsa.Reports;

import com.navitsa.entity.EmissionPetrolCertificateData;
import com.navitsa.entity.EmissionPetrolCertificateGas;
import com.navitsa.entity.EmissionPetrolCertificateLembda;
import com.navitsa.entity.EmissionPetrolCertificatePetrol;

public class EmissionPetrolResultBean {

	private EmissionPetrolCertificateData empcdata;
	
	private EmissionPetrolCertificateGas empcgas;
	
	private EmissionPetrolCertificateLembda empclambda;
	
	private EmissionPetrolCertificatePetrol empcpetrol;

	public EmissionPetrolResultBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmissionPetrolResultBean(EmissionPetrolCertificateData empcdata, EmissionPetrolCertificateGas empcgas,
			EmissionPetrolCertificateLembda empclambda, EmissionPetrolCertificatePetrol empcpetrol) {
		super();
		this.empcdata = empcdata;
		this.empcgas = empcgas;
		this.empclambda = empclambda;
		this.empcpetrol = empcpetrol;
	}

	public EmissionPetrolCertificateData getEmpcdata() {
		return empcdata;
	}

	public void setEmpcdata(EmissionPetrolCertificateData empcdata) {
		this.empcdata = empcdata;
	}

	public EmissionPetrolCertificateGas getEmpcgas() {
		return empcgas;
	}

	public void setEmpcgas(EmissionPetrolCertificateGas empcgas) {
		this.empcgas = empcgas;
	}

	public EmissionPetrolCertificateLembda getEmpclambda() {
		return empclambda;
	}

	public void setEmpclambda(EmissionPetrolCertificateLembda empclambda) {
		this.empclambda = empclambda;
	}

	public EmissionPetrolCertificatePetrol getEmpcpetrol() {
		return empcpetrol;
	}

	public void setEmpcpetrol(EmissionPetrolCertificatePetrol empcpetrol) {
		this.empcpetrol = empcpetrol;
	}
	
}
