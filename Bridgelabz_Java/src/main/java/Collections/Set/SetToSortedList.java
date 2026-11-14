package Collections.Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Problem: Convert a Set to a Sorted List
 * Convert a HashSet of integers into a list arranged in ascending order.
 */
public class SetToSortedList {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Set.of(5, 3, 9, 1));
        List<Integer> sorted = new ArrayList<>(numbers);

        Collections.sort(sorted);
        System.out.println("Sorted list: " + sorted);
    }
}
