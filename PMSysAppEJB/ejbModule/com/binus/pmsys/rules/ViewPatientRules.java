package com.binus.pmsys.rules;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.binus.pmsys.eao.ViewPatientEao;
import com.binus.pmsys.entity.Patient;

/**
 * Session Bean implementation class ViewPatientBacking
 */
@Stateless
@LocalBean
public class ViewPatientRules {
	
	@EJB
	private ViewPatientEao eao;
	
    public ViewPatientRules() { }
    
    public List<Patient> getPatients() {
    	List<Patient> patientList = null;
    	
    	try {
    		patientList = eao.getPatients();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		return patientList;
    }

}
