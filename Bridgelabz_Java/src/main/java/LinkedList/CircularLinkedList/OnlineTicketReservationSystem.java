package LinkedList.CircularLinkedList;

import java.util.Scanner;

/*
 * Problem Statement:
 * Design an online ticket reservation system using a circular linked list.
 * Each node stores Ticket ID, Customer Name, Movie Name, Seat Number,
 * and Booking Time.
 *
 * Implement the following operations:
 * 1. Add a new ticket reservation at the end of the circular list.
 * 2. Remove a ticket using its Ticket ID.
 * 3. Display all booked tickets.
 * 4. Search for tickets by Customer Name or Movie Name.
 * 5. Calculate the total number of booked tickets.
 *
 * A circular linked list is used so that the last node's next pointer
 * points back to the first node.
 */

public class OnlineTicketReservationSystem {

    // Node represents one booked ticket.
    static class Ticket {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Ticket next;

        Ticket(int ticketId, String customerName, String movieName,
               String seatNumber, String bookingTime) {

            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    // Stores the first and last nodes of the circular linked list.
    static class CircularLinkedList {
        private Ticket head;
        private Ticket tail;
        private int size = 0;

        // Add a new ticket at the end of the circular linked list.
        public void addTicket(int ticketId, String customerName,
                              String movieName, String seatNumber,
                              String bookingTime) {

            // Prevent duplicate ticket IDs.
            if (findTicketById(ticketId) != null) {
                System.out.println("Ticket ID already exists!");
                return;
            }

            Ticket newTicket = new Ticket(
                    ticketId, customerName, movieName,
                    seatNumber, bookingTime
            );

            // Case 1: The list is empty.
            if (head == null) {
                head = newTicket;
                tail = newTicket;

                // The only node points to itself.
                newTicket.next = head;
            } else {
                // Attach the new node after the current last node.
                tail.next = newTicket;
                tail = newTicket;

                // Maintain the circular connection.
                tail.next = head;
            }

            size++;
            System.out.println("Ticket booked successfully!");
        }

        // Find a ticket using its unique Ticket ID.
        private Ticket findTicketById(int ticketId) {
            if (head == null) {
                return null;
            }

            Ticket current = head;

            // Stop after visiting every node exactly once.
            do {
                if (current.ticketId == ticketId) {
                    return current;
                }

                current = current.next;
            } while (current != head);

            return null;
        }

        // Remove a ticket using its Ticket ID.
        public void removeTicket(int ticketId) {
            if (head == null) {
                System.out.println("No tickets are booked.");
                return;
            }

            Ticket current = head;
            Ticket previous = tail;

            // Search the circular list for the requested ticket.
            do {
                if (current.ticketId == ticketId) {

                    // Case 1: Only one node exists.
                    if (head == tail) {
                        head = null;
                        tail = null;
                    }
                    // Case 2: The first node is being removed.
                    else if (current == head) {
                        head = head.next;
                        tail.next = head;
                    }
                    // Case 3: The last node is being removed.
                    else if (current == tail) {
                        previous.next = head;
                        tail = previous;
                        tail.next = head;
                    }
                    // Case 4: A middle node is being removed.
                    else {
                        previous.next = current.next;
                    }

                    size--;
                    System.out.println(
                            "Ticket ID " + ticketId + " removed successfully!"
                    );
                    return;
                }

                previous = current;
                current = current.next;

            } while (current != head);

            System.out.println("Ticket ID not found.");
        }

        // Display all booked tickets.
        public void displayTickets() {
            if (head == null) {
                System.out.println("No tickets are booked.");
                return;
            }

            Ticket current = head;

            System.out.println("\n========== BOOKED TICKETS ==========");

            // A do-while loop ensures the first node is displayed.
            do {
                System.out.println("------------------------------");
                System.out.println("Ticket ID    : " + current.ticketId);
                System.out.println("Customer Name: " + current.customerName);
                System.out.println("Movie Name   : " + current.movieName);
                System.out.println("Seat Number  : " + current.seatNumber);
                System.out.println("Booking Time : " + current.bookingTime);

                current = current.next;
            } while (current != head);

            System.out.println("------------------------------");
            System.out.println("Total Tickets: " + size);
        }

        // Search for tickets using the customer's name.
        public void searchByCustomerName(String customerName) {
            if (head == null) {
                System.out.println("No tickets are booked.");
                return;
            }

            Ticket current = head;
            boolean found = false;

            do {
                if (current.customerName.equalsIgnoreCase(customerName)) {
                    displaySingleTicket(current);
                    found = true;
                }

                current = current.next;
            } while (current != head);

            if (!found) {
                System.out.println("No tickets found for customer: "
                        + customerName);
            }
        }

        // Search for tickets using the movie name.
        public void searchByMovieName(String movieName) {
            if (head == null) {
                System.out.println("No tickets are booked.");
                return;
            }

            Ticket current = head;
            boolean found = false;

            do {
                if (current.movieName.equalsIgnoreCase(movieName)) {
                    displaySingleTicket(current);
                    found = true;
                }

                current = current.next;
            } while (current != head);

            if (!found) {
                System.out.println("No tickets found for movie: " + movieName);
            }
        }

        // Display the details of one ticket.
        private void displaySingleTicket(Ticket ticket) {
            System.out.println("------------------------------");
            System.out.println("Ticket ID    : " + ticket.ticketId);
            System.out.println("Customer Name: " + ticket.customerName);
            System.out.println("Movie Name   : " + ticket.movieName);
            System.out.println("Seat Number  : " + ticket.seatNumber);
            System.out.println("Booking Time : " + ticket.bookingTime);
        }

        // Return the total number of booked tickets.
        public int getTotalTickets() {
            return size;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList reservations = new CircularLinkedList();

        int choice;

        do {
            System.out.println("\n===== ONLINE TICKET RESERVATION SYSTEM =====");
            System.out.println("1. Book a Ticket");
            System.out.println("2. Remove a Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search by Customer Name");
            System.out.println("5. Search by Movie Name");
            System.out.println("6. Count Booked Tickets");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character.

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int ticketId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String customerName = sc.nextLine();

                    System.out.print("Enter Movie Name: ");
                    String movieName = sc.nextLine();

                    System.out.print("Enter Seat Number: ");
                    String seatNumber = sc.nextLine();

                    System.out.print("Enter Booking Time: ");
                    String bookingTime = sc.nextLine();

                    reservations.addTicket(
                            ticketId, customerName, movieName,
                            seatNumber, bookingTime
                    );
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    int removeId = sc.nextInt();
                    sc.nextLine();

                    reservations.removeTicket(removeId);
                    break;

                case 3:
                    reservations.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer Name: ");
                    String searchCustomer = sc.nextLine();

                    reservations.searchByCustomerName(searchCustomer);
                    break;

                case 5:
                    System.out.print("Enter Movie Name: ");
                    String searchMovie = sc.nextLine();

                    reservations.searchByMovieName(searchMovie);
                    break;

                case 6:
                    System.out.println("Total Booked Tickets: "
                            + reservations.getTotalTickets());
                    break;

                case 7:
                    System.out.println("Exiting Ticket Reservation System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
