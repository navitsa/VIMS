package com.navitsa.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.HashMap;
import java.util.Map;

import com.ibm.icu.math.BigDecimal;

public class StringFormaterWeb {
   
    public static String padLeft(String strToPad, int len, String strFiller) {
        int fillLen = len - strToPad.length();
        if (fillLen <= 0) {
            return strToPad;
        } else {
            StringBuffer temp = new StringBuffer();
            for (int i = 0; i < fillLen; i++) {
                temp.append(strFiller);
            }
            return temp.append(strToPad).toString();
        }
    }
	public static String padRight(String strToPad, int len, String strFiller) {
        int fillLen = len - strToPad.length();
        if (fillLen <= 0) {
            return strToPad;
        } else {
            StringBuffer temp = new StringBuffer(strToPad);
            for (int i = 0; i < fillLen; i++) {
                temp.append(strFiller);
            }
            return temp.toString();
        }
    }
    public static long rupeesToLong(String strAmount) {
        BigDecimal bigDecimal = (new BigDecimal(strAmount)).multiply(new BigDecimal(100));
        return bigDecimal.longValue();
    }	
	
    public static String formatToRupees(long amount) {
        long intgerPart = amount / 100;
        long fractionPart = amount % 100;
        return Long.toString(intgerPart) + "." + padRight(padLeft(Long.toString(Math.abs(fractionPart)), 2, "0"), 2, "0");
    }
	
    public static String capitalizeWord(String str){  
        String words[]=str.split("\\s");  
        String capitalizeWord="";  
        for(String w:words){  
            String first=w.substring(0,1);  
            String afterfirst=w.substring(1);  
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
        }  
        return capitalizeWord.trim();  
    }
    
    public static String setLineAndSpace(int x,int y) {
    	String line="";
    	String space="";
    	for(int i=0;i<y;i++) {
    		line=line+"\n";	
    	}
    	for(int z=0;z<x;z++) {
    		space=space+" ";
    		
    	}
    	return line+space;
    }
    public static String getAddressComputer() throws IOException {
		String command = "wmic csproduct get UUID";
	    StringBuffer output = new StringBuffer();

	    Process SerNumProcess;
		
			SerNumProcess = Runtime.getRuntime().exec(command);
	
	    BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));

	    String line = "";
	    while ((line = sNumReader.readLine()) != null) {
	        output.append(line + "\n");
	        
	    }
	    String MachineID=output.toString().substring(output.indexOf("\n"), output.length()).trim();
	   return MachineID;
    }
    
    public static Boolean getAddressComputer(String date,String code) {
	

		Map<String,String> y=new HashMap<String, String>();
		y.put("A", "00");
		y.put("B", "56");
		y.put("C", "89");
		y.put("D", "45");
		y.put("E", "26");
		y.put("F", "78");
		y.put("G", "61");
		y.put("H", "67");
		y.put("I", "12");
		y.put("J", "69");
		y.put("K", "11");
		y.put("L", "98");
		y.put("M", "36");
		y.put("N", "27");
		y.put("O", "34");
		y.put("P", "26");
		y.put("Q", "40");
		y.put("R", "74");
		y.put("S", "82");
		y.put("T", "44");
		y.put("U", "85");
		y.put("V", "79");
		y.put("W", "34");
		y.put("y", "73");
		y.put("Y", "23");
		y.put("Z", "62");	
		
		y.put("1", "1");
		y.put("2", "2");
		y.put("3", "3");
		y.put("4", "4");
		y.put("5", "5");
		y.put("6", "6");
		y.put("7", "7");
		y.put("8", "8");
		y.put("9", "9");
		y.put("0", "0");
				
		Map<String,String> x=new HashMap<String, String>();
		x.put("A", "0G6");
		x.put("B", "0UY");
		x.put("C", "8T&");
		x.put("D", "W@U");
		x.put("E", "A34");
		x.put("F", "QW5");
		x.put("G", "78U");
		x.put("H", "5WQ");
		x.put("I", "FFY");
		x.put("J", "MYT");
		x.put("K", "$EW");
		x.put("L", "GGT");
		x.put("M", "UGB");
		x.put("N", "67W");
		x.put("O", "JKP");
		x.put("P", "NEV");
		x.put("Q", "T4W");
		x.put("R", "CHQ");
		x.put("S", "POL");
		x.put("T", "REM");
		x.put("U", "L@V");
		x.put("V", "HO1");
		x.put("W", "CO2");
		x.put("X", "HCO");
		x.put("Y", "C?G");
		x.put("Z", "Q$L");	
		
		x.put("1", "JQ");
		x.put("2", "UG");
		x.put("3", "RX");
		x.put("4", "ST");
		x.put("5", "OP");
		x.put("6", "D3");
		x.put("7", "GV");
		x.put("8", "FL");
		x.put("9", "QN");
		x.put("0", "ZR");
		
	//	InetAddress localHost;
		try {
//			localHost = InetAddress.getLocalHost();
//	
//		NetworkInterface ni = NetworkInterface.getByInetAddress(localHost);
//		byte[] hardwareAddress = ni.getHardwareAddress();
//		
//		
//		String[] hexadecimal = new String[hardwareAddress.length];
//		
//		
//		Long h=Long.parseLong("0");
			
			String command = "wmic csproduct get UUID";
		    StringBuffer output = new StringBuffer();

		    Process SerNumProcess;
			
				SerNumProcess = Runtime.getRuntime().exec(command);
		
		    BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));

		    String line = "";
		    while ((line = sNumReader.readLine()) != null) {
		        output.append(line + "\n");
		        
		    }
		    String MachineID=output.toString().substring(output.indexOf("\n"), output.length()).trim().replace("-", "");;
		   

		
			
			
			
			
			
			
			
			
			
		    String[] hexadecimal=new  String[16];	
			
		    Long h=Long.parseLong("0");
		    int c=0;
		for (int i = 0; i < MachineID.length(); i=i+2) {
		
		  //  System.out.println(MachineID.substring(i,i+1)+""+MachineID.substring(i+1,i+2));
		    h=Long.parseLong(y.get(MachineID.substring(i,i+1)))+Long.parseLong(y.get(MachineID.substring(i+1,i+2)));
		    if(h.toString().length()>2) {
				 
				h=Long.parseLong(h.toString().substring(0,1))+Long.parseLong(h.toString().substring(1));
				
			}
		    if(h.toString().length()>2) {
				 
						h=Long.parseLong(h.toString().substring(0,1))+Long.parseLong(h.toString().substring(1));
						
					}
			hexadecimal[c]=String.format("%02d", h);
			c++;
		}
	//	String date1="20-20-12-31-20-21-05-02";
		
