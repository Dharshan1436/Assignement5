package assignment5.ListInterface_Stack;

import java.util.Stack;

public class Program10 {
    private Stack<Integer> stack1; 
    private Stack<Integer> stack2; 

    public Program10() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    
    public void enqueue(int value) {
        stack1.push(value);
    }

    
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return stack2.pop();
    }

    
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return stack2.peek();
    }

    
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        Program10 queue = new Program10();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); 
        System.out.println(queue.peek());    
        System.out.println(queue.dequeue()); 
        System.out.println(queue.dequeue()); 

        
//         System.out.println(queue.dequeue());
    }
}
