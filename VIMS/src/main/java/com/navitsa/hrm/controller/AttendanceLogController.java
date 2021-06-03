package com.navitsa.hrm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.navitsa.hrm.service.EmployeeAttendanceService;

@Controller
public class AttendanceLogController {

	@Autowired
	private EmployeeAttendanceService employeeAttendanceService;

	@GetMapping("/AttendanceLog")
	public String attendanceLogPage() {
		return "hrm/attendanceLog";
	}

	@ModelAttribute("attendanceList")
	public List<String> getAllAttendances(HttpSession session) {
		String companyId = session.getAttribute("company.comID").toString();
		List<String> attendances = employeeAttendanceService.loadAttendances(companyId);
		return attendances;
	}
}
