package odev4;

public class MainClass {

	public static void main(String[] args) {

		Kopek kopek = new Kopek("karabaş");
		Kedi kedi = new Kedi("boncuk");

		kedi.Uyu();
		kedi.SuIc();
		kedi.Avlan();
		kopek.Avlan();
		kopek.YemekYe();
	}

}
