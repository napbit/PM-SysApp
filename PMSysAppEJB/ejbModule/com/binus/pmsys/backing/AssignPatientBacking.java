package com.binus.pmsys.backing;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class AssignPatientBacking implements Serializable {
	private static final long serialVersionUID = 5040862810873608584L;
	
	private String search;
	private int filterMode;
	
	public AssignPatientBacking() {	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getFilterMode() {
		return filterMode;
	}

	public void setFilterMode(int filterMode) {
		this.filterMode = filterMode;
	}

}
