
package RuntimeAnalysis;

import java.util.Arrays;

/*
 * Problem Description:
 * Compare Linear Search and Binary Search to find a target
 * element in a dataset.
 *
 * Linear Search checks elements one by one.
 * Binary Search repeatedly divides the sorted array into halves.
 *
 * Objective:
 * Understand the performance difference between O(N)
 * and O(log N) searching algorithms.
 *
 * Time Complexity:
 * Linear Search  : O(N)
 * Binary Search  : O(log N)
 *
 * Binary Search requires sorted data.
 */

public class SearchPerformanceComparison {

    // Searches for the target by checking each element.
    public static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    // Searches for the target by repeatedly dividing the array.
    public static int binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        int target = 50;

        // Perform Linear Search.
        System.out.println("Linear Search: "
                + linearSearch(arr, target));

        // Sort the array before performing Binary Search.
        Arrays.sort(arr);

        System.out.println("Binary Search: "
                + binarySearch(arr, target));
    }
}
