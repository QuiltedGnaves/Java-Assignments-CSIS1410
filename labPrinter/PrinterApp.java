package labPrinter;

import java.util.ArrayList;

public class PrinterApp {

	public static void main(String[] args) {
		
		LaserPrinter laser = new LaserPrinter(1923924);
		InkjetPrinter ink = new InkjetPrinter(5488961);
		
		System.out.println(laser);
		System.out.println(laser.print() + "\n");

		System.out.println(ink);
		System.out.println(ink.print() + "\n");
		
		System.out.println();
		
		ArrayList<Printer> printerList = new ArrayList<>();
		printerList.add(laser);
		printerList.add(ink);
		
		for(Printer el : printerList) {
			System.out.println(el);
			for(int i = 0; i <= 9; i++) {
				System.out.println(el.print());
			}
			System.out.println();
			
		}
	}

}
