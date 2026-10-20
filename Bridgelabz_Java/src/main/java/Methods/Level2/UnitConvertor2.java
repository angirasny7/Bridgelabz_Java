package Methods.Level2;

import java.util.Scanner;

/*
 * Converts distances between yards, feet, meters,
 * inches, and centimeters using static methods.
 */

public class UnitConvertor2 {

    // Converts yards to feet.
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    // Converts feet to yards.
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    // Converts meters to inches.
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    // Converts inches to meters.
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    // Converts inches to centimeters.
    public static double convertInchesToCm(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Convert yards to feet.
        System.out.print("Enter distance in yards: ");
        double yards = input.nextDouble();
        System.out.printf("Distance in feet: %.2f%n",
                convertYardsToFeet(yards));

        // Convert feet to yards.
        System.out.print("Enter distance in feet: ");
        double feet = input.nextDouble();
        System.out.printf("Distance in yards: %.2f%n",
                convertFeetToYards(feet));

        // Convert meters to inches.
        System.out.print("Enter distance in meters: ");
        double meters = input.nextDouble();
        System.out.printf("Distance in inches: %.2f%n",
                convertMetersToInches(meters));

        // Convert inches to meters.
        System.out.print("Enter distance in inches: ");
        double inches = input.nextDouble();
        System.out.printf("Distance in meters: %.4f%n",
                convertInchesToMeters(inches));

        // Convert inches to centimeters.
        System.out.print("Enter distance in inches: ");
        double inchesForCm = input.nextDouble();
        System.out.printf("Distance in centimeters: %.2f%n",
                convertInchesToCm(inchesForCm));

        input.close();
    }
}