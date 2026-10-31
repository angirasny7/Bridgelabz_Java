package Sorting;
/*
 * Problem Statement:
 * An e-commerce company maintains product prices
 * in an unsorted array.
 * Implement Quick Sort to arrange the product prices
 * in ascending order.
 *
 * Select a pivot element and partition the array
 * such that smaller elements are placed on the left
 * and larger elements are placed on the right.
 * Recursively sort both partitions.
 */

import java.util.Arrays;

public class QuickSort {

    // Method to partition the array around the pivot
    static int partition(int[] prices, int low, int high) {

        // Select the last element as the pivot
        int pivot = prices[high];

        // Index of the smaller element
        int i = low - 1;

        // Traverse elements before the pivot
        for (int j = low; j < high; j++) {

            // Move smaller elements to the left
            if (prices[j] <= pivot) {
                i++;

                // Swap elements
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Place pivot in its correct sorted position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        // Return the pivot's final position
        return i + 1;
    }

    // Method to recursively sort the partitions
    static void quickSort(int[] prices, int low, int high) {

        if (low < high) {

            // Find the correct position of the pivot
            int pivotIndex = partition(prices, low, high);

            // Sort elements before the pivot
            quickSort(prices, low, pivotIndex - 1);

            // Sort elements after the pivot
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {

        // Array containing unsorted product prices
        int[] prices = {500, 200, 800, 100, 400};

        // Call Quick Sort
        quickSort(prices, 0, prices.length - 1);

        // Display sorted product prices
        System.out.println("Sorted Product Prices: "
                + Arrays.toString(prices));
    }
}