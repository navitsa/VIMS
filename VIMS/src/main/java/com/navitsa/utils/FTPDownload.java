package com.navitsa.utils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

import org.apache.commons.net.ftp.FTPClient;


public class FTPDownload {



	public static void ftpDownload(String fname, String download_path,String server,String user , String pass) throws SQLException {

		

	        int port = 21;

	        
	        
	        // Create an instance of FTPClient 
	        FTPClient ftp = new FTPClient();
	        FileOutputStream fos = null;
	        try { 
	            // Establish a connection with the FTP URL 
	            ftp.connect(server,port); 
	            // Enter user details : user name and password 
	            boolean isSuccess = ftp.login(user, pass); 	  
	            if (isSuccess) { 
	                    // Create an OutputStream for the file
	                    String filename = download_path;
	                    fos = new FileOutputStream(filename);	                    
	                 // Fetch file from server 
	                    ftp.retrieveFile("/location/"+fname+".txt", fos);    
	            } 
	  
	            ftp.logout(); 
	        } 
	        catch (IOException e) { 
	            e.printStackTrace(); 
	        } 
	        finally { 
	            try {
	                if (fos != null) {fos.close();}
	            	
	                ftp.disconnect(); 
	            } 
	            catch (IOException e) { 
	                e.printStackTrace(); 
	            } 
	        } 
			
	
	}
}
