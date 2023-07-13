import java.util.Stack;

public class InfixToPostfix {
    
    // Function to check if a given character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Function to get the precedence of an operator
    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    // Function to convert infix notation to postfix notation
    private static String convertToPostfix(String infix) {
        String postfix = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid infix expression";
                } else {
                    stack.pop(); // Remove the '(' from the stack
                }
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
                    postfix += stack.pop();
                }
                stack.push(ch);
            }
        }

        // Pop any remaining operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid infix expression";
            }
            postfix += stack.pop();
        }

        return postfix;
    }

    public static void main(String[] args) {
        String infixExpression = "(A + B * C / D - E + F / G / ( H + I ))";
        String postfixExpression = convertToPostfix(infixExpression);
        System.out.println("Postfix notation: " + postfixExpression);
    }
}
