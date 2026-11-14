package Collections.Queue;

import java.util.Arrays;

/*
 * Problem: Circular Buffer Simulation
 * Implement a fixed-size queue backed by an array. When the buffer
 * is full, inserting a new item overwrites the oldest item.
 */
public class CircularBuffer {
    private final int[] data;
    private int start = 0;
    private int size = 0;

    public CircularBuffer(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive.");
        data = new int[capacity];
    }

    public void add(int value) {
        if (size < data.length) {
            data[(start + size) % data.length] = value;
            size++;
        } else {
            // Replace the oldest item and advance the start position.
            data[start] = value;
            start = (start + 1) % data.length;
        }
    }

    public String toString() {
        int[] ordered = new int[size];
        for (int i = 0; i < size; i++) {
            ordered[i] = data[(start + i) % data.length];
        }
        return Arrays.toString(ordered);
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.add(4);
        System.out.println("Buffer: " + buffer);
    }
}
