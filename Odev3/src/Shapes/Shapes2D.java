package Shapes;

public abstract class Shapes2D {
	protected final String color;

	protected Shapes2D(String color) {
		this.color = color;
	}

	public double CalculateArea() {
		return 0;
	}

	public double CalculatePerimeter() {
		return 0;
	}

	public String getColor() {
		return color;
	}
}
