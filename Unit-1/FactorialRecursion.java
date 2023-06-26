import java.util.Scanner;

public class FactorialRecursion {
     
     static int factorial(int n){    
        if (n == 0)    
            return 1;    
        else    
            return(n * factorial(n-1));    
 }    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int i,fact=1;

        fact=factorial(number);

        System.out.println("The factorial of " + number + " is: " + fact);

    }
}
