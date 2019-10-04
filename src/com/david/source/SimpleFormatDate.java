package com.david.source;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;

public class SimpleFormatDate
{
  public static void main(String args[]){
  Date todaysDate = new java.util.Date();
  // Formatting date into  yyyy-MM-dd HH:mm:ss e.g 2008-10-10 11:21:10
 
  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  String formattedDate = formatter.format(todaysDate);
  System.out.println("Formatted date is ==>"+formattedDate);

  // Formatting date into  yyyy-MM-dd e.g 2008-10-10 
  formatter = new SimpleDateFormat("yyyy-MM-dd");
  formattedDate = formatter.format(todaysDate);
  System.out.println("Formatted date is ==>"+formattedDate);

  // Formatting date into  MM/dd/yyyy e.g 10/10/2008 
  formatter = new SimpleDateFormat("MM/dd/yyyy");
  formattedDate = formatter.format(todaysDate);
  System.out.println("Formatted date is ==>"+formattedDate);
  
  formatter = new SimpleDateFormat("MMM");
  formattedDate = formatter.format(todaysDate);
  System.out.println("Formatted date is ==>"+formattedDate);
  
  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  Calendar cal = Calendar.getInstance();
  System.out.println(dateFormat.format(cal.getTime()));
  
  String dayNames[] = new DateFormatSymbols().getWeekdays();
  Calendar date2 = Calendar.getInstance();
  System.out.println("Today is a " 
    + dayNames[date2.get(Calendar.DAY_OF_WEEK)]);
  
  
  
  
  }
}

