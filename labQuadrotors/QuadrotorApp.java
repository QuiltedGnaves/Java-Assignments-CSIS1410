package labQuadrotors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrotorApp {

	public static void main(String[] args) {
		
		List<Quadrotor> rotors = new ArrayList(Arrays.asList(
				new Quadrotor(2,4,2), new Quadrotor(3,4,4), new Quadrotor(4,4,6),
				new Quadrotor(5,4,2), new Quadrotor(6,4,4), new Quadrotor(7,4,6)));
		Quadrotor searchItem = new Quadrotor(4,6,4);
		
		System.out.println(rotors);
		System.out.println();
		
		changeOrientation(rotors);
		
		System.out.println(rotors);
		System.out.println();
		
		if (rotors.contains(searchItem)) {
			System.out.println("rotors does contain " + rotors.get(rotors.indexOf(searchItem)));
		}
		
		System.out.println("Number of rotors: " + rotors.size());
		System.out.println();
		
		rotors.remove(searchItem);
		System.out.println(rotors);
		
		rotors.remove(0);
		System.out.println(rotors);
		

	}
	
	private static void changeOrientation(List<Quadrotor> rotorList) {
		
		for (Quadrotor el : rotorList) {
			int x = el.getX();
			int y = el.getY();
			
			el.setX(y);
			el.setY(x);
		}
	}

}
