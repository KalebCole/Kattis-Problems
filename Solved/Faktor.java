import java.util.*;
public class Faktor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); int a = sc.nextInt(); double i = (sc.nextInt()-.99);
        int scientists = (int)(Math.ceil(a*i));
        System.out.println(scientists);
    }
}
