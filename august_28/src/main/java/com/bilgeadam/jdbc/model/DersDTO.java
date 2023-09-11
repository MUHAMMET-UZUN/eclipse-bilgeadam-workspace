package com.bilgeadam.jdbc.model;

public class DersDTO {

	private Ogretmen ogretmen;
	private Konu konu;

	public DersDTO(Ogretmen ogretmen, Konu konu) {
		super();
		this.ogretmen = ogretmen;
		this.konu = konu;
	}

	@Override
	public String toString() {
		return "DersDTO [ogretmen=" + ogretmen + ", konu=" + konu + "]";
	}

}
