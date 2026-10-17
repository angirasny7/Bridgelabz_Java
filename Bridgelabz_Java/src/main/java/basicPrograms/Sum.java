package basicPrograms;

import java.util.Scanner;
public class Sum {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num1: ");
        int num1 = sc.nextInt();


        System.out.print("Enter num2: ");
        int num2 =  sc.nextInt();

        int sum = num1+num2;

        System.out.println("Sum is: " + sum);
    }
}

