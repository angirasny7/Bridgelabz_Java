package LinkedList.SinglyLinkedList;

/*
 * Problem Statement: Social Media Friend Connections Using Singly Linked List
 *
 * Create a system to manage social media friend connections using a
 * singly linked list. Each node represents a user and stores:
 * User ID, Name, Age, and a List of Friend IDs.
 *
 * Implement the following operations:
 * 1. Add a friend connection between two users.
 * 2. Remove a friend connection between two users.
 * 3. Find mutual friends between two users.
 * 4. Display all friends of a specific user.
 * 5. Search for a user by Name or User ID.
 * 6. Count the number of friends for each user.
 *
 * Requirements:
 * - Store users in a custom singly linked list.
 * - Store each user's friend IDs in a list.
 * - Friend connections are mutual (undirected).
 * - Prevent duplicate users and duplicate friendships.
 * - A user cannot be their own friend.
 * - Handle users or connections that do not exist.
 */

import java.util.ArrayList;
import java.util.Scanner;

// Represents a user in the social media system
class User {
    int userId;
    String name;
    int age;

    // Stores the IDs of this user's friends
    ArrayList<Integer> friendIds;

    // Points to the next user in the singly linked list
    User next;

    // Initializes user details
    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

// Manages users and their friend connections
class SocialMediaLinkedList {

    // Points to the first user
    private User head;

