package esya;

public class Mobilya implements Esya {
	private int tur;

	public void ahsapTuru() {
		System.out.println("bla bla");
	}

	public void setTur(int tur) {
		this.tur = tur;
	}

	@Override
	public double fiyatlama() {

		return tur * 10;
	}

}
