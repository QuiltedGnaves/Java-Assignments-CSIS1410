package labFile;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MountainApp {
	public static void main(String[] args) {
		
		List<Mountain> mountainList = new LinkedList<>();
		
		try (Scanner scan = new Scanner(MountainApp.class.getResourceAsStream("Mountains.csv"))) {
			while (scan.hasNextLine()) {
				Mountain temp;
				if ((temp = getMountain(scan.nextLine())) != null) {
					mountainList.add(temp);
				}
				
			}
		}
		
		for (Mountain el : mountainList) {
			System.out.println(el);
		}
	}

	private static Mountain getMountain(String nextLine) {
		String[] values = nextLine.split(",");
		
		try {
			
			return new Mountain(values[0], Integer.parseInt(values[1]), Boolean.parseBoolean(values[2]));
			
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			
			System.out.println(nextLine + " .. could not be read in as mountain.\n");
			return null;
			
		}
		
		
	}
}
