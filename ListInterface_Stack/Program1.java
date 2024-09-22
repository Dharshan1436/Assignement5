package assignment5.ListInterface_Stack;

public class Program1 {

    public static boolean isBalanced(String str) {
        int n = str.length();
        int[] stack = new int[n];
        int top = -1;
        
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            
            if (c == '(') {
                stack[++top] = c;
            } else if (c == ')') {
                if (top == -1) {
                    return false;
                }
                top--;
            }
        }
        
        return top == -1;
    }

    public static void main(String[] args) {
        String str = "((()))";
        System.out.println(isBalanced(str)); 
    }
}