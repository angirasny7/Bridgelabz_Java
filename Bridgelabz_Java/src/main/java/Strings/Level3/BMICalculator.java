
package Strings.Level3;

import java.util.Scanner;

/*
 * Problem:
 * Calculate the BMI and status of 10 people.
 * Store weight and height in a 2D array.
 * Calculate BMI and status using separate methods.
 * Display height, weight, BMI, and status in tabular format.
 */

public class BMICalculator {

    // Method to calculate BMI and status for every person
    public static String[][] calculateBMI(double[][] people) {

        String[][] results = new String[people.length][4];

        for (int i = 0; i < people.length; i++) {

            double weight = people[i][0];
            double heightCm = people[i][1];

            // Convert height from centimeters to meters
            double heightM = heightCm / 100.0;

            // Calculate BMI
            double bmi = weight / (heightM * heightM);

            // Determine BMI status
            String status;

            if (bmi <= 18.4) {
                status = "Underweight";
            } else if (bmi <= 24.9) {
                status = "Normal";
            } else if (bmi <= 39.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            // Store height, weight, BMI, and status
            results[i][0] = String.format("%.2f", heightCm);
            results[i][1] = String.format("%.2f", weight);
            results[i][2] = String.format("%.2f", bmi);
            results[i][3] = status;
        }

        return results;
    }

    // Method to display the results in tabular format
    public static void displayResults(String[][] results) {

        System.out.printf("%-12s %-12s %-12s %-15s%n",
                "Height (cm)", "Weight (kg)", "BMI", "Status");

        System.out.println(
                "-------------------------------------------------------");

        for (int i = 0; i < results.length; i++) {
            System.out.printf("%-12s %-12s %-12s %-15s%n",
                    results[i][0],
                    results[i][1],
                    results[i][2],
                    results[i][3]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Store weight in column 0 and height in column 1
        double[][] people = new double[10][2];

        // Take input for 10 people
        for (int i = 0; i < people.length; i++) {

            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter weight (kg): ");
            people[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm): ");
            people[i][1] = sc.nextDouble();

            if (people[i][0] <= 0 || people[i][1] <= 0) {
                System.out.println(
                        "Weight and height must be positive. "
                                + "Please enter this person's details again.");
                i--;
            }
        }

        // Calculate BMI and status
        String[][] results = calculateBMI(people);

        // Display the results
        System.out.println("\nBMI Report");
        displayResults(results);

        sc.close();
    }
}
