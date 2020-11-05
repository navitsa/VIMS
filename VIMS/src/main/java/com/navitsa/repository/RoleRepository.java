package com.navitsa.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.Role;

public interface RoleRepository extends CrudRepository<Role, String> {

	@Query(value = "SELECT RoleID FROM levelmanag where level_ID=:ulid",nativeQuery = true)
	public String[] listOfRoles(@Param("ulid") String ulid);
	
	@Query(value = "SELECT r FROM Role r WHERE r.status='ACTIVE' ORDER BY r.roleID")
	public List<Role> getAllRoles();
	
	@Query(value = "SELECT r FROM Role r,Levelmanage l WHERE l.levelManagePK.levelID.ulid=:ulid and l.levelManagePK.roleID.roleID=r.roleID")
	public List<Role> getAssignRoleByLevel(@Param("ulid") String ulid);
	

}
