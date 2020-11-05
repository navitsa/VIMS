package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.IncomingReceiptHead;

public interface IncomingReceiptHeadRepository extends CrudRepository<IncomingReceiptHead , String> {

	@Query(value = "SELECT ir From IncomingReceiptHead ir WHERE ir.inRecDate=:vRdate and ir.status='ACTIVE' order by ir.inRecDate,ir.inRecTime DESC")
	public List<IncomingReceiptHead> getIncomingReceiptNoByDate(@Param("vRdate") String vRdate);
	
	@Query(value = "SELECT ir From IncomingReceiptHead ir WHERE ir.inRecDate between :fromdate and :todate order by ir.status,ir.inRecDate,ir.payType,ir.inRecTime")
	public List<IncomingReceiptHead> getIncomingReceiptHeadBytwoDate(@Param("fromdate") String fromdate,@Param("todate") String todate);
	
}
