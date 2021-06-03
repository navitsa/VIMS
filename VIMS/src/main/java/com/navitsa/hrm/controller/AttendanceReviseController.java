package com.navitsa.hrm.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navitsa.hrm.entity.AttendanceRevise;
import com.navitsa.hrm.entity.DepartmentMaster;
import com.navitsa.hrm.entity.EmployeeAttendance;
import com.navitsa.hrm.entity.ShiftAllocation;
import com.navitsa.hrm.entity.ShiftMaster;
import com.navitsa.hrm.service.AttendanceReviseService;
import com.navitsa.hrm.service.DepartmentService;
import com.navitsa.hrm.service.EmployeeAttendanceService;
import com.navitsa.hrm.service.ShiftMasterService;

@Controller
public class AttendanceReviseController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeAttendanceService employeeAttendanceService;

	@Autowired
	private AttendanceReviseService attendanceReviseService;

	@Autowired
	private ShiftMasterService shiftMasterService;

	@GetMapping("/AttendanceRevise")
	public String AttendanceReportPage() {
		return "hrm/attendanceRevise";
	}

	@ModelAttribute("depList")
	public List<DepartmentMaster> getAllDeps(HttpSession session) {
		String companyId = session.getAttribute("company.comID").toString();
		return departmentService.getDepartmentsByCompany(companyId);
	}

	@ModelAttribute("shiftList")
	public List<ShiftMaster> getAllShifts(HttpSession session) {
		String companyId = session.getAttribute("company.comID").toString();
		return shiftMasterService.loadAllShifts(companyId);
	}

	@ModelAttribute("revisesList")
	public List<String> getAllAttendanceRevises(HttpSession session) {
		String companyId = session.getAttribute("company.comID").toString();
		List<String> revises = attendanceReviseService.loadAttendanceRevises(companyId);
		return revises;
	}

	@ModelAttribute("reviseId")
	public String setReviseCode(HttpSession session) {
		String companyId = session.getAttribute("company.comID").toString();
		String id = "0000000000".substring(attendanceReviseService.getMaxReviseId(companyId).length())
				+ attendanceReviseService.getMaxReviseId(companyId);
		return id;
	}

	@GetMapping("/loadEmployeeAttendanceDetails")
	public @ResponseBody EmployeeAttendance loadEmployeeAttendanceDetails(@RequestParam("date") String date,
			@RequestParam("shiftId") String shiftId, @RequestParam("employeeId") String employeeId,
			HttpSession session) {
		String companyId = session.getAttribute("company.comID").toString();
		EmployeeAttendance attendance = employeeAttendanceService.findEmployeeAttendanceByDetails(date, shiftId,
				employeeId, companyId);
		System.out.println("Method Loaded");
		return attendance;
	}

	@PostMapping("/submitAttendanceRevise")
	public String submitAttendanceRevise(@RequestParam("reviseId") String reviseId,
			@RequestParam("attendanceId") String attendanceId, @RequestParam("shiftId") String shiftId,
			@RequestParam("employeeId") String employeeId, @RequestParam("date") String date,
			@RequestParam("onTime") String onTime, @RequestParam("newOnTime") String newOnTime,
			@RequestParam("newOffTime") String newOffTime, @RequestParam("offTime") String offTime,
			@RequestParam("remark") String remark, @RequestParam("approved") boolean approved,
			@RequestParam(value = "companyId", required = false) String companyId) {

		AttendanceRevise revise = new AttendanceRevise();
		LocalDate submitDate = LocalDate.now();

		try {
			revise.setReviseId(reviseId);
			revise.setSubmitDate(Date.valueOf(submitDate));
			revise.setAttendanceId(attendanceId);
			revise.setShiftId(shiftId);
			revise.setEmployeeId(employeeId);
			revise.setDate(Date.valueOf(date));
			revise.setOnTime(onTime);
			revise.setOffTime(offTime);
			revise.setNewOnTime(newOnTime);
			revise.setNewOffTime(newOffTime);
			revise.setRemark(remark);
			revise.setApproved(approved);
			revise.setCompanyId(companyId);
			attendanceReviseService.saveAttendanceRevise(revise);

			return "redirect:/hrm/AttendanceRevise";

		} catch (Exception e) {
			System.out.println("Error");
		}
		return "hrm/AttendanceRevise";
	}
}
