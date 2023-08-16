package Odev;

import Shapes.Cube;
import Shapes.Cylinder;
import Shapes.Square2D;
import Shapes.Triangle2D;

public class MainClass {

	public static void main(String[] args) {
		Square2D kare2D = new Square2D(10, "beyaz");
		System.out.println("Kare rengi: " + kare2D.getColor());
		System.out.println("Kare alanı: " + kare2D.CalculateArea());
		System.out.println("Kare çevresi: " + kare2D.CalculatePerimeter());
		System.out.println();
		Triangle2D ucgen2D = new Triangle2D(3, 4, 5, "kırmızı");
		System.out.println("Üçgen rengi: " + ucgen2D.getColor());
		System.out.println("Üçgen alanı: " + ucgen2D.CalculateArea());
		System.out.println("Üçgen çevresi: " + ucgen2D.CalculatePerimeter());
		System.out.println();
		Cube kup = new Cube(5, "mavi");
		System.out.println("Küp rengi: " + kup.getColor());
		System.out.println("Küp yüzey alanı: " + kup.CalculateSurfaceArea());
		System.out.println("Küp hacmi: " + kup.CalculateVolume());
		System.out.println();
		Cylinder silindir = new Cylinder(6, 2, "yeşil");
		System.out.println("Silindir rengi: " + silindir.getColor());
		System.out.println("Silindir yüzey alanı: " + silindir.CalculateSurfaceArea());
		System.out.println("Silindir hacmi: " + silindir.CalculateVolume());
	}
}
