package com.navitsa.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.entity.EquipmentType;
import com.navitsa.entity.TestTypeEqumentType;
import com.navitsa.entity.Test_type;
import com.navitsa.services.EquipmentService;
import com.navitsa.services.TestTypeService;

@Controller
public class TestTypeController {
	
	@Autowired
	private TestTypeService testTypeService;
	@Autowired
	private EquipmentService eqervice;
	
	 /*@ModelAttribute("testTypes")
	 public List<Test_type> getAllTestTypes(){
		 
		 List<Test_type> ls = service.listAll();
		 return ls;
	 }*/
	@RequestMapping(value = "/callTestTypeEqumentType", method = RequestMethod.GET)
	public String getTestTypeEqumentType(Map <String , Object> model,@RequestParam String typeid) {
		TestTypeEqumentType testTypeEqumentType = new TestTypeEqumentType();		
		Test_type testType=testTypeService.listTestTypeById(typeid);
		testTypeEqumentType.setTypeId(testType);	
		List <TestTypeEqumentType> testtypeequmenttypeList = testTypeService.listTestTypeEqumentType();				
		model.put("testtypeequmenttypeList", testtypeequmenttypeList);		
		model.put("testtypeEqumenttype", testTypeEqumentType);
		return "AddEquipmentTypeToTestType";	
		
	}
	
	@ModelAttribute("eqTypeCmbfortesttyp")
	public List<EquipmentType> getAllTypeDetails() {
	List<EquipmentType> typedrop = eqervice.findAllEquipmentType();
	return typedrop;
	}
	@ModelAttribute("testtypeListTy")
	public List <Test_type> getListOfTestType(){
		List <Test_type> getTesttype = testTypeService.listAll();	
		return getTesttype;
	}

	@RequestMapping(value = "/saveTesttypeEqumenttype", method = RequestMethod.POST)
	public String savelaneTypeCategory(@Valid @ModelAttribute("testtypeEqumenttype") TestTypeEqumentType testTypeEqumentType,RedirectAttributes redirectAttributes) {
//		if(br.hasErrors()) {
//			return "testLanes";
//		}
		try {

			testTypeService.saveTestTypeEqumentType(testTypeEqumentType);
		
		redirectAttributes.addFlashAttribute("success", 1);
		}catch(Exception e) {
			System.out.println(e);
		redirectAttributes.addFlashAttribute("success", 0);
		}
		
		return "redirect:/callTestTypeEqumentType?typeid="+testTypeEqumentType.getTypeId().getTypeId();
	}
	
}
