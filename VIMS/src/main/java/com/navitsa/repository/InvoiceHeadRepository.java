package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.InvoiceHead;


public interface InvoiceHeadRepository extends CrudRepository<InvoiceHead,String>{

	@Query(value="SELECT ih FROM InvoiceHead ih,VehicleRegistration vr WHERE vr.date =:vrdate and vr.vid.vehicleID=:vecid and vr.payType=:payTyp and ih.status='ACTIVE' and vr.vregID=ih.vRegisterID.vregID group by ih.invoiceNo order by ih.invoiceNo ")
	public List<InvoiceHead> getInvoiceHeadByVehicalRegID(@Param("vrdate") String vRdate,@Param("vecid") String vecid,@Param("payTyp") String payTyp);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE InvoiceHead ih SET ih.status='INACTIVE' WHERE ih.invoiceNo=:invNo")
	public int setCancelInvoice(@Param("invNo")String invNo);
	
	@Query(value = "SELECT ih From InvoiceHead ih WHERE ih.invoiceDate between :fromdate and :todate order by ih.status,ih.invoiceDate,ih.invoiceTime")
	public List<InvoiceHead> getInvoiceHeadDetailBytwoDate(@Param("fromdate") String fromdate,@Param("todate") String todate);
	
	@Query(value = "SELECT ih From InvoiceHead ih WHERE ih.vRegisterID.cusid.id=:cusid and ih.status='ACTIVE' and ih.payStatus='Open' order by ih.invoiceDate,ih.invoiceTime")
	public List<InvoiceHead> getIncomingPaymentDetails(@Param("cusid") String cusid);
	
	@Query(value = "SELECT ih From InvoiceHead ih WHERE  ih.status='ACTIVE' and ih.payStatus='Open' order by ih.vRegisterID.cusid.id,ih.invoiceDate,ih.invoiceTime")
	public List<InvoiceHead> getAllActiveInvoiceHead();
}
