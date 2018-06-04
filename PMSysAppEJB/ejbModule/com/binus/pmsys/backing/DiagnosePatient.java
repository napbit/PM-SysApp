package com.binus.pmsys.backing;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class DiagnosePatient implements Serializable {
	private static final long serialVersionUID = 700326609867752540L;
	
	private String search;
	private int filterMode;
	
	private boolean medicineDialog;
	
	public DiagnosePatient() {	}

	public boolean isMedicineDialog() {
		return medicineDialog;
	}

	public void setMedicineDialog(boolean medicineDialog) {
		this.medicineDialog = medicineDialog;
	}
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getFilterMode() {
		return filterMode;
	}

	public void setFilterMode(int filterMode) {
		this.filterMode = filterMode;
	}

	public void dialogCloseListener() {
		setMedicineDialog(false);
	}
	
	public void openMedicineDialog() {
		setMedicineDialog(true);
	}
}
