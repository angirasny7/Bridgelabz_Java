package Arrays.Level1;
import java.util.Scanner;

/*
 * Stores and displays the multiplication table of a number from 1 to 10.
 */

public class MultiplicationTable {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] table = new int[10];

        // Store the multiplication results in the array
        for(int i = 1; i<table.length; i++){
            table[i-1] = number*i;
        }

        // Display the multiplication table
        for(int i = 1; i<= table.length; i++){
            System.out.printf("%d * %d = %d%n", number, i, table[i-1]);
        }
        input.close();
    }
}
