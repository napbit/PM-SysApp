package com.binus.pmsys.rules;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.binus.pmsys.eao.RegistrationEao;

/**
 * Session Bean implementation class RegistrationRules
 */
@Stateless
@LocalBean
public class RegistrationRules {
	
	@EJB
	private transient RegistrationEao eao;
	
    public RegistrationRules() { }

}
