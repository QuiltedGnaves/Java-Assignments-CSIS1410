package labConcert;

public class ConcertApp {

	public static void main(String[] args) {
		
		Concert newConcert = new Concert("The Concert", new Time(18, 0, 0), new Time(23, 59, 0));
		
		System.out.println(newConcert);

	}

}
