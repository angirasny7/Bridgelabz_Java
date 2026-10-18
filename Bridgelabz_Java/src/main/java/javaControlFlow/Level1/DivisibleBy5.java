package javaControlFlow.Level1;
import java.util.Scanner;

/*
Question 1: Program to check if the number is divisible by 5
 */

public class DivisibleBy5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Take input from the user
        System.out.print("Number: ");
        int number = input.nextInt();

        //Check if the number is divisible by 5
        if(number % 5 == 0){
            System.out.printf("Is the number %d divisible by 5? Yes", number);
        }
        else{
            System.out.printf("Is the number %d divisible by 5? No", number);
        }
        input.close();

    }
}
