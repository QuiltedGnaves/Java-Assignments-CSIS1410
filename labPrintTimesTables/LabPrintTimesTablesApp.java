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
			
			pW.println("Times Tables:\n");
			for (int i = 1; i <= 10; i += 2) {
				for (int j = 1; j <= 10; j++) {
					pW.printf("%3d * %d = %-3d \t\t %3d * %d = %-3d%n", j, i, (i * j), j, i+1, (i+1) * j);
				}
				pW.println();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
