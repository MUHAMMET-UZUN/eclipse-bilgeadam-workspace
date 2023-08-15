package Human;

public class Kadin extends Insan {
	public Kadin(String isim, double boy) {
		super(isim, boy);
	}

	@Override
	public void konus(String mesaj) {
		System.out.println("Kadın konuşuyor");
	}
}
