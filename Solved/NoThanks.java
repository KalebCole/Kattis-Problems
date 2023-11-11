import java.util.Scanner;
import java.util.TreeSet;

public class NoThanks {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        
        int sum = getSum(set);
        System.out.println(sum);

    }
    private static int getSum(TreeSet<Integer> set) {
        int prev = -1, sum = 0;
        for (Integer num : set) {
            if(num != prev+1) {
                sum += num;
            }
            prev = num;
        }
        return sum;
    }

}
