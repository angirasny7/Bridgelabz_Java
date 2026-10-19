package Arrays.Level1;

import java.util.Scanner;

/*
 * Implements FizzBuzz from 0 to a given number and stores
 * the results in a String array.
 */

public class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number from the user
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        // Validate the input
        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer.");
            input.close();
            System.exit(0);
        }

        // Create an array to store the FizzBuzz results from 0 to number
        String[] results = new String[number + 1];

        // Calculate and store the FizzBuzz result for each number
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }

        // Display the results with their positions
        for (int i = 0; i < results.length; i++) {
            System.out.println("Position " + (i + 1) + " = " + results[i]);
        }

        input.close();
    }
}