import java.util.*;

public class PostfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a postfix string");
        String postfix = sc.nextLine();
        int result = evaluatePostfix(postfix);
        System.out.println("Result: " + result);
    }

     static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else if (isOperator(c)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(c, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

     static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch =='^' || ch =='$';
    }

     static int performOperation(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '^':
                return operand1 ^ operand2;
            case '$':
                return operand1 ^ operand2;
        }
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }
}
