package Methods.Level2;

import java.util.Scanner;

/*
 * Checks whether 10 students are eligible to vote
 * based on their ages.
 */

public class StudentVoteChecker {

    // Checks whether a student is eligible to vote.
    public boolean canStudentVote(int age) {

        // Negative age is invalid.
        if (age < 0) {
            return false;
        }

        // A student can vote if their age is 18 or above.
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create an array to store the ages of 10 students.
        int[] ages = new int[10];

        // Create an object to call the non-static method.
        StudentVoteChecker checker = new StudentVoteChecker();

        // Read each student's age and check voting eligibility.
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter the age of student " + (i + 1) + ": ");
            ages[i] = input.nextInt();

            if (checker.canStudentVote(ages[i])) {
                System.out.println("Student " + (i + 1) + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote.");
            }
        }

        input.close();
    }
}