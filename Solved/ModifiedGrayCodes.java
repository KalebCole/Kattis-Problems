/**
 * This program generates the even Gray Code sequence for a given index.
 * The even Gray Code sequence is a modified version of the Gray Code sequence,
 * where successive elements differ by an even number of bits.
 * The program takes the number of queries as input, followed by the indices of
 * the even Gray Code elements to be generated.
 * For each query, the program calculates the even Gray Code element at the
 * given index and prints its 10-bit representation.
 * The program uses the concept of XOR and bit manipulation to generate the even
 * Gray Code sequence.
 * It maintains an array to keep track of the elements that have already been
 * found.
 * The program iterates through the sample space and checks if an element
 * satisfies the conditions for an even Gray Code.
 * If the conditions are met, the element is marked as found and the process
 * continues until the desired index is reached.
 * The program also includes helper methods to calculate the number of ones in a
 * binary representation and to convert a decimal number to its 10-bit binary
 * representation.
 */
public class ModifiedGrayCodes {
    static Kattio sc = new Kattio(System.in);
    static int[] sampleSpace = new int[1024]; // because 2^10

    public static void main(String[] args) {
        // Initialize the sample space
        for (int i = 0; i < sampleSpace.length; i++) {
            sampleSpace[i] = i;
        }

        // Read the number of queries
        int n = sc.getInt();

        // Process each query
        for (int i = 0; i < n; i++) {
            // Read the query index
            int query = sc.getInt();

            // Search for the even Gray Code element at the given index
            String binaryString = searchForGrayCodes(query);

            // Print the 10-bit representation of the even Gray Code element
            System.out.println(binaryString);
        }
    }

    /**
     * Searches for the even Gray Code element at the given index.
     * 
     * @param query The index of the even Gray Code element to be found.
     * @return The 10-bit representation of the even Gray Code element.
     */
    private static String searchForGrayCodes(int query) {
        boolean[] hasBeenFound = new boolean[1024];
        hasBeenFound[0] = true;
        int prev = 0, counterForQuery = 0, change = 0, curr;
        for (curr = 0; curr < sampleSpace.length; curr++) {
            if (hasBeenFound[curr])
                continue;
            change = prev ^ curr; // calculate the XOR
            int numOfOnesInChange = calculateNumOfOnesInChange(change);
            if (numOfOnesInChange % 2 == 0) {
                counterForQuery++;
                hasBeenFound[curr] = true;
                prev = curr;
            }
            if (counterForQuery == query) {
                break;
            }
        }
        return getTenDigitRepresentation(curr); // using curr because this is the last case
    }

    /**
     * Returns the 10-bit representation of the given decimal number.
     * 
     * @param grayCode The decimal number to be converted to its 10-bit binary
     *                 representation.
     * @return The 10-bit binary representation of the given decimal number.
     */
    private static String getTenDigitRepresentation(int grayCode) {
        StringBuilder sb = new StringBuilder();
        while (grayCode > 0) {
            sb.insert(0, grayCode % 2);
            grayCode = grayCode >> 1;
        }
        // add padding
        while (sb.length() < 10) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }

    /**
     * Calculates the number of ones in the binary representation of the given
     * decimal number.
     * 
     * @param change The decimal number for which the number of ones in its binary
     *               representation is to be calculated.
     * @return The number of ones in the binary representation of the given decimal
     *         number.
     */
    private static int calculateNumOfOnesInChange(int change) {
        int sum = 0;
        while (change > 0) {
            sum += change % 2;
            change = change >> 1;
        }
        return sum;
    }
}
