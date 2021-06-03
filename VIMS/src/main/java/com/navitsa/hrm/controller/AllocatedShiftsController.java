package com.navitsa.hrm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.navitsa.hrm.service.ShiftAllocationService;

@Controller
public class AllocatedShiftsController {

	@Autowired
	private ShiftAllocationService shiftAllocationService;

	@GetMapping("/AllocatedShifts")
	public String allocatedShiftsPage() {
		return "hrm/allocatedShifts";
	}

	@ModelAttribute("shiftAllocationList")
	public List<String> getAllShiftAllocations(HttpSession session) {
		String companyId = session.getAttribute("company.comID").toString();
		List<String> allocations = shiftAllocationService.loadShiftAllocationsByCompany(companyId);
		return allocations;
	}
}
