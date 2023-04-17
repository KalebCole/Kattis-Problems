import java.util.Scanner;

/*
 * Modular math - (a*b)modd (amodd*bmodd)modd
 * 12345 = 1234 * 10 + 5
 * 123456789101112 = 1234567891011 * 100 + 12
 * When you get to 3 digit numbers = * 1000 + x
 * 4 digits = * 10000 + x
 */

class ChampernowneCount{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int k = sc.nextInt();
        if(k == 1){
            System.out.println(size);
            return;
        }
        long curr = 1; long rem = 1; int count = 0; int exp = 1;
        for (int i = 2; i <= size; i++) {
            exp = (""+i).length();
            //get remainder, and add i
            //if divisible by k, count++
            //as i increases digits, increase power of 10 
            curr = rem * (int)Math.pow(10,exp) + i;
            if(curr%k==0) count++;
            rem = curr%k;
        }
        System.out.println(count);
    }
}