package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.Users;

public interface UsersRepository  extends CrudRepository<Users, String>{

		@Query(value="SELECT u FROM Users u WHERE u.userName =:uname AND u.password =:pass")
		public List<Users> checkLogin(@Param("uname") String uname,@Param("pass") String pass);
				
		@Query(value = "SELECT (max(s.userId)+1) FROM Users s ")
	    public String maxUsersID();
				
		@Query(value="SELECT u FROM Users u WHERE u.userName =:uname")
		public List<Users> userbyuserName(@Param("uname") String uname);
		
		@Query(value="SELECT u FROM Users u WHERE u.ulid.ulid =:userLevel")
		public List<Users> userbyLevel(@Param("userLevel") String userLevel);
			
		@Query(value="SELECT u FROM Users u WHERE u.userId =:userid")
		public Users userDet(@Param("userid") String userid);

		@Query(value="SELECT u FROM Users u WHERE u.userName =:userName")
		public Users userNamesearch(@Param("userName") String userName);
		
		@Query(value="SELECT u FROM Users u WHERE u.userName =:uname AND u.login =:login")
		public List<Users> checkQrLogin(@Param("uname") String uname,@Param("login") String login);
		
		
}
