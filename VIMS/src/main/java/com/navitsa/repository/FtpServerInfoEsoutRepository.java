package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.FtpServerInfoEsout;

public interface FtpServerInfoEsoutRepository extends CrudRepository<FtpServerInfoEsout, Integer> {
	
	@Query(value = "SELECT ftp FROM FtpServerInfoEsout ftp where ftp.center_id.center_ID=:center_id")
    public List<FtpServerInfoEsout> getFTPServerInfo(@Param("center_id") String center_id);

}
