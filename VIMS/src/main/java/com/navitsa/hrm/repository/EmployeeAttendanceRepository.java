package com.navitsa.hrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.navitsa.hrm.entity.EmployeeAttendance;
import com.navitsa.hrm.report.AttendanceMainReportBean;
import com.navitsa.hrm.report.AttendanceSubReportBean;

@Repository
public interface EmployeeAttendanceRepository extends CrudRepository<EmployeeAttendance, String> {

	@Query(value = "SELECT (max(ea.attendanceId)+1) FROM EmployeeAttendance ea WHERE ea.companyId=:companyId")
	public String maxAttendanceId(@Param("companyId") String companyId);

	@Query(value = "SELECT ea FROM EmployeeAttendance ea WHERE ea.attendanceId=:attendanceId AND ea.companyId=:companyId")
	public EmployeeAttendance findAttendanceByIdAndCompany(@Param("attendanceId") String attendanceId,
			@Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, employee_attendance.employee_id, shift_allocation.employee_name, shift_allocation.department_id, shift_allocation.department_name,employee_attendance.shift_id, shift_allocation.shift_name,\r\n"
			+ "DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\") as date, TIME_FORMAT(shift_allocation.start_time, \"%H:%i\") as start_time, TIME_FORMAT(shift_allocation.end_time, \"%H:%i\") as end_time, employee_attendance.on_time, employee_attendance.off_time,\r\n"
			+ "employee_attendance.approved\r\n" + "FROM employee_attendance \r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.date = shift_allocation.date AND employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id WHERE employee_attendance.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendances(@Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\"), employee_attendance.employee_id, shift_allocation.employee_name, shift_allocation.department_name, employee_attendance.shift_id, shift_allocation.shift_name, employee_attendance.on_time, employee_attendance.off_time, employee_attendance.approved, employee_attendance.company_id \r\n"
			+ "FROM employee_attendance\r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.date = shift_allocation.date AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date BETWEEN :startDate AND :endDate AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendancesByDate(@Param("startDate") String startDate, @Param("endDate") String endDate,
			@Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\"), employee_attendance.employee_id, shift_allocation.employee_name, shift_allocation.department_name, employee_attendance.shift_id, shift_allocation.shift_name, employee_attendance.on_time, employee_attendance.off_time, employee_attendance.approved, employee_attendance.company_id \r\n"
			+ "FROM employee_attendance\r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.date = shift_allocation.date AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date BETWEEN :startDate AND :endDate AND shift_allocation.department_id = :departmentId AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendancesByDepartment(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("departmentId") String departmentId,
			@Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\"), employee_attendance.employee_id, shift_allocation.employee_name, shift_allocation.department_name, employee_attendance.shift_id, shift_allocation.shift_name, employee_attendance.on_time, employee_attendance.off_time, employee_attendance.approved, employee_attendance.company_id \r\n"
			+ "FROM employee_attendance\r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.date = shift_allocation.date AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date BETWEEN :startDate AND :endDate AND shift_allocation.department_id = :departmentId AND employee_attendance.shift_id = :shiftId AND employee_attendance.approved = :approvalStatus AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendancesByDepartmentAndShiftAndApprovalStatus(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("departmentId") String departmentId,
			@Param("shiftId") String shiftId, @Param("approvalStatus") int approvalStatus,
			@Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\"), employee_attendance.employee_id, shift_allocation.employee_name, shift_allocation.department_name, employee_attendance.shift_id, shift_allocation.shift_name, employee_attendance.on_time, employee_attendance.off_time, employee_attendance.approved, employee_attendance.company_id \r\n"
			+ "FROM employee_attendance\r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.date = shift_allocation.date AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date BETWEEN :startDate AND :endDate AND shift_allocation.department_id = :departmentId AND employee_attendance.shift_id = :shiftId AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendancesByDepartmentAndShift(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("departmentId") String departmentId,
			@Param("shiftId") String shiftId, @Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\"), employee_attendance.employee_id, shift_allocation.employee_name, shift_allocation.department_name, employee_attendance.shift_id, shift_allocation.shift_name, employee_attendance.on_time, employee_attendance.off_time, employee_attendance.approved, employee_attendance.company_id \r\n"
			+ "FROM employee_attendance\r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.date = shift_allocation.date AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date BETWEEN :startDate AND :endDate AND shift_allocation.department_id = :departmentId AND employee_attendance.approved = :approvalStatus AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendancesByDepartmentAndApprovalStatus(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("departmentId") String departmentId,
			@Param("approvalStatus") int approvalStatus, @Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\"), employee_attendance.employee_id, shift_allocation.employee_name, shift_allocation.department_name, employee_attendance.shift_id, shift_allocation.shift_name, employee_attendance.on_time, employee_attendance.off_time, employee_attendance.approved, employee_attendance.company_id \r\n"
			+ "FROM employee_attendance\r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.date = shift_allocation.date AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date BETWEEN :startDate AND :endDate AND shift_allocation.department_id = :departmentId AND employee_attendance.employee_id = :employeeId AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendancesByEmployee(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("departmentId") String departmentId,
			@Param("employeeId") String employeeId, @Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\"), employee_attendance.employee_id, shift_allocation.employee_name, shift_allocation.department_name, employee_attendance.shift_id, shift_allocation.shift_name, employee_attendance.on_time, employee_attendance.off_time, employee_attendance.approved, employee_attendance.company_id \r\n"
			+ "FROM employee_attendance\r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.date = shift_allocation.date AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date BETWEEN :startDate AND :endDate AND shift_allocation.department_id = :departmentId AND employee_attendance.employee_id = :employeeId AND employee_attendance.shift_id = :shiftId AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendancesByEmployeeAndShift(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("departmentId") String departmentId,
			@Param("employeeId") String employeeId, @Param("shiftId") String shiftId,
			@Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\"), employee_attendance.employee_id, shift_allocation.employee_name, shift_allocation.department_name, employee_attendance.shift_id, shift_allocation.shift_name, employee_attendance.on_time, employee_attendance.off_time, employee_attendance.approved, employee_attendance.company_id \r\n"
			+ "FROM employee_attendance\r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.date = shift_allocation.date AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date BETWEEN :startDate AND :endDate AND shift_allocation.department_id = :departmentId AND employee_attendance.employee_id = :employeeId AND employee_attendance.approved = :approvalStatus AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendancesByEmployeeAndApprovalStatus(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("departmentId") String departmentId,
			@Param("employeeId") String employeeId, @Param("approvalStatus") int approvalStatus,
			@Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\"), employee_attendance.employee_id, shift_allocation.employee_name, shift_allocation.department_name, employee_attendance.shift_id, shift_allocation.shift_name, employee_attendance.on_time, employee_attendance.off_time, employee_attendance.approved, employee_attendance.company_id \r\n"
			+ "FROM employee_attendance\r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.date = shift_allocation.date AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date BETWEEN :startDate AND :endDate AND employee_attendance.shift_id = :shiftId AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendancesByShift(@Param("startDate") String startDate, @Param("endDate") String endDate,
			@Param("shiftId") String shiftId, @Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\"), employee_attendance.employee_id, shift_allocation.employee_name, shift_allocation.department_name, employee_attendance.shift_id, shift_allocation.shift_name, employee_attendance.on_time, employee_attendance.off_time, employee_attendance.approved, employee_attendance.company_id \r\n"
			+ "FROM employee_attendance\r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.date = shift_allocation.date AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date BETWEEN :startDate AND :endDate AND employee_attendance.approved = :approvalStatus AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendancesByApprovalStatus(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("approvalStatus") int approvalStatus,
			@Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\"), employee_attendance.employee_id, shift_allocation.employee_name, shift_allocation.department_name, employee_attendance.shift_id, shift_allocation.shift_name, employee_attendance.on_time, employee_attendance.off_time, employee_attendance.approved, employee_attendance.company_id \r\n"
			+ "FROM employee_attendance\r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.date = shift_allocation.date AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date BETWEEN :startDate AND :endDate AND employee_attendance.shift_id = :shiftId AND employee_attendance.approved = :approvalStatus AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendancesByShiftAndApprovalStatus(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("shiftId") String shiftId,
			@Param("approvalStatus") int approvalStatus, @Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\"), employee_attendance.employee_id, shift_allocation.employee_name, shift_allocation.department_name, employee_attendance.shift_id, shift_allocation.shift_name, employee_attendance.on_time, employee_attendance.off_time, employee_attendance.approved, employee_attendance.company_id \r\n"
			+ "FROM employee_attendance\r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.date = shift_allocation.date AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date BETWEEN :startDate AND :endDate AND shift_allocation.department_id = :departmentId AND employee_attendance.employee_id = :employeeId AND employee_attendance.shift_id = :shiftId AND employee_attendance.approved = :approvalStatus AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendancesByEmployeeAndShiftAndApprovalStatus(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("departmentId") String departmentId,
			@Param("employeeId") String employeeId, @Param("shiftId") String shiftId,
			@Param("approvalStatus") int approvalStatus, @Param("companyId") String companyId);

