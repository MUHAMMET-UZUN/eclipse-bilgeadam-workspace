package classes;

import com.bilgeadam.model.Person;

public class Classes {
	
	public static void main(String[] args)
	{
		ornek3();
	}

	private static void ornek1()
	{
	Integer temp = 4;
	doStuff(temp);
	System.err.println(temp);
	}

	public static void doStuff(Integer sayi)
	{
	sayi = sayi + 1;
	sayi = null;
	}

	private static void ornek2()

	{
	String konu = "Java";
	ekle(konu);
	System.err.println(konu);
	}
	 
	public static void ekle(String isim)
	{
	isim += " 101";
	isim = isim.replace("J", "H");
	//isim = null;
	System.err.println(isim);
	}


	private static void ornek3()
	{
	Person p = new Person();
	p.isim = "Tuğçe";
	System.err.println(p.isim);
	doStuff(p);
	System.err.println(p.isim);
	}

	private static void doStuff(Person p)
	{
	p.isim = "Numan";
	p = new Person("Onur");
	// p = new Person();
	}




}

