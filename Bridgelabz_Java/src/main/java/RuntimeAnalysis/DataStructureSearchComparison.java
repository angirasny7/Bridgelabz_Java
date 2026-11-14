
package RuntimeAnalysis;

import java.util.*;

/*
 * Problem Description:
 * Compare searching performance using Array, HashSet and TreeSet.
 *
 * Array uses linear traversal to find an element.
 * HashSet uses hashing to locate an element.
 * TreeSet uses a balanced Red-Black Tree to maintain
 * sorted elements.
 *
 * Objective:
 * Understand the searching performance and trade-offs
 * of different data structures.
 *
 * Time Complexity:
 * Array Search : O(N)
 * HashSet      : O(1) average, O(N) worst case.
 * TreeSet      : O(log N).
 */

public class DataStructureSearchComparison {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Insert array elements into both sets.
        for (int num : arr) {
            hashSet.add(num);
            treeSet.add(num);
        }

        int target = 30;

        // Search in Array using linear traversal.
        boolean found = false;

        for (int num : arr) {

            if (num == target) {
                found = true;
                break;
            }
        }

        System.out.println("Array Search: " + found);

        // Search in HashSet using hashing.
        System.out.println("HashSet Search: "
                + hashSet.contains(target));

        // Search in TreeSet using a balanced BST.
        System.out.println("TreeSet Search: "
                + treeSet.contains(target));
    }
}