	@Query(value = "SELECT DATE_FORMAT(shift_allocation.date, \"%Y-%m-%d\") as date, DATE_FORMAT(shift_allocation.date, \"%W\") as weekday, calander.Description as day_type, employee_attendance.on_time, employee_attendance.off_time, \r\n"
			+ "TIME_FORMAT(TIMEDIFF(employee_attendance.off_time, employee_attendance.on_time), \"%H:%i\") AS worked_time, \r\n"
			+ "CASE WHEN shift_allocation.start_time > employee_attendance.on_time && employee_attendance.off_time > shift_allocation.end_time THEN TIME_FORMAT(CONVERT(ADDTIME(TIMEDIFF(shift_allocation.start_time, employee_attendance.on_time), TIMEDIFF(employee_attendance.off_time, shift_allocation.end_time)), TIME), \"%H:%i\") WHEN shift_allocation.start_time > employee_attendance.on_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(shift_allocation.start_time, employee_attendance.on_time), TIME), \"%H:%i\") WHEN employee_attendance.off_time > shift_allocation.end_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(employee_attendance.off_time, shift_allocation.end_time), TIME), \"%H:%i\") ELSE null END AS over_time, \r\n"
			+ "CASE WHEN employee_attendance.on_time > shift_allocation.start_time && shift_allocation.end_time > employee_attendance.off_time THEN TIME_FORMAT(CONVERT(ADDTIME(TIMEDIFF(employee_attendance.on_time, shift_allocation.start_time), TIMEDIFF(shift_allocation.end_time, employee_attendance.off_time)), TIME), \"%H:%i\") WHEN employee_attendance.on_time > shift_allocation.start_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(employee_attendance.on_time, shift_allocation.start_time), TIME), \"%H:%i\") WHEN shift_allocation.end_time > employee_attendance.off_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(shift_allocation.end_time, employee_attendance.off_time), TIME), \"%H:%i\") ELSE null END AS short_time,  \r\n"
			+ "CASE WHEN CURDATE() < shift_allocation.date THEN 'Yet to come' WHEN applyleaves.Type IS NOT NULL THEN applyleaves.Type WHEN calander.Description = 'Sunday' THEN 'Restday' WHEN employee_attendance.on_time IS NULL && employee_attendance.off_time IS NULL THEN 'Absent' WHEN employee_attendance.on_time > shift_allocation.start_time THEN 'Late' ELSE null END AS attendance_description\r\n"
			+ "FROM ((shift_allocation\r\n" + "INNER JOIN calander ON shift_allocation.date = calander.Date)\r\n"
			+ "LEFT JOIN applyleaves ON shift_allocation.date = applyleaves.Date AND shift_allocation.employee_id = applyleaves.Employee_ID\r\n"
			+ "LEFT JOIN employee_attendance ON shift_allocation.date = employee_attendance.date AND shift_allocation.employee_id = employee_attendance.employee_id AND shift_allocation.shift_id = employee_attendance.shift_id)\r\n"
			+ "WHERE shift_allocation.employee_id = :employeeId AND month(shift_allocation.date) = :month AND  year(shift_allocation.date) = :year AND employee_attendance.company_id = :companyId AND shift_allocation.company_id = :companyId AND calander.CompanyID = :companyId", nativeQuery = true)
	public List<String> loadSubReportDetails(@Param("year") int year, @Param("month") int month,
			@Param("employeeId") String employeeId, @Param("companyId") String companyId);

