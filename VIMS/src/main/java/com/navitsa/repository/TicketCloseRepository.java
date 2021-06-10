package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.TicketClose;

public interface TicketCloseRepository extends CrudRepository<TicketClose,Integer> {
	
	@Query(value="SELECT tc FROM TicketClose tc WHERE tc.closeDate=:toDate and tc.status='ACTIVE'")
	public List<TicketClose> privewDownTimeReport(@Param("toDate")String toDate);

	@Query(value="SELECT tc FROM TicketClose tc WHERE tc.status='ACTIVE'")
	public List<TicketClose> findAllTickets();

	@Query(value="SELECT count(*) FROM TicketClose")
	public String getTotal();

	
}

