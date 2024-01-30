// this is a first-order recursion --> has 1 initial value
// decimal representation = using the decimal number systems
//  (compare to the binary number system, which would have a lot more digits)

import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if(line.equals("END")) return;
            if(line.equals("1")) System.out.println(1);
            else System.out.println(digits(line.length(), 2));
        }
    }

    public static int digits(int num, int count) {
        // base case
        if (num == 1)
            return count;
        // recursive case
        count += 1;
        return digits(String.valueOf(num).length(), count);
    }
}
