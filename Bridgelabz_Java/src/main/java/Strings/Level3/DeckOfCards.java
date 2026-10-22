
package Strings.Level3;

import java.util.Scanner;

/*
 * Problem:
 * Create a deck of cards, initialize and shuffle it,
 * distribute n cards to x players, and print each
 * player's cards.
 */

public class DeckOfCards {

    static String[] suits = {
            "Hearts", "Diamonds", "Clubs", "Spades"
    };

    static String[] ranks = {
            "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Jack", "Queen", "King", "Ace"
    };

    // Method to initialize the deck
    public static String[] initializeDeck() {

        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }

        return deck;
    }

    // Method to shuffle the deck
    public static String[] shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {

            int randomCardNumber =
                    i + (int) (Math.random() * (n - i));

            // Swap the current card with the random card
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }

    // Method to distribute cards among players
    public static String[][] distributeCards(
            String[] deck, int n, int x) {

        // Check whether the cards can be distributed equally
        if (n <= 0 || x <= 0 || n > deck.length || n % x != 0) {
            return null;
        }

        int cardsPerPlayer = n / x;

        // Each row represents one player
        String[][] players = new String[x][cardsPerPlayer];

        int cardIndex = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }

        return players;
    }

    // Method to print each player's cards
    public static void printPlayers(String[][] players) {

        for (int i = 0; i < players.length; i++) {

            System.out.println("\nPlayer " + (i + 1) + ":");

            for (int j = 0; j < players[i].length; j++) {
                System.out.println(players[i][j]);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Initialize and shuffle the deck
        String[] deck = initializeDeck();
        shuffleDeck(deck);

        // Take the number of cards and players
        System.out.print("Enter the number of cards to distribute: ");
        int n = sc.nextInt();

        System.out.print("Enter the number of players: ");
        int x = sc.nextInt();

        // Distribute cards
        String[][] players = distributeCards(deck, n, x);

        if (players == null) {
            System.out.println(
                    "Invalid input! Enter a positive number of cards "
                            + "not exceeding 52, and a positive number "
                            + "of players that divides the card count evenly.");
        } else {
            printPlayers(players);
        }

        sc.close();
    }
}
