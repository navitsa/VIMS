package com.navitsa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		con = DriverManager.getConnection("jdbc:mysql://149.56.134.121:3306/nuwanData?serverTimezone=UTC","nuwan","nuwan@123");
		return con;

	}

	//to view the data from the database      
	public  void view() throws SQLException
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con=this.getConnection();
			ps=con.prepareStatement("select * from appointment");
			//ps.setString(1, name);
			rs=ps.executeQuery();
			while (rs.next()) {
				System.out.println("date= "+rs.getString(3)+"\t"+"time= "+rs.getString(4));    

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
