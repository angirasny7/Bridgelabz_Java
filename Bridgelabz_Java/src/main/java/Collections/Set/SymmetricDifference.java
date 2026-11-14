package Collections.Set;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem: Symmetric Difference
 * Find elements that belong to either set, but not to both sets.
 */
public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));

        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);

        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2);

        result.removeAll(common);
        System.out.println("Symmetric difference: " + result);
    }
}
