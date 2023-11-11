import java.util.Scanner;

public class UllenDullenDoff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc. nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        if(13%n == 0) System.out.println(arr[n-1]);
        else System.out.println(arr[13%n-1]);
    }
}
