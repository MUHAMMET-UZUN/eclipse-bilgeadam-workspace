package august_10_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class MainClass {

	public static void main(String[] args) {
		// ornek1();
		// ornek2();
		// ornek3();
		// ornek7();
		// replace("numan karaaslan", "la", "-");
		// System.out.println(Zip("numan karaaslan"));
		// challenge1("numan karaaslan");
		challenge2("numan karaaslan", "n", "xxx");
	}

	private static void challenge2(String text, String from, String to) {

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
					System.out.println(from.length() + " " + i + " " + text.length());
				}
				System.out.println(from.length() + " " + i + " " + text.length());
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

	private static void replaceChallenge()

	{

		String replaced = " n";
		String replacer = " n n ";
		String deger = "n numan nkaraaslan n";
		String result = "";

		for (int i = 0; i < deger.length(); i++) {

			boolean exists = true;

			for (int j = 0; j < replaced.length(); j++) {
				if (i + j == deger.length()) {
					exists = false;
					break;
				}
				if (deger.charAt(i + j) != replaced.charAt(j)) {
					exists = false;
					break;
				}
			}
			if (exists) {
				result += replacer;
				i += replaced.length() - 1;
			} else {
				result += deger.charAt(i);
			}
		}
		System.out.print(result);
	}

	private static void ornek7() {
		Stack<String> kisiler = new Stack<>();
		kisiler.push("a1");
		kisiler.push("a2");
		kisiler.push("a3");
		kisiler.push("a4");
		System.err.println(kisiler.pop());
		System.err.println(kisiler.pop());
		System.err.println(kisiler.peek());
		System.err.println(kisiler.peek());
		System.err.println(kisiler.peek());
		System.err.println(kisiler.peek());
		System.err.println(kisiler.pop());
		System.err.println(kisiler.pop());
	}

	private static void ornek3() {
		// arraylistler sıra garantisi vermez, get(0) dediğimizde mesela ilk değer
		// gelmeyebilir!
		LinkedList<Integer> sayilar = new LinkedList<>();
		sayilar.add(3);
		sayilar.add(6);
		sayilar.add(9);
		sayilar.addFirst(12);
		sayilar.addLast(15);
		// sayilar.poll();
		// sayilar.pop();
		System.out.println(sayilar);
	}

	private static void ornek2() {
		ArrayList<Integer> sayilar = new ArrayList<>();
		sayilar.add(3);
		sayilar.add(6);
		sayilar.add(9);
		// sayilar.remove(6);
		// index olarak silmeye çalışmasın diye
		sayilar.remove((Integer) 6);
		System.out.println(sayilar);
	}

	private static void ornek1() {
		String[] liste = new String[4];
		ArrayList<String> isimler = new ArrayList<String>();
		isimler.add("Ahmet");
		isimler.add("Sedanur");
		isimler.add("Furkan");
		isimler.add("Ceyda");
		Collections.sort(isimler);
		// isimler.remove("Ahmet");
		// isimler.remove(0);
		for (String isim : isimler) {
			System.err.println(isim);
		}
	}
}
