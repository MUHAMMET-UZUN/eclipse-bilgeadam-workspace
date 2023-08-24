package odev4;

public abstract class Hayvan {

	public void YemekYe() {
		System.out.println("Hayvan yemek yiyor");
	}

	public void SuIc() {
		System.out.println("Hayvan su içiyor");
	}

	public void Uyu() {
		System.out.println("Hayvan uyuyor");
	}

	public void Avlan() {
		System.out.println("Hayvan avlanıyor");
	}

	public abstract void Konus();

}
