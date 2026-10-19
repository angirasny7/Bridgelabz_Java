package Arrays.Level1;

import java.util.Scanner;

/*
 * Stores up to 10 positive numbers and calculates their sum.
 */

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        // Accept numbers until 0, a negative number, or the array is full
        while (true) {
            System.out.print("Enter a positive number (0 or negative to stop): ");
            double number = input.nextDouble();

            if (number <= 0 || index == numbers.length) {
                break;
            }

            numbers[index] = number;
            index++;
        }

        // Display the numbers and calculate their sum
        System.out.println("Numbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.printf("Total sum: %.2f%n", total);

        input.close();
    }
}