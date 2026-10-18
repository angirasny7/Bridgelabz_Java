package javaControlFlow.Level1;

import java.util.Scanner;

/*
 * Prints whether each number from 1 to N is odd or even.
 */

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        if (number >= 1) {
            // Check each number from 1 to the given number
            for (int counter = 1; counter <= number; counter++) {
                if (counter % 2 == 0) {
                    System.out.println(counter + " is an even number.");
                } else {
                    System.out.println(counter + " is an odd number.");
                }
            }
        } else {
            System.out.println("Please enter a natural number greater than 0.");
        }

        input.close();
    }
}
