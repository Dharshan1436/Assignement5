package assignment5.ListInterface_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class SlidingWindowMaximum {
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                result.add(nums[deque.peek()]);
            }
        }
        return result;
    }
}

public class Program4 {
    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindow = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        List<Integer> maxValues = slidingWindow.maxSlidingWindow(nums, k);
        System.out.println(maxValues);
    }
}
