package com.binus.pmsys.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Visitation implements Serializable {
	private static final long serialVersionUID = 318525348363376248L;
	
	private int apptID;
	
	private int patientID;
	private String patientName;
	private String patientGender;
	private String patientDOB;
	
	private int doctorID;
	private int docTypeID;
	private String doctorType;
	private int staffID;
	private String staffName;
	
	private String apptTime;
	private String apptDate;
	
	private int apptFinish;
	
	public Visitation() { }
	
	public Visitation(Visitation vis) {
		setApptID(vis.getApptID());
		setPatientID(vis.getPatientID());
		setPatientName(vis.getPatientName());
		setPatientGender(vis.getPatientGender());
		setPatientDOB(vis.getPatientDOB());
		setDoctorID(vis.getDoctorID());
		setDocTypeID(vis.getDocTypeID());
		setDoctorType(vis.getDoctorType());
		setStaffID(vis.getStaffID());
		setStaffName(vis.getStaffName());
		setApptTime(vis.getApptTime());
		setApptDate(vis.getApptDate());
		setApptFinish(vis.getApptFinish());
	}
	
	public int getApptID() {
		return apptID;
	}

	public void setApptID(int apptID) {
		this.apptID = apptID;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
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

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public int getDocTypeID() {
		return docTypeID;
	}

	public void setDocTypeID(int docTypeID) {
		this.docTypeID = docTypeID;
	}

	public String getDoctorType() {
		return doctorType;
	}

	public void setDoctorType(String doctorType) {
		this.doctorType = doctorType;
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

	public String getApptTime() {
		return apptTime;
	}

	public void setApptTime(String apptTime) {
		this.apptTime = apptTime;
	}

	public String getApptDate() {
		return apptDate;
	}

	public void setApptDate(String apptDate) {
		this.apptDate = apptDate;
	}

	public int getApptFinish() {
		return apptFinish;
	}

	public void setApptFinish(int apptFinish) {
		this.apptFinish = apptFinish;
	}

}
