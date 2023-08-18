package esya;

public class BulasikMakinasi extends BeyazEsya implements Yikayabilir, SuKullanabilir {

	@Override
	public double fiyatlama() {
		return 100;
	}

	@Override
	public void sukullan() {

	}

	public void tabletKullan() {

	}

	@Override
	public void Yikama() {

	}

	@Override
	public void EnerjiVerimliliğiBilgisi() {
		System.out.println("Çok verimli");
	}

}
