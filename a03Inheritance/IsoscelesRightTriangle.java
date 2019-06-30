/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 * 
 */
package a03Inheritance;

public class IsoscelesRightTriangle {
	
	private final int leg;
	
	/**
	 * Creates Isoceles Right Triangle object
	 * @param l - int length of not hypotenuse sides
	 */
	public IsoscelesRightTriangle(int l) {
		this.leg = l;
	}
	
	/**
	 * Getter for non-hypotenuse side length
	 * @return int
	 */
	public int getLeg() {
		return leg;
	}

	/**
	 * Calc and return hypotenuse
	 * @return double
	 */
	public double hypotenuse() {
		return Math.sqrt((leg * leg) + (leg * leg));
	}


	@Override
	public String toString() {
		return "IsoscelesRightTriangle ( " + leg + " )";
	}
	
	

}
