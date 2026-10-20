package Methods.Level2;

import java.util.Scanner;

/*
 * Finds the youngest and tallest among Amar, Akbar, and Anthony
 * using their ages and heights stored in arrays.
 */

public class FriendsComparison {

    // Finds the youngest friend based on age.
    public static int findYoungest(int[] ages) {
        int youngestIndex = 0;

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }

        return youngestIndex;
    }

    // Finds the tallest friend based on height.
    public static int findTallest(double[] heights) {
        int tallestIndex = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        return tallestIndex;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Store the names of the three friends.
        String[] names = {"Amar", "Akbar", "Anthony"};

        // Create arrays to store ages and heights.
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Take age and height as input for each friend.
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter the age of " + names[i] + ": ");
            ages[i] = input.nextInt();

            System.out.print("Enter the height of " + names[i] + " in cm: ");
            heights[i] = input.nextDouble();
        }

        // Find the youngest and tallest friends.
        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);

        // Display the results.
        System.out.println("\nYoungest friend: " + names[youngestIndex]
                + " (Age: " + ages[youngestIndex] + " years)");

        System.out.println("Tallest friend: " + names[tallestIndex]
                + " (Height: " + heights[tallestIndex] + " cm)");

        input.close();
    }
}