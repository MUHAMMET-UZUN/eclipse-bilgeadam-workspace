package august_28;

import java.util.LinkedList;

import com.bilgeadam.jdbc.model.Konu;
import com.bilgeadam.jdbc.repository.KonuRepository;

public class MyApp {
	public static void main(String[] args) {
		KonuRepository repo = new KonuRepository();

		try {
			LinkedList<Konu> list = repo.selectAll();
			for (Konu k : list)
				System.out.println(k);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
