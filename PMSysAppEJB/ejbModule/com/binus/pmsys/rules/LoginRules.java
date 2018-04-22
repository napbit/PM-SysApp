package com.binus.pmsys.rules;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.binus.pmsys.entity.Staff;

/**
 * Session Bean implementation class LoginRules
 */
@Stateless
@LocalBean
public class LoginRules {
	
	//TODO: EAO
	
    public LoginRules() { }
    
    public Staff Login(String username, char[] password) {
    	Staff s = null;
    	
    	try {
			/*s = eao.Login(username, password, 2);*/
			/*s.setErrorMessage(ErrorCode.getErrorCode(res.getErrorCode()));*/
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return s;
    }
    
    public String getUserSalt(String username) {
    	String salt = null;
    	
    	try {
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return salt;
    }
}
