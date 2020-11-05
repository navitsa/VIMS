package com.navitsa.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.navitsa.Reports.EquipmentSummaryReportBeen;
import com.navitsa.entity.EquipmentMaster;
import com.navitsa.services.EquipmentService;
import com.navitsa.utils.ReportViewe;

@Controller("equipmentReportController")
public class EquipmentReportController {

	@Autowired
	private EquipmentService eqervice;
	
	
	@RequestMapping("/equipmentreport")
	public String equipmentType(Map<String, Object> model) {
		
		//String[][] result=eqervice.getEquipmentSummaryReportData();
		//List<EquipmentSummaryReportBeen> result=getTodayForexRates();
		
		List<EquipmentMaster> listEquipmentMaster = eqervice.findAllEquipmentMaster();
	//	Collections.sort(listEquipmentMaster);
		model.put("listalleqdetails", listEquipmentMaster);

		return "equipmentReport";
	}
	
	 @GetMapping("/equipmentSummaryReport")
	    public ModelAndView handleForexRequest(HttpServletResponse response) { 
		 ModelAndView mav = new ModelAndView("comPdfReportView");
	   try {
	          	ReportViewe review=new ReportViewe();
	          	List<EquipmentSummaryReportBeen> rates = getTodayForexRates(); 
	          	String reptValue=review.pdfReportViewInlineSystemOpen("EquipmentSummaryReport.jasper","EquipmentSummaryReport",rates,null,response);
	 								
				mav.addObject("pdfViewEq", reptValue);  	
	          	
	       }catch(Exception ex) {	        		
	    	   ex.printStackTrace();
	        		
	       }
	   
	   return mav;
	    }
	    
	    private List<EquipmentSummaryReportBeen> getTodayForexRates() {
	        //dummy rates
	        
	    	List<EquipmentMaster> result=eqervice.findAllEquipmentMaster();

	       List<EquipmentSummaryReportBeen> equipmentSummaryReportArray = new ArrayList<>();
	       
	       for(EquipmentMaster   equipmentMaster:result) {
	    	   EquipmentSummaryReportBeen eqSummaryBean=new EquipmentSummaryReportBeen();
	    	   eqSummaryBean.setEqtype(equipmentMaster.getEqModelID().getEqTypeID().getEqType());
	    	   eqSummaryBean.setEqmake(equipmentMaster.getEqModelID().getEqMakeID().getEqMake());
	    	   eqSummaryBean.setEqmodel(equipmentMaster.getEqModelID().getEqModel());
	    	   eqSummaryBean.setEqid(equipmentMaster.getEquipmentID());
	    	   eqSummaryBean.setSerialno(equipmentMaster.getSerialNo());
	    	   eqSummaryBean.setEqmodellogo(equipmentMaster.getEqModelID().getEqModelLogo());
	    	   eqSummaryBean.setEqmakelogo(equipmentMaster.getEqModelID().getEqMakeID().getEqMakeLogo());	    	   
	    	   equipmentSummaryReportArray.add(eqSummaryBean);
   
	       }
	       	       
	        return equipmentSummaryReportArray;
	    }	
	
}
