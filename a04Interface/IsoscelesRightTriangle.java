/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 * 
 */
package a04Interface;

public class IsoscelesRightTriangle implements Shape, Printable {
	
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

	@Override
	public void print() {
		if (this.leg == 3) {
			System.out.println("○");
			System.out.println("○ ○");
			System.out.println("○ ○ ○");
		} else {
			System.out.println("○");
			System.out.println("○ ○");
			System.out.println("○   ○");
			System.out.println("○     ○");
			System.out.println("○ ○ ○ ○ ○");
		}
	}

	@Override
	public double perimeter() {
		return this.leg + this.leg + this.hypotenuse();
	}

	@Override
	public double area() {
		return (this.leg * this.leg) / 2.0;
	}
	
	

}
