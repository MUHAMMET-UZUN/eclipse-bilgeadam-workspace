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

	}

	// zip challenge
	// numankaraaslan -> numakrsl

	// numan karaaslan
	// num-- karaasl--

	// numan karaaslan
	// num- karaasl-

	// numan karaaslan
	// xxxumaxxx- karaaslaxxx

	private static String replace(String text, String from, String to) {
		String newOutput = "";
		
		for (int i = 0; i < text.length(); i++) {
			
			if(text.charAt(i) == from.charAt(i))
			{
				for(int j =0; j<from.length();j++)
				{
					if(text.charAt(i+j) == from.charAt(j))
				}
			}
			else
				newOutput +=text.charAt(i);
		}
		return newOutput;
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
