package com.binus.pmsys.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;

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
	
	public static String formatDateToString(Date date, String datePattern) {
		if(date != null) {
			DateFormat df = new SimpleDateFormat(datePattern);
			return df.format(date);
		} else
			return null;
	}
	
	public static Date formatStringToDate(String date, String datePattern) {
		if(date != null) {
			DateFormat df = new SimpleDateFormat(datePattern);
			Date d = new Date();
			
			try {
				d = df.parse(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return d;
		} else
			return null;
	}
	
	public static int extractDateMonthAsInt(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate.getMonthValue();
	}
	
	public static String extractDateMonthAsString(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}
	
	public static int extractDateYearAsInt(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate.getYear();
	}
	
	public static int extractDateDayAsInt(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate.getDayOfMonth();
	}
	
	public static String getMonthNamefromInt(int month, Locale locale) {
		if(month < 12 || month > 0) {
			return Month.of(month).getDisplayName(TextStyle.FULL, locale);
		}
		else
			return null;
	}
	
	public static int getMonthfromString(String month) {
		DateTimeFormatter parse = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH);
		TemporalAccessor access = parse.parse(month);
		return access.get(ChronoField.MONTH_OF_YEAR);
	}
	
	public static String getDayOfWeekfromDate(Date date, Locale locale) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		DayOfWeek day = localDate.getDayOfWeek();
		return day.getDisplayName(TextStyle.FULL, locale);
	}
	
	public static int findLengthDaysinMonthYear(int year, int month) {
		YearMonth ym = YearMonth.of(year, month);
		return ym.lengthOfMonth();
	}
}
