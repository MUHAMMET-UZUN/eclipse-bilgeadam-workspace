package Immutability;

public final class Person
{
	// immutable için
	// 1. değişken private olacak
	// 2. setter metod yazılmayacak
	// 3. değişken final olacak
	// 4. class final olabilir

	private final String TCkimlik;
	private final Phone phone;

	public Person(Phone phone, String tCkimlik)
	{
		this.phone = phone;
		this.TCkimlik = tCkimlik;
	}

	public Phone getPhone()
	{
		return phone;
	}

	public String getTCkimlik()
	{
		// TCkimlik = "asdasd";
		return TCkimlik;
	}

//	public void setTCkimlik(String tCkimlik)
//	{
//		TCkimlik = tCkimlik;
//	}
}