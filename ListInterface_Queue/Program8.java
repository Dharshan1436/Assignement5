package assignment5.ListInterface_Queue;

import java.util.*;

class FirstNonRepeatingCharacter {
    private Queue<Character> queue;
    private Map<Character, Integer> frequencyMap;

    public FirstNonRepeatingCharacter() {
        queue = new LinkedList<>();
        frequencyMap = new HashMap<>();
    }

    public void addCharacter(char ch) {
        frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        queue.offer(ch);

        while (!queue.isEmpty() && frequencyMap.get(queue.peek()) > 1) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("No non-repeating character");
        } else {
            System.out.println("First non-repeating character: " + queue.peek());
        }
    }
}

public class Program8 {
    public static void main(String[] args) {
        FirstNonRepeatingCharacter stream = new FirstNonRepeatingCharacter();
        String input = "aabc";
        
        for (char ch : input.toCharArray()) {
            stream.addCharacter(ch);
        }
    }
}
