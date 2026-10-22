package Strings.Level2;

import java.util.Random;

/*
 * Question:
 * Generate ages for 10 students and check whether each student
 * can vote based on their age.
 *
 * Age >= 18: Can Vote
 * Age < 18 or negative: Cannot Vote
 */

// Class to check the voting eligibility of students
public class VotingEligibility {

    // Method to generate random two-digit ages for n students
    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            ages[i] = random.nextInt(90) + 10;
        }

        return ages;
    }

    // Method to determine voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }

        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayTable(String[][] result) {
        System.out.printf("%-15s %-20s%n", "Age", "Can Vote?");
        System.out.println("-----------------------------------");

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-15s %-20s%n",
                    result[i][0], result[i][1]);
        }
    }

    public static void main(String[] args) {
        int numberOfStudents = 10;

        // Generate random ages for 10 students
        int[] ages = generateAges(numberOfStudents);

        // Check voting eligibility
        String[][] result = checkVotingEligibility(ages);

        // Display the result
        System.out.println("Voting Eligibility of Students:\n");
        displayTable(result);
    }
}