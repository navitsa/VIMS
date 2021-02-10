package com.navitsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.navitsa.entity.TestProfile;
import com.navitsa.entity.VehiclesSubCategory;
import com.navitsa.services.TestProfileService;

@Controller
public class VehiclesSubCategoryController {
	
	@Autowired
	private TestProfileService testProfileService;

	@RequestMapping("/speedGovernor")
	public String laodForm(Model m) {
		
		m.addAttribute("veSubCatForm", new VehiclesSubCategory());
		return "speedGovernor";
	}
	
	 @ModelAttribute("testProfile")
	 public List<TestProfile> getAlltestProfiles(){
		 
		 List<TestProfile> ls = testProfileService.listAllProfiles();
		 return ls;
	 }
}
