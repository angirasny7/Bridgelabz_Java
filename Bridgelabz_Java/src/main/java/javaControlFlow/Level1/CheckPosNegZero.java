package javaControlFlow.Level1;
import java.util.Scanner;

/*
Question 6:
A program to check whether a number is positive, negative, or zero.
 */

public class CheckPosNegZero {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Take the input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        //Check the condition and print
        if(number > 0){
            System.out.println("Positive");
        }
        else if(number < 0){
            System.out.println("Negative");
        }
        else{
            System.out.println("Zero");
        }
        input.close();
    }
}
