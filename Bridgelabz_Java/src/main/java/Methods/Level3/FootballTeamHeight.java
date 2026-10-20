package Methods.Level3;

/*
 * Generates random heights for 11 football players
 * and calculates their total, mean, shortest, and tallest heights.
 */

public class FootballTeamHeight {

    // Generates random heights between 150 cm and 250 cm.
    public static int[] generateHeights() {
        int[] heights = new int[11];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;
        }

        return heights;
    }

    // Calculates the sum of all player heights.
    public static int findSum(int[] heights) {
        int sum = 0;

        for (int height : heights) {
            sum += height;
        }

        return sum;
    }

    // Calculates the mean height of the players.
    public static double findMean(int[] heights) {
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }

    // Finds the shortest player height.
    public static int findShortest(int[] heights) {
        int shortest = heights[0];

        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }

        return shortest;
    }

    // Finds the tallest player height.
    public static int findTallest(int[] heights) {
        int tallest = heights[0];

        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }

        return tallest;
    }

    public static void main(String[] args) {

        // Generate heights for 11 football players.
        int[] heights = generateHeights();

        // Display the heights of all players.
        System.out.println("Heights of 11 football players:");

        for (int i = 0; i < heights.length; i++) {
            System.out.println("Player " + (i + 1) + ": "
                    + heights[i] + " cm");
        }

        // Calculate and display the results.
        System.out.println("\nTotal height: " + findSum(heights) + " cm");
        System.out.printf("Mean height: %.2f cm%n", findMean(heights));
        System.out.println("Shortest height: " + findShortest(heights) + " cm");
        System.out.println("Tallest height: " + findTallest(heights) + " cm");
    }
}