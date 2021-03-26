package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.TestWisePrintOrder;

public interface TestWisePrintOrderRepository extends CrudRepository<TestWisePrintOrder,Integer> {

	@Query(value = "SELECT report_path FROM test_wise_print WHERE profile_id=:test_pro_id ORDER BY printing_order",nativeQuery = true)
	public String[] getPrintingOrder(@Param("test_pro_id") int test_pro_id);

}
