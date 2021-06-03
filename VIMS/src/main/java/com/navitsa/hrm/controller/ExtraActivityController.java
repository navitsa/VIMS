package com.navitsa.hrm.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.navitsa.hrm.entity.Employee;
import com.navitsa.hrm.entity.EmployeeExtraActivity;
import com.navitsa.hrm.entity.EmployeeSkill;
import com.navitsa.hrm.entity.ExtraActivityType;
import com.navitsa.hrm.service.EmployeeService;
import com.navitsa.hrm.service.ExtraActivityService;

@Controller
public class ExtraActivityController {

	@Autowired
	private ExtraActivityService aTypeService;

	@Autowired
	private EmployeeService empService;

	// extra activity
	// type-------------------------------------------------------------

	@RequestMapping(value = "/extraActivityType", method = RequestMethod.GET)
	public String getATPage(Map<String, Object> map) {
		map.put("saveAType", new ExtraActivityType());
		ExtraActivityType at = new ExtraActivityType();
		at.setActTypeID("00000".substring(aTypeService.maxAtID().length()) + aTypeService.maxAtID());
		map.put("saveAType", at);
		return "hrm/extraActivityType";
	}

	@ModelAttribute("aTypes")
	public List<ExtraActivityType> getAllATypes() {
		return aTypeService.getAllAt();
	}

	@RequestMapping(value = "/saveAType", method = RequestMethod.POST)
	public String saveAt(@Valid @ModelAttribute("saveAType") ExtraActivityType at, BindingResult br) {
		if (br.hasErrors()) {
			return "hrm/extraActivityType";
		} else {
			try {
				aTypeService.saveAType(at);
				return "redirect:/hrm/extraActivityType";
			} catch (Exception e) {
				System.out.println("Details not Saved");
			}
		}
		return "hrm/extraActivityType";
	}

	@RequestMapping(value = "/updateAt", method = RequestMethod.GET)
	public ModelAndView updateAt(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("hrm/extraActivityType");
		ExtraActivityType at = aTypeService.getAType(id);
		mav.addObject("saveAType", at);
		return mav;
	}

	// employee extra activity-----------------------------------------------

//	@RequestMapping(value="/employeeExtraActivitywithid", method = RequestMethod.GET)
//	public String getEetPagewithid(Map<String,Object>map, @RequestParam("eid") String eid) {
//		map.put("saveEet", new EmployeeExtraActivity());
//		EmployeeExtraActivity eea = new EmployeeExtraActivity();
//		map.put("saveEet", eea);
//		map.put("eid", eid);
//		return "employeeExtraActivity";
//	}

	@ModelAttribute("empEet")
	public List<EmployeeExtraActivity> getAllEet() {
		return aTypeService.getAllEet();
	}

	@ModelAttribute("emp")
	public List<Employee> getAllEmp() {
		return empService.getAllEmp();
	}

	@RequestMapping(value = "/saveEet", method = RequestMethod.POST)
	public String saveEet(@Valid @ModelAttribute("saveEmpActivity") EmployeeExtraActivity eet, BindingResult br) {
		if(br.hasErrors()) {
			return "hrm/employeeSkill";
		}else {
			aTypeService.saveEet(eet);
			return "redirect:/hrm/employeeSkill";
		}
		
	}

	@RequestMapping(value = "/updateEet", method = RequestMethod.GET)
	public ModelAndView updateEet(@RequestParam("empID") String empID , @RequestParam("actTypeID") String actTypeID) {
		ModelAndView mav = new ModelAndView("hrm/employeeExtraActivityEdit");
		EmployeeExtraActivity eet = aTypeService.getEmployeeExtraActivity(empID, actTypeID);
		mav.addObject("saveEmpActivity", eet);
		return mav;
	}

	// load empAcivity jsp
	@RequestMapping(value = "/employeeExtraActivity", method = RequestMethod.GET)
	public String getEetPage(Map<String, Object> map) {
		map.put("saveEet", new EmployeeExtraActivity());
		EmployeeExtraActivity eea = new EmployeeExtraActivity();
		map.put("saveEet", eea);

		return "hrm/employeeExtraActivity";
	}
	
	//LOAD SAVED EMPLOYEE EXTRA ACTIVITY  DETAILS TO GRID ACCORDING TO EMPLOYEE ID
			@RequestMapping(value="/getActivityDtails", method=RequestMethod.GET)
			public   @ResponseBody List<EmployeeExtraActivity> comboTable(@RequestParam String empID ) {
			List<EmployeeExtraActivity> listEmployeeExtraActivity = aTypeService.searchEmployeeExtraActivity(empID);
			return listEmployeeExtraActivity;
			}	
}
