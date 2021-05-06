package com.navitsa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.Reports.GlTranctionReportBeen;
import com.navitsa.Reports.OutgoingPaymentDetailsReportBeen;
import com.navitsa.Reports.ProfitsAndLossBeen;
import com.navitsa.Reports.TrialBalanceBeen;
import com.navitsa.entity.APInvoiceDetails;
import com.navitsa.entity.APInvoiceHead;
import com.navitsa.entity.APInvoiceTax;
import com.navitsa.entity.CenterMaster;
import com.navitsa.entity.DocType;
import com.navitsa.entity.GlPostingDetails;
import com.navitsa.entity.GlPostingHead;
import com.navitsa.entity.Glaccount;
import com.navitsa.entity.GlaccountMapping;
import com.navitsa.entity.OutgoingPaymentDetails;
import com.navitsa.entity.OutgoingPaymentHead;
import com.navitsa.entity.VehicleModel;
import com.navitsa.services.BusinessPartnerService;
import com.navitsa.services.CenterService;
import com.navitsa.services.FinanceAccountingService;
import com.navitsa.services.GlAccountService;
import com.navitsa.utils.DateHelperWeb;
import com.navitsa.utils.EnglishNumberToWords;
import com.navitsa.utils.ReportViewe;
import com.navitsa.utils.StringFormaterWeb;
import com.prime.hrm.entity.Bank;
import com.prime.hrm.entity.BankMaster;
import com.prime.hrm.entity.PartnerBankAccount;

@Controller
public class FinanceAccountingController {

	@Autowired
	private FinanceAccountingService financeAccountingService;

	@Autowired
	private CenterService centerService;
	@Autowired
	private GlAccountService glAccountService;
	@Autowired
	private BusinessPartnerService bPartnerService;

	@RequestMapping("/outgoingPayments")
	public String viewOutgoingPaymentForm(Model m, HttpSession session) {

		OutgoingPaymentHead obj = new OutgoingPaymentHead();
		m.addAttribute("outgoingPaymentForm", obj);
		return "outgoingPayments";
	}

	// Return all GLs
	@ModelAttribute("listGLAccounts")
	public List<Glaccount> findAll() {
		List<Glaccount> list = glAccountService.findAll();
		return list;
	}

