package assignment5.mapInterface;

import java.util.HashMap;
import java.util.Scanner;

public class Program2 {

	private static void countWordsFrequency(String input) {
		HashMap<String, Integer> map = new HashMap<>();
		String temp = "";

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch != ' ') {
				temp += ch;
			} else {
				if (!temp.isEmpty()) {
					map.put(temp, map.getOrDefault(temp, 0) + 1);
					temp = "";
				}
			}
		}

		if (!temp.isEmpty()) {
			map.put(temp, map.getOrDefault(temp, 0) + 1);
		}

		System.out.println("Word Frequency: " + map);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = scanner.nextLine();

		countWordsFrequency(input);
		scanner.close();
	}
}
