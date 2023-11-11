import java.util.Arrays;
import java.util.Scanner;

public class MinimumScalarProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int n = sc.nextInt();
            long[] vector1 = new long[n];
            long[] vector2 = new long[n];
            for (int j = 0; j < n; j++) {
                vector1[j] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                vector2[j] = sc.nextInt();
            }

            System.out.printf("Case #%d: %d\n", i + 1, scalarProduct(vector1, vector2));
        }
    }

    public static long scalarProduct(long[] vector1, long[] vector2) {
        Arrays.sort(vector1);
        Arrays.sort(vector2);
        long total = 0;
        for (int i = 0, j = vector2.length - 1; i < vector2.length && j >= 0; i++, j--) {
            total += (vector1[i] * vector2[j]);
        }
        return total;
    }
}