//		String date=date1.replace("-", "");
//		
//		Long datesum=Long.parseLong("0");
//		datesum=Long.parseLong(date.substring(0,2))+Long.parseLong(date.substring(1,2))+Long.parseLong(date.substring(3,4))+Long.parseLong(date.substring(5,6))+Long.parseLong(date.substring(7,8))+Long.parseLong(date.substring(9,10))+Long.parseLong(date.substring(11,12))+Long.parseLong(date.substring(13,14));
//	
//		System.out.println(datesum);
//		//	System.out.println(date.substring(0,2)+" "+date.substring(2,4));
//		if(datesum.toString().length()>2) {
//			 
//			datesum=Long.parseLong(datesum.toString().substring(0,1))+Long.parseLong(datesum.toString().substring(1));
//			
//		}
		
		
		
		String macAddress =date+"-"+String.join("-", hexadecimal);
		
		//System.out.println(macAddress);
		
		String[] getd=macAddress.split("-");
		
		String[] resu1=new String[4];
		for(int i=0;i<4;i++) {
		Long f=Long.parseLong("0");
		f=Long.parseLong(getd[i])+Long.parseLong(getd[i+4])+Long.parseLong(getd[i+8])+Long.parseLong(getd[i+12])+Long.parseLong(getd[i+16])+Long.parseLong(getd[i+20]);
		if(f.toString().length()>2) {
			 
			f=Long.parseLong(f.toString().substring(0,1))+Long.parseLong(f.toString().substring(1));
			
		}
		if(f.toString().length()>2) {
			 
			f=Long.parseLong(f.toString().substring(0,1))+Long.parseLong(f.toString().substring(1));
			
		}
		resu1[i]=x.get(String.format("%02d", f).substring(0, 1))+x.get(String.format("%02d", f).substring(1));
//		
//		
		}
	//System.out.println();String date,String 
			if(String.join("-", resu1).equals(code)) {
				return true;
			}else {
				return false;
			}
	
	
	
	//String.join("-", resu1);
	
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
    	
    }
    
}
