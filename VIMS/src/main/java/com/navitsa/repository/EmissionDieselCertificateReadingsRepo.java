package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.EmissionDieselCertificateReadings;

public interface EmissionDieselCertificateReadingsRepo extends CrudRepository<EmissionDieselCertificateReadings, String> {

	@Query(value = "SELECT er FROM EmissionDieselCertificateReadings er WHERE er.edc_id.id_no =:id_no ORDER BY er.id DESC")
	public List<EmissionDieselCertificateReadings> getEmiDieselCerReadings(@Param("id_no") String id_no);
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO emission_diesel_certificate_readings (k,hsu,rpm_min,rpm_max,oil_temp,id_no)\n" + 
			"SELECT K,HSU,RPM_Min,RPM_Max,Oil_Temp,S_No FROM edt_certificate_readings\n" + 
			"WHERE S_No =:id_no",nativeQuery=true)
	public void insertIntoEDCReadings(@Param("id_no") int id_no);

}
