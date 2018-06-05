package com.binus.pmsys.backing;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class StaffRegistrationBacking implements Serializable{
	private static final long serialVersionUID = 4048653124586114465L;
	
	public StaffRegistrationBacking() {	}

}
