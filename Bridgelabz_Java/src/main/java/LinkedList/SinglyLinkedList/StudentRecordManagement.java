package LinkedList.SinglyLinkedList;


/*
 * Problem Statement: Student Record Management Using Singly Linked List
 *
 * Create a program to manage student records using a singly linked list.
 * Each node stores the following student information:
 * Roll Number, Name, Age, and Grade.
 *
 * Implement the following operations:
 * 1. Add a student at the beginning of the list.
 * 2. Add a student at the end of the list.
 * 3. Add a student at a specific position.
 * 4. Delete a student using the roll number.
 * 5. Search for a student using the roll number.
 * 6. Display all student records.
 * 7. Update a student's grade using the roll number.
 *
 * Requirements:
 * - Use a singly linked list with a head reference.
 * - Each node must point to the next node.
 * - The next reference of the last node must be null.
 * - Handle empty lists and invalid positions.
 * - Do not allow duplicate roll numbers.
 */

import java.util.Scanner;

// Represents a single student node in the linked list
class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    // Constructor initializes student details
    Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Manages student records using a singly linked list
class StudentLinkedList {

    // Head points to the first node of the list
    private Student head;

    // Searches for a student by roll number
    // Returns the student node if found; otherwise, returns null
    public Student search(int rollNumber) {
        Student current = head;

        // Traverse the list until the student is found or the list ends
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    // Adds a student at the beginning of the list
    public void insertAtBeginning(
            int rollNumber, String name, int age, String grade) {

        // Prevent duplicate roll numbers
        if (search(rollNumber) != null) {
            System.out.println("Roll number already exists.");
            return;
        }

        // Create a new student node
        Student newStudent =
                new Student(rollNumber, name, age, grade);

        // Link the new node to the current first node
        newStudent.next = head;

        // Make the new node the first node
        head = newStudent;

        System.out.println("Student added at the beginning.");
    }

    // Adds a student at the end of the list
    public void insertAtEnd(
            int rollNumber, String name, int age, String grade) {

        // Prevent duplicate roll numbers
        if (search(rollNumber) != null) {
            System.out.println("Roll number already exists.");
            return;
        }

        // Create a new student node
        Student newStudent =
                new Student(rollNumber, name, age, grade);

        // If the list is empty, the new node becomes the head
        if (head == null) {
            head = newStudent;
            System.out.println("Student added at the end.");
            return;
        }

        // Traverse to the last node
        Student current = head;

        while (current.next != null) {
            current = current.next;
        }

        // Connect the last node to the new node
        current.next = newStudent;

        System.out.println("Student added at the end.");
    }

    // Inserts a student at a specified 1-based position
    public void insertAtPosition(
            int rollNumber, String name, int age,
            String grade, int position) {

        // Positions start from 1
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        // Prevent duplicate roll numbers
        if (search(rollNumber) != null) {
            System.out.println("Roll number already exists.");
            return;
        }

        // Position 1 means insertion at the beginning
        if (position == 1) {
            insertAtBeginning(rollNumber, name, age, grade);
            return;
        }

        // Traverse to the node immediately before the target position
        Student current = head;

        for (int i = 1;
             i < position - 1 && current != null;
             i++) {
            current = current.next;
        }

        // If current is null, the position is beyond the list
        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        // Create the new node
        Student newStudent =
                new Student(rollNumber, name, age, grade);

        // Link the new node to the next node
        newStudent.next = current.next;

        // Link the previous node to the new node
        current.next = newStudent;

        System.out.println("Student added at position " + position);
    }

    // Deletes a student using the roll number
    public void deleteStudent(int rollNumber) {

        // Check whether the list is empty
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // If the first node contains the target roll number
        if (head.rollNumber == rollNumber) {
            Student temp = head;

            // Move head to the second node
            head = head.next;

            // Disconnect the deleted node
            temp.next = null;

            System.out.println("Student deleted successfully.");
            return;
        }

        // Find the node immediately before the target node
        Student current = head;

        while (current.next != null
                && current.next.rollNumber != rollNumber) {
            current = current.next;
        }

        // If the target node does not exist
        if (current.next == null) {
            System.out.println("Student not found.");
            return;
        }

        // Store the node to be deleted
        Student temp = current.next;

        // Skip the deleted node
        current.next = temp.next;

        // Disconnect the deleted node
        temp.next = null;

        System.out.println("Student deleted successfully.");
    }

    // Displays all student records
    public void display() {

        // Check whether the list is empty
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        // Start traversal from the head
        Student current = head;

        System.out.println("\n----- Student Records -----");

        // Print each student's information
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber);
            System.out.println("Name       : " + current.name);
            System.out.println("Age        : " + current.age);
            System.out.println("Grade      : " + current.grade);
            System.out.println("---------------------------");

            // Move to the next node
            current = current.next;
        }
    }

    // Updates the grade of a student using the roll number
    public void updateGrade(int rollNumber, String newGrade) {

        // Find the student using the search method
        Student student = search(rollNumber);

        // Update the grade if the student exists
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}

