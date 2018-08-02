package com.binus.pmsys.entity;

public class Kabupaten {
	
	private int id;
	private String kabupatenName;
	
	public Kabupaten() { }
	
	public Kabupaten(Kabupaten k) {
		setId(k.getId());
		setKabupatenName(k.getKabupatenName());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKabupatenName() {
		return kabupatenName;
	}

	public void setKabupatenName(String kabupatenName) {
		this.kabupatenName = kabupatenName;
	}
	
	
	
}
