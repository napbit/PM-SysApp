package com.binus.pmsys.entity;

public class Address {
	
	private String address;
	private String propinsi;
	private String kabupaten;
	private String postCode;
	private String noHP;
	private String noTel;
	
	public Address() { }
	
	public Address(Address a) {
		setAddress(a.getAddress());
		setPropinsi(a.getPropinsi());
		setKabupaten(a.getKabupaten());
		setPostCode(a.getPostCode());
		setNoHP(a.getNoHP());
		setNoTel(a.getNoTel());
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPropinsi() {
		return propinsi;
	}

	public void setPropinsi(String propinsi) {
		this.propinsi = propinsi;
	}

	public String getKabupaten() {
		return kabupaten;
	}

	public void setKabupaten(String kabupaten) {
		this.kabupaten = kabupaten;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getNoHP() {
		return noHP;
	}

	public void setNoHP(String noHP) {
		this.noHP = noHP;
	}

	public String getNoTel() {
		return noTel;
	}

	public void setNoTel(String noTel) {
		this.noTel = noTel;
	}

}
