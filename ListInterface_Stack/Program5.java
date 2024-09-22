package assignment5.ListInterface_Stack;

import java.util.Stack;

public class Program5 {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        int length = expression.length();

        for (int i = 0; i < length; i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0'); 
            } else if (isOperator(c)) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                int result = applyOperator(c, val1, val2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int applyOperator(char operator, int val1, int val2) {
        switch (operator) {
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
            case '/':
                if (val2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return val1 / val2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String expression = "23*54*+";
        System.out.println(evaluatePostfix(expression));  
    }
}
