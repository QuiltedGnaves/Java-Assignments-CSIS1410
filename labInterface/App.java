package labInterface;

public class App
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Plane myPlane = new Plane(4, "Boing 747");
		System.out.printf("myPlane: %s%n", myPlane);

		Hangglider myHangglider = new Hangglider(true);
		System.out.printf("myHangglider: %s%n", myHangglider);

		Bird myBird = new Bird("Swallow");
		System.out.printf("myBird: %s%n", myBird);
		
		Flyable flyingThings[] = {myPlane, myHangglider, myBird};
		
		System.out.println();
		
		for (Flyable f : flyingThings) 
		{
			System.out.println(f);
			flyableActions(f);
		}
	}
	
	public static void flyableActions(Flyable f) 
	{
		f.launch();
		f.land();
		System.out.println();
	}

}
