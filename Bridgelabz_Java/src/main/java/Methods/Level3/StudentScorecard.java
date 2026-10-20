package Methods.Level3;

import java.util.Scanner;

public class StudentScorecard {

    // Generate random marks for each student in three subjects
    public static int[][] generateMarks(int students) {
        int[][] marks = new int[students][3];

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = (int) (Math.random() * 100);
            }
        }

        return marks;
    }

    // Calculate total, average, and percentage
    public static double[][] calculateScores(int[][] marks) {
        double[][] scores = new double[marks.length][3];

        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = total / 3.0;

            scores[i][0] = total;
            scores[i][1] = Math.round(average * 100.0) / 100.0;
            scores[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return scores;
    }

    // Determine the grade from the percentage
    public static char calculateGrade(double percentage) {
        if (percentage >= 80) {
            return 'A';
        } else if (percentage >= 70) {
            return 'B';
        } else if (percentage >= 60) {
            return 'C';
        } else if (percentage >= 50) {
            return 'D';
        } else if (percentage >= 40) {
            return 'E';
        } else {
            return 'R';
        }
    }

    // Display the student scorecard
    public static void displayScorecard(int[][] marks, double[][] scores) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-12s %-8s%n",
                "Student", "Physics", "Chemistry", "Maths",
                "Total", "Average", "Percentage", "Grade");

        for (int i = 0; i < marks.length; i++) {
            char grade = calculateGrade(scores[i][2]);

            System.out.printf(
                    "%-10d %-10d %-10d %-10d %-10.0f %-10.2f %-12.2f %-8c%n",
                    i + 1,
                    marks[i][0],
                    marks[i][1],
                    marks[i][2],
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    grade);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int students = sc.nextInt();

        if (students <= 0) {
            System.out.println("Number of students must be positive.");
            sc.close();
            return;
        }

        int[][] marks = generateMarks(students);
        double[][] scores = calculateScores(marks);

        displayScorecard(marks, scores);

        sc.close();
    }
}