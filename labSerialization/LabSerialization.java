package labSerialization;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LabSerialization {
    public static void main(String[] args) {
        ListVsSetDemo oldDemo = new ListVsSetDemo(
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(6, Color.BLUE),
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(8, Color.YELLOW));

        testDemo(oldDemo);
        
        String file = "src/labSerialization/Demo.ser";
        
        System.out.println("Start Serialization...\n");
        serialize(oldDemo, file);
        System.out.println("Serialize Complete!\n");
        
        ListVsSetDemo newDemo = new ListVsSetDemo();
        
        System.out.println("Start Deserialization...\n");
        newDemo = deserialize(file);
        System.out.println("Deserialization Complete!\n");
        
        testDemo(newDemo);
        
        System.out.println("Are oldDemo and newDemo equal... " + oldDemo.equals(newDemo));

    };

    private static void testDemo(ListVsSetDemo demo) {
        System.out.println("List:");
        System.out.println(demo.getListElements());
        System.out.println("Set:");
        System.out.println(demo.getSetElements());
    }
    
    public static void serialize(ListVsSetDemo demo, String fileName) {
    	try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(fileName))) {
    		
    		obj.writeObject(demo);
    		
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static ListVsSetDemo deserialize(String fileName) {
    	
    	try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(fileName))) {
    		
    		return (ListVsSetDemo) obj.readObject();
    		
    	} catch (IOException | ClassNotFoundException e) {
			System.out.println("Deserialize didn't work... " + e);
			return null;
		}
    }

}
