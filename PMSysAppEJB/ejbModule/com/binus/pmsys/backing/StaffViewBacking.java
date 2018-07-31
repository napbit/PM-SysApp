package com.binus.pmsys.backing;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.binus.pmsys.eao.StaffViewEao;
import com.binus.pmsys.entity.Staff;

@Named
@SessionScoped
public class StaffViewBacking extends BasicBacking {
	private static final long serialVersionUID = -8775746382303096522L;
	
	@EJB
	private transient StaffViewEao eao;
	
	private List<Staff> staffList = new ArrayList<Staff>();
	private Staff staff;
	
	private int filterMode;
	
	public StaffViewBacking() {

	}
	
	@PostConstruct
	public void init() {
		this.staffList = eao.getAllStaff();
	}
	
	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public int getFilterMode() {
		return filterMode;
	}

	public void setFilterMode(int filterMode) {
		this.filterMode = filterMode;
	}
	
	public String getStaffDetail(Staff staff) {
		this.staff = new Staff(staff);
		return "view.xhtml?faces-redirect=true";
	}
	
}
