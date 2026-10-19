package Arrays.Level2;

import java.util.Scanner;

/*
 * Finds the frequency of each digit in an integer
 * using a digit array and a frequency array.
 */

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take the number as input
        System.out.print("Enter an integer: ");
        String number = input.next();

        // Remove the negative sign if present
        if (number.charAt(0) == '-') {
            number = number.substring(1);
        }

        // Find the number of digits
        int count = number.length();

        // Create an array to store the digits
        int[] digits = new int[count];

        // Store each digit in the array
        for (int i = 0; i < count; i++) {
            digits[i] = number.charAt(i) - '0';
        }

        // Create a frequency array for digits 0 to 9
        int[] frequency = new int[10];

        // Count the frequency of each digit
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }

        // Display the frequency of each digit
        System.out.println("\nDigit frequencies:");

        for (int i = 0; i < frequency.length; i++) {
            System.out.println("Digit " + i + " = " + frequency[i]);
        }

        input.close();
    }
}