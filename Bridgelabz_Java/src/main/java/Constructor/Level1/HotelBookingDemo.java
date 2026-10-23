
/*
 * Question: Hotel Booking System
 * Create a HotelBooking class with attributes guestName, roomType,
 * and nights. Use default, parameterized, and copy constructors
 * to initialize bookings.
 */

package Constructor.Level1;

// Class to represent a Hotel Booking
class HotelBooking {

    // Attributes to store booking details
    String guestName;
    String roomType;
    int nights;

    // Default constructor
    HotelBooking() {
        guestName = "Unknown";
        roomType = "Standard";
        nights = 1;
    }

    // Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    // Method to display booking details
    void displayDetails() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Nights: " + nights);
        System.out.println();
    }
}

// Main class
public class HotelBookingDemo {

    public static void main(String[] args) {

        // Create a booking using the default constructor
        HotelBooking booking1 = new HotelBooking();

        // Create a booking using the parameterized constructor
        HotelBooking booking2 =
                new HotelBooking("Rahul Sharma", "Deluxe", 3);

        // Create a copy of booking2 using the copy constructor
        HotelBooking booking3 = new HotelBooking(booking2);

        // Display the default booking
        System.out.println("Booking 1 (Default Constructor):");
        booking1.displayDetails();

        // Display the parameterized booking
        System.out.println("Booking 2 (Parameterized Constructor):");
        booking2.displayDetails();

        // Display the copied booking
        System.out.println("Booking 3 (Copy Constructor):");
        booking3.displayDetails();
    }
}
