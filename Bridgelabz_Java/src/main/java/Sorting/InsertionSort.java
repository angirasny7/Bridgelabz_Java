package Sorting;
/*
 * Problem Statement:
 * A company stores employee IDs in an unsorted array.
 * Implement Insertion Sort to arrange the employee IDs
 * in ascending order.
 *
 * Divide the array into sorted and unsorted portions.
 * Pick an element from the unsorted portion and insert
 * it into its correct position in the sorted portion.
 */

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        // Array containing unsorted employee IDs
        int[] employeeIds = {105, 102, 108, 101, 104};

        // Start from the second element
        for (int i = 1; i < employeeIds.length; i++) {

            // Store the current element
            int key = employeeIds[i];

            // Consider the previous element
            int j = i - 1;

            // Shift elements greater than key to the right
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }

            // Insert key into its correct position
            employeeIds[j + 1] = key;
        }

        // Display the sorted employee IDs
        System.out.println("Sorted Employee IDs: "
                + Arrays.toString(employeeIds));
    }
}