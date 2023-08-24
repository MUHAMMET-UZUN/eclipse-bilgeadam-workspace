package odev4;

public class Kedi extends Pet implements Konusabilir, Avlanabilir, Uyuyabilir, YiyipIcebilir {

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

	@Override
	public void YemekYe() {
		System.out.println("Kedi yemek yiyor");

	}

	@Override
	public void SuIc() {
		System.out.println("Kedi su içiyor");

	}

	@Override
	public void Uyu() {
		System.out.println("Kedi uyuyor");

	}

}
