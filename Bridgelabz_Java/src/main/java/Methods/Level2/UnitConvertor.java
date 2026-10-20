package Methods.Level2;

import java.util.Scanner;

/*
 * Converts distances between kilometers and miles,
 * and meters and feet using static methods.
 */

public class UnitConvertor {

    // Converts kilometers to miles.
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    // Converts miles to kilometers.
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    // Converts meters to feet.
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    // Converts feet to meters.
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Convert kilometers to miles.
        System.out.print("Enter distance in kilometers: ");
        double km = input.nextDouble();
        System.out.printf("Distance in miles: %.2f%n", convertKmToMiles(km));

        // Convert miles to kilometers.
        System.out.print("Enter distance in miles: ");
        double miles = input.nextDouble();
        System.out.printf("Distance in kilometers: %.2f%n", convertMilesToKm(miles));

        // Convert meters to feet.
        System.out.print("Enter distance in meters: ");
        double meters = input.nextDouble();
        System.out.printf("Distance in feet: %.2f%n", convertMetersToFeet(meters));

        // Convert feet to meters.
        System.out.print("Enter distance in feet: ");
        double feet = input.nextDouble();
        System.out.printf("Distance in meters: %.2f%n", convertFeetToMeters(feet));

        input.close();
    }
}