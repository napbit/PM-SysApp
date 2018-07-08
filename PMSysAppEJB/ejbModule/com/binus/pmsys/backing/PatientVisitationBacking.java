package com.binus.pmsys.backing;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.binus.pmsys.entity.NewPatient;

@Named
@SessionScoped
public class PatientVisitationBacking extends BasicBacking {
	private static final long serialVersionUID = -4492741824548396665L;

	private NewPatient patient;
	private List<NewPatient> patients;
	
	private String searchTerm;
	private int filterMode;
	private boolean patientDialog;
	
	private int day;
	private String month;
	private int year;
	
	private int[] days, years;
	private List<String> months;
	
	public PatientVisitationBacking() {	}

	public NewPatient getPatient() {
		return patient;
	}

	public void setPatient(NewPatient patient) {
		this.patient = patient;
	}

	public List<NewPatient> getPatients() {
		return patients;
	}

	public void setPatients(List<NewPatient> patients) {
		this.patients = patients;
	}

	public boolean isPatientDialog() {
		return patientDialog;
	}

	public void setPatientDialog(boolean patientDialog) {
		this.patientDialog = patientDialog;
	}

	public int getFilterMode() {
		return filterMode;
	}

	public void setFilterMode(int filterMode) {
		this.filterMode = filterMode;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int[] getDays() {
		return days;
	}

	public void setDays(int[] days) {
		this.days = days;
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

	public void clearSearchTerm() {
		this.searchTerm = "";
	}
	
}
