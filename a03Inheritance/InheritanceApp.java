/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 * 
 */
package a03Inheritance;

public class InheritanceApp {

	public static void main(String[] args) {
		
		Rectangle rect = new Rectangle(5,4);
		Square square = new Square(4);
		IsoscelesRightTriangle isoTri = new IsoscelesRightTriangle(5);
		Circle circle = new Circle(4);
		
		System.out.println(rect);
		System.out.println("Length: " + rect.getLength());
		System.out.println("Width: " + rect.getWidth());
		System.out.println();
		
		System.out.println(square);
		System.out.println("Side: " + square.getSide());
		System.out.println();
		
		System.out.println(isoTri);
		System.out.println("Leg: " + isoTri.getLeg());
		System.out.printf("Hypotenuse: %.1f \n", isoTri.hypotenuse());
		System.out.println();
		
		System.out.println(circle);
		System.out.println("Radius: " + circle.getRadius());
		System.out.println("Diameter: " + circle.diameter());
		System.out.printf("Circumferene: %.1f\n", circle.circumference());
		System.out.println();
		
		Rectangle rect2 = square;
		System.out.println("Rectangle 2:");
		System.out.println("--------------");
		System.out.println(rect2);
		System.out.println("Length: " + rect2.getLength());
		System.out.println("Width: " + rect2.getWidth());
		System.out.println();
		
		
		
		Rectangle[] rectangles = {rect2, square, rect};
		
		System.out.println("Rectangle Array:");
		System.out.println("--------------");
		
		for (Rectangle r : rectangles) {
			System.out.println(r);
			System.out.println("Length: " + r.getLength());
			System.out.println("Width: " + r.getWidth());
			System.out.println();
		}
	}

}
