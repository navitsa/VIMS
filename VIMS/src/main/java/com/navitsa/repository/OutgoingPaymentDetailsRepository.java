package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.OutgoingPaymentDetails;

public interface OutgoingPaymentDetailsRepository extends CrudRepository<OutgoingPaymentDetails, Integer> {

	@Query(value = "SELECT op FROM OutgoingPaymentDetails op WHERE op.paymentVoucherNo.paymentVoucherNo=:voucherNo")
	public List<OutgoingPaymentDetails> getOutgoingPaymentDetailsByVoucherNo(@Param("voucherNo") String voucherNo);
}
