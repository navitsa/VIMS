package com.navitsa.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.entity.EquipmentMake;
import com.navitsa.services.EquipmentService;
import com.navitsa.validator.EquipmentMakeValidator;


@Controller("equipmentMakeController")
public class EquipmentMakeController {
	
	@Autowired
	private EquipmentService eqervice;
	   @Autowired
	   private EquipmentMakeValidator equipmentMakeValidator;
	   
	   @InitBinder
	   protected void initBinder(WebDataBinder binder) {
	     binder.addValidators(equipmentMakeValidator);
	      
	   }
		@RequestMapping("/equipmentmake")
		public String equipmentMake(Map<String, Object> model) {
			model.put("equipmentMake", new EquipmentMake());
			EquipmentMake eqMake = new EquipmentMake();
			eqMake.setEqMakeID("0000".substring(eqervice.maxEqMakeID().length()) + eqervice.maxEqMakeID());
			model.put("equipmentMake", eqMake);
			List<EquipmentMake> listEquipmentMakee = eqervice.findAllEquipmentMake();
			model.put("allequipmentMake", listEquipmentMakee);
			return "equipmentMake";
		}

		@RequestMapping(value = ("/saveequipmentMake"), method = RequestMethod.POST)
		public String saveEquipmentMake(@Valid @ModelAttribute("equipmentMake")EquipmentMake equipmentMake, BindingResult br,RedirectAttributes redirectAttributes) {
			
			if(br.hasErrors()) {
				
				return "equipmentMake";
			}
			else {
			try {
			eqervice.saveEquipmentMake(equipmentMake);
			redirectAttributes.addFlashAttribute("success",1);
			}catch(Exception e) {
				System.out.println(e);
				redirectAttributes.addFlashAttribute("success",0);
			}
			return "redirect:/equipmentmake.do";
			}
		}
//		public String saveEquipmentMake(@Valid @ModelAttribute("bisPartner")EquipmentMake equipmentMake, BindingResult br,@RequestParam("eqMakeID")  String eqMakeID, @RequestParam("eqMake")  String eqMake,
//				@RequestParam("status")  String status, @RequestParam("remarks")  String remarks,
//				@RequestParam("eqMakeLogo")  MultipartFile eqMakeLogo ) throws IOException {
//			if(br.hasErrors()) {
//				return "equipmentMake";
//			} else {
//			
//			if(eqMakeLogo.isEmpty()) {
//				EquipmentMake newEquipmentMake = new EquipmentMake(eqMakeID, eqMake, status, remarks);
//				eqervice.saveEquipmentMake(newEquipmentMake);	
//			}else {
//				EquipmentMake newEquipmentMake = new EquipmentMake(eqMakeID, eqMake, eqMakeLogo.getBytes(), status, remarks);
//				eqervice.saveEquipmentMake(newEquipmentMake);			
//				
//			}
//
//			return "redirect:/equipmentmake.do";
//			}
//		}
		
		@RequestMapping("/editEqMake")
		public ModelAndView editEqMake(@RequestParam String eqMakeID) {
			ModelAndView mav = new ModelAndView("equipmentMake");
			EquipmentMake equipmentMake =null;
			try {
				
				equipmentMake = eqervice.equipmentMakeByID(eqMakeID);
				mav.addObject("equipmentMake", equipmentMake);
				
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("******Null value passing error of edit  in eq Con*****");
				}
				
				try {
					
				String vmLogo = equipmentMake.getEqMakeLogoView();
				mav.addObject("vmLogo",vmLogo);
				
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("****Null value passing error of editMake in eq Con*****");
				}

				return mav;
		}

		@ModelAttribute("allequipmentMake")
		public List<EquipmentMake> getAllMake() {
			List<EquipmentMake> makes = eqervice.findAllEquipmentMake();
			return makes;
		}
		
}
