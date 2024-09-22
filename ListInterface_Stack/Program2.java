package assignment5.ListInterface_Stack;

public class Program2 {

    public static void reverse(int[] stack, int top) {
        if (top == -1) {
            return;
        }

        int temp = stack[top];
        reverse(stack, top - 1);
        insertAtBottom(stack, top, temp);
    }

    private static void insertAtBottom(int[] stack, int currentIndex, int value) {
        if (currentIndex == 0) {
            stack[0] = value;
            return;
        }

        int temp = stack[currentIndex - 1];
        insertAtBottom(stack, currentIndex - 1, value);
        stack[currentIndex] = temp;
    }

    public static void main(String[] args) {
        int[] stack = {1, 2, 3, 4, 5};
        int top = stack.length - 1;
        
        reverse(stack, top);
        
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");  
        }
    }
}
