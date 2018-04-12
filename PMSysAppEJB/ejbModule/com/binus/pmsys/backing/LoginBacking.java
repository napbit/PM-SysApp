package com.binus.pmsys.backing;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBacking implements Serializable {
	private static final long serialVersionUID = 1988449267982435477L;

	public LoginBacking() { }
	
}
