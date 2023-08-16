package Shapes;

public class Triangle2D extends Shapes2D {

	private double edgeLength1;
	private double edgeLength2;
	private double edgeLength3;

	public Triangle2D(double edgeLength1, double edgeLength2, double edgeLength3, String color) {
		super(color);
		this.edgeLength1 = edgeLength1;
		this.edgeLength2 = edgeLength2;
		this.edgeLength3 = edgeLength3;
	}

	@Override
	public double CalculateArea() {
		double s = CalculatePerimeter() / 2;
		return Math.sqrt(s * (s - edgeLength1) * (s - edgeLength2) * (s - edgeLength3));
	}

	@Override
	public double CalculatePerimeter() {
		return edgeLength1 + edgeLength2 + edgeLength3;
	}

}
