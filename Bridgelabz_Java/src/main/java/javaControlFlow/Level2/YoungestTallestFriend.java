package javaControlFlow.Level2;

import java.util.Scanner;

/*
 * Finds the youngest and tallest among three friends.
 */

public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Amar's age: ");
        int amarAge = input.nextInt();
        System.out.print("Enter Amar's height in cm: ");
        double amarHeight = input.nextDouble();

        System.out.print("Enter Akbar's age: ");
        int akbarAge = input.nextInt();
        System.out.print("Enter Akbar's height in cm: ");
        double akbarHeight = input.nextDouble();

        System.out.print("Enter Anthony's age: ");
        int anthonyAge = input.nextInt();
        System.out.print("Enter Anthony's height in cm: ");
        double anthonyHeight = input.nextDouble();

        String youngest = "Amar";
        int minimumAge = amarAge;

        if (akbarAge < minimumAge) {
            minimumAge = akbarAge;
            youngest = "Akbar";
        }
        if (anthonyAge < minimumAge) {
            youngest = "Anthony";
        }

        String tallest = "Amar";
        double maximumHeight = amarHeight;

        if (akbarHeight > maximumHeight) {
            maximumHeight = akbarHeight;
            tallest = "Akbar";
        }
        if (anthonyHeight > maximumHeight) {
            tallest = "Anthony";
        }

        System.out.println("Youngest friend: " + youngest);
        System.out.println("Tallest friend: " + tallest);

        input.close();
    }
}
