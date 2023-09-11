package august_23;

public class MainClass {
	public static void main(String[] args) {
		// ornek1();
		ornek2();

	}

	private static void ornek2() {
		System.err.println("Merhaba err 1");
		System.err.println("Merhaba err 2");
		System.err.println("Merhaba err 3");
		System.out.println("Merhaba out 1");
		System.out.println("Merhaba out 2");
		System.out.println("Merhaba out 3");
	}

	private static void ornek1() {
		new Thread(new Runnable()

		{
			@Override
			public void run() {
				System.err.println("merhaba thread");
			}
		}).start();
	}
}
