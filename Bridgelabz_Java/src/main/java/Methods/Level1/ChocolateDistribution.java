package Methods.Level1;

import java.util.Scanner;

/*
 * Calculates how many chocolates each child receives and how many remain.
 */
public class ChocolateDistribution {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;

        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = input.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = input.nextInt();

        if (numberOfChocolates < 0 || numberOfChildren <= 0) {
            System.out.println("Please enter a non-negative number of chocolates and a positive number of children.");
        } else {
            int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

            System.out.println("Chocolates each child gets: " + result[0]);
            System.out.println("Remaining chocolates: " + result[1]);
        }

        input.close();
    }
}