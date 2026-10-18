package javaControlFlow.Level2;

import java.util.Scanner;

/*
 * Calculates average marks and determines the grade and remarks.
 */

public class StudentGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Physics marks: ");
        double physics = input.nextDouble();

        System.out.print("Enter Chemistry marks: ");
        double chemistry = input.nextDouble();

        System.out.print("Enter Mathematics marks: ");
        double maths = input.nextDouble();

        if (physics < 0 || physics > 100
                || chemistry < 0 || chemistry > 100
                || maths < 0 || maths > 100) {
            System.out.println("Please enter marks between 0 and 100.");
        } else {
            double average = (physics + chemistry + maths) / 3.0;
            char grade;
            String remarks;

            if (average >= 80) {
                grade = 'A';
                remarks = "Level 4, above agency-normalized standards";
            } else if (average >= 70) {
                grade = 'B';
                remarks = "Level 3, at agency-normalized standards";
            } else if (average >= 60) {
                grade = 'C';
                remarks = "Level 2, below but approaching agency-normalized standards";
            } else if (average >= 50) {
                grade = 'D';
                remarks = "Level 1, well below agency-normalized standards";
            } else if (average >= 40) {
                grade = 'E';
                remarks = "Level 1-, too below agency-normalized standards";
            } else {
                grade = 'R';
                remarks = "Remedial standards";
            }

            System.out.printf("Average Mark: %.2f%%%n", average);
            System.out.println("Grade: " + grade);
            System.out.println("Remarks: " + remarks);
        }

        input.close();
    }
}
