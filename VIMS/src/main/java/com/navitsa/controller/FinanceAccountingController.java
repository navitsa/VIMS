package com.navitsa.controller;

import java.util.ArrayList;
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

import com.navitsa.Reports.OutgoingPaymentDetailsReportBeen;
import com.navitsa.Reports.ProfitsAndLossBeen;
import com.navitsa.Reports.TrialBalanceBeen;
import com.navitsa.entity.CenterMaster;
import com.navitsa.entity.Glaccount;
import com.navitsa.entity.OutgoingPaymentDetails;
import com.navitsa.entity.OutgoingPaymentHead;
import com.navitsa.services.BusinessPartnerService;
import com.navitsa.services.CenterService;
import com.navitsa.services.FinanceAccountingService;
import com.navitsa.services.GlAccountService;
import com.navitsa.utils.DateHelperWeb;
import com.navitsa.utils.ReportViewe;
import com.navitsa.utils.StringFormaterWeb;

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
	  public String viewOutgoingPaymentForm(Model m,HttpSession session) {
	    
		  OutgoingPaymentHead obj = new OutgoingPaymentHead();
		  m.addAttribute("outgoingPaymentForm",obj);
		  return "outgoingPayments";
	  }
	  
	//Return all GLs
	 @ModelAttribute("listGLAccounts")
	 	public List<Glaccount> findAll(){
		 List<Glaccount> list = glAccountService.findAll();
		 return list;
	 }
	 
	 @RequestMapping(value="/saveOutgoingPayment" ,method=RequestMethod.POST)
	 public ModelAndView saveOutgoingPayment(@Valid @ModelAttribute("outgoingPaymentForm") OutgoingPaymentHead outgoingPaymentHead, BindingResult br,
			 @RequestParam(value = "glAccNo") String[] glAccNo,
			 @RequestParam(value = "amount") Double[] amount,
			 @RequestParam(value = "remarks") String[] remarks,
			 Model m,HttpSession session,HttpServletResponse response) {
		 
			 if(br.hasErrors())  
		        {  
				 //return "outgoingPayments";  
		        }  
		        else  
		        { 		        	
		        	try {
		        		String centerid=(String) session.getAttribute("centerid");
		        		CenterMaster cm=centerService.getcenterById(centerid);
		        		String nextVoucherNo = cm.getPartner_ID().getOutVouFormate()+(cm.getPartner_ID().getMaxVouNo()+1);
		        		
		        		outgoingPaymentHead.setPaymentVoucherNo(nextVoucherNo);
		        		outgoingPaymentHead.setCenter_ID(cm);
		        		outgoingPaymentHead.setStatus("Active");
		        		if(outgoingPaymentHead.getPaymentMean().equalsIgnoreCase("Cheque")) {
		        			outgoingPaymentHead.setChequePrint("Pending");
		        		}

		        		List<OutgoingPaymentDetails> list = new ArrayList<OutgoingPaymentDetails>();
		        		double totalAmount = 0;
			       		 for(int i=0; i < glAccNo.length; i++){
			       			OutgoingPaymentDetails paymentDetail = new OutgoingPaymentDetails();
			       			paymentDetail.setGlAccNo(glAccNo[i]);
			       			paymentDetail.setAmount(amount[i]);
			       			paymentDetail.setRemarks(remarks[i]);
			       			paymentDetail.setPaymentVoucherNo(outgoingPaymentHead);
			       			list.add(paymentDetail);
			       			totalAmount = totalAmount+amount[i];
			    		 }
			       		 
			       		outgoingPaymentHead.setTotalPayment(totalAmount);
		        		financeAccountingService.saveOutgoingPaymentHead(outgoingPaymentHead);
		        		bPartnerService.setUpdateLastPaymentVoucherNo(cm.getPartner_ID().getPartner_ID());
			       		financeAccountingService.saveAllOutgoingPaymentDetails(list);
			       		      		
			       		ModelAndView mav = new ModelAndView("comPdfReportView");		       		
			       		ReportViewe view =new ReportViewe();
			       		String pdf_result = null;
						 
						try {
							pdf_result = view.pdfReportViewInlineSystemOpen("outgoingPayment.jasper", "outgoingPayment",list, null, response);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						mav.addObject("pdfViewEq", pdf_result); 
						return mav;
			       		
			        	//return "redirect:/outgoingPayments";
						
					} catch (Exception e) {
						//m.addAttribute("success",0);
					}

		        }
			return null;
			 
			 //return "outgoingPayments";  
	
	 }  

	  @RequestMapping(value = "/getOutgoingPaymentDetails", method=RequestMethod.GET) 
	  public @ResponseBody List<OutgoingPaymentDetails> getOutgoingPaymentDetails(@RequestParam String voucherNo) { 			  
		  List<OutgoingPaymentDetails> list = financeAccountingService.getOutgoingPaymentDetailsByVoucherNo(voucherNo);
		  return list;
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
			  	
			  	
				 //String reptValue=outgoingPaymentReceiptGenerate(outgoingPaymentHead,outgoingPaymentDetailsList,response);
				 //mav.addObject("pdfViewEq", reptValue);

	         return mav;
		  }
	  
		  @RequestMapping(value = "/getOutgoingPaymentsVoucherNoByDate", method=RequestMethod.GET) 
		  public @ResponseBody List<OutgoingPaymentHead> getOutgoingPaymentsVoucherNoByDate(@RequestParam String oRdate) { 			  
			  List<OutgoingPaymentHead> outgoingPaymentHead = financeAccountingService.getOutgoingPaymentsVoucherNoByDate(oRdate);
			  return outgoingPaymentHead;
		  }
		  @RequestMapping(value = "/OutgoingPaymentsDetailsReport", method=RequestMethod.GET) 
		  public String getOutgoingPaymentsDetailsReport(Map<String, String> model) { 
			  
			  return "outgoingPaymentDetailReport";
			  
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
		  
		  @RequestMapping("/chequePrint") 
		  public String getchequePrint() { 
			  return "chequePrint";
		  }
		  
		  @RequestMapping(value = "/chequePreview",method=RequestMethod.GET)
		  public ModelAndView chequePreview(HttpServletResponse response,HttpSession session) {
			  
			  ModelAndView mav = new ModelAndView("chequePrint");
			  
			  String centerid=(String) session.getAttribute("centerid");
			  CenterMaster centerMaster=centerService.getcenterById(centerid);
			  
			  String coordinate = centerMaster.getPartner_ID().getChequePrintConfig();
			  String xy[]=coordinate.split("-");
		
	          Map<String,Object> params = new HashMap<>();
	          params.put("date",StringFormaterWeb.setLineAndSpace(Integer.parseInt(xy[0]),Integer.parseInt(xy[1]))+"1 5 0 3 2 0 2 1");
	          params.put("pay",StringFormaterWeb.setLineAndSpace(Integer.parseInt(xy[2]),Integer.parseInt(xy[3]))+"National Institute Of Business Management");
	          params.put("moneyInWords",StringFormaterWeb.setLineAndSpace(Integer.parseInt(xy[4]),Integer.parseInt(xy[5]))+"** twelve million three hundred forty-five thousand six hundred seventy-eight Only **");
	          params.put("moneyInNumbers",StringFormaterWeb.setLineAndSpace(Integer.parseInt(xy[6]),Integer.parseInt(xy[7]))+"** 12,345,678.00 **");
	          
	          ReportViewe view=new ReportViewe();
	          String pdf_result=null;
	          	
	         try {
	        	 pdf_result=view.pdfReportViewInlineSystemOpen("chequePreview.jasper","chequePreview",null,params,response);
	          		
	          
	          	}catch(Exception e) {	          		
	          		e.printStackTrace();          		
	          	}
	         
			  mav.addObject("pdfViewEq", pdf_result); 
			  return mav;
		  }
		  
		  @RequestMapping(value = "/chartOfAccounts", method=RequestMethod.GET) 
		  public String createGlaccounts(Map<String, Object> model) { 
			  Glaccount glaccount=new Glaccount();			 			  
			  model.put("glaccount", glaccount); 
			  model.put("allglaccount", financeAccountingService.getAllGlaccounts()); 
			  
			  return "chartOfAccounts";
		  }
		  
  
			@RequestMapping(value = ("/saveGlaccount"), method = RequestMethod.POST)
			public String saveEquipmentMake(@Valid @ModelAttribute("glaccount")Glaccount glaccount, BindingResult br,RedirectAttributes redirectAttributes) {
				//System.out.println("ccc="+glaccount.getParentsAccount());
				if(br.hasErrors()) {
					
					return "chartOfAccounts";
				}
				else {
				try {
					financeAccountingService.saveGlaccount(glaccount);
				redirectAttributes.addFlashAttribute("success",1);
				}catch(Exception e) {
					System.out.println(e);
					redirectAttributes.addFlashAttribute("success",0);
				}
				return "redirect:/chartOfAccounts.do";
				}
			}
		  
			@RequestMapping(value = "/getglaccountByPrimary", method = RequestMethod.POST)
			public  @ResponseBody  List<Glaccount> getglaccountByPrimary(@RequestParam String priAccount){
				
		
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
			
			
			  @RequestMapping(value = "/trialBalance", method=RequestMethod.GET) 
			  public String trialBalance(Map<String, Object> model) { 			  
				  return "trialBalance";
			  }
			  
			  
			  
			  @RequestMapping(value = "/trialBalancePreview",method=RequestMethod.POST)
			  public ModelAndView trialBalancePreview(String fromdate,String todate,HttpServletResponse response,HttpSession session) {
				 // System.out.println("repStatu="+repStatu);
				  ModelAndView mav = new ModelAndView("trialBalance");
				  
				  String centerid=session.getAttribute("centerid")+"";
				  CenterMaster centerMaster=centerService.getcenterById(centerid);
				  
				 
				  String[][] glpostData=glAccountService.getGlPostingDateByDate(fromdate,todate,centerid);
				  
				  List<TrialBalanceBeen> trialBalanceBeenList = new ArrayList<TrialBalanceBeen>();
				  
				
				  	for(int i=0;i<glpostData.length;i++) {
				  		TrialBalanceBeen trialBalanceBeen=new TrialBalanceBeen();
				  		trialBalanceBeen.setGlaccountname(glpostData[i][1]);
				  		trialBalanceBeen.setPrimaryaccount(glpostData[i][2]);
				  		trialBalanceBeen.setDr(Double.parseDouble(glpostData[i][3].toString())/100);
				  		trialBalanceBeen.setCr(Double.parseDouble(glpostData[i][4].toString())/100);
					  		trialBalanceBeenList.add(trialBalanceBeen);
					  
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
		          		reptValue=review.pdfReportViewInlineSystemOpen("trialBalanceReport.jasper","Trial Balance",trialBalanceBeenList,params,response);
		          		
		          
		          	}catch(Exception e) {	          		
		          		e.printStackTrace();          		
		          	}
				  
				  mav.addObject("pdfViewEq", reptValue); 
				  return mav;
			  }  
			  
			  
			  @RequestMapping(value = "/profitsAndLoss", method=RequestMethod.GET) 
			  public ModelAndView profitsAndLoss(Map<String, Object> model,HttpServletResponse response,HttpSession session) { 	
				  
				  
				  
				  
				  
				// System.out.println("repStatu="+repStatu);
				  ModelAndView mav = new ModelAndView("profitsAndLoss");
				  
				  String centerid=session.getAttribute("centerid")+"";
				  CenterMaster centerMaster=centerService.getcenterById(centerid);
				  
				 
				  String[][] pnldata=glAccountService.getProfitsAndLossData("2021%",centerid);
				  
				  List<ProfitsAndLossBeen> profitsAndLossBeenList = new ArrayList<ProfitsAndLossBeen>();
				  
				
				  	for(int i=0;i<pnldata.length;i++) {
				  		ProfitsAndLossBeen profitsAndLossBeen=new ProfitsAndLossBeen();
				  		
				  		profitsAndLossBeen.setGlaccountname(pnldata[i][1]);
				  		profitsAndLossBeen.setPrimaryaccount(pnldata[i][2]);
				  		profitsAndLossBeen.setAmount(Double.parseDouble(pnldata[i][3].toString())/100);
				  		
				  		profitsAndLossBeenList.add(profitsAndLossBeen);
					  
				  	}
			
		          	ReportViewe review=new ReportViewe();
		          	Map<String,Object> params = new HashMap<>();

		        	params.put("img",centerMaster.getPartner_ID().getPartner_Logo());
		          	params.put("hedder",centerMaster.getPartner_ID().getReceiptHeader());
		          	params.put("address",centerMaster.getAdd03() );
		          //	params.put("fromdate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(fromdate)));
		          	//params.put("todate",DateHelperWeb.getFormatStringDate(DateHelperWeb.getDate(todate)));
		       
		          	String reptValue="";
		          	
		         try {
		          		reptValue=review.pdfReportViewInlineSystemOpen("profitsAndLossReport.jasper","P & L",profitsAndLossBeenList,params,response);
		          		
		          
		          	}catch(Exception e) {	          		
		          		e.printStackTrace();          		
		          	}
				  
				  mav.addObject("pdfViewEq", reptValue); 
				  return mav; 
				  
		 
				
			  }  
}
