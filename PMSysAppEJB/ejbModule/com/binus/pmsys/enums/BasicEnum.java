package com.binus.pmsys.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BasicEnum {
	
	public final static int FILTER_NO_RM = 1;
	public final static int FILTER_NAME = 2;
	public final static int FILTER_GENDER = 3;
	public final static int FILTER_DOB = 4;
	
	public final static String MONDAY = "Senin";
	public final static String TUESDAY = "Selasa";
	public final static String WEDNESDAY = "Rabu";
	public final static String THURSDAY = "Kamis";
	public final static String FRIDAY = "Jumat";
	public final static String SATURDAY = "Sabtu";
	public final static String SUNDAY = "Minggu";
	
	private static final Map<String, String> dayMap = new ConcurrentHashMap<String, String>();
	
	static {
		dayMap.put("Monday", MONDAY);
		dayMap.put("Tuesday", TUESDAY);
		dayMap.put("Wednesday", WEDNESDAY);
		dayMap.put("Thursday", THURSDAY);
		dayMap.put("Friday", FRIDAY);
		dayMap.put("Saturday", SATURDAY);
		dayMap.put("Sunday", SUNDAY);
	}
	
	public static String getIndoDay(String key) {
		return dayMap.get(key);
	}
}
