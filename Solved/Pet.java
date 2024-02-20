import java.util.Scanner;

public class Pet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] contestants = new int[5];
        for (int i = 0; i < contestants.length; i++) {
            for (int j = 0; j < 4; j++) {
                contestants[i] += sc.nextInt();
            }
        }
        int maxScore = -1;
        int index = 0;
        for (int i = 0; i < contestants.length; i++) {
            if (contestants[i] > maxScore) {
                maxScore = contestants[i];
                index = i+1;
            }
        }

        System.out.printf("%d %d", index, maxScore);
    }
}
