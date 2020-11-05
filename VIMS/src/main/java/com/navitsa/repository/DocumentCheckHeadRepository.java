package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.DocumentCheckHead;

public interface DocumentCheckHeadRepository extends CrudRepository<DocumentCheckHead, String> {
	
	@Query(value="SELECT (max(d.documentcheckheadid)+1) FROM DocumentCheckHead d ")
	public String maxDocumentCheckHeadID();
	

}
