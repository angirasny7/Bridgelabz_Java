
package Strings.Extras.Extras3;

import java.util.Scanner;

/*
 * Problem:
 * Calculate the Greatest Common Divisor (GCD)
 * and Least Common Multiple (LCM) of two numbers.
 * Use separate functions for GCD and LCM calculations.
 */

public class GCDAndLCMCalculator {

    // Method to take input from the user
    public static int takeInput(Scanner sc, String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    // Method to calculate GCD using the Euclidean algorithm
    public static int calculateGCD(int num1, int num2) {

        num1 = Math.abs(num1);
        num2 = Math.abs(num2);

        while (num2 != 0) {
            int remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }

        return num1;
    }

    // Method to calculate LCM using the GCD
    public static long calculateLCM(int num1, int num2) {

        if (num1 == 0 || num2 == 0) {
            return 0;
        }

        long a = Math.abs((long) num1);
        long b = Math.abs((long) num2);

        int gcd = calculateGCD(num1, num2);

        return (a / gcd) * b;
    }

    // Method to display the results
    public static void displayResults(
            int num1, int num2, int gcd, long lcm) {

        System.out.println("GCD of " + num1 + " and " + num2
                + " is: " + gcd);

        System.out.println("LCM of " + num1 + " and " + num2
                + " is: " + lcm);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take two numbers
        int num1 = takeInput(sc, "Enter the first number: ");
        int num2 = takeInput(sc, "Enter the second number: ");

        // Calculate GCD and LCM
        int gcd = calculateGCD(num1, num2);
        long lcm = calculateLCM(num1, num2);

        // Display the results
        displayResults(num1, num2, gcd, lcm);

        sc.close();
    }
}
