package august_18;

import Kartlar.BankaKarti;
import Kartlar.Kart;
import Kartlar.KrediKarti;
import Kartlar.PlatinKart;

public class MainClass {

	public static void main(String[] args) {
		// ornek1();
		// ornek2();
		// ornek3();

		// ornek5();
		// ornek6();
		ornek7();
	}

	private static void ornek7() {
		// upcasting
		BankaKarti bkart = new BankaKarti("");
		Kart krt = bkart;
		// aşağıdaki çalışmaz
		KrediKarti kkart = (KrediKarti) krt;
	}

	private static void ornek6() {
		// genelde class ların özel metodlarının kullanırken gerekebilir
		Kart returnType = doStuff4(2);
		if (returnType.getClass() == KrediKarti.class) {
			KrediKarti kkart = (KrediKarti) returnType;
			kkart.kredikartiOzelMetod();
		}
		if (returnType.getClass() == BankaKarti.class) {
			BankaKarti bkart = (BankaKarti) returnType;
			bkart.bankaKartiOzelMetod();
		}

		if (returnType.getClass() == PlatinKart.class) {
			KrediKarti pkart = (PlatinKart) returnType;
		}
	}

	private static Kart doStuff4(int sayi) {
		// TODO Auto-generated method stub
		if (sayi == 1) {
			return new Kart("");
		}
		if (sayi == 2) {
			return new BankaKarti("");
		}
		return null;
	}

	private static void ornek5() {
		Kart kart = new KrediKarti("");
		BankaKarti bKart = (BankaKarti) kart;

	}

	private static void ornek3() {
		var deger = new Integer(45);
		deger = null;
		doStuff3(deger);

	}

	private static void doStuff3(int sayi) {
		if (sayi > 4)
			System.out.println("asdas");

	}

	private static void ornek2() {
		Integer sayi = null;
		doStuff1(sayi);
	}

	private static void doStuff1(int i) {
		// null kontrolü yapılamaz
		if (i > 4)
			System.out.println(i);

	}

	private static void doStuff2(Integer i) {
		if (i != null && i > 4) {
			System.out.println(i);
		}

	}

	private static void ornek1() {
		Integer sayi = 5;
		int sayip = new Integer(5);
		sayi = null;
		// sayip = null;
	}

}
