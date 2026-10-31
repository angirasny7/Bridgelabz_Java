package LinearBinaryStringConcepts.LinearBinarySearch;

import java.util.Arrays;

public class FirstMissingPositiveAndBinarySearch {

    /*
     * Problem:
     * Find the first missing positive integer using Linear Search.
     * Sort the array and use Binary Search to find the target index.
     */

    // Method to find the first missing positive integer
    static int findFirstMissingPositive(int[] arr) {

        // Start checking from the smallest positive integer
        int number = 1;

        // Continue until a missing positive integer is found
        while (true) {

            // Assume the current number is not present
            boolean found = false;

            // Search for the current number in the array
            for (int i = 0; i < arr.length; i++) {

                // Check whether the current number exists
                if (arr[i] == number) {

                    found = true;
                    break;
                }
            }

            // If the number is not found, it is the first missing positive
            if (!found) {
                return number;
            }

            // Check the next positive integer
            number++;
        }
    }

    // Method to find the target index using Binary Search
    static int binarySearch(int[] arr, int target) {

        // Initialize the search boundaries
        int left = 0;
        int right = arr.length - 1;

        // Perform Binary Search
        while (left <= right) {

            // Calculate the middle index safely
            int mid = left + (right - left) / 2;

            // Check whether the target is found
            if (arr[mid] == target) {
                return mid;
            }

            // Search the left half if target is smaller
            else if (arr[mid] > target) {
                right = mid - 1;
            }

            // Search the right half if target is greater
            else {
                left = mid + 1;
            }
        }

        // Return -1 if the target is not present
        return -1;
    }

    public static void main(String[] args) {

        // Initialize the input array
        int[] arr = {3, 4, -1, 1};

        // Define the target element
        int target = 4;

        // Part 1: Find the first missing positive integer
        int missingPositive = findFirstMissingPositive(arr);

        // Display the first missing positive integer
        System.out.println("First Missing Positive: " + missingPositive);

        // Part 2: Sort the array before performing Binary Search
        Arrays.sort(arr);

        // Display the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        // Search for the target using Binary Search
        int index = binarySearch(arr, target);

        // Display the search result
        if (index != -1) {
            System.out.println("Target Index: " + index);
        } else {
            System.out.println("Target not found. Index: -1");
        }
    }
}
