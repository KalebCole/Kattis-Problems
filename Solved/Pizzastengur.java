import java.util.Scanner;

public class Pizzastengur {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner sc = new Scanner(System.in);

        // Read the target word length from input
        int targetWordLength = sc.nextInt();

        // Initialize a StringBuilder to build the target word
        StringBuilder targetWord = new StringBuilder(targetWordLength);

        // Define the possible characters to guess
        char[] guess = new char[] { 'P', 'I', 'Z', 'A' };

        // Initialize variables to keep track of the guessing process
        int feedback = -1;
        int randomGuess = 0;
        int guessCounter = 0;
        boolean[] hasGuessed = new boolean[4]; // this is to check that we have guessed 3 of 4

        // Start a loop to guess characters until the target word is found
        do {
            // Generate a random index to guess a character
            randomGuess = (int) (Math.random() * 4);

            // If this character has already been guessed, skip this iteration
            if (hasGuessed[randomGuess]) {
                continue;
            }

            // If we have guessed 3 characters without success, guess the remaining one
            if (guessCounter == 3) {
                for (int i = 0; i < hasGuessed.length; i++) {
                    if (!hasGuessed[i]) {
                        targetWord.append(guess[i]);
                        break;
                    }
                }

                // Reset the guesses
                for (int i = 0; i < hasGuessed.length; i++) {
                    hasGuessed[i] = false;
                }
                guessCounter = 0;
                continue;
            }

            // Send the guess to the program
            sendGuessToProgram(targetWord, guess[randomGuess]);

            // Mark this character as guessed
            hasGuessed[randomGuess] = true;
            guessCounter++;

            // Get the feedback from the program
            feedback = sc.nextInt();

            // If the feedback is positive, append the guessed character to the target word
            if (feedback == 1) {
                targetWord.append(guess[randomGuess]);

                // Reset the guesses
                for (int i = 0; i < hasGuessed.length; i++) {
                    hasGuessed[i] = false;
                }
                guessCounter = 0;
            }
        } while (feedback != 2 && targetWord.length() < targetWordLength);

        // If the target word is found, send it to the program
        if (targetWord.length() == targetWordLength && feedback != 2) {
            sendGuessToProgram(targetWord);
        }

        // Close the Scanner
        sc.close();
    }

    // Method to send the current target word to the program
    public static void sendGuessToProgram(StringBuilder targetWord) {
        System.out.println(targetWord);
        System.out.flush(); // we have to flush the buffer so that the other person can read it
    }

    // Method to send a guess to the program
    public static void sendGuessToProgram(StringBuilder targetWord, char guess) {
        System.out.println(targetWord + "" + guess);
        System.out.flush(); // we have to flush the buffer so that the other person can read it
    }
}