	@Query(value = "SELECT * FROM employee_attendance WHERE employee_attendance.date=:date AND employee_attendance.shift_id=:shiftId AND employee_attendance.employee_id=:employeeId AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public EmployeeAttendance findEmployeeAttendanceByDetails(@Param("date") String date,
			@Param("shiftId") String shiftId, @Param("employeeId") String employeeId,
			@Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\") AS date, employee_attendance.shift_id, shift_allocation.shift_name, shift_allocation.department_id, shift_allocation.department_name, employee_attendance.employee_id, shift_allocation.employee_name, \r\n"
			+ "TIME_FORMAT(shift_allocation.start_time, \"%H:%i\") AS start_time, TIME_FORMAT(shift_allocation.end_time, \"%H:%i\") AS end_time, employee_attendance.on_time, employee_attendance.off_time, CASE WHEN employee_attendance.approved = 1 THEN 'Yes' WHEN employee_attendance.approved = 0 THEN 'No' ELSE null END AS approval_status\r\n"
			+ "FROM employee_attendance \r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.date = shift_allocation.date AND employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date = :date AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public String[][] loadAttendanceRecordsByDate(@Param("date") String date, @Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\") AS date, employee_attendance.shift_id, shift_allocation.shift_name, shift_allocation.department_id, shift_allocation.department_name, employee_attendance.employee_id, shift_allocation.employee_name, \r\n"
			+ "TIME_FORMAT(shift_allocation.start_time, \"%H:%i\") AS start_time, TIME_FORMAT(shift_allocation.end_time, \"%H:%i\") AS end_time, employee_attendance.on_time, employee_attendance.off_time, CASE WHEN employee_attendance.approved = 1 THEN 'Yes' WHEN employee_attendance.approved = 0 THEN 'No' ELSE null END AS approval_status\r\n"
			+ "FROM employee_attendance \r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.date = shift_allocation.date AND employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date = :date AND shift_allocation.department_id = :departmentId AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public String[][] loadAttendanceRecordsByDepartment(@Param("date") String date,
			@Param("departmentId") String departmentId, @Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\") AS date, employee_attendance.shift_id, shift_allocation.shift_name, shift_allocation.department_id, shift_allocation.department_name, employee_attendance.employee_id, shift_allocation.employee_name, \r\n"
			+ "TIME_FORMAT(shift_allocation.start_time, \"%H:%i\") AS start_time, TIME_FORMAT(shift_allocation.end_time, \"%H:%i\") AS end_time, employee_attendance.on_time, employee_attendance.off_time, CASE WHEN employee_attendance.approved = 1 THEN 'Yes' WHEN employee_attendance.approved = 0 THEN 'No' ELSE null END AS approval_status\r\n"
			+ "FROM employee_attendance \r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.date = shift_allocation.date AND employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date = :date AND employee_attendance.shift_id = :shiftId AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public String[][] loadAttendanceRecordsByShift(@Param("date") String date, @Param("shiftId") String shiftId,
			@Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\") AS date, employee_attendance.shift_id, shift_allocation.shift_name, shift_allocation.department_id, shift_allocation.department_name, employee_attendance.employee_id, shift_allocation.employee_name, \r\n"
			+ "TIME_FORMAT(shift_allocation.start_time, \"%H:%i\") AS start_time, TIME_FORMAT(shift_allocation.end_time, \"%H:%i\") AS end_time, employee_attendance.on_time, employee_attendance.off_time, CASE WHEN employee_attendance.approved = 1 THEN 'Yes' WHEN employee_attendance.approved = 0 THEN 'No' ELSE null END AS approval_status\r\n"
			+ "FROM employee_attendance \r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.date = shift_allocation.date AND employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date = :date AND shift_allocation.department_id = :departmentId AND employee_attendance.shift_id = :shiftId AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public String[][] loadAttendanceRecordsByDepartmentAndShift(@Param("date") String date,
			@Param("departmentId") String departmentId, @Param("shiftId") String shiftId,
			@Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\") AS date, employee_attendance.shift_id, shift_allocation.shift_name, shift_allocation.department_id, shift_allocation.department_name, employee_attendance.employee_id, shift_allocation.employee_name, \r\n"
			+ "TIME_FORMAT(shift_allocation.start_time, \"%H:%i\") AS start_time, TIME_FORMAT(shift_allocation.end_time, \"%H:%i\") AS end_time, employee_attendance.on_time, employee_attendance.off_time, CASE WHEN employee_attendance.approved = 1 THEN 'Yes' WHEN employee_attendance.approved = 0 THEN 'No' ELSE null END AS approval_status\r\n"
			+ "FROM employee_attendance \r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.date = shift_allocation.date AND employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date = :date AND shift_allocation.department_id = :departmentId AND employee_attendance.employee_id = :employeeId AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public String[][] loadAttendanceRecordsByEmployee(@Param("date") String date,
			@Param("departmentId") String departmentId, @Param("employeeId") String employeeId,
			@Param("companyId") String companyId);

