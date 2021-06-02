package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.APInvoiceHead;
import com.navitsa.entity.APInvoicePaymentHead;

public interface APInvoicePaymentHeadRepository extends CrudRepository<APInvoicePaymentHead, String> {

	@Query(value = "SELECT (max(apiph.apInvoicePaymentHeadId)+1) FROM APInvoicePaymentHead apiph")
	public String maxAPInvoicePaymentHeadId();

	@Query(value = "SELECT apiph FROM APInvoicePaymentHead apiph WHERE apiph.paymentDate BETWEEN :fromDate AND :toDate")
	public List<APInvoicePaymentHead> getAPInvoicePaymentHeadsByDates(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT apiph FROM APInvoicePaymentHead apiph WHERE apiph.paymentDate BETWEEN :fromDate AND :toDate AND apiph.supplierMaster.supplierId = :supplierId")
	public List<APInvoicePaymentHead> getAPInvoicePaymentHeadsByDatesAndSupplier(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("supplierId") String supplierId);
}
