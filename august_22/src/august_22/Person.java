package august_22;

@CustomLog(level = 1)
public class Person {

	private int yas;
	@CustomLog(level = 2)
	private String isim;

	// public Person(int yas, String isim) {
	// super();
	// this.yas = yas;
	// this.isim = isim;
	// }

	public Person() {
		System.out.println("new yapılıyor");
	}

	@CustomLog(level = 3)
	private int getYas() {
		return yas;
	}

	public void setYas(Integer yas) {
		this.yas = yas;
	}

	public String getIsim() {
		return isim;
	}

	@CustomLog(level = 2)
	public void setIsim(String isim) {
		this.isim = isim;
	}

}
