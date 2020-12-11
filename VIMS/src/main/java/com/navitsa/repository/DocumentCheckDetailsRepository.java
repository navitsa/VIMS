package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.DocumentCheckDetails;

public interface DocumentCheckDetailsRepository extends CrudRepository<DocumentCheckDetails, Integer> {

	@Query(value = "SELECT  s FROM DocumentCheckDetails s,OcrDetails o WHERE o.documentCheckHeadID.documentcheckheadid=s.documentCheckHeadID.documentcheckheadid and o.ocrid=:ocrid")
	public List<DocumentCheckDetails> getCheckDocumentDetails(@Param("ocrid") int ocrid);
	
	@Query(value = "SELECT  s FROM DocumentCheckDetails s WHERE s.documentCheckHeadID.documentcheckheadid=:headid")
	public List<DocumentCheckDetails> getCheckDocumentDetailsByHeadid(@Param("headid") String headid);
}
