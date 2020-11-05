package com.navitsa.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.VisualProfileItems;


public interface VisuaProfileItemRepository extends CrudRepository<VisualProfileItems, String>{
	
    @Query(value = "SELECT i FROM VisualProfileItems i WHERE i.profile =:profileID AND i.stage.stageID =:stageID")
    public List<VisualProfileItems> search(@Param("profileID") String profileID,@Param("stageID") String stageID);
    
	@Query(value = "SELECT (max(vi.itemId)+1) FROM VisualProfileItems vi")
    public String maxItemID();
	
    //@Query(value = "SELECT COUNT FROM VisualProfileItems i WHERE i.profile =:profileID AND i.stage.stageID =:stageID")
    //public int getItemCount(@Param("profileID") String profileID,@Param("stageID") String stageID);

	
}
