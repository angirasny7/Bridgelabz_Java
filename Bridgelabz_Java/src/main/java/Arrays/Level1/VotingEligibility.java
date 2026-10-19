package Arrays.Level1;
import java.util.Scanner;

/*
 * Checks the voting eligibility of 10 students based on their ages.
 */

public class VotingEligibility {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int[] ages = new int[10];

        //Take the ages of 10 students
        for(int i = 0; i<ages.length; i++){
            System.out.print("Enter age of student " + (i+1) + ": ");
            ages[i] = input.nextInt();
        }
        //Check voting eligibility for each student
        for(int i = 0; i<ages.length; i++){
            if(ages[i] < 0){
                System.out.println("Invalid age: " + ages[i]);
            }
            else if(ages[i] >= 18){
                System.out.println("The student with the age " + ages[i] + " can vote");
            }
            else{
                System.out.println("The student with the age " + ages[i] + " cannot vote.");
            }
        }
        input.close();
    }
}
