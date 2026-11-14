package Collections.Set;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem: Union and Intersection of Two Sets
 * Union contains every element present in either set.
 * Intersection contains only elements common to both sets.
 */
public class UnionIntersection {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}
