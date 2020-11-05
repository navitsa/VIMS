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

import com.navitsa.entity.CountryMaster;
import com.navitsa.services.RegionalService;

@Controller
public class RegionalController {

	@Autowired
	private RegionalService rService;
	
	//redirect country page
	@RequestMapping(value = "/countryMaster", method = RequestMethod.GET)
	public String getCountry(Map<String, Object> map) {
		map.put("cMaster", new CountryMaster());
		CountryMaster cm = new CountryMaster();
		map.put("cMaster", cm);		
		List<CountryMaster> listCountryMaster = rService.getAll();
		map.put("listCountryMaster", listCountryMaster);
		return "countryMaster";
	}
	
	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	public String saveCountry(@Valid @ModelAttribute("cMaster")CountryMaster countryMaster,
							  BindingResult br,RedirectAttributes redirectAttributes){
				if(br.hasErrors()) {
					return "countryMaster";
				} else {
					try {
//						String chk = countryMaster.getStatus();
//						if(chk == null) {
//							countryMaster.setStatus("Inactive");
//							
//						}
					rService.save(countryMaster);
					rService.setDefault(countryMaster.getCountryCode());
					redirectAttributes.addFlashAttribute("success", 1);
					return "redirect:/countryMaster.do";		
				} catch(Exception e) {
					System.out.println(e);
					redirectAttributes.addFlashAttribute("success", 0);
				}
			}
			return "redirect:/countryMaster.do";	
		}
	
	
	@RequestMapping("/editCountry")
	public ModelAndView editEqMaster(@RequestParam String id) {		
		ModelAndView mav = new ModelAndView("countryMaster");
		CountryMaster cm = null;
		try {
			cm = rService.geAllCountrybyID(id);
			mav.addObject("cMaster", cm);
		} catch(Exception e) {
			System.out.println(e);
		}
		try {
			String flagimg = cm.getFlagImgView();	
			mav.addObject("flagimg", flagimg);
		} catch(Exception e) {
			System.out.println(e);
		}
		return mav;
		
	}

	@ModelAttribute("listCountryMaster")
	public List<CountryMaster> getAllDetails() {
		List<CountryMaster> country = rService.getAll();
		return country;
	}
	
	@RequestMapping("/provinceMaster")
	public String getProvince() {
		return "provinceMaster";
	}
	
	@RequestMapping("/districtMaster")
	public String getDistrict() {
		return "districtMaster";
	}
}
