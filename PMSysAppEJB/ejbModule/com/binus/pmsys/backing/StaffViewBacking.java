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
	private Staff newStaff;
	
	private int filterMode;
	
	private int year;
	private String month;
	private int day;
	
	private int[] years;
	private List<String> months = new ArrayList<String>();
	private int[] days;
	
	public StaffViewBacking() {

	}
	
	@PostConstruct
	public void init() {
		refreshStaffList();
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
	
	public Staff getNewStaff() {
		return newStaff;
	}

	public void setNewStaff(Staff newStaff) {
		this.newStaff = newStaff;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int[] getYears() {
		return years;
	}

	public void setYears(int[] years) {
		this.years = years;
	}

	public List<String> getMonths() {
		return months;
	}

	public void setMonths(List<String> months) {
		this.months = months;
	}

	public int[] getDays() {
		return days;
	}

	public void setDays(int[] days) {
		this.days = days;
	}

	public String getStaffDetail(Staff staff) {
		this.staff = new Staff(staff);
		return "view.xhtml?faces-redirect=true";
	}
	
	public String onClickEdit() {
		this.newStaff = new Staff(this.staff);
		return "edit.xhtml?faces-redirect=true";
	}
	
	public void refreshStaffList() {
		this.staffList = eao.getAllStaff();
	}
}
