package com.binus.pmsys.backing;

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
import com.binus.pmsys.eao.RegistrationEao;
import com.binus.pmsys.entity.Kabupaten;
import com.binus.pmsys.entity.NewPatient;
import com.binus.pmsys.entity.Province;
import com.binus.pmsys.enums.PatientEnum;
import com.binus.pmsys.utils.DateHelper;

@Named
@SessionScoped
public class RegistrationBacking extends BasicBacking {
	private static final long serialVersionUID = 8664948727348463034L;

	@EJB
	private transient RegistrationEao registrationService;

	@EJB
	private transient RegionEao regionEao;

	private NewPatient patient;

	private int year;
	private String month;
	private int day;

	private int[] years;
	private List<String> months, contactRelation;
	private int[] days;

	private String normalDOB; // DOB in user readable format

	private List<Province> provinces;
	private List<Kabupaten> kabupatens;

	public RegistrationBacking() {
	}

	public NewPatient getPatient() {
		return patient;
	}

	public void setPatient(NewPatient patient) {
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

	public int[] getYears() {
		return years;
	}

	public void setYears(int[] years) {
		this.years = years;
	}

	public List<String> getContactRelation() {
		return contactRelation;
	}

	public void setContactRelation(List<String> contactRelation) {
		this.contactRelation = contactRelation;
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

	public void pageInitialize() {
		if (!getIsPostBack()) {
			patient = new NewPatient();
			generateYearMonthDay();
			generateRelationList();
			getRegions();
		}
	}

	private void generateYearMonthDay() {
		LocalDate now = LocalDate.now();

		DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
		months = new ArrayList<String>();
		months.addAll(Arrays.asList(dfs.getMonths()));
		months.remove("");

		years = IntStream.rangeClosed(1900, LocalDate.now().getYear()).toArray();
		days = IntStream.rangeClosed(1, 31).toArray();

		day = now.getDayOfMonth();
		year = now.getYear();
		month = DateHelper.getMonthNamefromInt(now.getMonthValue(), Locale.ENGLISH);
	}
	
	private void getRegions() {
		this.provinces = regionEao.getProvinces();
		this.kabupatens = regionEao.getKabupatens();
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

	private void validateDOB() {
		normalDOB = day + "-" + month + "-" + year;
		String dobString = year + "-" + DateHelper.getMonthfromString(month) + "-" + day;
		Date dobDate = DateHelper.formatStringToDate(dobString, "yyyy-MM-dd");

		if (day > DateHelper.findLengthDaysinMonthYear(year, DateHelper.getMonthfromString(month))) {
			messageHandler("Tidak ada hari " + day + "di " + month + " " + year, FacesMessage.SEVERITY_ERROR);
		} else {
			patient.setPatientDOB(DateHelper.formatDateToString(dobDate, "yyyy-MM-dd"));
		}
	}

	private NewPatient prepackagePatientData(NewPatient patient) {
		if (patient.getHasBPJS() == PatientEnum.YES_BPJS) {
			patient.setPatientBPJS(patient.getPatientBPJS().replaceAll("\\s+", ""));
			patient.setPatientBPJSTypeID(PatientEnum.getBPJSClassByString(patient.getPatientBPJSType()));
		}

		patient.setPatientKTP(patient.getPatientKTP().replaceAll("\\s+", ""));
		patient.setPhoneTypeID(PatientEnum.getPhoneTypeByString(patient.getPhoneType()));

		if (patient.getPhoneTypeID() == PatientEnum.HOMEPHONE) {
			patient.setPhoneNumber(patient.getFrontExtNum() + " " + patient.getPhoneNumber());
		} else {
			patient.setPhoneNumber("+62 " + patient.getPhoneNumber());
		}

		return patient;
	}
	
	private void findProvince() {
		for (Province prov : provinces) {
			if(prov.getId() == patient.getProvinceID()) {
				this.patient.setProvince(prov.getProvinceName());
			}
		}
	}
	
	private void findKabupaten() {
		for (Kabupaten kab : kabupatens) {
			if(kab.getId() == patient.getKabupatenID()) {
				this.patient.setKabupaten(kab.getKabupatenName());
			}
		}
	}
	
	public String redirectToReview() {
		validateDOB();
		findProvince();
		findKabupaten();
		return "review.xhtml?faces-redirect=true";
	}

	public String finalizePatientCreation() {
		LocalDate now = LocalDate.now();
		
		int day = now.getDayOfMonth();
		int year = now.getYear();
		int month = now.getMonthValue();
		
		String date = year + "-" + month + "-" + day;
		Date dates = DateHelper.formatStringToDate(date, "yyyy-mm-dd");
		
		int result = registrationService.savePatient(prepackagePatientData(this.patient), DateHelper.formatDateToString(dates, "yyyy-mm-dd"));
		
		if (result == 1) {
			getFlash().setKeepMessages(true);
			getFlash().setRedirect(true);
			getFacesContext().addMessage(null, flashMessageHandler("Berhasil untuk registrasi pasien baru.", FacesMessage.SEVERITY_INFO));
		} else {
			getFlash().setKeepMessages(true);
			getFlash().setRedirect(true);
			getFacesContext().addMessage(null, flashMessageHandler("Registrasi pasien baru tidak berhasil.", FacesMessage.SEVERITY_ERROR));
		}
		
		return "/menu.xhtml?faces-redirect=true";
	}
}
