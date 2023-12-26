import java.util.Scanner;

public class Heliocentric {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = 1;
        while(sc.hasNext()){
            int e = sc.nextInt(), m = sc.nextInt();
            long result = getDaysUntilDayZero(e, m);
            System.out.printf("Case %d: %d\n",i,result);
            i++;
        }
        sc.close();
    }

    private static long getDaysUntilDayZero(int e, int m) {
        if(e == 0 && m == 0) return 0;
        // get e to 0
        m = (m+(365-e))%687;
        long total = 365-e;
        e = 0;

        // repeatedly add 365 until they are both 0
        while(e != 0 || m != 0){
            m = (m + 365) % 687;
            total+=365;
        }
        
        return total;
    }
}
