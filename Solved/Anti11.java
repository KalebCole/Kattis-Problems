import java.util.Scanner;

public class Anti11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int test;

        for (int i = 0; i < n; i++) {
            test = sc.nextInt();
            int[] caseZero = new int[test]; 
            int[] caseOne = new int[test]; 
            caseZero[0] = 1;
            caseOne[0] = 1;
            for (int j = 1; j < test; j++) {
                caseZero[j] = (int)((int)((int)(caseZero[j-1] % (Math.pow(10,9)+7)) + (int)(caseOne[j-1] % (Math.pow(10,9)+7))) % (Math.pow(10,9)+7)); 
                caseOne[j] = (int)(caseZero[j-1] % (Math.pow(10,9)+7));
            }
            int answer = (int)((caseOne[test-1] + caseZero[test-1]) % (Math.pow(10,9)+7));
            System.out.println(answer);

        }

    }


    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt(); int test;
    //     for (int i = 0; i < n; i++) {
    //         test = sc.nextInt();
    //         int sum = 0;
    //         sum += caseOne(test) + caseZero(test);
    //         System.out.println(sum % (10^9+7));
    //     }
    // }

    // /**
    //  * For the case where the binary string starts with a 1
    //  * @param n length of the binary string
    //  * @return
    //  */
    // public static int caseOne(int n) {
    //     if(n == 1) return 1;
    //     return caseZero(n-1);
    // }

    // /**
    //  * For the case where the binary string starts with a 0
    //  * @param n length of the binary string
    //  * @return
    //  */
    // public static int caseZero(int n) {
    //     if(n == 1) return 1;
    //     return caseOne(n-1) + caseZero(n-1);
    // }
}
