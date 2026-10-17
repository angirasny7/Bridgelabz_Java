package javaProgrammingElement.Level1;

import java.util.Scanner;
public class CalculateStudentFee {
    public static void main(String[] args){

        //Take the user input
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the student fee: ");
        double fee = input.nextDouble();

        System.out.print("Enter the discount percentage: ");
        double discountPercent = input.nextDouble();

        //Calculate discount amount
        double discount  = (fee * discountPercent)/100;

        //Calculate final fee
        double feeToPay = fee - discount;

        //Display the result
        System.out.printf("The discount amount is INR %.2f%n", discount);
        System.out.printf("The fee you have to pay is INR %.2f%n", feeToPay);

        input.close();
    }
}

