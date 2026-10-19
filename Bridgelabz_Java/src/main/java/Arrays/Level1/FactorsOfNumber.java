package Arrays.Level1;

import java.util.Scanner;

/*
 * Finds the factors of a number, stores them in an array,
 * and displays the factors.
 */

public class FactorsOfNumber {
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

        // Initialize the array capacity and index
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        // Find the factors and store them in the array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {

                // Increase the array size if it is full
                if (index == maxFactor) {
                    maxFactor = maxFactor * 2;

                    int[] temp = new int[maxFactor];

                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }

                    factors = temp;
                }

                factors[index] = i;
                index++;
            }
        }

        // Display the factors
        System.out.print("Factors of " + number + ": ");

        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        System.out.println();
        input.close();
    }
}