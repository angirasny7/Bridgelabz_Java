package Methods.Level2;
import java.util.Scanner;
/*
 * Finds the factors of a number and calculates their sum,
 * product, and sum of squares.
 */

public class FactorsCalculator {
    public static int[] findFactors(int number){
        int count = 0;
        for(int i = 1; i<=number; i++){
            if(number % i == 0){
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;
        for(int i = 1; i<=number; i++){
            if(number % i == 0){
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }
    public static int findSum(int[] factors){
        int sum = 0;
        for(int factor : factors){
            sum += factor;
        }
        return sum;
    }
    public static long findProduct(int[] factors){
        long product = 1;
        for(int factor : factors){
            product *= factor;
        }
        return product;
    }
    public static double findSumOfSquares(int[] factors){
        double sumOfSquares = 0;
        for(int factor : factors){
            sumOfSquares += Math.pow(factor, 2);
        }
        return sumOfSquares;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a positive number: ");
        int number = input.nextInt();

        if(number <= 0){
            System.out.println("Please enter a postive integer");
        }
        else{
            int[] factors = findFactors(number);
            System.out.println("Factors: ");
            for(int factor : factors){
                System.out.print(factor + " ");
            }
            System.out.println();
            System.out.println("Sum of factors: " +  findSum(factors));
            System.out.println("Product of factors: " + findProduct(factors));
            System.out.println("Sum of squares of factors: " + findSumOfSquares(factors));
        }
        input.close();
    }
}
