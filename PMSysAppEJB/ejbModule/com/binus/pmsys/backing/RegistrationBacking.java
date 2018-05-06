package com.binus.pmsys.backing;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
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
	private int month;
	private int day;
	
	private int[] years;
	private List<String> months = new ArrayList<String>();
	private int[] days;
	
	
	public RegistrationBacking() { }
	
	@PostConstruct
	public void init() {
		patient = new Patient();
		generateLists();
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

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
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

	private void generateLists() {
		DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
		months.addAll(Arrays.asList(dfs.getMonths()));
		months.remove("");
		years = IntStream.rangeClosed(1900,  2018).toArray();
		days = IntStream.rangeClosed(1, 31).toArray();
	}
	
	private void makeDate() { 
		LocalDate dob = LocalDate.of(year, month, day);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		patient.setBirthDate(dob.format(formatter));
	}
	
	public String berikutnya() {
		makeDate(); //TODO: test/fix this
		//TODO: verify date
		return "insurance.xhtml?faces-redirect=true";
	}
	
	public String berikutnyaInsurance() {
		return "review.xhtml?faces-redirect=true";
	}
}
