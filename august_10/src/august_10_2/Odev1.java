package august_10_2;

public class Odev1 {

	public static void main(String[] args) {
		// replace("numan karaaslan ", "a", "--");
		System.out.println(Zip("numan karaaslan"));
		// challenge1("numan karaaslan");

	}

	private static void challenge1(String text) {

		String[] temp = text.split(" ");

		for (int i = 0; i < temp.length; i++) {

			for (int j = 0; j < temp[i].length() - 2; j++) {

				System.out.print(temp[i].charAt(j));
			}
			System.out.print("-- ");
		}

	}

	// zip challenge
	// numankaraaslan -> numakrsl

	// numan karaaslan
	// num-- karaasl--

	// numan karaaslan
	// num- karaasl-

	// numan karaaslan
	// xxxumaxxx- karaaslaxxx

	private static String Zip(String text) {
		String temp = "";

		for (int i = 0; i < text.length(); i++) {
			if (CheckIfExist(text, i)) {
				continue;
			}
			temp += text.charAt(i);
		}

		return temp;
	}

	private static boolean CheckIfExist(String text, int index) {
		for (int i = 0; i < index; i++) {
			if (text.charAt(i) == text.charAt(index))
				return true;
		}
		return false;
	}

	private static void replace(String text, String from, String to) {
		String newOutput = "";
		int i = 0;
		// tüm textin indis sayısı kadar döngü oluşturuyoruz
		for (; i < text.length(); i++) {
			// eğer değiştireceğiiz kelimenin ilk harfini bulduysak sorguya giriyoruz
			// tüm texti değiştireceğimiz kelimenin ilk harfini bulana kadar döndürüyoruz
			if (text.charAt(i) == from.charAt(0)) {
				// eğer ilk harf ve sonrasındaki tüm harfler uyuşuyorsa eşitlik değişkenini
				// ayarlıyoruz
				// döngüde j yi i nin kaldığı yerden başlatıyoruz. i nin başladığı yerden
				// değiştireceğimiz kelimenin uzunluğu kadar döngüyü sürdüreceğiz
				// mesela değiştireceğimiz kelimenin ilk harfini 3. indiste bulduysak 3. indisi
				// j y everiyoruz
				// 3. indisin yanında aradığımız kelimenin ilk harfine karşılık geldiğinden 0
				// dan başlayan ayrı bir değişkenle ikisinin de eşitliğini sorguluyoruz
				if (CheckIsEqual(text, from, i)) {
					newOutput += to;
					i += from.length();
					// System.out.println(from.length() + " " + i + " " + text.length());
				}
				// System.out.println(from.length() + " " + i + " " + text.length());
			}
			newOutput += text.charAt(i);
		}
		System.out.println(newOutput);
	}

	private static boolean CheckIsEqual(String text, String from, int index) {
		int j = index;
		int k = 0;
		for (; j < from.length() + index; j++) {
			if (text.charAt(j) != from.charAt(k++)) {
				return false;
			}
		}
		return true;
	}

}
