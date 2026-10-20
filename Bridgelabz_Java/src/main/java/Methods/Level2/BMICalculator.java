package Methods.Level2;

import java.util.Scanner;

/*
 * Calculates the BMI of 10 people and determines their BMI status
 * based on their weight and height.
 */

public class BMICalculator {

    // Calculates the BMI of each person and stores it in the third column.
    public static void calculateBMI(double[][] people) {
        for (int i = 0; i < people.length; i++) {
            double weight = people[i][0];
            double heightInMeters = people[i][1] / 100.0;

            people[i][2] = weight / (heightInMeters * heightInMeters);
        }
    }

    // Determines the BMI status of each person.
    public static String[] calculateBMIStatus(double[][] people) {
        String[] status = new String[people.length];

        for (int i = 0; i < people.length; i++) {
            double bmi = people[i][2];

            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        return status;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Store weight, height in centimeters, and BMI for 10 people.
        double[][] people = new double[10][3];

        // Take weight and height as input for each person.
        for (int i = 0; i < people.length; i++) {
            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter weight in kg: ");
            people[i][0] = input.nextDouble();

            System.out.print("Enter height in cm: ");
            people[i][1] = input.nextDouble();
        }

        // Calculate BMI and determine the status of each person.
        calculateBMI(people);
        String[] status = calculateBMIStatus(people);

        // Display the height, weight, BMI, and status of each person.
        System.out.println("\n----- BMI Report -----");
        System.out.printf("%-10s %-12s %-12s %-12s %-15s%n",
                "Person", "Height(cm)", "Weight(kg)", "BMI", "Status");

        for (int i = 0; i < people.length; i++) {
            System.out.printf("%-10d %-12.2f %-12.2f %-12.2f %-15s%n",
                    i + 1,
                    people[i][1],
                    people[i][0],
                    people[i][2],
                    status[i]);
        }

        input.close();
    }
}