import java.util.Scanner;

public class Kafkaesque {
    // pass through it once, if there is a problem between current and prev, add 1
    // n starts at 1 because you have to pass through
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), prev = 0, curr = 0, count = 1;
        for (int i = 0; i < n; i++) {
            if (i==0) prev = sc.nextInt();
            else{
                curr = sc.nextInt();
                if (prev > curr) count++;
                prev = curr;
            }
        }
        System.out.println(count);
    }
}
