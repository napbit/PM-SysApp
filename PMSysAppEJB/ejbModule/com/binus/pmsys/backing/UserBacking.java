package com.binus.pmsys.backing;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.binus.pmsys.eao.LoginEao;
import com.binus.pmsys.entity.Staff;
import com.binus.pmsys.utils.SessionManager;

@Named
@SessionScoped
public class UserBacking extends BasicBacking {
	private static final long serialVersionUID = 5699209095221506153L;
	
	@EJB
	private transient LoginEao eao;
	
	private Staff user;
	
	private int totalStaff;
	private int totalPatient;
	private int totalMedicine;
	
	public UserBacking() { }
	
	public void init(/*Staff s*/) {
		//this.user = new Staff(s);
		totalStaff = eao.getTotalStaff();	
		totalPatient = eao.getTotalPatients();
		totalMedicine = eao.getTotalMedicines();
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

	public int getTotalStaff() {
		return totalStaff;
	}

	public void setTotalStaff(int totalStaff) {
		this.totalStaff = totalStaff;
	}

	public int getTotalPatient() {
		return totalPatient;
	}

	public void setTotalPatient(int totalPatient) {
		this.totalPatient = totalPatient;
	}

	public int getTotalMedicine() {
		return totalMedicine;
	}

	public void setTotalMedicine(int totalMedicine) {
		this.totalMedicine = totalMedicine;
	}
}
