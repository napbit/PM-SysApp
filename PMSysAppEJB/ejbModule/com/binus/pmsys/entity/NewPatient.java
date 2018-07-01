package com.binus.pmsys.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class NewPatient implements Serializable{
	private static final long serialVersionUID = 7922372315656026349L;
	
	private int patientID;
	private String patientRM;
	private String patientKTP;
	private String patientName;
	private String patientGender;
	private String patientDOB;
	
	private int bpjsID;
	private int hasBPJS;
	private String patientBPJS;
	private String patientBPJSType;
	private int patientBPJSTypeID;
	
	private int phoneID;
	private String phoneNumber;
	private String phoneType;
	private int phoneTypeID;
	
	private int emergencyID;
	private String contactName;
	private String contactRelationship;
	private String contactNumber;
	
	private int addressID;
	private String address;
	
	private String postCode;
	private int provinceID;
	private String province;
	
	private int kabupatenID;
	private String kabupaten;
	
	public NewPatient() {}
	
	public NewPatient(NewPatient p) {
		setPatientRM(p.getPatientRM());
		setPatientID(p.getPatientID());
		setPatientKTP(p.getPatientKTP());
		setPatientName(p.getPatientName());
		setPatientGender(p.getPatientGender());
		setPatientDOB(p.getPatientDOB());
		setBpjsID(p.getBpjsID());
		setPatientBPJS(p.getPatientBPJS());
		setPatientBPJSType(p.getPatientBPJSType());
		setPhoneID(p.getPhoneID());
		setPhoneNumber(p.getPhoneNumber());
		setPhoneType(p.getPhoneType());
		setEmergencyID(p.getEmergencyID());
		setContactName(p.getContactName());
		setContactRelationship(p.getContactRelationship());
		setContactNumber(p.getContactNumber());
		setAddressID(p.getAddressID());
		setAddress(p.getAddress());
		setPostCode(p.getPostCode());
		setProvinceID(p.getProvinceID());
		setProvince(p.getProvince());
		setKabupatenID(p.getKabupatenID());
		setKabupaten(p.getKabupaten());
		setHasBPJS(p.getHasBPJS());
		setPatientBPJSTypeID(p.getPatientBPJSTypeID());
		setPhoneTypeID(p.getPhoneTypeID());
	}
	
	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getPatientKTP() {
		return patientKTP;
	}

	public void setPatientKTP(String patientKTP) {
		this.patientKTP = patientKTP;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPatientDOB() {
		return patientDOB;
	}

	public void setPatientDOB(String patientDOB) {
		this.patientDOB = patientDOB;
	}

	public int getBpjsID() {
		return bpjsID;
	}

	public void setBpjsID(int bpjsID) {
		this.bpjsID = bpjsID;
	}

	public String getPatientBPJS() {
		return patientBPJS;
	}

	public void setPatientBPJS(String patientBPJS) {
		this.patientBPJS = patientBPJS;
	}

	public String getPatientBPJSType() {
		return patientBPJSType;
	}

	public void setPatientBPJSType(String patientBPJSType) {
		this.patientBPJSType = patientBPJSType;
	}

	public int getPhoneID() {
		return phoneID;
	}

	public void setPhoneID(int phoneID) {
		this.phoneID = phoneID;
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

	public int getEmergencyID() {
		return emergencyID;
	}

	public void setEmergencyID(int emergencyID) {
		this.emergencyID = emergencyID;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactRelationship() {
		return contactRelationship;
	}

	public void setContactRelationship(String contactRelationship) {
		this.contactRelationship = contactRelationship;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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

	public int getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getKabupatenID() {
		return kabupatenID;
	}

	public void setKabupatenID(int kabupatenID) {
		this.kabupatenID = kabupatenID;
	}

	public String getKabupaten() {
		return kabupaten;
	}

	public void setKabupaten(String kabupaten) {
		this.kabupaten = kabupaten;
	}

	public String getPatientRM() {
		return patientRM;
	}

	public void setPatientRM(String patientRM) {
		this.patientRM = patientRM;
	}

	public int getHasBPJS() {
		return hasBPJS;
	}

	public void setHasBPJS(int hasBPJS) {
		this.hasBPJS = hasBPJS;
	}

	public int getPatientBPJSTypeID() {
		return patientBPJSTypeID;
	}

	public void setPatientBPJSTypeID(int patientBPJSTypeID) {
		this.patientBPJSTypeID = patientBPJSTypeID;
	}

	public int getPhoneTypeID() {
		return phoneTypeID;
	}

	public void setPhoneTypeID(int phoneTypeID) {
		this.phoneTypeID = phoneTypeID;
	}
	
}
