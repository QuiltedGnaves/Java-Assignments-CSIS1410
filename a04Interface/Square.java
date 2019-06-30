/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 * 
 */
package a04Interface;

/**
 * Class to create a square that extends Rectangle
 * 
 *
 */
public class Square extends Rectangle implements Shape, Printable{

	/**
	 * Create square object1
	 * @param l 
	 */
	public Square(int l) {
		super(l, l);
	}
	
	/**
	 * Get side of square from super class
	 * @return int 
	 */
	public int getSide() {
		return super.getLength();
	}

	@Override
	public String toString() {
		return "Square ( " + super.getLength() + " )";
	}

	@Override
	public void print() {
		if (super.getLength() == 4) {
			System.out.println("○ ○ ○ ○");
			System.out.println("○     ○");
			System.out.println("○     ○");
			System.out.println("○ ○ ○ ○");
		} else {
			System.out.println("○ ○ ○");
			System.out.println("○   ○");
			System.out.println("○ ○ ○");
		}
		
	}

	@Override
	public double perimeter() {
		return this.getLength() * 4;
	}

	@Override
	public double area() {
		return this.getLength() * this.getLength();
	}
	
	

}
