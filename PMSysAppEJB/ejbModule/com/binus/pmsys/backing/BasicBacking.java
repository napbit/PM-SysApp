package com.binus.pmsys.backing;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class BasicBacking implements Serializable{
	private static final long serialVersionUID = 8927715261277783949L;

	public BasicBacking() { }
	
	public FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
	public ExternalContext getExternalContext(){
		return FacesContext.getCurrentInstance().getExternalContext();
	}
}
