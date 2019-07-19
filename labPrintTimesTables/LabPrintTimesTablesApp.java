package labPrintTimesTables;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class LabPrintTimesTablesApp {

	public static void main(String[] args) {
		File timesTablesFile = new File("src\\labPrintTimesTables\\TimesTables.txt");
		
		try {
			if (timesTablesFile.createNewFile()) {
				System.out.println("File Created.");
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (PrintWriter pW = new PrintWriter(timesTablesFile)) {
			
			for (int i = 1; i <= 10; i += 2) {
				for (int j = 1; j <= 10; j++) {
					pW.printf((i == 10 || j ==10) ? "%2d * %d = %-9d %d * %d = %d%n" : "%2d * %d = %-10d %d * %d = %d%n", j, i, (i * j), j, i+1, ((i+1) * j));
				}
				pW.println();
			}
			pW.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
