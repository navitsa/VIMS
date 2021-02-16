package com.navitsa.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class DBBackup {


	public static String startDBBackup(String dbBackPath) {
	
		String mysqlpath="C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\";
		String userName="root";
		String password="peLa071it";
		String port="3306";
		String dbname="vetest";
		
		
		Process p = null;
        try {
        	
    		Date backupDate = new Date();
    		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    		String backupDateStr = format.format(backupDate);
        	
        	
            Runtime runtime = Runtime.getRuntime();
            p = runtime.exec(mysqlpath+"mysqldump -u"+userName+" -p"+password+" -P "+port+" --add-drop-database -B "+dbname+" -r "+dbBackPath+"DB_BAK_"+backupDateStr+".sql");
//change the dbpass and dbname with your dbpass and dbname
            int processComplete = p.waitFor();

            if (processComplete == 0) {

                System.out.println("Backup created successfully!");
                return "1";
            } else {
              //  lblMessage.setText("Could not create the backup");
            	return "0";
            }


        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
		
	}
	
	
	
}
