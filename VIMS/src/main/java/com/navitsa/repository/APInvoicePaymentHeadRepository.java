package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.APInvoicePaymentHead;

public interface APInvoicePaymentHeadRepository extends CrudRepository<APInvoicePaymentHead, String> {

	@Query(value = "SELECT (max(apiph.apInvoicePaymentHeadId)+1) FROM APInvoicePaymentHead apiph")
	public String maxAPInvoicePaymentHeadId();
}
