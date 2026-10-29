package LinkedList.CircularLinkedList;

/*
 * Problem Statement: Round Robin CPU Scheduling Using Circular Linked List
 *
 * Implement a round-robin CPU scheduling algorithm using a circular
 * linked list. Each node represents a process and stores:
 * Process ID, Burst Time, and Priority.
 *
 * Implement the following operations:
 * 1. Add a process at the end of the circular linked list.
 * 2. Remove a process using its Process ID.
 * 3. Simulate round-robin scheduling with a fixed time quantum.
 * 4. Display the remaining processes after each round.
 * 5. Calculate the average waiting time.
 * 6. Calculate the average turnaround time.
 *
 * Requirements:
 * - The last node must point back to the first node.
 * - Each process executes for at most one time quantum per turn.
 * - An unfinished process gets another turn in the next round.
 * - A completed process is removed from the circular list.
 * - Waiting Time = Turnaround Time - Burst Time.
 * - Turnaround Time = Completion Time - Arrival Time.
 *
 * Assumption:
 * All processes arrive at time 0.
 * Priority is stored but is not used in Round Robin scheduling.
 */

import java.util.Scanner;

// Represents a process in the circular linked list
class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int completionTime;

    Process next;

    // Initializes process details
    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.completionTime = 0;
        this.next = null;
    }
}

// Implements a circular linked list for CPU scheduling
class CircularProcessList {

    // References to the first, last, and current processes
    private Process head;
    private Process tail;
    private Process current;

    private int size;

    // Searches for a process using its ID
    private Process findById(int processId) {
        if (head == null) {
            return null;
        }

        Process temp = head;

        // Stop after one complete cycle
        do {
            if (temp.processId == processId) {
                return temp;
            }

            temp = temp.next;
        } while (temp != head);

        return null;
    }

    // Adds a process at the end of the circular linked list
    public void addProcess(int id, int burstTime, int priority) {

        // Validate process details
        if (burstTime <= 0) {
            System.out.println("Burst time must be positive.");
            return;
        }

        // Prevent duplicate process IDs
        if (findById(id) != null) {
            System.out.println("Process ID already exists.");
            return;
        }

        Process newProcess = new Process(id, burstTime, priority);

        // If the list is empty, the process points to itself
        if (head == null) {
            head = tail = current = newProcess;
            newProcess.next = head;
        } else {
            // Insert the process after the current tail
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }

        size++;
        System.out.println("Process added successfully.");
    }

    // Removes a process using its ID
    public boolean removeProcess(int processId) {

        if (head == null) {
            System.out.println("Process list is empty.");
            return false;
        }

        Process temp = head;
        Process previous = tail;

        // Find the process while maintaining its previous node
        do {
            if (temp.processId == processId) {
                break;
            }

            previous = temp;
            temp = temp.next;
        } while (temp != head);

        // Process was not found
        if (temp.processId != processId) {
            System.out.println("Process not found.");
            return false;
        }

        // If the process being removed is the current process,
        // move current to its successor
        if (current == temp) {
            current = temp.next;
        }

        // Handle the case where only one process exists
        if (size == 1) {
            head = tail = current = null;
        } else {
            // Update the circular link
            previous.next = temp.next;

            // Update head if the first process is removed
            if (temp == head) {
                head = temp.next;
            }

            // Update tail if the last process is removed
            if (temp == tail) {
                tail = previous;
            }
        }

        // Disconnect the removed process
        temp.next = null;
        size--;

        return true;
    }

    // Displays the processes currently in the circular list
    public void displayProcesses() {

        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;

        System.out.println("\n--- Processes in Circular Queue ---");

        // Visit each process exactly once
        do {
            System.out.println(
                    "Process ID: " + temp.processId
                            + " | Burst Time: " + temp.burstTime
                            + " | Remaining Time: " + temp.remainingTime
                            + " | Priority: " + temp.priority
            );

            temp = temp.next;
        } while (temp != head);

        System.out.println("Total active processes: " + size);
    }

