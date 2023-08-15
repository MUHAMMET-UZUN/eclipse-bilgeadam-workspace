package Encapsulation;

public class Person
{
	// sadece private yaptım diye encapsulation oldu diyemeyiz bence

	private int yas;
	private boolean cinsiyet;

	public void setCinsiyet(boolean cinsiyet)
	{
		this.cinsiyet = cinsiyet;
	}

	public boolean isCinsiyet()
	{
		// true ise kadın olsun
		return cinsiyet;
	}

	public int getYas()
	{
		return cinsiyet ? yas - 1 : yas + 1;
	}

	public void setYas(int yas)
	{
		this.yas = yas;
	}
}