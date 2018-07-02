package com.binus.pmsys.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PatientEnum {
	
	public static final int YES_BPJS = 1;
	public static final int NO_BPJS = 0;
	
	public static final int BPJS_CLASS_A = 1;
	public static final int BPJS_CLASS_B = 2;
	public static final int BPJS_CLASS_C = 3;
	
	public static final int HANDPHONE = 1;
	public static final int HOMEPHONE = 2;
	
	private static final Map<String, Integer> bpjsClassMap = new ConcurrentHashMap<String, Integer>();
	private static final Map<Integer, String> revBPJSClassMap = new ConcurrentHashMap<Integer, String>();
	
	private static final Map<String, Integer> phoneTypeMap = new ConcurrentHashMap<String, Integer>();
	
	static {
		bpjsClassMap.put("Class A", BPJS_CLASS_A);
		bpjsClassMap.put("Class B", BPJS_CLASS_B);
		bpjsClassMap.put("Class C", BPJS_CLASS_C);
		
		revBPJSClassMap.put(BPJS_CLASS_A, "Class A");
		revBPJSClassMap.put(BPJS_CLASS_B, "Class B");
		revBPJSClassMap.put(BPJS_CLASS_C, "Class C");
		
		phoneTypeMap.put("HandPhone", HANDPHONE);
		phoneTypeMap.put("HomePhone", HOMEPHONE);
	}
	
	public static int getBPJSClassByString(String key) {
		return bpjsClassMap.get(key);
	}
	
	public static String getBPJSClassByInt(int key) {
		return revBPJSClassMap.get(key);
	}
	
	public static int getPhoneTypeByString(String key) {
		return phoneTypeMap.get(key);
	}
	
}
