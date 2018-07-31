package com.binus.pmsys.backing;

import java.io.Serializable;
import java.util.Arrays;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.codec.binary.Hex;

import com.binus.pmsys.entity.Staff;
import com.binus.pmsys.rules.LoginRules;
import com.binus.pmsys.utils.HashHelper;
import com.binus.pmsys.utils.SessionManager;

@Named
@RequestScoped
public class LoginBacking extends BasicBacking implements Serializable {
	private static final long serialVersionUID = 1988449267982435477L;
	
	@EJB
	private LoginRules rules;
	
	@Inject
	private UserBacking userSession;
	
	private String username;
	private String password;
	
	public LoginBacking() { }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private void clearInputs() {
		setUsername(null);
		setPassword(null);
	}
	
	public String loginUser() {
		String redirect = null;
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			Staff user = null;
			
			if(!user.equals(null) || user == null) { //TODO: Verify properly
				userSession.init(user);
				SessionManager.recordSession(context, user.getStaffID());
				redirect = "";
			} else {
				//TODO: MESSAGE
				redirect = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clearInputs();
		}
		
		return redirect;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/menu.xhtml?faces-redirect=true";
	}
}
