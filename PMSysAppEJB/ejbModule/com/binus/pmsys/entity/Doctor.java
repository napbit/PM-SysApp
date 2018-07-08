package com.binus.pmsys.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Doctor implements Serializable{
	private static final long serialVersionUID = -1182102852736090844L;
	
	private int doctorID;
	private int staffID;
	private String staffName;
	private String staffGender;

	private int positionID;
	private String staffPosition;
	
	private int doctorTypeID;
	private String doctorType;
	
	private String clinicName;
	
	public Doctor() { }
	
	public Doctor(Doctor doc) {
		setDoctorID(doc.getDoctorID());
		setStaffID(doc.getStaffID());
		setStaffName(doc.getStaffName());
		setStaffGender(doc.getStaffGender());
		setPositionID(doc.getPositionID());
		setStaffPosition(doc.getStaffPosition());
		setDoctorTypeID(doc.getDoctorTypeID());
		setDoctorType(doc.getDoctorType());
		setClinicName(doc.getClinicName());
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffGender() {
		return staffGender;
	}

	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public String getStaffPosition() {
		return staffPosition;
	}

	public void setStaffPosition(String staffPosition) {
		this.staffPosition = staffPosition;
	}

	public int getDoctorTypeID() {
		return doctorTypeID;
	}

	public void setDoctorTypeID(int doctorTypeID) {
		this.doctorTypeID = doctorTypeID;
	}

	public String getDoctorType() {
		return doctorType;
	}

	public void setDoctorType(String doctorType) {
		this.doctorType = doctorType;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}
}
