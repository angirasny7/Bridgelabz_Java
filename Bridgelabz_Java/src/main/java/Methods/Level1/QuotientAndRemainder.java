package Methods.Level1;

import java.util.Scanner;

/*
 * Calculates the quotient and remainder of two integers using a method.
 */
public class QuotientAndRemainder {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;

        return new int[]{remainder, quotient};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = input.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = input.nextInt();

        if (divisor == 0) {
            System.out.println("Divisor cannot be zero.");
        } else {
            int[] result = findRemainderAndQuotient(number, divisor);

            System.out.println("Quotient: " + result[1]);
            System.out.println("Remainder: " + result[0]);
        }

        input.close();
    }
}