package odev4;

public class Kopek extends Pet {

	public Kopek(String isim) {
		super(isim);
	}

	@Override
	public void Konus() {
		System.out.println("Hav hav hav!");
	}

	@Override
	public void Avlan() {
		System.out.println("Köpek kedi avlıyor");
	}

}
