package Kartlar;

public class BankaKarti extends Kart {

	private int bakiye;

	public BankaKarti(String sifre) {
		super(sifre);
	}

	@Override
	public void alisveris(int miktar) {
		if (this.bakiye > 0)
			this.bakiye -= miktar;
		else
			System.out.println("Bakiye yetersiz");
	}

	public void bankaKartiOzelMetod() {
		// TODO Auto-generated method stub

	}

	public int getBakiye() {
		return bakiye;
	}

	public void setBakiye(int bakiye) {
		this.bakiye += bakiye;
	}
}
