package com.navitsa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.navitsa.entity.AppointmentOnline;
import com.navitsa.entity.TestCategory;
import com.navitsa.entity.VehicleClass;

public class JDBCSingleton {
	
	//https://www.javatpoint.com/singleton-design-pattern-in-java#advantage
	// Step 1

	// create a JDBCSingleton class.

	// static member holds only one instance of the JDBCSingleton class.

	private static JDBCSingleton jdbc;

	// JDBCSingleton prevents the instantiation from any other class.
	private JDBCSingleton() {}

	// Now we are providing gloabal point of access.

	public static JDBCSingleton getInstance() {
		if (jdbc == null) {
			jdbc = new JDBCSingleton();
		}
		return jdbc;
	}

	// to get the connection from methods like insert, view etc.
	private static Connection getConnection() throws ClassNotFoundException, SQLException {

		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_appointment?serverTimezone=UTC","root","Lion311");
		return con;

	}

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
	 //to insert the record into the database 
    public int insert(AppointmentOnline a) throws SQLException
    {
        Connection c=null;
        
        PreparedStatement ps=null;
        
        int recordCounter=0;
        
        try {
            
                c=this.getConnection();
                ps=c.prepareStatement("INSERT INTO appointment (appointment_id,customer_name,customer_mobile_no,customer_email,vehicle_no,vehicle_class_id,category_id,appointment_date,appointment_time,status) VALUES (?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, a.getAppointmentID());
                ps.setString(2, a.getCusName());
                ps.setString(3, a.getCusMobileNo() );
                ps.setString(4, a.getCusEmail() );
                ps.setString(5, a.getVehicleNo());
                ps.setString(6, a.getVehicleClassId().getVehicleClassID());
                ps.setString(7, a.getCategoryId().getCategoryId());
                ps.setDate(8, convertUtilToSql(a.getAppointmentDate()));
                ps.setString(9, a.getAppointmentTime());
                ps.setString(10, a.getStatus());
                
                recordCounter=ps.executeUpdate();
                
                
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally{
              
            if (ps!=null){
                ps.close();
            }if(c!=null){
                c.close();
            } 
            
        }
        
       return recordCounter;
    }
	
	
	//to view the data from the database      
	public List<AppointmentOnline> view() throws SQLException
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AppointmentOnline > list = new ArrayList<>();

		try {

			con=this.getConnection();
			ps=con.prepareStatement("SELECT * FROM appointment WHERE date(appointment_date)=curdate() AND time(appointment_time) > curtime() AND status='pending'");
			//SELECT * FROM appointment WHERE date(appointment_date)=curdate() AND time(appointment_time) > curtime() AND status='pending'
			//ps.setString(1, name);
			rs=ps.executeQuery();
			
			while (rs.next()) {			
		        AppointmentOnline ao = new AppointmentOnline();
		        ao.setAppointmentID(rs.getString(2));
				ao.setCusName(rs.getString(3));
				ao.setCusMobileNo(rs.getString(4));
				ao.setCusEmail(rs.getString(5));
				ao.setVehicleNo(rs.getString(6));
				
				VehicleClass vc = new VehicleClass();
				vc.setVehicleClassID(rs.getString(7));
				ao.setVehicleClassId(vc);
				
				
				TestCategory tc = new TestCategory();
				tc.setCategoryId(rs.getString(8));
				ao.setCategoryId(tc);
				
				ao.setAppointmentDate(rs.getDate(9));
				ao.setAppointmentTime(rs.getString(10));
				ao.setStatus(rs.getString(11));
				
				list.add(ao);
			}


		} catch (Exception e) {
			System.out.println(e);

		}finally{
			if(rs!=null){
				rs.close();
			}if (ps!=null){
				ps.close();
			}if(con!=null){
				con.close();
			} 

		}
		return list;
		
	}
	
	
	//to update the data in the database
    public int update(String appointment_id) throws SQLException
    {
            Connection c=null;
            
            PreparedStatement ps=null;
            
            int recordCounter=0;
            
            try {
                
                    c=this.getConnection();
                    ps=c.prepareStatement(" update appointment set fetch_status=? where appointment_id=? ");
                    ps.setString(1, "pulled");
                    ps.setString(2, appointment_id);
                    recordCounter=ps.executeUpdate();
                    
                    
            } catch (Exception e) {
                
                e.printStackTrace();
                
            } finally{
                  
                if (ps!=null){
                    ps.close();
                }if(c!=null){
                    c.close();
                } 
                
            }
            
           return recordCounter;
        }
	
	// to delete the data from the database 
	public int delete() throws SQLException
	{
		Connection c=null;

		PreparedStatement ps=null;

		int recordCounter=0;

		try {

			c=this.getConnection();
			ps=c.prepareStatement(" delete from appointment ");

			recordCounter=ps.executeUpdate();


		} catch (Exception e) {

			e.printStackTrace();

		} finally{

			if (ps!=null){
				ps.close();
			}if(c!=null){
				c.close();
			} 

		}

		return recordCounter;
	}
}
