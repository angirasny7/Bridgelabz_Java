package Collections.List;

import java.util.LinkedList;

/*
 * Problem: Find the Nth Element from the End
 * Find the Nth node from the end of a singly linked list without
 * calculating the list size. Use two pointers separated by N nodes.
 *
 * Note: Java's LinkedList is doubly linked internally; this example
 * demonstrates the two-pointer technique using sequential iteration.
 */
public class NthElementFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be positive.");
        }

        var fast = list.listIterator();
        var slow = list.listIterator();

        // Move fast pointer N positions ahead.
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                throw new IllegalArgumentException("N is greater than the list length.");
            }
            fast.next();
        }

        // Move both pointers until fast reaches the end.
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }

    public static void main(String[] args) {
        LinkedList<String> values = new LinkedList<>(java.util.List.of("A", "B", "C", "D", "E"));
        System.out.println("2nd element from end: " + findNthFromEnd(values, 2));
    }
}
