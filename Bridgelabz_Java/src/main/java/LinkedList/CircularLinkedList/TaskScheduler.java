package LinkedList.CircularLinkedList;


/*
 * Problem Statement: Task Scheduler Using Circular Linked List
 *
 * Create a task scheduler using a circular linked list.
 * Each node stores the following task information:
 * Task ID, Task Name, Priority, and Due Date.
 *
 * Implement the following operations:
 * 1. Add a task at the beginning of the list.
 * 2. Add a task at the end of the list.
 * 3. Add a task at a specific position.
 * 4. Remove a task using its Task ID.
 * 5. View the current task.
 * 6. Move to the next task in the circular list.
 * 7. Display all tasks starting from the head node.
 * 8. Search for tasks using priority.
 *
 * Requirements:
 * - The last node must point back to the first node.
 * - Maintain a head reference to the first node.
 * - Maintain a current reference for task scheduling.
 * - Handle empty lists and invalid positions.
 * - Do not allow duplicate task IDs.
 */

import java.util.Scanner;

// Represents a single task node
class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    // Initializes task details
    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// Manages tasks using a circular singly linked list
class CircularTaskList {

    // Points to the first task
    private Task head;

    // Points to the task currently being scheduled
    private Task current;

    // Counts the number of tasks
    private int size;

    // Searches for a task using its ID
    private Task findById(int taskId) {
        if (head == null) {
            return null;
        }

        Task temp = head;

        // Stop after completing one full cycle
        do {
            if (temp.taskId == taskId) {
                return temp;
            }

            temp = temp.next;
        } while (temp != head);

        return null;
    }

    // Adds a task at the beginning
    public void insertAtBeginning(
            int id, String name, int priority, String dueDate) {

        // Prevent duplicate task IDs
        if (findById(id) != null) {
            System.out.println("Task ID already exists.");
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);

        // If the list is empty, point the node to itself
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            // Find the last node
            Task tail = head;

            while (tail.next != head) {
                tail = tail.next;
            }

            // Insert the new node before the old head
            newTask.next = head;
            tail.next = newTask;
            head = newTask;
        }

        size++;
        System.out.println("Task added at the beginning.");
    }

    // Adds a task at the end
    public void insertAtEnd(
            int id, String name, int priority, String dueDate) {

        // Prevent duplicate task IDs
        if (findById(id) != null) {
            System.out.println("Task ID already exists.");
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);

        // Handle an empty list
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            // Find the last node
            Task tail = head;

            while (tail.next != head) {
                tail = tail.next;
            }

            // Connect the last node to the new task
            tail.next = newTask;

            // Maintain the circular link
            newTask.next = head;
        }

        size++;
        System.out.println("Task added at the end.");
    }

    // Inserts a task at a specific 1-based position
    public void insertAtPosition(
            int id, String name, int priority,
            String dueDate, int position) {

        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (findById(id) != null) {
            System.out.println("Task ID already exists.");
            return;
        }

        // Position 1 means insertion at the beginning
        if (position == 1) {
            insertAtBeginning(id, name, priority, dueDate);
            return;
        }

        // Position size + 1 means insertion at the end
        if (position == size + 1) {
            insertAtEnd(id, name, priority, dueDate);
            return;
        }

        Task temp = head;

        // Move to the node before the target position
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        // Insert the new node between two existing nodes
        Task newTask = new Task(id, name, priority, dueDate);
        newTask.next = temp.next;
        temp.next = newTask;

        size++;
        System.out.println("Task added at position " + position);
    }

    // Removes a task using its ID
    public void removeTask(int taskId) {

        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        Task previous = null;

        // Find the task, stopping after one complete cycle
        do {
            if (temp.taskId == taskId) {
                break;
            }

            previous = temp;
            temp = temp.next;
        } while (temp != head);

        // If the task was not found
        if (temp.taskId != taskId) {
            System.out.println("Task not found.");
            return;
        }

        // Case 1: Only one task exists
        if (size == 1) {
            head = null;
            current = null;
        } else {
            // Find the last node when deleting the head
            if (temp == head) {
                Task tail = head;

                while (tail.next != head) {
                    tail = tail.next;
                }

                head = head.next;
                tail.next = head;
            } else {
                // Skip the node being deleted
                previous.next = temp.next;
            }

            // If the current task is deleted, move to its successor
            if (current == temp) {
                current = temp.next;
            }
        }

        // Disconnect the removed node
        temp.next = null;
        size--;

        System.out.println("Task removed successfully.");
    }

    // Displays the current task
    public void viewCurrentTask() {

        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n--- Current Task ---");
        displayTask(current);
    }

    // Moves the scheduler to the next task
    public void moveToNextTask() {

        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        // Circular link automatically returns to the first task
        current = current.next;

        System.out.println("Moved to the next task.");
        displayTask(current);
    }

    // Displays all tasks starting from the head
    public void displayAllTasks() {

        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;

        System.out.println("\n--- All Tasks ---");

        // A do-while loop visits the head at least once
        // and stops when the traversal returns to the head
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Displays all tasks matching a given priority
    public void searchByPriority(int priority) {

        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        boolean found = false;

        // Traverse exactly one complete cycle
        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }

            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with this priority.");
        }
    }

    // Prints the details of a single task
    private void displayTask(Task task) {
        System.out.println("Task ID  : " + task.taskId);
        System.out.println("Task Name: " + task.taskName);
        System.out.println("Priority : " + task.priority);
        System.out.println("Due Date : " + task.dueDate);
        System.out.println("-------------------------");
    }
}

