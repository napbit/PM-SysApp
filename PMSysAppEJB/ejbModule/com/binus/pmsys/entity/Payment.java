package com.binus.pmsys.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Payment implements Serializable{
	private static final long serialVersionUID = 3337553435617987704L;
	
	private int billID;
	
	private int patientID;
	private String patientName;
	
	private int doctorID;	
	private String doctorName;
	
	private float sum;
	private float finalPrice;
	private float paid;
	private float change;
	
	private String paymentType;
	private String date;
	
	public Payment() {	}
	
	public Payment(Payment p) {
		setBillID(p.getBillID());
		setPatientID(p.getPatientID());
		setPatientName(p.getPatientName());
		setDoctorID(p.getDoctorID());
		setDoctorName(p.getDoctorName());
		setSum(p.getSum());
		setFinalPrice(p.getFinalPrice());
		setPaymentType(p.getPaymentType());
		setDate(p.getDate());
		setPaid(p.getPaid());
		setChange(p.getChange());
	}
	
	public Payment(int billID, int patientID, String patientName, int doctorID, String doctorName, float sum,
			float finalPrice, String paymentType, String date) {
		super();
		this.billID = billID;
		this.patientID = patientID;
		this.patientName = patientName;
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.sum = sum;
		this.finalPrice = finalPrice;
		this.paymentType = paymentType;
		this.date = date;
	}



	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
		this.billID = billID;
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

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

	public float getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getPaid() {
		return paid;
	}

	public void setPaid(float paid) {
		this.paid = paid;
	}

	public float getChange() {
		return change;
	}

	public void setChange(float change) {
		this.change = change;
	}

}