// Main class contains the menu-driven program
public class StudentRecordManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create the linked list object
        StudentLinkedList list = new StudentLinkedList();

        int choice;

        // Display the menu until the user chooses to exit
        do {
            System.out.println("\n===== Student Record Management =====");
            System.out.println("1. Add student at beginning");
            System.out.println("2. Add student at end");
            System.out.println("3. Add student at specific position");
            System.out.println("4. Delete student");
            System.out.println("5. Search student");
            System.out.println("6. Display all students");
            System.out.println("7. Update student grade");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline

            int rollNumber;
            int age;
            int position;
            String name;
            String grade;

            switch (choice) {

                case 1:
                    // Read student details and insert at the beginning
                    System.out.print("Enter roll number: ");
                    rollNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter name: ");
                    name = sc.nextLine();

                    System.out.print("Enter age: ");
                    age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter grade: ");
                    grade = sc.nextLine();

                    list.insertAtBeginning(
                            rollNumber, name, age, grade);
                    break;

                case 2:
                    // Read student details and insert at the end
                    System.out.print("Enter roll number: ");
                    rollNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter name: ");
                    name = sc.nextLine();

                    System.out.print("Enter age: ");
                    age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter grade: ");
                    grade = sc.nextLine();

                    list.insertAtEnd(
                            rollNumber, name, age, grade);
                    break;

                case 3:
                    // Read student details and the target position
                    System.out.print("Enter roll number: ");
                    rollNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter name: ");
                    name = sc.nextLine();

                    System.out.print("Enter age: ");
                    age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter grade: ");
                    grade = sc.nextLine();

                    System.out.print("Enter position (starting from 1): ");
                    position = sc.nextInt();

                    list.insertAtPosition(
                            rollNumber, name, age, grade, position);
                    break;

                case 4:
                    // Delete a student by roll number
                    System.out.print("Enter roll number to delete: ");
                    rollNumber = sc.nextInt();

                    list.deleteStudent(rollNumber);
                    break;

                case 5:
                    // Search and display a student's details
                    System.out.print("Enter roll number to search: ");
                    rollNumber = sc.nextInt();

                    Student found = list.search(rollNumber);

                    if (found != null) {
                        System.out.println("\nStudent Found!");
                        System.out.println("Roll Number: " + found.rollNumber);
                        System.out.println("Name       : " + found.name);
                        System.out.println("Age        : " + found.age);
                        System.out.println("Grade      : " + found.grade);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 6:
                    // Display every student in the linked list
                    list.display();
                    break;

                case 7:
                    // Update a student's grade
                    System.out.print("Enter roll number: ");
                    rollNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new grade: ");
                    grade = sc.nextLine();

                    list.updateGrade(rollNumber, grade);
                    break;

                case 0:
                    // Exit the program
                    System.out.println("Exiting program...");
                    break;

                default:
                    // Handle an invalid menu choice
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        // Close the Scanner
        sc.close();
    }
}
