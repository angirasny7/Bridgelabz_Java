package Arrays.Level2;

import java.util.Scanner;

/*
 * Finds the youngest and tallest among Amar, Akbar, and Anthony
 * using their ages and heights.
 */

public class YoungestTallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Store the names of the three friends
        String[] names = {"Amar", "Akbar", "Anthony"};

        // Create arrays to store ages and heights
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Get the age and height of each friend
        for (int i = 0; i < names.length; i++) {
            System.out.println("\nEnter details for " + names[i] + ":");

            System.out.print("Age: ");
            ages[i] = input.nextInt();

            System.out.print("Height in cm: ");
            heights[i] = input.nextDouble();
        }

        // Initialize indices for the youngest and tallest friends
        int youngestIndex = 0;
        int tallestIndex = 0;

        // Find the youngest and tallest friends
        for (int i = 1; i < names.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }

            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display the results
        System.out.println("\nYoungest friend: " + names[youngestIndex]
                + ", Age: " + ages[youngestIndex]);

        System.out.println("Tallest friend: " + names[tallestIndex]
                + ", Height: " + heights[tallestIndex] + " cm");

        input.close();
    }
}