	@Query(value = "SELECT employee_attendance.attendance_id, DATE_FORMAT(employee_attendance.date, \"%d-%m-%Y\") AS date, employee_attendance.shift_id, shift_allocation.shift_name, shift_allocation.department_id, shift_allocation.department_name, employee_attendance.employee_id, shift_allocation.employee_name, \r\n"
			+ "TIME_FORMAT(shift_allocation.start_time, \"%H:%i\") AS start_time, TIME_FORMAT(shift_allocation.end_time, \"%H:%i\") AS end_time, employee_attendance.on_time, employee_attendance.off_time, CASE WHEN employee_attendance.approved = 1 THEN 'Yes' WHEN employee_attendance.approved = 0 THEN 'No' ELSE null END AS approval_status\r\n"
			+ "FROM employee_attendance \r\n"
			+ "INNER JOIN shift_allocation ON employee_attendance.date = shift_allocation.date AND employee_attendance.employee_id = shift_allocation.employee_id AND employee_attendance.shift_id = shift_allocation.shift_id AND employee_attendance.company_id = shift_allocation.company_id\r\n"
			+ "WHERE employee_attendance.date = :date AND shift_allocation.department_id = :departmentId AND employee_attendance.employee_id = :employeeId AND employee_attendance.shift_id = :shiftId AND employee_attendance.company_id = :companyId", nativeQuery = true)
	public String[][] loadAttendanceRecordsByEmployeeAndShift(@Param("date") String date,
			@Param("departmentId") String departmentId, @Param("employeeId") String employeeId,
			@Param("shiftId") String shiftId, @Param("companyId") String companyId);

