package com.navitsa.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.APInvoiceDetails;
import com.navitsa.entity.APInvoiceHead;
import com.navitsa.entity.APInvoicePaymentDetails;
import com.navitsa.entity.APInvoicePaymentHead;
import com.navitsa.entity.APInvoiceTax;
import com.navitsa.entity.DocType;
import com.navitsa.entity.Glaccount;
import com.navitsa.entity.OutgoingPaymentDetails;
import com.navitsa.entity.OutgoingPaymentHead;
import com.navitsa.hrm.entity.Bank;
import com.navitsa.hrm.entity.BankMaster;
import com.navitsa.hrm.entity.PartnerBankAccount;
import com.navitsa.hrm.repository.BankMasterRepository;
import com.navitsa.hrm.repository.BankRepository;
import com.navitsa.hrm.repository.PartnerBankAccountRepository;
import com.navitsa.repository.APInvoiceDetailsRepository;
import com.navitsa.repository.APInvoiceHeadRepository;
import com.navitsa.repository.APInvoicePaymentDetailsRepository;
import com.navitsa.repository.APInvoicePaymentHeadRepository;
import com.navitsa.repository.APInvoiceTaxRepository;
import com.navitsa.repository.DocTypeRepository;
import com.navitsa.repository.GlaccountRepository;
import com.navitsa.repository.IncomingReceiptHeadRepository;
import com.navitsa.repository.OutgoingPaymentDetailsRepository;
import com.navitsa.repository.OutgoingPaymentHeadRepository;
import com.navitsa.repository.ReceiptHeadRepository;

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
	ReceiptHeadRepository receiptHeadRepository;

	@Autowired
	GlaccountRepository glaccountRepository;

	@Autowired
	BankMasterRepository bankMasterRepository;

	@Autowired
	BankRepository bankRepository;

	@Autowired
	PartnerBankAccountRepository partnerBankAccountRepository;

	@Autowired
	APInvoiceHeadRepository apInvoiceHeadRepository;

	@Autowired
	APInvoiceDetailsRepository apInvoiceDetailsRepository;

	@Autowired
	APInvoiceTaxRepository apInvoiceTaxRepository;

	@Autowired
	APInvoicePaymentHeadRepository apInvoicePaymentHeadRepository;

	@Autowired
	APInvoicePaymentDetailsRepository apInvoicePaymentDetailsRepository;
	
	@Autowired
	DocTypeRepository docTypeRepositoryRepository;
	

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

	public List<OutgoingPaymentHead> getOutgoingPaymentsVoucherNoByDate(String vRdate) {
		return outgoingPaymentHeadRepo.getOutgoingPaymentsVoucherNoByDate(vRdate);
	}

	public List<OutgoingPaymentDetails> getOutgoingPaymentHeadDetailsBetweenTwoDays(String fromdate, String todate) {
		return outgoingPaymentHeadRepo.getOutgoingPaymentHeadDetailsBetweenTwoDays(fromdate, todate);
	}

	public String[][] getIncomingReceiptSumPayAmt(String fromdate) {
		return incomingReceiptHeadRepository.getIncomingReceiptSumPayAmt(fromdate);
	}

	public String[][] getReceiptHeadNetAndTestFeeTotal(String recDate) {
		return receiptHeadRepository.getReceiptHeadNetAndTestFeeTotal(recDate);
	}

	public List<Glaccount> getAllGlaccounts() {
		return (List<Glaccount>) glaccountRepository.findAll();
	}

	public Glaccount saveGlaccount(Glaccount glaccount) {
		return glaccountRepository.save(glaccount);

	}

	public List<Glaccount> getglaccountByPrimary(String priAccount) {
		return glaccountRepository.getglaccountByPrimary(priAccount);

	}

	public Glaccount getGlaccountbyId(String glaccno) {
		return glaccountRepository.getById(glaccno);
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

	public List<PartnerBankAccount> getBankAccountByBank(String bankid) {
		return (List<PartnerBankAccount>) partnerBankAccountRepository.getBankAccountByBank(bankid);
	}

	public String maxAPInvoiceHeadId() {
		if (apInvoiceHeadRepository.maxAPInvoiceHeadId() == null) {
			return "1";
		} else {
			return apInvoiceHeadRepository.maxAPInvoiceHeadId();

		}
	}

	public void saveAPInvoiceHead(@Valid APInvoiceHead apInvoiceHead) {
		apInvoiceHeadRepository.save(apInvoiceHead);
	}

	public void saveAPInvoiceDetailList(List<APInvoiceDetails> apInvoiceDetailsList) {
		apInvoiceDetailsRepository.saveAll(apInvoiceDetailsList);
	}

	public void saveAPInvoiceTaxList(List<APInvoiceTax> apInvoiceTaxList) {
		apInvoiceTaxRepository.saveAll(apInvoiceTaxList);
	}

	public List<APInvoiceHead> getAPInvoiceHeadIdsByDate(String date) {
		return apInvoiceHeadRepository.getAPInvoiceHeadIdsByDate(date);
	}

	public List<APInvoiceHead> getAPInvoiceHeadById(String invoiceID) {
		return apInvoiceHeadRepository.getAPInvoiceHeadById(invoiceID);
	}

	public List<APInvoiceHead> getAPInvoiceHeadByDates(String fromDate, String toDate) {
		return apInvoiceHeadRepository.getAPInvoiceHeadByDates(fromDate, toDate);
	}

	public List<APInvoiceHead> getAPInvoiceHeadSupplierList() {
		return apInvoiceHeadRepository.getAPInvoiceHeadSupplierList();
	}

	public List<APInvoiceHead> getAPInvoicesBySupplier(String supplierId) {
		return apInvoiceHeadRepository.getAPInvoicesBySupplier(supplierId);
	}

	public String maxAPInvoicePaymentHeadId() {
		if (apInvoicePaymentHeadRepository.maxAPInvoicePaymentHeadId() == null) {
			return "1";
		} else {
			return apInvoicePaymentHeadRepository.maxAPInvoicePaymentHeadId();

		}
	}

	public void saveAPInvoicePaymentHead(APInvoicePaymentHead apInvoicePaymentHead) {
		apInvoicePaymentHeadRepository.save(apInvoicePaymentHead);
	}

	public void saveAPInvoicePaymentDetailList(List<APInvoicePaymentDetails> apInvoicePaymentDetailsList) {
		apInvoicePaymentDetailsRepository.saveAll(apInvoicePaymentDetailsList);
	}

	public APInvoiceHead findAPInvoiceHeadById(String apInvoiceHeadId) {
		return apInvoiceHeadRepository.findById(apInvoiceHeadId).get();
	}

	public List<APInvoiceHead> getUnpaidAPInvoices() {
		return apInvoiceHeadRepository.getUnpaidAPInvoices();
	}

	public List<APInvoiceHead> getAPInvoiceHeadByDatesAndBalance(String fromDate, String toDate) {
		return apInvoiceHeadRepository.getAPInvoiceHeadByDatesAndBalance(fromDate, toDate);
	}

	public List<APInvoiceHead> getAPInvoiceHeadByDatesAndSupplierAndBalance(String fromDate, String toDate,
			String supplierId) {
		return apInvoiceHeadRepository.getAPInvoiceHeadByDatesAndSupplierAndBalance(fromDate, toDate, supplierId);
	}

	public List<APInvoicePaymentHead> getAPInvoicePaymentHeadsByDates(String fromDate, String toDate) {
		return apInvoicePaymentHeadRepository.getAPInvoicePaymentHeadsByDates(fromDate, toDate);
	}

	public List<APInvoicePaymentHead> getAPInvoicePaymentHeadsByDatesAndSupplier(String fromDate, String toDate,
			String supplierId) {
		return apInvoicePaymentHeadRepository.getAPInvoicePaymentHeadsByDatesAndSupplier(fromDate, toDate, supplierId);
	}

	public List<APInvoicePaymentDetails> getAPInvoicePaymentDetailsByHeadId(String apInvoicePaymentHeadId) {
		return apInvoicePaymentDetailsRepository.getAPInvoicePaymentDetailsByHeadId(apInvoicePaymentHeadId);
	}

	public List<APInvoicePaymentDetails> getAPInvoicePaymentDetailsByDates(String fromDate, String toDate) {
		return apInvoicePaymentDetailsRepository.getAPInvoicePaymentDetailsByDates(fromDate, toDate);
	}

	public List<APInvoicePaymentDetails> getAPInvoicePaymentDetailsByByDatesAndSupplier(String fromDate, String toDate,
			String supplierId) {
		return apInvoicePaymentDetailsRepository.getAPInvoicePaymentDetailsByByDatesAndSupplier(fromDate, toDate,
				supplierId);
	}

	public APInvoicePaymentHead findAPInvoicePaymentHeadById(String apInvoicePaymentHeadId) {
		return apInvoicePaymentHeadRepository.findById(apInvoicePaymentHeadId).get();
	}
	
	public DocType findDocTypeHeadById(int docTypeId) {
		return docTypeRepositoryRepository.findById(docTypeId).get();
	}
}
