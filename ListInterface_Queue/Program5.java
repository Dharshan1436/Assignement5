package assignment5.ListInterface_Queue;

import java.util.LinkedList;
import java.util.Queue;

class BinaryNumberGenerator {
    public void generateBinary(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 0; i < n; i++) {
            String binary = queue.poll();
            System.out.println(binary);
            queue.offer(binary + "0");
            queue.offer(binary + "1");
        }
    }
}

public class Program5 {
    public static void main(String[] args) {
        BinaryNumberGenerator generator = new BinaryNumberGenerator();
        int n = 10; 
        generator.generateBinary(n);
    }
}
