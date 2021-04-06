package com.navitsa.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.entity.VehicleCategory;
import com.navitsa.entity.VehicleMake;
import com.navitsa.services.VehicleCategoryService;

@Controller
public class VehicleCategoryController {

	@Autowired
	VehicleCategoryService vehicleCategoryService;

	@GetMapping("/vehicleCategory")
	public String VehicleCategoryPage(Map<String, Object> map) {
		map.put("vehicleCategoryForm", new VehicleCategory());
		VehicleCategory vehicleCategory = new VehicleCategory();
		map.put("vehicleCategoryForm", vehicleCategory);
		return "vehicleCategory";
	}

	// Save vehicle category data
	@RequestMapping(value = "/saveVehicleCategory", method = RequestMethod.POST)
	public String saveVehicleCategory(@Valid @ModelAttribute("vehicleCategoryForm") VehicleCategory vehicleCategory,
			BindingResult br, RedirectAttributes redirectAttributes) {
		if (br.hasErrors()) {
			return "vehicleCategory";
		} else {
			try {
				vehicleCategoryService.saveVehicleCategory(vehicleCategory);
				redirectAttributes.addFlashAttribute("success", 1);
				return "redirect:/vehicleCategory";
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("success", 0);
			}

		}
		return "vehicleCategory";
	}

	// getting vehicle category details for table
	@ModelAttribute("categoryList")
	public List<VehicleCategory> getCategoryList() {
		List<VehicleCategory> categoryList = vehicleCategoryService.getCategoryList();
		return categoryList;
	}

	// getting vehicle make data for edit purpose
	@RequestMapping("/editCategory")
	public ModelAndView editVehicleCategory(@RequestParam String id) {

		ModelAndView mav = new ModelAndView("vehicleCategory");
		VehicleCategory vc = null;

		try {
			vc = vehicleCategoryService.getVehicleCategoryById(id);
			mav.addObject("vehicleCategoryForm", vc);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("******Null value passing error of editMake in V Con*****");
		}
		return mav;
	}
}
