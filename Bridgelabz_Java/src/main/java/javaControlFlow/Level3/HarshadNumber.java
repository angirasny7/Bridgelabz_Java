package javaControlFlow.Level3;

import java.util.Scanner;

/*
 * Checks whether a number is divisible by the sum of its digits.
 */

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int originalNumber = number;
            int sum = 0;

            // Calculate the sum of the digits
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (originalNumber % sum == 0) {
                System.out.println(originalNumber + " is a Harshad Number.");
            } else {
                System.out.println(originalNumber + " is not a Harshad Number.");
            }
        }

        input.close();
    }
}
