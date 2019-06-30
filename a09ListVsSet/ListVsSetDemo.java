package a09ListVsSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListVsSetDemo {
	
	List<ColoredSquare> list;
	Set<ColoredSquare> set;
	
	public ListVsSetDemo(ColoredSquare...elements ) {
		this.list = new ArrayList<>(Arrays.asList(elements));
		this.set = new HashSet<>(Arrays.asList(elements));
	}
	
	public String getListElements() {
		StringBuilder sb = new StringBuilder();
		
		for (ColoredSquare el : list) {
			sb.append(el).append("\n");
		}
		
		return sb.toString();
	}
	
	public String getSetElements() {
		StringBuilder sb = new StringBuilder();
		
		for (ColoredSquare el : set) {
			sb.append(el).append("\n");
		}
		
		return sb.toString();
	}
	
	public void addElement(ColoredSquare el) {
		this.list.add(el);
		this.set.add(el);
	}

}
