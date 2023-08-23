package FileOps;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// ornek1();
		ornek2();
	}

	private static void ornek2() throws IOException {
		java.io.File file = new File(URI.create("C:/users/UMAMI/Desktop/dosya.txt"));
		FileReader reader = new FileReader(file);
		// char[] cbuf = new char[(int) (file.length() / 5];
		char[] cbuf = new char[10];
		reader.read(cbuf);
		for (int i = 0; i < cbuf.length; i++) {
			System.out.println(cbuf[i]);
		}

	}

	private static void ornek1() throws IOException {
		// uri ile verilebilir
		java.io.File file = new File("C:\\users\\UMAMI\\Desktop\\dosya.txt");
		FileReader reader = new FileReader(file);
		System.out.print("<");
		while (reader.ready()) {
			System.out.print((char) reader.read());
		}
		System.out.println(">");
	}

}
