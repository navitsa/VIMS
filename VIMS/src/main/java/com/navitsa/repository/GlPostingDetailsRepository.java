package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.GlPostingDetails;

public interface GlPostingDetailsRepository extends CrudRepository<GlPostingDetails, Integer> {

	@Query(value = "SELECT pd.GlAccNo,g.GlAccountName,g.PrimaryAccount,sum(if(pd.type='D',pd.Amount,0)),sum(if(pd.type='C',pd.Amount,0)) FROM gl_posting_details pd,gl_posting_head ph,glaccount g "
			+ "where pd.Journal_No=ph.Journal_No and g.GlAccNo=pd.GlAccNo and ph.Date between  :fromdate and :todate and ph.Center_ID=:center group by pd.GlAccNo    order by g.PrimaryAccount,pd.GlAccNo", nativeQuery = true)
	public String[][] getGlPostingDateByDate(@Param("fromdate") String fromdate, @Param("todate") String todate,
			@Param("center") String center);

	@Query(value = "SELECT pd.GlAccNo,g.GlAccountName,g.PrimaryAccount,(sum(if(pd.type='D',pd.Amount,0))-sum(if(pd.type='C',pd.Amount,0))) FROM gl_posting_details pd,gl_posting_head ph,glaccount g "
			+ "where pd.Journal_No=ph.Journal_No and g.GlAccNo=pd.GlAccNo and g.PrimaryAccount in ('Expense','Income')  and  ph.Date like :todate and ph.Center_ID=:center group by pd.GlAccNo    order by g.PrimaryAccount,pd.GlAccNo", nativeQuery = true)
	public String[][] getProfitsAndLossData(@Param("todate") String todate, @Param("center") String center);

	@Query(value = "SELECT ph.Journal_No,ph.doc_No,ph.Doc_id,g.GlAccountName,g.PrimaryAccount,(if(pd.type='D',pd.Amount,0)),(if(pd.type='C',pd.Amount,0)),ph.Date FROM gl_posting_details pd,gl_posting_head ph,glaccount g "
			+ "where pd.Journal_No=ph.Journal_No and g.GlAccNo=pd.GlAccNo and g.GlAccNo=:glaccno  and ph.Date between  :fromdate and :todate and ph.Center_ID=:center  order by ph.Date,ph.Journal_No", nativeQuery = true)
	public String[][] getGlPostingDateByGlaccno(@Param("fromdate") String fromdate, @Param("todate") String todate,
			@Param("glaccno") String glaccno, @Param("center") String center);

	@Query(value = "SELECT glpd FROM GlPostingDetails glpd WHERE glpd.journalNo.journalNo=:journalNo")
	public List<GlPostingDetails> getGlPostingDetailsByJournalNo(@Param("journalNo") int journalNo);

}
