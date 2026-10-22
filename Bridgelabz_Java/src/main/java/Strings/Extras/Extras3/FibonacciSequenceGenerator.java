
package Strings.Extras.Extras3;

import java.util.Scanner;

/*
 * Problem:
 * Generate the Fibonacci sequence up to the number
 * of terms specified by the user.
 * Use a separate function to calculate and print
 * the Fibonacci sequence.
 */

public class FibonacciSequenceGenerator {

    // Method to generate and print the Fibonacci sequence
    public static void generateFibonacci(int terms) {

        if (terms <= 0) {
            System.out.println("Please enter a positive number of terms.");
            return;
        }

        int first = 0;
        int second = 1;

        System.out.println("Fibonacci Sequence:");

        for (int i = 1; i <= terms; i++) {

            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take the number of terms from the user
        System.out.print("Enter the number of terms: ");
        int terms = sc.nextInt();

        // Generate the sequence
        generateFibonacci(terms);

        sc.close();
    }
}
