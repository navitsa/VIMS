package com.navitsa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.EmissionPetrolCertificateLembda;

public interface EmissionPetrolCertificateLembdaRepo extends CrudRepository<EmissionPetrolCertificateLembda, String> {

	@Query(value = "SELECT l FROM EmissionPetrolCertificateLembda l WHERE l.id_no.id_no =:id_no")
	public EmissionPetrolCertificateLembda getEmiPetrolCerLambda(@Param("id_no") String id_no);

	@Transactional
	@Modifying
	@Query(value="INSERT INTO emission_petrol_certificate_lembda(id_no,co,hc,co2,o2,nox,lembda,rpm)\n" + 
			"SELECT ID_NO,Lambda_CO,Lambda_HC,Lambda_CO2,Lambda_O2,Lambda_NOX,Lambda_LEMBDA,Lambda_RPM FROM ept_certificate_lambda\n" + 
			"WHERE ID_NO=:id_no",nativeQuery=true)
	public void insertIntoEPCLambda(@Param("id_no") int id_no);
}
