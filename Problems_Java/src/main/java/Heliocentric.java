import java.util.Scanner;

public class Heliocentric {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = 1;
        while(sc.hasNext()){
            int e = sc.nextInt(), m = sc.nextInt();
            long result = getDaysUntilDayZero(e, m);
            System.out.printf("Case %d: %d",i,result);
            i++;
        }
    }

    private static long getDaysUntilDayZero(int e, int m) {
        if(e%365 == m % 687) return e%365;

        long total = 0;
        while(e%365 != m % 687){
            if(m + (365-e) < 687){
                total += m + (365-e);
                m += (365-e);
            }
            else if(e + (687-m) < 365){
                total += e + (687-m);
                e += (687-m);
            }
        }
        
        return total;
    }
}
