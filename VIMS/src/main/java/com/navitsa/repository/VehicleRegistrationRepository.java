package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.VehicleRegistration;

public interface VehicleRegistrationRepository  extends CrudRepository<VehicleRegistration, String>  {
	

	@Query(value = "SELECT v FROM VehicleRegistration v WHERE v.vid.vehicleID =:vehicle_no AND v.viTestStatus ='pending' and v.status='ACTIVE'")
	public VehicleRegistration getPendingVehicle(@Param("vehicle_no") String vehicle_no);
	
	@Query(value = "SELECT v FROM VehicleRegistration v WHERE v.viTestStatus ='pending' and v.status='ACTIVE' ORDER BY v.date DESC, v.time DESC")
	public List<VehicleRegistration> getPendingVehicle();
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE VehicleRegistration vr SET vr.viTestStatus ='completed' WHERE vr.vregID=:vRegID")
	public int update_vi_test_status(@Param("vRegID") String vRegID);
	
	@Query(value = "SELECT (max(e.vregID)+1) FROM VehicleRegistration e ")
	public String maxVRegID();
	
	@Query(value="SELECT vr.testCategory.categoryId FROM VehicleRegistration vr WHERE vr.vregID =:register_id")
	public String getCategoryID(@Param("register_id") String register_id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE VehicleRegistration vr SET vr.testStatus ='completed' WHERE vr.vregID =:register_id")
	public int update_test_status(@Param("register_id") String register_id);
	
	@Query(value="SELECT V_Register_ID FROM vehicle_registration where Vehicle_ID =:vehicle_id AND Test_Status='pending' order by V_Register_ID DESC limit 1",nativeQuery=true)
	public String getRegistrationID(@Param("vehicle_id") String vehicle_id);
	
	@Query(value="SELECT vr FROM VehicleRegistration vr WHERE vr.date =:vRdate and vr.payType=:payTyp group by vid.vehicleID order by vid.vehicleID")
	public List<VehicleRegistration> getVechicalDetailByDate(@Param("vRdate") String vRdate,@Param("payTyp") String payTyp);
		
	@Query(value="SELECT v FROM VehicleRegistration v WHERE v.vid.vehicleID =:vehicle_no and v.status='ACTIVE' ORDER BY v.vregID DESC")
	public List<VehicleRegistration> getPerviousRegistrationVehicle(@Param("vehicle_no") String vehicle_no);
	
	@Query(value = "select vr From VehicleRegistration vr WHERE vr.testStatus ='pending' and vr.vid.vehicleID =:vehicle_no")
	public List<VehicleRegistration> getTestStatusVehicleRegistation(@Param("vehicle_no") String vehicleID);
	
	@Query(value = "select vr From VehicleRegistration vr WHERE  vr.date =:date and vr.centermaster.center_ID=:centerid")
	public List<VehicleRegistration> getVehicleRegDetailByDate(@Param("date") String date,@Param("centerid") String centerid);

	@Query(value="SELECT v FROM VehicleRegistration v WHERE v.ocrid.ocrid=:oid and v.status='ACTIVE'")
	public VehicleRegistration getRegistrationVehicleByOcrid(@Param("oid") int ocrid);

	@Query(value="SELECT vr FROM VehicleRegistration vr WHERE vr.ocrid.ocrid =:ocridn")
	public VehicleRegistration getRegistrationByRegisterId(@Param("ocridn") int ocrid);
}
