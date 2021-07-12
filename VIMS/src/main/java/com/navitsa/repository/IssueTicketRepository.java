package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.IssueTicket;
import com.navitsa.entity.TicketClose;

public interface IssueTicketRepository extends CrudRepository<IssueTicket, Integer> {

	@Query(value = "SELECT it FROM IssueTicket it WHERE it.issueDate between :fromDate and :toDate and it.status='ACTIVE'")	
	List<IssueTicket> getEquipmentByType(@Param("fromDate")String fromDate,@Param("toDate")String toDate);

	@Query(value = "SELECT it FROM IssueTicket it WHERE it.issueStatus like :ticketStatu and it.status='ACTIVE'")	
	List<IssueTicket> getOpenTicketDetails(@Param("ticketStatu")String ticketStatu);

	@Query(value="SELECT tc FROM IssueTicket tc WHERE tc.status='ACTIVE'")
	List<IssueTicket> findAllTickets();
	
}
