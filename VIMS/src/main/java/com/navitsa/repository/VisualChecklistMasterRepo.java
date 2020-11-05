package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.VisualChecklistMaster;

public interface VisualChecklistMasterRepo extends CrudRepository<VisualChecklistMaster, String>  {

	@Query(value = "SELECT (max(vcm.cheklistID)+1) FROM VisualChecklistMaster vcm ")
    public String maxCheckListMasterID();
	
	@Query(value = "SELECT cm FROM VisualChecklistMaster cm WHERE cm.cheklistID =:chMasterID")
	public VisualChecklistMaster getLastRecord(@Param("chMasterID") String chMasterID);
	
	@Query(value = "SELECT vcm FROM VisualChecklistMaster vcm ORDER BY vcm.cheklistID DESC")
	public List<VisualChecklistMaster> getAll();
	
	@Query(value = "SELECT cm FROM VisualChecklistMaster cm WHERE cm.vr.vregID =:regID")
	public VisualChecklistMaster getChecklistMasterData(@Param("regID") String regID);
	
}