	@Query(value = "SELECT year, month, employee_id, employee_name,\r\n"
			+ "TIME_FORMAT(SEC_TO_TIME(SUM(TIME_TO_SEC(over_time))), \"%H:%i\") AS total_over_time, \r\n"
			+ "TIME_FORMAT(SEC_TO_TIME(SUM(TIME_TO_SEC(short_time))), \"%H:%i\") AS total_short_time, \r\n"
			+ "count(worked_time) AS total_worked_days,\r\n"
			+ "sum(CASE WHEN attendance_description = 'Absent' && weekday != 'Sunday' THEN 1 ELSE 0 END) AS total_absent_days, \r\n"
			+ "sum(CASE WHEN day_type = 'Holiday' THEN 1 ELSE 0 END) AS total_holidays, \r\n"
			+ "sum(CASE WHEN weekday = 'Sunday' THEN 1 ELSE 0 END) AS total_rest_days \r\n"
			+ "FROM(SELECT year(shift_allocation.date) AS year, monthname(shift_allocation.date) AS month, shift_allocation.employee_id AS employee_id, shift_allocation.employee_name AS employee_name, DATE_FORMAT(shift_allocation.date, \"%W\") AS weekday, calander.Description AS day_type, \r\n"
			+ "TIMEDIFF(employee_attendance.off_time, employee_attendance.on_time) AS worked_time, \r\n"
			+ "CASE WHEN shift_allocation.start_time > employee_attendance.on_time && employee_attendance.off_time > shift_allocation.end_time THEN ADDTIME(TIMEDIFF(shift_allocation.start_time, employee_attendance.on_time), TIMEDIFF(employee_attendance.off_time, shift_allocation.end_time)) WHEN shift_allocation.start_time > employee_attendance.on_time THEN TIMEDIFF(shift_allocation.start_time, employee_attendance.on_time) WHEN employee_attendance.off_time > shift_allocation.end_time THEN TIMEDIFF(employee_attendance.off_time, shift_allocation.end_time) ELSE null END AS over_time, \r\n"
			+ "CASE WHEN employee_attendance.on_time > shift_allocation.start_time && shift_allocation.end_time > employee_attendance.off_time THEN ADDTIME(TIMEDIFF(employee_attendance.on_time, shift_allocation.start_time), TIMEDIFF(shift_allocation.end_time, employee_attendance.off_time)) WHEN employee_attendance.on_time > shift_allocation.start_time THEN TIMEDIFF(employee_attendance.on_time, shift_allocation.start_time) WHEN shift_allocation.end_time > employee_attendance.off_time THEN TIMEDIFF(shift_allocation.end_time, employee_attendance.off_time) ELSE null END AS short_time,  \r\n"
			+ "CASE WHEN CURDATE() < shift_allocation.date THEN 'Yet to come' WHEN applyleaves.Type IS NOT NULL THEN applyleaves.Type WHEN calander.Description = 'Sunday' THEN 'Restday' WHEN employee_attendance.on_time IS NULL && employee_attendance.off_time IS NULL THEN 'Absent' WHEN employee_attendance.on_time > shift_allocation.start_time THEN 'Late' ELSE null END AS attendance_description\r\n"
			+ "FROM ((shift_allocation\r\n" + "INNER JOIN calander ON shift_allocation.date = calander.Date)\r\n"
			+ "LEFT JOIN applyleaves ON shift_allocation.date = applyleaves.Date AND shift_allocation.employee_id = applyleaves.Employee_ID\r\n"
			+ "LEFT JOIN employee_attendance ON shift_allocation.date = employee_attendance.date AND shift_allocation.employee_id = employee_attendance.employee_id AND shift_allocation.shift_id = employee_attendance.shift_id) \r\n"
			+ "WHERE shift_allocation.employee_id = :employeeId AND shift_allocation.date BETWEEN :startDate AND :endDate  AND employee_attendance.company_id = :companyId AND shift_allocation.company_id = :companyId AND calander.CompanyID = :companyId)main", nativeQuery = true)
	public String[][] loadAttedanceMainReportDetails(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("employeeId") String employeeId,
			@Param("companyId") String companyId);

