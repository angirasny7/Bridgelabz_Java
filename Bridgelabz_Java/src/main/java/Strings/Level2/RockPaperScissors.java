package Strings.Level2;

import java.util.Scanner;

/*
 * Question:
 * Create a Rock-Paper-Scissors game between a user and a computer.
 * Display the result of every game, total wins, and winning percentages
 * in a tabular format.
 *
 * Rules:
 * Rock beats Scissors.
 * Paper beats Rock.
 * Scissors beats Paper.
 */

public class RockPaperScissors {

    // Method to generate the computer's choice
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);

        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    // Method to find the winner of a game
    public static String findWinner(String userChoice, String computerChoice) {

        if (userChoice.equals(computerChoice)) {
            return "Draw";
        }

        if (userChoice.equals("Rock") && computerChoice.equals("Scissors")
                || userChoice.equals("Paper") && computerChoice.equals("Rock")
                || userChoice.equals("Scissors") && computerChoice.equals("Paper")) {
            return "Player";
        }

        return "Computer";
    }

    // Method to calculate wins and winning percentages
    public static String[][] calculateStatistics(
            String[][] gameResults, int totalGames,
            int playerWins, int computerWins, int draws) {

        String[][] statistics = new String[3][2];

        double playerPercentage = (playerWins * 100.0) / totalGames;
        double computerPercentage = (computerWins * 100.0) / totalGames;

        statistics[0][0] = "Player";
        statistics[0][1] = String.format("%.2f%%", playerPercentage);

        statistics[1][0] = "Computer";
        statistics[1][1] = String.format("%.2f%%", computerPercentage);

        statistics[2][0] = "Draws";
        statistics[2][1] = String.valueOf(draws);

        return statistics;
    }

    // Method to display game results and statistics
    public static void displayResults(
            String[][] gameResults, String[][] statistics,
            int playerWins, int computerWins, int draws) {

        System.out.println("\n========== GAME RESULTS ==========");

        System.out.printf("%-10s %-15s %-15s %-15s%n",
                "Game", "Player Choice", "Computer Choice", "Winner");

        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < gameResults.length; i++) {
            System.out.printf("%-10s %-15s %-15s %-15s%n",
                    i + 1,
                    gameResults[i][0],
                    gameResults[i][1],
                    gameResults[i][2]);
        }

        System.out.println("\n========== FINAL STATISTICS ==========");

        System.out.printf("%-15s %-15s %-15s%n",
                "Participant", "Total Wins", "Win Percentage");

        System.out.println("---------------------------------------------");

        System.out.printf("%-15s %-15d %-15s%n",
                "Player", playerWins, statistics[0][1]);

        System.out.printf("%-15s %-15d %-15s%n",
                "Computer", computerWins, statistics[1][1]);

        System.out.printf("%-15s %-15d%n", "Draws", draws);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of games: ");
        int totalGames = sc.nextInt();

        if (totalGames <= 0) {
            System.out.println("Please enter a positive number of games.");
            sc.close();
            return;
        }

        String[][] gameResults = new String[totalGames][3];

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int i = 0; i < totalGames; i++) {

            System.out.println("\nGame " + (i + 1));
            System.out.println("Enter your choice: Rock, Paper, or Scissors");

            String userChoice = sc.next();

            // Validate the player's choice
            if (!userChoice.equalsIgnoreCase("Rock")
                    && !userChoice.equalsIgnoreCase("Paper")
                    && !userChoice.equalsIgnoreCase("Scissors")) {

                System.out.println("Invalid choice! Please enter Rock, Paper, or Scissors.");
                i--;
                continue;
            }

            // Normalize the player's choice
            userChoice = userChoice.substring(0, 1).toUpperCase()
                    + userChoice.substring(1).toLowerCase();

            String computerChoice = getComputerChoice();

            String winner = findWinner(userChoice, computerChoice);

            // Update the statistics
            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }

            // Store the result of each game
            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;

            System.out.println("Your choice: " + userChoice);
            System.out.println("Computer's choice: " + computerChoice);
            System.out.println("Winner: " + winner);
        }

        String[][] statistics = calculateStatistics(
                gameResults, totalGames, playerWins, computerWins, draws);

        displayResults(
                gameResults, statistics, playerWins, computerWins, draws);

        sc.close();
    }
}