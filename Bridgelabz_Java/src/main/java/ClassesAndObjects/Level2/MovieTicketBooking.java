
/*
 * Question: Model a Movie Ticket Booking System
 * Create a MovieTicket class with attributes movieName, seatNumber,
 * and price. Add methods to book a ticket by assigning a seat
 * and updating the price, and to display ticket details.
 */

package ClassesAndObjects.Level2;

import java.util.Scanner;

// Class to represent a Movie Ticket
class MovieTicket {

    // Attributes to store ticket details
    String movieName;
    String seatNumber;
    double price;

    // Method to book a ticket by assigning a seat and price
    void bookTicket(String seat, double ticketPrice) {
        if (ticketPrice > 0 && seat != null && !seat.trim().isEmpty()) {
            seatNumber = seat;
            price = ticketPrice;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Invalid seat number or ticket price.");
        }
    }

    // Method to display ticket details
    void displayDetails() {
        System.out.println("\n----- Movie Ticket Details -----");
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.printf("Ticket Price: %.2f%n", price);
    }
}

// Main class
public class MovieTicketBooking {

    public static void main(String[] args) {

        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Create an object of the MovieTicket class
        MovieTicket ticket = new MovieTicket();

        // Input the movie name
        System.out.print("Enter movie name: ");
        ticket.movieName = input.nextLine();

        // Input the seat number
        System.out.print("Enter seat number: ");
        String seat = input.nextLine();

        // Input the ticket price
        System.out.print("Enter ticket price: ");
        double ticketPrice = input.nextDouble();

        // Book the movie ticket
        ticket.bookTicket(seat, ticketPrice);

        // Display ticket details only if booking is successful
        if (ticket.seatNumber != null) {
            ticket.displayDetails();
        }

        // Close the Scanner
        input.close();
    }
}