	@Query(value = "SELECT DATE_FORMAT(shift_allocation.date, \"%Y-%m-%d\") as date, DATE_FORMAT(shift_allocation.date, \"%W\") as weekday, calander.Description as day_type, employee_attendance.on_time, employee_attendance.off_time,\n"
			+ "TIME_FORMAT(TIMEDIFF(employee_attendance.off_time, employee_attendance.on_time), \"%H:%i\") AS worked_time, \n"
			+ "CASE WHEN shift_allocation.start_time > employee_attendance.on_time && employee_attendance.off_time > shift_allocation.end_time THEN TIME_FORMAT(CONVERT(ADDTIME(TIMEDIFF(shift_allocation.start_time, employee_attendance.on_time), TIMEDIFF(employee_attendance.off_time, shift_allocation.end_time)), TIME), \"%H:%i\") WHEN shift_allocation.start_time > employee_attendance.on_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(shift_allocation.start_time, employee_attendance.on_time), TIME), \"%H:%i\") WHEN employee_attendance.off_time > shift_allocation.end_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(employee_attendance.off_time, shift_allocation.end_time), TIME), \"%H:%i\") ELSE \"-\" END AS over_time, \n"
			+ "CASE WHEN employee_attendance.on_time > shift_allocation.start_time && shift_allocation.end_time > employee_attendance.off_time THEN TIME_FORMAT(CONVERT(ADDTIME(TIMEDIFF(employee_attendance.on_time, shift_allocation.start_time), TIMEDIFF(shift_allocation.end_time, employee_attendance.off_time)), TIME), \"%H:%i\") WHEN employee_attendance.on_time > shift_allocation.start_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(employee_attendance.on_time, shift_allocation.start_time), TIME), \"%H:%i\") WHEN shift_allocation.end_time > employee_attendance.off_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(shift_allocation.end_time, employee_attendance.off_time), TIME), \"%H:%i\") ELSE \"-\" END AS short_time,\n"
			+ "CASE WHEN CURDATE() < shift_allocation.date THEN 'Yet to come' WHEN applyleaves.Type IS NOT NULL THEN applyleaves.Type WHEN calander.Description = 'Sunday' THEN 'Restday' WHEN employee_attendance.on_time IS NULL && employee_attendance.off_time IS NULL THEN 'Absent' WHEN employee_attendance.on_time > shift_allocation.start_time THEN 'Late' ELSE null END AS attendance_description\n"
			+ "FROM ((shift_allocation \n"
			+ "INNER JOIN calander ON shift_allocation.date = calander.Date AND shift_allocation.company_id = calander.CompanyID)\n"
			+ "left JOIN applyleaves ON shift_allocation.date = applyleaves.Date AND shift_allocation.employee_id = applyleaves.Employee_ID\n"
			+ "left JOIN employee_attendance ON shift_allocation.date = employee_attendance.date AND shift_allocation.employee_id = employee_attendance.employee_id AND shift_allocation.shift_id = employee_attendance.shift_id AND shift_allocation.company_id = employee_attendance.company_id)\n"
			+ "WHERE shift_allocation.employee_id = :employeeId AND shift_allocation.date BETWEEN :startDate AND :endDate AND shift_allocation.company_id = :companyId", nativeQuery = true)
	public String[][] loadAttendanceSubReportDetails(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("employeeId") String employeeId,
			@Param("companyId") String companyId);
	
	@Query(value = "SELECT DATE_FORMAT(shift_allocation.date, \"%Y-%m-%d\") as date, DATE_FORMAT(shift_allocation.date, \"%W\") as weekday, calander.Description as day_type, employee_attendance.on_time, employee_attendance.off_time,\n"
			+ "TIME_FORMAT(TIMEDIFF(employee_attendance.off_time, employee_attendance.on_time), \"%H:%i\") AS worked_time, \n"
			+ "CASE WHEN shift_allocation.start_time > employee_attendance.on_time && employee_attendance.off_time > shift_allocation.end_time THEN TIME_FORMAT(CONVERT(ADDTIME(TIMEDIFF(shift_allocation.start_time, employee_attendance.on_time), TIMEDIFF(employee_attendance.off_time, shift_allocation.end_time)), TIME), \"%H:%i\") WHEN shift_allocation.start_time > employee_attendance.on_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(shift_allocation.start_time, employee_attendance.on_time), TIME), \"%H:%i\") WHEN employee_attendance.off_time > shift_allocation.end_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(employee_attendance.off_time, shift_allocation.end_time), TIME), \"%H:%i\") ELSE \"-\" END AS over_time, \n"
			+ "CASE WHEN employee_attendance.on_time > shift_allocation.start_time && shift_allocation.end_time > employee_attendance.off_time THEN TIME_FORMAT(CONVERT(ADDTIME(TIMEDIFF(employee_attendance.on_time, shift_allocation.start_time), TIMEDIFF(shift_allocation.end_time, employee_attendance.off_time)), TIME), \"%H:%i\") WHEN employee_attendance.on_time > shift_allocation.start_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(employee_attendance.on_time, shift_allocation.start_time), TIME), \"%H:%i\") WHEN shift_allocation.end_time > employee_attendance.off_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(shift_allocation.end_time, employee_attendance.off_time), TIME), \"%H:%i\") ELSE \"-\" END AS short_time,\n"
			+ "CASE WHEN CURDATE() < shift_allocation.date THEN 'Yet to come' WHEN applyleaves.Type IS NOT NULL THEN applyleaves.Type WHEN calander.Description = 'Sunday' THEN 'Restday' WHEN employee_attendance.on_time IS NULL && employee_attendance.off_time IS NULL THEN 'Absent' WHEN employee_attendance.on_time > shift_allocation.start_time THEN 'Late' ELSE null END AS attendance_description\n"
			+ "FROM ((shift_allocation \n"
			+ "INNER JOIN calander ON shift_allocation.date = calander.Date AND shift_allocation.company_id = calander.CompanyID)\n"
			+ "left JOIN applyleaves ON shift_allocation.date = applyleaves.Date AND shift_allocation.employee_id = applyleaves.Employee_ID\n"
			+ "left JOIN employee_attendance ON shift_allocation.date = employee_attendance.date AND shift_allocation.employee_id = employee_attendance.employee_id AND shift_allocation.shift_id = employee_attendance.shift_id AND shift_allocation.company_id = employee_attendance.company_id)\n"
			+ "WHERE shift_allocation.employee_id = :employeeId AND shift_allocation.date BETWEEN :startDate AND :endDate AND shift_allocation.company_id = :companyId", nativeQuery = true)
	public List<String> loadAttendanceSubReportDetails2(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("employeeId") String employeeId,
			@Param("companyId") String companyId);
	
