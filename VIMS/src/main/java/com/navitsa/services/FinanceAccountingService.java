package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.IncomingReceiptDetails;
import com.navitsa.entity.IncomingReceiptHead;
import com.navitsa.entity.OutgoingPaymentDetails;
import com.navitsa.entity.OutgoingPaymentHead;
import com.navitsa.repository.OutgoingPaymentDetailsRepository;
import com.navitsa.repository.OutgoingPaymentHeadRepository;


@Service
@Transactional
public class FinanceAccountingService {
	@Autowired
	OutgoingPaymentHeadRepository outgoingPaymentHeadRepo;
	
	@Autowired
	OutgoingPaymentDetailsRepository outgoingPaymentDetailsRepo;
	
	
	public void saveOutgoingPaymentHead(OutgoingPaymentHead outgoingPaymentHead) {
		outgoingPaymentHeadRepo.save(outgoingPaymentHead);
		
	}
	public void saveAllOutgoingPaymentDetails(List<OutgoingPaymentDetails> outgoingPaymentDetails) {
		outgoingPaymentDetailsRepo.saveAll(outgoingPaymentDetails);
		
	}
	public OutgoingPaymentHead getOutgoingPaymentHeadbyVoucherNo(String VoucherNo) {
		return outgoingPaymentHeadRepo.findById(VoucherNo).get();			
	}
	
	public List<OutgoingPaymentDetails> getOutgoingPaymentDetailsByVoucherNo(String incRecId) {
		return outgoingPaymentDetailsRepo.getOutgoingPaymentDetailsByVoucherNo(incRecId);			
	}

	public List<OutgoingPaymentHead> getOutgoingPaymentsVoucherNoByDate(String vRdate){
		return outgoingPaymentHeadRepo.getOutgoingPaymentsVoucherNoByDate(vRdate);
	}
	public List<OutgoingPaymentDetails> getOutgoingPaymentHeadDetailsBetweenTwoDays(String fromdate,String todate){
		return outgoingPaymentHeadRepo.getOutgoingPaymentHeadDetailsBetweenTwoDays(fromdate,todate);
	}
	
	
}
