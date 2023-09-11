package august_11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

/*
Konsoldan girilen string içerisinde hangi harften kaç tane bulunduğunu sıralı bir şekilde yazmak, map kullanarak
Örnek: numan -> n2u1m1a1
Numan karaaslan n3u1m1a5 1k1r1s1l1


Konsoldan girilen ifadeyi zipleyip harfleri listeye atmak (map ve arraylist ile)
Örnek: numankaraaslan -> numakrsl
*/

public class Odev2 {

	public static void main(String[] args) {

		ornek1();
		// ornek2();
	}

	private static void ornek2() {
		HashSet<String> zippedString = new LinkedHashSet<>();
		int i;
		String text = "numan karaaslan";

		for (i = 0; i < text.length(); i++) {
			zippedString.add(text.charAt(i) + "");
		}
		Object[] zippedChar = zippedString.toArray();

		for (i = 0; i < zippedChar.length; i++) {
			System.out.print(zippedChar[i].toString());
		}
	}

	// HashMap in sıra garantisi yok, LinkedHashMap ile sıralı bir şekilde işlem
	// yapılabilir
	private static void ornek1() {
		HashMap<String, Integer> zippedString = new LinkedHashMap<>();
		int i;
		String text = "numan karaaslan";

		for (i = 0; i < text.length(); i++) {
			if (zippedString.containsKey(text.charAt(i) + "")) {
				Integer temp = zippedString.get(text.charAt(i) + "");
				temp++;
				zippedString.put(text.charAt(i) + "", temp);
			} else
				zippedString.put(text.charAt(i) + "", 1);
		}
		for (Entry<String, Integer> karakterler : zippedString.entrySet()) {
			System.out.print(karakterler.getKey() + karakterler.getValue());
		}
	}
}