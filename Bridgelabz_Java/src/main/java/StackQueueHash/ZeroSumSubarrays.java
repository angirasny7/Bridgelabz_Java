package StackQueueHash;

/*
 * Problem: Find All Subarrays with Zero Sum
 *
 * Description:
 * Given an integer array, find and print all contiguous
 * subarrays whose sum is equal to zero.
 *
 * Approach:
 * Use prefix sum and HashMap to store previous prefix sums
 * and their indices. Repeated prefix sums indicate zero-sum
 * subarrays.
 *
 * Time Complexity: O(n + output size)
 * Space Complexity: O(n)
 */

import java.util.*;

public class ZeroSumSubarrays {

    static void findZeroSumSubarrays(int[] arr) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int prefixSum = 0;

        boolean found = false;

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            // Subarray from index 0 to i
            if (prefixSum == 0) {

                printSubarray(arr, 0, i);
                found = true;
            }

            // Check if prefix sum already exists
            if (map.containsKey(prefixSum)) {

                for (int startIndex : map.get(prefixSum)) {

                    printSubarray(arr, startIndex + 1, i);
                    found = true;
                }
            }

            // Store current index for this prefix sum
            map.computeIfAbsent(prefixSum,
                    key -> new ArrayList<>()).add(i);
        }

        if (!found) {
            System.out.println("No zero-sum subarray found");
        }
    }

    // Print subarray between given indices
    static void printSubarray(int[] arr, int start, int end) {

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, -3, 3, -1, -2};

        System.out.println("Zero Sum Subarrays:");

        findZeroSumSubarrays(arr);
    }
}
