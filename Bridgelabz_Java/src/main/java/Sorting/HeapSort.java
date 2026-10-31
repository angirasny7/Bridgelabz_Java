package Sorting;
/*
 * Problem Statement:
 * A company receives job applications with different
 * expected salary demands.
 * Implement Heap Sort to arrange the salary demands
 * in ascending order.
 *
 * Build a Max Heap from the array.
 * Extract the largest element and place it at the end.
 * Rebuild the heap for the remaining elements.
 * Repeat until the array is completely sorted.
 */

import java.util.Arrays;

public class HeapSort {

    // Method to maintain the Max Heap property
    static void heapify(int[] salaries, int n, int i) {

        // Assume the current node is the largest
        int largest = i;

        // Calculate indices of left and right children
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if the left child is greater than the root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check if the right child is greater than the largest
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If the largest element is not the root, swap them
        if (largest != i) {

            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Method to perform Heap Sort
    static void heapSort(int[] salaries) {

        int n = salaries.length;

        // Step 1: Build a Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Step 2: Extract the largest element one by one
        for (int i = n - 1; i > 0; i--) {

            // Move the root (largest element) to the end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Restore Max Heap property for remaining elements
            heapify(salaries, i, 0);
        }
    }

    public static void main(String[] args) {

        // Array containing expected salary demands
        int[] salaries = {50000, 30000, 70000, 40000, 60000};

        // Call Heap Sort
        heapSort(salaries);

        // Display sorted salary demands
        System.out.println("Sorted Salary Demands: "
                + Arrays.toString(salaries));
    }
}