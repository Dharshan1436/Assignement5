package assignment5.ListInterface_Queue;

import java.util.LinkedList;
import java.util.Queue;

class InterleaveQueue {
    public Queue<Integer> interleave(Queue<Integer> queue) {
        int size = queue.size();
        Queue<Integer> firstHalf = new LinkedList<>();
        
        // Dequeue the first half
        for (int i = 0; i < size / 2; i++) {
            firstHalf.offer(queue.poll());
        }
        
        // Interleave the two halves
        while (!firstHalf.isEmpty()) {
            queue.offer(firstHalf.poll());
            queue.offer(queue.poll());
        }

        return queue;
    }
}

public class Program9 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);

        InterleaveQueue interleaver = new InterleaveQueue();
        Queue<Integer> interleavedQueue = interleaver.interleave(queue);
        
        while (!interleavedQueue.isEmpty()) {
            System.out.print(interleavedQueue.poll() + " ");
        }
    }
}
