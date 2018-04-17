package com.core;

import java.util.TimeZone;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;


public class Test {
	public static void main(String[] args) {
		
		/*
		LocalTime localTime = LocalTime.now(ZoneId.of("GMT-4"));
		System.out.println(localTime);
		*/
		
		TimeZone.setDefault(TimeZone.getTimeZone("EST"));
	       
	       
	       // Now my default time zone is in EST
	       System.out.println(TimeZone.getDefault());
	       // I get Eastern Time printed
	       System.out.println(new Date());

		
	}

}
