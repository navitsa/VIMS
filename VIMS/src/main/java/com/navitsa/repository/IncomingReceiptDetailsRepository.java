package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.IncomingReceiptDetails;

public interface IncomingReceiptDetailsRepository extends CrudRepository<IncomingReceiptDetails , String>{

	@Query(value = "SELECT ir FROM IncomingReceiptDetails ir WHERE ir.inRecNo.inRecNo=:incRecId")
	public List<IncomingReceiptDetails> getIncomingReceiptDetailsbyInvoiceNo(@Param("incRecId") String incRecId);
	
	
}
