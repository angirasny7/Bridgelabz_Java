package Collections.Queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem: Implement a Stack Using Queues
 * Implement push, pop and top using two queues. After insertion,
 * move older elements behind the new element so the front is the stack top.
 */
public class StackUsingQueues {
    private Queue<Integer> primary = new LinkedList<>();
    private Queue<Integer> helper = new LinkedList<>();

    public void push(int value) {
        helper.add(value);

        while (!primary.isEmpty()) {
            helper.add(primary.remove());
        }

        Queue<Integer> temp = primary;
        primary = helper;
        helper = temp;
    }

    public int pop() {
        if (primary.isEmpty()) throw new IllegalStateException("Stack is empty.");
        return primary.remove();
    }

    public int top() {
        if (primary.isEmpty()) throw new IllegalStateException("Stack is empty.");
        return primary.peek();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top: " + stack.top());
        System.out.println("Popped: " + stack.pop());
    }
}
