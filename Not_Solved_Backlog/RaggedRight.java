import java.util.ArrayList;
import java.util.Scanner;

public class RaggedRight {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        int sum = 0;
        
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Get input
        while (scanner.hasNext()) {
            String sentence = scanner.nextLine();
            words.add(sentence);
        }

        // Find max length
        int max = -1;
        for (String word : words) {
            if (word.length() > max) {
                max = word.length();
            }
        }

        // Add up the points
        for (int i = 0; i < words.size() - 1; i++) {
            String word = words.get(i);
            sum += Math.pow(max - word.length(), 2);
        }

        System.out.println(sum);
    }
}

