package Abstraction;

public class Vehicle
{
	private int lastikSayisi;
	private boolean lastikHavasi;
	private double benzinMiktari;

//	public Vehicle(int lastikSayisi, boolean lastikHavasi, double benzinMiktari)
//	{
//		this.lastikSayisi = lastikSayisi;
//		this.lastikHavasi = lastikHavasi;
//		this.benzinMiktari = benzinMiktari;
//	}

	// public void git(int lastikSayisi, boolean lastikHavasi, double benzinMiktari)
	public void git()
	{
		if (lastikSayisi != 4)
		{
			System.err.println("4 adet lastik olmalıdır");
			return;
		}
		if (!lastikHavasi)
		{
			System.err.println("Lastiklerin havası yok");
			return;
		}
		if (benzinMiktari == 0.0)
		{
			System.err.println("Benzin yoktur");
			return;
		}
		System.err.println("Araç gidiyor");
	}

	public void setLastikSayisi(int lastikSayisi)
	{
		this.lastikSayisi = lastikSayisi;
	}

	public void setLastikHavasi(boolean lastikHavasi)
	{
		this.lastikHavasi = lastikHavasi;
	}

	public void koybenzin(double benzinMiktari)
	{
		if (this.benzinMiktari > 50)
		{
			System.err.println("Benzin full zaten");
			return;
		}
		this.benzinMiktari += benzinMiktari;
	}

	public int getLastikSayisi()
	{
		return lastikSayisi;
	}

	public boolean isLastikHavasi()
	{
		return lastikHavasi;
	}

	public double getBenzinMiktari()
	{
		return benzinMiktari;
	}
}