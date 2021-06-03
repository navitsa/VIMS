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
import com.navitsa.hrm.entity.EmployeeLanguage;
import com.navitsa.hrm.entity.EmployeeSkill;
import com.navitsa.hrm.entity.ExtraActivityType;
import com.navitsa.hrm.entity.LanguageMaster;
import com.navitsa.hrm.entity.SkillMaster;
import com.navitsa.hrm.service.ExtraActivityService;
import com.navitsa.hrm.service.LanguageService;
import com.navitsa.hrm.service.SkillService;

@Controller
public class SkillController {

	@Autowired
	private SkillService smService;
	
	@Autowired
	private LanguageService laService;

	@Autowired
	private ExtraActivityService aTypeService;
	
	// skill master--------------------------------------------------------

	@RequestMapping(value = "/skillMaster", method = RequestMethod.GET)
	public String getSkillPage(Map<String, Object> map) {
		map.put("saveSkills", new SkillMaster());
		SkillMaster sm = new SkillMaster();
		sm.setSid("00000".substring(smService.maxSkillID().length()) + smService.maxSkillID());
		map.put("saveSkills", sm);
		return "hrm/skillMaster";
	}

	@RequestMapping(value = "/saveSkills", method = RequestMethod.POST)
	public String saveSkill(@Valid @ModelAttribute("saveSkills") SkillMaster sm, BindingResult br) {
		if (br.hasErrors()) {
			return "hrm/skillMaster";
		} else {
			try {
				smService.saveSkill(sm);
				return "redirect:/hrm/skillMaster";
			} catch (Exception e) {
				System.out.println("Details not saved");
			}
		}
		return "hrm/skillMaster";
	}

	@RequestMapping(value = "/updateSkill", method = RequestMethod.GET)
	public ModelAndView updateSkill(@RequestParam String sid) {
		ModelAndView mav = new ModelAndView("hrm/skillMaster");
		SkillMaster sm = smService.getSkill(sid);
		mav.addObject("saveSkills", sm);
		return mav;
	}

	@ModelAttribute("skills")
	public List<SkillMaster> getAllSkills() {
		return smService.getAllSkills();
	}

	@ModelAttribute("aTypes")
	public List<ExtraActivityType> getAllEATypes() {
		return aTypeService.getAllAt();
	}
	
	// employee skill---------------------------------------------------------

	@RequestMapping(value = "/employeeSkill", method = RequestMethod.GET)
	public String loadEmpSkillPage(Map<String, Object> map) {
		map.put("saveEmpSkill", new EmployeeSkill());
		map.put("saveEmpLan", new EmployeeLanguage());
		map.put("saveEmpActivity", new EmployeeExtraActivity());
		return "hrm/employeeSkill";
	}

	@ModelAttribute("EmpSkills")
	public List<EmployeeSkill> getAllEmpSkills() {
		return smService.getAllEmpSkill();
	}

	@ModelAttribute("Emps")
	public List<Employee> getAllEmps() {
		return smService.getAllEmps();
	}
	
	@ModelAttribute("aTypes")
	public List<ExtraActivityType> getAllATypes() {
		return aTypeService.getAllAt();
	}
	
	@ModelAttribute("lMaster")
	public List<LanguageMaster> getAllLm() {
		return laService.getAllLm();
	}

	@RequestMapping(value = "/saveEmpSkill", method = RequestMethod.POST)                     
	public String saveEmpSkill(@ModelAttribute("saveEmpSkill") EmployeeSkill empSkill) {
			smService.saveEmpSkill(empSkill);
			return "redirect:/hrm/employeeSkill";
		
	}

	@RequestMapping(value = "/updateEmpSkill", method = RequestMethod.GET)
	public ModelAndView updateEmpSkill(@RequestParam("empID") String empID, @RequestParam("sid") String sid) {
		ModelAndView mav = new ModelAndView("hrm/employeeSkillEdit");
		EmployeeSkill sm = smService.getSId(empID, sid);
		mav.addObject("saveEmpSkill", sm);
		return mav;
	}

	// load employee skill without id
//	@RequestMapping(value = "/employeeSkill", method = RequestMethod.GET)
//	public String loadEmpSkillPage(Map<String, Object> map) {
//		map.put("saveEmpSkill", new EmployeeSkill());
//		EmployeeSkill em = new EmployeeSkill();
//		map.put("saveEmpSkill", em);
//
//		return "employeeSkill";
//	}
	
	//LOAD SAVED EMPLOYEE SKILL  DETAILS TO GRID ACCORDING TO EMPLOYEE ID
		@RequestMapping(value="/getSkillDtails", method=RequestMethod.GET)
		public   @ResponseBody List<EmployeeSkill> comboTable(@RequestParam String empID ) {
		List<EmployeeSkill> listEmployeeSkill = smService.searchEmployeeSkill(empID);
		return listEmployeeSkill;
		}	

}
