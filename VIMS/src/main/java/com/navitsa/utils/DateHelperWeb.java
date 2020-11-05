package com.navitsa.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DateHelperWeb {

	 private static int calendarMonthToInt(int calendarMonth) {
	        if (calendarMonth == Calendar.JANUARY) {
	            return 1;
	        } else if (calendarMonth == Calendar.FEBRUARY) {
	            return 2;
	        } else if (calendarMonth == Calendar.MARCH) {
	            return 3;
	        } else if (calendarMonth == Calendar.APRIL) {
	            return 4;
	        } else if (calendarMonth == Calendar.MAY) {
	            return 5;
	        } else if (calendarMonth == Calendar.JUNE) {
	            return 6;
	        } else if (calendarMonth == Calendar.JULY) {
	            return 7;
	        } else if (calendarMonth == Calendar.AUGUST) {
	            return 8;
	        } else if (calendarMonth == Calendar.SEPTEMBER) {
	            return 9;
	        } else if (calendarMonth == Calendar.OCTOBER) {
	            return 10;
	        } else if (calendarMonth == Calendar.NOVEMBER) {
	            return 11;
	        } else if (calendarMonth == Calendar.DECEMBER) {
	            return 12;
	        } else {
	            return 1;
	        }
	    }
    public static int getYear(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);

        return cal.get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);

        int calendarMonth = cal.get(Calendar.MONTH);

        return calendarMonthToInt(calendarMonth);
    }

    public static int getDay(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);

        return cal.get(Calendar.DAY_OF_MONTH);
    }
    public static Date addMonths(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.set(getYear(date), getMonth(date) - 1, getDay(date));
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }
    public static Date getDate(String strDate) {
        Date date = null;
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = (Date) formatter.parse(strDate);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date;
    }
    public static String getFormatStringDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(date);
    }
    
    public static int dateFiff(Calendar date1, Calendar date2){
        if (date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)) {
          return Math.abs(date1.get(Calendar.DAY_OF_YEAR) - date2.get(Calendar.DAY_OF_YEAR));
        } else {
          if (date2.get(Calendar.YEAR) > date1.get(Calendar.YEAR)) {
          Calendar temp = date1;
          date1 = date2;
          date2 = temp;
        }
        int resultDays = 0;
        int dayOneOriginalYearDays = date1.get(Calendar.DAY_OF_YEAR);
        while (date1.get(Calendar.YEAR) > date2.get(Calendar.YEAR)) {
          date1.add(Calendar.YEAR, -1);
          resultDays += date1.getActualMaximum(Calendar.DAY_OF_YEAR);
        }
          return resultDays - date2.get(Calendar.DAY_OF_YEAR) + dayOneOriginalYearDays ;
        }
      }
    
    public static int stringDateDiff(String inputString1,String inputString2) {
    	
		  SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
//		    String inputString1 = "10 03 1995";
//		    String inputString2 = "14 03 1995";
		    try{
		      Date oldDate = myFormat.parse(inputString1);
		      Date newDate = myFormat.parse(inputString2);
		      int diffInDays = (int)( (newDate.getTime() - oldDate.getTime())
		                 / (1000 * 60 * 60 * 24) );
		      return diffInDays;
		    }catch(Exception ex){
		       System.out.println(ex);
		      return 0; 
		    }
    }
    
    
    
    
    
    
    
    
    
    
}
