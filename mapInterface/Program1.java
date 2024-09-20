package assignment5.mapInterface;

import java.util.HashMap;
import java.util.Scanner;

public class Program1 {
    private static void countCharacterFrequency(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        System.out.println("Character Frequency: " + map);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        countCharacterFrequency(input);
        scanner.close();
    }
}
