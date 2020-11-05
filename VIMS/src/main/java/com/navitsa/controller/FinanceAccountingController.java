package com.navitsa.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.navitsa.Reports.Contact;
import com.navitsa.Reports.ContactForm;
import com.navitsa.Reports.IncomingReceiptBeen;
import com.navitsa.Reports.IncomingReceiptSummaryBeen;
import com.navitsa.Reports.NumberDataBeen;
import com.navitsa.Reports.OutgoingPaymentBeen;
import com.navitsa.Reports.OutgoingPaymentDetailsReportBeen;
import com.navitsa.entity.CenterMaster;
import com.navitsa.entity.Customer;
import com.navitsa.entity.IncomingReceiptDetails;
import com.navitsa.entity.IncomingReceiptHead;
import com.navitsa.entity.OcrDetails;
import com.navitsa.entity.OutgoingPaymentDetails;
import com.navitsa.entity.OutgoingPaymentHead;
import com.navitsa.services.BusinessPartnerService;
import com.navitsa.services.CenterService;
import com.navitsa.services.FinanceAccountingService;
import com.navitsa.utils.DateHelperWeb;
import com.navitsa.utils.ReportViewe;
import com.navitsa.utils.StringFormaterWeb;

@Controller
public class FinanceAccountingController {

	@Autowired
	FinanceAccountingService financeAccountingService;
	
	@Autowired
	CenterService centerService;
	
	@Autowired
	BusinessPartnerService businessPartnerService;
	

	
	  @RequestMapping(value = "/outgoingPayments", method=RequestMethod.GET) 
	  public String getAgeAnalysisReport(Map<String, String> model) { 
		 // incomingReceiptSummaryRpt ageAnalysisReport
		  return "outgoingPayments";
	  }
	  
