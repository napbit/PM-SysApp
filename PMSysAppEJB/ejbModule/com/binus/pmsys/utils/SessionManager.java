package com.binus.pmsys.utils;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionManager {

	private static Map<Integer, String> userSessionList = new HashMap<Integer, String>();
	
	public SessionManager() { }
	
	public static void recordSession(FacesContext context, int id) {
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		userSessionList.put(id, session.getId());
	}
	
	public static void removeSession(int id){
		userSessionList.remove(id);
	}
	
	public static Boolean checkSessionIsActive(int id) {
		if(!userSessionList.get(id).isEmpty() || userSessionList.get(id) != null)
			return true;
		else
			return false;
	}
	
	public static int size() {
		return userSessionList.size();	
	}
}
