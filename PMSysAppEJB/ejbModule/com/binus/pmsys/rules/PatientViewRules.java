package com.binus.pmsys.rules;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.binus.pmsys.eao.PatientViewEao;
import com.binus.pmsys.entity.Patient;

/**
 * Session Bean implementation class ViewPatientBacking
 */
@Stateless
@LocalBean
public class PatientViewRules {
	
	@EJB
	private PatientViewEao eao;
	
    public PatientViewRules() { }
    
    public List<Patient> getPatients() {
    	List<Patient> patientList = null;
    	
    	try {
    		patientList = eao.getPatients();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		return patientList;
    }
    
    public Patient getPatient(int id) {
    	Patient patient = null;
    	
    	try {
			patient = eao.getPatient(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return patient;
    }
    
    public void savePatient(Patient patientData) {
    	try {
			eao.savePatient(patientData);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
