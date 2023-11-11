import java.util.Scanner;

public class Cokolada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        double log = Math.log(k) / Math.log(2);
        int n = (int) Math.pow(2, Math.ceil(log));
        if(Math.ceil(log) == log){
            System.out.println(n + " " + 0);
            return;
        }
        // determine breaks
        int count = 0;
        int temp = n;
        while (k > 0) {
            if (k >= temp / 2) {
                k -= temp / 2;
            }
            temp = temp / 2;
            count++;
        }
        System.out.println(n + " " + count);

    }
}
