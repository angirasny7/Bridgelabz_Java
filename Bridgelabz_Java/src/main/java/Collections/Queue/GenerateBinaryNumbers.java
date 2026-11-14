package Collections.Queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem: Generate Binary Numbers Using a Queue
 * Generate the first N binary numbers in increasing numeric order.
 * Each removed value produces two new values by appending 0 and 1.
 */
public class GenerateBinaryNumbers {
    public static void generate(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            System.out.print(current + " ");

            queue.add(current + "0");
            queue.add(current + "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        generate(5);
    }
}
