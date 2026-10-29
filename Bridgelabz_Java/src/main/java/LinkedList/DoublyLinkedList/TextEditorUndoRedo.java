package LinkedList.DoublyLinkedList;

/*
 * Problem Statement: Undo/Redo Functionality Using Doubly Linked List
 *
 * Design undo/redo functionality for a text editor using a doubly linked
 * list. Each node represents a state of the text content after an edit.
 *
 * Implement the following operations:
 * 1. Add a new text state after the user performs an edit.
 * 2. Undo: revert to the previous text state.
 * 3. Redo: move forward to the next text state after undo.
 * 4. Display the current text state.
 * 5. Limit history to a fixed number of states (10 states).
 *
 * Requirements:
 * - Each node must contain prev and next references.
 * - Maintain a current pointer to the active text state.
 * - Undo moves to the previous node.
 * - Redo moves to the next node.
 * - A new edit after undo must remove the old redo history.
 * - When the history limit is exceeded, remove the oldest state.
 */

import java.util.Scanner;

// Represents a single text state in the history
class TextState {
    String text;
    TextState prev;
    TextState next;

    // Stores a snapshot of the text
    TextState(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

// Manages text editing, undo, and redo operations
class TextEditor {

    private TextState head;
    private TextState tail;
    private TextState current;

    // Maximum number of text states to keep
    private final int MAX_HISTORY = 10;

    // Number of states currently stored
    private int size;

    // Adds a new text state after an edit
    public void addState(String newText) {

        TextState newState = new TextState(newText);

        // Initialize the history with the first state
        if (head == null) {
            head = tail = current = newState;
            size = 1;

            System.out.println("Text state saved.");
            return;
        }

        // If the user edited after undo, discard the redo history
        TextState nextState = current.next;

        while (nextState != null) {
            TextState temp = nextState.next;
            nextState.prev = null;
            nextState.next = null;
            nextState = temp;
        }

        // The current state becomes the last state
        current.next = null;
        tail = current;

        // Append the new state after the current state
        newState.prev = current;
        current.next = newState;
        current = newState;
        tail = newState;
        size++;

        // Remove the oldest state if the limit is exceeded
        if (size > MAX_HISTORY) {
            TextState oldHead = head;

            head = head.next;
            head.prev = null;

            // Disconnect the removed state
            oldHead.next = null;

            size--;
        }

        System.out.println("Text state saved.");
    }

    // Reverts to the previous text state
    public void undo() {

        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo.");
            return;
        }

        // Move one step backward
        current = current.prev;

        System.out.println("Undo successful.");
        displayCurrentState();
    }

    // Moves forward to the next text state
    public void redo() {

        if (current == null || current.next == null) {
            System.out.println("Nothing to redo.");
            return;
        }

        // Move one step forward
        current = current.next;

        System.out.println("Redo successful.");
        displayCurrentState();
    }

    // Displays the currently selected text state
    public void displayCurrentState() {

        if (current == null) {
            System.out.println("The text editor is empty.");
            return;
        }

        System.out.println("\n--- Current Text ---");
        System.out.println(current.text);
    }

    // Displays every state currently stored in history
    public void displayHistory() {

        if (head == null) {
            System.out.println("No history available.");
            return;
        }

        TextState temp = head;

        System.out.println("\n--- Text History ---");

        while (temp != null) {

            // Mark the currently active state
            if (temp == current) {
                System.out.println("-> [CURRENT] " + temp.text);
            } else {
                System.out.println("   " + temp.text);
            }

            temp = temp.next;
        }

        System.out.println("Stored states: " + size);
    }
}

// Main class for the text editor
public class TextEditorUndoRedo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        int choice;

        // Keep showing the menu until the user exits
        do {
            System.out.println("\n===== Text Editor =====");
            System.out.println("1. Type or replace text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display current text");
            System.out.println("5. Display history");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline

            switch (choice) {

                case 1:
                    // Save a new snapshot of the text
                    System.out.print("Enter the complete text: ");
                    String text = sc.nextLine();

                    editor.addState(text);
                    break;

                case 2:
                    // Revert to the previous state
                    editor.undo();
                    break;

                case 3:
                    // Restore the next state
                    editor.redo();
                    break;

                case 4:
                    // Display the current text
                    editor.displayCurrentState();
                    break;

                case 5:
                    // Display all saved states
                    editor.displayHistory();
                    break;

                case 0:
                    System.out.println("Exiting text editor.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
