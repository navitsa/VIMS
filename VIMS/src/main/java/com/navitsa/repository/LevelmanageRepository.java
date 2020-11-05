package com.navitsa.repository;

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
}
