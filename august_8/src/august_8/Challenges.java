package august_8;

public class Challenges {

	public static void main(String[] args)
	{
	//Challenge-1////////////////////////////////////////
	//System.out.println(StringReplace("Numan Karaaslan"));
		
	//Challenge-2////////////////////////////////////////
	//ArrayFlip1();
		
	//Challenge-3////////////////////////////////////////
	//removeRedundant("abbccc  xxddddeeeee",4);
		
	//Challenge-4////////////////////////////////////////
	//charCounter();
		
	//Challenge-5////////////////////////////////////////
	//charCounterAlternative();
	}
	
	private static String StringReplace(String text)
	{
		text.toLowerCase();
		char[] temp = text.toCharArray();
		
		for(int i = 0; i<temp.length;i++)
		{
			if(temp[i] == 'a')
				temp[i] = '2';
			else if(temp[i] == 'u')
				temp[i] = '7';
		}
		
		text = temp.toString();
		
		return new String(temp);
	}

	private static void ArrayFlip1()
	{
		//1 2 3 -> 9 8 7//
		//4 5 6 -> 6 5 4//
		//7 8 9 -> 3 2 1//
		
		int[][] dizi = new int[][]{ 
				new int[]{1,2,3},
				new int[] {4,5,6},
				new int[] {7,8,9} 
				};
			
		for(int i=0; i<dizi.length; i++)
		{
			for(int j=0; j<dizi[i].length; j++)
			{
				System.err.print(dizi[dizi.length - i - 1][dizi[i].length - j - 1] + " ");
			}
			System.err.println();
		}
	}

	private static void removeRedundant(String isim, int adet)
	{
	// abbcccddddeeeee, 4 -> abbcc

		String sonuc = " ";

		for (int i = 0; i < isim.length(); i++) {
		    char harf = isim.charAt(i);
		    int sayac = 0;

		        for (int j = 0; j < isim.length(); j++) {
		            if (isim.charAt(j) == harf) {
		                sayac++;
		            }
		        }

		    if (sayac < adet) {
		        sonuc += harf;
		    }

		}



		System.out.println(" " + sonuc);
	}

	private static void charCounter()
	{
	// numan karaaslan
	// n3u1m1a5 1k1r1s1l1
		String isim = "numan karaaslan";
		String bakilanKarakterler = "";
		for(int i =0; i<isim.length(); i++)
		{if(bakilanKarakterler.contains(isim.charAt(i)+""))
		{
			continue;
		}
			int sayac = 0;
			for(int j=0; j<isim.length(); j++)
			{
				sayac += isim.charAt(i) == isim.charAt(j) ? 1 : 0;
			}
			bakilanKarakterler += isim.charAt(i);
			System.out.print(isim.charAt(i) + "" + sayac);
		}
	}
	
	private static void charCounterAlternative()
	{
	// numan karaaslan
	// n3u1m1a5 1k1r1s1l1
		String isim = "numan karaaslan";
		
		for(int i =0; i<isim.length(); i++)
		{
			if(CheckIfExists(isim,i))
			{
				continue;
			}
			
			int sayac = 0;
			for(int j=0; j<isim.length(); j++)
			{
				sayac += isim.charAt(i) == isim.charAt(j) ? 1 : 0;
			}
			
			System.out.print(isim.charAt(i) + "" + sayac);
		}
	}
	
	private static boolean CheckIfExists(String isim, int index)
	{
		boolean exist = false;
		
		for(int i =0; i<index; i++)
		{
			if(isim.charAt(i) == isim.charAt(index)) {
				exist = true;
				break;
			}
		}
		return exist;
	}
}
