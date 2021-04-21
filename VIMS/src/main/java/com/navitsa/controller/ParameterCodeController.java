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

import com.navitsa.entity.ParameterCodes;
import com.navitsa.entity.TestParameter;
import com.navitsa.entity.TestParameterAngle;
import com.navitsa.entity.TestPoint;
import com.navitsa.entity.Test_type;
import com.navitsa.services.ParameterCodeService;

@Controller
public class ParameterCodeController {

	@Autowired
	ParameterCodeService parameterCodeService;

	@RequestMapping(value = "/parameterCode", method = RequestMethod.GET)
	public String parameterCodePage(Map<String, Object> map) {
		ParameterCodes parameterCodes = new ParameterCodes();
		parameterCodes.setS_id(parameterCodeService.maxParameterCodesSID());
		map.put("parameterCodesForm", parameterCodes);
		return "parameterCode";
	}

	@ModelAttribute("parameterCodeList")
	public List<ParameterCodes> getAllParameterCodes() {
		List<ParameterCodes> listParameterCodes = parameterCodeService.getAllParameterCodes();
		return listParameterCodes;
	}

	@ModelAttribute("testTypeList")
	public List<Test_type> getAllTestTypes() {
		List<Test_type> listTestTypes = parameterCodeService.getAllTestTypes();
		return listTestTypes;
	}

	@ModelAttribute("testPointList")
	public List<TestPoint> getAllTestPoints() {
		List<TestPoint> listTestPoints = parameterCodeService.getAllTestPoints();
		return listTestPoints;
	}

	@ModelAttribute("testParameterList")
	public List<TestParameter> getAllTestParameters() {
		List<TestParameter> listTestParameters = parameterCodeService.getAllTestParameters();
		return listTestParameters;
	}

	@ModelAttribute("testParameterAngleList")
	public List<TestParameterAngle> getAllTestParameterAngles() {
		List<TestParameterAngle> listTestParameterAngles = parameterCodeService.getAllTestParameterAngles();
		return listTestParameterAngles;
	}

	@RequestMapping(value = "/saveParameterCodes", method = RequestMethod.POST)
	public String saveParameterCodes(@Valid @ModelAttribute("parameterCodesForm") ParameterCodes parameterCodes,
			BindingResult br, RedirectAttributes redirectAttributes) {

		if (br.hasErrors()) {
			return "parameterCode";
		} else {

			try {
				parameterCodeService.saveParameterCodes(parameterCodes);
				redirectAttributes.addFlashAttribute("success", 1);
				return "redirect:/parameterCode";
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("success", 0);
			}
		}

		return "parameterCode";
	}

	@RequestMapping("/editParameterCodes")
	public ModelAndView editParameterCodes(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("parameterCode");
		ParameterCodes parameterCodes = parameterCodeService.findByParameterCodesSId(id);
		mav.addObject("parameterCodesForm", parameterCodes);
		return mav;
	}

}