	@RequestMapping(value = "/saveOutgoingPayment", method = RequestMethod.POST)
	public ModelAndView saveOutgoingPayment(
			@Valid @ModelAttribute("outgoingPaymentForm") OutgoingPaymentHead outgoingPaymentHead, BindingResult br,
			@RequestParam(value = "glAccNo") String[] glAccNo, @RequestParam(value = "amount") Double[] amount,
			@RequestParam(value = "remarks") String[] remarks, Model m, HttpSession session,
			HttpServletResponse response) {
		System.out.println("ffff");
		if (br.hasErrors()) {
			System.out.println("rrrr");
			return null;
		} else {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				DateTimeFormatter formattertime = DateTimeFormatter.ofPattern("HH:mm");
				LocalTime time = LocalTime.now();
				outgoingPaymentHead.setPaymentDate(formatter.format(date));

				String centerid = (String) session.getAttribute("centerid");
				CenterMaster cm = centerService.getcenterById(centerid);
				String nextVoucherNo = cm.getPartner_ID().getOutVouFormate() + (cm.getPartner_ID().getMaxVouNo() + 1);

				outgoingPaymentHead.setPaymentVoucherNo(nextVoucherNo);
				outgoingPaymentHead.setCenter_ID(cm);
				outgoingPaymentHead.setStatus("Active");
				if (outgoingPaymentHead.getPaymentMean().equalsIgnoreCase("Cheque")) {
					outgoingPaymentHead.setChequePrint("Pending");
				}

				List<GlPostingDetails> glPostingDetailsList = new ArrayList<>();

				List<GlaccountMapping> glMappingResult = glAccountService.getGlaccountMappingByDocId(4);

				GlPostingHead glPostingHead = new GlPostingHead();
				glPostingHead.setDocNo(nextVoucherNo);

				DocType docType = new DocType();
				docType.setDocid(4);

				glPostingHead.setDocid(docType);
				glPostingHead.setDate(formatter.format(date));
				glPostingHead.setTime(time.format(formattertime));
				glPostingHead.setCenterID(cm);
				glPostingHead.setStatus("ACTIVE");

				String crAccount;
				for (GlaccountMapping gmresult : glMappingResult) {
					if (gmresult.getType().equals(outgoingPaymentHead.getPaymentMean())) {
						crAccount = gmresult.getcR();
					}

				}

				List<OutgoingPaymentDetails> list = new ArrayList<OutgoingPaymentDetails>();
				double totalAmount = 0;
				for (int i = 0; i < glAccNo.length; i++) {
					OutgoingPaymentDetails paymentDetail = new OutgoingPaymentDetails();
					paymentDetail.setGlAccNo(glAccNo[i]);
					paymentDetail.setAmount(amount[i]);
					paymentDetail.setRemarks(remarks[i]);
					paymentDetail.setPaymentVoucherNo(outgoingPaymentHead);
					list.add(paymentDetail);
					totalAmount = totalAmount + amount[i];

					GlPostingDetails glPostingDetails1 = new GlPostingDetails();
					glPostingDetails1.setJournalNo(glPostingHead);

					glPostingDetails1.setGlAccNo(new Glaccount(glAccNo[i]));

					glPostingDetails1.setType("D");

					// long x=Long.parseLong((amount[i]*100));
					long l1 = (new Double(amount[i] * 100)).longValue();
					glPostingDetails1.setAmount(l1);
					glPostingDetailsList.add(glPostingDetails1);

				}

				long l2 = (new Double(totalAmount * 100)).longValue();
				glPostingHead.setTotalDR(l2);
				// long l3 = (new Double(totalAmount*100)).longValue();
				glPostingHead.setTotalCR(l2);

				glAccountService.saveGlPostingHeadRepository(glPostingHead);
				glAccountService.saveAllGlPostingDetailsRepository(glPostingDetailsList);

				outgoingPaymentHead.setTotalPayment(totalAmount);
				financeAccountingService.saveOutgoingPaymentHead(outgoingPaymentHead);
				bPartnerService.setUpdateLastPaymentVoucherNo(cm.getPartner_ID().getPartner_ID());
				financeAccountingService.saveAllOutgoingPaymentDetails(list);

				ModelAndView mav = new ModelAndView("comPdfReportView");
				ReportViewe view = new ReportViewe();
				String pdf_result = null;

				pdf_result = view.pdfReportViewInlineSystemOpen("outgoingPayment.jasper", "outgoingPayment", list, null,
						response);

				mav.addObject("pdfViewEq", pdf_result);
				System.out.println("kklllll");
				return mav;

				// return "redirect:/outgoingPayments";

			} catch (Exception e) {
				// m.addAttribute("success",0);
				e.printStackTrace();
				System.out.println("ttqqqqq");
				return null;
			}

		}

