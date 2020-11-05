package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction , String> {
	@Query(value = "SELECT (max(e.trID)+1) FROM Transaction e ")
	public String maxtrID();
}
