package com.binus.pmsys.backing;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.binus.pmsys.entity.Patient;
import com.binus.pmsys.utils.DateHelper;

@Named
@SessionScoped
public class RegistrationBacking extends BasicBacking {
	private static final long serialVersionUID = 8664948727348463034L;
	
	private Patient patient;
	
	private int year;
	private String month;
	private int day;
	
	private int[] years;
	private List<String> months = new ArrayList<String>();
	private int[] days;
	
	
	public RegistrationBacking() { }
	
	@PostConstruct
	public void init() {
		patient = new Patient();
		generateYearMonthDay();
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
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

	private void generateYearMonthDay() {
		LocalDate now = LocalDate.now();
		
		DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
		months.addAll(Arrays.asList(dfs.getMonths()));
		months.remove("");
		
		years = IntStream.rangeClosed(1900,  LocalDate.now().getYear()).toArray();
		days = IntStream.rangeClosed(1, 31).toArray();
		
		day = now.getDayOfMonth();
		year = now.getYear();
		month = DateHelper.getMonthNamefromInt(now.getMonthValue(), Locale.ENGLISH);
	}
	
	public String berikutnya() {
		//TODO: validate date
		return "review.xhtml?faces-redirect=true";
	}
}
