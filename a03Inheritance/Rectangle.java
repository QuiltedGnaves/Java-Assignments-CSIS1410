/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 * 
 */
package a03Inheritance;

/**
 * 
 * Creates a rectangle object
 *
 */
public class Rectangle {
	
	private final int length;
	private final int width;
	
	/**
	 * 
	 * @param l - int rectangle length
	 * @param w - int rectangel width
	 */
	public Rectangle(int l, int w) {
		this.length = l;
		this.width = w;
	}

	/**
	 * Get length of rectangle
	 * @return int
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Get width of rectangle
	 * @return int
	 */
	public int getWidth() {
		return width;
	}

	@Override
	public String toString() {
		return "Rectangle ( " + length + " x " + width + " )";
	}
	
	

}
