package com.binus.pmsys.entity;

public class Patient {
	
	private int id;
	private String patientKTP;
	private String patientBPJS;
	private String name;
	private String gender;
	private String birthDate;
	private int relationID;
	private String relationName;
	private String relationType;
	private String relationContact;
	private Address address;
	
	public Patient() { 
		address = new Address();
	}
	
	public Patient(Patient p) {
		setId(p.getId());
		setPatientKTP(p.getPatientKTP());
		setPatientBPJS(p.getPatientBPJS());
		setName(p.getName());
		setGender(p.getGender());
		setBirthDate(p.getBirthDate());
		setRelationID(p.getRelationID());
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

	public String getPatientKTP() {
		return patientKTP;
	}

	public void setPatientKTP(String patientKTP) {
		this.patientKTP = patientKTP;
	}

	public String getPatientBPJS() {
		return patientBPJS;
	}

	public void setPatientBPJS(String patientBPJS) {
		this.patientBPJS = patientBPJS;
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

	public int getRelationID() {
		return relationID;
	}

	public void setRelationID(int relationID) {
		this.relationID = relationID;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
