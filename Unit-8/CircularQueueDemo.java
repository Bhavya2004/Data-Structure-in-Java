import java.util.Scanner;

class CqDemo {

    int[] queue;
    int front = -1;
    int rear = -1;

    CqDemo(int size) {
        queue = new int[size];
    }

    public void enqueue(int x) {
        // Check if the queue is full
        if ((front == 0 && rear == queue.length - 1) || (rear == (front - 1))) {
            System.out.println("Queue Overflow");
            return;
        }

        // Check if the queue is initially empty
        if (front == -1)
            front = rear = 0;
        else if (rear == queue.length - 1) // If rear is at the end, reset it to the beginning
            rear = 0;
        else
            rear++;

        queue[rear] = x;
    }

    public int dequeue() {
        // Check if the queue is empty
        if (front == -1) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int item = queue[front];

        // If there is only one element in the queue
        if (front == rear)
            front = rear = -1;
        else if (front == queue.length - 1) // If front is at the end, reset it to the beginning
            front = 0;
        else
            front++;

        return item;
    }

    public void display() {
        // Check if the queue is empty
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }

        int i = front;
        System.out.print("Queue elements: ");
        while (true) {
            System.out.print("[" + queue[i] + "] ");
            if (i == rear)
                break;
            if (i == queue.length - 1)
                i = 0;
            else
                i++;
        }
        System.out.println();
    }
}

public class CircularQueueDemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the queue ");
        int n = sc.nextInt();

        CqDemo queue = new CqDemo(n);

        int choice;
        do {
            System.out.println("Enter Your Choice ");
            System.out.println("Press 1 to enqueue ");
            System.out.println("Press 2 to dequeue ");
            System.out.println("Press 3 to display  ");
            System.out.println("Press 4 to exit  ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Element");
                    queue.enqueue(sc.nextInt());
                    break;
                case 2:
                    int dequeuedItem = queue.dequeue();
                    if (dequeuedItem != -1) {
                        System.out.println("[" + dequeuedItem + "]");
                    }
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}
    