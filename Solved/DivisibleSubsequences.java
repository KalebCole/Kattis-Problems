//Algorithms: Prefix sum/cumulative function + modular artithemetic
// you can use a prefix sum and hashing to solve this problem in O(n) time complexity.
// This approach works because if the prefix sum up to two indices, i and j, have the same modulus when divided by the divisor,
// then the sum of the elements between i + 1 and j is divisible by the divisor.

class DivisibileSubsequences {
    static Kattio sc = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = sc.getInt();
        for (int i = 0; i < cases; i++) {
            int divisor = sc.getInt(), n = sc.getInt();
            // padding the array by 1 so that we don't get into an Out of bounds error in
            // the prefix sum array portion
            int[] subsequence = makeModPrefixSumArray(divisor, n);
            int count = getNumOfSubsequences(divisor, subsequence);
            System.out.println(count);
        }
    }

    /*
     * You initialize this with the mod value of 0 having a count of 1. This step
     * acknowledges the base case where the sum of the subsequence is 0, which is
     * inherently divisible by d
     * 
     */
    private static int getNumOfSubsequences(int divisor, int[] subsequence) {
        int[] countArrForPairsOfMods = new int[divisor];
        countArrForPairsOfMods[0] = 1;
        int totalCounter = 0;
        for (int i = 1; i < subsequence.length; i++) {
            countArrForPairsOfMods[subsequence[i]] += 1;
        }

        for (int i = 0; i < countArrForPairsOfMods.length; i++) {
            totalCounter += (countArrForPairsOfMods[i] * (countArrForPairsOfMods[i] - 1)) / 2;
        }
        return totalCounter;
    }

    private static int[] makeModPrefixSumArray(int divisor, int n) {
        int[] array = new int[n + 1];
        // we only care about the modulus so i can do this in one shot
        // if i add the numbers and not the modulus it will go out of bounds for
        // integers
        for (int i = 1; i < n + 1; i++) {
            array[i] = (sc.getInt() + array[i - 1]) % divisor;
        }
        return array;
    }

    /*
     * O(n^2) approach that ran into a TLE error
     */
    // public static void main(String[] args) {
    // int cases = sc.getInt();
    // for (int i = 0; i < cases; i++) {
    // int divisor = sc.getInt(), n = sc.getInt();
    // int[] subsequence = new int[n];
    // for (int j = 0; j < n; j++) {
    // subsequence[j] = sc.getInt();
    // }
    // int count = getNumOfSubsequences(divisor, subsequence);
    // System.out.println(count);
    // }
    // }

    // // O(n^2)
    // private static int getNumOfSubsequences(int divisor, int[] subsequence) {
    // int sum = 0, counter = 0;
    // for (int start = 0; start < subsequence.length; start++) {
    // sum = subsequence[start];
    // // individual case
    // if (sum % divisor == 0) {
    // counter++;
    // }
    // for (int end = start + 1; end < subsequence.length; end++) {
    // sum += subsequence[end];
    // if (sum % divisor == 0) {
    // counter++;
    // }
    // }
    // }
    // return counter;
    // }
}