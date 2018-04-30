package com.binus.pmsys.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

public class DateHelper {
	
	public static boolean isBeforeDate(Date check, Date against) {
		if(against.equals(null) || against == null)
			return false;
		else {
			LocalDate localCheck = check.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate localAgainst = against.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			if(localCheck.isBefore(localAgainst))
				return true;
			else
				return false;	
		}
	}
	
	public static boolean isAfterDate(Date check, Date against) {
		LocalDate localCheck = check.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate localAgainst = against.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		if(localCheck.isAfter(localAgainst))
			return true;
		else
			return false;
	}
	
	public static String formatDateToString(Date date, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}
	
	public static Date formatStringToDate(String date, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		Date d = new Date();
		
		try {
			d = df.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return d;
	}
	
	public static int findLengthDaysinMonthYear(int year, int month) {
		YearMonth ym = YearMonth.of(year, month);
		return ym.lengthOfMonth();
	}
}
