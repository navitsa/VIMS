package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.ReceiptHead;

public interface ReceiptHeadRepository extends CrudRepository<ReceiptHead,String>{

	@Query(value="SELECT rh FROM ReceiptHead rh,VehicleRegistration vr WHERE vr.date =:vrdate and vr.vid.vehicleID=:vecid and vr.payType=:payTyp and vr.vregID=rh.vRegisterID.vregID and rh.status='ACTIVE' group by rh.recNo order by rh.recNo ")
	public List<ReceiptHead> getReceiptHeadByVehicalRegID(@Param("vrdate") String vRdate,@Param("vecid") String vecid,@Param("payTyp") String payTyp);
	
	@Query(value="SELECT rh FROM ReceiptHead rh WHERE rh.vRegisterID.vregID=:vregid ")
	public ReceiptHead getReceiptHeadDetailsByVRid(@Param("vregid") String vregid);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE ReceiptHead rh SET rh.status='INACTIVE' WHERE rh.recNo=:recNo")
	public int setCancelReceipt(@Param("recNo")String recNo);
	
	@Query(value="SELECT COALESCE(sum(rh.testFee),0),COALESCE(sum(rh.netTotal),0) FROM ReceiptHead rh WHERE rh.recDate=:recDate ")
	public String[][] getReceiptHeadNetAndTestFeeTotal(@Param("recDate") String recDate);
}
