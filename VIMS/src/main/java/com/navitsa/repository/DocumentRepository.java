package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.Document;

public interface DocumentRepository  extends CrudRepository<Document , Integer>{

	@Query(value = "SELECT d FROM Document d where d.status='ACTIVE' ")
	public List<Document> getAllActiveDocument();

}
