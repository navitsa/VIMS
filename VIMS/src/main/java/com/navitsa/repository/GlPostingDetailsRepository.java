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

	@Query(value = "SELECT glpd FROM GlPostingDetails glpd WHERE glpd.journalNo.date BETWEEN :fromDate AND :toDate")
	public List<GlPostingDetails> getGlPostingDetailsByDates(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT gpd.type as type, if(aph.supplier_id is null=1, apih.supplier_id,aph.supplier_id) as supplier_id, gph.date, gph.doc_No as invoice_no, dt.Document, gph.Journal_No as gl_no, gla.GlAccNo as gl_account_no, gla.GlAccountName as gl_account, if(gpd.type='C',gpd.Amount,0) as credit,if(gpd.type='D',gpd.Amount,0) as debit FROM vims.gl_posting_details gpd left join glaccount gla on gpd.GlAccNo = gla.GlAccNo ,gl_posting_head gph left join ap_invoice_head aph on gph.doc_No = aph.ap_invoice_head_id left join ap_invoice_payment_head apih on gph.doc_No = apih.ap_payment_head_id left join doc_type dt on gph.Doc_id = dt.Doc_id \r\n" + 
			"where gpd.Journal_No = gph.Journal_No and gph.Doc_id in ('5','6') and if(aph.supplier_id is null=1, apih.supplier_id,aph.supplier_id) = :supplierId and gph.date between :fromDate and :toDate", nativeQuery = true)
	public String[][] getVendorGLTransactionReportDetails(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("supplierId") String supplierId);
}
