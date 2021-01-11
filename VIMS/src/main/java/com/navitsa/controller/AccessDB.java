package com.navitsa.controller;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.navitsa.entity.EmissionDieselCertificateData;
import com.navitsa.entity.EmissionDieselCertificateReadings;
import com.navitsa.services.TestReportConfigService;

@Controller
public class AccessDB {

	
	@Autowired
	private TestReportConfigService testReportService;
	
	@RequestMapping("/readingEmissionResults")
	public void readingEmissionResults(){
		// TODO Auto-generated method stub
		try{  
			   //String url="jdbc:odbc:mydsn";  
			   Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			   
			   String path ="C:\\Users\\Mudalige\\Documents\\M Access dbs\\DieselTest.mdb";
			   
			   String url = "jdbc:ucanaccess://"+path;
			   
			   
			   Connection c=DriverManager.getConnection(url,"Admin","avl123");
			   Statement st=c.createStatement();  
			   ResultSet rs=st.executeQuery("select * from T_Certificate_Data WHERE Vehicle_No='RJ06PB6430'"); 
			   String id_no = null;
			    
			   while(rs.next()){
				id_no =   rs.getString(2);
				//System.out.println(rs.getString(2)+" "+rs.getString(6)+" "+rs.getString(27));
			    EmissionDieselCertificateData obj = new EmissionDieselCertificateData();
			    obj.setId_no(rs.getString(2));
			    obj.setVehicle_no(rs.getString(6));
			    obj.setResult(rs.getString(27));
			    testReportService.saveEmissionDieselCertificateData(obj);
			   }
			   
			   rs.close();
			   st.close();
			   
			   PreparedStatement stmt=c.prepareStatement("select * from T_Certificate_Readings WHERE S_No = ?"); 
			   stmt.setString(1, id_no);
			   ResultSet rs1=stmt.executeQuery(); 
			   while(rs1.next()) {
				   
				   EmissionDieselCertificateData DCDobj = new EmissionDieselCertificateData();
				   DCDobj.setId_no(id_no);
				   EmissionDieselCertificateReadings obj = new EmissionDieselCertificateReadings();
				   obj.setK(rs1.getString(3));
				   obj.setHsu(rs1.getString(4));
				   obj.setRpm_min(rs1.getString(5));
				   obj.setRpm_max(rs1.getString(6));
				   obj.setOil_temp(rs1.getString(7));
				   obj.setEdc_id(DCDobj);
				   
				   testReportService.saveEmissionDieselCertificateReadings(obj);
				   
				   System.out.println(rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4));
			   }
			   
			   
			  
			}catch(Exception ee){System.out.println(ee);}  
	}

}
