package labPrinter;

public abstract class Printer {
	
	private int serialNumber;
	
	public Printer(int number) {
		this.serialNumber = number;
	}
	
	public abstract String print();

	@Override
	public String toString() {
		return String.format("%s #%d", this.getClass().getSimpleName(), this.serialNumber);
	}
	
	

}
