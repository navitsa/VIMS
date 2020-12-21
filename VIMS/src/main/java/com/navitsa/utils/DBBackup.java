package com.navitsa.utils;

import java.io.IOException;
import java.util.Date;

public  class DBBackup {


	public static String startDBBackup() {
	
		//String executeCmd = "mysqldump -h localhost -P 3307 -u root -pneV071it vinoddb>E:/CTB2/pqr0258.sql"; 
		
		Process p = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            p = runtime.exec("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump -uroot -pneV071it -P 3307 --add-drop-database -B vinoddb -r E:/CTB2/pqr0258.sql");
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
