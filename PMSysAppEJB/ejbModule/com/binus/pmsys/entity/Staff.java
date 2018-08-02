package com.binus.pmsys.entity;

public class Staff {
	
	private int staffID;
	private String staffKTP;
	private String staffName;
	private String staffDOB;
	private String staffGender;
	
	private String joinDate;
	private String leaveDate;
	
	private int positionID;
	private String position;
	
	private int contactID;
	private String phoneNumber;
	private String phoneType;
	private String frontExt;
	
	private int clinicID;
	private String clinicName;
	
	private int addressID;
	private String address;
	
	private String postCode;
	private int provinceID;
	private String province;
	private int kabupatenID;
	private String kabupaten;
	
	private int loginID;
	private String username;
	
	public Staff() {
		
	}
	
	public Staff(Staff s) {
		setStaffID(s.getStaffID());
		setStaffKTP(s.getStaffKTP());
		setStaffName(s.getStaffName());
		setStaffDOB(s.getStaffDOB());
		setStaffGender(s.getStaffGender());
		setJoinDate(s.getJoinDate());
		setLeaveDate(s.getLeaveDate());
		setPositionID(s.getPositionID());
		setPosition(s.getPosition());
		setContactID(s.getContactID());
		setPhoneNumber(s.getPhoneNumber());
		setPhoneType(s.getPhoneType());
		setFrontExt(s.getFrontExt());
		setClinicID(s.getClinicID());
		setClinicName(s.getClinicName());
		setAddressID(s.getAddressID());
		setAddress(s.getAddress());
		setPostCode(s.getPostCode());
		setProvinceID(s.getProvinceID());
		setProvince(s.getProvince());
		setKabupatenID(s.getKabupatenID());
		setKabupaten(s.getKabupaten());
		setLoginID(s.getLoginID());
		setUsername(s.getUsername());
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public String getStaffKTP() {
		return staffKTP;
	}

	public void setStaffKTP(String staffKTP) {
		this.staffKTP = staffKTP;
	}

	public String getStaffDOB() {
		return staffDOB;
	}

	public void setStaffDOB(String staffDOB) {
		this.staffDOB = staffDOB;
	}

	public String getStaffGender() {
		return staffGender;
	}

	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public int getClinicID() {
		return clinicID;
	}

	public void setClinicID(int clinicID) {
		this.clinicID = clinicID;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getKabupaten() {
		return kabupaten;
	}

	public void setKabupaten(String kabupaten) {
		this.kabupaten = kabupaten;
	}

	public int getLoginID() {
		return loginID;
	}

	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getFrontExt() {
		return frontExt;
	}

	public void setFrontExt(String frontExt) {
		this.frontExt = frontExt;
	}

	public int getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}

	public int getKabupatenID() {
		return kabupatenID;
	}

	public void setKabupatenID(int kabupatenID) {
		this.kabupatenID = kabupatenID;
	}
	
	
	
}
