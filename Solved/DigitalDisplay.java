import java.util.Scanner;

public class DigitalDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("end")) {
                System.out.print("end\n");
                return;
            }
            Clock clock = new Clock(line);
            System.out.println(clock);
            System.out.print("\n");
        }
        sc.close();
    }

}

class Clock {
    int[] digits;

    public Clock(String time) {
        this.digits = new int[4];
        time = time.replace(":", ""); // Remove the colon
        for (int i = 0; i < time.length(); i++) {
            this.digits[i] = Character.getNumericValue(time.charAt(i)); // Convert each character to an integer
        }
    }

    public String convertToDigital() {
        StringBuilder sb = new StringBuilder();

        // simulating the columns
        for (int i = 1; i <= 7; i++) {
            // simulating the rows
            for (int j = 0; j < this.digits.length; j++) {
                sb.append(digitalRepresentationByLine(this.digits[j], i, j));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private String digitalRepresentationByLine(int digit, int level, int placement) {
        StringBuilder sb = new StringBuilder();
        // need to add space based on the level
        switch (level) {
            case 1:
                handleCaseOne(digit, sb);
                appendSpace(level, placement, sb);
                break;
            case 2:
            case 3:
                handleCaseTwoAndThree(digit, sb);
                appendSpace(level, placement, sb);
                break;
            case 4:
                handleCaseFour(digit, sb);
                appendSpace(level, placement, sb);
                break;
            case 5:
                handleCaseFive(digit, sb);
                appendSpace(level, placement, sb);
                break;
            case 6:
                handleCaseSix(digit, sb);
                appendSpace(level, placement, sb);
                break;
            case 7:
                handleCaseSeven(digit, sb);
                appendSpace(level, placement, sb);
                break;
            default:
                break;
        }
        return sb.toString();
    }

    private void handleCaseSeven(int digit, StringBuilder sb) {
        switch (digit) {
            case 1:
            case 4:
            case 7:
                sb.append("    +");
                break;
            case 2:
            case 0:
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
                sb.append("+---+");
                break;
            default:
                break;
        }
    }

    private void handleCaseSix(int digit, StringBuilder sb) {
        switch (digit) {
            case 0:
            case 6:
            case 8:
                sb.append("|   |");
                break;
            case 1:
            case 3:
            case 4:
            case 5:
            case 7:
            case 9:
                sb.append("    |");
                break;
            case 2:
                sb.append("|    ");
                break;
            default:
                break;
        }
    }

    private void handleCaseFive(int digit, StringBuilder sb) {
        switch (digit) {
            case 0:
            case 6:
            case 8:
                sb.append("|   |");
                break;
            case 1:
            case 3:
            case 4:
            case 5:
            case 7:
            case 9:
                sb.append("    |");
                break;
            case 2:
                sb.append("|    ");
                break;
            default:
                break;
        }
    }

    private void handleCaseFour(int digit, StringBuilder sb) {
        switch (digit) {
            case 0:
                sb.append("+   +");
                break;
            case 1:
            case 7:
                sb.append("    +");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
                sb.append("+---+");
                break;
            default:
                break;
        }
    }

    private void handleCaseTwoAndThree(int digit, StringBuilder sb) {
        switch (digit) {
            case 1:
            case 2:
            case 3:
            case 7:
                sb.append("    |");
                break;
            case 0:
            case 4:
            case 8:
            case 9:
                sb.append("|   |");
                break;
            case 5:
            case 6:
                sb.append("|    ");
            default:
                break;
        }
    }

    private void handleCaseOne(int digit, StringBuilder sb) {
        switch (digit) {
            case 1:
                sb.append("    +");
                break;
            case 0:
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                sb.append("+---+");
                break;
            case 4:
                sb.append("+   +");
                break;
            default:
                break;
        }
    }

    private void appendSpace(int level, int placement, StringBuilder sb) {
        // last digit, do not append space
        if (placement == 3) {
            return;
        } else if ((level == 3 || level == 5) && placement == 1) {
            sb.append("  o  ");
        } else if (placement == 1) {
            sb.append(" ".repeat(5));
        } else {
            sb.append(" ".repeat(2));
        }
    }

    @Override
    public String toString() {
        return convertToDigital();
    }
}
