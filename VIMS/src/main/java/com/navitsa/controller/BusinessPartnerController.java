package com.navitsa.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.entity.BusinessPartner;
import com.navitsa.entity.CountryMaster;
import com.navitsa.services.BusinessPartnerService;
import com.navitsa.services.RegionalService;

@Controller
public class BusinessPartnerController {

	@Autowired
	BusinessPartnerService partnerService;
	
	@Autowired
	RegionalService rService;
	
	@RequestMapping("/businessPartner")
	public String listPartners(Map<String, Object> map) {
		
		//map.put("bisPartner", new BusinessPartner());
		BusinessPartner partner = new BusinessPartner();
		partner.setPartner_ID("0000".substring(partnerService.partnerMaxID().length()) + partnerService.partnerMaxID());
		map.put("bisPartner", partner);
		
		List<BusinessPartner> listBusinessPartner = partnerService.listPartners();
		map.put("listPartner", listBusinessPartner);
		return "businessPartner";
	}
	//save b partner
	@RequestMapping(value = "/saveBPartner", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("bisPartner")BusinessPartner businessPartner,
			BindingResult br,RedirectAttributes redirectAttributes) {
		
		if(br.hasErrors()) 
		{
			return "businessPartner";
		} else {
			try 
			{
				if(businessPartner.getDefaultPartner() != null)
				{
					partnerService.savePartner(businessPartner);
					partnerService.setDefaultPartner(businessPartner.getPartner_ID());
				}
				else {
					businessPartner.setDefaultPartner("Inactive");
					partnerService.savePartner(businessPartner);
				}

				redirectAttributes.addFlashAttribute("success", 1);
				return "redirect:/businessPartner.do";
				
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("success", 0);
			System.out.println(e);
			}
		}
		return "redirect:/businessPartner.do";
	}
	
	@RequestMapping("/editPartner")
	public ModelAndView editPartner(@RequestParam String partner_ID) {
		ModelAndView mav = new ModelAndView("businessPartner");
		BusinessPartner biPartner = null;
		
		try {
			biPartner = partnerService.getPartnerId(partner_ID);
		 	mav.addObject("bisPartner", biPartner);
		} catch (Exception e) { 
			System.out.println(e);
		}
		try {
			String partnerLogo = biPartner.getPartnerImgView();
			mav.addObject("img", partnerLogo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return mav;
	}
	

	@ModelAttribute("country")
	public List<CountryMaster> getAll() {
		List<CountryMaster> country = rService.getAll() ;
		return country;
	}
	
	@RequestMapping("/businessPartnerRegTypes")
	public String BPartnerRegType() {
		return "businessPartnerRegTypes";
	}
	
	@ModelAttribute("listPartner")
	public List<BusinessPartner> getAllDetails() {
		List<BusinessPartner> partner = partnerService.listPartners();
		return partner;
	}
}
