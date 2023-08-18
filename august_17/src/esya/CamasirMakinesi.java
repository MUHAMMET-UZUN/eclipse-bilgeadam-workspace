package esya;

public class CamasirMakinesi extends BeyazEsya implements Sikabilir, Yikayabilir, SuKullanabilir {

	@Override
	public double fiyatlama() {
		return 100;
	}

	@Override
	public void EnerjiVerimliliğiBilgisi() {
		System.out.println("Çok verimli");

	}

	@Override
	public void Sikma() {

	}

	@Override
	public void Yikama() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sukullan() {
		// TODO Auto-generated method stub

	}

}
