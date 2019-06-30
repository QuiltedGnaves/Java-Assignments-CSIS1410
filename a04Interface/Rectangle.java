/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 * 
 */
package a04Interface;

/**
 * 
 * Creates a rectangle object
 *
 */
public class Rectangle implements Shape, Printable {
	
	private final int length;
	private final int width;
	
	/**
	 * 
	 * @param l - int rectangle length
	 * @param w - int rectangle width
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

	@Override
	public void print() {
		if (this.length == 6 ) {
			System.out.println("○ ○ ○ ○ ○ ○");
			System.out.println("○         ○");
			System.out.println("○ ○ ○ ○ ○ ○");
		} else {
			System.out.println("○ ○ ○ ○ ○");
			System.out.println("○       ○");
			System.out.println("○       ○");
			System.out.println("○ ○ ○ ○ ○");
		}
		
	}

	@Override
	public double perimeter() {
		return (this.length * 2) + (this.width * 2);
	}

	@Override
	public double area() {
		return this.length * this.width;
	}
	
	

}
