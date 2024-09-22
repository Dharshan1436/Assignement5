package assignment5.ListInterface_Stack;

import java.util.Stack;

public class Program6 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Program6() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int removed = stack.pop();
            if (removed == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1; 
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1; 
    }

    public static void main(String[] args) {
        Program6 minStack = new Program6();
        minStack.push(2);
        minStack.push(0);
        minStack.push(0);
        minStack.push(0);

        System.out.println(minStack.getMin());  
        minStack.pop();
        System.out.println(minStack.getMin());  
        minStack.pop();
        System.out.println(minStack.getMin()); 
        minStack.pop();
        System.out.println(minStack.getMin());  
    }
}
