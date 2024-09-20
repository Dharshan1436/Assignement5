package assignment5.mapInterface;

import java.util.HashMap;
import java.util.Map;

public class Program6 {

	private static void findDuplicatesAndCounts(int[] ar) {
		if (ar.length == 0) {
			System.out.println("Array is empty, no duplicates found.");
			return;
		}

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : ar) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		boolean hasDuplicates = false;

		
		System.out.println("Duplicate elements and their counts:");
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println("Element: " + entry.getKey() + ", Count: " + entry.getValue());
				hasDuplicates = true;
			}
		}

		if (!hasDuplicates) {
			System.out.println("No duplicates found.");
		}
	}

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 5, 6, 2, 13, 5, 4, 9, 4, 7 };
		findDuplicatesAndCounts(ar);
	}
}
