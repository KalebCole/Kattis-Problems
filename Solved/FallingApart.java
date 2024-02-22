import java.util.Arrays;

public class FallingApart {
    static Kattio sc = new Kattio(System.in);

    public static void main(String[] args) {
        int n = sc.getInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.getInt();
        }
        Arrays.sort(nums);
        int alice = 0, bob = 0;
        boolean isAlice = true;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (isAlice) {
                alice += nums[i];
                isAlice = !isAlice;
            } else {
                bob += nums[i];
                isAlice = !isAlice;
            }
        }

        System.out.print(alice + " " + bob);
    }
}
