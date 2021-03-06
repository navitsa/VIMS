package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.GlPostingDetails;

public interface GlPostingDetailsRepository  extends CrudRepository<GlPostingDetails, Integer>{

	@Query(value = "SELECT pd.GlAccNo,g.GlAccountName,g.PrimaryAccount,sum(if(pd.type='D',pd.Amount,0)),sum(if(pd.type='C',pd.Amount,0)) FROM gl_posting_details pd,gl_posting_head ph,glaccount g "
			+ "where pd.Journal_No=ph.Journal_No and g.GlAccNo=pd.GlAccNo and ph.Date between  :fromdate and :todate and ph.Center_ID=:center group by pd.GlAccNo    order by g.PrimaryAccount,pd.GlAccNo",nativeQuery = true)
	public String[][] getGlPostingDateByDate(@Param("fromdate")String fromdate,@Param("todate")String todate,@Param("center")String center);
	
	@Query(value = "SELECT pd.GlAccNo,g.GlAccountName,g.PrimaryAccount,(sum(if(pd.type='D',pd.Amount,0))-sum(if(pd.type='C',pd.Amount,0))) FROM gl_posting_details pd,gl_posting_head ph,glaccount g "
			+ "where pd.Journal_No=ph.Journal_No and g.GlAccNo=pd.GlAccNo and g.PrimaryAccount in ('Expenses','Income')  and  ph.Date like :todate and ph.Center_ID=:center group by pd.GlAccNo    order by g.PrimaryAccount,pd.GlAccNo",nativeQuery = true)
	public String[][] getProfitsAndLossData(@Param("todate")String todate,@Param("center")String center);
	
	
}
