package javaControlFlow.Level3;

import java.util.Scanner;

/*
 * Checks whether a number is an Armstrong number using digit cubes.
 */

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            int originalNumber = number;
            int sum = 0;

            // Calculate the sum of cubes of the digits
            while (number != 0) {
                int digit = number % 10;
                sum += digit * digit * digit;
                number /= 10;
            }

            if (sum == originalNumber) {
                System.out.println(originalNumber + " is an Armstrong Number.");
            } else {
                System.out.println(originalNumber + " is not an Armstrong Number.");
            }
        }

        input.close();
    }
}
