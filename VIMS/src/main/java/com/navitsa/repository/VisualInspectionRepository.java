package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.VisualProfile;


public interface VisualInspectionRepository extends CrudRepository<VisualProfile, String> {
	
	@Query(value = "SELECT (max(vp.visualProfileID)+1) FROM VisualProfile vp ")
    public String maxProfileID();
	
	@Query(value = "select visual_profile_stages.Stage,\r\n" + 
			"visual_profile_items.Visual_Profile_Item,\r\n" + 
			"coalesce(v_profile_item_status.V_Profile_Item_Status,'') as V_Profile_Item_Status ,\r\n" + 
			"coalesce(items_status_remarks.Item_Status_Remarks,'') as Item_Status_Remarks \r\n" + 
			"from visual_profile_stages \r\n" + 
			"left join visual_profile_items ON visual_profile_stages.Visual_Profile_Stage_ID = visual_profile_items.Visual_Profile_Stage_ID \r\n" + 
			"left join v_profile_item_status ON visual_profile_items.Visual_Profile_Item_ID = v_profile_item_status.Visual_Profile_Item_ID \r\n" + 
			"left join items_status_remarks ON v_profile_item_status.V_Profile_Item_Status_ID = items_status_remarks.V_Profile_Item_Status_ID\r\n" + 
			"WHERE visual_profile_stages.Visual_Profile_ID=:proId\r\n" + 
			"order by visual_profile_stages.Stage;",nativeQuery = true)
    public String[][] getSummary(@Param("proId") String proId);
	
	/*@Query(value = "SELECT vp FROM VisualProfile vp WHERE vp.testCat.categoryId =:catID")
    public VisualProfile findBycatID(@Param("catID") String catID);*/
	
}
