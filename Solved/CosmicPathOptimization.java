import java.util.Scanner;
public class CosmicPathOptimization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += sc.nextInt();
        }
        System.out.println((int)Math.floor(temp/n));
    }
}
