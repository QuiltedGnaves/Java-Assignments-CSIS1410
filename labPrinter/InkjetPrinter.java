package labPrinter;

public class InkjetPrinter extends Printer {
	
	private int remainingCartridge;
	private String returnVal;

	public InkjetPrinter(int number) {
		super(number);
		this.remainingCartridge = 100;
	}

	public int getRemainingCartridge() {
		return remainingCartridge;
	}

	@Override
	public String print() {
		if (remainingCartridge > 0) {
			returnVal = String.format("Inkjet is printing. Remainging cartridge is " + this.getRemainingCartridge() + "%%");
			this.remainingCartridge -= 10;
		} else {
			returnVal = "Cartridge is empty";
		}
		
		return returnVal;
	}

}
