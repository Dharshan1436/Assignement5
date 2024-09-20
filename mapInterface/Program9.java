package assignment5.mapInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Program9 {

    private static void findTopKFrequent(int[] ar, int k) {
        

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : ar) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        System.out.println("Top " + k + " frequent elements:");
        while (!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            System.out.println("Element: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        int[] ar = { 1, 2, 3, 4, 5, 6, 4, 5, 2, 2, 2, 2, 3, 5, 4, 8 };
        int k = 5;
        findTopKFrequent(ar, k);
    }
}
