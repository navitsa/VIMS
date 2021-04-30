package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.APInvoiceHead;

public interface APInvoiceHeadRepository extends CrudRepository<APInvoiceHead, String> {

	@Query(value = "SELECT (max(apih.apInvoiceHeadId)+1) FROM APInvoiceHead apih")
	public String maxAPInvoiceHeadId();
}
