package Arrays.Level1;
import java.util.Scanner;

/*
 * Calculates the mean height of 11 football players.
 */
public class MeanHeight {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // Create an array to store the heights of 11 players
        double[] heights = new double[11];

        // Accept the height of each player
        for(int i = 0 ; i<heights.length; i++){
            System.out.printf("Enter the height of player %d : " , (i+1));
            heights[i] =  input.nextDouble();
        }
        // Calculate the sum of all player heights
        double heightSum = 0.0;
        for(int i = 0; i< 11; i++){
            heightSum += heights[i];

        }
        // Calculate the mean height by dividing the sum by the number of players
        double meanHeight = heightSum / 11;
        System.out.println("Mean height of football team : " + meanHeight);

        input.close();
    }
}
