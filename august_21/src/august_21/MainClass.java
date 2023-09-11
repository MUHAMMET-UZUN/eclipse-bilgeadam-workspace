package august_21;

public class MainClass {
	public static void main(String[] args) {
		ornek8();
	}

	private static void ornek8() {
		// checked exception fırlatan bir metod mutlaka try catch içine alınmalıdır
		try {
			// FileReader reader = new ("asd");
			islem();
		} catch (ArithmeticException e) {

		}
	}

	public static void islem() { // 1.41 de kaldın
		int k = 7 / 0;
	}
}
