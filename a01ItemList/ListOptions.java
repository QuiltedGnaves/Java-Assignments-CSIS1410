/*
 * Dax Allen
 * Assignment: Item List
 * CSIS 1410
 * Section 402
 * 
 */
package a01ItemList;
/**
 * Class just used to print out the menu
 * 
 *
 */
public class ListOptions {
	
	/**
	 * Overrides ListOptions toString()
	 * 
	 * @return Returns the formatted options in a list
	 */
	@Override
	public String toString() {
		return  "1. Display All Products \n" +
				"2. Add a Product \n" +
				"3. Find a Product \n" +
				"4. Delete a Product \n" +
				"5. Number of Products in List \n" +
				"6. Exit \n" +
				"Enter Choice: ";
	}
	
}
