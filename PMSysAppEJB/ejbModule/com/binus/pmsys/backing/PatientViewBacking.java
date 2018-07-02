package com.binus.pmsys.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.binus.pmsys.eao.PatientViewEao;
import com.binus.pmsys.entity.NewPatient;

@Named
@SessionScoped
public class PatientViewBacking implements Serializable {
	private static final long serialVersionUID = -513189841959490721L;
	
	@EJB
	private PatientViewEao eao;
	
	private String search;
	private int filterMode;
	
	private NewPatient patient;
	private List<NewPatient> patients;
	
	public PatientViewBacking() { }
	
	@PostConstruct
	public void init() {
		patients = new ArrayList<NewPatient>();
		this.patients = eao.getPatients();
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
	
	public NewPatient getPatient() {
		return patient;
	}

	public void setPatient(NewPatient patient) {
		this.patient = patient;
	}

	public List<NewPatient> getPatients() {
		return patients;
	}

	public void setPatients(List<NewPatient> patients) {
		this.patients = patients;
	}

	public String onClickView(NewPatient patientData) {
		patient = new NewPatient(patientData); 
		return "view.xhtml?faces-redirect=true";
	}
	
	public void onClickSearch() {
		patients = eao.getPatientSearch(filterMode, search);
	}

}
