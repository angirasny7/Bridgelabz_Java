package Collections.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Problem: Reverse a List
 * Reverse the elements of a list without using Collections.reverse()
 * or any other built-in reverse method. Demonstrate the logic with
 * both ArrayList and LinkedList.
 */
public class ReverseList {
    // Swap elements from the two ends until the middle is reached.
    public static <T> void reverse(List<T> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> linkedList = new LinkedList<>(List.of(1, 2, 3, 4, 5));

        reverse(arrayList);
        reverse(linkedList);

        System.out.println("Reversed ArrayList: " + arrayList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
