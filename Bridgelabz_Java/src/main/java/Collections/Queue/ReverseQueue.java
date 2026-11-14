package Collections.Queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem: Reverse a Queue
 * Reverse queue elements using queue operations only. A recursive
 * approach removes the front item, reverses the remaining queue,
 * and inserts the removed item at the back.
 */
public class ReverseQueue {
    public static <T> void reverse(Queue<T> queue) {
        if (queue.isEmpty()) return;

        T front = queue.remove();
        reverse(queue);
        queue.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        reverse(queue);
        System.out.println(queue);
    }
}
