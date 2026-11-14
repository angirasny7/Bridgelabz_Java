package Collections.List;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/*
 * Problem: Remove Duplicates While Preserving Order
 * Remove repeated values from a list while keeping the first
 * occurrence of every value in its original position.
 */
public class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> input) {
        // LinkedHashSet removes duplicates and preserves insertion order.
        return new ArrayList<>(new LinkedHashSet<>(input));
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 1, 2, 2, 3, 4);
        System.out.println(removeDuplicates(numbers));
    }
}
