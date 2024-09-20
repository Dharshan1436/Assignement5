package assignment5.mapInterface;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program4 {

	private static void FirstNonRepeatedCharacter(String input) {
		

		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println("FirstNonRepeatedCharacter: " + entry.getKey());
				return;
			}
		}

		System.out.println("No non repeated character found.");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = scanner.nextLine();

		FirstNonRepeatedCharacter(input);
		scanner.close();
	}
}
