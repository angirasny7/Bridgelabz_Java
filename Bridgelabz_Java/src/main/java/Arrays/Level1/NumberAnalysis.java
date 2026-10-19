package Arrays.Level1;
import java.util.Scanner;
/*
 * Classifies five numbers and compares the first and last elements.
 */

public class NumberAnalysis {
    public static void main(String[] args){
        Scanner input  = new Scanner(System.in);

        int[] numbers = new int[5];

        // Take input for five numbers
        for(int i = 0; i<numbers.length; i++){
            System.out.print("Enter number " + (i+1) + ": ");
            numbers[i] = input.nextInt();
        }
        // Classify each number
        for(int i = 0; i< numbers.length; i++){
            if(numbers[i] > 0){
                if(numbers[i] % 2 == 0){
                    System.out.printf("Number %d is positive and even%n", numbers[i]);
                }
                else{
                    System.out.printf("Number %d is positive and odd%n", numbers[i]);
                }
            }
            else if(numbers[i] < 0){
                System.out.printf("Number %d is negative%n", numbers[i]);
            }
            else{
                System.out.printf("Number %d is zero%n", numbers[i]);
            }
        }
        // Compare the first and last elements
        int last = numbers.length-1;
        if(numbers[0] > numbers[last]){
            System.out.printf("Number %d is greater than %d%n", numbers[0], numbers[last]);
        }
        else if(numbers[0] < numbers[last]){
            System.out.printf("Number %d is less than %d%n ", numbers[0], numbers[last]);
        }
        else{
            System.out.printf("Number %d and %d are equal%n", numbers[0] , numbers[last]);
        }
        input.close();
    }
}
