package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.Levelmanage;
import com.navitsa.entity.LevelmanagePK;

public interface LevelmanageRepository extends CrudRepository<Levelmanage, LevelmanagePK> {

	
	@Transactional
	@Modifying
	@Query(value="DELETE From Levelmanage  WHERE levelManagePK.levelID.ulid=:levelid")
	public void deleteUserLevelManageByLevelid(@Param("levelid")String levelid);
	
	@Query(value = "SELECT ul FROM Levelmanage ul,Users u where u.userId=:userid and u.ulid.ulid=ul.levelManagePK.levelID.ulid ")
    public List<Levelmanage> getUserLevelmanageRole(@Param("userid")String userid);
	
}
