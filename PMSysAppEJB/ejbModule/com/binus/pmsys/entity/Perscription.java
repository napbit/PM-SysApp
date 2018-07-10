package com.binus.pmsys.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Perscription implements Serializable{
	private static final long serialVersionUID = -1797407965421426044L;
	
	private int perID;
	
	private int medID;
	private String medName;
	private String medCategory;
	private String medType;
	private String activeIngredients;
	
	private int patID;
	private String patName;
	
	private String instructions;
	
	public Perscription() { }
	
	public Perscription(Perscription per) {
		setPerID(per.getPerID());
		setMedID(per.getMedID());
		setMedName(per.getMedName());
		setPatID(per.getPatID());
		setPatName(per.getPatName());
		setInstructions(per.getInstructions());
		setMedCategory(per.getMedCategory());
		setMedType(per.getMedType());
		setActiveIngredients(per.getActiveIngredients());
	}
	
	public int getPerID() {
		return perID;
	}

	public void setPerID(int perID) {
		this.perID = perID;
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

	public int getPatID() {
		return patID;
	}

	public void setPatID(int patID) {
		this.patID = patID;
	}

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
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

}
