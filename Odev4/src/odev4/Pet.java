package odev4;

public abstract class Pet extends Hayvan {
	private String isim;

	public Pet(String isim) {
		this.isim = isim;
	}

	@Override
	public void Konus() {
		System.out.println("Hayvan konuşuyor");

	}
}
