package com.binus.pmsys.backing;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BasicBacking implements Serializable{
	private static final long serialVersionUID = 8927715261277783949L;

	public BasicBacking() { }
	
	protected boolean getIsPostBack() {
		return FacesContext.getCurrentInstance().isPostback();
	}
	
	protected void messageHandler(String message, FacesMessage.Severity severity) {
		FacesMessage facesMessage = new FacesMessage(message);
		facesMessage.setSeverity(severity);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
}
