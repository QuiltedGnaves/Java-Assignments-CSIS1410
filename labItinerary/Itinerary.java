package labItinerary;

import java.util.ArrayList;
import java.util.Scanner;

public class Itinerary {

	public static void main(String[] args) {
		ArrayList<String> itinerary = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String travelRoute;
		
		do {
			do {
				System.out.print("Please enter a destination or DONE: ");
				if (!scan.hasNext("\\w+")) {
					System.out.print("Invalid input. Please enter a destination or DONE: ");
					scan.next();
				}
				travelRoute = scan.nextLine();
				itinerary.add(travelRoute.toUpperCase());
				
				
			} while (!travelRoute.matches("\\w+"));
			
			
			
		} while (!travelRoute.equalsIgnoreCase("done"));
		
		boolean first = true;
		for (String dest : itinerary) {
			if (!dest.equalsIgnoreCase("done")) {
//				System.out.println("Destination: " + dest);
				
				if (!first) {
					sb.append(" to ").append(dest);
				} else {	
					sb.append(dest);
					first = false;
				}
			}
			
		}
		System.out.println(sb);
		
		scan.close();
		
		
		
		

	}

}
