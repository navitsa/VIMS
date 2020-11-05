package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.Roleassign;

public interface RoleassignRepository  extends CrudRepository<Roleassign, String>{

	@Query(value="SELECT r FROM Roleassign r WHERE r.roleassignPK.userID.userId =:userid and r.status='ACTIVE' and r.roleassignPK.roleID.status='ACTIVE'")
	public List<Roleassign> findUserIdRoles(@Param("userid") String userid);
	
}
