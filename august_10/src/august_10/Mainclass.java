package august_10;

public class Mainclass {

	public static void main(String[] args) {

		// static metodddan sadece statik mtod ve verilere erişilir
		// ornek1();
		ornek2();
	}

	private static void ornek2() {
		Person p = new Person();
		p.setIsim("berkay");
		p.setYas(34);
		Person p2 = new Person();
		p2.setIsim("feyza");
		p2.setYas(23);
		System.out.println(p.getYas() + " " + p.getIsim());
		System.out.println(p2.getYas() + " " + p2.getIsim());

	}

//	private static void ornek1() {
//		Person p = new Person();
//		p.setIsim("Elif");
//		p.setYas(34);
//		System.out.println(p.getYas() + " " + p.getIsim());
//		Person.yas = 23;
//		System.out.println(p.getYas() + " " + p.getIsim());
//	}
}

class LEVEL

{
	// new yapmak mantıksız olacaktır
	public static final Integer HIGH_LEVEL = 1;
	public static final Integer MEDIUM_LEVEL = 2;
	public static final Integer LOW_LEVEL = 3;
}

class Person {
	// staticler class lara yapışıktır
	private static int yas;
	private String isim;

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	/*
	 * static { // }
	 */
}
