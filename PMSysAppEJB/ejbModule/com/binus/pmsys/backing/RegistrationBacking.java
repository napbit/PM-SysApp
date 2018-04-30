package com.binus.pmsys.backing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
	
	private List<Integer> yearList = new ArrayList<Integer>();
	private List<Integer> monthList = new ArrayList<Integer>();
	private List<Integer> dayList = new ArrayList<Integer>();
	
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

	public List<Integer> getYearList() {
		return yearList;
	}

	public void setYearList(List<Integer> yearList) {
		this.yearList = yearList;
	}

	public List<Integer> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<Integer> monthList) {
		this.monthList = monthList;
	}

	public List<Integer> getDayList() {
		return dayList;
	}

	public void setDayList(List<Integer> dayList) {
		this.dayList = dayList;
	}

	private void generateLists() {
		yearList = IntStream.rangeClosed(1900, 2018).boxed().collect(Collectors.toList());
		monthList = IntStream.rangeClosed(1, 12).boxed().collect(Collectors.toList());
	}
	
	public void monthYearDayListener() {
		if(month > 0) {
			dayList.removeAll(dayList);
			int len = DateHelper.findLengthDaysinMonthYear(year, month);
			dayList = IntStream.rangeClosed(1, len).boxed().collect(Collectors.toList());
		}
	}
	
	private void makeDate() {
		LocalDate dob = LocalDate.of(year, month, day);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		patient.setBirthDate(dob.format(formatter));
	}
	
	public String berikutnya() {
		makeDate();
		return "review.xhtml?faces-redirect=true";
	}
}
