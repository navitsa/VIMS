package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitsa.entity.UserLevel;

public interface UserLevelRepository  extends CrudRepository<UserLevel, String>{

	
	@Query(value = "SELECT (max(s.ulid)+1) FROM UserLevel s ")
    public String maxUserlevelID();
}
