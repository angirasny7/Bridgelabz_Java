package Arrays.Level2;

import java.util.Scanner;

/*
 * Calculates the BMI of multiple people using a 2D array
 * and displays their weight, height, BMI, and weight status.
 */

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number of people
        System.out.print("Enter the number of people: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Error: Number of people must be positive.");
            input.close();
            return;
        }

        // Create a 2D array to store weight, height, and BMI
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Get weight and height for each person
        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter weight in kg: ");
            double weight = input.nextDouble();

            while (weight <= 0) {
                System.out.print("Invalid weight. Enter a positive weight: ");
                weight = input.nextDouble();
            }

            System.out.print("Enter height in cm: ");
            double height = input.nextDouble();

            while (height <= 0) {
                System.out.print("Invalid height. Enter a positive height: ");
                height = input.nextDouble();
            }

            personData[i][0] = weight;
            personData[i][1] = height;
        }

        // Calculate BMI and determine weight status
        for (int i = 0; i < number; i++) {
            double heightInMetres = personData[i][1] / 100.0;

            personData[i][2] = personData[i][0]
                    / (heightInMetres * heightInMetres);

            double bmi = personData[i][2];

            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display the BMI report
        System.out.println("\nBMI Report");
        System.out.printf("%-10s %-15s %-15s %-12s %-15s%n",
                "Person", "Weight (kg)", "Height (cm)", "BMI", "Status");

        for (int i = 0; i < number; i++) {
            System.out.printf("%-10d %-15.2f %-15.2f %-12.2f %-15s%n",
                    i + 1,
                    personData[i][0],
                    personData[i][1],
                    personData[i][2],
                    weightStatus[i]);
        }

        input.close();
    }
}