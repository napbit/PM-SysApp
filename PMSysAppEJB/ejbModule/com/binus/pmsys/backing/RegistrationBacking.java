package com.binus.pmsys.backing;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.binus.pmsys.entity.Patient;

@Named
@ViewScoped
public class RegistrationBacking extends BasicBacking {
	private static final long serialVersionUID = 8664948727348463034L;
	
	private Patient patient;
	
	public RegistrationBacking() { }

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
