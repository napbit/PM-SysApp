package com.binus.pmsys.backing;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.binus.pmsys.entity.Patient;

@Named
@ViewScoped
public class RegistrationBacking extends BasicBacking {
	private static final long serialVersionUID = 8664948727348463034L;
	
	private Patient patient;
	
	private int year;
	private int month;
	private int day;
	
	public RegistrationBacking() { }

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

}
