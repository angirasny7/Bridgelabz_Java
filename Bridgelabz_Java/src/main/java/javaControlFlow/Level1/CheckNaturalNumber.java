package javaControlFlow.Level1;
import java.util.Scanner;
/*
Question 4: Program to check for the natural number and
write the sum of n natural numbers
*/

public class CheckNaturalNumber {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Take the input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        //Check the condition and compute the sum
        if(number >= 0){
            int sum = (number*(number+1))/2;
            System.out.printf("The sum of %d natural numbers is %d ", number, sum);
        }
        else{
            System.out.printf("The number %d is not a natural number ", number);
        }
        input.close();
    }
}
