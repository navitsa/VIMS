package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.ItemRemarks;


public interface ItemStatusRemarksRepository extends CrudRepository<ItemRemarks, String>{

	@Query(value = "SELECT r FROM ItemRemarks r WHERE r.is.profileItemStatusID =:statusID")
	public List<ItemRemarks> searchRemark(@Param("statusID") String statusID);
	
	//used
	@Query(value = "SELECT (max(ir.remarksID)+1) FROM ItemRemarks ir")
    public String maxRemarkID();
}
