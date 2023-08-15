package august_15;

import Human.Insan;
import Kartlar.BankaKarti;
import Kartlar.Kart;
import Kartlar.KrediKarti;
import Kartlar.PlatinKart;

public class MainClass {

	public static void main(String[] args) {
		// ornek1();
		// ornek2();
		// ornek3();
		// ornek4();
		ornek5();

	}

	private static void ornek5() {
		// abstract sınıflar new yapılamaz
		// görünmeyen bir extension, anonymous class
		Insan insan = new Insan("", 30) {

			@Override
			public void konus(String mesaj) {
				System.out.println("İnsan konuşuyor");

			}
		};

	}

	private static void ornek4() {
		// doStuff3();

	}

	enum KartTypes {
		KART, BKART, KKART
	}

	private static void doStuff3(KartTypes kartType) {
		switch (kartType) {
		case BKART:
			System.out.println("Banka");
			break;
		case KKART:
			System.out.println("Kredi");
			break;
		case KART:
			System.out.println("Kart");
			break;
		}
	}

	private static void ornek3() {
		doStuff2(new PlatinKart(""));

	}

	private static void doStuff2(KrediKarti kart) {
//kendisi ve aşağısı
	}

	private static void ornek2() {
		// >= ilişkisi
		Kart krt = new BankaKarti("");
		doStuff(krt);
	}

	private static void doStuff(Kart krt) {
		// aşağıdan yukarılara bakılmalı
		if (krt instanceof BankaKarti) {

		}
		if (krt instanceof KrediKarti) {

		}
		if (krt instanceof PlatinKart) {

		}
		if (krt instanceof Kart) {

		}
	}

	private static void ornek1() {
		BankaKarti bKart = new BankaKarti("");
		bKart.setKartNo("1121234");
		System.out.println(bKart.getKartNo());
		KrediKarti kKart = new KrediKarti("");
		kKart.setKartNo("1123123");
		System.out.println(kKart.getKartNo());
		PlatinKart pKart = new PlatinKart("");
		pKart.alisveris(123123);
	}

}
