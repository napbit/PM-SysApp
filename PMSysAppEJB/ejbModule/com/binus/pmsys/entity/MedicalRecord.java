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
	private int patientDiastolic;
	private int patientWeight;
	private int patientHeight;
	private float patientBMI;
	
	private String recordDate;
	
	public MedicalRecord() {
		
	}

	public MedicalRecord(MedicalRecord mr) {
		setRecordID(mr.getRecordID());
		setRecordSEP(mr.getRecordSEP());
		setDoctorID(mr.getDoctorID());
		setDoctorName(mr.getDoctorName());
		setPatientID(mr.getPatientID());
		setPatientName(mr.getPatientName());
		setMedicalSubject(mr.getMedicalSubject());
		setMedicalObject(mr.getMedicalObject());
		setMedicalAssessment(mr.getMedicalAssessment());
		setMedicalPlanning(mr.getMedicalPlanning());
		setPatientSystolic(mr.getPatientSystolic());
		setPatientDiastolic(mr.getPatientDiastolic());
		setPatientWeight(mr.getPatientWeight());
		setPatientHeight(mr.getPatientHeight());
		setPatientBMI(mr.getPatientBMI());
		setRecordDate(mr.getRecordDate());
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

	public int getPatientDiastolic() {
		return patientDiastolic;
	}

	public void setPatientDiastolic(int patientDiastolic) {
		this.patientDiastolic = patientDiastolic;
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

	public float getPatientBMI() {
		return patientBMI;
	}

	public void setPatientBMI(float patientBMI) {
		this.patientBMI = patientBMI;
	}

	public int getPatientWeight() {
		return patientWeight;
	}

	public void setPatientWeight(int patientWeight) {
		this.patientWeight = patientWeight;
	}

	public int getPatientHeight() {
		return patientHeight;
	}

	public void setPatientHeight(int patientHeight) {
		this.patientHeight = patientHeight;
	}

}
