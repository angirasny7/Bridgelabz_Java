package Collections.Set;

import java.util.Set;

/*
 * Problem: Find Subsets
 * Check whether every element of the first set is also present
 * in the second set.
 */
public class CheckSubset {
    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(2, 3);
        Set<Integer> set2 = Set.of(1, 2, 3, 4);

        System.out.println("Is set1 a subset of set2? " + set2.containsAll(set1));
    }
}
