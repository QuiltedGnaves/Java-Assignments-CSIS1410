/*
 * Dax Allen
 * Assignment: Item List
 * CSIS 1410
 * Section 402
 * 
 */

package a01ItemList;

import java.util.Scanner;

/**
 * App used as database for products. Allows for product brand, product name, product price, 
 * and then automatically adds an ID number. 
 * 
 *
 */
public class ItemList {

	public static void main(String[] args) {
		
		List prodList = new List();
		ListOptions options = new ListOptions();
		Scanner scan = new Scanner(System.in);
		
		int answer = -1;
		
		boolean run = true;
		boolean prodCreated = false;
		boolean validInput = true;
		
		while (run) {
			do {
				System.out.println(options.toString());
				if (!scan.hasNextInt()) { // If non int value entered
					validInput = false;
					System.out.println("Invalid Input. Please enter a number between 1 and 6.\n");
					scan.next();
				} else {
					answer = scan.nextInt();
					if (answer > 6 || answer < 1) {
						System.out.println("Invalid Input. Please enter a number between 1 and 6.\n");
						validInput = false;
					} else {
						validInput = true;
					}
				}
				System.out.println("");
			} while (!validInput);
			
			
			/*
			 * Questionable hack to force user to create a product before anything else.
			 * Should probably re-think logic
			 */
			if(prodCreated == false && answer != 2) {
				answer = -1;
			}
			
			switch(answer) {
			
			case 1: 
				prodList.displayItems();
				break;
			case 2:
				prodList.addItem();
				prodCreated = true;
				break;
			case 3:
				prodList.findItem();
				break;
			case 4:
				prodList.deleteItem();
				break;
			case 5:
				prodList.numOfItems();
				break;
			case 6:
				System.out.println("Quiting Application...");
				run = false;
				break;
			case -1:
				System.out.println("No products created yet. Please create some products. \n");
				break;
			}
		}
		
		scan.close();
		

	}

}
