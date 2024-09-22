package assignment5.ListInterface_Stack;

public class Program3 {

    public static void sortStack(int[] stack, int top) {
        if (top == -1) {
            return;
        }

        int temp = stack[top];
        sortStack(stack, top - 1);
        insertInSortedOrder(stack, top - 1, temp);
    }

    private static void insertInSortedOrder(int[] stack, int top, int value) {
        if (top == -1 || stack[top] <= value) {
            stack[top + 1] = value;
            return;
        }

        int temp = stack[top];
        insertInSortedOrder(stack, top - 1, value);
        stack[top + 1] = temp;
    }

    public static void main(String[] args) {
        int[] stack = {3, 1, 4, 2, 5};
        int top = stack.length - 1;

        sortStack(stack, top);

        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");  
        }
    }
}
