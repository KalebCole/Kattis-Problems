import java.util.Scanner;

public class Monopoly {
    public static void main(String[] args) {
        double[] probArr = new double[] { 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1 }; // based on hard coded probabilities
        Scanner sc = new Scanner(System.in);

        double prob = 0;
        int n = sc.nextInt();
        int temp;
        for (int i = 0; i < n; i++) {
            temp = sc.nextInt();
            prob += (probArr[temp - 2] / 36);
        }
        System.out.println(prob);
    }
}
