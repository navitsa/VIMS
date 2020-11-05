package com.navitsa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.EmissionPetrolCertificateGas;

public interface EmissionPetrolCertificateGasRepo extends CrudRepository<EmissionPetrolCertificateGas, String> {

	@Query(value = "SELECT g FROM EmissionPetrolCertificateGas g WHERE g.id_no.id_no =:id_no")
	public EmissionPetrolCertificateGas getEmiPetrolCerGas(@Param("id_no") String id_no);

	@Transactional
	@Modifying
	@Query(value="INSERT INTO emission_petrol_certificate_gas (id_no,pres_co,pres_hc,co,hc,co2,o2,nox,lembda,rpm)\n" + 
			"SELECT ID_NO,Gas_Pres_CO,Gas_Pres_HC,Gas_Pretuned_CO,Gas_Pretuned_HC,Gas_Pretuned_CO2,Gas_Pretuned_O2,Gas_Pretuned_NOX,Gas_Pretuned_LEMBDA,Gas_Pretuned_RPM FROM ept_certificate_gas\n" + 
			"WHERE ID_NO=:id_no",nativeQuery=true)
	public void insertIntoEPCGas(@Param("id_no") int id_no);
}
