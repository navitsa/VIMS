package com.navitsa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.EmissionDieselCertificateData;

public interface EmissionDieselCertificateDataRepo extends CrudRepository<EmissionDieselCertificateData, String> {

	@Query(value = "SELECT e FROM EmissionDieselCertificateData e WHERE e.reg_id.vregID =:register_id")
	public EmissionDieselCertificateData getEmiDieselCerData(@Param("register_id") String register_id);
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO emission_diesel_certificate_data (id_no,vehicle_no,hsu_pres,k_pres,result,V_Register_ID)\n" + 
			"SELECT ID_No,Vehicle_No,HSUmean_Pres,Kmean_Pres,Result,:regId FROM edt_certificate_data\n" + 
			"WHERE Vehicle_No=:vehicleID ORDER BY ID_No DESC LIMIT 1;",nativeQuery=true)
	public void insertIntoEDCData(@Param("vehicleID") String vehicleID,@Param("regId") String regId);

	@Query(value="SELECT id_no FROM emission_diesel_certificate_data WHERE V_Register_ID=:regId",nativeQuery=true)
	public int getEDCDataID(@Param("regId") String regId);
}
