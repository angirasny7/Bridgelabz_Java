package Arrays.Level2;

import java.util.Scanner;

/*
 * Stores student marks in a 2D array and calculates
 * their percentages and grades.
 */

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number of students
        System.out.print("Enter the number of students: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Error: Number of students must be positive.");
            input.close();
            return;
        }

        // Create a 2D array to store three subject marks
        double[][] marks = new double[number][3];
        double[] percentages = new double[number];
        char[] grades = new char[number];

        // Get marks for each student
        for (int i = 0; i < number; i++) {
            System.out.println("\nStudent " + (i + 1));

            for (int j = 0; j < 3; j++) {
                String subject;

                if (j == 0) {
                    subject = "Physics";
                } else if (j == 1) {
                    subject = "Chemistry";
                } else {
                    subject = "Mathematics";
                }

                System.out.print("Enter " + subject + " marks (0-100): ");
                marks[i][j] = input.nextDouble();

                while (marks[i][j] < 0 || marks[i][j] > 100) {
                    System.out.print("Invalid marks. Enter " + subject + " marks (0-100): ");
                    marks[i][j] = input.nextDouble();
                }
            }
        }

        // Calculate percentages and assign grades
        for (int i = 0; i < number; i++) {
            double totalMarks = 0;

            for (int j = 0; j < 3; j++) {
                totalMarks += marks[i][j];
            }

            percentages[i] = totalMarks / 3.0;

            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        // Display the results
        System.out.println("\nStudent Results");
        System.out.printf("%-10s %-10s %-12s %-15s %-12s %-8s%n",
                "Student", "Physics", "Chemistry", "Mathematics",
                "Percentage", "Grade");

        for (int i = 0; i < number; i++) {
            System.out.printf("%-10d %-10.2f %-12.2f %-15.2f %-12.2f %-8c%n",
                    i + 1,
                    marks[i][0],
                    marks[i][1],
                    marks[i][2],
                    percentages[i],
                    grades[i]);
        }

        input.close();
    }
}