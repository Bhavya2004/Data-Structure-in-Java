import java.util.Scanner;

class Stack {
    Scanner sc = new Scanner(System.in);
    int[] stack;
    int top;
    int size;

    public void initializeStack(int size) {
        stack = new int[size];
        this.size = size;
        top = -1;
    }

    public void push() {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
        } else {
            System.out.println("Enter a value to insert");
            int x = sc.nextInt();
            stack[++top] = x;
            System.out.println("Pushed " + x + " onto the stack.");
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println("Popped " + stack[top] + " from the stack.");
		    top--;
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("The stack is empty");
        } else {
            System.out.println("The elements in the stack are:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    public void peep() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("The top element is: " + stack[top]);
        }
    }

    public void change() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Enter position to change (0 for top):");
        int position = sc.nextInt();

        if (position < 0 || position > top) {
            System.out.println("Invalid position");
            return;
        }

        System.out.println("Enter new value:");
        int newValue = sc.nextInt();

        stack[top - position] = newValue;
        System.out.println("Changed position " + position + " to " + newValue);
    }
}

public class StackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of stack: ");
        int size = scanner.nextInt();

        Stack stack = new Stack();
        stack.initializeStack(size);

        System.out.println("\nStack Operations:");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Display");
        System.out.println("4. Peep");
        System.out.println("5. Change");
        System.out.println("6. Exit");

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    stack.push();
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    stack.peep();
                    break;
                case 5:
                    stack.change();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
