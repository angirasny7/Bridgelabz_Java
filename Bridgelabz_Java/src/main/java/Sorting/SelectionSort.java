package Sorting;
/*
 * Problem Statement:
 * A university maintains students' exam scores
 * in an unsorted array.
 * Implement Selection Sort to arrange the scores
 * in ascending order.
 *
 * Find the minimum element from the unsorted portion
 * and swap it with the first unsorted element.
 * Repeat until the entire array is sorted.
 */

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        // Array containing unsorted exam scores
        int[] scores = {78, 45, 92, 65, 88};

        // Traverse the array to find minimum elements
        for (int i = 0; i < scores.length - 1; i++) {

            // Assume the current element is the minimum
            int minIndex = i;

            // Find the minimum element in the unsorted portion
            for (int j = i + 1; j < scores.length; j++) {

                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the minimum element with the first
            // element of the unsorted portion
            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }

        // Display the sorted exam scores
        System.out.println("Sorted Exam Scores: "
                + Arrays.toString(scores));
    }
}