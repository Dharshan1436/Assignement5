package assignment5.ListInterface_Stack;

import java.util.Stack;

public class Program8 {

    public static int[] findNextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

       
        for (int i = n - 1; i >= 0; i--) {
           
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            
            result[i] = stack.isEmpty() ? -1 : arr[stack.peek()];

            
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25, 7, 8};
        int[] nge = findNextGreaterElements(arr);

        for (int n : nge) {
            System.out.print(n + " "); 
        }
    }
}
