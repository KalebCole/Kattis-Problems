public class AntiPalindrome {
    static Kattio sc = new Kattio(System.in);

    public static void main(String[] args) throws Exception {
        String[] line = sc.getLine().toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length; i++) {
            // remove the non-alphabet
            for (int j = 0; j < line[i].length(); j++) {
                if (Character.isAlphabetic(line[i].charAt(j)))
                    sb.append(line[i].charAt(j));
            }
        }
        boolean isAPalindrome = false;
        for (int i = 0; i < sb.length(); i++) {
            if (isAPalindrome)
                break;
            for (int j = i + 1; j <= sb.length(); j++) {
                if (j - i == 1)
                    continue;
                if (isPalindrome(sb.substring(i, j))) {
                    isAPalindrome = true;
                    break;
                }
            }
        }
        if (isAPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Anti-Palindrome");
        }
    }

    private static boolean isPalindrome(String substring) {
        for (int i = 0, j = substring.length() - 1; i < j; i++, j--) {
            if (substring.charAt(i) != substring.charAt(j))
                return false;
        }
        return true;
    }
}
