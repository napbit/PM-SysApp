package com.binus.pmsys.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Medicine implements Serializable{
	private static final long serialVersionUID = 4336186074926666419L;

	private int medID;
	private String medName;
	private String medCategory;
	private String medType;
	private String activeIngredients;
	
	private int stockQty;
	private float medicinePrice; // MARKUP
	private float medicineHNA;
	private float medicinePPN;
	private float medicineFinalPrice;
	
	private String expDate;
	
	public Medicine() {	}

	public Medicine(Medicine m) {
		setMedID(m.getMedID());
		setMedName(m.getMedName());
		setMedCategory(m.getMedCategory());
		setMedType(m.getMedType());
		setActiveIngredients(m.getActiveIngredients());
		setStockQty(m.getStockQty());
		setMedicinePrice(m.getMedicinePrice());
		setMedicineHNA(m.getMedicineHNA());
		setMedicinePPN(m.getMedicinePPN());
		setMedicineFinalPrice(m.getMedicineFinalPrice());
		setExpDate(m.getExpDate());
	}
	
	public float calculateFinalPrice() {
		return (this.medicineHNA * (this.medicinePPN/100 + 1)) + medicinePrice;
	}
	
	public int getMedID() {
		return medID;
	}

	public void setMedID(int medID) {
		this.medID = medID;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public String getMedCategory() {
		return medCategory;
	}

	public void setMedCategory(String medCategory) {
		this.medCategory = medCategory;
	}

	public String getMedType() {
		return medType;
	}

	public void setMedType(String medType) {
		this.medType = medType;
	}

	public String getActiveIngredients() {
		return activeIngredients;
	}

	public void setActiveIngredients(String activeIngredients) {
		this.activeIngredients = activeIngredients;
	}

	public int getStockQty() {
		return stockQty;
	}

	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}

	public float getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(float medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	public float getMedicineHNA() {
		return medicineHNA;
	}

	public void setMedicineHNA(float medicineHNA) {
		this.medicineHNA = medicineHNA;
	}

	public float getMedicinePPN() {
		return medicinePPN;
	}

	public void setMedicinePPN(float medicinePPN) {
		this.medicinePPN = medicinePPN;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public float getMedicineFinalPrice() {
		return medicineFinalPrice;
	}

	public void setMedicineFinalPrice(float medicineFinalPrice) {
		this.medicineFinalPrice = medicineFinalPrice;
	}
	
	
}
