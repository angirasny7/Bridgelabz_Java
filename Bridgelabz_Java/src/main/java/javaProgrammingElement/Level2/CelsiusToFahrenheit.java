package javaProgrammingElement.Level2;


import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Take temperature in Celsius
        System.out.print("Enter temperature in Celsius: ");
        double celsius = input.nextDouble();

        // Convert Celsius to Fahrenheit
        double fahrenheitResult = (celsius * 9 / 5) + 32;

        // Display the result
        System.out.printf(
                "The %.2f Celsius is %.2f Fahrenheit%n",
                celsius, fahrenheitResult
        );

        input.close();
    }
}

