package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Java_Utility {
    public int getrandomNumber() {
		Random random=new Random();
		int randomint=random.nextInt(5000);
		return randomint;
	}
      public String getSystemDateYYYYDDMM() {                       //get current system date
	 Date dateobj=new Date();
	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	 String date=sdf.format(dateobj);
	 return date;
 }
      public String getRequiredDateYYYDDMM(int days) {                //get after some day date
    	  Date dateobj=new Date();
    	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	  String date=sdf.format(dateobj);
    	  Calendar cal=sdf.getCalendar();
    	  cal.add(Calendar.DAY_OF_MONTH, days);
    	  String reqDate=sdf.format(cal.getTime());
    	  return reqDate;
    	  
      }
}
