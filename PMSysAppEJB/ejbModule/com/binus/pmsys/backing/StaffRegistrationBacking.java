package com.binus.pmsys.backing;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import com.binus.pmsys.eao.RegionEao;
import com.binus.pmsys.eao.StaffViewEao;
import com.binus.pmsys.entity.Kabupaten;
import com.binus.pmsys.entity.Position;
import com.binus.pmsys.entity.Province;
import com.binus.pmsys.entity.Staff;
import com.binus.pmsys.utils.DateHelper;

@Named
@SessionScoped
public class StaffRegistrationBacking extends BasicBacking{
	private static final long serialVersionUID = 4048653124586114465L;
	
	@EJB
	private transient RegionEao regionEao;
	
	@EJB
	private transient StaffViewEao staffEao;
	
	private Staff newStaff;
	
	private String normalDOB;
	private String normalJoin;
	
	private int year;
	private String month;
	private int day;
	
	private int joinYear;
	private String joinMonth;
	private int joinDay;
	
	private int[] years;
	private List<String> months = new ArrayList<String>();
	private int[] days;

	private List<Province> provinces;
	private List<Kabupaten> kabupatens;
	private List<Position> positions;
	
	public StaffRegistrationBacking() {	}
	
	@PostConstruct
	public void init() {
		newStaff = new Staff();
		generateYearMonthDayNow();
		getPositionsList();
		getRegions();
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

	public int getJoinYear() {
		return joinYear;
	}

	public void setJoinYear(int joinYear) {
		this.joinYear = joinYear;
	}

	public String getJoinMonth() {
		return joinMonth;
	}

	public void setJoinMonth(String joinMonth) {
		this.joinMonth = joinMonth;
	}

	public int getJoinDay() {
		return joinDay;
	}

	public void setJoinDay(int joinDay) {
		this.joinDay = joinDay;
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

	public String getNormalDOB() {
		return normalDOB;
	}

	public void setNormalDOB(String normalDOB) {
		this.normalDOB = normalDOB;
	}

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	public List<Kabupaten> getKabupatens() {
		return kabupatens;
	}

	public void setKabupatens(List<Kabupaten> kabupatens) {
		this.kabupatens = kabupatens;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	
	public String getNormalJoin() {
		return normalJoin;
	}

	public void setNormalJoin(String normalJoin) {
		this.normalJoin = normalJoin;
	}

	public String reviewRegistration() {
		validateDOB();
		validateJoinDate();
		return "review.xhtml?faces-redirect=true";
	}
	
	private void getRegions() {
		this.provinces = regionEao.getProvinces();
		this.kabupatens = regionEao.getKabupatens();
	}
	
	private void generateYearMonthDayNow() {
		LocalDate now = LocalDate.now();
		
		DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
		months = new ArrayList<String>();
		months.addAll(Arrays.asList(dfs.getMonths()));
		months.remove("");
		
		years = IntStream.rangeClosed(1900,  LocalDate.now().getYear()).toArray();
		days = IntStream.rangeClosed(1, 31).toArray();
		
		day = now.getDayOfMonth();
		year = now.getYear();
		month = DateHelper.getMonthNamefromInt(now.getMonthValue(), Locale.ENGLISH);
		
		joinDay = now.getDayOfMonth();
		joinYear = now.getYear();
		joinMonth = DateHelper.getMonthNamefromInt(now.getMonthValue(), Locale.ENGLISH);
	}
	
	private void getPositionsList() {
		this.positions = staffEao.getPositions();
	}
	
	private void validateDOB() {
		normalDOB = day + "-" + month + "-" + year;
		String dobString = year + "-" + DateHelper.getMonthfromString(month) + "-" + day;
		Date dobDate = DateHelper.formatStringToDate(dobString, "yyyy-MM-dd");

		if (day > DateHelper.findLengthDaysinMonthYear(year, DateHelper.getMonthfromString(month))) {
			messageHandler("Tidak ada hari " + day + "di " + month + " " + year + " untuk tanggal lahir.", FacesMessage.SEVERITY_ERROR);
		} else {
			newStaff.setStaffDOB(DateHelper.formatDateToString(dobDate, "yyyy-MM-dd"));
		}
	}
	
	private void validateJoinDate() {
		normalJoin = joinDay + "-" + joinMonth + "-" + joinYear;
		String dobString = joinYear + "-" + DateHelper.getMonthfromString(joinMonth) + "-" + joinDay;
		Date dobDate = DateHelper.formatStringToDate(dobString, "yyyy-MM-dd");

		if (joinDay > DateHelper.findLengthDaysinMonthYear(joinYear, DateHelper.getMonthfromString(joinMonth))) {
			messageHandler("Tidak ada hari " + joinDay + "di " + joinMonth + " " + joinYear + " untuk tanggal masuk.", FacesMessage.SEVERITY_ERROR);
		} else {
			newStaff.setJoinDate(DateHelper.formatDateToString(dobDate, "yyyy-MM-dd"));
		}
	}
}
