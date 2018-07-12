package org.jayantiandhale;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Factory Methods for creating unmodifiable collections
 * Collections - group of individual objects - List, Set, Queue
 * Map - key value pairs
 * List - duplicates are allowed, insertion order is preserved
 * Set - duplicates are not allowed, insertion order is not preserved
 * 
 * Immutable - once created, not allowed to change the content
 * i.e. String, wrapper classes, 
 * - needed for reusablility, performance, 
 *
 * Factory Methods - 
 * static factory methods - by using class name, calling a mehtod and that method returns the same class
 * i.e. DateFormat df=DateFormat.getInstance()
 * 
 * Similarly, for 
 * List l = List.of() , 
 * Set s = Set.of() or 
 * Map m=Map.of() .. of method is a factory method.
 * 
 * Collections.unmodifiable - wrapper
 * Collections are data structures in classes, changing them causes exception
 * 
 * Ref: https://docs.oracle.com/javase/9/core/creating-immutable-lists-sets-and-maps.htm#JSCOR-GUID-930A5334-9413-4E87-A1D7-6FF4E9E421B2
 * 
 * @author jandhal
 *
 */
public class UnmodifiableCollection {

	public static void main(String[] args) {
		try {
			/**
			 * ---------------------------MAP - unmodifiable Map created using factory methods---------------------------
			 */
			System.out.println("Unmodifiable Map");
			Map<Integer, String> java8_map=new HashMap<>();
			java8_map.put(1, "first");
			java8_map.put(2, "second");
			java8_map=Collections.unmodifiableMap(java8_map);
			//java8_map.put(3, "third"); //throws exception
			java8_map.forEach((k,v)->System.out.println("Key:"+k +"\t Value:"+v));	
			/**
			 * ---------------------------MAP - unmodifiable Map with Java 9---------------------------
			 */
			System.out.println("\nImmutable Map");
			Map<Integer,String> java9_map=Map.of(1,"first",2,"second");	
			/*Map<Integer,String> java9_map2=Map.ofEntries(
					Map.entry(3, "three"),
					Map.entry(4, "four")
					);*/
			java9_map.forEach((k,v)->System.out.println("Key:"+k+"\t Value:"+v));
			
			
			
			/**
			 * ---------------------------LIST - unmodifiable List can also be created same way---------------------------
			 */
			System.out.println("\nunmodifiable List - but modified");
			List<Integer> java8_list=Arrays.asList(1,3,4);
			List<Integer> java8_list1=Collections.unmodifiableList(java8_list);
			//java8_list.set(0,5); //modification is still possible without any errors
			java8_list1.forEach(i->System.out.print("\t"+i));
			/**
			 * ---------------------------LIST - unmodifiable list with java 9---------------------------
			 */
			System.out.println("\nImmutable List");
			//doesn't allow null
			List<Integer> java9_list=List.of(12, 12, 13, 14, 15, 16, 17, 19, 20);
			//java9_list.set(0, 5); //not allowed to modify, throws exception
			java9_list.forEach(i->System.out.print("\t "+i));

			
			
			/**
			 * ---------------------------SET - unmodifiable set can also be created same way---------------------------
			 */			
			Set<Integer> java9_set=Set.of(11,12,13,14,15,16,17,18,19,20);
			System.out.println("\nImmutable Set:");
			java9_set.forEach(i->System.out.print("\t"+i));
		}catch(UnsupportedOperationException e) {
			System.out.println("Not allowed to insert to unmodifiable collection!" );
		}
			
	}

}
