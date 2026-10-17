package basicPrograms;

import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        int original = num;
        int temp = num;
        int sum = 0;
        int digits = 0;
        while(temp > 0){
            digits++;
            temp = temp/10;
        }
        temp = num;

        while(temp > 0){
            int digit = temp % 10;
            sum += (int)Math.pow(digit, digits);
            temp = temp/10;
        }
        if(sum == original){
            System.out.println(num + " is an Armstrong Number");
        }
        else{
            System.out.println(num + " is not an Armstrong Number");
        }
    }
}

