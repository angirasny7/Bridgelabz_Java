package Methods.Level1;

import java.util.Scanner;

/*
 * Calculates the sum of the first N natural numbers using a loop.
 */
public class SumNaturalNumbers {

    public static int calculateSum(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();

        if (n < 1) {
            System.out.println("Please enter a positive integer.");
        } else {
            int sum = calculateSum(n);
            System.out.println("Sum of the first " + n + " natural numbers: " + sum);
        }

        input.close();
    }
}