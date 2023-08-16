package Shapes;

public class Cube extends Shapes3D {

	private double edgeLength;

	public Cube(double edgeLength, String color) {
		super(color);
		this.edgeLength = edgeLength;
	}

	@Override
	public double CalculateSurfaceArea() {
		return edgeLength * edgeLength * 6;
	}

	@Override
	public double CalculateVolume() {
		return edgeLength * edgeLength * edgeLength;
	}

}
