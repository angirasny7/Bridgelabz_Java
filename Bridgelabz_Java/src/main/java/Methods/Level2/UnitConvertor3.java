package Methods.Level2;

import java.util.Scanner;

/*
 * Converts temperature, weight, and volume
 * using static methods.
 */

public class UnitConvertor3 {

    // Converts Fahrenheit to Celsius.
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        double fahrenheit2celsius = (fahrenheit - 32) * 5 / 9;
        return fahrenheit2celsius;
    }

    // Converts Celsius to Fahrenheit.
    public static double convertCelsiusToFahrenheit(double celsius) {
        double celsius2fahrenheit = (celsius * 9 / 5) + 32;
        return celsius2fahrenheit;
    }

    // Converts pounds to kilograms.
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    // Converts kilograms to pounds.
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    // Converts gallons to liters.
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    // Converts liters to gallons.
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Convert Fahrenheit to Celsius.
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = input.nextDouble();
        System.out.printf("Temperature in Celsius: %.2f%n",
                convertFahrenheitToCelsius(fahrenheit));

        // Convert Celsius to Fahrenheit.
        System.out.print("Enter temperature in Celsius: ");
        double celsius = input.nextDouble();
        System.out.printf("Temperature in Fahrenheit: %.2f%n",
                convertCelsiusToFahrenheit(celsius));

        // Convert pounds to kilograms.
        System.out.print("Enter weight in pounds: ");
        double pounds = input.nextDouble();
        System.out.printf("Weight in kilograms: %.2f%n",
                convertPoundsToKilograms(pounds));

        // Convert kilograms to pounds.
        System.out.print("Enter weight in kilograms: ");
        double kilograms = input.nextDouble();
        System.out.printf("Weight in pounds: %.2f%n",
                convertKilogramsToPounds(kilograms));

        // Convert gallons to liters.
        System.out.print("Enter volume in gallons: ");
        double gallons = input.nextDouble();
        System.out.printf("Volume in liters: %.2f%n",
                convertGallonsToLiters(gallons));

        // Convert liters to gallons.
        System.out.print("Enter volume in liters: ");
        double liters = input.nextDouble();
        System.out.printf("Volume in gallons: %.2f%n",
                convertLitersToGallons(liters));

        input.close();
    }
}