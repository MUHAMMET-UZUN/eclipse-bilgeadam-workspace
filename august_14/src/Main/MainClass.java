package Main;

import Abstraction.Vehicle;
import Immutability.Person;
import Immutability.Phone;

public class MainClass {

	public static void main(String[] args) {
		// ornek1();
		ornek2();
	}

	private static void ornek2() {
		Person p = new Person(new Phone("iphone"), "12312");
		System.err.println(p.getPhone().getModel());
		p.getPhone().setModel("android");
		System.err.println(p.getPhone().getModel());
	}

	private static void ornek1() {
		// çok kötü bir abstrraction örneği
		Vehicle v = new Vehicle();
		v.setLastikSayisi(4);
		v.setLastikHavasi(true);
		v.koybenzin(3);
		v.git();
	}

}
