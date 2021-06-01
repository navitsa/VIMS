package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.GlPostingHead;

public interface GlPostingHeadRepository extends CrudRepository<GlPostingHead, Integer> {

	@Query(value = "SELECT glph FROM GlPostingHead glph WHERE glph.docid.docid=:docId")
	List<GlPostingHead> getGLPostingHeadsByDocId(@Param("docId") int docId);

	@Query(value = "SELECT glph FROM GlPostingHead glph WHERE glph.docNo=:docNo")
	GlPostingHead getGlPostingHeadByDocNo(@Param("docNo") String docNo);
}
