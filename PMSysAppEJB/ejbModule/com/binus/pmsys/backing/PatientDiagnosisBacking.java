package com.binus.pmsys.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.binus.pmsys.eao.PatientDiagnosisEao;
import com.binus.pmsys.entity.MedicalRecord;
import com.binus.pmsys.entity.NewPatient;
import com.binus.pmsys.entity.Visitation;

@Named
@SessionScoped
public class PatientDiagnosisBacking implements Serializable {
	private static final long serialVersionUID = 700326609867752540L;
	
	@EJB
	private transient PatientDiagnosisEao eao;
	
	private String search;
	private int filterMode;
	
	private NewPatient patient;
	private MedicalRecord medicalRecord;
	
	private Visitation visit;
	private List<Visitation> visits;
	
	private boolean medicineDialog;
	
	public PatientDiagnosisBacking() {	}
	
	@PostConstruct
	public void init() {
		visits = new ArrayList<Visitation>();
		visits = eao.getListByDoctor(1); // TODO: get by login
	}
	
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

	public List<Visitation> getVisits() {
		return visits;
	}

	public void setVisits(List<Visitation> visits) {
		this.visits = visits;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public Visitation getVisit() {
		return visit;
	}

	public void setVisit(Visitation visit) {
		this.visit = visit;
	}

	public void dialogCloseListener() {
		setMedicineDialog(false);
	}
	
	public void openMedicineDialog() {
		setMedicineDialog(true);
	}
	
	public String diagnosePatient(Visitation visit) {
		this.visit = new Visitation(visit);
		medicalRecord = new MedicalRecord();
		return "diagnosa.xhtml?faces-redirect=true";
	}
}
