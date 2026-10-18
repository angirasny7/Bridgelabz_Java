package javaControlFlow.Level1;
import java.util.Scanner;

/*Question 2: Program to check if the first number is
the smallest of the 3 numbers
*/
public class CheckSmallest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Take the input for three numbers
        System.out.print("Enter Number1: ");
        int number1 = input.nextInt();

        System.out.print("Enter Number2: ");
        int number2 = input.nextInt();

        System.out.print("Enter Number3: ");
        int number3 = input.nextInt();

        //Check the condition
        if(number1 < number2 && number1 < number3){
            System.out.println("Is the first number the smallest? Yes");
        }
        else{
            System.out.println("Is the first number the smallest? No");
        }
        input.close();
    }
}
