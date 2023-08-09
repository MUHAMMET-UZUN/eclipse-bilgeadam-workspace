package com.bilgeadam.model;

public class Person
{
	Integer yas;
	public String isim;
	
	public void setYas(Integer yas) {
		this.yas = yas;
	}
	public Integer getYas() {
		return yas;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getIsim() {
		return isim;
	}
	
	public Person()
	{
		isim="yok";
		yas=1;
	}
	
	public Person(String isim) 
	{
		this.isim = isim;
		yas = 1;
	}
	
	
	/**
	 * @param mesaj
	 * ekrana yazdırılacak olan mesaj
	 * @param sayi
	 * kaç kere yazacağı
	 * @return
	 * örnek
	 */
	public String Konus(String mesaj,int sayi)
	{
		for(int i =0; i<sayi;i++)
			System.out.println(mesaj);
		return "Merhaba " + mesaj;
	}

	public String Konus(String mesaj)
	{
		System.out.println("Merhaba " + mesaj);
		return "Merhaba " + mesaj;
	}
}