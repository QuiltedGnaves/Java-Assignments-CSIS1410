/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 * 
 */
package a03Inheritance;

/**
 * Class to create a square that extends Rectangle
 * 
 *
 */
public class Square extends Rectangle {

	/**
	 * Create square object
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
	
	

}