// Main class for the menu-driven application
public class TaskScheduler {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularTaskList list = new CircularTaskList();

        int choice;

        // Continue until the user chooses to exit
        do {
            System.out.println("\n===== Task Scheduler =====");
            System.out.println("1. Add task at beginning");
            System.out.println("2. Add task at end");
            System.out.println("3. Add task at specific position");
            System.out.println("4. Remove task by ID");
            System.out.println("5. View current task");
            System.out.println("6. Move to next task");
            System.out.println("7. Display all tasks");
            System.out.println("8. Search tasks by priority");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline

            int id;
            int priority;
            int position;
            String name;
            String dueDate;

            switch (choice) {

                case 1:
                    // Read task details and add at the beginning
                    System.out.print("Enter task ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter task name: ");
                    name = sc.nextLine();

                    System.out.print("Enter priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter due date (DD-MM-YYYY): ");
                    dueDate = sc.nextLine();

                    list.insertAtBeginning(id, name, priority, dueDate);
                    break;

                case 2:
                    // Read task details and add at the end
                    System.out.print("Enter task ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter task name: ");
                    name = sc.nextLine();

                    System.out.print("Enter priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter due date (DD-MM-YYYY): ");
                    dueDate = sc.nextLine();

                    list.insertAtEnd(id, name, priority, dueDate);
                    break;

                case 3:
                    // Read task details and the target position
                    System.out.print("Enter task ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter task name: ");
                    name = sc.nextLine();

                    System.out.print("Enter priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter due date (DD-MM-YYYY): ");
                    dueDate = sc.nextLine();

                    System.out.print("Enter position (starting from 1): ");
                    position = sc.nextInt();
                    sc.nextLine();

                    list.insertAtPosition(
                            id, name, priority, dueDate, position);
                    break;

                case 4:
                    // Remove a task using its ID
                    System.out.print("Enter task ID to remove: ");
                    id = sc.nextInt();

                    list.removeTask(id);
                    break;

                case 5:
                    // Display the currently scheduled task
                    list.viewCurrentTask();
                    break;

                case 6:
                    // Advance to the next task in the cycle
                    list.moveToNextTask();
                    break;

                case 7:
                    // Display all tasks from the head node
                    list.displayAllTasks();
                    break;

                case 8:
                    // Search for tasks with a given priority
                    System.out.print("Enter priority to search: ");
                    priority = sc.nextInt();

                    list.searchByPriority(priority);
                    break;

                case 0:
                    System.out.println("Exiting Task Scheduler.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
