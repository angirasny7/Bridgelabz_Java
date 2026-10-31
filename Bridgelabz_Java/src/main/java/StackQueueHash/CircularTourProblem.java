package StackQueueHash;

/*
 * Problem: Circular Tour Problem
 *
 * Description:
 * Given petrol and distance arrays representing circular
 * petrol pumps, find the starting pump from which a truck
 * can complete the entire circular tour.
 *
 * Return -1 if no valid starting point exists.
 *
 * Approach:
 * Use a greedy approach to track total and current petrol
 * surplus. Reset the starting point whenever the current
 * petrol balance becomes negative.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class CircularTourProblem {

    static int findStartingPoint(int[] petrol, int[] distance) {

        int n = petrol.length;

        int totalSurplus = 0;
        int currentSurplus = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {

            int balance = petrol[i] - distance[i];

            totalSurplus += balance;

            currentSurplus += balance;

            // Current starting point is invalid
            if (currentSurplus < 0) {

                start = i + 1;

                currentSurplus = 0;
            }
        }

        // Check whether completing the tour is possible
        if (totalSurplus < 0) {
            return -1;
        }

        return start;
    }

    public static void main(String[] args) {

        int[] petrol = {4, 6, 7, 4};

        int[] distance = {6, 5, 3, 5};

        int result = findStartingPoint(petrol, distance);

        if (result == -1) {
            System.out.println("No valid starting point");
        } else {
            System.out.println("Start Index: " + result);
        }
    }
}
