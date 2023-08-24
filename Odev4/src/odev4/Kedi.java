package odev4;

public class Kedi extends Pet {

	public Kedi(String isim) {
		super(isim);
	}

	@Override
	public void Konus() {
		System.out.println("Miyaaav");
	}

	@Override
	public void Avlan() {
		System.out.println("Kedi fare avlıyor");
	}

}
