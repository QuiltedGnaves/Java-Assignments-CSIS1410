/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 */
package a09ListVsSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Creates an object that contains a list and a set
 * @author Dax Allen
 *
 */
public class ListVsSetDemo {
	
	List<ColoredSquare> list;
	Set<ColoredSquare> set;
	
	/**
	 * Contructor that sets the list and the set to the varying amount of ColorSquare objects passed in.
	 * @param elements variable amount of ColoredSquare objects
	 */
	public ListVsSetDemo(ColoredSquare...elements ) {
		this.list = new ArrayList<>(Arrays.asList(elements));
		this.set = new HashSet<>(Arrays.asList(elements));
	}
	
	/**
	 * Getter for the list that uses a stringbuilder to return a formatted string.
	 * @return String formatted to display each item on it's own line.
	 */
	public String getListElements() {
		StringBuilder sb = new StringBuilder();
		
		for (ColoredSquare el : list) {
			sb.append(el).append("\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * Getter for the set that uses a stringbuilder to return a formatted string.
	 * @return String formatted to display each item on it's own line.
	 */
	public String getSetElements() {
		StringBuilder sb = new StringBuilder();
		
		for (ColoredSquare el : set) {
			sb.append(el).append("\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * Adds a ColoredSquare object to both the list and the set
	 * @param el ColoredSquare object
	 */
	public void addElement(ColoredSquare el) {
		this.list.add(el);
		this.set.add(el);
	}

}
