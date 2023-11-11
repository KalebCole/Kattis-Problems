import java.util.Scanner;

public class Zamka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt(), d = sc.nextInt(), x = sc.nextInt();

        int sum, max = 0, min = 0;
        boolean minFlag = false, maxFlag = false;
        for (int i = l, j = d; i <= d && j >= l; i++, j--) {
            if(minFlag && maxFlag) break;
            // for min number
            if(!minFlag){
                sum = getSumOfDigits(i);
                if(sum == x){
                    min = i;
                    minFlag = true;
                }
            }
            if(!maxFlag){
                // for max number
                sum = getSumOfDigits(j);
                if(sum == x){
                    max = j;
                    maxFlag = true;
                }
            }
        }
        System.out.println(min);
        System.out.println(max);
    }

    private static int getSumOfDigits(int num) {
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num = num / 10;
        }
        
        return sum;
    }
}
