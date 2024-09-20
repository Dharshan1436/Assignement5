package assignment5.setInterfaceAndClass;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program7 {
	private static void measurePerformance(Set<Integer> set, int elements, String setType) {

		long startTime = System.nanoTime();
		for (int i = 0; i < elements; i++) {
			set.add(i);
		}
		long endTime = System.nanoTime();
		System.out.println(setType + " - Add Time: " + (endTime - startTime) / 1000000 + " ms");

		startTime = System.nanoTime();
		for (int i = 0; i < elements; i++) {
			set.contains(i);
		}
		endTime = System.nanoTime();
		System.out.println(setType + " - Contains Time: " + (endTime - startTime) / 1000000 + " ms");

		startTime = System.nanoTime();
		for (int i = 0; i < elements; i++) {
			set.remove(i);
		}
			
		System.out.println(setType + " - Remove Time: " + (endTime - startTime) / 1000000 + " ms");

		System.out.println();
	}

	public static void main(String[] args) {
		final int ELEMENTS = 1000000;

		measurePerformance(new HashSet<Integer>(), ELEMENTS, "HashSet");

		measurePerformance(new LinkedHashSet<Integer>(), ELEMENTS, "LinkedHashSet");

		measurePerformance(new TreeSet<Integer>(), ELEMENTS, "TreeSet");

	}
}
