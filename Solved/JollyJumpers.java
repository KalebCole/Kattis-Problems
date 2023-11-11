import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JollyJumpers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] line = sc.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int[] nums = new int[n];
            for (int i = 1; i < line.length; i++) {
                nums[i-1] = Integer.parseInt(line[i]);
            }
            if(isJolly(n, nums)) System.out.println("Jolly");
            else System.out.println("Not jolly");
        }
    }

    public static boolean isJolly(int n, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            set.add(i);
        }
        int diff = 0;
        for (int i = 1; i < nums.length; i++) {
            diff = Math.abs(nums[i]-nums[i-1]); 
            // already found in set
            if(!set.contains(diff)) return false;
            set.remove(diff);
        }

        if(set.size() == 0) return true;
        return false;
    }
}
