import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bilgeadam.jdbc.repository.OgretmenRepository;

public class Tests

{

	@Test

	public void asd() throws SQLException

	{

		// yazmak isterseniz testler burada

		OgretmenRepository repository = new OgretmenRepository();

		Assertions.assertTrue(repository.selectAll().size() == 6);

	}

}