package labQuadrotors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrotorApp {

	public static void main(String[] args) {
		
		List<Quadrotor> rotors = new ArrayList<>(Arrays.asList(
				new Quadrotor(2,4,2), new Quadrotor(3,4,4), new Quadrotor(4,4,6),
				new Quadrotor(5,4,2), new Quadrotor(6,4,4), new Quadrotor(7,4,6)));
		Quadrotor searchItem = new Quadrotor(4,6,4);
		
		System.out.println(rotors);
		
		changeOrientation(rotors);
		
		System.out.println(rotors);
		System.out.println();
		
		if (rotors.contains(searchItem)) {
			System.out.printf("rotors does contain %s%n", searchItem);
		} else {
			System.out.printf("rotors does not contain %s%n", searchItem);
		}
		
		System.out.printf("Number of rotors: %d%n", rotors.size());
		System.out.println();
		
		rotors.remove(searchItem);
		System.out.println(rotors);
		
		rotors.remove(0);
		System.out.println(rotors);
		

	}
	
	private static void changeOrientation(List<Quadrotor> rotorList) {
		
		for (Quadrotor el : rotorList) {
			int x = el.getX();
			el.setX(el.getY());
			el.setY(x);
		}
	}

}
