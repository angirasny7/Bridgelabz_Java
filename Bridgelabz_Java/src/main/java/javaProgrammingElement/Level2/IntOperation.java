package javaProgrammingElement.Level2;

import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Take three integer inputs
        System.out.print("Enter value of a: ");
        int a = input.nextInt();

        System.out.print("Enter value of b: ");
        int b = input.nextInt();

        System.out.print("Enter value of c: ");
        int c = input.nextInt();

        // Perform integer operations
        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;
        int result4 = a % b + c;

        // Display the results
        System.out.println("The results of Int Operations are " +
                result1 + ", " + result2 + ", " +
                result3 + ", and " + result4);

        input.close();
    }
}

