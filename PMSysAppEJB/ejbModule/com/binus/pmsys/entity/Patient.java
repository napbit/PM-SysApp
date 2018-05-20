package com.binus.pmsys.entity;

public class Patient {
	
	private int id;
	private String KTP;
	private String BPJS;
	private String name;
	private String gender;
	private String birthDate;
	private String relationName;
	private String relationType;
	private String relationContact;
	private Address address;
	
	public Patient() { 
		address = new Address();
	}
	
	public Patient(Patient p) {
		setId(p.getId());
		setKTP(p.getKTP());
		setName(p.getName());
		setGender(p.getGender());
		setBirthDate(p.getBirthDate());
		setHeight(p.getHeight());
		setWeight(p.getWeight());
		setRelationName(p.getRelationName());
		setRelationType(p.getRelationType());
		setRelationContact(p.getRelationContact());
		address = new Address(p.getAddress());
	}

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

	public String getBPJS() {
		return BPJS;
	}

	public void setBPJS(String bPJS) {
		BPJS = bPJS;
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

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public String getRelationContact() {
		return relationContact;
	}

	public void setRelationContact(String relationContact) {
		this.relationContact = relationContact;
	}

}
