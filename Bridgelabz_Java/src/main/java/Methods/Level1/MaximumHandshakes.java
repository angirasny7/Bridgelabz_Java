package Methods.Level1;

import java.util.Scanner;

/*
 * Calculates the maximum number of handshakes
 * possible among N students using a method.
 */

public class MaximumHandshakes {

    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        if (numberOfStudents < 0) {
            System.out.println("Number of students cannot be negative.");
        } else {
            int handshakes = calculateHandshakes(numberOfStudents);

            System.out.println("Maximum number of handshakes: " + handshakes);
        }

        input.close();
    }
}