package com.binus.pmsys.entity;

public class Province {
	
	private int id;
	private String provinceName;
	
	public Province() { }
	
	public Province(Province p) {
		setId(p.getId());
		setProvinceName(p.getProvinceName());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	
}
