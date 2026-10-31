package StackQueueHash;

/*
 * Problem: Check for a Pair with Given Sum
 *
 * Description:
 * Given an integer array and a target sum, check whether
 * there exists a pair of elements whose sum equals the target.
 *
 * Approach:
 * Use a HashSet to store visited elements.
 * For each element, check whether its complement
 * (target - current element) already exists.
 *
 * Time Complexity: O(n) average
 * Space Complexity: O(n)
 */

import java.util.HashSet;

public class PairWithGivenSum {

    static boolean findPair(int[] arr, int target) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {

            int complement = target - num;

            // Check whether complement exists
            if (set.contains(complement)) {

                System.out.println("Pair found: "
                        + complement + ", " + num);

                return true;
            }

            // Store current element
            set.add(num);
        }

        System.out.println("No pair found");

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};

        int target = 9;

        findPair(arr, target);
    }
}
