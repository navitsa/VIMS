package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.OcrDetails;
import com.navitsa.entity.TestLimitRule;

public interface OcrDetailsRepository extends CrudRepository<OcrDetails, Integer> {

	@Query(value = "SELECT (max(oc.ocrid)+1) FROM OcrDetails oc ")
	public String maxOcrDetailsID();
	
	@Transactional
	@Modifying
	@Query(value="UPDATE OcrDetails oc SET oc.vmStatus=:vmStatus,oc.vrStatus=:vrStatus,oc.docStatus=:docStatus  WHERE oc.ocrid=:ocrid")
	public int setVmAndVrStatus(@Param("vmStatus")String vmStatus,@Param("vrStatus")String vrStatus,@Param("docStatus")String docStatus,@Param("ocrid")String ocrid);
	
	
	@Query(value = "SELECT oc FROM OcrDetails oc where oc.vmStatus=:vmStatus and oc.vrStatus=:vrStatus and oc.docStatus=:docStatus and oc.vrStatus='pending' and oc.status='ACTIVE'")
	public List<OcrDetails> pendingOcrStatusDetails(@Param("vmStatus")String vmStatus,@Param("vrStatus")String vrStatus,@Param("docStatus")String docStatus);
	
	@Query(value = "SELECT oc FROM OcrDetails oc where oc.vrStatus='pending' and oc.status='ACTIVE'")
	public List<OcrDetails> pendingOcrDetails();
	
	@Query(value = "SELECT oc FROM OcrDetails oc where (oc.vmStatus='pending' OR oc.vrStatus='pending' OR oc.docStatus='pending') AND oc.ocrDate LIKE :todayDate || '%' ")
	public List<OcrDetails> getOCRVehicles(@Param("todayDate")String todayDate);
	
	@Query(value = "SELECT oc FROM OcrDetails oc where oc.status='ACTIVE' AND  oc.ocrDate LIKE :todayDate || '%' ")
	public List<OcrDetails> getOCRVehiclesByDates(@Param("todayDate")String todayDate);
	
	@Query(value = "SELECT count(*),COALESCE(sum(if(o.vm_Status='completed',1,0)),0),COALESCE(sum(if(o.vr_Status='completed',1,0)),0),COALESCE(sum(if(o.doc_Status='completed',1,0)),0) FROM ocr_details o where o.ocrDate like :selectedDate",nativeQuery = true)
    public String[][] getDashBordOCrDetails(@Param("selectedDate") String selectedDate);
	
	@Query(value = "SELECT oc FROM OcrDetails oc where oc.vmStatus='completed' and oc.vrStatus='pending' and oc.docStatus='completed' and oc.paymentStatus='completed' and oc.status='ACTIVE'")
	public List<OcrDetails> pendingLaneEntryData();
	
	@Query(value = "SELECT oc FROM OcrDetails oc where oc.vrStatus='completed' AND oc.ocrDate LIKE :todayDate || '%' and oc.status='ACTIVE'")
	public List<OcrDetails> completedVehiclesPayment(@Param("todayDate")String todayDate);

	@Query(value = "SELECT t FROM OcrDetails t WHERE t.gateID.gateID =:gate")
	public List<OcrDetails>  filterVehicleNO(@Param("gate") String gate);
}
