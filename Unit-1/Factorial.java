import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        long factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        // int i = 1;
        // while (i <= number) {
        //     factorial *= i;
        //     i++;
        // }

        System.out.println("The factorial of " + number + " is: " + factorial);

    }
}
