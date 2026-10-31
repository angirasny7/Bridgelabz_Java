package StackQueueHash;

/*
 * Problem: Sliding Window Maximum
 *
 * Description:
 * Given an integer array and a window size k, find the
 * maximum element in every contiguous window of size k.
 *
 * Approach:
 * Use a Deque to store indices of useful elements.
 * Remove expired indices from the front and smaller
 * elements from the back.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindowMaximum {

    static int[] maxSlidingWindow(int[] arr, int k) {

        if (arr == null || k <= 0 || k > arr.length) {
            return new int[0];
        }

        int n = arr.length;

        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices outside the current window
            while (!deque.isEmpty() &&
                    deque.peekFirst() <= i - k) {

                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() &&
                    arr[deque.peekLast()] <= arr[i]) {

                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Store maximum after first window is formed
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};

        int k = 3;

        int[] result = maxSlidingWindow(arr, k);

        System.out.println("Original Array: " +
                Arrays.toString(arr));

        System.out.println("Window Size: " + k);

        System.out.println("Maximum Elements: " +
                Arrays.toString(result));
    }
}