	  @RequestMapping(value = "saveoutgoingPayments", method = RequestMethod.POST)
	  public ModelAndView saveNewUsers(
			  @ModelAttribute("contactForm") ContactForm contactForm,HttpServletResponse response,HttpSession session) {
		ModelAndView mav = new ModelAndView("outgoingPaymentsPreiew");
		
		System.out.println("ppppppppppppppppp=");
		System.out.println(contactForm);
		System.out.println(contactForm.getContacts());
		List<Contact> contacts = contactForm.getContacts();
		
		if(null != contacts && contacts.size() > 0) {
		//	ContactController.contacts = contacts;
			for (Contact contact : contacts) {
				System.out.printf("%s \t %s \n", contact.getAmount());
			}
		}
		
//		
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
//	    Date date = new Date(); 
//	    DateTimeFormatter formattertime = DateTimeFormatter.ofPattern("HH:mm:ss");
//	    LocalTime time = LocalTime.now();
//		
//		  String centerid=session.getAttribute("centerid")+"";
//		  CenterMaster centerMaster=centerService.getcenterById(centerid);
//		  
//	       	int maxVouNo=centerMaster.getPartner_ID().getMaxVouNo();
//	    	String outVouFormate=centerMaster.getPartner_ID().getOutVouFormate();
//	    	String nextoutVouFormate=outVouFormate+(maxVouNo+1);
//	    
//		OutgoingPaymentHead outgoingPaymentHead=new OutgoingPaymentHead();
//		outgoingPaymentHead.setPaymentVoucherNo(nextoutVouFormate);
//		outgoingPaymentHead.setDueDate(payDueDate);
//		outgoingPaymentHead.setPaymentDate(formatter.format(date));
//		outgoingPaymentHead.setPaymentTime(time.format(formattertime));
//		outgoingPaymentHead.setToOrderOf(toOrderOf);
//		outgoingPaymentHead.setPayTo(payTo);
//		outgoingPaymentHead.setPayType(paytype);
//		outgoingPaymentHead.setChequeNo(chequeNo);
//		outgoingPaymentHead.setAcType(actype);
//		outgoingPaymentHead.setStatus("ACTIVE");
//		outgoingPaymentHead.setCenter_ID(centerMaster);
//		outgoingPaymentHead.setChequePrint("NO");
//		
//		List<OutgoingPaymentDetails> OutgoingPaymentDetailsList=new ArrayList<OutgoingPaymentDetails>();
//		
//		
//		
//		OutgoingPaymentDetails outgoingPaymentDetails=new OutgoingPaymentDetails();
//		outgoingPaymentDetails.setPaymentVoucherNo(outgoingPaymentHead);
//		
//		outgoingPaymentDetails.setgLAccNo("dfdf");
//		outgoingPaymentDetails.setRemarks("rrrrr");
//		outgoingPaymentDetails.setAmount(0);
//		
//		OutgoingPaymentDetailsList.add(outgoingPaymentDetails);
//		
//		
//		
//		
//		outgoingPaymentHead.setTotalPayment(0);
//		
//		
//		financeAccountingService.saveOutgoingPaymentHead(outgoingPaymentHead);
//		
//		
//		financeAccountingService.saveAllOutgoingPaymentDetails(OutgoingPaymentDetailsList);
//		
//		businessPartnerService.setUpdateLastinRecNo(centerMaster.getPartner_ID().getPartner_ID());
//		
//		 String reptValue=outgoingPaymentReceiptGeaerate(outgoingPaymentHead,OutgoingPaymentDetailsList,response);
//		 mav.addObject("pdfViewEq", reptValue);
//		
		return mav;
	  }	  
	  
	
		public String outgoingPaymentReceiptGeaerate(OutgoingPaymentHead outgoingPaymentHead,
				   List<OutgoingPaymentDetails> outgoingPaymentDetails, HttpServletResponse response) {

					if (outgoingPaymentHead.getStatus().toString().equals("ACTIVE")) {
						

						List<OutgoingPaymentBeen> outgoingPaymentBeenList=new ArrayList<OutgoingPaymentBeen>();
						
						for(OutgoingPaymentDetails outgoingPayDetails:outgoingPaymentDetails) {
							OutgoingPaymentBeen outgoingPaymentBeen=new OutgoingPaymentBeen();
							outgoingPaymentBeen.setGlaccno(outgoingPayDetails.getgLAccNo());
							outgoingPaymentBeen.setGlaccname("");
							outgoingPaymentBeen.setAmount(StringFormaterWeb.formatToRupees(outgoingPayDetails.getAmount()));
							outgoingPaymentBeen.setRemarks(outgoingPayDetails.getRemarks());
							outgoingPaymentBeen.setStyle(false);
							outgoingPaymentBeenList.add(outgoingPaymentBeen);
						
						//totalPay=totalPay+incomingReceiptDetails.getPayAmount();
						}
						
						
//						IncomingReceiptBeen incomingReceiptBeen2=new IncomingReceiptBeen();
//						incomingReceiptBeen2.setInvno("TOTAL");
//						incomingReceiptBeen2.setVecno("");
//						incomingReceiptBeen2.setInctotal("");
//						incomingReceiptBeen2.setPayamount(StringFormaterWeb.formatToRupees(totalPay));
//						incomingReceiptBeen2.setBalance("");
//						incomingReceiptBeen2.setStyle(true);
//						incomingReceiptBeenList.add(incomingReceiptBeen2);
						
						
						
						
//						CenterMaster centerMaster = centerService.getcenterById(vehiclereg.getCentermaster().getCenter_ID());

						ReportViewe review = new ReportViewe();
						Map<String, Object> params = new HashMap<>();
						params.put("img", outgoingPaymentHead.getCenter_ID().getPartner_ID().getPartner_Logo());
						params.put("hedder", outgoingPaymentHead.getCenter_ID().getPartner_ID().getReceiptHeader());
						params.put("address", outgoingPaymentHead.getCenter_ID().getAdd03());
						params.put("footer", outgoingPaymentHead.getCenter_ID().getPartner_ID().getReceiptFooter());
	
						params.put("payvouchno", outgoingPaymentHead.getPaymentVoucherNo());
						params.put("paytime", outgoingPaymentHead.getPaymentTime());
						params.put("paydate", outgoingPaymentHead.getPaymentDate());
						params.put("paytype", outgoingPaymentHead.getPayType());
						
						params.put("toorderof", outgoingPaymentHead.getToOrderOf());
						params.put("payto", outgoingPaymentHead.getPayTo());
						params.put("chequeno", outgoingPaymentHead.getChequeNo());
						params.put("duedate", outgoingPaymentHead.getDueDate());
						params.put("acctyp", outgoingPaymentHead.getAcType());
						
						String reptValue = "";

						try {
							reptValue = review.pdfReportViewInlineSystemOpen("outgoingPayment.jasper", "Outgoing Payment",
									outgoingPaymentBeenList, params, response);

						} catch (Exception e) {
							e.printStackTrace();
						}
						return reptValue;
					} else {

						return "INACTIVE";

					}

				}
	  
		  
	  
