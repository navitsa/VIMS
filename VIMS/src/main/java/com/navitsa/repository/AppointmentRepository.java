package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment , String> {

	@Query(value = "SELECT (max(a.appointmentID)+1) FROM Appointment a ")
    public String nextId();

	@Query(value = "SELECT appointment_time FROM appointment where appointment_date =:selectedDate AND lane=:laneID",nativeQuery = true)
	//@Query(value = "SELECT a FROM Appointment a where a.appointmentDate =:selectedDate AND a.lane.testLaneHeadId=:laneID")
	public String[] getReservedTimes(@Param("selectedDate") String selectedDate, @Param("laneID") String laneID);

	@Query(value = "SELECT a FROM Appointment a where a.status='pending'")
    public List<Appointment> getAllPendingAppointment();
	
	@Query(value = "SELECT * FROM appointment WHERE date(appointment_date)=curdate() AND time(appointment_time) > curtime() AND status='pending'",nativeQuery = true)
    public List<Appointment> getPendingAppointmentsByDate(@Param("selectedDate") String selectedDate);

	@Query(value = "SELECT count(*),COALESCE(sum(if(a.status='pending',0,1)),0) FROM appointment a WHERE  a.appointment_date =:selectedDate",nativeQuery = true)
    public String[][] getDashBordApoymentDetails(@Param("selectedDate") String selectedDate);
	
	@Query(value = "SELECT * FROM appointment WHERE date(appointment_date)=curdate() AND  time(appointment_time) < curtime() AND status='pending' order by time(appointment_time) DESC",nativeQuery=true)
    public List<Appointment> getLateAppos();
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Appointment a SET a.status ='cancelled' WHERE a.appointmentID =:appoID")
	public int cancellingAppointment(@Param("appoID") String appoID);
	
	
}