    // Searches for a user using their ID
    private User findUserById(int userId) {
        User current = head;

        while (current != null) {
            if (current.userId == userId) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    // Adds a new user at the end of the linked list
    public void addUser(int userId, String name, int age) {

        // Prevent duplicate user IDs
        if (findUserById(userId) != null) {
            System.out.println("User ID already exists.");
            return;
        }

        if (age < 0) {
            System.out.println("Age cannot be negative.");
            return;
        }

        User newUser = new User(userId, name, age);

        // If the list is empty, the new user becomes the head
        if (head == null) {
            head = newUser;
        } else {
            // Traverse to the last user
            User current = head;

            while (current.next != null) {
                current = current.next;
            }

            // Append the new user
            current.next = newUser;
        }

        System.out.println("User added successfully.");
    }

    // Adds a mutual friendship between two users
    public void addFriendConnection(int firstId, int secondId) {

        // A user cannot be friends with themselves
        if (firstId == secondId) {
            System.out.println("A user cannot be their own friend.");
            return;
        }

        User first = findUserById(firstId);
        User second = findUserById(secondId);

        // Both users must exist
        if (first == null || second == null) {
            System.out.println("One or both users were not found.");
            return;
        }

        // Prevent duplicate friendships
        if (first.friendIds.contains(secondId)) {
            System.out.println("Friend connection already exists.");
            return;
        }

        // Store the connection in both users' friend lists
        first.friendIds.add(secondId);
        second.friendIds.add(firstId);

        System.out.println("Friend connection added successfully.");
    }

    // Removes a mutual friendship between two users
    public void removeFriendConnection(int firstId, int secondId) {

        User first = findUserById(firstId);
        User second = findUserById(secondId);

        if (first == null || second == null) {
            System.out.println("One or both users were not found.");
            return;
        }

        // Check whether the friendship exists
        if (!first.friendIds.contains(secondId)) {
            System.out.println("Friend connection does not exist.");
            return;
        }

        // Remove the connection from both friend lists
        first.friendIds.remove(Integer.valueOf(secondId));
        second.friendIds.remove(Integer.valueOf(firstId));

        System.out.println("Friend connection removed successfully.");
    }

    // Finds mutual friends between two users
    public void findMutualFriends(int firstId, int secondId) {

        User first = findUserById(firstId);
        User second = findUserById(secondId);

        if (first == null || second == null) {
            System.out.println("One or both users were not found.");
            return;
        }

        boolean found = false;

        System.out.println("\n--- Mutual Friends ---");

        // Check which friends of the first user also belong
        // to the second user's friend list
        for (int friendId : first.friendIds) {

            if (second.friendIds.contains(friendId)) {
                User mutualFriend = findUserById(friendId);

                if (mutualFriend != null) {
                    System.out.println(
                            "User ID: " + mutualFriend.userId
                                    + ", Name: " + mutualFriend.name);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No mutual friends found.");
        }
    }

    // Displays all friends of a specific user
    public void displayFriends(int userId) {

        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("\nFriends of " + user.name + ":");

        if (user.friendIds.isEmpty()) {
            System.out.println("This user has no friends.");
            return;
        }

        // Display each friend using their ID
        for (int friendId : user.friendIds) {
            User friend = findUserById(friendId);

            if (friend != null) {
                System.out.println(
                        "User ID: " + friend.userId
                                + ", Name: " + friend.name
                                + ", Age: " + friend.age);
            }
        }
    }

    // Searches for users by their ID
    public void searchById(int userId) {

        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
        } else {
            displayUser(user);
        }
    }

    // Searches for users by their name
    public void searchByName(String name) {

        User current = head;
        boolean found = false;

        // Multiple users may have the same name
        while (current != null) {

            if (current.name.equalsIgnoreCase(name)) {
                displayUser(current);
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("No user found with this name.");
        }
    }

    // Displays the details of one user
    private void displayUser(User user) {
        System.out.println("User ID: " + user.userId);
        System.out.println("Name   : " + user.name);
        System.out.println("Age    : " + user.age);
        System.out.println("Friends: " + user.friendIds.size());
        System.out.println("--------------------------");
    }

    // Counts the friends of every user
    public void countFriendsForEachUser() {

        if (head == null) {
            System.out.println("No users available.");
            return;
        }

        User current = head;

        System.out.println("\n--- Friend Counts ---");

        while (current != null) {
            System.out.println(
                    "User: " + current.name
                            + " (ID: " + current.userId + ")"
                            + " | Number of Friends: "
                            + current.friendIds.size());

            current = current.next;
        }
    }

    // Displays all users in the system
    public void displayAllUsers() {

        if (head == null) {
            System.out.println("No users available.");
            return;
        }

        User current = head;

        System.out.println("\n--- All Users ---");

        while (current != null) {
            displayUser(current);
            current = current.next;
        }
    }
}

// Main class for the social media application
public class SocialMediaFriendConnections {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SocialMediaLinkedList socialMedia =
                new SocialMediaLinkedList();

        int choice;

        // Continue displaying the menu until the user exits
        do {
            System.out.println("\n===== Social Media Friend Connections =====");
            System.out.println("1. Add user");
            System.out.println("2. Add friend connection");
            System.out.println("3. Remove friend connection");
            System.out.println("4. Find mutual friends");
            System.out.println("5. Display friends of a user");
            System.out.println("6. Search user by ID");
            System.out.println("7. Search user by name");
            System.out.println("8. Count friends for each user");
            System.out.println("9. Display all users");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            int userId;
            int firstId;
            int secondId;
            int age;
            String name;

            switch (choice) {

                case 1:
                    // Read details and create a new user
                    System.out.print("Enter user ID: ");
                    userId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter name: ");
                    name = sc.nextLine();

                    System.out.print("Enter age: ");
                    age = sc.nextInt();

                    socialMedia.addUser(userId, name, age);
                    break;

                case 2:
                    // Connect two users as friends
                    System.out.print("Enter first user ID: ");
                    firstId = sc.nextInt();

                    System.out.print("Enter second user ID: ");
                    secondId = sc.nextInt();

                    socialMedia.addFriendConnection(firstId, secondId);
                    break;

                case 3:
                    // Remove the friendship between two users
                    System.out.print("Enter first user ID: ");
                    firstId = sc.nextInt();

                    System.out.print("Enter second user ID: ");
                    secondId = sc.nextInt();

                    socialMedia.removeFriendConnection(firstId, secondId);
                    break;

                case 4:
                    // Find friends shared by two users
                    System.out.print("Enter first user ID: ");
                    firstId = sc.nextInt();

                    System.out.print("Enter second user ID: ");
                    secondId = sc.nextInt();

                    socialMedia.findMutualFriends(firstId, secondId);
                    break;

                case 5:
                    // Display all friends of a user
                    System.out.print("Enter user ID: ");
                    userId = sc.nextInt();

                    socialMedia.displayFriends(userId);
                    break;

                case 6:
                    // Search for a user by ID
                    System.out.print("Enter user ID: ");
                    userId = sc.nextInt();

                    socialMedia.searchById(userId);
                    break;

                case 7:
                    // Search for users by name
                    System.out.print("Enter name: ");
                    name = sc.nextLine();

                    socialMedia.searchByName(name);
                    break;

                case 8:
                    // Display the number of friends for each user
                    socialMedia.countFriendsForEachUser();
                    break;

                case 9:
                    // Display all registered users
                    socialMedia.displayAllUsers();
                    break;

                case 0:
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
