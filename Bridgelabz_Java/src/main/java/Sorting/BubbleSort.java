package Sorting;
/*
 * Problem Statement:
 * A school maintains student marks in an array.
 * Implement Bubble Sort to arrange the marks in
 * ascending order.
 *
 * Compare adjacent elements and swap them if they
 * are in the wrong order. Repeat until the array
 * is completely sorted.
 */

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        // Array containing student marks
        int[] marks = {85, 45, 92, 67, 78};

        // Traverse the array multiple times
        for (int i = 0; i < marks.length - 1; i++) {

            boolean swapped = false;

            // Compare adjacent elements
            for (int j = 0; j < marks.length - 1 - i; j++) {

                // Swap if the current element is greater
                // than the next element
                if (marks[j] > marks[j + 1]) {

                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;

                    swapped = true;
                }
            }

            // Stop if no swaps occurred
            if (!swapped) {
                break;
            }
        }

        // Display the sorted marks
        System.out.println("Sorted Student Marks: "
                + Arrays.toString(marks));
    }
}