package com.binus.pmsys.backing;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.binus.pmsys.eao.PatientViewEao;
import com.binus.pmsys.entity.NewPatient;
import com.binus.pmsys.enums.PatientEnum;
import com.binus.pmsys.utils.DateHelper;

@Named
@SessionScoped
public class PatientViewBacking implements Serializable {
	private static final long serialVersionUID = -513189841959490721L;
	
	@EJB
	private PatientViewEao eao;
	
	private String search;
	private int filterMode;
	
	private NewPatient patient;
	private List<NewPatient> patients;
	
	private int year;
	private String month;
	private int day;
	
	private int[] years;
	private List<String> months, contactRelation;
	private int[] days;
	
	public PatientViewBacking() { }
	
	@PostConstruct
	public void init() {
		patients = new ArrayList<NewPatient>();
		this.patients = eao.getPatients();
	}
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getFilterMode() {
		return filterMode;
	}

	public void setFilterMode(int filterMode) {
		this.filterMode = filterMode;
	}
	
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
	
	public PatientViewEao getEao() {
		return eao;
	}

	public void setEao(PatientViewEao eao) {
		this.eao = eao;
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

	public List<String> getContactRelation() {
		return contactRelation;
	}

	public void setContactRelation(List<String> contactRelation) {
		this.contactRelation = contactRelation;
	}
	
	public String onClickView(NewPatient patientData) {
		patient = new NewPatient(patientData); 
		return "view.xhtml?faces-redirect=true";
	}
	
	public String onClickEdit() {
		generateYearMonthDay();
		generateRelationList();
		if(patient.getPhoneTypeID() == PatientEnum.HOMEPHONE && patient.getPhoneNumber().contains(" ")) {
			splitPatientPhoneNumber();
			System.out.println("split");
		}
		return "edit.xhtml?faces-redirect=true";
	}
	
	private void splitPatientPhoneNumber() {
		String[] splitted = patient.getPhoneNumber().split(" ");
		patient.setFrontExtNum(splitted[0]);
		patient.setPhoneNumber(splitted[1]);
	}
	
	private void generateYearMonthDay() {
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
	}
	
	private void generateRelationList() {
		contactRelation = new ArrayList<String>();
		contactRelation.add("Ayah");
		contactRelation.add("Ibu");
		contactRelation.add("Kakak");
		contactRelation.add("Adik");
		contactRelation.add("Kakek");
		contactRelation.add("Nenek");
		contactRelation.add("Paman");
		contactRelation.add("Bibi");
		contactRelation.add("Cucu");
		contactRelation.add("Suami");
		contactRelation.add("Istri");
		contactRelation.add("Saudara");
		contactRelation.add("Anak");
		contactRelation.add("Teman");
	}
	
	public void onClickSearch() {
		patients = eao.getPatientSearch(filterMode, search);
	}

}
