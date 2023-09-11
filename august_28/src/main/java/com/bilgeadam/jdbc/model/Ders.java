package com.bilgeadam.jdbc.model;

public class Ders {
	private long ID;
	private long OGR_ID;
	private long KONU_ID;

	public Ders(long iD, long ogrId, long konuId) {
		super();
		ID = iD;
		OGR_ID = ogrId;
		KONU_ID = konuId;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public long getOGR_ID() {
		return OGR_ID;
	}

	public void setOGR_ID(long oGR_ID) {
		OGR_ID = oGR_ID;
	}

	public long getKONU_ID() {
		return KONU_ID;
	}

	public void setKONU_ID(long kONU_ID) {
		KONU_ID = kONU_ID;
	}
}
