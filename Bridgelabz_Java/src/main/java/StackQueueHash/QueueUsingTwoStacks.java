package StackQueueHash;
import java.util.Stack;
/*
 * Problem: Implement a Queue Using Two Stacks
 *
 * Description:
 * Implement a Queue using two Stacks such that it follows
 * FIFO (First In, First Out) behavior.
 *
 * Operations:
 * 1. enqueue() - Insert an element into the queue.
 * 2. dequeue() - Remove the front element from the queue.
 * 3. peek()    - Return the front element without removing it.
 * 4. isEmpty()- Check whether the queue is empty.
 *
 * Approach:
 * Use two stacks. Stack1 handles insertion, while Stack2
 * handles deletion by reversing the element order.
 *
 * Time Complexity:
 * Enqueue: O(1)
 * Dequeue: O(1) Amortized
 *
 * Space Complexity: O(n)
 */

public class QueueUsingTwoStacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Insert element into queue
    void enqueue(int data) {
        stack1.push(data);
        System.out.println(data + " inserted");
    }

    // Remove element from queue
    int dequeue() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        // Transfer elements if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // Return front element
    int peek() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Check whether queue is empty
    boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {

        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Deleted: " + queue.dequeue());
        System.out.println("Deleted: " + queue.dequeue());

        System.out.println("Front element: " + queue.peek());

        System.out.println("Is Queue Empty? " + queue.isEmpty());
    }
}
