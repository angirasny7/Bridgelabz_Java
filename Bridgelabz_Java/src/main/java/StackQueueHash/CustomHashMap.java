package StackQueueHash;

/*
 * Problem: Implement a Custom HashMap
 *
 * Description:
 * Design a HashMap that supports insertion, retrieval,
 * deletion, and searching of key-value pairs without
 * using Java's built-in HashMap.
 *
 * Approach:
 * Use an array of linked lists and Separate Chaining
 * to handle collisions.
 *
 * Operations:
 * put(), get(), remove(), containsKey()
 *
 * Average Time Complexity: O(1)
 * Worst-case Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class CustomHashMap<K, V> {

    // Node represents a key-value pair
    static class Node<K, V> {

        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node<K, V>[] buckets;

    private int capacity = 10;

    private int size = 0;

    // Constructor
    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = (Node<K, V>[]) new Node[capacity];
    }

    // Calculate bucket index
    private int getIndex(K key) {

        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    // Insert or update key-value pair
    public void put(K key, V value) {

        if (key == null) {
            throw new IllegalArgumentException("Null keys not supported");
        }

        int index = getIndex(key);

        Node<K, V> current = buckets[index];

        // Check whether key already exists
        while (current != null) {

            if (current.key.equals(key)) {
                current.value = value;
                return;
            }

            current = current.next;
        }

        // Insert new node at the beginning
        Node<K, V> newNode = new Node<>(key, value);

        newNode.next = buckets[index];

        buckets[index] = newNode;

        size++;
    }

    // Retrieve value using key
    public V get(K key) {

        if (key == null) {
            return null;
        }

        int index = getIndex(key);

        Node<K, V> current = buckets[index];

        while (current != null) {

            if (current.key.equals(key)) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    // Check whether key exists
    public boolean containsKey(K key) {

        if (key == null) {
            return false;
        }

        int index = getIndex(key);

        Node<K, V> current = buckets[index];

        while (current != null) {

            if (current.key.equals(key)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Remove key-value pair
    public void remove(K key) {

        if (key == null) {
            return;
        }

        int index = getIndex(key);

        Node<K, V> current = buckets[index];

        Node<K, V> previous = null;

        while (current != null) {

            if (current.key.equals(key)) {

                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                size--;

                return;
            }

            previous = current;
            current = current.next;
        }
    }

    // Return number of entries
    public int size() {
        return size;
    }

    // Display HashMap
    public void display() {

        for (int i = 0; i < capacity; i++) {

            Node<K, V> current = buckets[i];

            while (current != null) {

                System.out.println(
                        current.key + " = " + current.value
                );

                current = current.next;
            }
        }
    }

    public static void main(String[] args) {

        CustomHashMap<Integer, String> map =
                new CustomHashMap<>();

        // Insert elements
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");
        map.put(4, "JavaScript");

        System.out.println("HashMap Elements:");

        map.display();

        // Retrieve value
        System.out.println("\nValue for key 2: "
                + map.get(2));

        // Check key
        System.out.println("Contains key 3: "
                + map.containsKey(3));

        // Remove element
        map.remove(3);

        System.out.println("\nAfter removing key 3:");

        map.display();

        System.out.println("\nSize: " + map.size());
    }
}
