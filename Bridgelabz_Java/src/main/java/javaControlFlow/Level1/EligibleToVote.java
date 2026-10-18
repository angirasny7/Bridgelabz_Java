package javaControlFlow.Level1;
import java.util.Scanner;

/*
Question 5: A program to check whether a person can vote, depending on whether his/her
age is greater than or equal to 18.
*/

public class EligibleToVote {
    public static void main(String[] args){
        Scanner input  = new Scanner(System.in);

        //Take age as input
        System.out.print("Enter the age: ");
        int age = input.nextInt();

        //Check if the person is eligible to vote
        if(age >= 18){
            System.out.printf("The person's age is %d and can vote. ", age);
        }
        else{
            System.out.printf("The person's age is %d and cannot vote. ", age);
        }
        input.close();
    }
}
