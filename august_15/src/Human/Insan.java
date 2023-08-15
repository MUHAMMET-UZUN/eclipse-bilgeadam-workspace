package Human;

public abstract class Insan {
	private String isim;
	private double boy;

	public Insan(String isim, double boy) {
		this.isim = isim;
		this.boy = boy;
	}

	public void normalMetod() {
		System.err.println("sdf");
	}

	// abstract metod sadece abstract classlarda yazılır
	// abstract olmayanların override zorunluluğu yoktur
	public abstract void konus(String mesaj);
}