	@Query(value = "SELECT DATE_FORMAT(shift_allocation.date, \"%d-%m-%Y\") as date, DATE_FORMAT(shift_allocation.date, \"%W\") as weekday, calander.Description as day_type, shift_allocation.shift_name as shift, TIME_FORMAT(shift_allocation.start_time, \"%H:%i\") as start_time, TIME_FORMAT(shift_allocation.end_time, \"%H:%i\") as end_time, employee_attendance.on_time, employee_attendance.off_time,\n" + 
			"TIME_FORMAT(TIMEDIFF(employee_attendance.off_time, employee_attendance.on_time), \"%H:%i\") AS worked_time,\n" + 
			"CASE WHEN shift_allocation.start_time > employee_attendance.on_time && employee_attendance.off_time > shift_allocation.end_time THEN TIME_FORMAT(CONVERT(ADDTIME(TIMEDIFF(shift_allocation.start_time, employee_attendance.on_time), TIMEDIFF(employee_attendance.off_time, shift_allocation.end_time)), TIME), \"%H:%i\") WHEN shift_allocation.start_time > employee_attendance.on_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(shift_allocation.start_time, employee_attendance.on_time), TIME), \"%H:%i\") WHEN employee_attendance.off_time > shift_allocation.end_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(employee_attendance.off_time, shift_allocation.end_time), TIME), \"%H:%i\") ELSE null END AS over_time,\n" + 
			"CASE WHEN employee_attendance.on_time > shift_allocation.start_time && shift_allocation.end_time > employee_attendance.off_time THEN TIME_FORMAT(CONVERT(ADDTIME(TIMEDIFF(employee_attendance.on_time, shift_allocation.start_time), TIMEDIFF(shift_allocation.end_time, employee_attendance.off_time)), TIME), \"%H:%i\") WHEN employee_attendance.on_time > shift_allocation.start_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(employee_attendance.on_time, shift_allocation.start_time), TIME), \"%H:%i\") WHEN shift_allocation.end_time > employee_attendance.off_time THEN TIME_FORMAT(CONVERT(TIMEDIFF(shift_allocation.end_time, employee_attendance.off_time), TIME), \"%H:%i\") ELSE null END AS short_time,\n" + 
			"CASE WHEN CURDATE() < shift_allocation.date THEN 'Yet to come' WHEN applyleaves.Type IS NOT NULL THEN applyleaves.Type WHEN calander.Description = 'Sunday' THEN 'Restday' WHEN employee_attendance.on_time IS NULL && employee_attendance.off_time IS NULL THEN 'Absent' WHEN employee_attendance.on_time > shift_allocation.start_time THEN 'Late' ELSE null END AS attendance_description\n" + 
			"FROM ((shift_allocation\n" + 
			"INNER JOIN calander ON shift_allocation.date = calander.Date AND shift_allocation.company_id = calander.CompanyID)\n" + 
			"left JOIN applyleaves ON shift_allocation.date = applyleaves.Date AND shift_allocation.employee_id = applyleaves.Employee_ID AND shift_allocation.company_id = applyleaves.CompanyID\n" + 
			"left JOIN employee_attendance ON shift_allocation.date = employee_attendance.date AND shift_allocation.employee_id = employee_attendance.employee_id AND shift_allocation.shift_id = employee_attendance.shift_id AND shift_allocation.company_id = employee_attendance.company_id)\n" + 
			"WHERE shift_allocation.employee_id = :employeeId AND shift_allocation.date BETWEEN :startDate AND :endDate AND shift_allocation.company_id = :companyId", nativeQuery = true)
	public String[][] loadAttendanceSubSheet(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("employeeId") String employeeId,
			@Param("companyId") String companyId);
	
