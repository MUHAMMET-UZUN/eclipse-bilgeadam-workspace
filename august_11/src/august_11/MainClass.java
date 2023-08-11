package august_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Objects;

public class MainClass {

	public static void main(String[] args) {
		// ornek8();
		// ornek9();
		// ornek10();
		// ornek11();
		// ornek12();
		// ornek13();
		ornek14();

	}

	private static void ornek14() {
		HashMap<Person, Vehicle> map = new HashMap<>();

		// furkanın arabası nedir sorusunun cevabı
		map.put(new Person("furkan", 1), new Vehicle("audi"));
		map.put(new Person("seyyit", 2), new Vehicle("audi"));
		map.put(new Person("furkan", 1), new Vehicle("mercedes"));
		map.put(new Person("numan", 3), new Vehicle("mercedes"));

		for (Entry<Person, Vehicle> entry : map.entrySet()) {
			System.out.println(entry.getKey().getName() + entry.getKey().getNumber());
			System.out.println(entry.getKey().getName() + " in arabası " + entry.getValue().getIsim());
		}
	}

	private static void ornek13() {

		HashSet<Person> kisiler = new HashSet<>();
		kisiler.add(new Person("elif", 1));
		kisiler.add(new Person("furkan", 2));
		kisiler.add(new Person("hikmet", 3));
		kisiler.add(new Person("furkan", 2));
		System.out.println(kisiler);
	}

	private static void ornek12() {
		ArrayList<Person> kisiler = new ArrayList<>();
		kisiler.add(new Person("beyza", 1));
		kisiler.add(new Person("onur", 2));
		kisiler.add(new Person("muhammet", 3));
		System.out.println(kisiler);
		kisiler.remove(new Person("onur", 2));
		System.out.println(kisiler);
		// ArrayList<Person> temp = new ArrayList<>();
		/*
		 * for (Person person : kisiler) { if (person != p) { continue; }
		 * temp.add(person); }
		 */
		// System.out.println(kisiler);
	}

	private static void ornek11() {

		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("id", 1);
		map.put("isim", "Beyza");
		map.put("numara", 100);

		LinkedHashMap<String, Object> map2 = new LinkedHashMap<>();
		map2.put("id", 2);
		map2.put("isim", "Tuğçe");
		map2.put("numara", 200);

		// db den select ile geldi varsayabiliriz
		LinkedList<HashMap<String, Object>> kisiler = new LinkedList<>();
		kisiler.add(map);
		kisiler.add(map2);

		for (HashMap<String, Object> hashMap : kisiler) {
			for (Entry<String, Object> entry : hashMap.entrySet()) {
				System.out.print(entry.getKey() + " - " + entry.getValue() + " ");
			}
			System.out.println();
		}
	}

	private static void hocaOrnek11() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("id", 1);
		map.put("isim", "beyza");
		map.put("numara", 100);
		LinkedHashMap<String, Object> map2 = new LinkedHashMap<>();
		map2.put("id", 2);
		map2.put("isim", "tuğçe");
		map2.put("numara", 200);
		// veritabanından select ile geldi farz edebiliriz
		LinkedList<HashMap<String, Object>> kisiler = new LinkedList<>();
		kisiler.add(map);
		kisiler.add(map2);
		System.err.println(kisiler);

	}

	/*
	 * private static void ornek10() { HashMap<Integer, Person> kisiler = new
	 * HashMap<>(); kisiler.put(1, new Person("beyza", 100)); kisiler.put(2, new
	 * Person("tuğçe", 100)); kisiler.put(3, new Person("ceyda", 100));
	 * 
	 * for (Entry<Integer, Person> pair : kisiler.entrySet()) {
	 * System.out.println(pair); } }
	 */

	private static void ornek9() {
		HashMap<Integer, String> map = new HashMap<>();

		map.put(1, "ceyda");
		map.put(2, "elif");
		map.put(3, "tuğçe");
		map.put(2, "banu");
		map.remove(1);
		System.out.println(map);
	}

	private static void ornek8() {
		HashSet<String> isimler = new HashSet<>();
		isimler.add("numan");
		isimler.add("numan");
		isimler.add("numan");
		isimler.add("onur");
		isimler.add("muhammet");
		isimler.add("onur");

		for (String isim : isimler)
			System.out.println(isim);
	}

}

class Person {

	private String name;
	private Integer number;

	public Person(String name, Integer number) {
		this.number = number;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

//	@Override
//	public int hashCode() {
//	return Objects.hash(name, number);
//	}

	@Override
	public int hashCode() {
		return Objects.hash(name, number);
	}

	@Override
	public boolean equals(Object obj) {
		// referansları değil içerikleri karşılaştırmak için
		Person other = (Person) obj;
		return Objects.equals(this.name, other.getName()) && Objects.equals(this.number, other.getNumber());
	}

}

class Vehicle {
	private String isim;

	public Vehicle(String isim) {
		this.isim = isim;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}
}
