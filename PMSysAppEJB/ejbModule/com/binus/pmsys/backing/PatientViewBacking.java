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

	private Patient patient;
	private List<Patient> patients;
	
	private boolean personalEdit = false;
	private boolean kontakEdit = false;
	private boolean emergencyEdit = false;
	
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

	public boolean isPersonalEdit() {
		return personalEdit;
	}

	public void setPersonalEdit(boolean personalEdit) {
		this.personalEdit = personalEdit;
	}

	public boolean isKontakEdit() {
		return kontakEdit;
	}

	public void setKontakEdit(boolean kontakEdit) {
		this.kontakEdit = kontakEdit;
	}

	public boolean isEmergencyEdit() {
		return emergencyEdit;
	}

	public void setEmergencyEdit(boolean emergencyEdit) {
		this.emergencyEdit = emergencyEdit;
	}
	
	public void editPanel(int key) {
		switch (key) {
		case 1:
			personalEdit = true;
			break;
		case 2:
			kontakEdit = true;
			break;
		case 3:
			emergencyEdit = true;
			break;
		}
	}
	
	public void savePanel(int key) {
		switch (key) {
		case 1:
			savePersonal();
			break;
		case 2:
			saveKontak();
			break;
		case 3:
			saveEmergency();
			break;
		}
	}
	
	private void savePersonal() {
		rules.savePatient(this.patient);
		personalEdit = false;
	}
	
	private void saveKontak() {
		kontakEdit = false;
	}
	
	private void saveEmergency() {
		emergencyEdit = false;
	}
	
	public String onClickEdit(Patient patientData) {
		patient = new Patient(patientData);
		return "view.xhtml?faces-redirect=true";
	}
	
	public void onClickSearch() {
		patients = rules.getPatientSearch(search);
	}

}
