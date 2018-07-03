package com.binus.pmsys.entity;

public class MedicalRecord {
	
	private int recordID;
	private String recordSEP;
	
	private int doctorID;
	private String doctorName;
	
	private int patientID;
	private String patientName;
	
	private String medicalSubject;
	private String medicalObject;
	private String medicalAssessment;
	private String medicalPlanning;
	
	private int bloodPressure;
	private int patientSystolic;
	private int patientSiastolic;
	private float patientWeight;
	private float patientHeight;
	
	private String recordDate;
	
	public MedicalRecord() {
		
	}

	public int getRecordID() {
		return recordID;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}

	public String getRecordSEP() {
		return recordSEP;
	}

	public void setRecordSEP(String recordSEP) {
		this.recordSEP = recordSEP;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getMedicalSubject() {
		return medicalSubject;
	}

	public void setMedicalSubject(String medicalSubject) {
		this.medicalSubject = medicalSubject;
	}

	public String getMedicalObject() {
		return medicalObject;
	}

	public void setMedicalObject(String medicalObject) {
		this.medicalObject = medicalObject;
	}

	public String getMedicalAssessment() {
		return medicalAssessment;
	}

	public void setMedicalAssessment(String medicalAssessment) {
		this.medicalAssessment = medicalAssessment;
	}

	public String getMedicalPlanning() {
		return medicalPlanning;
	}

	public void setMedicalPlanning(String medicalPlanning) {
		this.medicalPlanning = medicalPlanning;
	}

	public int getPatientSystolic() {
		return patientSystolic;
	}

	public void setPatientSystolic(int patientSystolic) {
		this.patientSystolic = patientSystolic;
	}

	public int getPatientSiastolic() {
		return patientSiastolic;
	}

	public void setPatientSiastolic(int patientSiastolic) {
		this.patientSiastolic = patientSiastolic;
	}

	public float getPatientWeight() {
		return patientWeight;
	}

	public void setPatientWeight(float patientWeight) {
		this.patientWeight = patientWeight;
	}

	public float getPatientHeight() {
		return patientHeight;
	}

	public void setPatientHeight(float patientHeight) {
		this.patientHeight = patientHeight;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public int getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(int bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

}
