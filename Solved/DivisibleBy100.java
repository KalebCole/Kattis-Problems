public class DivisibleBy100 {
    static Kattio sc = new Kattio(System.in);

    public static void main(String[] args) {
        StringBuilder n = new StringBuilder(sc.getWord());
        StringBuilder m = new StringBuilder(sc.getWord());

        // < 1 case
        if (m.length() > n.length()) {
            int padding = m.length() - n.length() - 1;
            n.insert(0, "0".repeat(padding)); // this may be off by 1
            n.insert(0, "0.");
            getRidOfTrailingZerosWithDecimal(n);
        }
        // > 1 case
        else {
            int numOfZeroes = m.length() - 1; // do not account leading 1
            // going from the right to where the decimal point may be
            int indexOfNonZero = -1;
            // case this checks: 10000 / 10
            for (int i = n.length() - 1; i >= n.length() - 1 - numOfZeroes; i--) {
                if (n.charAt(i) != '0') {
                    indexOfNonZero = i;
                    break;
                }
            }
            // case: 9257.234
            if (indexOfNonZero != -1) {
                n.insert(n.length() - numOfZeroes, "."); // this may be off by 1
                getRidOfTrailingZerosWithDecimal(n);
            } else {
                // 1000 / 10
                n.delete(n.length() - numOfZeroes, n.length()); // there is no decimal
            }
        }
        System.out.println(n.toString());
    }

    // this only mattes when i have a decimal place
    private static void getRidOfTrailingZerosWithDecimal(StringBuilder n) {
        // find decimal place
        int decimalLocation = -1;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '.') {
                decimalLocation = i;
                break;
            }
        }

        // loop from the end to the decimal location to find first non-zero
        for (int i = n.length() - 1; i > decimalLocation; i--) {
            if (n.charAt(i) != '0') {
                n.delete(i + 1, n.length());
                break;
            }
        }

    }
}