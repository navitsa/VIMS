package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.OutgoingPaymentDetails;
import com.navitsa.entity.OutgoingPaymentHead;

public interface OutgoingPaymentHeadRepository extends CrudRepository<OutgoingPaymentHead, String> {

	@Query(value = "SELECT oh From OutgoingPaymentHead oh WHERE oh.paymentDate=:pdate and oh.status='ACTIVE' order by oh.paymentDate,oh.paymentTime DESC")
	public List<OutgoingPaymentHead> getOutgoingPaymentsVoucherNoByDate(@Param("pdate") String pdate);
	
	@Query(value = "SELECT opd From OutgoingPaymentHead oh,OutgoingPaymentDetails opd WHERE oh.paymentDate between :fromdate and :todate and opd.paymentVoucherNo.paymentVoucherNo=oh.paymentVoucherNo order by oh.paymentDate,opd.paymentVoucherNo.paymentVoucherNo")
	public List<OutgoingPaymentDetails> getOutgoingPaymentHeadDetailsBetweenTwoDays(@Param("fromdate") String fromdate,@Param("todate") String todate);

	@Query(value = "SELECT oh From OutgoingPaymentHead oh WHERE oh.paymentMean='Cheque' AND oh.chequePrint='Pending' ")
	public List<OutgoingPaymentHead> getPendingChequePayments();
		
}
