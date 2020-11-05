package com.navitsa.controller;

import java.io.IOException;
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

import com.navitsa.entity.EquipmentMake;
import com.navitsa.entity.EquipmentModel;
import com.navitsa.entity.EquipmentType;
import com.navitsa.services.EquipmentService;

@Controller("equipmentModelController")
public class EquipmentModelController {
	@Autowired
	private EquipmentService eqervice;
	
	@RequestMapping("/equipmentmodel")
	public String equipmentModel(Map<String, Object> model) {
		model.put("equipmentModel", new EquipmentModel());
		EquipmentModel eqModel = new EquipmentModel();
		eqModel.setEqModelID("0000".substring(eqervice.maxEqModelID().length()) + eqervice.maxEqModelID());
		model.put("equipmentModel", eqModel);
		List<EquipmentModel> listEquipmentModel = eqervice.findAllEquipmentModel();
		model.put("listEquipmentModel", listEquipmentModel);
		return "equipmentModel";
	}
	


	@RequestMapping(value = "/saveEquipmentmodel", method = RequestMethod.POST)
	public String saveequipmentModel(@Valid @ModelAttribute("equipmentModel") EquipmentModel newEquipmentModel,  BindingResult br,RedirectAttributes redirectAttributes)throws IOException {
		
		
		
		 if(br.hasErrors())  
	        {  
			
			 return "equipmentModel";
	        }  
	        else  
	        {  
	        	try {
	        		redirectAttributes.addFlashAttribute("success",1);
	        		eqervice.saveEquipmentModel(newEquipmentModel);
	        		return "redirect:/equipmentmodel.do";
	        	}catch (Exception e) {
					// TODO: handle exception
	        		 redirectAttributes.addFlashAttribute("success",0);
				}
	        }
		return "equipmentModel";

	}
	@ModelAttribute("eqMakeDetailsCmb")
	public List<EquipmentMake> getAllMakeDetails() {
		List<EquipmentMake> makedrop = eqervice.findAllEquipmentMake();
		return makedrop;
	}
	// editEqModel
	// editEqModel
		@RequestMapping("/editEqModel")
		public ModelAndView editEqModel(@RequestParam String id) {
			ModelAndView mav = new ModelAndView("equipmentModel");
			EquipmentModel equipmentMake = null;
			
			try {
				equipmentMake =eqervice.equipmentModelByID(id);
				
				mav.addObject("equipmentModel", equipmentMake);
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
			try {
				String img = equipmentMake.getEqModelLogoView();
				mav.addObject("img", img);
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
			return mav;
		}
		@ModelAttribute("listEquipmentModel")
		public List<EquipmentModel> getAllModels() {
			List<EquipmentModel> models = eqervice.findAllEquipmentModel();
			return models;
		}
		
		@ModelAttribute("types")
		public List<EquipmentType> getAllTypes() {
			List<EquipmentType> types = eqervice.findAllEquipmentType();
			return types;
		}
}
