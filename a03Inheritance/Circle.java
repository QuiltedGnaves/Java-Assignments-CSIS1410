/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 * 
 */
package a03Inheritance;

/**
 * Creates a circle object
 * 
 */
public class Circle {
	
	private final int radius;
	
	/**
	 * 
	 * @param r - int value of radius
	 */
	public Circle(int r) {
		this.radius = r;
	}
	
	/**
	 * Radius getter
	 * @return int
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Calc and return diameter
	 * @return int
	 */
	public int diameter() {
		return radius * 2;
	}
	
	/**
	 * Calc and return circumference
	 * @return double
	 */
	public double circumference() {
		return diameter() * Math.PI;
	}

	/**
	 * ToString override
	 */
	@Override
	public String toString() {
		return "Circle ( " + radius + " )";
	}
	
	

}
