package com.navitsa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.navitsa.Reports.EmissionDieselResult;
import com.navitsa.Reports.EmissionPetrolResultBean;
import com.navitsa.entity.EmissionDieselCertificateData;
import com.navitsa.entity.EmissionDieselCertificateReadings;
import com.navitsa.entity.EmissionPetrolCertificateData;
import com.navitsa.entity.EmissionPetrolCertificateGas;
import com.navitsa.entity.EmissionPetrolCertificateLembda;
import com.navitsa.entity.EmissionPetrolCertificatePetrol;
import com.navitsa.entity.VehicleRegistration;

public class JDBCSingletonAVL {
	// static member holds only one instance of the JDBCSingleton class.

	private static JDBCSingletonAVL jdbc;

	// JDBCSingleton prevents the instantiation from any other class.
	private JDBCSingletonAVL() {}

	// Now we are providing gloabal point of access.

	public static JDBCSingletonAVL getInstance() {
		if (jdbc == null) {
			jdbc = new JDBCSingletonAVL();
		}
		return jdbc;
	}

	// to get the connection from methods like insert, view etc.
	private static Connection getConnection(String avlPath, String dbName) throws ClassNotFoundException, SQLException {

		Connection con = null;
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		String url = "jdbc:ucanaccess://"+avlPath+"//"+dbName;
		con = DriverManager.getConnection(url,"Admin","avl123");
		return con;

	}
	
	//to get the data from the database      
	public EmissionDieselResult pullDieselData(String vehicleID,VehicleRegistration vrobj,
			String avlPath,String dbName) throws SQLException
	{
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		EmissionDieselCertificateData edcd = null;
		List<EmissionDieselCertificateReadings> list = new ArrayList<>();
		
		try {

			con=this.getConnection(avlPath,dbName);
			ps=con.prepareStatement("select * from T_Certificate_Data WHERE Vehicle_No=? ORDER BY ID_No DESC LIMIT 1");
			ps.setString(1, vehicleID);
			rs=ps.executeQuery();

			String id_no = null;
			while (rs.next()) {
				
				edcd = new EmissionDieselCertificateData();
				id_no = rs.getString("ID_No");
				edcd.setId_no(id_no);
				edcd.setVehicle_no(rs.getString("Vehicle_No"));
				edcd.setHsu_pres(rs.getString("HSUmean_Pres"));
				edcd.setK_pres(rs.getString("Kmean_Pres"));
				edcd.setResult(rs.getString("Result"));
				edcd.setReg_id(vrobj);
			}
			
			if(id_no != null) {
				ps2=con.prepareStatement("select * from T_Certificate_Readings WHERE S_No = ?");
				ps2.setString(1,id_no);
				rs2=ps2.executeQuery();
				while (rs2.next()) {
					EmissionDieselCertificateReadings edcr = new EmissionDieselCertificateReadings();
					edcr.setK(rs2.getString("K"));
					edcr.setHsu(rs2.getString("HSU"));
					edcr.setRpm_min(rs2.getString("RPM_Min"));
					edcr.setRpm_max(rs2.getString("RPM_Max"));
					edcr.setOil_temp(rs2.getString("Oil_Temp"));
					//edcr.setEdc_id(null);
					list.add(edcr);
				}			
			}

		} catch (Exception e) {
			System.out.println(e);

		}finally{
			if(rs!=null){
				rs.close();
				//rs2.close();
			}if (ps!=null){
				ps.close();
				//ps2.close();
			}if(con!=null){
				con.close();
			} 

		}
		return new EmissionDieselResult(edcd,list);
		
	}
	
