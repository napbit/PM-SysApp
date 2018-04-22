package com.binus.pmsys.entity;

public class Staff {
	
	private int sID;
	private String sJabatan;
	private String sKTP;
	private String sName;
	private String sUsername;
	private String sDOB;
	private String sGender;
	private Address sAddress;
	
	public Staff() { }
	
	public Staff(Staff s) {
		setsID(s.getsID());
		setsJabatan(s.getsJabatan());
		setsKTP(sKTP);
		setsName(s.getsName());
		setsUsername(s.getsUsername());
		setsDOB(s.getsDOB());
		setsGender(s.getsGender());
		sAddress = new Address(s.getsAddress());
	}
	
	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}

	public String getsJabatan() {
		return sJabatan;
	}

	public void setsJabatan(String sJabatan) {
		this.sJabatan = sJabatan;
	}

	public String getsKTP() {
		return sKTP;
	}

	public void setsKTP(String sKTP) {
		this.sKTP = sKTP;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsUsername() {
		return sUsername;
	}

	public void setsUsername(String sUsername) {
		this.sUsername = sUsername;
	}

	public String getsDOB() {
		return sDOB;
	}

	public void setsDOB(String sDOB) {
		this.sDOB = sDOB;
	}

	public String getsGender() {
		return sGender;
	}

	public void setsGender(String sGender) {
		this.sGender = sGender;
	}

	public Address getsAddress() {
		return sAddress;
	}

	public void setsAddress(Address sAddress) {
		this.sAddress = sAddress;
	}

}
