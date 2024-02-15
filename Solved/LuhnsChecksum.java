// check if a credit card number is valid using Luhn's algorithm
// look out for where it starts

import java.util.Scanner;

public class LuhnsChecksum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (checksumAlgorithm(sc.next()) == 0)
                System.out.println("PASS");
            else
                System.out.println("FAIL");
        }
    }

    public static int checksumAlgorithm(String digits) {
        int sum = 0;
        int digit;
        // read carefully where to start from
        for (int i = digits.length() - 1; i >= 0; i -= 1) {
            // length is odd, i must be even to manipulate
            // length is even, i must be odd
            if (digits.length() % 2 == 1 && i % 2 == 0 || digits.length() % 2 == 0 && i % 2 == 1) {
                sum += Integer.parseInt("" + digits.charAt(i));
                continue;
            }
            // now we're at every second digit
            digit = Integer.parseInt("" + digits.charAt(i));
            digit *= 2;
            if (digit >= 10) {
                sum += digit % 10 + digit / 10;
            } else {
                sum += digit;
            }
        }
        if (sum % 10 == 0)
            return 0;
        return -1;
    }

}
