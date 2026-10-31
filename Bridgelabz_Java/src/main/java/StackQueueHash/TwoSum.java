package StackQueueHash;

/*
 * Problem: Two Sum
 *
 * Description:
 * Given an integer array and a target value, find the
 * indices of two distinct elements whose sum equals
 * the target.
 *
 * Approach:
 * Use a HashMap to store array elements and their indices.
 * For each element, check whether its complement
 * (target - current element) exists in the map.
 *
 * Time Complexity: O(n) average
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {

    static int[] findTwoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // Check whether complement exists
            if (map.containsKey(complement)) {

                return new int[]{
                        map.get(complement), i
                };
            }

            // Store element and its index
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};

        int target = 9;

        int[] result = findTwoSum(nums, target);

        if (result[0] == -1) {
            System.out.println("No valid pair found");
        } else {
            System.out.println("Indices: "
                    + Arrays.toString(result));
        }
    }
}
