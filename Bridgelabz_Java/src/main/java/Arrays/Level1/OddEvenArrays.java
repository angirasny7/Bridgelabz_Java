package Arrays.Level1;

import java.util.Scanner;

/*
 * Separates odd and even numbers from 1 to the given number
 * and stores them in separate arrays.
 */

public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number from the user
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        // Check whether the number is a natural number
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number.");
            input.close();
            System.exit(0);
        }

        // Create arrays to store odd and even numbers
        int[] odd = new int[number / 2 + 1];
        int[] even = new int[number / 2 + 1];

        // Initialize indices for both arrays
        int oddIndex = 0;
        int evenIndex = 0;

        // Separate numbers into odd and even arrays
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even[evenIndex] = i;
                evenIndex++;
            } else {
                odd[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print the odd numbers
        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }

        // Print the even numbers
        System.out.print("\nEven numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }

        System.out.println();
        input.close();
    }
}