package assignment5.mapInterface;

import java.util.TreeMap;

public class Program7 {

	static TreeMap<String, Long> phoneBook = new TreeMap<>();

	private static void add(String name, Long phoneNumber) {
		phoneBook.put(name, phoneNumber);
		System.out.println("Added contact: " + name + " - " + phoneNumber);
	}

	private static void remove(String name) {
		if (phoneBook.containsKey(name)) {
			phoneBook.remove(name);
			System.out.println("Removed contact: " + name);
		} else {
			System.out.println("Contact " + name + " not found.");
		}
	}

	private static void searchByName(String name) {
		if (phoneBook.containsKey(name)) {
			System.out.println("Found contact: " + name + " - " + phoneBook.get(name));
		} else {
			System.out.println("Contact " + name + " not found.");
		}
	}

	public static void main(String[] args) {

		add("Dharshan", 9844480769L);
		add("Ram", 3474946546L);

		searchByName("Dharshan");

		remove("Dharshan");

		searchByName("Dharshan");

		System.out.println("PhoneBook: " + phoneBook);
	}
}
