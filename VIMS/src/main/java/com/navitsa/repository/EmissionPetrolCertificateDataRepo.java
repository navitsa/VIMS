package com.navitsa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.EmissionPetrolCertificateData;

public interface EmissionPetrolCertificateDataRepo extends CrudRepository<EmissionPetrolCertificateData, String> {

	@Query(value = "SELECT ep FROM EmissionPetrolCertificateData ep WHERE ep.reg_id.vregID =:register_id")
	public EmissionPetrolCertificateData getValuesByRegisterID(@Param("register_id") String register_id);

	@Transactional
	@Modifying
	@Query(value="INSERT INTO emission_petrol_certificate_data (id_no,vehicle_no,result,cancelled,V_Register_ID)\n" + 
			"SELECT ID_No,Vehicle_No,Result,Cancelled,:regId FROM ept_certificate_data\n" + 
			"WHERE Vehicle_No=:vehicleID ORDER BY ID_No DESC LIMIT 1;",nativeQuery=true)
	public void insertIntoEPCData(@Param("vehicleID") String vehicleID, @Param("regId") String regId);

	@Query(value="SELECT id_no FROM emission_petrol_certificate_data WHERE V_Register_ID=:regId",nativeQuery=true)
	public int getEPCDataID(@Param("regId") String regId);

}