		// return "outgoingPayments";

	}

	@RequestMapping(value = "/getOutgoingPaymentDetails", method = RequestMethod.GET)
	public @ResponseBody List<OutgoingPaymentDetails> getOutgoingPaymentDetails(@RequestParam String voucherNo) {
		List<OutgoingPaymentDetails> list = financeAccountingService.getOutgoingPaymentDetailsByVoucherNo(voucherNo);
		return list;
	}

	@RequestMapping(value = "/reprintOutgoingPayments", method = RequestMethod.GET)
	public String getreprintOutgoingPayments(Map<String, String> model) {

		return "reprintOutgoingPayments";
	}

	@RequestMapping(value = "/previewOutgoingPayments", method = RequestMethod.POST)
	public ModelAndView printReprintIncomingReceipt(@RequestParam String voucherNo, @RequestParam String inrecDate,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("reprintOutgoingPayments");
		OutgoingPaymentHead outgoingPaymentHead = financeAccountingService.getOutgoingPaymentHeadbyVoucherNo(voucherNo);
		List<OutgoingPaymentDetails> outgoingPaymentDetailsList = financeAccountingService
				.getOutgoingPaymentDetailsByVoucherNo(voucherNo);
		String pdf_result = null;

		ReportViewe view = new ReportViewe();
		try {
			pdf_result = view.pdfReportViewInlineSystemOpen("outgoingPayment.jasper", "outgoingPayment",
					outgoingPaymentDetailsList, null, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String
		// reptValue=outgoingPaymentReceiptGenerate(outgoingPaymentHead,outgoingPaymentDetailsList,response);
		mav.addObject("pdfViewEq", pdf_result);

		return mav;
	}

	@RequestMapping(value = "/getOutgoingPaymentsVoucherNoByDate", method = RequestMethod.GET)
	public @ResponseBody List<OutgoingPaymentHead> getOutgoingPaymentsVoucherNoByDate(@RequestParam String oRdate) {

		List<OutgoingPaymentHead> outgoingPaymentHead = financeAccountingService
				.getOutgoingPaymentsVoucherNoByDate(oRdate);
		return outgoingPaymentHead;
	}

	@RequestMapping(value = "/OutgoingPaymentsDetailsReport", method = RequestMethod.GET)
	public String getOutgoingPaymentsDetailsReport(Map<String, String> model) {

		return "outgoingPaymentDetailReport";

	}

	@RequestMapping(value = "/previewIOutgoingPaymentsDetailsReport", method = RequestMethod.POST)
	public ModelAndView previewIOutgoingPaymentsDetailsReport(String fromdate, String todate,
			HttpServletResponse response, HttpSession session) {

		ModelAndView mav = new ModelAndView("comPdfReportView");

		String centerid = session.getAttribute("centerid") + "";
		CenterMaster centerMaster = centerService.getcenterById(centerid);

		List<OutgoingPaymentDetails> outgoingPaymentDetails = financeAccountingService
				.getOutgoingPaymentHeadDetailsBetweenTwoDays(fromdate, todate);

		List<OutgoingPaymentDetailsReportBeen> outgoingPaymentDetailsReportBeenList = new ArrayList<OutgoingPaymentDetailsReportBeen>();

		for (OutgoingPaymentDetails ihData : outgoingPaymentDetails) {

			OutgoingPaymentDetailsReportBeen outgoingPaymentDetailsReportBeen = new OutgoingPaymentDetailsReportBeen();

			outgoingPaymentDetailsReportBeen.setVoucherno(ihData.getPaymentVoucherNo().getPaymentVoucherNo());
			outgoingPaymentDetailsReportBeen.setGlaccno(ihData.getGlAccNo());
			outgoingPaymentDetailsReportBeen.setGlaccname("");
			outgoingPaymentDetailsReportBeen.setAmount(ihData.getAmount().toString());
			outgoingPaymentDetailsReportBeen.setRemarks(ihData.getRemarks());
			outgoingPaymentDetailsReportBeen.setPaydate(ihData.getPaymentVoucherNo().getPaymentDate());
			outgoingPaymentDetailsReportBeen.setPaytype(ihData.getPaymentVoucherNo().getPaymentMean());
			outgoingPaymentDetailsReportBeen.setDuedate(ihData.getPaymentVoucherNo().getDueDate());
			outgoingPaymentDetailsReportBeen.setPaytime(ihData.getPaymentVoucherNo().getPaymentTime());
			outgoingPaymentDetailsReportBeen.setToorderrof(ihData.getPaymentVoucherNo().getToOrderOf());
			outgoingPaymentDetailsReportBeen.setPayto(ihData.getPaymentVoucherNo().getPayTo());

			outgoingPaymentDetailsReportBeenList.add(outgoingPaymentDetailsReportBeen);

		}

		ReportViewe review = new ReportViewe();
		Map<String, Object> params = new HashMap<>();

		params.put("img", centerMaster.getPartner_ID().getPartner_Logo());
		params.put("hedder", centerMaster.getPartner_ID().getReceiptHeader());
		params.put("address", centerMaster.getAdd03());
		params.put("fromdate", DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(fromdate)));
		params.put("todate", DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(todate)));

		String reptValue = "";

		try {
			reptValue = review.pdfReportViewInlineSystemOpen("outgoingPaymentDetailsReport.jasper",
					"Outgoing Payment Details Report", outgoingPaymentDetailsReportBeenList, params, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("pdfViewEq", reptValue);
		return mav;
	}

	@RequestMapping(value = "/chequePrint", method = RequestMethod.GET)
	public String getchequePrint(Map<String, String> model) {
		// incomingReceiptSummaryRpt ageAnalysisReport
		return "chequePrint";
	}

	// Return all Pending Cheque Payments
	@ModelAttribute("pendingChequePayments")
	public List<OutgoingPaymentHead> getPendingChequePayments() {
		List<OutgoingPaymentHead> list = financeAccountingService.getPendingChequePayments();
		return list;
	}

	@RequestMapping(value = "/chequePreview", method = RequestMethod.GET)
	public ModelAndView chequePreview(@RequestParam(value = "voucherNo") String voucherNo,
			@RequestParam(value = "chequeDate") String chequeDate, HttpServletResponse response, HttpSession session)
			throws ParseException {

		ModelAndView mav = new ModelAndView("chequePrint");

		String centerid = (String) session.getAttribute("centerid");
		CenterMaster centerMaster = centerService.getcenterById(centerid);

		String coordinate = centerMaster.getPartner_ID().getChequePrintConfig();
		String xy[] = coordinate.split("-");

		OutgoingPaymentHead rs = financeAccountingService.getOutgoingPaymentHeadbyVoucherNo(voucherNo);

		Map<String, Object> params = new HashMap<>();
		params.put("date",
				StringFormaterWeb.setLineAndSpace(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])) + chequeDate);
		params.put("pay",
				StringFormaterWeb.setLineAndSpace(Integer.parseInt(xy[2]), Integer.parseInt(xy[3])) + rs.getPayTo());
		params.put("moneyInWords", StringFormaterWeb.setLineAndSpace(Integer.parseInt(xy[4]), Integer.parseInt(xy[5]))
				+ "** " + EnglishNumberToWords.convert(rs.getTotalPayment().longValue()) + " only **");
		Double a = rs.getTotalPayment() * 100;
		params.put("moneyInNumbers", StringFormaterWeb.setLineAndSpace(Integer.parseInt(xy[6]), Integer.parseInt(xy[7]))
				+ "** " + StringFormaterWeb.formatToRupees(a.longValue()) + " **");

		ReportViewe view = new ReportViewe();
		String pdf_result = null;

		try {
			pdf_result = view.pdfReportViewInlineSystemOpen("chequePreview.jasper", "chequePreview", null, params,
					response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("pdfViewEq", pdf_result);
		return mav;
	}

	@RequestMapping(value = "/chartOfAccounts", method = RequestMethod.GET)
	public String createGlaccounts(Map<String, Object> model) {
		Glaccount glaccount = new Glaccount();
		model.put("glaccount", glaccount);
		model.put("allglaccount", financeAccountingService.getAllGlaccounts());

		return "chartOfAccounts";
	}

	@RequestMapping(value = ("/saveGlaccount"), method = RequestMethod.POST)
	public String saveEquipmentMake(@Valid @ModelAttribute("glaccount") Glaccount glaccount, BindingResult br,
			RedirectAttributes redirectAttributes) {

		if (br.hasErrors()) {

			return "chartOfAccounts";
		} else {
			try {
				financeAccountingService.saveGlaccount(glaccount);
				redirectAttributes.addFlashAttribute("success", 1);
			} catch (Exception e) {
				System.out.println(e);
				redirectAttributes.addFlashAttribute("success", 0);
			}
			return "redirect:/chartOfAccounts.do";
		}
	}

	@RequestMapping(value = "/getglaccountByPrimary", method = RequestMethod.POST)
	public @ResponseBody List<Glaccount> getglaccountByPrimary(@RequestParam String priAccount) {

		return financeAccountingService.getglaccountByPrimary(priAccount);

	}

	@RequestMapping("/editGlaccount")
	public ModelAndView getGlaccountbyId(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("chartOfAccounts");
		System.out.println(id);

		Glaccount glaccount = financeAccountingService.getGlaccountbyId(id);
		System.out.println(glaccount);

		mav.addObject("glaccount", glaccount);
		return mav;
	}

	@RequestMapping(value = "/trialBalance", method = RequestMethod.GET)
	public String trialBalance(Map<String, Object> model) {
		return "trialBalance";
	}

	@RequestMapping(value = "/trialBalancePreview", method = RequestMethod.POST)
	public ModelAndView trialBalancePreview(String fromdate, String todate, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("repStatu="+repStatu);
		ModelAndView mav = new ModelAndView("trialBalance");

		String centerid = session.getAttribute("centerid") + "";
		CenterMaster centerMaster = centerService.getcenterById(centerid);

		String[][] glpostData = glAccountService.getGlPostingDateByDate(fromdate, todate, centerid);

		List<TrialBalanceBeen> trialBalanceBeenList = new ArrayList<TrialBalanceBeen>();

		for (int i = 0; i < glpostData.length; i++) {
			TrialBalanceBeen trialBalanceBeen = new TrialBalanceBeen();
			trialBalanceBeen.setGlaccountname(glpostData[i][1]);
			trialBalanceBeen.setPrimaryaccount(glpostData[i][2]);
			trialBalanceBeen.setDr(Double.parseDouble(glpostData[i][3].toString()) / 100);
			trialBalanceBeen.setCr(Double.parseDouble(glpostData[i][4].toString()) / 100);
			trialBalanceBeenList.add(trialBalanceBeen);

		}

		ReportViewe review = new ReportViewe();
		Map<String, Object> params = new HashMap<>();

		params.put("img", centerMaster.getPartner_ID().getPartner_Logo());
		params.put("hedder", centerMaster.getPartner_ID().getReceiptHeader());
		params.put("address", centerMaster.getAdd03());
		params.put("fromdate", DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(fromdate)));
		params.put("todate", DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(todate)));

		String reptValue = "";

		try {
			reptValue = review.pdfReportViewInlineSystemOpen("trialBalanceReport.jasper", "Trial Balance",
					trialBalanceBeenList, params, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("pdfViewEq", reptValue);
		return mav;
	}

	@RequestMapping(value = "/profitsAndLoss", method = RequestMethod.GET)
	public ModelAndView profitsAndLoss(Map<String, Object> model, HttpServletResponse response, HttpSession session) {

		// System.out.println("repStatu="+repStatu);
		ModelAndView mav = new ModelAndView("profitsAndLoss");

		String centerid = session.getAttribute("centerid") + "";
		CenterMaster centerMaster = centerService.getcenterById(centerid);

		String[][] pnldata = glAccountService.getProfitsAndLossData("2021%", centerid);

		List<ProfitsAndLossBeen> profitsAndLossBeenList = new ArrayList<ProfitsAndLossBeen>();

		System.out.println(pnldata);
		for (int i = 0; i < pnldata.length; i++) {
			ProfitsAndLossBeen profitsAndLossBeen = new ProfitsAndLossBeen();

			profitsAndLossBeen.setGlaccountname(pnldata[i][1]);
			profitsAndLossBeen.setPrimaryaccount(pnldata[i][2]);
			profitsAndLossBeen.setAmount(Double.parseDouble(pnldata[i][3].toString()) / 100);

			profitsAndLossBeenList.add(profitsAndLossBeen);

		}

		ReportViewe review = new ReportViewe();
		Map<String, Object> params = new HashMap<>();

		params.put("img", centerMaster.getPartner_ID().getPartner_Logo());
		params.put("hedder", centerMaster.getPartner_ID().getReceiptHeader());
		params.put("address", centerMaster.getAdd03());
		// params.put("fromdate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(fromdate)));
		// params.put("todate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(todate)));

		String reptValue = "";

		try {
			reptValue = review.pdfReportViewInlineSystemOpen("profitsAndLossReport.jasper", "P & L",
					profitsAndLossBeenList, params, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("pdfViewEq", reptValue);
		return mav;

	}

	@RequestMapping(value = "/journalVoucher", method = RequestMethod.GET)
	public String journalVoucher(Map<String, Object> model) {
		return "journalVoucher";
	}

	@ModelAttribute("glaccountList")
	public List<Glaccount> glaccountList() {
		List<Glaccount> models = financeAccountingService.getAllGlaccounts();
		return models;
	}

	@RequestMapping(value = ("/saveJournalVoucher"), method = RequestMethod.POST)
	public @ResponseBody String saveJournalVoucher(@RequestParam("glaccno") String[] glaccno, @RequestParam("dramt") String[] dramt,
			@RequestParam("cramt") String[] cramt, HttpServletResponse response, HttpSession session) {

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			DateTimeFormatter formattertime = DateTimeFormatter.ofPattern("HH:mm:ss");
			LocalTime time = LocalTime.now();

			String centerid = session.getAttribute("centerid") + "";
			CenterMaster centerMaster = centerService.getcenterById(centerid);

			List<GlPostingDetails> glPostingDetailsList = new ArrayList<>();
			List<GlaccountMapping> glMappingResult = glAccountService.getGlaccountMappingByDocId(3);

			GlPostingHead glPostingHead = new GlPostingHead();
			glPostingHead.setDocNo(null);

			glPostingHead.setDocid(null);
			glPostingHead.setDate(formatter.format(date));
			glPostingHead.setTime(time.format(formattertime));
			glPostingHead.setCenterID(centerMaster);
			glPostingHead.setStatus("ACTIVE");

			long crtot = 0;
			long drtot = 0;
			for (int i = 0; i < glaccno.length; i++) {

				GlPostingDetails glPostingDetails1 = new GlPostingDetails();
				glPostingDetails1.setJournalNo(glPostingHead);

				glPostingDetails1.setGlAccNo(new Glaccount(glaccno[i]));
				if (Long.parseLong(dramt[i]) > 0) {
					glPostingDetails1.setType("D");
					glPostingDetails1.setAmount(Long.parseLong(dramt[i]) * 100);
					drtot = drtot + Long.parseLong(dramt[i]);
				}

				if (Long.parseLong(cramt[i]) > 0) {
					glPostingDetails1.setType("C");
					glPostingDetails1.setAmount(Long.parseLong(cramt[i]) * 100);
					crtot = crtot + Long.parseLong(cramt[i]);
				}

				glPostingDetailsList.add(glPostingDetails1);

			}

			glPostingHead.setTotalDR(drtot);
			glPostingHead.setTotalCR(crtot);

			glAccountService.saveGlPostingHeadRepository(glPostingHead);
			glAccountService.saveAllGlPostingDetailsRepository(glPostingDetailsList);

			return "1";

		} catch (Exception e) {
			System.out.println(e);
			return "0";
		}

	}

	@RequestMapping(value = "/glTranctionReport", method = RequestMethod.GET)
	public String glTranctionReport(Map<String, Object> model) {
		return "glTranctionReport";
	}

	@RequestMapping(value = "/glTranctionReportPreview", method = RequestMethod.POST)
	public ModelAndView trialBalancePreview(String fromdate, String todate, String glaccno,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("repStatu="+repStatu);
		ModelAndView mav = new ModelAndView("glTranctionReport");

		String centerid = session.getAttribute("centerid") + "";
		CenterMaster centerMaster = centerService.getcenterById(centerid);

		String title = "";
		String[][] glpostData = glAccountService.getGlPostingDateByGlaccno(fromdate, todate, glaccno, centerid);

		List<GlTranctionReportBeen> glTranctionReportBeenList = new ArrayList<GlTranctionReportBeen>();
		// System.out.println(glpostData);

		for (int i = 0; i < glpostData.length; i++) {
			// System.out.println(glpostData[i][0].toString());
			GlTranctionReportBeen glTranctionReportBeen = new GlTranctionReportBeen();

			glTranctionReportBeen.setJournalno(glpostData[i][0].toString());
			glTranctionReportBeen.setDoctype(glpostData[i][1].toString());
			glTranctionReportBeen.setDocument(glpostData[i][2].toString());
			glTranctionReportBeen.setPrimaryaccount(glpostData[i][4].toString());
			glTranctionReportBeen.setDr(Double.parseDouble(glpostData[i][5].toString()) / 100);
			glTranctionReportBeen.setCr(Double.parseDouble(glpostData[i][6].toString()) / 100);
			glTranctionReportBeen.setDate(glpostData[i][7].toString());
			title = glaccno + "-" + glpostData[i][3].toString();
			glTranctionReportBeenList.add(glTranctionReportBeen);
		}

		ReportViewe review = new ReportViewe();
		Map<String, Object> params = new HashMap<>();

		params.put("img", centerMaster.getPartner_ID().getPartner_Logo());
		params.put("hedder", centerMaster.getPartner_ID().getReceiptHeader());
		params.put("address", centerMaster.getAdd03());
		params.put("fromdate", DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(fromdate)));
		params.put("todate", DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(todate)));
		params.put("title", title);

		String reptValue = "";

		try {
			reptValue = review.pdfReportViewInlineSystemOpen("glTranctionReport.jasper", "GL Tranction Report",
					glTranctionReportBeenList, params, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("pdfViewEq", reptValue);
		return mav;
	}

	@RequestMapping(value = "/createBank", method = RequestMethod.GET)
	public ModelAndView createBank() {
		ModelAndView mav = new ModelAndView("createBank");
		mav.addObject("bankMaster", new BankMaster());
		List<BankMaster> allBank = financeAccountingService.getBankMasterAll();
		mav.addObject("allBankMasterDetails", allBank);
		return mav;
	}

	@RequestMapping(value = ("/saveBankMaster"), method = RequestMethod.POST)
	public String saveBank(@ModelAttribute("bankMaster") BankMaster bankMaster, HttpSession session) {
		// System.out.println("ccc="+glaccount.getParentsAccount());

		String centerid = session.getAttribute("centerid") + "";
		CenterMaster centerMaster = centerService.getcenterById(centerid);
		try {

			bankMaster.setCompany(centerMaster.getPartner_ID());
			financeAccountingService.saveBankMaster(bankMaster);
			// redirectAttributes.addFlashAttribute("success",1);
		} catch (Exception e) {
			System.out.println(e);
			// redirectAttributes.addFlashAttribute("success",0);
		}
		return "redirect:/createBank.do";
	}

	@RequestMapping(value = "/createBankBranch", method = RequestMethod.GET)
	public ModelAndView createBankBranch() {
		ModelAndView mav = new ModelAndView("createBankBranch");
		mav.addObject("branch", new Bank());
		List<Bank> allBank = financeAccountingService.getBankBranchAll();
		mav.addObject("allBankDetails", allBank);
		return mav;
	}

	@ModelAttribute("bankNameList")
	public List<BankMaster> getBankMasterDetails() {
		List<BankMaster> allBank = financeAccountingService.getBankMasterAll();
		return allBank;
	}

	@RequestMapping(value = ("/saveBranch"), method = RequestMethod.POST)
	public String saveBank(@ModelAttribute("branch") Bank branch) {
		// System.out.println("ccc="+glaccount.getParentsAccount());

		try {
			financeAccountingService.saveBankBranch(branch);
			;
			// redirectAttributes.addFlashAttribute("success",1);
		} catch (Exception e) {
			System.out.println(e);
			// redirectAttributes.addFlashAttribute("success",0);
		}
		return "redirect:/createBankBranch.do";
	}

	@ModelAttribute("bankBranchList")
	public List<Bank> getbankBranchListDetails() {
		List<Bank> allBank = financeAccountingService.getBankBranchAll();
		return allBank;
	}

	@RequestMapping(value = "/partnerBankAccount", method = RequestMethod.GET)
	public ModelAndView bankAccount() {
		ModelAndView mav = new ModelAndView("partnerBankAccount");
		mav.addObject("bankAccount", new PartnerBankAccount());
		List<PartnerBankAccount> allaccount = financeAccountingService.getPartnerBankAccountAll();
		mav.addObject("allaccountetails", allaccount);
		return mav;
	}

	@RequestMapping(value = ("/saveBankAccount"), method = RequestMethod.POST)
	public String saveBankAccount(@ModelAttribute("bankAccount") PartnerBankAccount partnerBankAccount) {
		// System.out.println("ccc="+glaccount.getParentsAccount());

		try {
			financeAccountingService.savePartnerBankAccount(partnerBankAccount);
			// redirectAttributes.addFlashAttribute("success",1);
		} catch (Exception e) {
			System.out.println(e);
			// redirectAttributes.addFlashAttribute("success",0);
		}
		return "redirect:/partnerBankAccount";
	}

	@RequestMapping(value = "/APInvoice", method = RequestMethod.GET)
	public String apInvoicePage(Model model) {
		APInvoiceHead apInvoiceHead = new APInvoiceHead();
		model.addAttribute("apInvoiceForm", apInvoiceHead);
		/*
		 * System.out.println( "AP Invoice Head ID : " +
		 * "00000".substring(financeAccountingService.maxAPInvoiceHeadId().length()) +
		 * financeAccountingService.maxAPInvoiceHeadId());
		 */
		return "apInvoice";
	}

	@RequestMapping(value = "/getGLAccounts", method = RequestMethod.GET)
	public @ResponseBody List<Glaccount> getGLAccounts() {
		List<Glaccount> glAccounts = glAccountService.findAll();
		return glAccounts;
	}

	@RequestMapping(value = "/saveAPInvoice", method = RequestMethod.POST)
	public String saveAPInvoice(@Valid @ModelAttribute("apInvoiceForm") APInvoiceHead apInvoiceHead, BindingResult br,
			@RequestParam(value = "detailsGlAccount") String[] detailsGlAccount,
			@RequestParam(value = "detailsDescription") String[] detailsDescription,
			@RequestParam(value = "detailsAmount") String[] detailsAmount,
			@RequestParam(value = "taxesGlAccount") String[] taxesGlAccount,
			@RequestParam(value = "taxesDescription") String[] taxesDescription,
			@RequestParam(value = "taxesAmount") String[] taxesAmount, Model m, HttpSession session,
			HttpServletResponse response) {

		Long netTotal = 0L;
		List<APInvoiceDetails> apInvoiceDetailsList = new ArrayList<>();
		List<APInvoiceTax> apInvoiceTaxList = new ArrayList<>();
		apInvoiceHead.setApInvoiceHeadId("00000".substring(financeAccountingService.maxAPInvoiceHeadId().length())
				+ financeAccountingService.maxAPInvoiceHeadId());

		for (int c = 0; c < detailsAmount.length; c++) {
			netTotal = netTotal + (Double.valueOf(detailsAmount[c]).longValue() * 100);
		}

		for (int d = 0; d < taxesAmount.length; d++) {
			netTotal = netTotal + (Double.valueOf(taxesAmount[d]).longValue() * 100);
		}

		apInvoiceHead.setNetTotal(netTotal);

		for (int e = 0; e < detailsGlAccount.length; e++) {
			APInvoiceDetails apInvoiceDetails = new APInvoiceDetails();
			Glaccount glaccount = new Glaccount();
			glaccount.setGlAccNo(detailsGlAccount[e]);
			apInvoiceDetails.setApInvoiceHeadId(apInvoiceHead);
			apInvoiceDetails.setGlAccNo(glaccount);
			apInvoiceDetails.setDescription(detailsDescription[e]);
			apInvoiceDetails.setAmount(Double.valueOf(detailsAmount[e]).longValue() * 100);
			apInvoiceDetailsList.add(apInvoiceDetails);
		}

		for (int f = 0; f < taxesGlAccount.length; f++) {
			APInvoiceTax apInvoiceTax = new APInvoiceTax();
			Glaccount glaccount = new Glaccount();
			glaccount.setGlAccNo(taxesGlAccount[f]);
			apInvoiceTax.setApInvoiceHeadId(apInvoiceHead);
			apInvoiceTax.setGlAccNo(glaccount);
			apInvoiceTax.setDescription(taxesDescription[f]);
			apInvoiceTax.setAmount(Double.valueOf(taxesAmount[f]).longValue() * 100);
			apInvoiceTaxList.add(apInvoiceTax);
		}

		financeAccountingService.saveAPInvoiceHead(apInvoiceHead);
		financeAccountingService.saveAPInvoiceDetailList(apInvoiceDetailsList);
		financeAccountingService.saveAPInvoiceTaxList(apInvoiceTaxList);

		return "redirect:/APInvoice";
	}

	@RequestMapping(value = "/APInvoiceSummaryReport", method = RequestMethod.GET)
	public String apInvoiceHeadReportPage(Model model) {
		return "apInvoiceSummaryReport";
	}

	@RequestMapping(value = "/getAPInvoiceHeadIdsByDate", method = RequestMethod.GET)
	public @ResponseBody List<APInvoiceHead> getAPInvoiceHeadIdsByDate(@RequestParam String date) {
		List<APInvoiceHead> apInvoiceHeadList = financeAccountingService.getAPInvoiceHeadIdsByDate(date);
		return apInvoiceHeadList;
	}

	@RequestMapping(value = "/previewAPInvoiceSummaryReport", method = RequestMethod.POST)
	public ModelAndView previewAPInvoiceHeadReport(@RequestParam String fromDate, @RequestParam String toDate, 
			HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView("apInvoiceSummaryReport");
		String centerid = session.getAttribute("centerid")+"";
		CenterMaster centerMaster = centerService.getcenterById(centerid);
		List<APInvoiceHead> list = new ArrayList<>();
		List<APInvoiceHead> apInvoiceHeadList = financeAccountingService.getAPInvoiceHeadByDates(fromDate, toDate);
		for (int i = 0; i < apInvoiceHeadList.size(); i++) {
			APInvoiceHead apInvoiceHead = new APInvoiceHead();
			apInvoiceHead.setApInvoiceHeadId(apInvoiceHeadList.get(i).getApInvoiceHeadId());
			apInvoiceHead.setSupplierId(apInvoiceHeadList.get(i).getSupplierId());
			apInvoiceHead.setSupplierGlCode(apInvoiceHeadList.get(i).getSupplierGlCode());
			apInvoiceHead.setDate(apInvoiceHeadList.get(i).getDate());
			apInvoiceHead.setNetTotal(apInvoiceHeadList.get(i).getNetTotal()/100);
			list.add(apInvoiceHead);
			
		}
		String pdf_result = null;
		String reportName = "AP Invoice Head Report - " + fromDate + " - " + toDate;
		ReportViewe view = new ReportViewe();
		Map<String,Object> params = new HashMap<>();
    	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
      	params.put("header",centerMaster.getPartner_ID().getReceiptHeader());
      	params.put("address",centerMaster.getAdd03());
      	params.put("fromDate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(fromDate)));
      	params.put("toDate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(toDate)));
		try {
			pdf_result = view.pdfReportViewInlineSystemOpen("apInvoiceSummaryReport.jasper", reportName, list, params,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("pdfViewEq", pdf_result);
		return mav;
	}
}