package labPolymorphism;


public class DogApp
{
    public static void main(String[] args)
    {
        Dog myDog = new Dog("Greyhound");
        actAsDog(myDog);

        SledDog mySledDog = new SledDog("Husky");
        actAsDog(mySledDog);

        CircusDog myCircusDog = new CircusDog("Terrier");
        actAsDog(myCircusDog);
        
        System.out.println("Using an Array:");
        System.out.println();
        
        Dog dogArr[] = {myDog, mySledDog, myCircusDog};
        
        for (Dog d : dogArr) {
        	System.out.println(d);
        	if (d instanceof SledDog) {
        		((SledDog) d).pullSled();
        	}
        	actAsDog(d);
        }
    }

    private static void actAsDog(Dog d)
    {
        d.communicate();
        d.move();
        System.out.println();
    }
}
