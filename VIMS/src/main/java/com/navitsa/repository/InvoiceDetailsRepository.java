package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.InvoiceDetails;


public interface InvoiceDetailsRepository extends CrudRepository<InvoiceDetails,Integer>{

	@Query(value = "SELECT i FROM InvoiceDetails i WHERE i.invoiceNo.invoiceNo =:invno")
	public List<InvoiceDetails> getInvoiceDetails(@Param("invno")String invno);
	
}
