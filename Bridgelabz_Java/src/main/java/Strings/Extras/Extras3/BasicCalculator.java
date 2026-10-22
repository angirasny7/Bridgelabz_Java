
package Strings.Extras.Extras3;

import java.util.Scanner;

/*
 * Problem:
 * Create a basic calculator that performs addition,
 * subtraction, multiplication, and division.
 * Each operation must have its own function.
 */

public class BasicCalculator {

    // Method to perform addition
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    // Method to perform subtraction
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Method to perform multiplication
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Method to perform division
    public static double divide(double num1, double num2) {
        return num1 / num2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Display the operation menu
        System.out.println("Basic Calculator");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        // Take the user's choice
        System.out.print("Choose an operation (1-4): ");
        int choice = sc.nextInt();

        if (choice < 1 || choice > 4) {
            System.out.println("Invalid operation choice!");
        } else {

            // Take two numbers
            System.out.print("Enter the first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = sc.nextDouble();

            double result = 0;
            boolean valid = true;

            // Perform the selected operation
            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    break;

                case 2:
                    result = subtract(num1, num2);
                    break;

                case 3:
                    result = multiply(num1, num2);
                    break;

                case 4:
                    if (num2 == 0) {
                        System.out.println(
                                "Error: Division by zero is not allowed.");
                        valid = false;
                    } else {
                        result = divide(num1, num2);
                    }
                    break;

                default:
                    valid = false;
            }

            // Display the result
            if (valid) {
                System.out.println("Result: " + result);
            }
        }

        sc.close();
    }
}
