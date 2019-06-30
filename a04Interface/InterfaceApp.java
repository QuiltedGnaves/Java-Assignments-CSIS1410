/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 * 
 */
package a04Interface;

import java.util.HashMap;
import java.util.Map;

public class InterfaceApp {

	public static void main(String[] args) {
		
		Map<String, Shape> shapesMap = new HashMap<>();
		
		Rectangle rect1 = new Rectangle(6,3);
		Rectangle rect2 = new Rectangle(5,4);
		shapesMap.put("Rectangle", rect1);
		shapesMap.put("Rectangle", rect2);
		
		Square square1 = new Square(4);
		Square square2 = new Square(3);
		shapesMap.put("Square", square1);
		shapesMap.put("Square", square2);
		
		IsoscelesRightTriangle iso1 = new IsoscelesRightTriangle(5);
		IsoscelesRightTriangle iso2 = new IsoscelesRightTriangle(3);
		shapesMap.put("IsoscelesRightTriangle", iso1);
		shapesMap.put("IsoscelesRightTriangle", iso2);
		
		Circle circle1 = new Circle(7);
		Circle circle2 = new Circle(2);
		
		Shape shapes[] = {rect1, rect2, square1, square2, iso1, iso2, circle1, circle2};
		
		for (Shape el : shapes) {
			System.out.println(el);
			System.out.printf("Perimeter: %.1f %n", el.perimeter());
			System.out.printf("Area: %.1f %n", el.area());
			if (!(el instanceof Circle)) {
				switch (el.getClass().getSimpleName()) {
				case "Rectangle":
					((Rectangle) el).print();
					break;
				case "Square":
					((Square) el).print();
					break;
				case "IsoscelesRightTriangle":
					((IsoscelesRightTriangle) el).print();
					break;
				}
			}
			System.out.println();
		}
	}

}
