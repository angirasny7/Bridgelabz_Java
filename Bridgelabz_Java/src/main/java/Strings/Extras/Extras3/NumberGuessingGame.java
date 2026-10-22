
package Strings.Extras.Extras3;

import java.util.Random;
import java.util.Scanner;

/*
 * Problem:
 * The user thinks of a number between 1 and 100.
 * The computer generates random guesses.
 * The user provides feedback:
 * H - Guess is too high
 * L - Guess is too low
 * C - Guess is correct
 *
 * Use separate methods to generate guesses,
 * receive feedback, and determine the next guess.
 */

public class NumberGuessingGame {

    // Generate a random number within the given range
    public static int generateGuess(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    // Receive feedback from the user
    public static char receiveFeedback(Scanner sc, int guess) {
        System.out.println("Computer's guess: " + guess);
        System.out.print("Enter H (too high), L (too low), "
                + "or C (correct): ");

        return sc.next().toUpperCase().charAt(0);
    }

    // Determine the next guess based on feedback
    public static int determineNextGuess(
            int guess, char feedback, int[] range) {

        if (feedback == 'H') {
            range[1] = guess - 1;
        } else if (feedback == 'L') {
            range[0] = guess + 1;
        }

        return generateGuess(range[0], range[1]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Initial guessing range: 1 to 100
        int[] range = {1, 100};

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("The computer will try to guess it.");

        int guess = generateGuess(range[0], range[1]);

        while (true) {

            char feedback = receiveFeedback(sc, guess);

            if (feedback == 'C') {
                System.out.println("Correct! The computer guessed your number.");
                break;
            }

            if (feedback != 'H' && feedback != 'L') {
                System.out.println("Invalid input! Enter H, L, or C.");
                continue;
            }

            // Update the possible range
            if (feedback == 'H') {
                range[1] = guess - 1;
            } else {
                range[0] = guess + 1;
            }

            // Check whether the feedback is consistent
            if (range[0] > range[1]) {
                System.out.println(
                        "Inconsistent feedback! No possible number remains.");
                break;
            }

            // Generate the next guess
            guess = determineNextGuess(guess, feedback, range);
        }

        sc.close();
    }
}
