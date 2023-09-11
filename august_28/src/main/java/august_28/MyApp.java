package august_28;

import java.sql.SQLException;

import com.bilgeadam.jdbc.repository.DersOgrenciRepository;
import com.bilgeadam.jdbc.repository.DersRepository;
import com.bilgeadam.jdbc.repository.KonuRepository;
import com.bilgeadam.jdbc.repository.OgrenciRepository;
import com.bilgeadam.jdbc.repository.OgretmenRepository;

public class MyApp {
	public static void main(String[] args) throws SQLException {
		static KonuRepository konuRepository = new KonuRepository();
		static OgretmenRepository ogretmenRepository = new OgretmenRepository();
		static DersRepository dersRepository = new DersRepository();
		static OgrenciRepository ogrenciRepository = new OgrenciRepository();
		static DersOgrenciRepository dersOgrenciRepository = new DersOgrenciRepository();

		ogretmenRepository.insert("berkay", false);
		System.out.println(ogretmenRepository);
	}
}
