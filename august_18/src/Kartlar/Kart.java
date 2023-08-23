package Kartlar;

public class Kart {
	protected String kartNo;
	private String sifre;
	// private final String bankaIsmi;

	public Kart(String sifre/* , String bankaIsmi */) {
		this.sifre = sifre;
		// this.bankaIsmi = bankaIsmi;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getKartNo() {
		return kartNo.substring(3, 5) + "xxxx";
	}

	public void setKartNo(String kartNo) {
		this.kartNo = kartNo;
	}

	public void alisveris(int miktar) {
		System.out.println("Kart sınıfı extend ederek kullanılır");
	}

}
