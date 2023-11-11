/**
 * 
 * Rewrite this and use a map to store the stickers collected
 */
// array problem

// look at indicies of the prizes and find the minimum # from the stickers required - multiply that by the prize total

import java.util.Scanner;

public class FastFoodPrizes {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int cases = sc.nextInt();
        int prizes, stickers;
        int[] stickersCollected;
        int[] prizesArr;
        int[] prizeTotals;
        // total amount won from all the stickers
        
        for (int i = 0; i < cases; i++) {
            int totalWon = 0;
            prizes = sc.nextInt(); stickers = sc.nextInt();
            
            prizesArr = new int[prizes];
            prizeTotals = new int[prizes];
            for (int j = 0; j < prizes; j++) {
            // now that we have this, we know the sequence of numbers required for the prize
                prizesArr[j] = sc.nextInt();
                for (int j2 = 0; j2 < prizesArr[j]; j2++) {
                    sc.nextInt();
                }
                prizeTotals[j] = sc.nextInt();
            }

            // get the total # of stickers collected
            stickersCollected = new int[stickers]; 
            for (int k = 0; k < stickers; k++) {
                stickersCollected[k] = sc.nextInt();
            }
            // check from the range of 0 - prizesArr[0], prizesArr[0] - prizesArr[1]
            int min, low = 0;
            for (int j = 0; j < prizesArr.length; j++) {
                if (j==0) min = findMinimum(stickersCollected, 0,prizesArr[0]);
                else min = findMinimum(stickersCollected, low, low+prizesArr[j]);
                low += prizesArr[j];
                totalWon += prizeTotals[j] * min;
            } 
        System.out.println(totalWon);
        }

    }

    private static int findMinimum(int[] stickersCollected, int low, int high) {
        int min = stickersCollected[low];
        for (int i = low; i < high; i++) {
            if (min > stickersCollected[i]) min = stickersCollected[i];
        }
        return min;
    }
}
