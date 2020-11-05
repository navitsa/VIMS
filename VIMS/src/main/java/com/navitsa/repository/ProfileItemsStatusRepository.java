package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.ProfileItemsStatus;

public interface ProfileItemsStatusRepository extends CrudRepository<ProfileItemsStatus, String> {
	
	@Query(value = "SELECT s FROM ProfileItemsStatus s WHERE s.visualprofileID LIKE '%' || :profileID || '%' AND s.visualProfileStageID LIKE '%' || :stageID || '%'"
			+ "AND s.item.itemId LIKE '%' || :itemID || '%' " )
	public List<ProfileItemsStatus> search(@Param("profileID") String profileID , @Param("stageID") String stageID , @Param("itemID") String itemID);
	
	@Query(value = "SELECT (max(i.profileItemStatusID)+1) FROM ProfileItemsStatus i ")
    public String maxStatusID();

}
