package basicPrograms;

import java.util.Scanner;
public class SwapNumbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num1: ");
        int num1 = sc.nextInt();

        System.out.print("Enter num1: ");
        int num2 = sc.nextInt();

        System.out.println("Before Swapping:");
        System.out.println("a = " + num1);
        System.out.println("b = " + num2);

        int temp = num1;
        num1 = num2;
        num2 = temp;

        System.out.println("After Swapping:");
        System.out.println("a = " + num1);
        System.out.println("b = " + num2);
    }
}

