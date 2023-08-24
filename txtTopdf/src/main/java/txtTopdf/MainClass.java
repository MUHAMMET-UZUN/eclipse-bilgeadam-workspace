package txtTopdf;

import java.io.IOException;

import com.aspose.words.Document;

public class MainClass {
	public static void main(String[] args) throws Exception {

		String dosyaYolu = "dosya.txt"; // Okunacak dosyanın yolu

		try {

			Document doc = new Document(dosyaYolu);
			doc.save("Output.pdf");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
