import java.util.Scanner;

// Kadane's Algorithm

/*
 * 
 * 
 * public class MaxSumSubArray {
 
    public static void main(String[] args) {
 
        int[] arr = {30, -40, 20, 40};
 
        int sum = findMaxSum(arr);
        System.out.println("The maximum sum in the sub array is : " + sum);
    }
 
    private static int findMaxSum(int[] arr) {
        int sum = 0;
        int max = 0;
 
        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(sum + arr[i], arr[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
 */

public class RadioCommercials {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int commercials = sc.nextInt(), price = sc.nextInt();
        sc.nextLine();
        int[] prices = new int[commercials];

        for (int i = 0; i < prices.length; i++) {
        prices[i] = sc.nextInt() - price;
        }
        sc.close();

        int profit;
        profit = linearMaxSubArray(prices);
        // new int[] { -5, 14, -10, 9, -30 }
        // profit = maxSubArray(prices);
        System.out.println(profit);
    }

    public static int linearMaxSubArray(int[] arr) {
        int maxUpToK = 0;
        int globalMax = 0;
        int start = 0, end = 0;
        for (int k = 0; k < arr.length; k++) {
            // check if the current element is bigger than the current sum
            if (maxUpToK + arr[k] < arr[k]) {
                maxUpToK = arr[k];
                start = k;
                end = k;
            } else {
                maxUpToK += arr[k];
            }
            // check if current sum is greater than global max
            if (maxUpToK > globalMax) {
                globalMax = maxUpToK;
                end = k;
            }
        }
        return globalMax;
    }

    // helper method
    public static int maxSubArray(int[] arr) {
        return maxSubArray(arr, 0, arr.length / 2, arr.length / 2 + 1, arr.length - 1);
    }

    // O(nlogn)
    public static int maxSubArray(int[] arr, int a, int b, int c, int d) {
        return 0;
    }
}
