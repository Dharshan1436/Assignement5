package assignment5.setInterfaceAndClass;

import java.util.*;

public class Program3 {
	public static Integer findFirstNonDuplicate(int[] arr) {
		Set<Integer> uniqueSet = new LinkedHashSet<>();
		Set<Integer> duplicateSet = new HashSet<>();

		for (int num : arr) {
			if (!duplicateSet.contains(num)) {
				if (!uniqueSet.contains(num)) {
					uniqueSet.add(num);
				} else {
					uniqueSet.remove(num);
					duplicateSet.add(num);
				}
			}
		}

		if (!uniqueSet.isEmpty()) {

			return uniqueSet.iterator().next();
		}
		return null;
	}

	public static void main(String[] args) {
		int[] input = { 4, 5, 6, 4, 7, 8, 5,6 };
		Integer result = findFirstNonDuplicate(input);
		System.out.println("First non-duplicate element: " + result);
	}
}