    // Simulates round-robin CPU scheduling
    public void executeRoundRobin(int timeQuantum) {

        if (timeQuantum <= 0) {
            System.out.println("Time quantum must be positive.");
            return;
        }

        if (head == null) {
            System.out.println("No processes available for scheduling.");
            return;
        }

        // Store the number of processes before scheduling starts
        int totalProcesses = size;

        // Store the results of completed processes
        int[] processIds = new int[totalProcesses];
        int[] burstTimes = new int[totalProcesses];
        int[] completionTimes = new int[totalProcesses];

        int completedCount = 0;
        int currentTime = 0;
        int round = 1;

        System.out.println("\n===== Round Robin Scheduling =====");
        System.out.println("Time Quantum: " + timeQuantum);

        // Continue until every process has completed
        while (head != null) {

            // Each process present at the start of this round
            // gets at most one turn during the round
            int processesThisRound = size;

            System.out.println("\n--- Round " + round + " ---");

            for (int i = 0; i < processesThisRound; i++) {

                // Get the process currently scheduled
                Process executing = current;

                System.out.println(
                        "Executing Process P" + executing.processId);

                // Execute for the quantum or the remaining burst time,
                // whichever is smaller
                int executionTime = Math.min(
                        timeQuantum, executing.remainingTime);

                executing.remainingTime -= executionTime;
                currentTime += executionTime;

                System.out.println(
                        "Execution Time: " + executionTime);
                System.out.println(
                        "Current Time: " + currentTime);
                System.out.println(
                        "Remaining Burst Time: "
                                + executing.remainingTime);

                if (executing.remainingTime == 0) {

                    // Record completion details before removing the node
                    processIds[completedCount] = executing.processId;
                    burstTimes[completedCount] = executing.burstTime;
                    completionTimes[completedCount] = currentTime;
                    completedCount++;

                    System.out.println(
                            "Process P" + executing.processId
                                    + " completed.");

                    // Completed processes are removed automatically
                    removeProcess(executing.processId);

                } else {
                    // Move to the next process in the circular list
                    current = executing.next;
                }
            }

            // Display the active queue after each complete round
            System.out.println("\nQueue after Round " + round + ":");
            displayProcesses();

            round++;
        }

        // Calculate and display scheduling statistics
        displayStatistics(
                processIds, burstTimes, completionTimes,
                completedCount);
    }

    // Calculates average waiting and turnaround times
    private void displayStatistics(
            int[] processIds, int[] burstTimes,
            int[] completionTimes, int count) {

        if (count == 0) {
            System.out.println("No completed processes to evaluate.");
            return;
        }

        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;

        System.out.println("\n===== Scheduling Statistics =====");

        System.out.printf(
                "%-12s %-12s %-15s %-15s%n",
                "Process ID", "Burst Time",
                "Waiting Time", "Turnaround Time");

        for (int i = 0; i < count; i++) {

            // All processes arrive at time 0
            int turnaroundTime = completionTimes[i];

            // Waiting time = Turnaround time - Burst time
            int waitingTime = turnaroundTime - burstTimes[i];

            totalWaitingTime += waitingTime;
            totalTurnaroundTime += turnaroundTime;

            System.out.printf(
                    "%-12d %-12d %-15d %-15d%n",
                    processIds[i],
                    burstTimes[i],
                    waitingTime,
                    turnaroundTime);
        }

        // Calculate the averages
        double averageWaitingTime = totalWaitingTime / count;
        double averageTurnaroundTime = totalTurnaroundTime / count;

        System.out.printf(
                "%nAverage Waiting Time: %.2f%n",
                averageWaitingTime);

        System.out.printf(
                "Average Turnaround Time: %.2f%n",
                averageTurnaroundTime);
    }
}

// Main class for the round-robin scheduler
public class RoundRobinScheduler {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularProcessList scheduler = new CircularProcessList();

        int choice;

        // Display the menu until the user exits
        do {
            System.out.println("\n===== Round Robin CPU Scheduler =====");
            System.out.println("1. Add process");
            System.out.println("2. Remove process by ID");
            System.out.println("3. Display processes");
            System.out.println("4. Run Round Robin scheduling");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            int id;
            int burstTime;
            int priority;
            int timeQuantum;

            switch (choice) {

                case 1:
                    // Read process details
                    System.out.print("Enter Process ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter Burst Time: ");
                    burstTime = sc.nextInt();

                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();

                    // Add the process to the circular queue
                    scheduler.addProcess(id, burstTime, priority);
                    break;

                case 2:
                    // Remove a process manually by ID
                    System.out.print("Enter Process ID to remove: ");
                    id = sc.nextInt();

                    if (scheduler.removeProcess(id)) {
                        System.out.println(
                                "Process removed successfully.");
                    } else {
                        System.out.println(
                                "Unable to remove process.");
                    }
                    break;

                case 3:
                    // Display the current circular queue
                    scheduler.displayProcesses();
                    break;

                case 4:
                    // Read the fixed time quantum and run scheduling
                    System.out.print("Enter Time Quantum: ");
                    timeQuantum = sc.nextInt();

                    scheduler.executeRoundRobin(timeQuantum);
                    break;

                case 0:
                    System.out.println("Exiting scheduler.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
