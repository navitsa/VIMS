package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment , String> {

	@Query(value = "SELECT (max(a.appointmentID)+1) FROM Appointment a ")
    public String nextId();

	@Query(value = "SELECT appointment_time FROM appointment where appointment_date =:selectedDate AND lane=:laneID",nativeQuery = true)
	//@Query(value = "SELECT a FROM Appointment a where a.appointmentDate =:selectedDate AND a.lane.testLaneHeadId=:laneID")
	public String[] getReservedTimes(@Param("selectedDate") String selectedDate, @Param("laneID") String laneID);

	@Query(value = "SELECT a FROM Appointment a where a.status='pending'")
    public List<Appointment> getAllPendingAppointment();
	
	@Query(value = "SELECT * FROM appointment WHERE status = 'pending' AND appointment_date =:selectedDate",nativeQuery = true)
    public List<Appointment> getPendingAppointmentsByDate(@Param("selectedDate") String selectedDate);

	@Query(value = "SELECT count(*),COALESCE(sum(if(a.status='pending',0,1)),0) FROM appointment a WHERE  a.appointment_date =:selectedDate",nativeQuery = true)
    public String[][] getDashBordApoymentDetails(@Param("selectedDate") String selectedDate);
}
