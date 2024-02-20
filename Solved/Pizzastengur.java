import java.util.Scanner;

public class Pizzastengur {
    public static void main(String[] args) {
        // try the 4 combinations at each step and progressively build a string
        // (StringBuilder)

        // 3n + 1 = guess P,I,Z, then we know it is A and the next guess is AP
        Scanner sc = new Scanner(System.in);
        int targetWordLength = sc.nextInt();
        StringBuilder targetWord = new StringBuilder(targetWordLength);

        char[] guess = new char[] { 'P', 'I', 'Z', 'A' };
        // make a guess or request to the program
        // write a while loop --> updating for loop counter is not smart
        // until we get a 2
        // do while loop
        // use modulus and
        int feedback = -1;
        int guessCounter = 0;
        do {
            sendGuessToProgram(targetWord, guess[guessCounter]);
            // get the response back from the program
            feedback = sc.nextInt();
            if (feedback == 1) {
                targetWord.append(guess[guessCounter]);
                guessCounter = 0;
                continue;
            } else if (guessCounter == 2) {
                targetWord.append(guess[++guessCounter]);
                guessCounter = 0;
                continue;
            }
            // keep this from going out of bounds
            guessCounter++;
            guessCounter %= 4;
        } while (feedback != 2 && targetWord.length() < targetWordLength);
        if (targetWord.length() == targetWordLength && feedback != 2) {
            sendGuessToProgram(targetWord);
        }
        sc.close();
    }

    public static void sendGuessToProgram(StringBuilder targetWord) {
        // append the character to the targetWord in a print statment to the output
        System.out.println(targetWord);
        // flushing is for the other people to read
        System.out.flush();
    }

    public static void sendGuessToProgram(StringBuilder targetWord, char guess) {
        // append the character to the targetWord in a print statment to the output
        System.out.println(targetWord + "" + guess);
        // flushing is for the other people to read
        System.out.flush();
    }
}
