package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.ReceiptDetails;

public interface ReceiptDetailsRepository extends CrudRepository<ReceiptDetails, Integer>{

	@Query(value = "SELECT r FROM ReceiptDetails r WHERE r.recNo.recNo =:recNo1")
	public List<ReceiptDetails> getReceiptDetails(@Param("recNo1")String recNo);
	
}
