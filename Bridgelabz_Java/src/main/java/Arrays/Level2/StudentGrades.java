package Arrays.Level2;

import java.util.Scanner;

/*
 * Calculates students' percentages and assigns grades
 * based on their Physics, Chemistry, and Mathematics marks.
 */

public class StudentGrades {
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

        // Create arrays to store marks, percentages, and grades
        double[][] marks = new double[number][3];
        double[] percentages = new double[number];
        char[] grades = new char[number];

        // Get marks for each student
        for (int i = 0; i < number; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Physics marks: ");
            marks[i][0] = input.nextDouble();

            while (marks[i][0] < 0 || marks[i][0] > 100) {
                System.out.print("Invalid marks. Enter Physics marks (0-100): ");
                marks[i][0] = input.nextDouble();
            }

            System.out.print("Enter Chemistry marks: ");
            marks[i][1] = input.nextDouble();

            while (marks[i][1] < 0 || marks[i][1] > 100) {
                System.out.print("Invalid marks. Enter Chemistry marks (0-100): ");
                marks[i][1] = input.nextDouble();
            }

            System.out.print("Enter Mathematics marks: ");
            marks[i][2] = input.nextDouble();

            while (marks[i][2] < 0 || marks[i][2] > 100) {
                System.out.print("Invalid marks. Enter Mathematics marks (0-100): ");
                marks[i][2] = input.nextDouble();
            }
        }

        // Calculate percentages and assign grades
        for (int i = 0; i < number; i++) {
            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];

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

        // Display marks, percentages, and grades
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