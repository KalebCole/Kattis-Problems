// This is a complement's rule proble
// to find a substring all substrings of 2 in 1000000
// you would calculate the number of total ints (1 million) and subtract the
// cases where there are not any 0's
// 1 million - 9*9*9*9*9*9 (9^6)



/**
 * For 32 in 10000000
 * 1. Count how many do not have a 3 or a 2
 * 2. Count how many have 3 in the first spot (can't have 2 in next spot), 3 in second spot (can't have 2 in next spot), ...
 * 3. Count how many have 2 in the first spot, have 2 in the second spot (can't have it in the first spot), ....
 */
/**
 * PowersOf2
 */
public class PowersOf2 {

    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        int total = sc.getInt();
        int e = sc.getInt();

        // calculate the amount of numbers that do not have 2^e in it
        int other = calculateComplement(total, e);

        // total - other
        System.out.println(total - other);
    }

    private static int calculateComplement(int total, int exponent) {
        int number = 0;
        int len = ("" + Math.pow(2, exponent)).length();

        return number;
    }
}
