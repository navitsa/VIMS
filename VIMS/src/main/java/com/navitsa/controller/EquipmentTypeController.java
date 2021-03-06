package com.navitsa.controller;

import java.util.HashMap;
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

import com.navitsa.entity.EquipmentType;
import com.navitsa.services.EquipmentService;

@Controller("equipmentTypeController")
public class EquipmentTypeController {

	@Autowired
	private EquipmentService eqervice;

	@RequestMapping("/equipmenttype")
	public String equipmentType(Map<String, Object> model) {
		EquipmentType eqtyp = new EquipmentType();
		eqtyp.setEqTypeID("0000".substring(eqervice.maxEqTypeID().length()) + eqervice.maxEqTypeID());
		model.put("equipmentType", eqtyp);
		List<EquipmentType> listequipmenttype = eqervice.findAllEquipmentType();
		model.put("allequipmenttype", listequipmenttype);
		return "equipmentType";
	}

	@RequestMapping("/editEqType")
	public ModelAndView editEqType(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("equipmentType");
		EquipmentType equipmentType = eqervice.equipmentTypeByID(id);
		mav.addObject("equipmentType", equipmentType);
		return mav;
	}

	@ModelAttribute("statusMap")
	public Map<String, String> getCountryList() {
		Map<String, String> countryList = new HashMap<String, String>();
		countryList.put("ACTIVE", "ACTIVE");
		countryList.put("INACTIVE", "INACTIVE");
		return countryList;
	}

	@RequestMapping(value = "/saveequipmenttype", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("equipmentType")  EquipmentType equipmentType , BindingResult br,RedirectAttributes redirectAttributes) {
		
		if(br.hasErrors()) {
			redirectAttributes.addFlashAttribute("success", 0);
			return "equipmentType";
			
		} else {
			eqervice.saveEquipmentTyp(equipmentType);
			redirectAttributes.addFlashAttribute("success", 1);
			return "redirect:/equipmenttype.do";
	    	  
		}
	  		
	      }
	
	    @ModelAttribute("allequipmenttype")
		public List<EquipmentType> getAllTypes() {
			List<EquipmentType> types = eqervice.findAllEquipmentType();
			return types;
		}
	}

   


