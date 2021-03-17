package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.Glaccount;
import com.navitsa.entity.OutgoingPaymentDetails;
import com.navitsa.entity.OutgoingPaymentHead;
import com.navitsa.repository.GlaccountRepository;
import com.navitsa.repository.IncomingReceiptHeadRepository;
import com.navitsa.repository.OutgoingPaymentDetailsRepository;
import com.navitsa.repository.OutgoingPaymentHeadRepository;
import com.navitsa.repository.ReceiptHeadRepository;
import com.prime.hrm.entity.Bank;
import com.prime.hrm.entity.BankMaster;
import com.prime.hrm.entity.PartnerBankAccount;
import com.prime.hrm.repository.BankMasterRepository;
import com.prime.hrm.repository.BankRepository;
import com.prime.hrm.repository.PartnerBankAccountRepository;

@Service
@Transactional
public class FinanceAccountingService {
	@Autowired
	OutgoingPaymentHeadRepository outgoingPaymentHeadRepo;
	
	@Autowired
	OutgoingPaymentDetailsRepository outgoingPaymentDetailsRepo;
	
	@Autowired
	IncomingReceiptHeadRepository incomingReceiptHeadRepository;
	
	@Autowired
	ReceiptHeadRepository  receiptHeadRepository;
	
	@Autowired
	GlaccountRepository  glaccountRepository;
	
	@Autowired
	BankMasterRepository  bankMasterRepository;
		
	@Autowired
	BankRepository  bankRepository;
	
	@Autowired
	PartnerBankAccountRepository  partnerBankAccountRepository;
	
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
	
	public String[][] getIncomingReceiptSumPayAmt(String fromdate){
		return incomingReceiptHeadRepository.getIncomingReceiptSumPayAmt(fromdate);
	}
	
	public String[][] getReceiptHeadNetAndTestFeeTotal(String recDate){
		return receiptHeadRepository.getReceiptHeadNetAndTestFeeTotal(recDate);
	}
	
	public List<Glaccount> getAllGlaccounts(){
		return (List<Glaccount>) glaccountRepository.findAll();
	}
	public Glaccount saveGlaccount(Glaccount glaccount) {
		return  glaccountRepository.save(glaccount);
		
	}
	
	public List<Glaccount> getglaccountByPrimary(String priAccount) {
		return  glaccountRepository.getglaccountByPrimary(priAccount);
		
	}
	public Glaccount getGlaccountbyId(String glaccno) {
		return  glaccountRepository.getById(glaccno);
	}
	public List<OutgoingPaymentHead> getPendingChequePayments() {
		return outgoingPaymentHeadRepo.getPendingChequePayments();
	}
	public void saveBankMaster(BankMaster bankMaster) {
		  bankMasterRepository.save(bankMaster);
	}
	
	
	public void saveBankBranch(Bank bank) {
		  bankRepository.save(bank);
	}
	
	public void savePartnerBankAccount(PartnerBankAccount partnerBankAccount) {
		partnerBankAccountRepository.save(partnerBankAccount);
	}
	
	public List<BankMaster> getBankMasterAll() {
		return (List<BankMaster>) bankMasterRepository.findAll();
	}
	public List<Bank> getBankBranchAll() {
		return (List<Bank>) bankRepository.findAll();
	}
	public List<PartnerBankAccount> getPartnerBankAccountAll() {
		return (List<PartnerBankAccount>) partnerBankAccountRepository.findAll();
	}
	
	public List<PartnerBankAccount> getBankAccountByBank( String bankid){
		return (List<PartnerBankAccount>) partnerBankAccountRepository.getBankAccountByBank(bankid);
	}
}
