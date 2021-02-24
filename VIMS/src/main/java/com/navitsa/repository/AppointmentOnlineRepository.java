package com.navitsa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.AppointmentOnline;

public interface AppointmentOnlineRepository extends CrudRepository<AppointmentOnline , String> {

	@Query(value = "SELECT a.appointmentTime FROM AppointmentOnline a where a.appointmentDate =:selectedDate AND a.categoryId.categoryId =:catID")
	public String[] getReservedTimes(@Param("selectedDate") Date selectedDate,@Param("catID") String catID);
	
	@Query(value = "SELECT * FROM appointment_online WHERE date(appointment_date)=curdate() AND time(appointment_time) > curtime() AND appointment_status='pending' ORDER BY time(appointment_time) ASC",nativeQuery = true)
    public List<AppointmentOnline> viewAppointmentsAtGate(@Param("selectedDate") String selectedDate);

	@Query(value = "SELECT * FROM appointment_online WHERE date(appointment_date)=curdate() AND  time(appointment_time) < curtime() AND appointment_status='pending' order by time(appointment_time) DESC",nativeQuery=true)
    public List<AppointmentOnline> getLateAppos();

	@Transactional
	@Modifying
	@Query(value = "UPDATE AppointmentOnline a SET a.appointmentStatus ='cancelled' WHERE a.appointmentID =:appoID")
	public int cancellingAppointment(@Param("appoID") String appoID);
}