	@Query(value = "SELECT TIME_FORMAT(SEC_TO_TIME(SUM(TIME_TO_SEC(over_time))), \"%H:%i\") AS total_over_time, TIME_FORMAT(SEC_TO_TIME(SUM(TIME_TO_SEC(short_time))), \"%H:%i\") AS total_short_time, count(worked_time) AS total_worked_days,\n" + 
			"sum(CASE WHEN attendance_description = 'Absent' && weekday != 'Sunday' THEN 1 ELSE 0 END) AS total_absent_days,\n" + 
			"sum(CASE WHEN day_type = 'Holiday' THEN 1 ELSE 0 END) AS total_holidays,\n" + 
			"sum(CASE WHEN weekday = 'Sunday' THEN 1 ELSE 0 END) AS total_rest_days\n" + 
			"FROM(SELECT DATE_FORMAT(shift_allocation.date, \"%W\") AS weekday, calander.Description AS day_type,\n" + 
			"TIMEDIFF(employee_attendance.off_time, employee_attendance.on_time) AS worked_time,\n" + 
			"CASE WHEN shift_allocation.start_time > employee_attendance.on_time && employee_attendance.off_time > shift_allocation.end_time THEN ADDTIME(TIMEDIFF(shift_allocation.start_time, employee_attendance.on_time), TIMEDIFF(employee_attendance.off_time, shift_allocation.end_time)) WHEN shift_allocation.start_time > employee_attendance.on_time THEN TIMEDIFF(shift_allocation.start_time, employee_attendance.on_time) WHEN employee_attendance.off_time > shift_allocation.end_time THEN TIMEDIFF(employee_attendance.off_time, shift_allocation.end_time) ELSE null END AS over_time,\n" + 
			"CASE WHEN employee_attendance.on_time > shift_allocation.start_time && shift_allocation.end_time > employee_attendance.off_time THEN ADDTIME(TIMEDIFF(employee_attendance.on_time, shift_allocation.start_time), TIMEDIFF(shift_allocation.end_time, employee_attendance.off_time)) WHEN employee_attendance.on_time > shift_allocation.start_time THEN TIMEDIFF(employee_attendance.on_time, shift_allocation.start_time) WHEN shift_allocation.end_time > employee_attendance.off_time THEN TIMEDIFF(shift_allocation.end_time, employee_attendance.off_time) ELSE null END AS short_time,\n" + 
			"CASE WHEN CURDATE() < shift_allocation.date THEN 'Yet to come' WHEN applyleaves.Type IS NOT NULL THEN applyleaves.Type WHEN calander.Description = 'Sunday' THEN 'Restday' WHEN employee_attendance.on_time IS NULL && employee_attendance.off_time IS NULL THEN 'Absent' WHEN employee_attendance.on_time > shift_allocation.start_time THEN 'Late' ELSE null END AS attendance_description\n" + 
			"FROM ((shift_allocation INNER JOIN calander ON shift_allocation.date = calander.Date AND shift_allocation.company_id = calander.CompanyID)\n" + 
			"LEFT JOIN applyleaves ON shift_allocation.date = applyleaves.Date AND shift_allocation.employee_id = applyleaves.Employee_ID AND shift_allocation.company_id = applyleaves.CompanyID\n" + 
			"LEFT JOIN employee_attendance ON shift_allocation.date = employee_attendance.date AND shift_allocation.employee_id = employee_attendance.employee_id AND shift_allocation.shift_id = employee_attendance.shift_id AND shift_allocation.company_id = employee_attendance.company_id) \n" + 
			"WHERE shift_allocation.employee_id = :employeeId AND shift_allocation.date BETWEEN :startDate AND :endDate AND shift_allocation.company_id = :companyId)main", nativeQuery = true)
	public String[][] loadAttendanceMainSheet(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("employeeId") String employeeId,
			@Param("companyId") String companyId);

	@Query(value = "SELECT Department FROM department where department.Department_ID = :departmentId AND department.Company_ID = :companyId", nativeQuery = true)
	public String getDepartmentByIdAndCompany(@Param("departmentId") String departmentId, @Param("companyId") String companyId);

}
