package Shapes;

public class Square2D extends Shapes2D {

	private double edgeLength;

	public Square2D(double edgeLength, String color) {
		super(color);
		this.edgeLength = edgeLength;
	}

	@Override
	public double CalculateArea() {
		return edgeLength * edgeLength;
	}

	@Override
	public double CalculatePerimeter() {
		return edgeLength * 4;
	}
}
