import java.util.Scanner;

public class ChartingProgress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int indexOfStart = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("")) {
                // sc.nextLine(); // get the next empty line
                // print 2 lines
                System.out.println();
                System.out.println();
                indexOfStart = 0;
                continue;
            }
            int numOfAsterisks = countAsterisks(line);
            String print = printLine(indexOfStart, numOfAsterisks, line.length());
            System.out.println(print);
            indexOfStart += numOfAsterisks;
        }
    }

    private static String printLine(int indexOfStart, int numOfAsterisks, int lengthOfLine) {
        StringBuilder lineToPrint = new StringBuilder();

        if (numOfAsterisks == 0) {
            lineToPrint.append(".".repeat(lengthOfLine));
        } else {
            for (int i = 0; i < indexOfStart; i++) {
                lineToPrint.append(".");
            }
            // int asterisksToAdd = indexOfStart + "*".repeat(numOfAsterisks).length();

            lineToPrint.insert(0, "*".repeat(numOfAsterisks));
            while (lineToPrint.length() < lengthOfLine) {
                lineToPrint.insert(0, ".");
            }
        }
        return lineToPrint.toString();
    }

    private static int countAsterisks(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '*')
                count += 1;
        }
        return count;
    }
}
