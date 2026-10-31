package StackQueueHash;

/*
 * Problem: Sort a Stack Using Recursion
 *
 * Description:
 * Given a stack of integers, sort its elements in ascending
 * order using recursion without using an additional data structure.
 *
 * Approach:
 * Recursively pop all elements and insert them back into
 * their correct sorted positions.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n) due to recursion.
 */

import java.util.Stack;

public class SortStackUsingRecursion {

    // Insert element at its correct sorted position
    static void sortedInsert(Stack<Integer> stack, int element) {

        // Base condition
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int top = stack.pop();

        sortedInsert(stack, element);

        stack.push(top);
    }

    // Sort the stack recursively
    static void sortStack(Stack<Integer> stack) {

        // Base condition
        if (stack.isEmpty()) {
            return;
        }

        int element = stack.pop();

        sortStack(stack);

        sortedInsert(stack, element);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
