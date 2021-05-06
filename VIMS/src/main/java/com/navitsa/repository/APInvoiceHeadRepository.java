package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.APInvoiceHead;

public interface APInvoiceHeadRepository extends CrudRepository<APInvoiceHead, String> {

	@Query(value = "SELECT (max(apih.apInvoiceHeadId)+1) FROM APInvoiceHead apih")
	public String maxAPInvoiceHeadId();

	@Query(value = "SELECT apih FROM APInvoiceHead apih WHERE apih.date=:date")
	public List<APInvoiceHead> getAPInvoiceHeadIdsByDate(@Param("date") String date);

	@Query(value = "SELECT apih FROM APInvoiceHead apih WHERE apih.apInvoiceHeadId=:invoiceID")
	public List<APInvoiceHead> getAPInvoiceHeadById(@Param("invoiceID") String invoiceID);

	@Query(value = "SELECT apih FROM APInvoiceHead apih WHERE apih.date BETWEEN :fromDate AND :toDate")
	public List<APInvoiceHead> getAPInvoiceHeadByDates(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
}
