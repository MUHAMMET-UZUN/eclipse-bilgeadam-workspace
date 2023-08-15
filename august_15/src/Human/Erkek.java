package Human;

public class Erkek extends Insan {
	public Erkek(String isim, double boy) {
		super(isim, boy);
	}

	@Override
	public void konus(String mesaj) {
		System.out.println("Erkek konuşuyor");
	}
}
