package com.navitsa.utils;

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
    
    
}
