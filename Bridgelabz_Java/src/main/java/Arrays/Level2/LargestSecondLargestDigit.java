package Arrays.Level2;

import java.util.Scanner;

/*
 * Extracts the digits of a number, stores them in an array,
 * and finds the largest and second-largest digits.
 */

public class LargestSecondLargestDigit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number from the user
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        // Handle negative numbers
        number = Math.abs(number);

        // Initialize the array capacity and index
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Extract digits and store them in the array
        while (number != 0) {
            int digit = number % 10;

            // Increase array capacity if it is full
            if (index == maxDigit) {
                maxDigit = maxDigit * 2;

                int[] temp = new int[maxDigit];

                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                digits = temp;
            }

            digits[index] = digit;
            index++;

            number = number / 10;
        }

        // Handle the input number 0
        if (index == 0) {
            digits[index] = 0;
            index++;
        }

        // Initialize the largest and second-largest digits
        int largest = -1;
        int secondLargest = -1;

        // Find the largest and second-largest distinct digits
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] < largest) {
                secondLargest = digits[i];
            }
        }

        // Display the digits
        System.out.print("Digits: ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }

        System.out.println();

        // Display the largest and second-largest digits
        System.out.println("Largest digit: " + largest);

        if (secondLargest == -1) {
            System.out.println("Second-largest distinct digit does not exist.");
        } else {
            System.out.println("Second-largest digit: " + secondLargest);
        }

        input.close();
    }
}