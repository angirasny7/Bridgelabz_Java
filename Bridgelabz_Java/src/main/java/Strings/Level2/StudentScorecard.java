package Strings.Level2;

import java.util.Random;

/*
 * Question:
 * Generate random marks for students in Physics, Chemistry, and Maths.
 * Calculate the total, average, percentage, and grade for each student.
 * Display the results in a tabular format.
 *
 * Grade Criteria:
 * A: 80% and above
 * B: 70% - 79%
 * C: 60% - 69%
 * D: 50% - 59%
 * E: 40% - 49%
 * R: 39% and below
 */

public class StudentScorecard {

    // Method 1: Generate random two-digit marks for n students
    public static int[][] generateMarks(int n) {
        int[][] marks = new int[n][3];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            marks[i][0] = random.nextInt(100); // Physics
            marks[i][1] = random.nextInt(100); // Chemistry
            marks[i][2] = random.nextInt(100); // Maths
        }

        return marks;
    }

    // Method 2: Calculate total, average, and percentage
    public static double[][] calculateResults(int[][] marks) {
        double[][] results = new double[marks.length][4];

        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];

            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Round average and percentage to 2 decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
            results[i][3] = total / 3;
        }

        return results;
    }

    // Method 3: Calculate the grade based on percentage
    public static String[][] calculateGrades(double[][] results) {
        String[][] grades = new String[results.length][2];

        for (int i = 0; i < results.length; i++) {
            double percentage = results[i][2];

            grades[i][0] = String.valueOf(percentage);

            if (percentage >= 80) {
                grades[i][1] = "A";
            } else if (percentage >= 70) {
                grades[i][1] = "B";
            } else if (percentage >= 60) {
                grades[i][1] = "C";
            } else if (percentage >= 50) {
                grades[i][1] = "D";
            } else if (percentage >= 40) {
                grades[i][1] = "E";
            } else {
                grades[i][1] = "R";
            }
        }

        return grades;
    }

    // Method 4: Display all students' scorecards
    public static void displayScorecard(
            int[][] marks, double[][] results, String[][] grades) {

        System.out.printf(
                "%-10s %-10s %-10s %-10s %-10s %-12s %-12s %-10s%n",
                "Student", "Physics", "Chemistry", "Maths",
                "Total", "Average", "Percentage", "Grade"
        );

        System.out.println(
                "------------------------------------------------------------------------------------------"
        );

        for (int i = 0; i < marks.length; i++) {
            System.out.printf(
                    "%-10d %-10d %-10d %-10d %-10.0f %-12.2f %-12.2f %-10s%n",
                    i + 1,
                    marks[i][0],
                    marks[i][1],
                    marks[i][2],
                    results[i][0],
                    results[i][1],
                    results[i][2],
                    grades[i][1]
            );
        }
    }

    public static void main(String[] args) {

        int numberOfStudents = 10;

        // Generate marks for all students
        int[][] marks = generateMarks(numberOfStudents);

        // Calculate totals, averages, and percentages
        double[][] results = calculateResults(marks);

        // Calculate grades
        String[][] grades = calculateGrades(results);

        // Display the scorecard
        displayScorecard(marks, results, grades);
    }
}