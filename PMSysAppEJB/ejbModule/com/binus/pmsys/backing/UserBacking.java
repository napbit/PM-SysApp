package com.binus.pmsys.backing;

import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.binus.pmsys.entity.Staff;
import com.binus.pmsys.utils.SessionManager;

@Named
@SessionScoped
public class UserBacking extends BasicBacking {
	private static final long serialVersionUID = 5699209095221506153L;
	
	private Staff user;
	
	public UserBacking() { }
	
	public void init(Staff s) {
		this.user = new Staff(s);
	}
	
	@PreDestroy
	public void deinit() {
		SessionManager.removeSession(user.getStaffID());
	}

	public Staff getUser() {
		return user;
	}

	public void setUser(Staff user) {
		this.user = user;
	}
}
