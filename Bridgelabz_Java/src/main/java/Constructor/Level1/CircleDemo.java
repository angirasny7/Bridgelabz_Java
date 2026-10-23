
/*
 * Question: Create a Circle class with a radius attribute.
 * Use constructor chaining to initialize radius with default
 * and user-provided values.
 */

package Constructor.Level1;

// Class to represent a Circle
class Circle {

    // Attribute to store the radius
    double radius;

    // Default constructor
    Circle() {
        this(1.0); // Calls the parameterized constructor
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to display the radius
    void displayDetails() {
        System.out.println("Radius: " + radius);
    }
}

// Main class
public class CircleDemo {

    public static void main(String[] args) {

        // Create an object using the default constructor
        Circle circle1 = new Circle();

        // Create an object using the parameterized constructor
        Circle circle2 = new Circle(5.0);

        // Display circle details
        System.out.println("Circle 1 (Default Constructor):");
        circle1.displayDetails();

        System.out.println("\nCircle 2 (User-Provided Radius):");
        circle2.displayDetails();
    }
}
