package Collections.Set;

import java.util.Set;

/*
 * Problem: Check if Two Sets Are Equal
 * Determine whether two sets contain exactly the same elements.
 * Set equality does not depend on the order of elements.
 */
public class CheckSetEquality {
    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(3, 2, 1);

        System.out.println("Are sets equal? " + set1.equals(set2));
    }
}
