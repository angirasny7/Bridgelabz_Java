package Collections.List;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Rotate Elements in a List
 * Rotate a list to the left by a given number of positions.
 * Example: [10, 20, 30, 40, 50], rotate by 2 -> [30, 40, 50, 10, 20].
 */
public class RotateList {
    public static <T> void rotateLeft(List<T> list, int positions) {
        if (list.isEmpty()) {
            return;
        }

        int rotations = positions % list.size();

        // Move the first element to the end for each rotation.
        for (int i = 0; i < rotations; i++) {
            T first = list.remove(0);
            list.add(first);
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        rotateLeft(numbers, 2);
        System.out.println("After left rotation: " + numbers);
    }
}
