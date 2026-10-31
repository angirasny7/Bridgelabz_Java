package StackQueueHash;

/*
 * Problem: Longest Consecutive Sequence
 *
 * Description:
 * Given an unsorted integer array, find the length of the
 * longest sequence of consecutive elements.
 *
 * The consecutive elements do not need to be adjacent
 * in the original array.
 *
 * Approach:
 * Use a HashSet to store array elements.
 * Start counting only when the previous consecutive
 * element does not exist in the set.
 *
 * Time Complexity: O(n) average
 * Space Complexity: O(n)
 */

import java.util.HashSet;

public class LongestConsecutiveSequence {

    static int findLongestSequence(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        // Store all elements in HashSet
        for (int num : arr) {
            set.add(num);
        }

        int maxLength = 0;

        // Traverse the array
        for (int num : set) {

            // Check if current element is the start
            if (num == Integer.MIN_VALUE || !set.contains(num - 1)) {

                int currentNum = num;
                int currentLength = 1;

                // Count consecutive elements
                while (currentNum != Integer.MAX_VALUE &&
                        set.contains(currentNum + 1)) {

                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2};

        int result = findLongestSequence(arr);

        System.out.println("Longest Consecutive Sequence: "
                + result);
    }
}
