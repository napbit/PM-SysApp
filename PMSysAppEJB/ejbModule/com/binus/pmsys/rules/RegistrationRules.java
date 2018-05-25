package com.binus.pmsys.rules;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.binus.pmsys.eao.RegistrationEao;
import com.binus.pmsys.entity.Patient;

/**
 * Session Bean implementation class RegistrationRules
 */
@Stateless
@LocalBean
public class RegistrationRules {
	
	@EJB
	private transient RegistrationEao eao;
	
    public RegistrationRules() { }
    
    public void savePatient(Patient patientData) {
    	
    	try {
			eao.savePatient(patientData);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
}
