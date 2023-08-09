package classes;

import java.util.Scanner;

public class Classes {

	public static void main(String[] args) {
		
		Person p = new Person();
		
	}
	
	

}

class Person
{
	private Integer yas;
	private String isim;
	
	public Person() 
	{
		System.out.println(Konus("Ben geldim"));
	}
	
	public String Konus(String mesaj)
	{
		return "Merhaba " + mesaj;
	}
}
