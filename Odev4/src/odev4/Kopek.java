package odev4;

public class Kopek extends Vahsi implements Konusabilir, Avlanabilir, YiyipIcebilir {

	public Kopek(String isim) {
		super(isim);
	}

	@Override
	public void Konus() {
		System.out.println("Hav hav hav!");
	}

	@Override
	public void YemekYe() {
		System.out.println("Köpek yemek yiyor");

	}

	@Override
	public void SuIc() {
		System.out.println("Köpek su içiyor");

	}

	@Override
	public void Avlan() {
		System.out.println("Köpek avlanıyor");

	}

}
