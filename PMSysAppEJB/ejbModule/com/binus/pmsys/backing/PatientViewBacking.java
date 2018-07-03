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

import com.binus.pmsys.eao.PatientViewEao;
import com.binus.pmsys.entity.MedicalRecord;
import com.binus.pmsys.entity.NewPatient;
import com.binus.pmsys.enums.BasicEnum;
import com.binus.pmsys.enums.PatientEnum;
import com.binus.pmsys.utils.DateHelper;

@Named
@SessionScoped
public class PatientViewBacking extends BasicBacking implements Serializable {
	private static final long serialVersionUID = -513189841959490721L;
	
	@EJB
	private PatientViewEao eao;
	
	private String search;
	private int filterMode = 1;
	
	private NewPatient patient, editPatient;
	private List<NewPatient> patients;
	
	private MedicalRecord medicalRecord;
	private List<MedicalRecord> medicalRecords;
	
	private int year;
	private String month;
	private int day;
	
	private int[] years;
	private List<String> months, contactRelation = new ArrayList<String>();
	private int[] days;
	
	public PatientViewBacking() { }
	
	@PostConstruct
	public void init() {
		patients = new ArrayList<NewPatient>();
		generateYearMonthDayNow();
		refreshPatientData();
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

	public NewPatient getEditPatient() {
		return editPatient;
	}

	public void setEditPatient(NewPatient editPatient) {
		this.editPatient = editPatient;
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
	
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	public String onClickView(NewPatient patientData) {
		patient = new NewPatient(patientData);
		getPatientMedicalRecord();
		return "view.xhtml?faces-redirect=true";
	}
	
	public String onClickEdit() {
		unpackPatientData();
		return "edit.xhtml?faces-redirect=true";
	}
	
	public void refreshPatientData() {
		this.patients = eao.getPatients();
	}
	
	private void getPatientMedicalRecord() {
		this.medicalRecords = eao.getPatientMedicalRecordList(this.patient.getPatientID());
	}
	
	private void unpackPatientData() {
		editPatient = new NewPatient(this.patient);
		splitPatientNumber();
		generateYearMonthDay();
		generateRelationList();
		if(editPatient.getPatientBPJS() != null) {
			editPatient.setHasBPJS(1);
		}
	}
	
	private void packPatientData() {
		editPatient.setPatientBPJSTypeID(PatientEnum.getBPJSClassByString(editPatient.getPatientBPJSType()));
		
		if(editPatient.getPhoneTypeID() == PatientEnum.HOMEPHONE) {
			editPatient.setPhoneNumber(editPatient.getFrontExtNum() + " " + editPatient.getPhoneNumber());
		} else {
			editPatient.setPhoneNumber("+62 " + editPatient.getPhoneNumber());
		}
		
		patient.setProvinceID(1);
		patient.setKabupatenID(1);
		
		validateDOB();
	}
	
	private void validateDOB() {
		String dobString = year + "-" + DateHelper.getMonthfromString(month) + "-" + day;
		Date dobDate = DateHelper.formatStringToDate(dobString, "yyyy-MM-dd");
		
		if(day > DateHelper.findLengthDaysinMonthYear(year, DateHelper.getMonthfromString(month))) {
			messageHandler("Tidak ada hari " + day + "di " + month + " " + year, FacesMessage.SEVERITY_ERROR);
		} else {
			editPatient.setPatientDOB(DateHelper.formatDateToString(dobDate, "yyyy-MM-dd"));
		}
	}
	
	public String finalizePatientEdit() {
		packPatientData();
		this.patient = new NewPatient(editPatient);
		eao.updatePatient(this.editPatient);
		return "view.xhtml?faces-redirect=true";
	}
	
	private void splitPatientNumber() {
		String[] splitted = editPatient.getPhoneNumber().split(" ");
		
		if(editPatient.getPhoneTypeID() == PatientEnum.HOMEPHONE) {
			editPatient.setFrontExtNum(splitted[0]);
			editPatient.setPhoneNumber(splitted[1]);
		} else if(editPatient.getPhoneTypeID() == PatientEnum.HANDPHONE) {
			editPatient.setPhoneNumber(splitted[1]);
		}
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
	
	private void generateYearMonthDay() {
		String[] splitDOB = editPatient.getPatientDOB().split("-");
		
		DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
		months = new ArrayList<String>();
		months.addAll(Arrays.asList(dfs.getMonths()));
		months.remove("");
		
		years = IntStream.rangeClosed(1900,  LocalDate.now().getYear()).toArray();
		days = IntStream.rangeClosed(1, 31).toArray();
		
		day = Integer.valueOf(splitDOB[2]);
		year = Integer.valueOf(splitDOB[0]);
		month = DateHelper.getMonthNamefromInt(Integer.valueOf(splitDOB[1]), Locale.ENGLISH);
	}
	
	private void generateRelationList() {
		if(contactRelation.isEmpty()) {
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
	}
	
	private void validateSearchDate() {
		String dobString = year + "-" + DateHelper.getMonthfromString(month) + "-" + day;
		Date dobDate = DateHelper.formatStringToDate(dobString, "yyyy-MM-dd");
		
		if(day > DateHelper.findLengthDaysinMonthYear(year, DateHelper.getMonthfromString(month))) {
			messageHandler("Tidak ada hari " + day + "di " + month + " " + year, FacesMessage.SEVERITY_ERROR);
		} else {
			search = DateHelper.formatDateToString(dobDate, "yyyy-MM-dd");
		}
	}
	
	public void clearSearchTerm() {
		search = "";
	}
	
	public void onClickSearch() {
		switch (filterMode) {
		case BasicEnum.FILTER_NO_RM:
			break;
		case BasicEnum.FILTER_NAME:
			this.patients = eao.getPatientSearchName(this.search);
			break;
		case BasicEnum.FILTER_GENDER:
			this.patients = eao.getPatientSearchGender(this.search);
			break;
		case BasicEnum.FILTER_DOB:
			validateSearchDate();
			this.patients = eao.getPatientSearchDOB(this.search);
			break;
		default:
			break;
		}
	}

}
