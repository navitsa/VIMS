package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.VisualChecklistDetail;

public interface VisualChecklistDetailRepo extends CrudRepository<VisualChecklistDetail,Integer> {
	
	@Query(value = "SELECT vcd FROM VisualChecklistDetail vcd WHERE vcd.vcm.cheklistID =:chMasterID")
	public List<VisualChecklistDetail> getAllData(@Param("chMasterID") String chMasterID);
	
	@Query(value = "SELECT vcd FROM VisualChecklistDetail vcd WHERE vcd.vcm.cheklistID =:chMasterID AND (vcd.status.profileItemStatusID is not null OR vcd.image is not null)")
	public List<VisualChecklistDetail> getCheckedData(@Param("chMasterID") String chMasterID);

}
