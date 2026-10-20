package Methods.Level2;
import java.util.Scanner;

/*
 * Calculates the sum of n natural numbers using recursion
 * and the formula n * (n + 1) / 2, then compares the results.
 */

public class SumNaturalNumbers {
    //Calculate Sum of natural numbers using recursion.
    public static long sumUsingRecursion(int n){
        //Base case
        if(n == 1){
            return 1;
        }
        //Recursive case
        return n + sumUsingRecursion(n-1);
    }
    //Calculate sum using the mathematical formula
    public static long sumUsingFormula(int n){
        return (long)n*(n+1)/2;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Take the input from the user
        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        //Check whether the input is a natural number
        if(n < 0){
            System.out.println("Invalid input! Please enter a natural number");
            input.close();
            return;
        }
        //Calculate sum using both methods.
        long recursiveSum = sumUsingRecursion(n);
        long formulaSum = sumUsingFormula(n);

        //Display the results
        System.out.println("Sum using formula: " + recursiveSum);
        System.out.println("Sum using formula: "+ formulaSum);

        //Compare the results to verify correctness
        if(recursiveSum == formulaSum){
            System.out.println("Both computations are correct. The results match.");
        }
        else{
            System.out.println("The results do not match.");
        }
        input.close();
    }
}
