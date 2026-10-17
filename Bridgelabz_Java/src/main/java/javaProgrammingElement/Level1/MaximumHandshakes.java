package javaProgrammingElement.Level1;

import java.util.Scanner;

public class MaximumHandshakes {
    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Take the number of students as input
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        // Calculate the maximum number of handshakes
        int handshakes =
                (numberOfStudents * (numberOfStudents - 1)) / 2;

        // Display the result
        System.out.println(
                "The maximum number of handshakes is " + handshakes
        );

        input.close();
    }
}

