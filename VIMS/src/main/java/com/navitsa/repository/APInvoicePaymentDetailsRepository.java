package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.APInvoicePaymentDetails;

public interface APInvoicePaymentDetailsRepository extends CrudRepository<APInvoicePaymentDetails, Integer> {

	@Query(value = "SELECT apipd FROM APInvoicePaymentDetails apipd WHERE apipd.apInvoicePaymentHeadId.apInvoicePaymentHeadId = :apInvoicePaymentHeadId")
	List<APInvoicePaymentDetails> getAPInvoicePaymentDetailsByHeadId(
			@Param("apInvoicePaymentHeadId") String apInvoicePaymentHeadId);

	@Query(value = "SELECT apipd FROM APInvoicePaymentDetails apipd WHERE apipd.apInvoicePaymentHeadId.paymentDate BETWEEN :fromDate AND :toDate")
	List<APInvoicePaymentDetails> getAPInvoicePaymentDetailsByDates(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT apipd FROM APInvoicePaymentDetails apipd WHERE apipd.apInvoicePaymentHeadId.paymentDate BETWEEN :fromDate AND :toDate AND apipd.apInvoicePaymentHeadId.supplierMaster.supplierId = :supplierId")
	List<APInvoicePaymentDetails> getAPInvoicePaymentDetailsByByDatesAndSupplier(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("supplierId") String supplierId);
}
