package Strings.Level2;
import java.util.Scanner;
/*
 * Question:
 * Write a program to find the length of a String without using the
 * built-in length() method. Use an infinite loop to count characters
 * using charAt(). When charAt() throws a StringIndexOutOfBoundsException,
 * handle the exception and return the character count. Compare the result
 * with the built-in length() method.
 */

public class FindStringLength {
    //Method to find String length without using length()
    public static int findLength(String text){
        int count = 0;
        try{
            //Infinite loop to access characters one by one
            while(true){
                text.charAt(count);
                count++;
            }
        }
        catch(StringIndexOutOfBoundsException e){
            //The exception occurs when count reaches the String's Length
            return count;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Take input from the user
        System.out.print("Enter a string: ");
        String text = sc.next();

        //Find the length using the user-defined method
        int result1 = findLength(text);
        //Find the length using the built-in method
        int result2 = text.length();

        //Display both results
        System.out.println("Length using user-defined method: " + result1);
        System.out.println("Length using built-in length(): "+ result2);

        //Compare both the results
        System.out.println("Are both results equal? " + (result1 == result2));

        sc.close();

    }
}
