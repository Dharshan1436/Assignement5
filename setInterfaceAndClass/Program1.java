package assignment5.setInterfaceAndClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class Program1 {

	public static void demonstrateSetBehavior(List<Integer> list) {

		HashSet<Integer> hashSet = new HashSet<>(list);
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(list);
		TreeSet<Integer> treeSet = new TreeSet<>(list);

		System.out.println("HashSet: " + hashSet);
		System.out.println("LinkedHashSet: " + linkedHashSet);
		System.out.println("TreeSet: " + treeSet);
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(2);

		demonstrateSetBehavior(list);
	}
}
