package assignment5.mapInterface;

import java.util.*;

public class Program5 {
	
	public static Map<String, Integer> sortByValue(HashMap<String, Integer> map) {

		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

		list.sort((x, y) -> x.getValue().compareTo(y.getValue()));

		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> res : list) {
			sortedMap.put(res.getKey(), res.getValue());
		}

		return sortedMap;
	}

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();
		map.put("Apple", 5);
		map.put("Banana", 2);
		map.put("Orange", 8);
		map.put("Mango", 3);
		map.put("Grapes", 1);

		System.out.println("Original HashMap: " + map);

		Map<String, Integer> sortedMap = sortByValue(map);

		System.out.println("Sorted HashMap by Values: " + sortedMap);
	}

}
