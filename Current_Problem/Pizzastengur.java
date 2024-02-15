import java.util.Scanner;

public class Pizzastengur {
    public static void main(String[] args) {
        // try the 4 combinations at each step and progressively build a string
        // (StringBuilder)

        // 3n + 1 = guess P,I,Z, then we know it is A and the next guess is AP
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        StringBuilder targetWord = new StringBuilder(length);

        char[] guess = new char[] { 'P', 'I', 'Z', 'A' };
        // make a guess or request to the program
        for (int i = 0; i < guess.length; i++) {
            sendGuessToProgram(targetWord, guess[i]);
            // get the response back from the program
            int feedback = Integer.parseInt(sc.nextLine());

            // correct guess
            if (feedback == 2) {
                break;
            }
            // correct substring
            else if (feedback == 1) {
                targetWord.append(guess[i]);
                i = 0;
            }
            // not correct guess, but 3rd to last guess, so choose the last one
            else if (i == 2) {
                targetWord.append(guess[i + 1]);
                i = 0;
            }
        }
        sc.close();
    }

    public static void sendGuessToProgram(StringBuilder targetWord, char guess) {
        // append the character to the targetWord in a print statment to the output
        System.out.println(targetWord + "" + guess);
        // flushing is for the other people to read
        System.out.flush();
    }
}
