package com.binus.pmsys.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class StaffMenuBacking implements Serializable {
	private static final long serialVersionUID = -2254318467858280512L;
	
	private List<String> menuSource = new ArrayList<String>();
	
	public StaffMenuBacking() { }
	
	public List<String> getMenuSource() {
		return menuSource;
	}

	public void setMenuSource(List<String> menuSource) {
		this.menuSource = menuSource;
	}

	public String redirectStaff() {
		menuSource.clear();
		menuSource.add("Umum - Registrasi Pasien Baru");
		menuSource.add("Umum - Pasien");
		menuSource.add("Umum - Atur Rawat Jalan");
		menuSource.add("Admin - Registrasi Staff");
		menuSource.add("Admin - Staff List");
		menuSource.add("Admin - Atur Menu Staff");
		menuSource.add("Dokter - Kunjungan");
		return "aturpersonal.xhtml?faces-redirect=true";
	}
}
