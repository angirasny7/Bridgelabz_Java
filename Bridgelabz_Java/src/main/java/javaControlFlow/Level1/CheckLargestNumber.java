package javaControlFlow.Level1;
import java.util.Scanner;

/* Question 3: Program to check if the first, second, or third
number is the largest of the three.
*/
public class CheckLargestNumber {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Take input from the user
        System.out.print("Enter Number1: ");
        int number1 = input.nextInt();

        System.out.print("Enter Number2: ");
        int number2 = input.nextInt();

        System.out.print("Enter Number3: ");
        int number3 = input.nextInt();

        // Check which number is the largest
        boolean firstIsLargest = number1 > number2 && number1 > number3;
        boolean secondIsLargest = number2 > number1 && number2 > number3;
        boolean thirdIsLargest = number3 > number1 && number3 > number2;

        // Display the results
        System.out.println("Is the first number the largest? " + firstIsLargest);
        System.out.println("Is the second number the largest? " + secondIsLargest);
        System.out.println("Is the third number the largest? " + thirdIsLargest);

        input.close();
    }
}
