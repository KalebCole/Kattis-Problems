import java.util.Scanner;

public class QuiteAProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            boolean hasWord = hasProblemSubstringInLine(sc.nextLine());
            if (hasWord)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    private static boolean hasProblemSubstringInLine(String line) {
        if(line.toLowerCase().contains("problem")) return true;
        return false;
    }
}
