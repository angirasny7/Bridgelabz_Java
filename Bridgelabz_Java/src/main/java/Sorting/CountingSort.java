package Sorting;
/*
 * Problem Statement:
 * A school collects student ages ranging from 10 to 18.
 * Implement Counting Sort to arrange the ages
 * in ascending order.
 *
 * Create a count array to store the frequency
 * of each age.
 * Use the frequency information to reconstruct
 * the sorted array.
 */

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {

        // Array containing unsorted student ages
        int[] ages = {15, 12, 18, 10, 14, 12, 16, 10};

        // Define the minimum and maximum age
        int min = 10;
        int max = 18;

        // Create a count array to store frequencies
        int[] count = new int[max - min + 1];

        // Step 1: Count the frequency of each age
        for (int age : ages) {
            count[age - min]++;
        }

        // Step 2: Reconstruct the sorted array
        int index = 0;

        // Traverse the count array
        for (int i = 0; i < count.length; i++) {

            // Insert each age according to its frequency
            while (count[i] > 0) {

                ages[index] = i + min;

                index++;
                count[i]--;
            }
        }

        // Display the sorted student ages
        System.out.println("Sorted Student Ages: "
                + Arrays.toString(ages));
    }
}