package labKeyValuePair2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pair2App {

	public static void main(String[] args) {
		
		KeyValuePair2<String, Integer> p1 = new KeyValuePair2<String, Integer>("SLC", 189899);
		KeyValuePair2<String, Integer> p2 = new KeyValuePair2<String, Integer>("NY", 8244910);
		KeyValuePair2<String, Integer> p3 = new KeyValuePair2<String, Integer>("LA", 3819702);
		KeyValuePair2<String, Integer> p4 = new KeyValuePair2<String, Integer>("SF", 812826);
		
		List<KeyValuePair2<?,?>> cities = new ArrayList<>();
		
		cities.add(p1);
		cities.add(p2);
		cities.add(p3);
		cities.add(p4);
		
		System.out.println("Original List:");
		for (KeyValuePair2 el : cities) {
			System.out.println(el);
		}
		System.out.println();
		
		Collections.sort(cities);
		
		System.out.println("Sorted List:");
		for (KeyValuePair2 el : cities) {
			System.out.println(el);
		}
		System.out.println();

	}

}
