package ClassesAndObjects.Level1;
import java.util.Scanner;
/*
 * Question: Compute Area and Circumference of a Circle
 * Create a Circle class with an attribute radius.
 * Add methods to calculate and display the area
 * and circumference of the circle.
 */

//Class to represent circle
class Circle{
    //Attribute to store the radius of the circle
    double radius;

    //Method to calculate the area of the circle
    double calculateArea(){
        return Math.PI*radius*radius;
    }

    //Method to calculate the circumference of the circle
    double calculateCircumference(){
        return 2*Math.PI*radius;
    }

    // Method to display the area and circumference
    void displayDetails() {
        System.out.printf("Area: %.2f%n", calculateArea());
        System.out.printf("Circumference: %.2f%n", calculateCircumference());
    }
}

public class CircleArea {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Create an object of the Class circle
        Circle circle = new Circle();

        // Input the radius
        System.out.print("Enter the radius of the circle: ");
        circle.radius = input.nextDouble();

        // Display the area and circumference
        circle.displayDetails();

        // Close the Scanner
        input.close();
    }
}
