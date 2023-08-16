package Shapes;

public class Cylinder extends Shapes3D {

	private double height;
	private double r;

	public Cylinder(double height, double r, String color) {
		super(color);
		this.height = height;
		this.r = r;
	}

	@Override
	public double CalculateSurfaceArea() {
		return 2 * Math.PI * r * r + 2 * Math.PI * r * height;
	}

	@Override
	public double CalculateVolume() {
		return Math.PI * r * r * height;
	}
}