	public EmissionPetrolResultBean pullPetrolData(String vehicleID,VehicleRegistration vrobj,
			String avlPath,String dbName) throws SQLException
	{
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps4 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		
		EmissionPetrolCertificateData epcd = null;
		EmissionPetrolCertificateGas epcg = null;
		EmissionPetrolCertificateLembda epcl = null;
		EmissionPetrolCertificatePetrol epcp = null;
		
		try {

			con=this.getConnection(avlPath,dbName);
			ps=con.prepareStatement("select * from T_Certificate_Data WHERE Vehicle_No=:vehicleID ORDER BY ID_No DESC LIMIT 1");
			ps.setString(1, vehicleID);
			rs=ps.executeQuery();

			String id_no = null;
			while (rs.next()) {
				
				epcd = new EmissionPetrolCertificateData();
				id_no = rs.getString("ID_No");
				epcd.setId_no(id_no);
				epcd.setVehicle_no(rs.getString("Vehicle_No"));
				epcd.setResult(rs.getString("Result"));
				epcd.setCancelled(rs.getString("Cancelled"));
				epcd.setReg_id(vrobj);
			}
			
			if(id_no != null) {
				ps2=con.prepareStatement("select * from T_Certificate_Gas WHERE ID_NO = ?");
				ps2.setString(1,id_no);
				rs2=ps2.executeQuery();
				while (rs2.next()) {
					epcg = new EmissionPetrolCertificateGas();
					//epcg.setId_no();
					epcg.setPres_co(rs2.getString("Gas_Pres_CO"));
					epcg.setPres_hc(rs2.getString("Gas_Pres_HC"));
					epcg.setCo(rs2.getString("Gas_Pretuned_CO"));
					epcg.setHc(rs2.getString("Gas_Pretuned_HC"));
					epcg.setCo2(rs2.getString("Gas_Pretuned_CO2"));
					epcg.setO2(rs2.getString("Gas_Pretuned_O2"));
					epcg.setNox(rs2.getString("Gas_Pretuned_NOX"));
					epcg.setLembda(rs2.getString("Gas_Pretuned_LEMBDA"));
					epcg.setRpm(rs2.getString("Gas_Pretuned_RPM"));					
				}
				
				ps3=con.prepareStatement("select * from T_Certificate_Lambda WHERE ID_NO = ?");
				ps3.setString(1,id_no);
				rs3=ps3.executeQuery();
				while (rs3.next()) {
					epcl = new EmissionPetrolCertificateLembda();
					//epcl.setId_no();
					epcl.setCo(rs3.getString("Lambda_CO"));
					epcl.setHc(rs3.getString("Lambda_HC"));
					epcl.setCo2(rs3.getString("Lambda_CO2"));
					epcl.setO2(rs3.getString("Lambda_O2"));
					epcl.setNox(rs3.getString("Lambda_NOX"));
					epcl.setLembda(rs3.getString("Lambda_LEMBDA"));
					epcl.setRpm(rs3.getString("Lambda_RPM"));					
				}
				
				ps4=con.prepareStatement("select * from T_Certificate_Petrol WHERE ID_NO = ?");
				ps4.setString(1,id_no);
				rs4=ps4.executeQuery();
				while (rs4.next()) {
					epcp = new EmissionPetrolCertificatePetrol();
					//epcp.setId_no();
					epcp.setPres_co(rs4.getString("Petrol_Pres_CO"));
					epcp.setPres_hc(rs4.getString("Petrol_Pres_HC"));
					epcp.setCo(rs4.getString("Petrol_Pretuned_CO"));
					epcp.setHc(rs4.getString("Petrol_Pretuned_HC"));
					epcp.setCo2(rs4.getString("Petrol_Pretuned_CO2"));
					epcp.setO2(rs4.getString("Petrol_Pretuned_O2"));
					epcp.setNox(rs4.getString("Petrol_Pretuned_NOX"));
					epcp.setLembda(rs4.getString("Petrol_Pretuned_LEMBDA"));
					epcp.setRpm(rs4.getString("Petrol_Pretuned_RPM"));
				}
				
			}

		} catch (Exception e) {
			System.out.println(e);

		}finally{
			if(rs!=null){
				rs.close();
				//rs2.close();
			}if (ps!=null){
				ps.close();
				//ps2.close();
			}if(con!=null){
				con.close();
			} 

		}
		return  new EmissionPetrolResultBean(epcd,epcg,epcl,epcp);
		
	}
}
