package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>{

	@Query(value = "SELECT (max(c.id)+1) FROM Customer c ")
    public String maxCusID();
	
    @Query(value = "SELECT c FROM Customer c WHERE c.tpno =:mobileNo")
    public Customer getCustomerByMobileNo(@Param("mobileNo") String mobileNo);
	
}
