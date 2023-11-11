import java.util.Scanner;

/**
 * Plank
 */
public class Plank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(plankTabulation(n))  ;
    }

    public static int plankTabulation(int n) {
        int[] table = new int[n+1];
        table[0] = 1;
        for (int i = 1; i < n+1; i++) {
            if(i-1 >= 0) table[i] += table[i-1];
            if(i-2 >= 0) table[i] += table[i-2];
            if(i-3 >= 0) table[i] += table[i-3];
        }
        return table[n];
    }
    
}
