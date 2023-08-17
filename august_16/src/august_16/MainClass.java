package august_16;

import java.util.ArrayList;
import java.util.List;

import Insan.AskereGider;
import Insan.Erkek;
import Insan.Human;
import Insan.Kadin;

public class MainClass {

	public static void main(String[] args) {
		// ornek1();
		ornek2(new Erkek());
		ornek2(new Kadin());
	}

	private static void ornek2(Human h) {
		h.konus();
		List<String> liste = new ArrayList<>();
		liste.add("sadsad");
	}

	private static void ornek1() {
		Human k = new Erkek();
		if (k instanceof Erkek) {
			System.out.println("true");
		}
		if (k instanceof AskereGider) {
			System.out.println("true");
		}
	}

}
