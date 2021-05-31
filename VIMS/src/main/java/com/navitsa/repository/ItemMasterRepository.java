package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.ItemMaster;

public interface ItemMasterRepository extends CrudRepository<ItemMaster, String> {

	@Query(value = "SELECT (max(im.itemCode)+1) FROM ItemMaster im")
	public String maxItemCode();
	
	@Query(value = "SELECT im FROM ItemMaster im")
	public List<ItemMaster> getItemList();
}
