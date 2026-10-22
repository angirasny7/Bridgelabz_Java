
package Strings.Extras.Extras3;

import java.util.Scanner;

/*
 * Problem:
 * Take three integer inputs from the user
 * and find the maximum among the three numbers.
 * Use separate methods for input and calculation.
 */

public class MaximumOfThreeNumbers {

    // Method to take an integer input
    public static int takeInput(Scanner sc, String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    // Method to find the maximum of three numbers
    public static int findMaximum(int num1, int num2, int num3) {

        if (num1 >= num2 && num1 >= num3) {
            return num1;
        } else if (num2 >= num1 && num2 >= num3) {
            return num2;
        } else {
            return num3;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take three numbers from the user
        int num1 = takeInput(sc, "Enter the first number: ");
        int num2 = takeInput(sc, "Enter the second number: ");
        int num3 = takeInput(sc, "Enter the third number: ");

        // Calculate and display the maximum
        int maximum = findMaximum(num1, num2, num3);

        System.out.println("Maximum number: " + maximum);

        sc.close();
    }
}
