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

}
