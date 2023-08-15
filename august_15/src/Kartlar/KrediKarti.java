package Kartlar;

public class KrediKarti extends Kart {

	private int limit;

	public KrediKarti(String sifre) {
		super(sifre);
		super.setSifre("sa");
		System.out.println("kredi kartı new");
	}

	@Override
	public void alisveris(int miktar) {
		if (limit < 50000)
			this.limit += miktar;
		else
			System.out.println("Limit yetersiz");
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
