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
import com.binus.pmsys.eao.StaffViewEao;
import com.binus.pmsys.entity.Kabupaten;
import com.binus.pmsys.entity.Position;
import com.binus.pmsys.entity.Province;
import com.binus.pmsys.entity.Staff;
import com.binus.pmsys.enums.BasicEnum;
import com.binus.pmsys.enums.PatientEnum;
import com.binus.pmsys.utils.DateHelper;

@Named
@SessionScoped
public class StaffViewBacking extends BasicBacking {
	private static final long serialVersionUID = -8775746382303096522L;

	@EJB
	private transient StaffViewEao eao;

	@EJB
	private transient RegionEao regionEao;

	private List<Staff> staffList = new ArrayList<Staff>();
	private Staff staff;
	private Staff newStaff;

	private int filterMode;

	private int year;
	private String month;
	private int day;

	private int[] years;
	private List<String> months = new ArrayList<String>();
	private int[] days;

	private List<Province> provinces;
	private List<Kabupaten> kabupatens;
	private List<Position> positions;
	
	private String searchTerm;
	
	public StaffViewBacking() {

	}

	@PostConstruct
	public void init() {
		refreshStaffList();
	}

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public int getFilterMode() {
		return filterMode;
	}

	public void setFilterMode(int filterMode) {
		this.filterMode = filterMode;
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

	public List<String> getMonths() {
		return months;
	}

	public void setMonths(List<String> months) {
		this.months = months;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public int[] getDays() {
		return days;
	}

	public void setDays(int[] days) {
		this.days = days;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public String getStaffDetail(Staff staff) {
		this.staff = new Staff(staff);
		return "view.xhtml?faces-redirect=true";
	}

	public String onClickEdit() {
		this.newStaff = new Staff(this.staff);
		generateYearMonthDay();
		getRegions();
		getPositionsList();
		return "edit.xhtml?faces-redirect=true";
	}

	private void getRegions() {
		this.provinces = regionEao.getProvinces();
		this.kabupatens = regionEao.getKabupatens();
	}

	private void getPositionsList() {
		this.positions = eao.getPositions();
	}

	private void generateYearMonthDay() {
		String[] splitDOB = newStaff.getStaffDOB().split("-");

		DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
		months = new ArrayList<String>();
		months.addAll(Arrays.asList(dfs.getMonths()));
		months.remove("");

		years = IntStream.rangeClosed(1900, LocalDate.now().getYear()).toArray();
		days = IntStream.rangeClosed(1, 31).toArray();

		day = Integer.valueOf(splitDOB[2]);
		year = Integer.valueOf(splitDOB[0]);
		month = DateHelper.getMonthNamefromInt(Integer.valueOf(splitDOB[1]), Locale.ENGLISH);
	}

	public String updateStaffConfirm() {
		packStaffData();
		this.staff = new Staff(newStaff);
		int result = this.eao.updateStaff(newStaff);

		if (result == 1) {
			getFlash().setKeepMessages(true);
			getFlash().setRedirect(true);
			getFacesContext().addMessage(null, flashMessageHandler("Berhasil untuk mengupdate data staff.", FacesMessage.SEVERITY_INFO));
		} else {
			getFlash().setKeepMessages(true);
			getFlash().setRedirect(true);
			getFacesContext().addMessage(null, flashMessageHandler("Mengupdate data staff tidak berhasil.", FacesMessage.SEVERITY_ERROR));
		}

		return "view.xhtml?faces-redirect=true";
	}

	private void packStaffData() {
		if (PatientEnum.getPhoneTypeByString(newStaff.getPhoneType()) == PatientEnum.HOMEPHONE) {
			newStaff.setPhoneNumber(newStaff.getFrontExt() + " " + newStaff.getPhoneNumber());
		} else {
			newStaff.setPhoneNumber("+62 " + newStaff.getPhoneNumber());
		}

		validateDOB();
	}

	private void validateDOB() {
		String dobString = year + "-" + DateHelper.getMonthfromString(month) + "-" + day;
		Date dobDate = DateHelper.formatStringToDate(dobString, "yyyy-MM-dd");

		if (day > DateHelper.findLengthDaysinMonthYear(year, DateHelper.getMonthfromString(month))) {
			messageHandler("Tidak ada hari " + day + "di " + month + " " + year, FacesMessage.SEVERITY_ERROR);
		} else {
			newStaff.setStaffDOB(DateHelper.formatDateToString(dobDate, "yyyy-MM-dd"));
		}
	}
	
	private void searchStaffList() {
		switch (filterMode) {
		case BasicEnum.FILTER_NO_RM:
			
			break;
		case BasicEnum.FILTER_NAME:
			
			break;
		case BasicEnum.FILTER_GENDER:
			
			break;
		case BasicEnum.FILTER_DOB:
			
			break;
		default:
			break;
		}
	}
	
	public void refreshStaffList() {
		this.staffList = eao.getAllStaff();
	}
}
