
package Strings.Extras.Extras3;

import java.util.Scanner;

/*
 * Problem:
 * Calculate the factorial of a number using recursion.
 * Separate input, calculation, and output into methods.
 */

public class FactorialUsingRecursion {

    // Method to take input from the user
    public static int takeInput(Scanner sc) {
        System.out.print("Enter a non-negative integer: ");
        return sc.nextInt();
    }

    // Recursive method to calculate factorial
    public static long factorial(int n) {

        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case
        return n * factorial(n - 1);
    }

    // Method to display the result
    public static void displayResult(int n, long result) {
        System.out.println("Factorial of " + n + " is: " + result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input
        int number = takeInput(sc);

        if (number < 0) {
            System.out.println(
                    "Factorial is not defined for negative integers.");
        } else if (number > 20) {
            System.out.println(
                    "Please enter a number between 0 and 20.");
        } else {
            // Calculate factorial
            long result = factorial(number);

            // Display output
            displayResult(number, result);
        }

        sc.close();
    }
}
