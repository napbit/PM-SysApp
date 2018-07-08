package com.binus.pmsys.backing;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import com.binus.pmsys.eao.PatientViewEao;
import com.binus.pmsys.eao.PatientVisitationEao;
import com.binus.pmsys.entity.Doctor;
import com.binus.pmsys.entity.NewPatient;
import com.binus.pmsys.enums.BasicEnum;
import com.binus.pmsys.utils.DateHelper;

@Named
@SessionScoped
public class PatientVisitationBacking extends BasicBacking {
	private static final long serialVersionUID = -4492741824548396665L;
	
	@EJB
	private transient PatientViewEao patientEao;
	
	@EJB
	private transient PatientVisitationEao eao;
	
	private NewPatient patient;
	private List<NewPatient> patients;
	
	private Doctor doctor;
	private List<Doctor> doctors;
	
	private String searchTerm;
	private int filterMode = BasicEnum.FILTER_NO_RM;
	private boolean patientDialog, patientView, doctorView, welcomeView = true;
	
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

	public boolean isPatientView() {
		return patientView;
	}

	public void setPatientView(boolean patientView) {
		this.patientView = patientView;
	}

	public boolean isDoctorView() {
		return doctorView;
	}

	public void setDoctorView(boolean doctorView) {
		this.doctorView = doctorView;
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

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public boolean isWelcomeView() {
		return welcomeView;
	}

	public void setWelcomeView(boolean welcomeView) {
		this.welcomeView = welcomeView;
	}

	public void clearSearchTerm() {
		this.searchTerm = "";
	}
	
	public void handleDialog() {
		setPatientDialog(false);
	}
	
	public void openPatientDialog() {
		setPatientDialog(true);
		if(months == null) {
			generateYearMonthDayNow();
		}
		
		if(patients == null) {
			getPatientList();
		}
	}
	
	public void onClickSearch() {
		switch (filterMode) {
		case BasicEnum.FILTER_NO_RM:
			break;
		case BasicEnum.FILTER_NAME:
			this.patients = patientEao.getPatientSearchName(this.searchTerm);
			break;
		case BasicEnum.FILTER_GENDER:
			this.patients = patientEao.getPatientSearchGender(this.searchTerm);
			break;
		case BasicEnum.FILTER_DOB:
			validateSearchDate();
			this.patients = patientEao.getPatientSearchDOB(this.searchTerm);
			break;
		default:
			break;
		}
	}
	
	private void validateSearchDate() {
		String dobString = year + "-" + DateHelper.getMonthfromString(month) + "-" + day;
		Date dobDate = DateHelper.formatStringToDate(dobString, "yyyy-MM-dd");
		
		if(day > DateHelper.findLengthDaysinMonthYear(year, DateHelper.getMonthfromString(month))) {
			messageHandler("Tidak ada hari " + day + "di " + month + " " + year, FacesMessage.SEVERITY_ERROR);
		} else {
			this.searchTerm = DateHelper.formatDateToString(dobDate, "yyyy-MM-dd");
		}
	}
	
	public void refreshPatients() {
		this.patients = patientEao.getPatients();
	}
	
	private void getPatientList() {
		patients = new ArrayList<NewPatient>();
		this.patients = patientEao.getPatients();
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
	}
	
	public void handlePatientSelection() {
		handleDialog();
		setPatientView(true);
		initilizeDoctors();
		setDoctorView(true);
	}
	
	private void initilizeDoctors() {
		LocalTime now = LocalTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		String nowTime = dtf.format(now).toString();
		
		String nowDate = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		
		System.out.println(BasicEnum.getIndoDay(nowDate) + " " + nowTime + " " + LocalDate.now().toString());
		
		doctors = eao.getAvailableDoctor(BasicEnum.getIndoDay(nowDate), "08:00:00", "08:00:00");
	}
	
	public void assignPatient() {
		LocalTime now = LocalTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		String nowTime = dtf.format(now).toString();
		
		String nowDate = LocalDate.now().toString();
		
		eao.assignDoctorPatient(this.patient.getPatientID(), this.doctor.getDoctorID(), nowTime, nowDate);
		
		flushEntities();
	}
	
	private void flushEntities() {
		this.patient = null;
		this.doctor = null;
		this.patients = null;
		this.doctors = null;
	}
}
