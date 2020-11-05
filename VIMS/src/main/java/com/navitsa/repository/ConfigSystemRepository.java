package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.ConfigSystem;

public interface ConfigSystemRepository extends CrudRepository<ConfigSystem, Integer> {
	
	@Query(value = "SELECT cs FROM ConfigSystem cs WHERE cs.centermaster.center_ID =:centerid and cs.testLaneHeadId.testLaneHeadId=:lanehId and cs.type='FTP'")
	public List<ConfigSystem> getConfigSystemByCenter(@Param("centerid")String centerid,@Param("lanehId") String lanehId);

	@Query(value = "SELECT cs FROM ConfigSystem cs WHERE cs.centermaster.center_ID =:center_id AND cs.type=:type")
	public List<ConfigSystem> getFTPServerInfo(@Param("center_id") String center_id,@Param("type") String type);
}
