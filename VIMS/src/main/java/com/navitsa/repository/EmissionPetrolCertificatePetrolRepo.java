package com.navitsa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.EmissionPetrolCertificatePetrol;

public interface EmissionPetrolCertificatePetrolRepo extends CrudRepository<EmissionPetrolCertificatePetrol, String>{

	@Query(value = "SELECT p FROM EmissionPetrolCertificatePetrol p WHERE p.id_no.id_no =:id_no")
	public EmissionPetrolCertificatePetrol getEmiPetrolCerPetrol(@Param("id_no") String id_no);

	@Transactional
	@Modifying
	@Query(value="INSERT INTO emission_petrol_certificate_petrol(id_no,pres_co,pres_hc,co,hc,co2,o2,nox,lembda,rpm)\n" + 
			"SELECT ID_NO,Petrol_Pres_CO,Petrol_Pres_HC,Petrol_Pretuned_CO,Petrol_Pretuned_HC,Petrol_Pretuned_CO2,Petrol_Pretuned_O2,Petrol_Pretuned_NOX,Petrol_Pretuned_LEMBDA,Petrol_Pretuned_RPM FROM ept_certificate_petrol\n" + 
			"WHERE ID_NO=:id_no",nativeQuery=true)
	public void insertIntoEPCPetrol(@Param("id_no") int id_no);
}
