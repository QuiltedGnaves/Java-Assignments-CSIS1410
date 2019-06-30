/*
 * Dax Allen
 * Assignment: Item List
 * CSIS 1410
 * Section 402
 * 
 */
package a01ItemList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/** Used to create an ArrayList and interact with it.
 *  <p>
 *  Creates a class List that creates an ArrayList and all required methods to interact with the list.
 *  
 *
 */
public class List {
	
	private ArrayList<Product> list = new ArrayList<Product>();
	private Map<Integer, Product> prodMap = new HashMap<>();
	private Scanner scan = new Scanner(System.in);
	private String regexWord = "[\\w\\s]+";
	
	public List() {
		
	}
	/**
	 * Displays all items in the ArrayList
	 */
	public void displayItems() {
		for (Product item : list) {
			System.out.println(item.toString());
		}
		System.out.println("");
	}
	/**
	 * Adds a new Product Object to the ArrayList and the Map. Requests data internally, requires no parameters.
	 */
	public void addItem() {
		String brand;
		String name;
		BigDecimal price;
		
		do {
			brand = System.console().readLine("Please enter the product brand: ");
			while (!brand.matches(regexWord)) {
				brand = System.console().readLine("Invalid input, please enter alphanumeric characters only: ");
				
			}
			
		} while (!brand.matches(regexWord));
		System.out.println("");
		
		do {
			name = System.console().readLine("Please enter the product name: ");
			while (!name.matches(regexWord)) {
				name = System.console().readLine("Invalid input, please enter alphanumeric characters only: ");
			}
			
		} while (!name.matches(regexWord));
		System.out.println("");
		
		do {
			System.out.print("Please enter the price greater than zero: ");
			while (!scan.hasNextBigDecimal()) {
				System.out.print("Invalid input, please enter a price greater than zero in currency format(X.XX): ");
				scan.next();
			}
			price = scan.nextBigDecimal();
			
		} while (price.compareTo(BigDecimal.ZERO) <= 0);
		System.out.println("");
		
		
		Product tempHolder = new Product(brand, name, price);
		prodMap.put(tempHolder.getProductId(), tempHolder);
		list.add(tempHolder);
		tempHolder = null;
		
	}
	/**
	 * Finds and item in the ArrayList. Requests data internally, requires no parameters.
	 */
	public void findItem() {
		
		int idToGet;
		do {
			System.out.print("Enter a valid ID of the item to find: ");
			while (!scan.hasNextInt()) {
				System.out.print("Invalid input, please enter a valid ID number: ");
				scan.next();
			}
			idToGet = scan.nextInt();
			
		} while (!prodMap.containsKey(idToGet));
		System.out.println("");
		
		Product id = prodMap.get(idToGet);
		
		int index = list.indexOf(id);
		
		System.out.println(list.get(index) + "\n");
		
	}
	/**
	 * Deletes and item from the ArrayList. Requests data internally, requires no parameters.
	 */
	public void deleteItem() {
		
		int idToGet;
		do {
			System.out.print("Enter a valid ID of the item to delete: ");
			while (!scan.hasNextInt()) {
				System.out.print("Invalid input, please enter a valid ID number: ");
				scan.next();
			}
			idToGet = scan.nextInt();
			
		} while (!prodMap.containsKey(idToGet));
		System.out.println("");
		
		Product id = prodMap.get(idToGet);
		
		int index = list.indexOf(id);
		
		System.out.println(id.getBrand() + " has been removed! \n");
		list.remove(index);
		prodMap.remove(idToGet);
		
	}
	/**
	 * Prints out the number of items in the ArrayList.
	 */
	public void numOfItems() {
		System.out.println((list.size() == 1) ? "There is 1 product. \n" : "There are " + list.size() + " products.\n");
		
	}
	
}
