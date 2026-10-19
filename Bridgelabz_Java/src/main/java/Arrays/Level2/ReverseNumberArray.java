package Arrays.Level2;

import java.util.Scanner;

/*
 * Stores the digits of a number in an array and displays
 * them in reverse order to reverse the number.
 */

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number from the user
        System.out.print("Enter an integer: ");
        String number = input.next();

        // Handle a negative number
        boolean isNegative = number.charAt(0) == '-';

        if (isNegative) {
            number = number.substring(1);
        }

        // Create an array to store the digits
        int numberOfDigits = number.length();
        int[] digits = new int[numberOfDigits];

        // Extract the digits and store them in the array
        for (int i = 0; i < numberOfDigits; i++) {
            digits[i] = number.charAt(i) - '0';
        }

        // Display the digits in reverse order
        System.out.print("Reversed number: ");

        if (isNegative) {
            System.out.print("-");
        }

        for (int i = numberOfDigits - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }

        System.out.println();
        input.close();
    }
}