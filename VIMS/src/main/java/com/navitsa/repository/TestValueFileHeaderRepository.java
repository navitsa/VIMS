package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.TestValueFileHeader;

public interface TestValueFileHeaderRepository extends CrudRepository<TestValueFileHeader,Integer> {
	
	
	@Query(value = "SELECT (max(tvh.test_value_file_id)+1) FROM TestValueFileHeader tvh ")
    public String getMaxHeaderID();
	
	@Query(value = "SELECT tvh FROM TestValueFileHeader tvh WHERE tvh.status='pending'")
    public List<TestValueFileHeader> getPendingReports();
	
	@Query(value = "SELECT tvh FROM TestValueFileHeader tvh WHERE tvh.status='completed'")
    public List<TestValueFileHeader> getCompletedReports();
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE TestValueFileHeader a SET a.status ='completed' WHERE a.vreg.vregID =:register_id")
	public int update_status(@Param("register_id") String register_id);
	
//	@Query(value = "SELECT * FROM ftp_server_info_esout where Center_ID=:center_id",nativeQuery = true)
//    public List<FtpServerInfoEsout> getFTPServerInfo(@Param("center_id") String center_id);

}
