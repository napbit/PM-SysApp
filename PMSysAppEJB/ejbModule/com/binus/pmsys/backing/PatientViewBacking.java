package com.binus.pmsys.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.binus.pmsys.entity.Patient;
import com.binus.pmsys.rules.PatientViewRules;

@Named
@SessionScoped
public class PatientViewBacking implements Serializable {
	private static final long serialVersionUID = -513189841959490721L;
	
	@EJB
	private PatientViewRules rules;
	
	private String search;
	private int filterMode;
	
	private Patient patient;
	private List<Patient> patients;
	
	public PatientViewBacking() { }
	
	@PostConstruct
	public void init() {
		patients = new ArrayList<Patient>();
		patients = rules.getPatients();
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	public String onClickView(Patient patientData) {
		patient = new Patient(patientData);
		return "view.xhtml?faces-redirect=true";
	}
	
	public void onClickSearch() {
		patients = rules.getPatientSearch(search);
	}

}