		  @RequestMapping(value = "/reprintOutgoingPayments", method=RequestMethod.GET) 
		  public String getreprintOutgoingPayments(Map<String, String> model) { 
			  
			  return "reprintOutgoingPayments";
		  }	
		  
		  @RequestMapping(value="/PrivewOutgoingPayments" ,method=RequestMethod.POST) 
		  public ModelAndView printReprintIncomingReceipt(@RequestParam String voucherNo,@RequestParam String inrecDate,HttpServletResponse response) {
			  	ModelAndView mav = new ModelAndView("reprintOutgoingPayments");
	  	
			  	OutgoingPaymentHead outgoingPaymentHead=financeAccountingService.getOutgoingPaymentHeadbyVoucherNo(voucherNo);	  	
			  	List<OutgoingPaymentDetails> outgoingPaymentDetailsList=financeAccountingService.getOutgoingPaymentDetailsByVoucherNo(voucherNo);
			  	
			  	
				 String reptValue=outgoingPaymentReceiptGeaerate(outgoingPaymentHead,outgoingPaymentDetailsList,response);
				 mav.addObject("pdfViewEq", reptValue);

	         return mav;
		  }
	  
		  @RequestMapping(value = "/getOutgoingPaymentsVoucherNoByDate", method=RequestMethod.GET) 
		  public @ResponseBody List<OutgoingPaymentHead> getOutgoingPaymentsVoucherNoByDate(@RequestParam String oRdate) { 			  
			  List<OutgoingPaymentHead> outgoingPaymentHead = financeAccountingService.getOutgoingPaymentsVoucherNoByDate(oRdate);
			  return outgoingPaymentHead;
		  }
		  @RequestMapping(value = "/OutgoingPaymentsDetailsReport", method=RequestMethod.GET) 
		  public String getOutgoingPaymentsDetailsReport(Map<String, String> model) { 
			 // incomingReceiptSummaryRpt
			  return "OutgoingPaymentsDetailsReport";
		  }
		  
