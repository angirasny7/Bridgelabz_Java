package Arrays.Level2;

import java.util.Scanner;

/*
 * Extracts the digits of a number into an array, dynamically
 * increases the array capacity, and finds the largest and
 * second-largest distinct digits.
 */

public class LargestSecondLargestDigitV2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number as a string
        System.out.print("Enter an integer: ");
        String number = input.next();

        // Remove the negative sign if present
        if (number.charAt(0) == '-') {
            number = number.substring(1);
        }

        // Initialize the array capacity and index
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Extract digits and store them in the array
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = number.charAt(i) - '0';

            // Increase the array capacity if it is full
            if (index == maxDigit) {
                maxDigit *= 2;

                int[] temp = new int[maxDigit];

                for (int j = 0; j < digits.length; j++) {
                    temp[j] = digits[j];
                }

                digits = temp;
            }

            digits[index] = digit;
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
        System.out.println("Largest digit: " + largest);

        if (secondLargest == -1) {
            System.out.println("Second-largest distinct digit does not exist.");
        } else {
            System.out.println("Second-largest digit: " + secondLargest);
        }

        input.close();
    }
}