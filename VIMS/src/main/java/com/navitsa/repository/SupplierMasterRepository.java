package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.SupplierMaster;

public interface SupplierMasterRepository extends CrudRepository<SupplierMaster, String> {

	@Query(value = "SELECT (max(sm.supplierId)+1) FROM SupplierMaster sm")
	public String maxSupplierId();
	
	@Query(value = "SELECT sm FROM SupplierMaster sm")
	public List<SupplierMaster> getSupplierList();
}
