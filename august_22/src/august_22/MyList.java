package august_22;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class MyList extends ArrayList<Integer> {

	@SuppressWarnings("null")
	@Override
	public boolean add(Integer e) {
		try {
			String temp = null;
			if (temp.equals("asd")) {
				System.out.println("asd");
			}
		} catch (Exception ex) {

		}
		if (e > 5)
			return super.add(e);

		else
			return false;
	}

	@Deprecated(since = "V3", forRemoval = true) // bu metodun mesela 3. versiondan sonra kullanılmamasını izah ediyor
	@Override
	public void add(int index, Integer element) {
		super.add(index, element);
	}

}