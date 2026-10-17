package javaProgrammingElement.Level2;

import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Take temperature in Fahrenheit
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = input.nextDouble();

        // Convert Fahrenheit to Celsius
        double celsiusResult = (fahrenheit - 32) * 5 / 9;

        // Display the result
        System.out.printf(
                "The %.2f Fahrenheit is %.2f Celsius%n",
                fahrenheit, celsiusResult
        );

        input.close();
    }
}
