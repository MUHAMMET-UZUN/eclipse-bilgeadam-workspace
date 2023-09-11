package com.bilgeadam.jdbc.model;

public class Ogrenci {
	private long ID;
	private String NAME;
	private long OGR_NUMBER;
	private long YEAR;

	public Ogrenci() {

	}

	public Ogrenci(long ID, String NAME, long OGR_NUMBER, long YEAR) {
		this.ID = ID;
		this.NAME = NAME;
		this.OGR_NUMBER = OGR_NUMBER;
		this.YEAR = YEAR;
	}

	@Override
	public String toString() {
		return "Ogrenci [ID=" + ID + ", NAME=" + NAME + ", OGR_NUMBER=" + OGR_NUMBER + ", YEAR=" + YEAR + "]";
	}

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	public long getOGR_NUMBER() {
		return OGR_NUMBER;
	}

	public void setOGR_NUMBER(long OGR_NUMBER) {
		this.OGR_NUMBER = OGR_NUMBER;
	}

	public long getYEAR() {
		return YEAR;
	}

	public void setYEAR(long YEAR) {
		this.YEAR = YEAR;
	}
}
