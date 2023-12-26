import java.util.Scanner;

public class Peragrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(peragrams(s));
    }

    public static int peragrams(String word) {
        int totalToSubtract = 0;
        int[] countArr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            countArr[word.charAt(i) - 97]++; // add character count to position in array
        }

        int oddNumberFlag = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] % 2 == 1) {
                oddNumberFlag++;
            }
            if (oddNumberFlag > 1) {
                totalToSubtract++;
                oddNumberFlag--;
            }

        }

        return totalToSubtract;
    }
}
