package com.binus.pmsys.entity;

public class Patient {
	
	private int id;
	private String KTP;
	private String name;
	private String gender;
	private String birthDate;
	private Address address;
	private String relation;
	private String noTel;
	
	public Patient() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKTP() {
		return KTP;
	}

	public void setKTP(String kTP) {
		KTP = kTP;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getNoTel() {
		return noTel;
	}

	public void setNoTel(String noTel) {
		this.noTel = noTel;
	}

}
