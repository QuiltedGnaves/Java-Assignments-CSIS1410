package labPrinter;

public class LaserPrinter extends Printer {
	
	private int remainingToner;
	private String returnVal;
	
	public LaserPrinter(int number) {
		super(number);
		this.remainingToner = 100;
	}

	public int getRemainingToner() {
		return remainingToner;
	}

	@Override
	public String print() {
		if (remainingToner > 0) {
			returnVal = String.format("Inkjet is printing. Remainging cartridge is " + this.getRemainingToner() + "%%");
			this.remainingToner -= 10;
		} else {
			returnVal = "Toner is empty";
		}
		return returnVal;
		
	}

}