		  @RequestMapping(value = "/previewIOutgoingPaymentsDetailsReport",method=RequestMethod.POST)
		  public ModelAndView previewIOutgoingPaymentsDetailsReport(String fromdate,String todate,HttpServletResponse response,HttpSession session) {
			 // System.out.println("repStatu="+repStatu);
			  ModelAndView mav = new ModelAndView("OutgoingPaymentsDetailsReport");
			  
			  String centerid=session.getAttribute("centerid")+"";
			  CenterMaster centerMaster=centerService.getcenterById(centerid);
			  
			  List<OutgoingPaymentDetails> outgoingPaymentDetails=financeAccountingService.getOutgoingPaymentHeadDetailsBetweenTwoDays(fromdate,todate);	
			  
			  List<OutgoingPaymentDetailsReportBeen> outgoingPaymentDetailsReportBeenList = new ArrayList<OutgoingPaymentDetailsReportBeen>();
			  
			  	for(OutgoingPaymentDetails ihData:outgoingPaymentDetails) {
		
				  	
				  		OutgoingPaymentDetailsReportBeen outgoingPaymentDetailsReportBeen=new OutgoingPaymentDetailsReportBeen();
				  		
				  		outgoingPaymentDetailsReportBeen.setVoucherno(ihData.getPaymentVoucherNo().getPaymentVoucherNo());
				  		outgoingPaymentDetailsReportBeen.setGlaccno(ihData.getgLAccNo());
				  		outgoingPaymentDetailsReportBeen.setGlaccname("");
				  		outgoingPaymentDetailsReportBeen.setAmount(StringFormaterWeb.formatToRupees(ihData.getAmount()));
				  		outgoingPaymentDetailsReportBeen.setRemarks(ihData.getRemarks());
				  		outgoingPaymentDetailsReportBeen.setPaydate(ihData.getPaymentVoucherNo().getPaymentDate());
				  		outgoingPaymentDetailsReportBeen.setPaytype(ihData.getPaymentVoucherNo().getPayType());
				  		outgoingPaymentDetailsReportBeen.setDuedate(ihData.getPaymentVoucherNo().getDueDate());
				  		outgoingPaymentDetailsReportBeen.setPaytime(ihData.getPaymentVoucherNo().getPaymentTime());
				  		outgoingPaymentDetailsReportBeen.setToorderrof(ihData.getPaymentVoucherNo().getToOrderOf());
				  		outgoingPaymentDetailsReportBeen.setPayto(ihData.getPaymentVoucherNo().getPayTo());

				  		
				  		
				  		outgoingPaymentDetailsReportBeenList.add(outgoingPaymentDetailsReportBeen);
				  	
			  	}
		
	          	ReportViewe review=new ReportViewe();
	          	Map<String,Object> params = new HashMap<>();

	        	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
	          	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
	          	params.put("address",centerMaster.getAdd03() );
	          	params.put("fromdate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(fromdate)));
	          	params.put("todate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(todate)));
	       
	          	String reptValue="";
	          	
	         try {
	          		reptValue=review.pdfReportViewInlineSystemOpen("outgoingPaymentDetailsReport.jasper","Outgoing Payment Details Report",outgoingPaymentDetailsReportBeenList,params,response);
	          		
	          
	          	}catch(Exception e) {	          		
	          		e.printStackTrace();          		
	          	}
	         
			  mav.addObject("pdfViewEq", reptValue); 
			  return mav;
		  }
		  
		  @RequestMapping(value = "/chequePrint", method=RequestMethod.GET) 
		  public String getchequePrint(Map<String, String> model) { 
			 // incomingReceiptSummaryRpt ageAnalysisReport
			  return "chequePrint";
		  }
		  
		  @RequestMapping(value = "/chequePreview",method=RequestMethod.POST)
		  public ModelAndView chequePreview(HttpServletResponse response,HttpSession session) {
			 // System.out.println("repStatu="+repStatu);
			  ModelAndView mav = new ModelAndView("chequePrint");
			  
			  String centerid=session.getAttribute("centerid")+"";
			  CenterMaster centerMaster=centerService.getcenterById(centerid);
			 
			  String chequePrintconfig=centerMaster.getPartner_ID().getChequePrintConfig();
			  String cpconList[]=chequePrintconfig.split("-");
		
			  
	          	ReportViewe review=new ReportViewe();
	          	Map<String,Object> params = new HashMap<>();

	        	params.put("date",StringFormaterWeb.setLineAndSpace(Integer.parseInt(cpconList[0]),Integer.parseInt(cpconList[1]))+"20/01/2020");
	          	params.put("chequeno",StringFormaterWeb.setLineAndSpace(Integer.parseInt(cpconList[2]),Integer.parseInt(cpconList[3]))+"34343-3423525");
	          	params.put("amount",StringFormaterWeb.setLineAndSpace(Integer.parseInt(cpconList[4]),Integer.parseInt(cpconList[5]))+"500");
	          	params.put("amountinword",StringFormaterWeb.setLineAndSpace(Integer.parseInt(cpconList[6]),Integer.parseInt(cpconList[7]))+"fgf");
	          	params.put("duedata",StringFormaterWeb.setLineAndSpace(Integer.parseInt(cpconList[8]),Integer.parseInt(cpconList[9]))+"01/01/2020");
	       
	          	String reptValue="";
	          	
	         try {
	          		reptValue=review.pdfReportViewInlineSystemOpen("chequePre.jasper","Cheque",null,params,response);
	          		
	          
	          	}catch(Exception e) {	          		
	          		e.printStackTrace();          		
	          	}
	         
			  mav.addObject("pdfViewEq", reptValue); 
			  return mav;
		  } 
		  
}
