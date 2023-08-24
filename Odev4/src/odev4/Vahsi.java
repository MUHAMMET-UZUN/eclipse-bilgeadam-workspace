package odev4;

public class Vahsi extends Hayvan {
	private String isim;

	public Vahsi(String isim) {
		this.isim = isim;
	}

	@Override
	public void Konus() {
		System.out.println("Hayvan konuşuyor");

	}
}
