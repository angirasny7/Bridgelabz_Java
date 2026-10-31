package Sorting;
/*
 * Problem Statement:
 * A bookstore maintains a list of book prices in an array.
 * Implement Merge Sort to arrange the book prices
 * in ascending order.
 *
 * Divide the array into two halves recursively.
 * Sort both halves and merge them by comparing elements
 * to obtain the final sorted array.
 */

import java.util.Arrays;

public class MergeSort {

    // Method to divide the array into smaller parts
    static void mergeSort(int[] prices, int left, int right) {

        // Continue dividing while more than one element exists
        if (left < right) {

            // Find the middle index
            int mid = left + (right - left) / 2;

            // Sort the left half
            mergeSort(prices, left, mid);

            // Sort the right half
            mergeSort(prices, mid + 1, right);

            // Merge both sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Method to merge two sorted subarrays
    static void merge(int[] prices, int left, int mid, int right) {

        // Calculate sizes of both subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy elements into the left temporary array
        for (int i = 0; i < n1; i++) {
            leftArray[i] = prices[left + i];
        }

        // Copy elements into the right temporary array
        for (int j = 0; j < n2; j++) {
            rightArray[j] = prices[mid + 1 + j];
        }

        // Initialize pointers for both arrays and original array
        int i = 0;
        int j = 0;
        int k = left;

        // Compare elements and merge in ascending order
        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements from the left array
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from the right array
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        // Array containing unsorted book prices
        int[] prices = {450, 200, 750, 150, 600};

        // Call Merge Sort
        mergeSort(prices, 0, prices.length - 1);

        // Display the sorted book prices
        System.out.println("Sorted Book Prices: "
                + Arrays.toString(prices));
    }
}