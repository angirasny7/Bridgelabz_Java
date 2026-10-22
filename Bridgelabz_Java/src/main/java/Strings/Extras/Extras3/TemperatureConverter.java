
package Strings.Extras.Extras3;

import java.util.Scanner;

/*
 * Problem:
 * Convert temperatures between Fahrenheit and Celsius.
 * Use separate functions for Fahrenheit-to-Celsius
 * and Celsius-to-Fahrenheit conversions.
 */

public class TemperatureConverter {

    // Convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    // Convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    // Display the conversion result
    public static void displayResult(
            double temperature, double result, int choice) {

        if (choice == 1) {
            System.out.printf("%.2f Fahrenheit = %.2f Celsius%n",
                    temperature, result);
        } else {
            System.out.printf("%.2f Celsius = %.2f Fahrenheit%n",
                    temperature, result);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");

        System.out.print("Enter your choice (1 or 2): ");
        int choice = sc.nextInt();

        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice!");
        } else {
            System.out.print("Enter the temperature: ");
            double temperature = sc.nextDouble();

            double result;

            if (choice == 1) {
                result = fahrenheitToCelsius(temperature);
            } else {
                result = celsiusToFahrenheit(temperature);
            }

            displayResult(temperature, result, choice);
        }

        sc.close();
    }
}
